
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Solution class for validating strings containing parentheses, brackets, and
 * braces. This class provides functionality to check if a string of brackets is
 * valid.
 *
 * Valid strings must: 1. Have matching pairs of brackets 2. Have correct
 * ordering of opening and closing brackets 3. Each closing bracket must match
 * the most recently opened unmatched bracket
 */
class ValidParentheses {

    /**
     * Determines if a string of brackets is valid.
     *
     * @param s the input string containing brackets to validate
     * @return true if the string is valid, false otherwise
     *
     * Time Complexity: O(n) where n is the length of the string Space
     * Complexity: O(n) for the stack storage
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        // Map of matching pairs for quick lookup
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                // If current char is a closing bracket
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                if (topElement != map.get(c)) {
                    return false;
                }
            } else {
                // If current char is an opening bracket
                stack.push(c);
            }
        }

        // Return true if stack is empty, false otherwise
        return stack.isEmpty();
    }

    /**
     * Main method containing test cases to verify the functionality.
     */
    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();

        // Test cases
        String[] testCases = {
            "()", // Valid - simple parentheses
            "()[]{}", // Valid - multiple different brackets
            "(]", // Invalid - mismatched brackets
            "([)]", // Invalid - incorrect ordering
            "{[]}", // Valid - nested brackets
            "", // Valid - empty string
            "(((", // Invalid - unclosed brackets
            ")))", // Invalid - no opening brackets
            "({[]})" // Valid - complex nesting
        };

        boolean[] expectedResults = {
            true, // ()
            true, // ()[]{}
            false, // (]
            false, // ([)]
            true, // {[]}
            true, // ""
            false, // (((
            false, // )))
            true // ({[]})
        };

        // Run test cases
        for (int i = 0; i < testCases.length; i++) {
            boolean result = solution.isValid(testCases[i]);
            System.out.printf("Test case %d: \"%s\" -> %b (Expected: %b)%n",
                    i + 1, testCases[i], result, expectedResults[i]);
            assert result == expectedResults[i] :
                    "Test case " + (i + 1) + " failed! Expected " + expectedResults[i] + " but got " + result;
        }

        System.out.println("All test cases completed!");
    }
}
