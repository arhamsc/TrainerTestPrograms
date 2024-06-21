package sub_number;

import java.util.ArrayList;
import java.util.Scanner;

public class LargestSubNumber {
    static int[] position = new int[100005];

    public static String largestSubNumber(String input, int N, int K) {
        int[] prefix = new int[N];
        prefix[0] = input.charAt(0) - '0';
        for (int index = 1; index < N; ++index) {
            prefix[index] = prefix[index - 1] ^ (input.charAt(index) - '0');
        }
        int rem = 0;
        int maximum = 0;
        int resultingIndex = N;
        preComputing(K);
        for (int i = N - 1; i > 0; i--) {
            rem = (((input.charAt(i) - '0') * position[N - i - 1]) + rem) % K;
            if (rem == 0 && prefix[i - 1] >= maximum && input.charAt(i) != '0') {
                maximum = prefix[i - 1];
                resultingIndex = i;
            }
        }
        if (resultingIndex == N) {
            return "-1";
        } else {
            String res = input.substring(resultingIndex);
            int nonZeroIndex = 0;
            for (int i = 0; i < res.length(); ++i) {
                if (res.charAt(i) != '0') {
                    nonZeroIndex = i;
                    break;
                }
            }
            return res.substring(nonZeroIndex);
        }
    }

    public static void preComputing(int K) {
        position[0] = 1;
        for (int index = 1; index < position.length; ++index) {
            position[index] = (position[index - 1] * 10) % K;
        }
    }

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        ArrayList<Integer> N = new ArrayList<>(), K = new ArrayList<>();
        ArrayList<String> input = new ArrayList<>();
        for (int t = 0; t < tc; t++) {
            N.add(sc.nextInt());
            K.add(sc.nextInt());
            input.add( sc.next());
        }

        for (int i = 0; i < N.size(); i++) {
            System.out.println(largestSubNumber(input.get(i), N.get(i), K.get(i)));
        }
    }

}
