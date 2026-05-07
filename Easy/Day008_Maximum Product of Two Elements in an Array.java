class Solution {
    public int maxProduct(int[] nums) {

        // max  -> stores the largest element in the array
        // smax -> stores the second largest element      
        int smax = -1;
        int max = -1;

        // Time Complexity: O(n)
        // We traverse the array only once
        for (int i = 0; i < nums.length; i++) {

            // If current element is greater than max
            if (max < nums[i]) {

                // Previous max becomes second max
                smax = max;

                // Update max with current element
                max = nums[i];

            }

            // If current element is smaller than max
            // but greater than second max
            else if (smax < nums[i]) {

                // Update second largest element
                smax = nums[i];
            }
        }

        // Apply formula:
        // (largest element - 1) * (second largest element - 1)
        int ans = (max - 1) * (smax - 1);

        // Time Complexity: O(1)
        // Constant time mathematical operation

        // Overall Time Complexity: O(n)
        // Because array traversal dominates the execution time

        // Space Complexity: O(1)
        // No extra data structure is used

        // Return the maximum product
        return ans;
    }
}
