package 전체문제.fourth_month_2024_03.first_2024_03_01;
import java.util.*;
import java.io.*;
public class BJ_1600_말이되고픈원숭이_Gold_3 {

    static int N,M;
    static int [][] map;
    static boolean[][][]visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N][M][K+1];
        int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
        int[][]moveHorse = {{-1,-2},{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2}};
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0,0,K});
        visited[0][0][K] = true;
        int answer = -1;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i  =c[0]; int j =c[1]; int cnt = c[2]; int jump = c[3];
            if(i==N-1&&j==M-1) {
                answer = cnt;
                break;
            }
            if(jump>0){
                for(int d=0;d<8;d++){
                    int ni = i + moveHorse[d][0];
                    int nj = j + moveHorse[d][1];
                    if(!range(ni,nj,jump-1)) continue;
                    visited[ni][nj][jump-1] = true;
                    q.offer(new int[]{ni,nj,cnt+1,jump-1});
                }
            }
                for (int d = 0; d < 4; d++) {
                    int ni = i + move[d][0];
                    int nj = j + move[d][1];
                    if (!range(ni, nj,jump)) continue;
                    visited[ni][nj][jump] = true;
                    q.offer(new int[]{ni, nj,cnt+1,jump});
                }
            }
        System.out.println(answer);
    }
    static boolean range(int ni,int nj,int jump){
        if(ni<0||nj<0||N-1<ni||M-1<nj) return false;
        if(map[ni][nj]==1||visited[ni][nj][jump]) return false;
        return true;
    }
}
