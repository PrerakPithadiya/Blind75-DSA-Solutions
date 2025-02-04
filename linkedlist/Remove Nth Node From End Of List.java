
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
 * Solution class to remove the nth node from the end of a linked list
 * Time Complexity: O(n) where n is the length of the linked list
 * Space Complexity: O(1) as we only use constant extra space
 */
class Solution {

    /**
     * Removes the nth node from the end of the linked list
     *
     * @param head The head node of the linked list
     * @param n The position from the end to remove (1-based indexing)
     * @return The head of the modified linked list
     * @throws IllegalArgumentException if n is greater than the size of the
     * list or n <= 0
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (n <= 0) {
            throw new IllegalArgumentException("n must be positive");
        }

        int size = size(head);
        if (n > size) {
            throw new IllegalArgumentException("n cannot be greater than list size");
        }

        if (n == size) {
            head = head.next;
            return head;
        }

        int opr = size - n - 1;
        ListNode currentNode = head;
        for (int k = 0; k < opr; k++) {
            currentNode = currentNode.next;
        }
        currentNode.next = currentNode.next.next;
        return head;
    }

    /**
     * Calculates the size of the linked list
     *
     * @param head The head node of the linked list
     * @return The number of nodes in the linked list
     */
    private int size(ListNode head) {
        int size = 0;
        ListNode currentNode = head;
        while (currentNode != null) {
            size++;
            currentNode = currentNode.next;
        }
        return size;
    }

    /**
     * Test cases
     */
    public void test() {
        // Test Case 1: Remove 2nd node from end in list 1->2->3->4->5
        ListNode test1 = new ListNode(1);
        test1.next = new ListNode(2);
        test1.next.next = new ListNode(3);
        test1.next.next.next = new ListNode(4);
        test1.next.next.next.next = new ListNode(5);
        ListNode result1 = removeNthFromEnd(test1, 2);
        assert toString(result1).equals("1->2->3->5");

        // Test Case 2: Remove head node (1st from end in list 1)
        ListNode test2 = new ListNode(1);
        ListNode result2 = removeNthFromEnd(test2, 1);
        assert result2 == null;

        // Test Case 3: Remove 1st node from end in list 1->2
        ListNode test3 = new ListNode(1);
        test3.next = new ListNode(2);
        ListNode result3 = removeNthFromEnd(test3, 1);
        assert toString(result3).equals("1");

        // Test Case 4: Empty list
        ListNode result4 = removeNthFromEnd(null, 1);
        assert result4 == null;
    }

    /**
     * Helper method to convert LinkedList to string for testing
     *
     * @param head The head node of the linked list
     * @return String representation of the linked list
     */
    private String toString(ListNode head) {
        if (head == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        ListNode current = head;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append("->");
            }
            current = current.next;
        }
        return sb.toString();
    }
}
