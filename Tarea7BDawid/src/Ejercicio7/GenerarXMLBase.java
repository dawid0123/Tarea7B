package Ejercicio7;


import java.io.File;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public abstract class GenerarXMLBase {
    protected Document doc;
    protected Element rootElement;

    public GenerarXMLBase() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.newDocument();
            rootElement = doc.createElement("Alumnos");
            doc.appendChild(rootElement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para agregar un alumno al documento XML
    public abstract void agregarAlumno(int nia, String nombre, String apellidos, char genero, String fechaNacimiento, String ciclo, String curso, String grupo);

    // Lee los datos del usuario y llama a agregarAlumno para añadirlos al documento
    public void leerDatosYGenerarXML() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 5; i++) {
            System.out.println("Alumno " + i + ":");

            System.out.print("NIA (entero): ");
            int nia = Integer.parseInt(scanner.nextLine());

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Apellidos: ");
            String apellidos = scanner.nextLine();

            System.out.print("Género (M/F): ");
            char genero = scanner.nextLine().charAt(0);

            System.out.print("Fecha de Nacimiento (yyyy-mm-dd): ");
            String fechaNacimiento = scanner.nextLine();

            System.out.print("Ciclo: ");
            String ciclo = scanner.nextLine();

            System.out.print("Curso: ");
            String curso = scanner.nextLine();

            System.out.print("Grupo: ");
            String grupo = scanner.nextLine();

            // Llamada a la implementación específica de agregarAlumno
            agregarAlumno(nia, nombre, apellidos, genero, fechaNacimiento, ciclo, curso, grupo);
        }

        guardarArchivoXML("alumnos.xml");
    }

    // Guarda el documento en un archivo XML
    protected void guardarArchivoXML(String nombreArchivo) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(nombreArchivo));
            transformer.transform(source, result);
            System.out.println("Archivo XML generado exitosamente: " + nombreArchivo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

