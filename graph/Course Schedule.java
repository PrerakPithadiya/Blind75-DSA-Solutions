package graph;

import java.util.*;

/**
 * Course Schedule - Determines if it's possible to finish all courses given
 * prerequisites
 *
 * Problem: Given numCourses courses (labeled from 0 to numCourses-1) and
 * prerequisites where prerequisites[i] = [ai, bi] indicates that you must take
 * course bi first if you want to take course ai, determine if it's possible to
 * finish all courses.
 *
 * Solution approach: 1. Uses topological sort with Kahn's algorithm 2. Builds a
 * directed graph from prerequisites 3. Tracks in-degree of each node (course)
 * 4. Processes courses with 0 in-degree first 5. Returns true if all courses
 * can be completed (no cycles)
 *
 * Time Complexity: O(V + E) where V is number of courses and E is number of
 * prerequisites Space Complexity: O(V + E) for storing the graph and queue
 */
class Solution {

    /**
     * Determines if it's possible to finish all courses given the prerequisites
     *
     * @param numCourses number of courses to take
     * @param prerequisites array of prerequisite pairs where [a,b] means b must
     * be taken before a
     * @return true if all courses can be finished, false if there's a cycle
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Build the graph and calculate in-degrees
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            graph.get(prerequisiteCourse).add(course);  // prerequisite -> course
            inDegree[course]++;  // Increment in-degree of the course
        }

        // Step 2: Use a queue to process nodes with in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Step 3: Process the courses in topological order
        int count = 0;  // Track the number of courses processed
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            count++;

            // Reduce the in-degree of neighboring courses
            for (int neighbor : graph.get(currentCourse)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If we were able to process all courses, return true
        return count == numCourses;
    }

    /**
     * Test cases for the canFinish method
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Simple case with 2 courses
        int[][] prerequisites1 = {{1, 0}};
        assert solution.canFinish(2, prerequisites1) == true;
        System.out.println("Test Case 1 Passed");

        // Test Case 2: Cycle detection
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        assert solution.canFinish(2, prerequisites2) == false;
        System.out.println("Test Case 2 Passed");

        // Test Case 3: Multiple prerequisites
        int[][] prerequisites3 = {{1, 0}, {2, 1}, {3, 2}};
        assert solution.canFinish(4, prerequisites3) == true;
        System.out.println("Test Case 3 Passed");

        // Test Case 4: No prerequisites
        int[][] prerequisites4 = {};
        assert solution.canFinish(1, prerequisites4) == true;
        System.out.println("Test Case 4 Passed");

        // Test Case 5: Complex case with multiple dependencies
        int[][] prerequisites5 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        assert solution.canFinish(4, prerequisites5) == true;
        System.out.println("Test Case 5 Passed");

        System.out.println("All test cases passed!");
    }
}
