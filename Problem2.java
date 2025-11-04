// Time Complexity : O(3n)
// Space Complexity : O(n) for stack storage
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Use a monotonic increasing stack to find the next biggest number. Once the biggest numbers are found in first loop, we will start from the beginning of the nums to find the next biggest number for the remaining numbers.
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        // filling the array with -1 for default result
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack<>();

        // doing 2n since we have to find the next bigger number in circular way
        for (int i = 0; i < 2 * n; i++) {
            while (!st.isEmpty() && nums[i % n] > nums[st.peek()]) {
                int popped = st.pop();
                res[popped] = nums[i % n];
            }

            // adding the number to the stack only on first loop. we just have to find the next biggest number for remaining numbers from first loop in second loop
            if (i < n)
                st.push(i);
        }
        return res;
    }
}