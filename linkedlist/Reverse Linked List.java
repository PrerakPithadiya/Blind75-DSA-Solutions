
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Solution class for reversing a singly linked list
 * Time Complexity: O(n) where n is the number of nodes in the list
 * Space Complexity: O(1) as we only use three pointers
 */
class Solution {

    /**
     * Reverses a singly linked list iteratively
     *
     * @param head The head node of the linked list to be reversed
     * @return The new head node of the reversed linked list
     */
    public ListNode reverseList(ListNode head) {
        // Edge case: empty list or single node
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;    // Previous node pointer
        ListNode curr = head;    // Current node pointer
        ListNode next;    // Next node pointer

        while (curr != null) {
            next = curr.next;    // Store next node
            curr.next = prev;    // Reverse the link
            prev = curr;         // Move prev one step forward
            curr = next;         // Move curr one step forward
        }

        return prev;    // New head of reversed list
    }

    /**
     * Test cases for the reverseList method
     */
    public void testReverseList() {
        // Test Case 1: Normal case [1->2->3->4->5]
        ListNode test1 = new ListNode(1);
        test1.next = new ListNode(2);
        test1.next.next = new ListNode(3);
        test1.next.next.next = new ListNode(4);
        test1.next.next.next.next = new ListNode(5);
        ListNode reversedTest1 = reverseList(test1);
        assert checkReverse(reversedTest1, new int[]{5, 4, 3, 2, 1});

        // Test Case 2: Single node [1]
        ListNode test2 = new ListNode(1);
        ListNode reversedTest2 = reverseList(test2);
        assert checkReverse(reversedTest2, new int[]{1});

        // Test Case 3: Empty list []
        if (reverseList(null) != null) {
            throw new AssertionError("Test Case 3 failed: Expected null for empty list");
        }

        // Test Case 4: Two nodes [1->2]
        ListNode test4 = new ListNode(1);
        test4.next = new ListNode(2);
        ListNode reversedTest4 = reverseList(test4);
        assert checkReverse(reversedTest4, new int[]{2, 1});
    }

    /**
     * Helper method to verify if a linked list matches expected values
     *
     * @param head The head of the linked list to check
     * @param expected Array of expected values in order
     * @return true if the linked list matches the expected values, false
     * otherwise
     */
    private boolean checkReverse(ListNode head, int[] expected) {
        ListNode curr = head;
        for (int val : expected) {
            if (curr == null || curr.val != val) {
                return false;
            }
            curr = curr.next;
        }
        return curr == null;
    }
}
