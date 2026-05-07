package 전체문제2026.May.Second;

import java.util.*;
import java.io.*;
public class SWEA_7793_오나의여신님_D5 {
    static int N,M;
    static char[][]map;
    static int [][] move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            M= Integer.parseInt(st.nextToken());
            map = new char[N][M];
            int si = 0 ;int sj = 0;
            Queue<int[]> virus = new ArrayDeque<>();
            boolean[][]virusMap = new boolean[N][M];
            for(int i=0;i<N;i++){
                String str = br.readLine();
                for(int j=0;j<M;j++){
                    map[i][j] = str.charAt(j);
                    if(map[i][j]=='S'){
                        si = i; sj = j;
                    }
                    if(map[i][j]=='*'){
                        virus.offer(new int[]{i,j});
                        virusMap[i][j] = true;
                    }
                }
            }
            map[si][sj] = '.';
            boolean[][]visited= new boolean[N][M];
            visited[si][sj] = true;
            Queue<int[]> q= new ArrayDeque<>();
            q.offer(new int[]{si,sj});
            int cnt = 0;
            int answer = 987654321;
            OuterLoop:
            while(true) {
                //바이러스 퍼뜨리기
                int qSize = virus.size();
                for(int s=0;s<qSize;s++){
                    int[]c = virus.poll();
                    int i = c[0]; int j = c[1];
                    for(int d=0;d<4;d++){
                        int ni = i + move[d][0];
                        int nj = j + move[d][1];
                        if (ni < 0 || nj < 0 || N - 1 < ni || M - 1 < nj) continue;
                        if (map[ni][nj]=='D') continue;
                        if (map[ni][nj] == 'X') continue;
                        if(virusMap[ni][nj]) continue;
                        virusMap[ni][nj] = true;
                        virus.offer(new int[]{ni, nj});
                    }
                }
                //이동
                qSize = q.size();
                if(qSize==0) break OuterLoop;
                for (int s = 0; s < qSize; s++) {
                    int[] c = q.poll();
                    int i = c[0];
                    int j = c[1];
                    if (map[i][j] == 'D') {
                        answer = cnt;
                        break OuterLoop;
                    }
                    for (int d = 0; d < 4; d++) {
                        int ni = i + move[d][0];
                        int nj = j + move[d][1];
                        if (ni < 0 || nj < 0 || N - 1 < ni || M - 1 < nj) continue;
                        if (virusMap[ni][nj]) continue;
                        if (map[ni][nj] == 'X') continue;
                        if(visited[ni][nj]) continue;
                        visited[ni][nj] = true;
                        q.offer(new int[]{ni, nj});
                    }
                }

                cnt++;
            }
            sb.append("#"+t+" ");
            if(answer!=987654321){
                sb.append(answer);
            }else{
                sb.append("GAME OVER");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
