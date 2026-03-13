package 전체문제2026.March.Eighth;

import java.util.*;
import java.io.*;
public class BJ_3987_보이저1호_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};

        // \  : 0 -> 3 , 1 -> 2 , 2 -> 1, 3 -> 0
        int[]firMove = {3,2,1,0};
        // / : 0 -> 1 , 1->0 ,2 -> 3, 3->2
        int[]secMove = {1,0,3,2};
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][]map = new char[N][M];
        for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine()," ");
        int si = Integer.parseInt(st.nextToken())-1;
        int sj = Integer.parseInt(st.nextToken())-1;

        boolean cycleFlag = false;
        int answer = -1;
        int ansDir = 0;
        for(int od=0;od<4;od++) {

            if (cycleFlag) break;

            boolean[][][] visited = new boolean[N][M][4];
            Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{si, sj, 1, od, od});
            visited[si][sj][od] = true;


            while (!q.isEmpty()) {
                int[] c = q.poll();
                int i = c[0];
                int j = c[1];
                int cnt = c[2];
                int d = c[3];
                int odirinD = c[4];
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if ((ni < 0 || nj < 0 || N - 1 < ni || M - 1 < nj) || (map[ni][nj] == 'C')) {
                    if(answer<cnt){
                        answer = Math.max(answer, cnt);
                        ansDir = odirinD;
                    }
                    break;
                }
                if (visited[ni][nj][d]) {
                    answer = -1;
                    ansDir = odirinD;
                    cycleFlag = true;
                    break;
                }
                visited[ni][nj][d] = true;
                if (map[ni][nj] == '\\') d = firMove[d];
                if (map[ni][nj] == '/') d = secMove[d];
                q.offer(new int[]{ni, nj, cnt + 1, d, odirinD});
            }
        }
        char[] ansMove = {'U','R','D','L'};
        System.out.println(ansMove[ansDir]);
        if(cycleFlag){
            System.out.println("Voyager");
        }else{
            System.out.println(answer);
        }
    }
}
