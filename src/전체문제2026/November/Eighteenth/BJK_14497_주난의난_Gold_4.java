package 전체문제2026.November.Eighteenth;

import java.util.*;
import java.io.*;
public class BJK_14497_주난의난_Gold_4 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int si = Integer.parseInt(st.nextToken())-1;
        int sj = Integer.parseInt(st.nextToken())-1;
        int gi = Integer.parseInt(st.nextToken())-1;
        int gj = Integer.parseInt(st.nextToken())-1;
        int[][]map = new int[N][M];

        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                char ch = str.charAt(j);
                if(ch=='#'||ch=='*') {
                    map[i][j] = 0;
                    continue;
                };
                ch -= '0';
                map[i][j] = ch;
            }
        }
        Queue<int[]> q= new ArrayDeque<>();
        int time = 1;
        boolean[][]visited=  new boolean[N][M];
        visited[si][sj] = true;
        q.offer(new int[]{si,sj});

        OuterLoop:
        while(true){
            Queue<int[]> nextQ  =new ArrayDeque<>();
            while(!q.isEmpty()) {
                int[] c = q.poll();
                int i = c[0];
                int j = c[1];
                if (i == gi && j == gj) {
                    break OuterLoop;
                }
                for (int d = 0; d < 4; d++) {
                    int ni = i + move[d][0];
                    int nj = j + move[d][1];
                    if (ni < 0 || nj < 0 || N - 1 < ni || M - 1 < nj) continue;
                    if (visited[ni][nj]) continue;
                    visited[ni][nj] = true;
                    if (map[ni][nj] == 0) q.offer(new int[]{ni, nj});
                    if (map[ni][nj] == 1) {
                        nextQ.offer(new int[]{ni,nj});
                        map[ni][nj] = 0;
                    }
                }
            }
            q = nextQ;
            time++;
        }
        System.out.println(time);
    }
}
