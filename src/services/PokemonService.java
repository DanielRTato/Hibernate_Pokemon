package services;

import config.HibernateConfig;
import model.Adestrador;
import model.Pokedex;
import model.Pokemon;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.List;

public class PokemonService {

    // Con objetos

    public Pokemon crearPokemon(String nome, LocalDate nacemento, Pokedex pokedexEntry, Adestrador adestrador) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Pokemon pokemon = new Pokemon();
            pokemon.setNome(nome);
            pokemon.setNacemento(nacemento);
            pokemon.setPokedexEntry(pokedexEntry);
            pokemon.setAdestrador(adestrador);

            session.save(pokemon); // insert
            transaction.commit();
            System.out.println("Registro de Pokemon creado correctamente.");
            return pokemon;
        } catch (Exception e) {
            System.out.println("Error al crear el Pokemon: " + e.getMessage());
            return null;
        }
    }

    public void actualizarPokemon (Long id, String nome, LocalDate nacemento, Pokedex pokedexEntry, Adestrador adestrador) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Pokemon pokemon = session.get(Pokemon.class, id);
            if (pokemon != null) {
                pokemon.setNome(nome);
                pokemon.setNacemento(nacemento);
                pokemon.setPokedexEntry(pokedexEntry);
                pokemon.setAdestrador(adestrador);

                session.update(pokemon);
            } else {
                System.out.println("No se encontró el Pokemon");
            }
            transaction.commit();
            System.out.println("Se actualizó el Pokemon correctamente");
        } catch (Exception e) {
            System.out.println("Error al actualizar el Pokemon: " + e.getMessage());
        }
    }


    public void actualizarPokemon(Pokemon pokemon) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.update(pokemon);
            transaction.commit();
            System.out.println("Se actualizó el Pokemon correctamente");
        } catch (Exception e ) {
            System.out.println("Error al actualizar el Pokemon: " + e.getMessage());
        }
    }


    // consultas
    public List<Pokemon> listarPokemons() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from Pokemon", Pokemon.class).list();

        } catch (Exception e) {
            System.out.println("Error al listar los Pokemons: " + e.getMessage());
            return null;
        }
    }

    public void actualizaNombrePokemon(Long id, String novoNome){
        try(Session s = HibernateConfig.getSessionFactory().openSession()){
            Transaction tx = s.beginTransaction();
            s.createQuery("update Pokemon set nome=:n where id=:id")
                    .setParameter("n", novoNome).setParameter("id", id).executeUpdate();
            tx.commit();
        }
    }

    public void elimarTodosPokemons() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.createQuery("delete from Pokemon").executeUpdate();
            transaction.commit();
        }
    }

}
