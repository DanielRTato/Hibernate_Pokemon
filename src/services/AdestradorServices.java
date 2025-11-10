package services;

import config.HibernateConfig;
import model.Adestrador;
import model.Pokedex;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class AdestradorServices {

    public void crearAdestrador (String nome, LocalDate nacemento) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Adestrador adestrador = new Adestrador();
            adestrador.setNome(nome);
            adestrador.setNacemento(nacemento);

            session.save(adestrador); // insert
            transaction.commit();

            System.out.println("Registro de Adestrador realizado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al crear al Adestrador: " + e.getMessage());
        }
    }

    public void actualizarAdestrador(Long id, String nome, LocalDate nacemento) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Adestrador adestrador = session.get(Adestrador.class, id);
            if (adestrador != null){
                adestrador.setNome(nome);
                adestrador.setNacemento(nacemento);

                session.update(adestrador);
            }
            else {
                System.out.println("No se encontró al Adestrador");
            }
            transaction.commit();
            System.out.println("Se actualizo al Adestrador correctamente");
        } catch (Exception e) {
            System.out.println("Error al actualizar el Adestrador: " + e.getMessage());
        }
    }

    public Adestrador leerAdestrador(Long id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(Adestrador.class, id); // select por id
        } catch (Exception e) {
            System.out.println("Error al leer la Adestrador: " + e.getMessage());
            return null;
        }
    }

    public void eliminarAdestrador(Long id) {
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Adestrador adestrador = session.get(Adestrador.class, id);
            if (adestrador != null){
                session.delete(adestrador);
            } else {
                System.out.println("No se econtro al Adestrador para borrarlo");
            }
            transaction.commit();
            System.out.println("Adestrador eliminado");
        } catch (Exception e) {
            System.out.println("Error al eliminar al Adestrador: " + e.getMessage());
        }
    }

    public void eliminarTodosAdestradores() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.createQuery("delete from Adestrador").executeUpdate();
            transaction.commit();
        }
    }

    public List<Adestrador> listarAdestradores() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from Adestrador", Adestrador.class).list();
        }
    }

    public Adestrador buscarPorId(Long id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(Adestrador.class, id);
        }
    }

}
