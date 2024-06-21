package abcd_special_string;

import java.util.ArrayList;
import java.util.Scanner;

/*
You are given a special string S, this string represents the relations. String S consists of only two characters &#x27;&lt;&#x27; and &#x27;&gt;&#x27;. You task is to find the Lexicographically Smallest string L, consisting of unique characters of lower case latin letters (a-z) and follows the relations mentioned in S.For Example, If you are given S as &quot;&lt;&gt;&lt;&quot;, then you have to find lexicographically smallest string in which every two consecutive characters follows the relation in the order mentioned in S. Here the answer is &#x27;acbd&#x27; as  a &lt; c &gt; b &lt; d.It is clear that, if S is of length n then L will be of length n+1. You have to print string L.

Input: First Line contains T, denoting the number of test cases in each test file.Each Test case contains string S, denoting the relations.

Output:For each test case, print lexicographically Smallest string L consists of unique characters and following the relations mentioned in S.
 */
public class ABCDSpecialString {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        ArrayList<String> inputs = new ArrayList<>(t);

        for (int i = 0; i < t; i++) {
            inputs.add(scanner.next());
        }

        for(String s: inputs) {
            ArrayList<Character> sb = new ArrayList<>(s.length() + 1);
            for (int i = 'a'; i < 'a' + s.length() + 1; i++) {
                sb.add((char) i);
                if (i == 'a' + s.length() || s.charAt(i - 'a') == '<') {
                    while(!sb.isEmpty()) {
                        System.out.print(sb.get(sb.size() - 1));
                        sb.remove(sb.size() - 1);
                    }
                }
            }
            System.out.println();
        }
    }
}
