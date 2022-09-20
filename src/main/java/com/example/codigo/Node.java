package com.example.codigo;


public class Node {
    public Node head;
    private Object data;//Información que va dentro del nodo
        public Node next;//Siguiente nodo
        public Node previous;


        //Constructor de objeto Node
        public Node(Object data){
            this.next = null;
            this.data = data;
        }

        //Getter de información dentro del objeto nodo
        public Object getData(){
            return this.data;
        }
        //Setter de información dentro del objeto nodo
        public void setData (Object data){
            this.data = data;
        }

        //Getter del nodo siguiente
        //public boolean temp2 =false;
        public Node getNext(){

                return this.next;
        }


        //Setter del nodo siguiente
        public void setNext(Node node){
            this.next = node;
        }
        public Node getPrevious(){
            return this.previous;
        }

}

