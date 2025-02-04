
/**
 * Definition for singly-linked list.
 */
class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

}

/**
 * Solution class for merging two sorted linked lists Time Complexity: O(n + m)
 * where n and m are lengths of input lists Space Complexity: O(1) as we only
 * use constant extra space
 */
class Solution {

    /**
     * Merges two sorted linked lists into a single sorted linked list
     *
     * @param head1 The head of the first sorted linked list
     * @param head2 The head of the second sorted linked list
     * @return The head of the merged sorted linked list
     */
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {

        // Handle edge cases
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        // Create a dummy node to simplify the merging process
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Traverse both lists and merge them
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                current.next = head1;
                head1 = head1.next;
            } else {

                current.next = head2;
                head2 = head2.next;
            }

            current = current.next;
        }

        // Attach remaining nodes if any
        current.next = (head1 == null) ? head2 : head1;

        return dummy.next;
    }

    /**
     * Test cases for the mergeTwoLists method
     */
    public void testMergeTwoLists() {
        // Test Case 1: Regular merge
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        mergeTwoLists(list1, list2);
        // Expected: 1->2->3->4->5->6

        // Test Case 2: One empty list
        ListNode list3 = new ListNode(1);
        ListNode list4 = null;

        mergeTwoLists(list3, list4);
        // Expected: 1

        // Test Case 3: Both empty lists
        mergeTwoLists(null, null);
        // Expected: null

        // Test Case 4: Lists of different lengths
        ListNode list5 = new ListNode(1);
        list5.next = new ListNode(2);

        ListNode list6 = new ListNode(3);
        list6.next = new ListNode(4);
        list6.next.next = new ListNode(5);
        list6.next.next.next = new ListNode(6);

        mergeTwoLists(list5, list6);
        // Expected: 1->2->3->4->5->6
    }
}
