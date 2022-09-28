package com.example.codigo;

import javax.swing.plaf.PanelUI;
import java.io.File;

public class DoubleLL<N> {
    public static Node head;
    Node tail = null;
    public int size = 0;
    public static Node current = head;

    public Node next;
    //private canciones;



    DoubleLL<N> songsList;

    public static Node settNext(){
        current=current.next;


        return current;
    }



    //DoubleLL canciones= LogInController.usedFiles();

    //add a node to the list
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
    public void setNext(Node node) {

        this.tail.next = node;
    }
    //print all the nodes of doubly linked list
    public void displayList(){

        Node current = this.head;
        while(current != null){
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    public Object getData(){

        Node current = this.head;
        return current.getData();
    }
    public Object getNextData(){
        Node current = this.head;
        current = current.getNext();
        return current.getData();
    }

    public Object next(){
        Node current2=this.head.next;
        current2= current2.next;
        return current2;
    }
    public Object nextCPBtn(){
        if(this.next== null){
            this.next=head;
        }
        if(head.previous== null){
            this.next=tail;
        }
        return null;
    }
    public Object getNext() {
        return this.next;
    }
    void deleteAllNodes() {
        Node temp = new Node(this.tail);
        while(this.head != null) {
            temp = this.head;
            this.head = this.head.next;
            temp = null;
        }

    }
}
