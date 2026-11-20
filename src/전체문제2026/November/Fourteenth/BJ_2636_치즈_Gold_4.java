package 전체문제2026.November.Fourteenth;

import java.util.*;
import java.io.*;
public class BJ_2636_치즈_Gold_4 {
    static int N,M;
    static int[][]map;
    static boolean[][]visited;
    static Queue<int[]> cheezeQ;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int time = 0;
        int lastCheeze = 0;
        while(true){
            boolean isMelt = false;
            //녹일거 체크
            isMelt = checkMelt();
            if(!isMelt) break;
            //치즈개수세기
            lastCheeze = cheezeQ.size();
            //녹여버리기
            executeMelt();
            time++;
        }
        System.out.println(time+"\n"+lastCheeze);
    }
    static void executeMelt(){
        while(!cheezeQ.isEmpty()){
            int[]c = cheezeQ.poll();
            int i = c[0]; int j = c[1];
            map[i][j] = 0;
        }
    }
    static boolean checkMelt(){
        boolean flag = false;
        visited = new boolean[N][M];
        Queue<int[]> q =new ArrayDeque<>();
        cheezeQ = new ArrayDeque<>();
        q.offer(new int[]{0,0});
        visited[0][0] = true;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(!checkRange(ni,nj)) continue;
                if(visited[ni][nj]) continue;
                visited[ni][nj] = true;
                if(map[ni][nj]==1) {
                    flag = true;
                    cheezeQ.offer(new int[]{ni,nj});
                }
                if(map[ni][nj]==0) q.offer(new int[]{ni,nj});
            }
        }

        return flag;
    }
    static boolean checkRange(int i,int j){
        if(i<0||j<0||N-1<i||M-1<j) return false;
        return true;
    }
}
