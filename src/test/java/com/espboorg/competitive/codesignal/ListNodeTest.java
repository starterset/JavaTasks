package com.espboorg.competitive.codesignal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeTest {

    @Test
    void testSetAndGetNext() {
        //given
        ListNode<Integer> listNode = new ListNode<>(null);
        ListNode<Integer> newNode = new ListNode<>(null);
        //when
        listNode.setNext(newNode);
        //then
        assertEquals(newNode, listNode.getNext());
    }

    @Test
    void testSetAndGetValue() {
        //given
        ListNode<Integer> listNode = new ListNode<>(null);
        //then
        assertNull(listNode.getValue());

        //given
        listNode.setNext(new ListNode<>(3));
        //then
        assertEquals(3, listNode.getNext().getValue());

        //given
        listNode.setValue(9);
        //then
        assertEquals(9, listNode.getValue());
    }

    @Test
    void testAddAll() {
        //given
        ListNode<Integer> integerList = new ListNode<>(null);
        Integer[] input = {3, 1, 2, 3, 4, 5};
        //when
        integerList.addAll(input);
        //then
        String expected = "3, 1, 2, 3, 4, 5";
        assertEquals(expected, integerList.toString());
        ListNode<Integer> temp = integerList;
        for (int el : input) {
            assertEquals(temp.getValue(), el);
            temp = temp.getNext();
        }
    }

    @Test
    void testRemoveAllOccupancies() {
        //given
        ListNode<Integer> integerList = new ListNode<>(null);
        Integer[] input = {3, 1, 2, 3, 4, 5, 3};
        integerList.addAll(input);
        //when
        integerList.removeAllOccupancies(3);
        //then
        String expected = "1, 2, 4, 5";
        assertEquals(expected, integerList.toString());
        Integer[] res = {1, 2, 4, 5};
        ListNode<Integer> temp = integerList;
        for (int el : res) {
            assertEquals(temp.getValue(), el);
            temp = temp.getNext();
        }
    }
}
