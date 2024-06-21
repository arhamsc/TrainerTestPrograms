package james;

import java.util.Scanner;

public class JamesAndMenu {
    public static int solve(int numMenus, int numItems, long[][] menus) {

        int bestMenu = 0;
        long[] bestPrices = new long[numItems];
        int[] countBestForMenus = new int[numMenus];

        for (int i = 0; i < numItems; i++) {
            long max = menus[0][i];

            for (int j = 0; j < numMenus; j++) {
                max = Math.max(max, menus[j][i]);
            }
            bestPrices[i] = max;
        }


        int maxBestCount = 0;

        for (int i = 0; i < numMenus; i++) {
            for (int j = 0; j < numItems; j++) {
                if (menus[i][j] == bestPrices[j]) {
                    countBestForMenus[i]++;

                }
            }
            maxBestCount = Math.max(maxBestCount, countBestForMenus[i]);
        }


        long[] avgMenus = new long[numMenus];

        for (int i = 0; i < numMenus; i++) {
            long avg = 0;

            for (int j = 0; j < numItems; j++) {
                avg += menus[i][j];
            }
            avg = avg / numItems;
            avgMenus[i] = avg;
        }

        long maxAvg = 0;

        for (int i = 0; i < numMenus; i++) {
            if (countBestForMenus[i] == maxBestCount) {
                if (avgMenus[i] > maxAvg) {
                    bestMenu = i + 1;
                    maxAvg = avgMenus[i];
                }
            }
        }

        return bestMenu;
    }

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        long[][] menus = new long[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                menus[i][j] = sc.nextLong();
            }
        }

        int result = solve(n, m, menus);

        System.out.println(result);
    }
}
