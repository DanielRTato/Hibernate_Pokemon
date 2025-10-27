package services;

import config.HibernateConfig;
import model.Pokedex;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class PokedexServices {

    public void crearPokedex(String nome, double peso, String misc) {
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

    public void actualizarPokedex(Pokedex pokedex) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(pokedex);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al actualizar la Pokdex: " + e.getMessage());
        }
    }

    public void eliminarEntradaPokedex(Long id) {

    }
}
