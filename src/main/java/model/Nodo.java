package model;

public class Nodo {
    private double value;
    private String name;
    private Nodo next;

    public Nodo(double value, String name) {
        this.value = value;
        this.name = name;
        next = null;
    }

    public double getValue() {return value;}

    public String getName() {return name;}

    public Nodo getNext() {return next;}

    public void setValue(double value) {this.value = value;}

    public void setName(String name) {this.name = name;}

    public void setNext(Nodo next) {this.next = next;}
}