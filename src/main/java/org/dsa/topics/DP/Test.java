package org.dsa.topics.DP;

public class Test {

    public static void main(String[] args) {
        int[] set = {-3, -1, 4, -8, 1, 8};
        int sum = -4;
        System.out.println(subsetSumDP(set, sum));
    }

    private static int subsetSumDP(int[] arr, int target) {
        int absTarget = Math.abs(target);

        // Calculate the sum of negative elements in the array
        int sumNegative = 0;
        for (int num : arr) {
            if (num < 0) {
                sumNegative += num;
            }
        }

        // Adjust the size of the DP table based on the range of achievable sums with negative elements
        int minSum = sumNegative;
        int maxSum = absTarget;
        int dpSize = maxSum - minSum + 1;
        int n = arr.length;
        int[][] dp = new int[n + 1][dpSize];

        // Base cases:
        for (int i = 0; i <= n; i++) {
            dp[i][0 - minSum] = 1; // Empty subset always sums up to 0
        }

        for (int i = 1; i <= dpSize - 1; i++) {
            dp[0][i] = 0; // No elements, except for sum 0, can be achieved
        }

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = minSum; j <= maxSum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j - minSum] = dp[i - 1][j - minSum] | dp[i - 1][j - arr[i - 1] - minSum];
                } else {
                    dp[i][j - minSum] = dp[i - 1][j - minSum];
                }
            }
        }

        // If the original target sum was negative, return the result for the absolute target sum
        if (target < 0) {
            return dp[n][absTarget - sumNegative];
        } else {
            return dp[n][absTarget - minSum]; // Return the result for the absolute target sum
        }
    }
}
