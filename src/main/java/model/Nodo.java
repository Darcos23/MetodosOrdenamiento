package model;

public class Nodo {
    private double value;
    private String nnnnn;
    private Nodo next;
    private Nodo prev;
    public Nodo(double value, String nnnnn) {
        this.value = value;
        this.nnnnn = nnnnn;
        next = null;
        prev = null;
    }

    public double getValue() {return value;}

    public String getNnnnn() {return nnnnn;}

    public Nodo getNext() {return next;}

    public Nodo getPrev() {return prev;}

    public void setValue(double value) {this.value = value;}

    public void setNnnnn(String nnnnn) {this.nnnnn = nnnnn;}

    public void setNext(Nodo next) {this.next = next;}

    public void setPrev(Nodo prev) {this.prev = prev;}
}