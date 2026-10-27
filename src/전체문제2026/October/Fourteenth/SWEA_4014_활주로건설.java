package 전체문제2026.October.Fourteenth;

import java.util.*;
import java.io.*;
public class SWEA_4014_활주로건설 {
    static int N,X;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb=  new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            int[][]map = new int[N][N];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int answer = 0;
            for(int i=0;i<N;i++){
               if(calc(map[i])) answer++;
            }
            for(int j=0;j<N;j++){
                int[]tmpMap = new int[N];
                for(int i=0;i<N;i++) tmpMap[i] = map[i][j];
                if(calc(tmpMap)) answer++;
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
    static boolean calc(int[]arr){
        boolean flag = true;
        int before = arr[0];
        int cnt = 1;
        boolean[]check = new boolean[N];
        for(int i=1;i<N;i++){
            if(before==arr[i]) {
                cnt++;
                continue;
            };
            if(2 <= Math.abs(before-arr[i])){
                flag = false;
                break;
            }
            if(before<arr[i]){
                if(cnt<X){
                    flag = false;
                    break;
                }
                if(i-X<0){
                    flag =false;
                    break;
                }
                for(int j=i-1;i-X<=j;j--){
                    check[j] = true;
                }
                cnt = 1;
            }
            before = arr[i];
       }
        if(!flag) return flag;
        before = arr[N-1];
        cnt = 1;
        for(int i=N-2;-1<i;i--){
            if(before==arr[i]) {
                cnt++;
                continue;
            }
            if(2 <= Math.abs(before-arr[i])){
                flag = false;
                break;
            }
            if(before<arr[i]){
                if(cnt<X){
                    flag = false;
                    break;
                }
                if(N-1<i+X){
                    flag =false;
                    break;
                }
                for(int j=i+1;j<=i+X;j++){
                    if(check[j]) {
                        flag = false;
                        break;
                    }
                    check[j] = true;
                }
                cnt = 1;
            }
            before = arr[i];

        }
        return flag;
    }
}
