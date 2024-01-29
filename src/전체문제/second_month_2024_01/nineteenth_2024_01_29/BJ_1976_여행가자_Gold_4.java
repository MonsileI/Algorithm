package 전체문제.second_month_2024_01.nineteenth_2024_01_29;

import java.util.*;
import java.io.*;
public class BJ_1976_여행가자_Gold_4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[][]map = new boolean[N+1][N+1];
        StringTokenizer st = null;
        for(int i=1;i<N+1;i++){
            st=  new StringTokenizer(br.readLine()," ");
            for(int j=1;j<N+1;j++){
                int num = Integer.parseInt(st.nextToken());
                if(num==1) map[i][j] = true;
                if(i==j) map[i][j] = true;
            }
        }
        for(int l=1;l<N+1;l++){
            for(int i=1;i<N+1;i++){
                for(int j=1;j<N+1;j++){
                    if(map[i][j]) continue;
                    if(i==j) continue;
                    if(map[i][l] && map[l][j]) map[i][j] = true;
                }
            }
        }
        st = new StringTokenizer(br.readLine()," ");
        int before = Integer.parseInt(st.nextToken());
        boolean flag = true;
        for(int i=1;i<M;i++){
            int num = Integer.parseInt(st.nextToken());
            if(!map[before][num]){
                flag= false;
                break;
            }
            before = num;
        }
        System.out.println(flag ? "YES" : "NO");

    }
}
