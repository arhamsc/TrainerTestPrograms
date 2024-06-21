package same_strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class SameStrings {
    public static boolean canMakeEqual(String s, String t) {
        if (s.length() != t.length()) {
            return false; // Different lengths, cannot be made equal
        }

        Map<Character, Integer> freq = new HashMap<>();

        // Count character frequencies in both strings
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Compare character frequencies
        for (char c : freq.keySet()) {
            if (!freq.containsKey(c) || freq.get(c) % 2 == 1) {
                return false; // Mismatched character counts
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine(); // Consume newline

        while (T-- > 0) {
            String s = sc.next();
            String t = sc.next();

            System.out.println(canMakeEqual(s, t) ? "YES" : "NO");
        }
    }
}
