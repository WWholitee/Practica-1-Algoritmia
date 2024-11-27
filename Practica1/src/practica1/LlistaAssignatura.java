package practica1;

import java.util.ArrayList;
import java.util.Comparator;

public class LlistaAssignatura implements InterficieLista {

    @Override
    public ArrayList lista() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Nodo interno para la lista enlazada
    private class Node {

        Assignatura assignatura;
        Node next;

        Node(Assignatura assignatura) {
            this.assignatura = assignatura;
            this.next = null;
        }
    }

    private Node head; // Primer nodo de la lista

    public LlistaAssignatura() {
        this.head = null;
    }

    @Override
    public int longitud() {
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    @Override
    public void addObject(Object a) {
        Node newNode = new Node((Assignatura) a);

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

    public void EliminarElement(int index) {
        if (head == null || index < 0) {
            return; // Lista vacía o índice no válido
        }
        if (index == 0) { // Eliminar el primer nodo
            head = head.next;
            return;
        }

        Node current = head;
        for (int i = 0; current != null && i < index - 1; i++) {
            current = current.next;
        }

        if (current != null && current.next != null) {
            current.next = current.next.next;
        }
    }

    @Override
    public Assignatura getObject(int index) {
        Node current = head;
        for (int i = 0; i < index && current != null; i++) {
            current = current.next;
        }
        return (current != null) ? current.assignatura : null;
    }

    @Override
    public String getElement(int index) {
        Assignatura assignatura = getObject(index);
        return (assignatura != null) ? assignatura.toString() : null;
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
                if (current.assignatura.getIdentificador().compareTo(current.next.assignatura.getIdentificador()) > 0) {
                    // Intercambiar asignaturas
                    Assignatura temp = current.assignatura;
                    current.assignatura = current.next.assignatura;
                    current.next.assignatura = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped); // Continuar mientras haya intercambios
    }

    public void OrdenarLlista(Comparator<Assignatura> comparator) {
        if (head == null || head.next == null) {
            return; // Lista vacía o con un solo elemento
        }
        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current.next != null) {
                if (comparator.compare(current.assignatura, current.next.assignatura) > 0) {

                    Assignatura temp = current.assignatura;
                    current.assignatura = current.next.assignatura;
                    current.next.assignatura = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped); // Continuar mientras haya intercambios
    }
}
