public class FibonacciSolutions {             

    // --------------------------------------------------          
    // 1. ITERATIVE APPROACH (BEST)
    // --------------------------------------------------
    /*
     * Idea:
     * Instead of storing all values, we only track last two numbers.
     * 
     * Example:
     * 0, 1 → 1 → 2 → 3 → 5 ...
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int fibIterative(int n) {
        if (n <= 1) return n;

        int prev = 0; // F(0)
        int curr = 1; // F(1)

        for (int i = 2; i <= n; i++) {
            int next = prev + curr; // F(n) = F(n-1) + F(n-2)
            prev = curr;
            curr = next;
        }

        return curr;
    }

    // --------------------------------------------------
    // 2. RECURSIVE APPROACH (BRUTE FORCE)
    // --------------------------------------------------
    /*
     * Idea:
     * Directly follow definition:
     * fib(n) = fib(n-1) + fib(n-2)
     * 
     * Problem:
     * Same values are recomputed many times.
     * 
     * Time Complexity: O(2^n)
     * Space Complexity: O(n)
     */
    public static int fibRecursive(int n) {
        if (n <= 1) return n;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    // --------------------------------------------------
    // 3. MEMOIZATION (TOP-DOWN DP)
    // --------------------------------------------------
    /*
     * Idea:
     * Store already computed results in an array (dp).
     * Avoid repeated calculations.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int fibMemo(int n) {
        int[] dp = new int[n + 1];
        return helper(n, dp);
    }

    private static int helper(int n, int[] dp) {
        if (n <= 1) return n;

        // If already calculated, return stored value
        if (dp[n] != 0) return dp[n];

        dp[n] = helper(n - 1, dp) + helper(n - 2, dp);
        return dp[n];
    }

    // --------------------------------------------------
    // 4. TABULATION (BOTTOM-UP DP)
    // --------------------------------------------------
    /*
     * Idea:
     * Build solution from 0 to n using an array.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int fibTabulation(int n) {
        if (n <= 1) return n;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // --------------------------------------------------
    // MAIN METHOD (FOR TESTING)
    // --------------------------------------------------
    public static void main(String[] args) {
        int n = 5;

        System.out.println("Iterative: " + fibIterative(n));
        System.out.println("Recursive: " + fibRecursive(n));
        System.out.println("Memoization: " + fibMemo(n));
        System.out.println("Tabulation: " + fibTabulation(n));
    }
}
