package com.espboorg.competitive.hackerrank._16_01_22;

/*
    Single linked list
    ------------------------------
    Head->[1]->[2]->[3]->[4]->Null
    ------------------------------
    print: 4 3 2 1
*/

public class SinglyLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, null))));
        printReverse(head);
    }

    public static void printReverse(Node next) {
        if (next == null) {
            return;
        }
        printReverse(next.next);
        System.out.println(next.val);
    }
}

class Node {
    int val;
    Node next;

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}