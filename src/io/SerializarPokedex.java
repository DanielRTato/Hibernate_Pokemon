package io;

import model.Pokedex;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class SerializarPokedex {

    public static void serializarPokedex(List<Pokedex> lista, String ruta) {

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))){
            oos.writeObject(lista.get(0));
            oos.writeObject(lista.get(1));
            System.out.println("Serialización de 2 Pokedex terminada:  " + ruta );
        } catch (Exception e){
            System.out.println("Error durante la serialización: " + e.getMessage());
        }
    }

    public static Pokedex[] deserializarPokedex(String ruta) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
            Pokedex p1 = (Pokedex) ois.readObject();
            Pokedex p2 = (Pokedex) ois.readObject();
            System.out.println("Deserializadas 2 Pokedex: " + ruta);
            return new Pokedex[]{p1, p2};
        } catch (Exception e) {
            System.out.println("Error deserializando: " + e.getMessage());
            return new Pokedex[0];
        }
    }
}