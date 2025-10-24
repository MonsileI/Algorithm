package 전체문제2025.September.Tenth;

import java.util.*;
import java.io.*;
public class BJ_1099_알수없는문장_Gold_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N =  Integer.parseInt(br.readLine());
        String[]arr = new String[N];
        for(int i=0;i<N;i++) {
            arr[i] = br.readLine();
            str = str.replaceAll(arr[i],"");
        }
        System.out.println(str);

    }
}
