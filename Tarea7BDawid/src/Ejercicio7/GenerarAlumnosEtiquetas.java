package Ejercicio7;

import org.w3c.dom.Element;

public class GenerarAlumnosEtiquetas extends GenerarXMLBase {
    @Override
    public void agregarAlumno(int nia, String nombre, String apellidos, char genero, String fechaNacimiento, String ciclo, String curso, String grupo) {
        Element alumno = doc.createElement("Alumno");
        rootElement.appendChild(alumno);

        Element niaElement = doc.createElement("NIA");
        niaElement.appendChild(doc.createTextNode(String.valueOf(nia)));
        alumno.appendChild(niaElement);

        Element nombreElement = doc.createElement("Nombre");
        nombreElement.appendChild(doc.createTextNode(nombre));
        alumno.appendChild(nombreElement);

        Element apellidosElement = doc.createElement("Apellidos");
        apellidosElement.appendChild(doc.createTextNode(apellidos));
        alumno.appendChild(apellidosElement);

        Element generoElement = doc.createElement("Genero");
        generoElement.appendChild(doc.createTextNode(String.valueOf(genero)));
        alumno.appendChild(generoElement);

        Element fechaElement = doc.createElement("FechaNacimiento");
        fechaElement.appendChild(doc.createTextNode(fechaNacimiento));
        alumno.appendChild(fechaElement);

        Element cicloElement = doc.createElement("Ciclo");
        cicloElement.appendChild(doc.createTextNode(ciclo));
        alumno.appendChild(cicloElement);

        Element cursoElement = doc.createElement("Curso");
        cursoElement.appendChild(doc.createTextNode(curso));
        alumno.appendChild(cursoElement);

        Element grupoElement = doc.createElement("Grupo");
        grupoElement.appendChild(doc.createTextNode(grupo));
        alumno.appendChild(grupoElement);
    }

    public static void main(String[] args) {
        GenerarAlumnosEtiquetas generador = new GenerarAlumnosEtiquetas();
        generador.leerDatosYGenerarXML();
    }
}

