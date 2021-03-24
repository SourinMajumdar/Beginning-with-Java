// To take a singly linked list input from the user, then enter a new node at a specific position (index) in the list and display the modified list.

import java.util.Scanner;

class Node {
    int data;
    Node nextNode;}

class LinkedList {

    private Node head;

    public void insert(int data) {
        // create a new Node and store a data.
        Node node = new Node();
        node.data = data;
        node.nextNode = null;

        // check the head is null or not.
        // if head is null, assign the Node and exit.
        if (this.head == null) {
            head = node;
            return;}

        //assign a head into the temp Node and loop it until find the null 
          //reference.

        Node tempNode = this.head;
        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;}
        tempNode.nextNode = node;   //assign new node.
    }

    public void insertNth(int data, int position) {
        //create new node.
        Node node = new Node();
        node.data = data;
        node.nextNode = null;

        if (this.head == null) {
            // if head is null and position is zero then exit.
            if (position != 0) {
                return;} 
            else { //node set to the head.
                this.head = node;}
        }

        if (head != null && position == 0) {
            node.nextNode = this.head;
            this.head = node;
            return;}


        Node current = this.head;
        Node previous = null;

        int i = 0;

        while (i < position) {
            previous = current;
            current = current.nextNode;
            if (current == null) {
                break;}
            i++;}

        node.nextNode = current;
        previous.nextNode = node;
    }
    
    public void print() {
        if (this.head == null) {
            return;}
            
        //print all nodes
        Node tempNode = this.head;
        while (tempNode != null) {
            System.out.print(tempNode.data + " -> ");
            tempNode = tempNode.nextNode;
        }
        System.out.println("NULL");
    }
}
public class SinglyLinkedList {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes: ");
        int n = sc.nextInt();
        System.out.println("\nEnter nodes: ");
        LinkedList ls = new LinkedList();

        for(int i=0; i<n; i++){
            int x = sc.nextInt();
            ls.insert(x);}

        System.out.print("\nOriginal linked-list: ");
        ls.print();
        System.out.print("\nEnter index of new node: ");
        int pos = sc.nextInt();
        System.out.print("\nEnter new node: ");
        int newNode = sc.nextInt();

        ls.insertNth(newNode, pos);

        System.out.print("\nNew modified linked-list: ");
        ls.print();
        sc.close();
    }
}
