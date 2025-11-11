package io;

import model.Pokedex;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.util.List;

public class PokedexXML {

    public static void crearPokedexXML(List<Pokedex> lista, String ruta) {
        try {
            XMLOutputFactory factory = XMLOutputFactory.newFactory();
            XMLStreamWriter writer = factory.createXMLStreamWriter(new FileWriter(ruta));

            writer.writeStartDocument("1.0");
            writer.writeStartElement("pokedex");

            for (Pokedex p : lista) {
                writer.writeStartElement("pokemon");
                writer.writeAttribute("id", String.valueOf(p.getId()));

                writer.writeStartElement("nome");
                writer.writeCharacters(p.getNome());
                writer.writeEndElement();

                writer.writeStartElement("peso");
                writer.writeCharacters(String.valueOf(p.getPeso()));
                writer.writeEndElement();

                writer.writeStartElement("misc");
                writer.writeCharacters(p.getMisc() != null ? p.getMisc() : "");
                writer.writeEndElement();

                writer.writeEndElement(); // </pokemon>
            }

            writer.writeEndElement(); // </pokedex>
            writer.writeEndDocument();
            writer.flush();
            writer.close();

            System.out.println("Archivo pokedex.xml creado correctamente en " + ruta);
        } catch (Exception e) {
            System.out.println("Error al generar XML: " + e.getMessage());
        }
    }
}
