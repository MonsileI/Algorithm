package 전체문제2026.February.Seventh;

import java.util.*;
import java.io.*;
public class BJ_14502_연구소_Gold_4 {
    static int N,M;
    static int[][]map;
    static int sum;
    static List<int[]> wall;
    static int answer;
    static Queue<int[]> virus;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int size;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        wall = new ArrayList<>();
        virus = new ArrayDeque<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==0){
                    sum++;
                    wall.add(new int[]{i,j});
                }
                if(map[i][j]==2){
                    virus.add(new int[]{i,j});
                }
            }
        }
        size = wall.size();
        comb(0,0);
        answer -= 3;
        System.out.println(answer);

    }
    static void calc(){
        Queue<int[]> tmpQueue = new ArrayDeque<>(virus);
        boolean[][]visited= new boolean[N][M];
        int tmpZeroCnt = sum;
        while(!tmpQueue.isEmpty()){
            int[]c = tmpQueue.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(visited[ni][nj]) continue;
                visited[ni][nj] = true;
                if(map[ni][nj]==0){
                    tmpZeroCnt--;
                    tmpQueue.offer(new int[]{ni,nj});
                }

            }
        }
        answer = Math.max(answer,tmpZeroCnt);
    }
    static void comb(int start,int depth){
        if(depth==3){
            calc();
            return;
        }
        for(int i=start;i<size;i++){
            int[]c = wall.get(i);
            map[c[0]][c[1]] = 1;
            comb(i+1,depth+1);
            map[c[0]][c[1]] = 0;

        }
    }
}
