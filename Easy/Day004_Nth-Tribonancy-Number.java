public class TribonacciSolutions {

    // --------------------------------------------------
    // 1. MEMOIZATION (TOP-DOWN DP) 
    // --------------------------------------------------
    /*
     * Idea:    
     * Tribonacci is similar to Fibonacci, but instead of 2,
     * we sum the last 3 numbers.
     * 
     * T(n) = T(n-1) + T(n-2) + T(n-3)
     * 
     * Base Cases:
     * T(0) = 0, T(1) = 1, T(2) = 1
     * 
     * We use dp[] to store already computed values.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int tribonacciMemo(int n) {
        int[] dp = new int[n + 1];
        return helper(n, dp);
    }

    private static int helper(int n, int[] dp) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        // If already calculated, return stored value
        if (dp[n] != 0) return dp[n];

        dp[n] = helper(n - 1, dp)
              + helper(n - 2, dp)
              + helper(n - 3, dp);

        return dp[n];
    }

    // --------------------------------------------------
    // 2. TABULATION (BOTTOM-UP DP)
    // --------------------------------------------------
    /*
     * Idea:
     * Build the solution from 0 → n iteratively.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int tribonacciTabulation(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1]
                  + dp[i - 2]
                  + dp[i - 3];
        }

        return dp[n];
    }

    // --------------------------------------------------
    // 3. ITERATIVE (SPACE OPTIMIZED) 🔥 BEST
    // --------------------------------------------------
    /*
     * Idea:
     * Instead of array, store only last 3 values.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int tribonacciOptimized(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int a = 0; // T(0)
        int b = 1; // T(1)
        int c = 1; // T(2)

        for (int i = 3; i <= n; i++) {
            int next = a + b + c;
            a = b;
            b = c;
            c = next;
        }

        return c;
    }

    // --------------------------------------------------
    // MAIN METHOD (FOR TESTING)
    // --------------------------------------------------
    public static void main(String[] args) {
        int n = 5;

        System.out.println("Memoization: " + tribonacciMemo(n));
        System.out.println("Tabulation: " + tribonacciTabulation(n));
        System.out.println("Optimized: " + tribonacciOptimized(n));
    }
}
