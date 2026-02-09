package 전체문제2026.February.Fifth;

import java.util.*;
import java.io.*;
public class BJ_1553_도미노찾기_Gold_5 {
    static int[][]map;
    static int N,M;
    static int answer;
    static boolean[][]visited;
    static int goal;
    static boolean[]numbers;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 8; M = 7;
        map = new int[N][M];
        visited = new boolean[N][M];
        goal = 28;
        numbers = new boolean[49];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(str.charAt(j)-'0'+"");
            }
        }
        dfs(0);
        System.out.println(answer);
    }
    static void dfs(int depth) {
        if (depth == 28) {
            answer++;
            return;
        }

        int x = -1, y = -1;
        outer:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    x = i; y = j;
                    break outer;
                }
            }
        }

        // 오른쪽
        if (y + 1 < M && !visited[x][y + 1]) {
            tryPut(x, y, x, y + 1, depth);
        }

        // 아래
        if (x + 1 < N && !visited[x + 1][y]) {
            tryPut(x, y, x + 1, y, depth);
        }
    }

    static void tryPut(int x1, int y1, int x2, int y2, int depth) {
        int a = map[x1][y1];
        int b = map[x2][y2];
        if (a > b) { int t = a; a = b; b = t; }

        int num = a * 7 + b;
        if (numbers[num]) return;

        numbers[num] = true;
        visited[x1][y1] = visited[x2][y2] = true;
        dfs(depth + 1);
        visited[x1][y1] = visited[x2][y2] = false;
        numbers[num] = false;
    }
}
