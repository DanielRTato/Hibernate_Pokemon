package services;

import config.HibernateConfig;
import model.Pokedex;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.management.Query;
import java.math.BigDecimal;
import java.util.List;

public class PokedexServices {

    //          ------- USANDO Session.get, save, update, delete --------

    public Pokedex crearPokedex(String nome, BigDecimal peso, String misc) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Pokedex nuevaPokedex = new Pokedex();
            nuevaPokedex.setNome(nome);
            nuevaPokedex.setPeso(peso);
            nuevaPokedex.setMisc(misc);

            session.save(nuevaPokedex); // insert
            transaction.commit();
            System.out.println("Registro de Pokedex creada correctamente");

            return nuevaPokedex;

        } catch (Exception e) {
            System.out.println("Error al crear la Pokedex: " + e.getMessage());
            return null;
        }
    }

    public Pokedex leerPokedex(Long id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(Pokedex.class, id); // Como select por id
        } catch (Exception e) {
            System.out.println("Error al leer la Pokedex: " + e.getMessage());
            return null;
        }
    }

    /**
     * Actualiza la pokedex pasando los parámetros individualmente
     *
     * @param id
     * @param nome
     * @param peso
     * @param misc
     */
    public void actualizarPokedex(Long id, String nome, BigDecimal peso, String misc) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Pokedex pokedex = session.get(Pokedex.class, id);
            if (pokedex != null) {
                pokedex.setNome(nome);
                pokedex.setPeso(peso);
                pokedex.setMisc(misc);

                session.update(pokedex); // update
            } else {
                System.out.println("No se encontro la Pokedex");
            }
            transaction.commit();
            System.out.println("Se actualizó el registro de la Pokedex");

        } catch (Exception e) {
            System.out.println("Error al intentar actualizar la Pokedex: " + e.getMessage());
        }
    }

    /**
     * Actualiza la entrada de la Pokedex pasandole un objeto entero
     *
     * @param pokedex
     */
    public void actualizarPokedex(Pokedex pokedex) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.update(pokedex); // update
            transaction.commit();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarPokedex(Long id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Pokedex pokedex = session.get(Pokedex.class, id);
            if (pokedex != null) {
                session.delete(pokedex); // delete
            } else {
                System.out.println("No se encontro la Pokedex para eliminarla");
            }
            transaction.commit();
            System.out.println("Registro de la Pokedex eliminado correctamente");
        } catch (Exception e) {
            System.out.println("Error al eliminar de la Pokedex: " + e.getMessage());
        }
    }

    //         -- USANDO sessio.createQuery --

    public List<Pokedex> listarPokedex() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from Pokedex", Pokedex.class).list();

        } catch (Exception e) {
            System.out.println("Error al listar Pokedex por Query: " + e.getMessage());
            return null;
        }
    }

    public void eliminarPokedexPorId(Long id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            List<Pokedex> pokedexList = session.createQuery("from Pokedex where id = :id", Pokedex.class)
                    .setParameter("id", id)
                    .getResultList();

            if (!pokedexList.isEmpty()) {
                Pokedex pokedex = pokedexList.get(0);
                session.delete(pokedex);
                System.out.println("eliminado correctamente.");
            } else {
                System.out.println("Non se atopou o powkedex co id " + id);
            }

            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }

    public void eliminarTodaPokedex() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.createQuery("delete from Pokedex").executeUpdate();
            transaction.commit();
        }
    }

    public Pokedex buscarPorId(Long id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(Pokedex.class, id);
        }
    }

}
