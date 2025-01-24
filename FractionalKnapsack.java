import java.util.*;

public class FractionalKnapsack {
    // Class to store the item details
    static class Item {
        int weight;
        int profit;
        double ratio;

        public Item(int weight, int profit) {
            this.weight = weight;
            this.profit = profit;
            this.ratio = (double) profit / weight;
        }
    }

    public static void main(String[] args) {
        int[] profit = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int totalWeight = 50;

        double maxProfit = fractionalKnapsack(profit, weight, totalWeight);
        System.out.println("Maximum Profit: " + maxProfit);
    }

    static double fractionalKnapsack(int[] profit, int[] weight, int totalWeight) {
        int n = profit.length;

        // Create an array of items
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(weight[i], profit[i]);
        }

        // Sort items by profit-to-weight ratio in descending order
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        double totalProfit = 0.0;
        int remainingWeight = totalWeight;

        // Pick items until the knapsack is full
        for (Item item : items) {
            if (remainingWeight >= item.weight) {
                // Take the whole item
                totalProfit += item.profit;
                remainingWeight -= item.weight;
            } else {
                // Take the fraction of the item
                totalProfit += item.ratio * remainingWeight;
                break; // Knapsack is full
            }
        }

        return totalProfit;
    }
}
