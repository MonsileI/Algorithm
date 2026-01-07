package 전체문제2026.January.Second;

import java.util.*;
import java.io.*;
public class BJ_9663_NQueen_Gold_4  {
    static int N;
    static int[] arr;
    static boolean[]visited;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        for(int i=0;i<N;i++){
            visited[i] = true;
            arr[0] = i;
            dfs(1,i);
            visited[i] = false;
        }
        System.out.println(answer);

    }
    static void dfs(int y,int x){
        if(y==N){
            answer++;
            return;
        }
        //visited 로 x값 체크
        OuterLoop:
        for(int j=0;j<N;j++){

            if(!visited[j]){
                for(int d=0;d<y;d++){
                    if(Math.abs(y-d) == Math.abs(j-arr[d])){
                        continue OuterLoop;
                    }
                }
                visited[j] = true;
                arr[y] = j;
                dfs(y+1,j);
                visited[j] = false;
            }
        }
    }
}
