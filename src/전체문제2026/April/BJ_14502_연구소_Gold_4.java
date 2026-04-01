package 전체문제2026.April;

import java.util.*;
import java.io.*;
public class BJ_14502_연구소_Gold_4 {
    static int N;
    static int M;
    static int[][]map;
    static Queue<int[]>virus;
    static List<int[]> empty;
    static int[]tmp;
    static int emptySize;
    static int answer;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        empty = new ArrayList<>();
        virus = new ArrayDeque<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2) virus.offer(new int[]{i,j});
                if(map[i][j]==0) empty.add(new int[]{i,j});
            }
        }
        emptySize = empty.size();
        tmp = new int[3];
        comb(0,0);
        System.out.println(answer);
    }
    static void calc(){
        boolean[][] visited = new boolean[N][M];
        for(int t : tmp){
            int i = empty.get(t)[0];
            int j = empty.get(t)[1];
            map[i][j] = 1;
        }
        Queue<int[]> q= new ArrayDeque<>(virus);
        int sum = 0;
        while(!q.isEmpty()){
            int [] c= q.poll();
            int i = c[0]; int j =c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(map[ni][nj]==1) continue;
                if(visited[ni][nj]) continue;
                visited[ni][nj] = true;
                if(map[ni][nj]==0) sum++;
                q.offer(new int[]{ni,nj});
            }
        }
        for(int t : tmp){
            int i = empty.get(t)[0];
            int j = empty.get(t)[1];
            map[i][j] = 0;
        }
        sum = emptySize - sum - 3; //기둥 세운 자리
        answer = Math.max(answer,sum);

    }
    static void comb(int start,int depth){
        if(depth==3){
            calc();
            return;
        }
        for(int i=start;i<emptySize;i++){
            tmp[depth] = i;
            comb(i+1,depth+1);
        }
    }
}
