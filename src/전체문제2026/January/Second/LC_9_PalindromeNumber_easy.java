package 전체문제2026.January.Second;
import java.util.*;
public class LC_9_PalindromeNumber_easy {
    public static void main(String[] args) {
        int x = -121;
        boolean answer = false;
            answer = true;
            String str = String.valueOf(x);
            int L = 0; int R = str.length()-1;
            while(L<R) {
                char f = str.charAt(L);
                char s = str.charAt(R);
                if (f != s) {
                    answer = false;
                    break;
                }
                L++;
                R--;
            }
            System.out.println(answer);
    }
}
