package com.espboorg.competitive.codesignal.complexalgo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListAlgorithmsTest {

    @Test
    void testIsPalindrome_1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        assertTrue(SinglyLinkedListAlgorithms.isPalindrome(head));
    }

    @Test
    void testIsPalindrome_2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        assertFalse(SinglyLinkedListAlgorithms.isPalindrome(head));
    }

    @Test
    void testIsPalindrome_3() {
        ListNode head = new ListNode(10);
        head.next = new ListNode(11);

        assertFalse(SinglyLinkedListAlgorithms.isPalindrome(head));
    }

    @Test
    public void testSwapLinkedListNodes_1() {
        ListNode head = createLinkedListFromArray(new int[]{1, 2, 3, 4, 5});
        int[] result = extractLinkedListValues(SinglyLinkedListAlgorithms.swapLinkedListNodes(head, 0, 4));
        assertEquals(Arrays.toString(new int[]{5, 2, 3, 4, 1}), Arrays.toString(result));
    }

    @Test
    public void testSwapLinkedListNodes_2() {
        ListNode head = createLinkedListFromArray(new int[]{1, 2, 3, 4, 5});
        int[] result = extractLinkedListValues(SinglyLinkedListAlgorithms.swapLinkedListNodes(head, 1, 3));
        assertEquals(Arrays.toString(new int[]{1, 4, 3, 2, 5}), Arrays.toString(result));
    }

    @Test
    public void testSwapLinkedListNodes_3() {
        ListNode head = createLinkedListFromArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        int[] result = extractLinkedListValues(SinglyLinkedListAlgorithms.swapLinkedListNodes(head, 0, 8));
        assertEquals(Arrays.toString(new int[]{9, 2, 3, 4, 5, 6, 7, 8, 1}), Arrays.toString(result));
    }

    @Test
    public void testSwapLinkedListNodes_4() {
        ListNode head = createLinkedListFromArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        int[] result = extractLinkedListValues(SinglyLinkedListAlgorithms.swapLinkedListNodes(head, 4, 5));
        assertEquals(Arrays.toString(new int[]{1, 2, 3, 4, 6, 5, 7, 8, 9}), Arrays.toString(result));
    }

    @Test
    public void testRemoveDuplicates() {
        ListNode head = createLinkedListFromArray(new int[]{1, 3, 2, 3, 2, 3, 4, 5, 5, 5});
        int[] result = extractLinkedListValues(SinglyLinkedListAlgorithms.removeDuplicates(head));
        assertEquals(Arrays.toString(new int[]{1, 3, 2, 4, 5}), Arrays.toString(result));
    }

    @Test
    public void testRotateRight_1() {
        ListNode head = createLinkedListFromArray(new int[]{1, 2, 3, 4, 5});
        int[] result = extractLinkedListValues(SinglyLinkedListAlgorithms.rotateRight(head, 4));
        assertEquals(Arrays.toString(new int[]{2, 3, 4, 5, 1}), Arrays.toString(result));
    }

    @Test
    public void testRotateRight_2() {
        ListNode head = createLinkedListFromArray(new int[]{1, 2, 3, 4, 5});
        int[] result = extractLinkedListValues(SinglyLinkedListAlgorithms.rotateRight(head, 5));
        assertEquals(Arrays.toString(new int[]{1, 2, 3, 4, 5}), Arrays.toString(result));
    }

    @Test
    public void testRotateRight_3() {
        ListNode head = createLinkedListFromArray(new int[]{1, 2, 3, 4, 5});
        int[] result = extractLinkedListValues(SinglyLinkedListAlgorithms.rotateRight(head, 6));
        assertEquals(Arrays.toString(new int[]{5, 1, 2, 3, 4}), Arrays.toString(result));
    }

    @Test
    public void testRotateRight_4() {
        ListNode head = createLinkedListFromArray(new int[]{1, 2});
        int[] result = extractLinkedListValues(SinglyLinkedListAlgorithms.rotateRight(head, 1002));
        assertEquals(Arrays.toString(new int[]{1, 2}), Arrays.toString(result));
    }

    @Test
    public void testHasCycle_1() {
        ListNode head1 = new ListNode(1);
        assertFalse(SinglyLinkedListAlgorithms.hasCycle(head1));
    }

    @Test
    public void testHasCycle_2() {
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        assertFalse(SinglyLinkedListAlgorithms.hasCycle(head2));
    }

    @Test
    public void testHasCycle_3() {
        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        head3.next.next = new ListNode(3);
        head3.next.next.next = head3;
        assertTrue(SinglyLinkedListAlgorithms.hasCycle(head3));
    }

    @Test
    public void testHasCycle_4() {
        ListNode head4 = new ListNode(1);
        head4.next = new ListNode(2);
        head4.next.next = new ListNode(2);
        head4.next.next.next = new ListNode(1);
        assertFalse(SinglyLinkedListAlgorithms.hasCycle(head4));
    }

    @Test
    public void testHasCycle_5() {
        ListNode head5 = new ListNode(1);
        head5.next = new ListNode(2);
        head5.next.next = new ListNode(3);
        head5.next.next.next = new ListNode(4);
        head5.next.next.next.next = new ListNode(5);
        head5.next.next.next.next.next = head5.next.next;
        assertTrue(SinglyLinkedListAlgorithms.hasCycle(head5));
    }

    private ListNode createLinkedListFromArray(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    private int[] extractLinkedListValues(ListNode head) {
        int[] values = new int[100]; // Assume maximum list length for simplicity
        int index = 0;
        while (head != null) {
            values[index++] = head.val;
            head = head.next;
        }
        int[] result = new int[index];
        System.arraycopy(values, 0, result, 0, index);
        return result;
    }
}