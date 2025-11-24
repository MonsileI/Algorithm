package 전체문제2025.November.Eighth;

import java.util.*;
import java.io.*;
public class BJ_17142_연구소3_Gold_3 {
    static int N,V;
    static List<int[]> Virus;
    static int[][]map;
    static int vSize;
    static int[]tmp;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int answer;
    static int zeroCnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        Virus = new ArrayList<>();
        map = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] =  Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    Virus.add(new int[]{i,j});
                }
                if(map[i][j]==0){
                    zeroCnt++;
                }
            }
        }
        tmp = new int[V];
        vSize = Virus.size();
        answer = Integer.MAX_VALUE;
        comb(0,0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);


    }
    static void calc(){
        boolean[][]visited = new boolean[N][N];
        Queue<int[]> q=  new ArrayDeque<>();
        for(int i=0;i<V;i++){
            int vi = Virus.get(tmp[i])[0];
            int vj = Virus.get(tmp[i])[1];
            q.offer(new int[]{vi,vj,0});
            visited[vi][vj] = true;
        }
        int tmp = 0;
        int zeroEraze = 0;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1]; int cnt = c[2];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                if(map[ni][nj]==1) continue;
                if(!visited[ni][nj]){
                    visited[ni][nj] = true;
                    if(map[ni][nj]==0){
                        q.offer(new int[]{ni,nj,cnt+1});
                        zeroEraze++;
                        tmp = Math.max(tmp,cnt+1);
                    }
                    if(map[ni][nj]==2){
                        q.offer(new int[]{ni,nj,cnt+1});
                    }

                }
            }
        }
        if(zeroEraze==zeroCnt) {
            answer = Math.min(answer, tmp);
        }
    }
    static void comb(int depth, int start){

        if(depth==V){
            calc();
            return;
        }

        for(int i=start;i<vSize;i++){
            tmp[depth] = i;
            comb(depth+1,i+1);
        }

    }
}
