package gym_streak;

import java.util.ArrayList;
import java.util.Scanner;

public class GymStreak {
    public static int maxStreak(String attendance) {
        int maxStreak = 0;
        int currentStreak = 0;
        int missedDays = 0;

        for (int i = 0; i < attendance.length(); i++) {
            if (attendance.charAt(i) == '1') {
                currentStreak++;
            } else {
                if (missedDays == 1) {
                    currentStreak = 0;  // Reset streak if already missed one day
                    missedDays = 0;
                } else {
                    currentStreak++; // Continue streak if this is the first missed day
                    missedDays = 1;
                }
            }
            maxStreak = Math.max(maxStreak, currentStreak); // Update max streak
        }
        return maxStreak;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        ArrayList<String> attendance = new ArrayList<>();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            attendance.add(sc.next());
        }

        for(String att: attendance) {
            int result = maxStreak(att);
            System.out.println(result);
        }
        sc.close();
    }
}
