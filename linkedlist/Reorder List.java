
/**
 * Definition for singly-linked list.
 * This class represents a node in a singly-linked list data structure.
 */
class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

}

/**
 * Solution class containing the reorderList algorithm Problem: Given a singly
 * linked list L: L0→L1→…→Ln-1→Ln, reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 */
class Solution {

    /**
     * Reorders the given linked list according to the pattern: First element ->
     * Last element -> Second element -> Second last element and so on
     *
     * Algorithm steps: 1. Find the middle of the linked list using slow/fast
     * pointer technique 2. Reverse the second half of the linked list 3. Merge
     * the first half and reversed second half alternately
     *
     * Time Complexity: O(n) where n is the number of nodes Space Complexity:
     * O(1) as only constant extra space is used
     *
     * @param head The head node of the linked list to be reordered
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find middle of the linked list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half
        ListNode prev = null, curr = slow, temp;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // Step 3: Merge first and second half
        ListNode first = head, second = prev;
        while (second != null && second.next != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
    }

    /**
     * Test cases to verify the reorderList implementation
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Normal case
        // Input: 1->2->3->4
        // Expected: 1->4->2->3
        ListNode test1 = new ListNode(1);
        test1.next = new ListNode(2);
        test1.next.next = new ListNode(3);
        test1.next.next.next = new ListNode(4);
        solution.reorderList(test1);
        printList("Test Case 1", test1);

        // Test Case 2: Odd length list
        // Input: 1->2->3->4->5
        // Expected: 1->5->2->4->3
        ListNode test2 = new ListNode(1);
        test2.next = new ListNode(2);
        test2.next.next = new ListNode(3);
        test2.next.next.next = new ListNode(4);
        test2.next.next.next.next = new ListNode(5);
        solution.reorderList(test2);
        printList("Test Case 2", test2);

        // Test Case 3: Single node
        // Input: 1
        // Expected: 1
        ListNode test3 = new ListNode(1);
        solution.reorderList(test3);
        printList("Test Case 3", test3);

        // Test Case 4: Empty list
        // Input: null
        // Expected: null
        solution.reorderList(null);
        printList("Test Case 4", null);
    }

    /**
     * Helper method to print the linked list
     *
     * @param testName Name of the test case
     * @param head Head of the linked list to print
     */
    private static void printList(String testName, ListNode head) {
        System.out.print(testName + ": ");
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
