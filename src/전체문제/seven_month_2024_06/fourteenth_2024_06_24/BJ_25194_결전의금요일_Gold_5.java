package 전체문제.seven_month_2024_06.fourteenth_2024_06_24;

import java.util.*;
import java.io.*;
public class BJ_25194_결전의금요일_Gold_5 {
    static int N;
    static boolean flag;
    static int[]arr;
    static int Limit = 100;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        arr = new int[7];
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken()) % 7;
            if(num==0) continue;
            arr[num]++;
        }
        if(arr[4]!=0) flag= true;
        else dfs(0);
        System.out.println(flag? "YES" : "NO");
    }
    static void dfs(int sum){
        if(flag) return;
        if(sum>Limit) return;
        if(sum%7==4){
            flag= true;
            return;
        }

        for(int i=1;i<7;i++){
            if(arr[i]==0) continue;
            arr[i]--;
            dfs(sum+i);
            arr[i]++;
        }
    }

}
