package com.espboorg.competitive.codesignal.complexalgo;

import java.util.HashSet;
import java.util.Set;

public class SinglyLinkedListAlgorithms {

    // ==========================================
    // Linked List Operations in Java
    // ==========================================

    /// Determine whether the linked list is a palindrome or not.
    /// A linked list is a palindrome if it reads the same forward and backward.
    ///
    /// @param head the first `Node` in the singly linked list
    /// @return `true` if the linked list is a palindrome and `false` otherwise
    /// @implNote Time Complexity: `O(n)`, Space Complexity: `O(1)`
    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalfHead = reverseLinkedList(slow);

        ListNode start = head;
        ListNode end = secondHalfHead;

        boolean result = true;

        while (end != null) {
            if (start.val != end.val) {
                result = false;
                break;
            }
            start = start.next;
            end = end.next;
        }

        // Restore the original order of the list
        reverseLinkedList(end);

        return result;
    }

    private static ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    /// Swaps the nodes of the linked list at these two provided indices
    ///
    /// @param head  the first `Node` in the singly linked list
    /// @param start index of the start node
    /// @param end   index of the end node
    /// @return the head node of the modified linked list
    /// @implNote Time Complexity: `O(n)`, Space Complexity: `O(1)`
    public static ListNode swapLinkedListNodes(ListNode head, int start, int end) {
        if (head == null || head.next == null || start >= end) {
            return head;
        }

        ListNode startPrev = null, startNode = null, endPrev = null, endNode = null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int index = -1;
        ListNode current = dummy;

        while (current != null && index <= end) {
            if (index + 1 == start) {
                startPrev = current;
                startNode = current.next;
            }
            if (index + 1 == end) {
                endPrev = current;
                endNode = current.next;
            }
            current = current.next;
            index++;
        }

        // Return original head if either index is out of bounds
        if (startNode == null || endNode == null) {
            return head;
        }

        startPrev.next = endNode;
        endPrev.next = startNode;

        ListNode temp = startNode.next;
        startNode.next = endNode.next;
        endNode.next = temp;

        return dummy.next;
    }

    /// Remove all duplicate nodes from an unsorted linked list and return the head of the updated linked list.
    /// The order of the remaining nodes in the list should be the same as in the original.
    ///
    /// @param head the first `Node` in the singly linked list
    /// @return the head of the updated linked list
    /// @implNote Time Complexity: `O(n)`
    public static ListNode removeDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode current = new ListNode(0);
        current.next = head;

        while (current.next != null) {
            if (set.contains(current.next.val)) {
                current.next = current.next.next;
            } else {
                set.add(current.next.val);
                current = current.next;
            }
        }
        return head;
    }

    /// Rotates the linked list to the right by k places.
    /// Note that k might be 0 or greater than the length of the linked list.
    /// Take the last k nodes from the end of the list and move them to the start of the list,
    /// maintaining their original order.
    ///
    /// @param head the first `Node` in the singly linked list
    /// @param k    integer
    /// @return the head of the resulting linked list
    /// @implNote Time Complexity: `O(n)`
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int size = 0;
        ListNode current = head;
        while (current != null) {
            size++;
            current = current.next;
        }

        // k can be grater then the size of Linked List, so take the remainder
        if (size < k) {
            k = k % size;
        }

        // If remainder k equals 0 or size, no rotation is performed
        if (k == 0 || k == size) {
            return head;
        }

        ListNode newHead = null;
        int index = 0;
        current = head;
        while (current != null) {
            ListNode next = current.next;
            if (index + 1 == size - k) {
                newHead = current.next;
                current.next = null; // Dereference to make it new end of the list
            }
            if (index + 1 == size) {
                current.next = head;
            }
            current = next;
            index++;
        }

        head = newHead;
        return head;
    }

    /// Detect if a cycle exists in the linked list.
    /// A linked list is said to contain a cycle
    /// if a node's next pointer points back to one of the previous nodes in the list.
    ///
    /// @param head the first `Node` in the singly linked list
    /// @return `true` if the linked list contains a cycle; `false` otherwise
    /// @implNote Space Complexity: `O(1)`
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            if (fast.next == head || fast.next.next == head) {
                return true;
            }
            if (fast.next == slow) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
