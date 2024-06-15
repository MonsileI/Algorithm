package 전체문제.seven_month_2024_06.eighth_2024_06_15;

import java.util.*;
import java.io.*;
public class BJ_14497_주난의난_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];
        st = new StringTokenizer(br.readLine(), " ");
        int si = Integer.parseInt(st.nextToken()) - 1;
        int sj = Integer.parseInt(st.nextToken()) - 1;
        int ei = Integer.parseInt(st.nextToken()) - 1;
        int ej = Integer.parseInt(st.nextToken()) - 1;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        map[si][sj] = '0';
        map[ei][ej] = '1';
        int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{si, sj});
        int answer = 0;
        boolean[][]visited = new boolean[N][M];
        visited[si][sj] = true;
        OuterLoop:
        while (true) {
            Queue<int[]> nextQ = new ArrayDeque<>();
            while(!q.isEmpty()){
                int[]c = q.poll();
                int i = c[0]; int j = c[1];
                if(i==ei && j==ej) break OuterLoop;
                for(int d=0;d<4;d++){
                    int ni = i + move[d][0];
                    int nj = j + move[d][1];
                    if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                    if(map[ni][nj]=='1'){
                        visited[ni][nj] = true;
                        map[ni][nj] = '0';
                        nextQ.offer(new int[]{ni,nj});
                    }else{
                        if(!visited[ni][nj]){
                        visited[ni][nj] = true;
                        q.offer(new int[]{ni,nj});
                        }
                    }
                }
            }
            answer++;
            q = nextQ;
        }
        System.out.println(answer);
    }
}
