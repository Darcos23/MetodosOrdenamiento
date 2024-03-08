package model;

import model.Nodo;
public class ControllerList {
    private Nodo firstNode;
    public ControllerList() {
        firstNode = null;
    }

    // AÑADIR NODOS (LISTA SIMPLE):
    public void addNodos1(double value, String nnnnn) {

        Nodo newNodo = new Nodo(value, nnnnn);

        if (firstNode == null) {
            firstNode = newNodo;
        } else {
            Nodo current = firstNode;
            while(current.getNext() != null) {
                current = current.getNext();
            }

            current.setNext(newNodo);
        }
    }

    // IMPRESIÓN:
    public String toStringList() throws Exception {

        StringBuilder sb = new StringBuilder();
        Nodo current = firstNode;

        while (current != null) {
            sb.append(current.getValue());

            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        return sb.toString();
    }

    // SELECCIÓN:
    public void ordenamientoSeleccion() {
        if (firstNode != null && firstNode.getNext() != null) {

            Nodo target = firstNode;
            Nodo beforeTarget = null;

            while (target.getNext() != null) {
                Nodo before = target;
                Nodo lowest = target;
                beforeTarget = target;
                Nodo current = target.getNext();

                while (current != null) {
                    if (current.getValue() < lowest.getValue()) {
                        before = beforeTarget;
                        lowest = current;
                    }
                    beforeTarget = current;
                    current = current.getNext();
                }

                if (target != lowest) {
                    before.setNext(lowest.getNext());

                    lowest.setNext(target);
                    if (target == firstNode) {
                        firstNode = lowest;
                    } else {
                        Nodo temp = firstNode;
                        while (temp.getNext() != target) {
                            temp = temp.getNext();
                        }
                        temp.setNext(lowest);
                    }

                    target = lowest.getNext();
                } else {
                    target = target.getNext();
                }
            }
        }
    }
}