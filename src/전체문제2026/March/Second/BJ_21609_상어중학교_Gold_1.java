package 전체문제2026.March.Second;

import java.util.*;
import java.io.*;
public class BJ_21609_상어중학교_Gold_1 {
    static int N,M;
    static int [][]map;
    static boolean[][]visited;
    static int answer;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
       while(true){
            boolean f = findAndTerminate();
            if(!f) break;
            gravity();
            turn();
            gravity();
       }
        System.out.println(answer);
    }
    static void turn(){
        for(int tc=0;tc<(N/2);tc++){
            //위쪽 저장
            int[]tmp = new int[N];
            for(int j=tc;j<N-tc;j++) tmp[j] = map[tc][j];
            //오른쪽 -> 위
            for(int i=tc;i<N-tc;i++) map[tc][i] = map[i][N-tc-1];
            //아래 -> 오른쪽
            for(int j=N-tc-1;tc<=j;j--) map[N-j-1][N-tc-1] = map[N-tc-1][j];
            //왼쪽 -> 아래
            for(int i=N-tc-1;tc<=i;i--) map[N-tc-1][i] = map[i][tc];
            //위 -> 왼쪽
            for(int i=tc;i<N-tc;i++) map[N-i-1][tc] = tmp[i];
        }
    }
    static void gravity(){

        for(int j=0;j<N;j++){
            for(int i=N-1;-1<i;i--){
                if(map[i][j] < 0) continue;//빈공간-2 , 검은색 블록 -1
                int ci = i;
                while(true){
                    if(ci==N){
                        ci=N-1;
                        break;
                    }
                    if(map[ci][j]==-2) ci++;
                    else{
                        if(ci==i) ci++;
                        else{
                            ci--;
                            break;
                        }

                    }
                }
                if(ci==i) continue;
                int tmp = map[ci][j];
                map[ci][j] = map[i][j];
                map[i][j] = tmp;
            }
        }
    }
    static boolean findAndTerminate(){
        visited = new boolean[N][N];
        int maxShapeCount = 0;
        int maxZeroCount = 0;
        int minI = N; int minJ = N;
        boolean flag = false;
        for(int i=N-1;-1<i;i--){
            for(int j=N-1;-1<j;j--){
                if(map[i][j]==-1) continue;
                if(map[i][j]==0) continue;
                if(map[i][j]==-2) continue; //제거된 블록 표시

                if(visited[i][j]) continue;
                visited[i][j] = true;
                int []count = bfs(i,j,map[i][j],false);
                int shapeCnt = count[0];
                int zeroCnt = count[1];
                int tmpI = count[2];
                int tmpJ = count[3];
                if(1<shapeCnt){
                    flag = true;
                }
                if(maxShapeCount<shapeCnt){
                    maxShapeCount = shapeCnt;
                    maxZeroCount = zeroCnt;
                    minI = tmpI; minJ = tmpJ;
                }else if(maxShapeCount==shapeCnt){
                    if(maxZeroCount<zeroCnt){
                        maxShapeCount = shapeCnt; //명시성을 위해 굳이 작성하는 코드
                        maxZeroCount = zeroCnt;
                        minI = tmpI ;minJ = tmpJ;
                    }else if(maxZeroCount==zeroCnt){
                        if(minI<tmpI){
                            maxShapeCount = shapeCnt; //명시성을 위해 굳이 작성하는 코드
                            maxZeroCount = zeroCnt;
                            minI = tmpI ;minJ = tmpJ;
                        }else if(minI==tmpI){
                            if(minJ<tmpJ){
                                maxShapeCount = shapeCnt; //명시성을 위해 굳이 작성하는 코드
                                maxZeroCount = zeroCnt;
                                minI = tmpI ;minJ = tmpJ;
                            }
                        }
                    }
                }
            }
        }
        if(!flag) return false;
        visited = new boolean[N][N];
        answer += Math.pow(maxShapeCount,2);
        bfs(minI,minJ,map[minI][minJ],true); //제거목적
        return true;
    }
    static int[] bfs(int y,int x,int shape,boolean isTermatinate){

        if(isTermatinate){
            map[y][x] = -2;
        }
        int minI = y;
        int minJ = x;
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{y,x});
        boolean[][]zeroVisited = new boolean[N][N];
        int cnt = 1;
        int zeroCnt = 0;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j  =c[1];

            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                if(map[ni][nj]==-1) continue;
                if(map[ni][nj]==shape){
                    if(!visited[ni][nj]){
                        if(ni < minI || (ni == minI && nj < minJ)){
                            minI = ni;
                            minJ = nj;
                        }
                        if(isTermatinate) map[ni][nj] = -2;
                        visited[ni][nj] = true;
                        cnt++;
                        q.offer(new int[]{ni,nj});
                    }
                }
                if(map[ni][nj]==0){
                    if(!zeroVisited[ni][nj]){
                        if(isTermatinate) map[ni][nj] = -2;
                        zeroVisited[ni][nj] = true;
                        cnt++;
                        zeroCnt++;
                        q.offer(new int[]{ni,nj});
                    }
                }
            }
        }
        return new int[]{cnt,zeroCnt,minI,minJ};
    }
}
