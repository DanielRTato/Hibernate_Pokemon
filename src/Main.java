import static javax.xml.bind.DatatypeConverter.printDateTime;
import config.HibernateConfig;
import model.Pokedex;
import org.hibernate.Session;
import services.PokedexServices;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //      -- PARTE 1 --

        List<Pokedex> listaPokedex = new ArrayList<>();
        PokedexServices pokedexServices = new PokedexServices();

        // Insertar 10 pokemon el la tabla pokedex
//        pokedexServices.crearPokedex("Slaking", new BigDecimal(500.12), "Grande");
//        pokedexServices.crearPokedex("Butterfly", new BigDecimal(111), "Bicho");
//        pokedexServices.crearPokedex("Evee", new BigDecimal(1), "Rata");
//        pokedexServices.crearPokedex("Espeon", new BigDecimal(111.12), "Rata Rara");
//        pokedexServices.crearPokedex("Glaceon", new BigDecimal(12345.1), "Rata fria");
//        pokedexServices.crearPokedex("Vulpix", new BigDecimal(99), "Rata fuego");
//        pokedexServices.crearPokedex("Ninetales", new BigDecimal(0), "Perro fuego");
//        pokedexServices.crearPokedex("Arcanite", new BigDecimal(1), "Eh perro gordo fuego");
//        pokedexServices.crearPokedex("Blaziken", new BigDecimal(2), "Pollo fuego");
//        pokedexServices.crearPokedex("Rapidash", new BigDecimal(12312312), "Caballo fuego");

        // Listar Pokemons da pokedex
//       listaPokedex = pokedexServices.listarPokedex();
//        for (Pokedex pokedex : listaPokedex){
//            System.out.println(pokedex);
//        }

        // Modificar 2 entradas na pokedex
//        pokedexServices.actualizarPokedex(1l, "Slaking",new BigDecimal(500.12), "Grande actualizado");
//        pokedexServices.actualizarPokedex(2l, "Butefly ",new BigDecimal(5.02), "Bicho actualizado");

        // Listar pokemons na pokedex actualizada
//        List<Pokedex> listaPokedexActualizada = pokedexServices.listarPokedex();
//        listaPokedexActualizada.forEach(System.out::println);
//
//        for (Pokedex p : listaPokedexActualizada) {
//            pokedexServices.eliminarPokedex(p.getId());
//        }

        //      -- PARTE 2 --




    }
}
