package practica1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Comparator;

public class ListaEstudiantes implements InterficieLista, Iterable<Estudiantes> {

    // Nodo interno para la lista enlazada
    private class Node {
        Estudiantes estudiante;
        Node next;

        Node(Estudiantes estudiante) {
            this.estudiante = estudiante;
            this.next = null;
        }
    }

    private Node head; // Primer nodo de la lista

    // Constructor
    public ListaEstudiantes() {
        this.head = null;
    }

    @Override
    public int longitud() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    @Override
    public void Order() {
        if (head == null || head.next == null) return; // Lista vacía o con un solo elemento

        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current.next != null) {
                if (current.estudiante.getDescripcion().compareTo(current.next.estudiante.getDescripcion()) > 0) {
                    // Intercambiar estudiantes
                    Estudiantes temp = current.estudiante;
                    current.estudiante = current.next.estudiante;
                    current.next.estudiante = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    @Override
    public ArrayList<Estudiantes> lista() {
        ArrayList<Estudiantes> estudiantes = new ArrayList<>();
        Node current = head;
        while (current != null) {
            estudiantes.add(current.estudiante);
            current = current.next;
        }
        return estudiantes;
    }

    @Override
    public String getElement(int a) {
        Estudiantes estudiante = getEstudiante(a);
        return (estudiante != null) ? estudiante.toString() : null;
    }

    @Override
    public Estudiantes getObject(int i) {
        return getEstudiante(i);
    }

    @Override
    public void addObject(Object alumnoNuevo) {
        Node newNode = new Node((Estudiantes) alumnoNuevo);

        if (head == null) { // Si la lista está vacía
            head = newNode;
        } else { // Añadir al final
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public boolean ExisteEstudiante(Estudiantes alumnoNuevo) {
        Node current = head;
        while (current != null) {
            if (current.estudiante.getDescripcion().equals(alumnoNuevo.getDescripcion()) &&
                current.estudiante.getIdentificador().equals(alumnoNuevo.getIdentificador())) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void AfegirAssignaturaAAlumne(String dni, String codi) {
        Node current = head;
        while (current != null) {
            if (current.estudiante.getIdentificador().equals(dni)) {
                current.estudiante.matricularAsignatura(codi);
                return;
            }
            current = current.next;
        }
        System.out.println("Estudiante con DNI " + dni + " no encontrado.");
    }

    public ArrayList<String> BuscarAlumnes(String codigoAsignatura) {
        ArrayList<String> estudiantesMatriculados = new ArrayList<>();
        Node current = head;
        while (current != null) {
            if (current.estudiante.EstaMatriculado(codigoAsignatura)) {
                estudiantesMatriculados.add(current.estudiante.getDescripcion());
            }
            current = current.next;
        }
        return estudiantesMatriculados;
    }

    public void EliminarAsignatura(String codi) {
        Node current = head;
        while (current != null) {
            if (current.estudiante.EstaMatriculado(codi)) {
                current.estudiante.desmatricularAsignatura(codi);
            }
            current = current.next;
        }
    }

    public Estudiantes getEstudiante(int i) {
        Node current = head;
        for (int index = 0; index < i && current != null; index++) {
            current = current.next;
        }
        return (current != null) ? current.estudiante : null;
    }

    @Override
    public Iterator<Estudiantes> iterator() {
        return new Iterator<Estudiantes>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Estudiantes next() {
                if (current == null) {
                    throw new java.util.NoSuchElementException();
                }
                Estudiantes estudiante = current.estudiante;
                current = current.next;
                return estudiante;
            }
        };
    }
}
