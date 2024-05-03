package 전체문제.sixth_month_2024_05.second_2024_05_02;

import java.util.*;
import java.io.*;
public class BJ_11478_서로다른부분문자열의개수_Silver_3  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Set<String> set= new HashSet<>();
        int N = str.length();
        StringBuilder sb = null;
        for(int i=0;i<N;i++){
            sb = new StringBuilder();
            sb.append(str.charAt(i));
            set.add(sb.toString());
            for(int j=i+1;j<N;j++){
                sb.append(str.charAt(j));
                set.add(sb.toString());
            }
        }
        System.out.println(set.size());
    }
}
