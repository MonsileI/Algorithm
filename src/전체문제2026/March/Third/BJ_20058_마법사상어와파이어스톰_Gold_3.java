package 전체문제2026.March.Third;

import java.util.*;
import java.io.*;
public class BJ_20058_마법사상어와파이어스톰_Gold_3 {
    static int [][]map;
    static int N;
    static int qSize;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static boolean[][]visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        N = (int)Math.pow(2,N);
        int Q = Integer.parseInt(st.nextToken());
        map  = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine()," ");


        while(0<Q){
            qSize = Integer.parseInt(st.nextToken());
            qSize = (int)Math.pow(2,qSize);

            divideAndConquer(0,0,N);
            //인접한게 0 이상이면 녹이기
            List<int[]> checkMelt = new ArrayList<>();
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    int cnt = 0;
                    for(int d=0;d<4;d++) {
                        int ni = i + move[d][0];
                        int nj = j + move[d][1];
                        if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                        if(0 < map[ni][nj]) cnt++;
                    }
                    if(cnt<3) checkMelt.add(new int[]{i,j});
                }
            }
            for(int[] node : checkMelt){
                map[node[0]][node[1]]--;
            }
            Q--;
        }


        int sum = 0;
        int max = 0;
        visited = new boolean[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sum += Math.max(map[i][j],0);
                if(0<map[i][j] && !visited[i][j]){
                    visited[i][j] = true;
                    max = Math.max(max,bfs(i,j));
                }
            }
        }

        System.out.println(sum+"\n"+max);
    }
    static int bfs(int y,int x){
        Queue<int[]> q= new ArrayDeque<>();
        int cnt = 1;

        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                if(visited[ni][nj]) continue;
                if(map[ni][nj]<1) continue;
                visited[ni][nj] = true;
                cnt++;
                q.offer(new int[]{ni,nj});
            }
        }

        return cnt;
    }
    static void turn(int y,int x,int size){

        int[][] tmp = new int[size][size];

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                tmp[j][size-1-i] = map[y+i][x+j];
            }
        }

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                map[y+i][x+j] = tmp[i][j];
            }
        }
    }
    static void divideAndConquer(int y,int x,int size){
        if(size==qSize){
            turn(y,x,size);
            return;
        }
        divideAndConquer(y,x,size/2);
        divideAndConquer(y+size/2,x,size/2);
        divideAndConquer(y,x+size/2,size/2);
        divideAndConquer(y+size/2,x+size/2,size/2);

    }
}
