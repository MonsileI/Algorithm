package 전체문제2026.February.First;

import java.util.*;
import java.io.*;
public class BJ_20208_진우의민트초코우유_Gold_5 {
    static int N,M,H;
    static List<int[]> milkList;
    static int si,sj;
    static boolean[]visited;
    static int size;
    static boolean flag;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        milkList = new ArrayList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                int node = Integer.parseInt(st.nextToken());
                if(node==1){
                    si = i;
                    sj = j;
                }
                if(node==2){
                    milkList.add(new int[]{i,j});
                }
            }
        }
        size = milkList.size();
        visited = new boolean[size];
        dfs(si,sj,0,M);
        System.out.println(answer);
    }
    static void dfs(int i,int j,int cnt,int power){
        if (power >= checkRange(i, j, si, sj)) {
            answer = Math.max(answer, cnt);
        }
        for(int t=0;t<size;t++){
            if(visited[t]) continue;
            int y= milkList.get(t)[0];
            int x = milkList.get(t)[1];
            int len = checkRange(y,x,i,j);
            if(power<len) continue;
            int nextMove = power-len+H;

            visited[t] = true;
            dfs(y,x,cnt+1,nextMove);
            visited[t] = false;
        }
    }
    static int checkRange(int y,int x,int i,int j){
        return Math.abs(y-i)+Math.abs(x-j);
    }
}
