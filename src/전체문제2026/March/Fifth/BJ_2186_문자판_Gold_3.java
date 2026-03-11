package 전체문제2026.March.Fifth;

import java.util.*;
import java.io.*;
public class BJ_2186_문자판_Gold_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); //K까지만 이동 가능
        char[][]map = new char[N][M];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j);
            }
        }
        String word = br.readLine();
        int len = word.length();
        Queue<int[]> q= new ArrayDeque<>();
        int[][][]dp = new int[N][M][len];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==word.charAt(len-1)){
                    q.offer(new int[]{i,j,len-1});
                    dp[i][j][len-1]++;
                }
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            for(int t=0;t<size;t++) {
                int[] c = q.poll();
                int i = c[0];
                int j = c[1];
                int idx = c[2];
                if (idx == 0) continue;
                for (int d = 0; d < 4; d++) {
                    int ni = i;
                    int nj = j;
                    for (int l = 0; l < K; l++) {
                        ni += move[d][0];
                        nj += move[d][1];
                        if (ni < 0 || nj < 0 || N - 1 < ni || M - 1 < nj) break;

                        if (map[ni][nj] == word.charAt(idx - 1)) {
                            if (dp[ni][nj][idx - 1] == 0) {
                                q.offer(new int[]{ni, nj, idx - 1});
                            }
                            dp[ni][nj][idx - 1] += dp[i][j][idx];
                        }
                    }
                }
            }
        }
        int answer = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                answer += dp[i][j][0];
            }
        }
        System.out.println(answer);
    }
}
