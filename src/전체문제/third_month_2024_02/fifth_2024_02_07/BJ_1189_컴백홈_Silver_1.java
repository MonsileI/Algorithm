package 전체문제.third_month_2024_02.fifth_2024_02_07;
import java.util.*;
import java.io.*;
public class BJ_1189_컴백홈_Silver_1 {
    static int N,M;
    static char[][]map;
    static int answer;
    static int totalCnt;
    static boolean[][]visited;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        totalCnt = Integer.parseInt(st.nextToken());
        map =new char[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();
        visited[N-1][0] = true;
        dfs(N-1,0,1);
        System.out.println(answer);
    }
    static void dfs(int i,int j,int cnt){

        if(i==0 && j==M-1){
            if(cnt==totalCnt) answer++;
            return;
        }
        for(int d=0;d<4;d++){
            int ni = i + move[d][0];
            int nj = j + move[d][1];
            if(ni<0||nj<0||N-1<ni||M-1<nj)continue;
            if(!visited[ni][nj] && map[ni][nj]!='T'){
                visited[ni][nj] = true;
                dfs(ni,nj,cnt+1);
                visited[ni][nj] = false;
            }
        }
    }
}
