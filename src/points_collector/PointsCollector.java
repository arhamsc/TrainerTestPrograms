package points_collector;

/*
Sam is playing a game where he has to collect clues. The location of the next clue is obtained from the previous clue only. Now, he has to collect clues from 2 different sources, both of which are arranged like a list. The size of the lists is the same.

For the first list, in each clue, there is a value, either ‘”-1“ or “1”, Sam starts with a certain point. At each clue, if the value is “-1“, his point decrease by 1, and if the value is “1”, his point increase by 1.

For the second list, in each clue, there is a value, either ‘”-1“ or “1”, Sam starts with a certain point. At each clue, if the value is “-1“, his point decrease by 2, and if the value is “1”, his points increase by 2.

So, to give Sam more points, the person setting the clues wants to re-arrange the clues in two lists such that he gets maximum points without changing the size of the lists. Your task is to help him do that.

Print the points scored by him. Initial

Input Format

The first line will contain the size of the lists, n.

The next n lines contain n elements of list 1.

The next n lines contain n elements of list 2.

The last line takes P as input which represents the initial points with Sam.




Output Format

Print a single integer, denoting the points scored by Sam

Constraints:

1 =< n <= 10,000

1 <= P <= 1,00,000
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PointsCollector {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        ArrayList<Integer> a = new ArrayList<>(n);
        ArrayList<Integer> b = new ArrayList<>(n);
        ArrayList<Integer> combined = new ArrayList<>(a);

        for (int i = 0; i < n * 2; i++) {
            combined.add(scanner.nextInt());
        }

        int points = scanner.nextInt();

        Collections.sort(combined);

        a.addAll(combined.subList(0, n));
        b.addAll(combined.subList(n, n * 2));

        b = b.stream().map(i -> i * 2).collect(Collectors.toCollection(ArrayList::new));

        for(int i: a) {
            points += i;
        }

        for(int i: b) {
            points += i;
        }

        System.out.println(points);
    }
}
