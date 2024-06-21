package op_to_mode;

import java.util.*;

public class MinOperationsToMode {
    public static int minOperations(List<Integer> arr, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int currentMaxCount = 0; // Frequency of current most frequent number
        int modesCount = 0; // Count of current modes

        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            int count = frequencyMap.get(num);
            if (count > currentMaxCount) {
                currentMaxCount = count;
                modesCount = 1;
            } else if (count == currentMaxCount) {
                modesCount++;
            }
        }

        int countOfK = frequencyMap.getOrDefault(k, 0);

        // If K is already a mode or can become the sole mode
        if (countOfK >= currentMaxCount) {
            if (countOfK == currentMaxCount && modesCount > 1) {
                return 1; // Make K the sole mode by changing one other element
            }
            return 0; // K is already a mode or can become one without changes
        }

        // Calculate elements to change
        return arr.size() - countOfK - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        List<List<Integer>> A = new ArrayList<>();
        List<Integer> K = new ArrayList<>();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            K.add(sc.nextInt());
            List<Integer> a = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                a.add(sc.nextInt());
            }

            A.add(a);
        }

        for (List<Integer> a: A) {
            int result = minOperations(a, K.get(A.indexOf(a)));
            System.out.println(result);
        }
    }
}

