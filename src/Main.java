import model.Pokedex;
import services.PokedexServices;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        PokedexServices pokedexS = new PokedexServices();

        Pokedex p1 = new Pokedex("Charmander", new BigDecimal(49) , "df");
        Pokedex p2 = new Pokedex("Bulbasur", new BigDecimal(4119) , "sdfds");
        Pokedex p3 = new Pokedex("Pikachu", new BigDecimal(419) , "sdfsdfsdf");
        Pokedex p4 = new Pokedex("Charmander", new BigDecimal(149) , "sdf");
        Pokedex p5 = new Pokedex("Charizard", new BigDecimal(3232) , "hj");
        Pokedex p6 = new Pokedex("Mew", new BigDecimal(31) , "i");
        Pokedex p7 = new Pokedex("Evee", new BigDecimal(123123) , "nmb");
        Pokedex p8 = new Pokedex("MewTwo", new BigDecimal(332) , "asd");
        Pokedex p9 = new Pokedex("Vulkarona", new BigDecimal(222) , "fgdg");
        Pokedex p10 = new Pokedex("persian", new BigDecimal(1) , "fgh");

        pokedexS.listarPokedexConsulta();


    }
}