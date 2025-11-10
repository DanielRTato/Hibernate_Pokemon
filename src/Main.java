import static javax.xml.bind.DatatypeConverter.printDateTime;

import config.HibernateConfig;
import model.Adestrador;
import model.Pokedex;
import model.Pokemon;
import org.hibernate.Session;
import services.AdestradorServices;
import services.PokedexServices;
import services.PokemonService;
import util.AdestradorXML;
import util.PokedexXML;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //      -- PARTE 1 --

        List<Pokedex> listaPokedex = new ArrayList<>();
        PokedexServices pokedexServices = new PokedexServices();

        System.out.println("Insertar 10 Pokemons na Pokedex");
        Pokedex pSaling = pokedexServices.crearPokedex("Slaking", new BigDecimal(500.12), "Grande");
        Pokedex pButterfly = pokedexServices.crearPokedex("Butterfly", new BigDecimal(111), "Bicho");
        Pokedex pEvee = pokedexServices.crearPokedex("Evee", new BigDecimal(1), "Rata");
        Pokedex pEspeon = pokedexServices.crearPokedex("Espeon", new BigDecimal(111.12), "Rata Rara");
        Pokedex pGlaceon = pokedexServices.crearPokedex("Glaceon", new BigDecimal(12345.1), "Rata fria");
        Pokedex pVulpix = pokedexServices.crearPokedex("Vulpix", new BigDecimal(99), "Rata fuego");
        Pokedex pNinetales = pokedexServices.crearPokedex("Ninetales", new BigDecimal(0), "Perro fuego");
        Pokedex pArcanite = pokedexServices.crearPokedex("Arcanite", new BigDecimal(1), "Eh perro gordo fuego");
        Pokedex pBlaziken = pokedexServices.crearPokedex("Blaziken", new BigDecimal(2), "Pollo fuego");
        Pokedex pRapidash = pokedexServices.crearPokedex("Rapidash", new BigDecimal(12312312), "Caballo fuego");

        System.out.println("Listar pokedex");
        listaPokedex = pokedexServices.listarPokedex();
        for (Pokedex pokedex : listaPokedex) {
            System.out.println(pokedex);
        }

        System.out.println("Modificar 2 pokedex");
        pokedexServices.actualizarPokedex(1l, "Slaking", new BigDecimal(500.12), "Grande actualizado");
        pokedexServices.actualizarPokedex(2l, "Butefly ", new BigDecimal(5.02), "Bicho actualizado");

        System.out.println("Listar pokedex modificada");
        List<Pokedex> listaPokedexActualizada = pokedexServices.listarPokedex();
        listaPokedexActualizada.forEach(System.out::println);

//        System.out.println("Eliminando toda la pokedex");
//        for (Pokedex p : listaPokedexActualizada) {
//            pokedexServices.eliminarPokedex(p.getId());
//        }

        //                       <--------------- PARTE 2 ------------->
        AdestradorServices adestradorServices = new AdestradorServices();
        List<Adestrador> listaAdestrador = new ArrayList<>();

        System.out.println("Insertar 2 Adestradores");
        Adestrador aGary = adestradorServices.crearAdestrador("Gary", LocalDate.of(1996, 5, 16));
        Adestrador aAsh = adestradorServices.crearAdestrador("Ash", LocalDate.of(1996, 1, 12));

        System.out.println("Listar Adestradores");
        listaAdestrador = adestradorServices.listarAdestradores();
        listaAdestrador.forEach(System.out::println);

        System.out.println("Modificar 2 Adestradores");
        adestradorServices.actualizarAdestrador(1L, "GarryActualizado", LocalDate.of(1994, 1, 24));
        adestradorServices.actualizarAdestrador(2L, "AshActualizado", LocalDate.of(1995, 9, 16));

        System.out.println("Listar Adestradores modificados");
        List<Adestrador> listaAdestradorActualizada = adestradorServices.listarAdestradores();
        listaAdestradorActualizada.forEach(System.out::println);

        // toXML pokemons y adestradores
        AdestradorXML adestradorXML = new AdestradorXML();
        PokedexXML pokedexXML = new PokedexXML();

        System.out.println("Creando ficheros XML de Adestradores y Pokedex");
        adestradorXML.crearAdestradorXML(listaAdestradorActualizada, "adestradores.xml");
        pokedexXML.crearPokedexXML(listaPokedexActualizada, "pokedex.xml");

//        System.out.println("Eliminando todos los Adestradores");
//        for(Adestrador a : listaAdestradorActualizada) {
//            adestradorServices.eliminarAdestrador(a.getId());
//        }

        //                   <------- PARTE 3 -------->

        PokemonService pokemonService = new PokemonService();

        System.out.println("Insertar 12 Pokemons 6 para cada adestrador");
        pokemonService.crearPokemon("Slaking", LocalDate.of(2020, 1, 1), pSaling, aGary);
        pokemonService.crearPokemon("Butterfly", LocalDate.of(2019, 2, 2), pButterfly, aGary);
        pokemonService.crearPokemon("Evee", LocalDate.of(2018, 3, 3), pEvee, aGary);
        pokemonService.crearPokemon("Espeon", LocalDate.of(2017, 4, 4), pEspeon, aGary);
        pokemonService.crearPokemon("Glaceon", LocalDate.of(2016, 5, 5),pGlaceon, aGary);
        pokemonService.crearPokemon("Vulpix", LocalDate.of(2015, 6, 6), pVulpix, aGary);
        pokemonService.crearPokemon("Ninetales", LocalDate.of(2020, 7, 7), pNinetales, aAsh);
        pokemonService.crearPokemon("Arcanite", LocalDate.of(2019, 8, 8), pArcanite, aAsh);
        pokemonService.crearPokemon("Blaziken", LocalDate.of(2018, 9, 9), pBlaziken, aAsh);
        pokemonService.crearPokemon("Rapidash", LocalDate.of(2017, 10, 10), pRapidash, aAsh);
        pokemonService.crearPokemon("Evee", LocalDate.of(2016, 11, 11), pEvee, aAsh);
        pokemonService.crearPokemon("Glaceon", LocalDate.of(2015, 12, 12), pGlaceon, aAsh);

        System.out.println("Listar Pokemons de la tabla Pokemon");
        pokemonService.listarPokemons().forEach(System.out::println);

        System.out.println("Modificar 4 Pokemons");
        List<Pokemon> pokemons = pokemonService.listarPokemons();
        for (int i = 0; i<4; i++) {
            pokemonService.actualizaNombrePokemon(pokemons.get(i).getId(), pokemons.get(i).getNome() + "Actualido");
        }

        System.out.println("Mostrar Pokemons modificados");
        pokemonService.listarPokemons().forEach(System.out::println);


    }




}