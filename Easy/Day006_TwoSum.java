import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
     
public class Solution {

    // This function finds two indices such that nums[i] + nums[j] = target
    public int[] twoSum(int[] nums, int target) {

        // We use a HashMap to store number -> index
        Map<Integer, Integer> map = new HashMap<>();

        /*
         * Example dry run:
         * nums = [2, 7, 11, 15], target = 9
         *
         * Step 1:
         * i = 0 → nums[i] = 2
         * complement = 9 - 2 = 7
         * map is empty → store (2,0)
         *
         * Step 2:
         * i = 1 → nums[i] = 7
         * complement = 9 - 7 = 2
         * map has 2 → answer found → return [0,1]
         */

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            // If we already saw the complement, we’re done
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            // Otherwise store current number for future
            map.put(nums[i], i);
        }

        // Just in case (problem guarantees a solution though)
        throw new IllegalArgumentException("No solution found");
    }

    public static void main(String[] args) {

        Solution obj = new Solution();

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = obj.twoSum(nums, target);

        System.out.println(Arrays.toString(result));
    }
}
