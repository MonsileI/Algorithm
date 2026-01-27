package 전체문제2026.January.Eleventh;

import java.util.*;
import java.io.*;
public class BJ_3980_선발명단_Gold_5 {
    static int answer;
    static int[][] arr;
    static int N;
    static boolean[] visited;
    static boolean[] person;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int TC = Integer.parseInt(br.readLine());
        N = 11;
        while (0 < TC) {
            answer = 0;
            arr = new int[N][N];
            visited = new boolean[N];
            person = new boolean[N];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<N;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dfs(0,0, 0);
            sb.append(answer + "\n");
            TC--;
        }
        System.out.println(sb.toString());

    }

    static void dfs(int start,int depth, int sum) {

        if (depth == N) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = start; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[j] && !person[i] && arr[i][j] != 0) {
                    visited[j] = true;
                    person[i] = true;
                    dfs(i+1,depth + 1, sum + arr[i][j]);
                    visited[j] = false;
                    person[i] = false;
                }
            }
        }
    }
}
