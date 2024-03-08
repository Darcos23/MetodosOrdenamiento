package model;

import model.Nodo;
public class ControllerList {
    private Nodo firstNode;
    public ControllerList() {
        firstNode = null;
    }

    // AÑADIR NODOS (LISTA SIMPLE):
    public void addNodos(double value, String name) {

        Nodo newNodo = new Nodo(value, name);

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

    // INSERCIÓN:
    public void ordenamientoInsercion() {
        if (firstNode != null && firstNode.getNext() != null) {
            Nodo current = firstNode.getNext();
            Nodo prev, temp;
            while (current != null) {
                prev = firstNode;
                temp = null;
                while (prev != current && prev.getValue() <= current.getValue()) {
                    temp = prev;
                    prev = prev.getNext();
                }
                if (prev != current) {
                    if (temp != null) {
                        temp.setNext(current);
                    }
                    Nodo next = current.getNext();
                    current.setNext(prev);
                    while (prev.getNext() != current) {
                        prev = prev.getNext();
                    }
                    prev.setNext(next);
                    if (temp == null) {
                        firstNode = current;
                    }
                }
                current = current.getNext();
            }
        }
    }

    //BURBUJA
    public void ordenamientoBurbuja() {
        if (firstNode != null && firstNode.getNext() != null) {
            boolean swapped = true;
            Nodo temp;
            Nodo endNode = null;

            while (swapped) {
                swapped = false;
                Nodo current = firstNode;
                Nodo prev = null;

                while (current.getNext() != endNode) {
                    if (current.getValue() > current.getNext().getValue()) {
                        if (prev == null) {
                            temp = firstNode;
                            firstNode = firstNode.getNext();
                            temp.setNext(firstNode.getNext());
                            firstNode.setNext(temp);
                            prev = firstNode;
                        } else {
                            temp = current.getNext();
                            current.setNext(temp.getNext());
                            temp.setNext(current);
                            prev.setNext(temp);
                            prev = temp;
                        }
                        swapped = true;
                    } else {
                        prev = current;
                        current = current.getNext();
                    }
                }
                endNode = current;
            }
        }
    }

}