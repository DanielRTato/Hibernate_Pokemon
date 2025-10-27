package services;

import config.HibernateConfig;
import model.Pokedex;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.List;


public class PokedexServices {

    public void crearPokedex(String nome, BigDecimal peso, String misc) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Pokedex nuevaEntradaPokedex = new Pokedex();
            nuevaEntradaPokedex.setNome(nome);
            nuevaEntradaPokedex.setPeso(peso);
            nuevaEntradaPokedex.setMisc(misc);

            session.save(nuevaEntradaPokedex);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al crear una entrada en la Pokedex: " + e.getMessage());
        }
    }

    public Pokedex leerPokedex(Long id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(Pokedex.class, id);
        } catch (Exception e) {
            System.out.println("Error al leer la Pokedex: " + e.getMessage());
            return null;
        }
    }

    public List<Pokedex> listarPokedexConsulta() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Query<Pokedex> query = session.createQuery("FROM Pokedex", Pokedex.class);
            return query.list();
        } catch (Exception e) {
            System.out.println("Erro ao listar a Pokédex: " + e.getMessage());
            return null;
        }
    }

    public void actualizarPokedex(Pokedex pokedex) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(pokedex);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al actualizar la Pokdex: " + e.getMessage());
        }
    }

    public void eliminarConsulta() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("DELETE FROM Pokedex");
            query.executeUpdate();
            transaction.commit();
            System.out.println("Todas as entradas da Pokédex foron eliminadas.");
        } catch (Exception e) {
            System.out.println("Erro ao eliminar todas as entradas: " + e.getMessage());
        }
    }



    public void eliminarEntradaPokedex(Long id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Pokedex pokedex = session.get(Pokedex.class, id);
            if (pokedex != null) {
                session.delete(pokedex);
            } else {
                System.out.println("No se pudo borrar la entrada de la Pokedex");
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al eliminar la enrtada de la Pokedex: " +e.getMessage());
        }
    }


}
