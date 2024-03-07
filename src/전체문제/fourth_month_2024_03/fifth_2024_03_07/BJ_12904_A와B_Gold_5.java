package 전체문제.fourth_month_2024_03.fifth_2024_03_07;
import java.util.*;
import java.io.*;
public class BJ_12904_A와B_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String f = br.readLine();
        String s = br.readLine();
        if (f.length() > s.length()) System.out.println(0);
        else {
            StringBuilder sb = new StringBuilder();
            sb.append(s);
            while (true) {
                char ch = sb.charAt(sb.length() - 1);
                sb.deleteCharAt(sb.length() - 1);
                if (ch == 'B') sb.reverse();
                if (sb.length() == f.length()) break;
            }
            if (sb.toString().equals(f)) System.out.println(1);
            else System.out.println(0);
        }
    }
}
