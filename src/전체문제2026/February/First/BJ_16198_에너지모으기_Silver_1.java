package 전체문제2026.February.First;

import java.util.*;
import java.io.*;
public class BJ_16198_에너지모으기_Silver_1 {
    static int N;
    static int[]arr;
    static int answer;
    static boolean[]visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        dfs(0,0);
        System.out.println(answer);
    }
    static void dfs(int depth,int sum){
        if(depth==N-2){
            answer = Math.max(answer,sum);
            return;
        }
        for(int i=1;i<N-1;i++){
            if(!visited[i]){
                visited[i] = true;
                int before = 0;
                int after = 0;
                for(int j=i;-1<j;j--){
                    if(!visited[j]){
                        before = arr[j];
                        break;
                    }
                }
                for(int j=i;j<N;j++){
                    if(!visited[j]){
                        after = arr[j];
                        break;
                    }
                }
                dfs(depth+1,sum+(before*after));
                visited[i] = false;
            }
        }
    }
}
