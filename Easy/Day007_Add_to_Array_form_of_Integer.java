class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        
        // List to store the final result
        List<Integer> ans = new ArrayList<>();

        // Pointer to traverse the array from last digit (rightmost)
        int p = num.length - 1;

        // Carry to handle overflow during addition
        int carry = 0;

        // Loop until all digits of num[] and k are processed
        while (p >= 0 || k > 0) {

            int numval = 0;

            // If array still has digits left, take current digit
            if (p >= 0) {
                numval = num[p];
            }

            // Extract last digit of k
            int d = k % 10;

            // Add current digit of array, digit of k, and carry
            int sum = numval + d + carry;

            // Result digit (ones place)
            int digit = sum % 10;

            // Update carry (tens place)
            carry = sum / 10;

            // Add the digit to result list
            ans.add(digit);

            // Move to next digit in array (left side)
            p--;

            // Remove last digit from k
            k = k / 10;
        }

        // If carry is still left after loop, add it
        if (carry > 0) {
            ans.add(carry);
        }

        // Since digits were added in reverse order, reverse the list
        Collections.reverse(ans);

        // Return the final result
        return ans;
    }
}