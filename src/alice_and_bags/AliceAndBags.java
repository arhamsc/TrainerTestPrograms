package alice_and_bags;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AliceAndBags {
    public static int largestPrimeFactor(int num) {
        int i = 2;
        while (i * i <= num) {
            while (num % i == 0) {
                num /= i;
            }
            i++;
        }
        return (num > 1) ? num : i - 1;
    }

    public static int[] solve(ArrayList<Integer> arr) {
        Map<Integer, Integer> bags = new HashMap<>();
        int maxBag = 0, maxSum = Integer.MIN_VALUE;

        for (Integer num : arr) {
            int bagNum = largestPrimeFactor(num);
            bags.put(bagNum, bags.getOrDefault(bagNum, 0) + num);

            if (bags.get(bagNum) > maxSum) {
                maxSum = bags.get(bagNum);
                maxBag = bagNum;
            } else if (bags.get(bagNum) == maxSum && bagNum < maxBag) {
                maxBag = bagNum;
            }
        }
        return new int[]{bags.size(), maxBag};
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int t = scanner.nextInt();
        ArrayList<ArrayList<Integer>> a = new ArrayList<>(t);
        for (int i = 0; i < t; i++) {
            final int n = scanner.nextInt();
            ArrayList<Integer> b = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                b.add(scanner.nextInt());
            }
            a.add(b);
        }

        for (ArrayList<Integer> b : a) {
            final int[] result = solve(b);
            System.out.println(result[0] + " " + result[1]);
        }
    }
}
