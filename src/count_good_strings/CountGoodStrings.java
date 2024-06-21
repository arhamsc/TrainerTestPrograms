package count_good_strings;

import java.util.*;

public class CountGoodStrings {
    static final int MOD = 1000000007;
    static final int MAX_SIZE = 100005;
    static int[][][] dp = new int[MAX_SIZE][30][2]; // Memoization table
    static int n, k;
    static String s;

    public static int solve(int i, int misMatchCount, boolean smaller) {
        if (misMatchCount < 0) {
            return 0;
        }
        if (i == n) {
            return (misMatchCount == 0 && smaller) ? 1 : 0;
        }
        if (dp[i][misMatchCount][smaller ? 1 : 0] != -1) {
            return dp[i][misMatchCount][smaller ? 1 : 0];
        }

        int ans = 0;
        if (smaller) {
            // If the string is already smaller, any character is allowed
            for (char ch = 'a'; ch <= 'z'; ch++) {
                ans = (ans + solve(i + 1, (misMatchCount - (ch != s.charAt(i) ? 1 : 0)), true)) % MOD;
            }
        } else {
            // If not smaller, we can only use characters up to s[i]
            for (char ch = 'a'; ch <= s.charAt(i); ch++) {
                ans = (ans + solve(i + 1, misMatchCount - ((ch != s.charAt(i) ? 1 : 0)), ch < s.charAt(i))) % MOD;
            }
        }
        return dp[i][misMatchCount][smaller ? 1 : 0] = ans;
    }

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            n = sc.nextInt();
            k = sc.nextInt();
            s = sc.next();

            // Initialize memoization table
            for (int[][] row : dp) {
                for (int[] col : row) {
                    Arrays.fill(col, -1);
                }
            }
            System.out.println(solve(0, k, false));
        }
    }
}

