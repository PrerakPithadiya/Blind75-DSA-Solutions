
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/**
 * Solution class to detect cycles in a linked list using Floyd's Cycle-Finding Algorithm
 * (also known as "tortoise and hare" algorithm)
 *
 * Time Complexity: O(n) where n is the number of nodes in the linked list
 * Space Complexity: O(1) as only two pointers are used
 */
class Solution {

    /**
     * Determines if a linked list has a cycle
     *
     * @param head The head node of the linked list to check
     * @return true if the linked list has a cycle, false otherwise
     */
    public boolean hasCycle(ListNode head) {
        // Handle edge cases: empty list or single node
        if (head == null || head.next == null) {
            return false;
        }

        // Initialize two pointers: slow moves one step, fast moves two steps
        ListNode slow = head;
        ListNode fast = head.next;

        // Continue until fast catches up to slow (cycle exists)
        // or fast reaches end (no cycle)
        while (fast != slow) {
            slow = slow.next;
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * Test cases for the hasCycle method
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Empty list
        assert !solution.hasCycle(null) : "Empty list should return false";

        // Test Case 2: Single node without cycle
        ListNode single = new ListNode(1);
        assert !solution.hasCycle(single) : "Single node without cycle should return false";

        // Test Case 3: Two nodes without cycle
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        assert !solution.hasCycle(head1) : "List without cycle should return false";

        // Test Case 4: List with cycle
        ListNode head2 = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);
        head2.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second;  // Creates cycle
        assert solution.hasCycle(head2) : "List with cycle should return true";

        System.out.println("All test cases passed!");
    }
}
