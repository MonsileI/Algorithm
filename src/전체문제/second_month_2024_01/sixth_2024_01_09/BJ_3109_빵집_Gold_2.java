package 전체문제.second_month_2024_01.sixth_2024_01_09;
import java.util.*;
import java.io.*;
public class BJ_3109_빵집_Gold_2 {
    static int N,M;
    static boolean[][] visited;
    static boolean flag;
    static char[][]map;
    static int answer;
    static int[]move = {-1,0,1};
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            flag = false;
            dfs(i,0);
        }
        System.out.println(answer);
    }
    static void dfs(int y,int x){
        visited[y][x] = true;
        if(x==M-1){
            flag = true;
            answer++;
            return;
        }
        for(int d=0;d<3;d++){
            int ni = y + move[d];
            int nj = x + 1;
            if(ni<0||N-1<ni) continue;
            if(map[ni][nj]=='x') continue;
            if(visited[ni][nj]) continue;
            if(flag) return;
            dfs(ni,nj);
        }
    }
}
