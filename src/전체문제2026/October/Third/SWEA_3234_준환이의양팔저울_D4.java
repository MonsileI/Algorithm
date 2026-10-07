package 전체문제2026.October.Third;

import java.util.*;
import java.io.*;
public class SWEA_3234_준환이의양팔저울_D4 {
    static int answer;
    static int[]arr;
    static int N;
    static boolean[]visited;
    static int[] factorial;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb= new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            answer = 0;
            factorial = new int[10];
            factorial[0] = 1;
            for (int i = 1; i <= 9; i++) {
                factorial[i] = factorial[i - 1] * i;
            }
            st =new StringTokenizer(br.readLine()," ");
            int sum = 0;
            for(int i=0;i<N;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
            }
            visited = new boolean[N];
            dfs(0,0,0,sum);
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
    static void dfs(int depth, int a, int b, int remainSum) {
        if (depth == N) {
            answer++;
            return;
        }

        // 남은 추를 전부 오른쪽에 놓아도 안전한 경우
        if (a >= b + remainSum) {
            answer += factorial[N - depth] * (1 << (N - depth));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, a + arr[i], b, remainSum - arr[i]);
                if (b + arr[i] <= a) {
                    dfs(depth + 1, a, b + arr[i], remainSum - arr[i]);
                }
                visited[i] = false;
            }
        }
    }
}
