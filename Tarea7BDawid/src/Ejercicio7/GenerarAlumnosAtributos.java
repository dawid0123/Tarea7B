package Ejercicio7;

import org.w3c.dom.Element;

public class GenerarAlumnosAtributos extends GenerarXMLBase {
    @Override
    public void agregarAlumno(int nia, String nombre, String apellidos, char genero, String fechaNacimiento, String ciclo, String curso, String grupo) {
        Element alumno = doc.createElement("Alumno");

        alumno.setAttribute("NIA", String.valueOf(nia));
        alumno.setAttribute("Nombre", nombre);
        alumno.setAttribute("Apellidos", apellidos);
        alumno.setAttribute("Genero", String.valueOf(genero));
        alumno.setAttribute("FechaNacimiento", fechaNacimiento);
        alumno.setAttribute("Ciclo", ciclo);
        alumno.setAttribute("Curso", curso);
        alumno.setAttribute("Grupo", grupo);

        rootElement.appendChild(alumno);
    }

    public static void main(String[] args) {
        GenerarAlumnosAtributos generador = new GenerarAlumnosAtributos();
        generador.leerDatosYGenerarXML();
    }
}

