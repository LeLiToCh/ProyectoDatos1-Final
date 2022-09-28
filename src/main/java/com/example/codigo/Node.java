package com.example.codigo;


public class Node {
    public Node head;
    private Object data;
        public Node next;
        public Node previous;
        public Node(Object data){
            this.next = null;
            this.data = data;
        }
        public Object getData(){
            return this.data;
        }
        public void setData (Object data){
            this.data = data;
        }
        public Node getNext(){
            return this.next;
        }
        public void setNext(Node node){
            this.next = node;
        }
        public Node getPrevious(){
            return this.previous;
        }

}

