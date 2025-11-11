package io;

import model.Pokemon;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.util.List;

public class PokemonXMl {

    public static void crearPokemonXML(List<Pokemon> lista, String ruta, int max) {
        try {
            XMLOutputFactory f = XMLOutputFactory.newFactory();
            XMLStreamWriter w = f.createXMLStreamWriter(new FileWriter(ruta));

            w.writeStartDocument("1.0");
            w.writeStartElement("pokemons");

            for (Pokemon p : lista) {
                w.writeStartElement("pokemon");
                w.writeAttribute("id", String.valueOf(p.getId()));

                w.writeStartElement("nome");
                w.writeCharacters(p.getNome());
                w.writeEndElement();

                w.writeStartElement("nacemento");
                w.writeCharacters(p.getNacemento() != null ? p.getNacemento().toString() : "");
                w.writeEndElement();

                w.writeStartElement("pokedexEntryId");
                w.writeCharacters(String.valueOf(p.getPokedexEntry().getId()));
                w.writeEndElement();

                w.writeStartElement("adestradorId");
                w.writeCharacters(String.valueOf(p.getAdestrador().getId()));
                w.writeEndElement();

                w.writeEndElement(); // </pokemon>

            }
            w.writeEndElement(); // </pokemons>
            w.writeEndDocument();
            w.flush();
            w.close();
            System.out.println("Archivo pokemons.xml creado en " + ruta);
        } catch (Exception e) {
            System.out.println("Error al generar XML de pokemons: " + e.getMessage());
        }
    }
}
