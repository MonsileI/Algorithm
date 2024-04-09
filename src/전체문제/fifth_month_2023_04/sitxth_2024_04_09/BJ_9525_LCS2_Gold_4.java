package 전체문제.fifth_month_2023_04.sitxth_2024_04_09;

import java.util.*;
import java.io.*;
public class BJ_9525_LCS2_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String f = br.readLine();
        String s = br.readLine();
        int fSize = f.length();
        int sSize = s.length();
        int[][]lcs = new int[fSize+1][sSize+1];
        Stack<Character> stack = new Stack<>();
        for(int i=1;i<fSize+1;i++){
            char ch = f.charAt(i-1);
            for(int j=1;j<sSize+1;j++){
                char sch = s.charAt(j-1);
                if(ch==sch) lcs[i][j] = lcs[i-1][j-1]+1;
                else lcs[i][j] = Math.max(lcs[i-1][j],lcs[i][j-1]);
            }
        }
        int i = fSize;
        int j = sSize;
        while(0<i && 0<j){
            if(i==0||j==0) break;
           if(lcs[i][j]==lcs[i-1][j]) i--;
           else if(lcs[i][j]==lcs[i][j-1]) j--;
           else{
               stack.push(f.charAt(i-1));
               i--;j--;
           }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())sb.append(stack.pop());
        System.out.println(lcs[fSize][sSize]);
        System.out.println(sb.toString());
    }
}
