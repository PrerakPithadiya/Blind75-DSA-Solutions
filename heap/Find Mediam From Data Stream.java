
import java.util.PriorityQueue;

/**
 * MedianFinder class implements a data structure that efficiently finds the
 * median from a data stream. It uses two heaps to maintain the numbers: a
 * max-heap for the lower half and a min-heap for the upper half. Time
 * Complexity: O(log n) for addNum, O(1) for findMedian Space Complexity: O(n)
 * where n is the number of elements
 */
class MedianFinder {

    // Max-heap to store the smaller half of the numbers
    private final PriorityQueue<Integer> lowerHalf;
    // Min-heap to store the larger half of the numbers
    private final PriorityQueue<Integer> upperHalf;

    /**
     * Initializes the MedianFinder data structure. Creates two priority queues
     * with appropriate comparators.
     */
    public MedianFinder() {
        // Max-heap: store negative values to simulate max-heap behavior in Java
        lowerHalf = new PriorityQueue<>((a, b) -> b - a);
        // Min-heap: default behavior
        upperHalf = new PriorityQueue<>();
    }

    /**
     * Adds a number to the data structure. Maintains balance between the two
     * heaps to ensure efficient median finding.
     *
     * @param num The number to be added to the data structure
     */
    public void addNum(int num) {
        if (lowerHalf.isEmpty() || num <= lowerHalf.peek()) {
            lowerHalf.offer(num);
        } else {
            upperHalf.offer(num);
        }

        // Balance the heaps: lowerHalf should not have more than one extra element compared to upperHalf
        if (lowerHalf.size() > upperHalf.size() + 1) {
            upperHalf.offer(lowerHalf.poll());
        } else if (upperHalf.size() > lowerHalf.size()) {
            lowerHalf.offer(upperHalf.poll());
        }
    }

    /**
     * Finds the median of all numbers added so far.
     *
     * @return The median as a double value
     */
    public double findMedian() {
        if (lowerHalf.size() > upperHalf.size()) {
            return lowerHalf.peek();
        } else {
            return (lowerHalf.peek() + upperHalf.peek()) / 2.0;
        }
    }

    /**
     * Test cases demonstrating the usage of MedianFinder
     */
    public static void main(String[] args) {
        // Test Case 1: Basic functionality
        MedianFinder finder1 = new MedianFinder();
        finder1.addNum(1);
        assert finder1.findMedian() == 1.0 : "Test Case 1.1 failed";
        finder1.addNum(2);
        assert finder1.findMedian() == 1.5 : "Test Case 1.2 failed";
        finder1.addNum(3);
        assert finder1.findMedian() == 2.0 : "Test Case 1.3 failed";

        // Test Case 2: Adding numbers in non-sorted order
        MedianFinder finder2 = new MedianFinder();
        finder2.addNum(5);
        finder2.addNum(2);
        finder2.addNum(1);
        assert finder2.findMedian() == 2.0 : "Test Case 2 failed";

        // Test Case 3: Even number of elements
        MedianFinder finder3 = new MedianFinder();
        finder3.addNum(1);
        finder3.addNum(2);
        finder3.addNum(3);
        finder3.addNum(4);
        assert finder3.findMedian() == 2.5 : "Test Case 3 failed";

        // Test Case 4: Duplicate elements
        MedianFinder finder4 = new MedianFinder();
        finder4.addNum(1);
        finder4.addNum(1);
        finder4.addNum(1);
        assert finder4.findMedian() == 1.0 : "Test Case 4 failed";

        System.out.println("All test cases passed successfully!");
    }
}
