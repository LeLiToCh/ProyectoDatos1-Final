package com.example.codigo;

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
        //Create a new node
        Node newNode = new Node(data);
        //If list is empty
        if(head == null) {
            //Both head and tail will point to newNode
            head = tail = newNode;
            //head's previous will point to null
            head.previous = null;
            //tail's next will point to null, as it is the last node of the list
            tail.next = null;
        }
        else {
            //newNode will be added after tail such that tail's next will point to newNode
            tail.next = newNode;
            //newNode's previous will point to tail
            newNode.previous = tail;
            //newNode will become new tail
            tail = newNode;
            //As it is last node, tail's next will point to null
            tail.next = null;
        }
        //Size will count the number of nodes present in the list
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


    public Object getNext() {
        return this.next;
    }
}
