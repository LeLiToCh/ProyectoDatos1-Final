package com.example.codigo;
/**
 * Clase Lista Doblemente Enlazada Circular que se encarga del movimiento de los nodos y sus interacciones
 * @authors Emmanuel Esquivel Chavarria & Andres Madrigal Vega
 */

import javax.swing.plaf.PanelUI;
import java.io.File;

public class DoubleLL<N> {
    /**
     * Nodo cabeza, pincipal nodo de la lista en cuestion.
     */
    public static Node head;
    /**
     * Nodo cola, ubicado al final de la lista.
     */
    Node tail = null;
    /**
     * Tamanno de la lista
     */
    public int size = 0;
    /**
     * Nodo current, para mayor facilidad de moverse dentro de la lista.
     */
    public static Node current = head;
    /**
     * Nodo next para obtener el valos que precede.
     */
    public Node next;
    //private canciones;

    /**
     * Instanciacion de lista doblemente enlazada
     */
    DoubleLL<N> songsList;

    /**
     * Metodo para setear el seguiente nodo.
     * @return Node
     */
    public static Node settNext(){
        current=current.next;


        return current;
    }

    /**
     * Metodo para annadir nodo a la lista
     * @param data archivo por annadir.
     */
    public void addNode(File data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = tail = newNode;
            head.previous = null;
            tail.next = null;
        }
        else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
            tail.next = null;
        }
        size++;
    }
    /**
     * Metodo para remover nodo a la lista
     * @param node nodo por remover.
     */
    public void remove(Node node) {
        if (node.previous == null) {
            head = node.next;
        } else if (node.next == null) {
            tail = node.previous;
        } else {
            node.previous.next = node.next;
            node.next.previous = node.previous;
        }
    }

    /**
     * Metodo para mostrar las lista en cuestion.
     */
    public void displayList(){

        Node current = this.head;
        while(current != null){
            System.out.println(current.getData());
            current = current.getNext();
        }
    }
    /**
     * Metodo para obtener info de la lista en cuestion.
     */
    public Object getData(){

        Node current = this.head;
        return current.getData();
    }
    /**
     * Metodo para obtener info que precede de la lista en cuestion.
     */
    public Object getNextData(){
        Node current = this.head;
        current = current.getNext();
        return current.getData();
    }
    /**
     * Metodo para setear la cabeza en el siguiente nodo.
     */
    public Object next(){
        Node current2=this.head.next;
        current2= current2.next;
        return current2;
    }

    /**
     * Metodo para reproduccion continua en lista doblemente enlazada.
     * @return retorno nulo.
     */
    public Object nextCPBtn(){
        if(this.next== null){
            this.next=head;
        }
        if(head.previous== null){
            this.next=tail;
        }
        return null;
    }

    /**
     * Metodo para eliminar todos los nodos de la lista doblemente enlazada cricular.
     */
    void deleteAllNodes() {
        Node temp = new Node(this.tail);
        while(this.head != null) {
            temp = this.head;
            this.head = this.head.next;
            temp = null;
        }

    }
}
