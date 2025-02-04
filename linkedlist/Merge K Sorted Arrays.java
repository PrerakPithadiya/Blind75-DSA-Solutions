
import java.util.*;

/**
 * Solution class for merging K sorted arrays into a single sorted array. Time
 * Complexity: O(N * log k) where N is total number of elements across all
 * arrays Space Complexity: O(k) for the priority queue + O(N) for the result
 * array
 */
class Solution {

    /**
     * Merges K sorted arrays into a single sorted array using a min-heap
     * approach.
     *
     * @param kArrays ArrayList of K sorted arrays that need to be merged
     * @param k Number of arrays to be merged
     * @return ArrayList containing all elements from input arrays in sorted
     * order
     * @throws IllegalArgumentException if kArrays is null or k is negative
     */
    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k) {
        // Input validation
        if (kArrays == null || k < 0) {
            throw new IllegalArgumentException("Invalid input: kArrays cannot be null and k cannot be negative");
        }

        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(n -> n.value));

        // Insert the first element of each array into the heap
        for (int i = 0; i < k; i++) {
            if (kArrays.get(i) != null && !kArrays.get(i).isEmpty()) {
                minHeap.offer(new Node(kArrays.get(i).get(0), i, 0));
            }
        }

        // Extract the smallest element from the heap and add it to the result
        while (!minHeap.isEmpty()) {
            Node smallest = minHeap.poll();
            result.add(smallest.value);

            // If there are more elements in the array from which the smallest element was taken, add the next element to the heap
            if (smallest.index + 1 < kArrays.get(smallest.arrayIndex).size()) {
                minHeap.offer(new Node(kArrays.get(smallest.arrayIndex).get(smallest.index + 1), smallest.arrayIndex, smallest.index + 1));
            }
        }

        return result;
    }

    /**
     * Helper class to store information about elements in the priority queue.
     * Each Node contains the value of the element, its array index, and its
     * position in the array.
     */
    static class Node {

        int value;      // The actual value of the element
        int arrayIndex; // Index of the array this element belongs to
        int index;      // Position of this element in its array

        /**
         * Constructs a new Node with the given parameters.
         *
         * @param value The value of the element
         * @param arrayIndex The index of the array this element belongs to
         * @param index The position of this element in its array
         */
        Node(int value, int arrayIndex, int index) {
            this.value = value;
            this.arrayIndex = arrayIndex;
            this.index = index;
        }
    }

    /**
     * Main method containing test cases for the mergeKSortedArrays function.
     */
    public static void main(String[] args) {
        // Test Case 1: Normal case with multiple arrays
        ArrayList<ArrayList<Integer>> test1 = new ArrayList<>();
        test1.add(new ArrayList<>(Arrays.asList(1, 4, 7)));
        test1.add(new ArrayList<>(Arrays.asList(2, 5, 8)));
        test1.add(new ArrayList<>(Arrays.asList(3, 6, 9)));
        ArrayList<Integer> result1 = mergeKSortedArrays(test1, 3);
        System.out.println("Test 1 Result: " + result1); // Expected: [1, 2, 3, 4, 5, 6, 7, 8, 9]

        // Test Case 2: Empty arrays
        ArrayList<ArrayList<Integer>> test2 = new ArrayList<>();
        test2.add(new ArrayList<>());
        test2.add(new ArrayList<>());
        ArrayList<Integer> result2 = mergeKSortedArrays(test2, 2);
        System.out.println("Test 2 Result: " + result2); // Expected: []

        // Test Case 3: Single array
        ArrayList<ArrayList<Integer>> test3 = new ArrayList<>();
        test3.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        ArrayList<Integer> result3 = mergeKSortedArrays(test3, 1);
        System.out.println("Test 3 Result: " + result3); // Expected: [1, 2, 3]

        // Test Case 4: Arrays with duplicate elements
        ArrayList<ArrayList<Integer>> test4 = new ArrayList<>();
        test4.add(new ArrayList<>(Arrays.asList(1, 1, 3)));
        test4.add(new ArrayList<>(Arrays.asList(1, 2, 2)));
        ArrayList<Integer> result4 = mergeKSortedArrays(test4, 2);
        System.out.println("Test 4 Result: " + result4); // Expected: [1, 1, 1, 2, 2, 3]
    }
}
