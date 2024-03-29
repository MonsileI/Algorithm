package 완전탐색.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_17141_연구소2_Gold_4 {
    static int N,M;
    static int [][] map;
    static List<int[]> list;
    static int size;
    static int[]tmp;
    static int sum = 0;
    static int answer = 987654321;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        list = new ArrayList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2) {
                    list.add(new int[]{i,j});
                    map[i][j] =0;
                }
                if(map[i][j]==0) sum++;
            }
        }
        tmp = new int[M];
        size = list.size();
        if(sum==0) System.out.println(0);
        else {
            comb(0, 0);
            System.out.println(answer == 987654321 ? -1 : answer);
        }
    }

    static void calc(){
        int sumTmp = sum;
        boolean[][]visited = new boolean[N][N];
        Queue<int[]> q= new ArrayDeque<>();
        for(int i=0;i<M;i++){
            int[]virus = list.get(tmp[i]);
            q.offer(new int[]{virus[0],virus[1],0});
            visited[virus[0]][virus[1]] = true;
            sumTmp--;
        }
        if(sumTmp==0) {
            answer = 0;
            return;
        }
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1]; int cnt = c[2];
            if(cnt>=answer) return;
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                if(!visited[ni][nj]&&map[ni][nj]==0){
                    visited[ni][nj] = true;
                    sumTmp--;
                    if(sumTmp==0) {
                        answer = Math.min(answer,cnt+1);
                        return;
                    }
                    q.offer(new int[]{ni,nj,cnt+1});
                }

            }

        }

    }
    static void comb(int depth,int start){

        if(depth==M){
            calc();
            return;
        }


        for(int i=start;i<size;i++){
            tmp[depth] = i;
            comb(depth+1,i+1);

        }
    }
}
