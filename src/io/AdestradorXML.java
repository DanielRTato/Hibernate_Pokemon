package io;

import model.Adestrador;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.util.List;

public class AdestradorXML {

    public static void crearAdestradorXML(List<Adestrador> lista, String ruta) {
        try {
            XMLOutputFactory factory = XMLOutputFactory.newFactory();
            XMLStreamWriter writer = factory.createXMLStreamWriter(new FileWriter(ruta));

            writer.writeStartDocument("1.0");
            writer.writeStartElement("adestradores");

            for (Adestrador a : lista) {
                writer.writeStartElement("adestrador");
                writer.writeAttribute("id", String.valueOf(a.getId()));

                writer.writeStartElement("nome");
                writer.writeCharacters(a.getNome());
                writer.writeEndElement();

                writer.writeStartElement("nacemento");
                writer.writeCharacters(a.getNacemento() != null ? a.getNacemento().toString() : "");
                writer.writeEndElement();

                writer.writeEndElement(); // </adestrador>
            }

            writer.writeEndElement(); // </adestradores>
            writer.writeEndDocument();
            writer.flush();
            writer.close();

            System.out.println("Archivo adestradores.xml creado correctamente en " + ruta);
        } catch (Exception e) {
            System.out.println("Error al generar XML: " + e.getMessage());
        }
    }
}

