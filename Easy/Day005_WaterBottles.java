/**      
 * Problem: 1518. Water Bottles      
 * * Approach: Simulation
 * We simulate the process of drinking bottles and exchanging the empty ones.
 * This is a greedy approach because we exchange as many bottles as possible 
 * at every available opportunity.
 * * Time Complexity: O(log_exchange(N))
 * - In each step, the number of bottles is divided by the exchange rate.
 * - This logarithmic reduction ensures the loop runs very few times even for large N.
 * * Space Complexity: O(1)
 * - We only use a fixed amount of space for integer variables (totalDrunk, emptyBottles, etc.).
 * - The space usage does not grow with the input size.       
 */
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        // Initialize total bottles consumed with the starting count
        int totalDrunk = numBottles;
        
        // We start with as many empty bottles as we initially drank     
        int emptyBottles = numBottles;           

        // Loop as long as we have enough empty bottles to make an exchange
        while (emptyBottles >= numExchange) {
            // Calculate how many new full bottles we receive
            int newFullBottles = emptyBottles / numExchange;
            
            // Calculate how many empty bottles couldn't be exchanged in this round
            int leftoverEmpties = emptyBottles % numExchange;

            // Increment the total count of bottles drunk
            totalDrunk += newFullBottles;

            // The new count of empty bottles is:
            // (The bottles we just finished) + (The ones we couldn't exchange)
            emptyBottles = newFullBottles + leftoverEmpties;
        }

        return totalDrunk;
    }
}
