package com.espboorg.competitive.hackerrank;

public class SinglyLinkedList {
    static void main() {
        ListNode<Integer> integerList = new ListNode<>(null);
        Integer[] input = {3, 1, 2, 3, 4, 5};
        integerList.addAll(input);
        System.out.println(integerList);
        integerList.removeAllOccupancies(3);
        System.out.println(integerList);

        ListNode<Integer> integerList2 = new ListNode<>(null);
        Integer[] input2 = {1, 2, 3, 4, 5, 6, 7, 6, 6, 6};
        integerList2.addAll(input2);
        System.out.println(integerList2);
        integerList2.removeAllOccupancies(6);
        System.out.println(integerList2);
    }
}

class ListNode<T> {
    ListNode(T x) {
        value = x;
    }

    private T value;
    private ListNode<T> next;

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    private void setHead(ListNode<T> newHead) {
        this.value = newHead.value;
        this.next = newHead.next;
    }

    public void addAll(T[] arr) {
        ListNode<T> newHead = new ListNode<>(null);
        newHead.next = this;
        ListNode<T> listNode = newHead;
        for (T el : arr) {
            listNode.setNext(new ListNode<>(el));
            listNode = listNode.next;
        }
        setHead(newHead.next);
    }

    public void removeAllOccupancies(T elementToRemove) {
        ListNode<T> newHead = new ListNode<>(null);
        newHead.next = this;
        ListNode<T> current = this;
        ListNode<T> previous = newHead;
        while (current != null) {
            if (current.value == elementToRemove) {
                previous.next = current.next;
            } else {
                previous = current;
            }
            current = current.next;
        }
        setHead(newHead.next);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        ListNode<T> temp = this;
        while (temp != null) {
            output.append(temp.value).append(", ");
            temp = temp.next;
        }
        output.setLength(output.length() - 2);
        return output.toString();
    }
}
