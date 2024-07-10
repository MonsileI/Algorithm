package 전체문제.eigth_month_2024_07.sixth_2024_07_10;

import java.util.*;
import java.io.*;
public class BJ_20008_몬스터를처치하자_Gold_5 {
    static int N;
    static int Mon;
    static int ans = 987654321;
    static int[][]arr;
    static boolean[]visited;
    static int memo;
    static int[]tmp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        Mon = Integer.parseInt(st.nextToken());
        arr = new int[N][2];
        tmp = new int[N];
        visited = new boolean[N];
        int min = 987654321;
        memo = 0;
        for(int i=0;i<N;i++){
            st =new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            if(arr[i][1]<min){
                min = arr[i][1];
                memo = (Mon/arr[i][1]) * arr[i][0];
            }
        }
        dfs(0);
        System.out.println(ans);
    }

    static void calc(){
        int[]time = new int[memo+1];
        int idx = 0;
        int t = 0;
        int p = 0;
        for(int i=0;i<N;i++){
            t = arr[tmp[i]][0];
            p = arr[tmp[i]][1];
            idx = 0;
            while(true){
                if(idx>memo) break;
                if(time[idx]!=0) {
                    idx++;
                    continue;
                }
                time[idx] = p;
                idx += t;
            }
        }
        int sum = 0;
        for(int i=0;i<memo+1;i++){
            sum += time[i];
            if(sum>=Mon){
                ans = Math.min(ans,i+1);
                return;
            }
        }
    }
    static void dfs(int depth){
        if(depth==N){
            calc();
            return;
        }
        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                tmp[depth] = i;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}
