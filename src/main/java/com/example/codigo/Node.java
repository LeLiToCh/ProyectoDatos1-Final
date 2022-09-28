package com.example.codigo;

/**
 * Metodo Node para el control especifico de cada nodo dentro de la lista.
 * @authors Emmanuel Esquivel Chavarria & Andres Madrigal Vega
 */

public class Node {
    /**
     * Cabeza de la lista
     */
    public Node head;
    /**
     * Objeto con informacion
     */
    private Object data;
    /**
     * Atributo para setear nodo siguiente
     */
    public Node next;
    /**
     * Atributo para setear nodo previo
     */
    public Node previous;
    /**
     * Constructor de la informaion de next y data
     */
    public Node(Object data){
            this.next = null;
            this.data = data;
    }

    /**
     * Metodo para obtencion de la informacion
     * @return data.
     */
    public Object getData(){
            return this.data;
        }
    /**
     * Metodo para seteo de la nueva informacion
     * @return data.
     */
    public void setData (Object data){
            this.data = data;
        }
    /**
     * Metodo para conseguir el siguiente nodo
     * @return data.
     */
    public Node getNext(){
            return this.next;
        }
    /**
     * Metodo para seteo del siguiente nodo
     * @return data.
     */
    public void setNext(Node node){
            this.next = node;
        }
    /**
     * Metodo para conseguir el nodo previo
     * @return data.
     */
    public Node getPrevious(){
            return this.previous;
        }

}

