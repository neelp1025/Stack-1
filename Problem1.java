// Time Complexity : O(2n)
// Space Complexity : O(n) for stack storage
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Use a monotonic increasing stack to find the index of the next warmer day.
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                int previous = st.pop();
                result[previous] = i - previous;
            }
            st.push(i);
        }

        return result;
    }
}