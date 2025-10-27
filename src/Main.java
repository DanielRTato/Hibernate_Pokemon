import model.Pokedex;
import services.PokedexServices;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        PokedexServices pokedexS = new PokedexServices();

        pokedexS.crearPokedex("Charmander", new BigDecimal(49) , "df");
        pokedexS.crearPokedex("Bulbasur", new BigDecimal(4119) , "sdfds");
        pokedexS.crearPokedex("Pikachu", new BigDecimal(419) , "sdfsdfsdf");
        pokedexS.crearPokedex("Charmander", new BigDecimal(149) , "sdf");
        pokedexS.crearPokedex("Charizard", new BigDecimal(3232) , "hj");
        pokedexS.crearPokedex("Mew", new BigDecimal(31) , "i");
        pokedexS.crearPokedex("Evee", new BigDecimal(123123) , "nmb");
        pokedexS.crearPokedex("MewTwo", new BigDecimal(332) , "asd");
        pokedexS.crearPokedex("Vulkarona", new BigDecimal(222) , "fgdg");
        pokedexS.crearPokedex("persian", new BigDecimal(1) , "fgh");




    }
}