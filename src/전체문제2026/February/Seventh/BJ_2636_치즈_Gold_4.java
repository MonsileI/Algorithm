package 전체문제2026.February.Seventh;

import java.util.*;
import java.io.*;
public class BJ_2636_치즈_Gold_4 {
    static int N,M;
    static int[][]map;
    static boolean[][]visited;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static boolean flag;
    static int sum;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0;i<N;i++){
            st =new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        while(true){
            visited = new boolean[N][M];
            flag = true;
            int tmp = sum;
            sum = 0;
            OuterLoop:
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(!visited[i][j] && map[i][j]==0){
                        visited[i][j] = true;
                        checkCheeze(i,j);
                        break OuterLoop;
                    }
                }
            }
            if(flag){
                sum = tmp;
                break;
            }

            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j]==-1) map[i][j] = 0;
                }
            }
            cnt++;
        }
        System.out.println(cnt+"\n"+sum);
    }
    static void checkCheeze(int y,int x){
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int []c = q.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(visited[ni][nj]) continue;
                visited[ni][nj] = true;
                if(map[ni][nj]==1) {
                    flag = false;
                    map[ni][nj] = -1;
                    sum++;
                }
                if(map[ni][nj]==0) {
                    q.offer(new int[]{ni,nj});
                }
            }
        }
    }
}
