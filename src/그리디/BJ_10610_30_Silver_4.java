package 그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_10610_30_Silver_4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int len = num.length();
        int total = 0;
        boolean flag = false;
        int[]arr = new int[len];
        for(int i=0;i<len;i++) {
            int number = num.charAt(i)-'0';
            total += number;
            if(number==0) flag = true;
            arr[i] = number;
        }
        if(!flag) System.out.println(-1);
        else if(total % 3 !=0) System.out.println(-1);
        else {
            Arrays.sort(arr);
            StringBuilder sb = new StringBuilder();
            for (int i = len - 1; -1 < i; i--) sb.append(arr[i]);
            System.out.println(sb.toString());
        }
    }
}
