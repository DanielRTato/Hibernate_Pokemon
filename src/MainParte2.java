//import static javax.xml.bind.DatatypeConverter.printDateTime;
//
//import config.HibernateConfig;
//import model.Adestrador;
//import model.Pokedex;
//import model.Pokemon;
//import org.hibernate.Session;
//import services.AdestradorServices;
//import services.PokedexServices;
//import services.PokemonService;
//import util.AdestradorXML;
//import util.PokedexXML;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//public class MainParte2 {
//    public static void main(String[] args) {
//
//        //      -- PARTE 1 --
//
//        List<Pokedex> listaPokedex = new ArrayList<>();
//        PokedexServices pokedexServices = new PokedexServices();
//
//        System.out.println("Insertar 10 Pokemons na Pokedex");
////        pokedexServices.crearPokedex("Slaking", new BigDecimal(500.12), "Grande");
////        pokedexServices.crearPokedex("Butterfly", new BigDecimal(111), "Bicho");
////        pokedexServices.crearPokedex("Evee", new BigDecimal(1), "Rata");
////        pokedexServices.crearPokedex("Espeon", new BigDecimal(111.12), "Rata Rara");
////        pokedexServices.crearPokedex("Glaceon", new BigDecimal(12345.1), "Rata fria");
////        pokedexServices.crearPokedex("Vulpix", new BigDecimal(99), "Rata fuego");
////        pokedexServices.crearPokedex("Ninetales", new BigDecimal(0), "Perro fuego");
////        pokedexServices.crearPokedex("Arcanite", new BigDecimal(1), "Eh perro gordo fuego");
////        pokedexServices.crearPokedex("Blaziken", new BigDecimal(2), "Pollo fuego");
////        pokedexServices.crearPokedex("Rapidash", new BigDecimal(12312312), "Caballo fuego");
//
//        System.out.println("Listar pokedex");
//        listaPokedex = pokedexServices.listarPokedex();
//        for (Pokedex pokedex : listaPokedex) {
//            System.out.println(pokedex);
//        }
//
//        System.out.println("Modificar 2 pokedex");
//        pokedexServices.actualizarPokedex(1l, "Slaking", new BigDecimal(500.12), "Grande actualizado");
//        pokedexServices.actualizarPokedex(2l, "Butefly ", new BigDecimal(5.02), "Bicho actualizado");
//
//        System.out.println("Listar pokedex modificada");
//        List<Pokedex> listaPokedexActualizada = pokedexServices.listarPokedex();
//        listaPokedexActualizada.forEach(System.out::println);
//
////        System.out.println("Eliminando toda la pokedex");
////        for (Pokedex p : listaPokedexActualizada) {
////            pokedexServices.eliminarPokedex(p.getId());
////        }
//
//        //                       <--------------- PARTE 2 ------------->
//        AdestradorServices adestradorServices = new AdestradorServices();
//        List<Adestrador> listaAdestrador = new ArrayList<>();
//
//        System.out.println("Insertar 2 Adestradores");
////      adestradorServices.crearAdestrador("Gary", LocalDate.of(1996, 5, 16));
////       adestradorServices.crearAdestrador("Ash", LocalDate.of(1996, 1, 12));
//
//        System.out.println("Listar Adestradores");
//        listaAdestrador = adestradorServices.listarAdestradores();
//        listaAdestrador.forEach(System.out::println);
//
//        System.out.println("Modificar 2 Adestradores");
//        adestradorServices.actualizarAdestrador(1L, "GarryActualizado", LocalDate.of(1994, 1, 24));
//        adestradorServices.actualizarAdestrador(2L, "AshActualizado", LocalDate.of(1995, 9, 16));
//
//        System.out.println("Listar Adestradores modificados");
//        List<Adestrador> listaAdestradorActualizada = adestradorServices.listarAdestradores();
//        listaAdestradorActualizada.forEach(System.out::println);
//
//        // toXML pokemons y adestradores
//        AdestradorXML adestradorXML = new AdestradorXML();
//        PokedexXML pokedexXML = new PokedexXML();
//
//        System.out.println("Creando ficheros XML de Adestradores y Pokedex");
//        adestradorXML.crearAdestradorXML(listaAdestradorActualizada, "adestradores.xml");
//        pokedexXML.crearPokedexXML(listaPokedexActualizada, "pokedex.xml");
//
////        System.out.println("Eliminando todos los Adestradores");
////        for(Adestrador a : listaAdestradorActualizada) {
////            adestradorServices.eliminarAdestrador(a.getId());
////        }
//
//        //                   <------- PARTE 3 -------->
//
//        PokemonService pokemonService = new PokemonService();
//
//        // Inserir 12 pokemons na taboa de pokemon (6 para cada adestrador)
//        Adestrador Gary = adestradorServices.buscarPorId(1L);
//        Adestrador Ash = adestradorServices.buscarPorId(2L);
//
//        Pokedex Slaking = pokedexServices.buscarPorId(1L);
//        Pokedex Butterfly = pokedexServices.buscarPorId(2L);
//        Pokedex Evee = pokedexServices.buscarPorId(3L);
//        Pokedex Espeon = pokedexServices.buscarPorId(4L);
//        Pokedex Glaceon = pokedexServices.buscarPorId(5L);
//        Pokedex Vulpix = pokedexServices.buscarPorId(6L);
//        Pokedex Ninetales = pokedexServices.buscarPorId(7L);
//        Pokedex Arcanite = pokedexServices.buscarPorId(8L);
//        Pokedex Blaziken = pokedexServices.buscarPorId(9L);
//        Pokedex Rapidash = pokedexServices.buscarPorId(10L);
//
//
////            pokemonService.crearPokemon("Slaking", LocalDate.of(2020, 1, 5), Slaking, Gary);
////            pokemonService.crearPokemon("Butterfly", LocalDate.of(2020, 1, 5), Butterfly, Gary);
////            pokemonService.crearPokemon("Evee", LocalDate.of(2020, 1, 5), Evee, Gary);
////            pokemonService.crearPokemon("Espeon", LocalDate.of(2020, 1, 5), Espeon, Gary);
////            pokemonService.crearPokemon("Glaceon", LocalDate.of(2020, 1, 5), Glaceon, Gary);
////            pokemonService.crearPokemon("Vulpix", LocalDate.of(2020, 1, 5), Vulpix, Gary);
////            pokemonService.crearPokemon("Ninetales", LocalDate.of(2020, 1, 5), Ninetales, Ash);
////            pokemonService.crearPokemon("Arcanite", LocalDate.of(2020, 1, 5), Arcanite, Ash);
////            pokemonService.crearPokemon("Blaziken", LocalDate.of(2020, 1, 5), Blaziken, Ash);
////            pokemonService.crearPokemon("Rapidash", LocalDate.of(2020, 1, 5), Rapidash, Ash);
////            pokemonService.crearPokemon("Evee", LocalDate.of(2020, 1, 5), Evee, Ash);
////            pokemonService.crearPokemon("Espeon", LocalDate.of(2020, 1, 5), Espeon, Ash);
//
//        List<Pokemon> listaPokemon = pokemonService.listarPokemons();
//
//        listaPokemon.forEach(System.out::println);
//
//
//    }
//}