package practica1;

import java.util.Comparator;

/**
 *
 * @author ellen
 */
public class LlistaCurs implements InterficieLista {

    // Nodo interno para la lista enlazada
    private class Node {

        Curso curso;
        Node next;

        Node(Curso curso) {
            this.curso = curso;
            this.next = null;
        }
    }

    private Node head; // Primer nodo de la lista

    public LlistaCurs() {
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
        if (head == null || head.next == null) {
            return; // Lista vacía o con un solo elemento
        }
        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current.next != null) {
                if (current.curso.getNombre().compareTo(current.next.curso.getNombre()) > 0) {
                    // Intercambiar cursos
                    Curso temp = current.curso;
                    current.curso = current.next.curso;
                    current.next.curso = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    public void EliminarElement(int index) {
        if (index < 0 || index >= longitud()) {
            return;
        }

        // Si el índice es 0 (primer nodo),movemos el head al siguiente nodo
        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            // Eliminar el nodo en el índice especificado
            if (current != null && current.next != null) {
                current.next = current.next.next; // Eliminar el nodo
            }
        }
    }

    @Override
    public String getElement(int a) {
        Curso curso = getCurs(a);
        return (curso != null) ? curso.toString() : null;
    }

    @Override
    public Curso getObject(int i) {
        return getCurs(i);
    }

    @Override
    public void addObject(Object o) {
        if (!(o instanceof Curso)) {
            System.out.println("El objeto no es una instancia de Curso.");
            return;
        }

        Node newNode = new Node((Curso) o);

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

    public void BuscarCodiAssignatura(String codi, String dni) {
        boolean encontrado = false;
        Node current = head;

        while (current != null) {
            Curso curso = current.curso;
            if (curso.ExisteAssignatura(codi)) {
                curso.AfegirAlumneAAssignatura(codi, dni);
                encontrado = true;
            }
            current = current.next;
        }

        if (!encontrado) {
            System.out.println("La asignatura con código " + codi + " no fue encontrada en ningún curso.");
        }
    }

    public Curso getCurs(int index) {
        Node current = head;
        for (int i = 0; i < index && current != null; i++) {
            current = current.next;
        }
        return (current != null) ? current.curso : null;
    }

    @Override
    public java.util.ArrayList<Curso> lista() {
        java.util.ArrayList<Curso> cursos = new java.util.ArrayList<>();
        Node current = head;
        while (current != null) {
            cursos.add(current.curso);
            current = current.next;
        }
        return cursos;
    }
}
