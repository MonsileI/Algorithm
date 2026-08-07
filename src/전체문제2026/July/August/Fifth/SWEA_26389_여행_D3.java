package 전체문제2026.July.August.Fifth;

import java.util.*;
import java.io.*;
public class SWEA_26389_여행_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=  new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        while(0<TC) {
            String str = br.readLine();
            int[]arr = new int[4]; //0123
            for (int t = 0; t < str.length(); t++) {
                char ch = str.charAt(t);
                switch (ch) {
                    case 'N':
                         arr[0]++;
                        break;
                    case 'E':
                         arr[1]++;
                        break;
                    case 'S':
                         arr[2]++;
                        break;
                    case 'W':
                         arr[3]++;
                        break;
                }
            }
            boolean flag  = true;
            if(arr[0]==0 && arr[2]!=0) flag = false;
            if(arr[2]==0 && arr[0]!=0) flag= false;
            if(arr[1]==0 && arr[3]!=0) flag = false;
            if(arr[3]==0 && arr[1]!=0) flag = false;
            if(flag) sb.append("Yes");
            else sb.append("No");
            sb.append("\n");
            TC--;
        }
        System.out.println(sb.toString());
    }
}
