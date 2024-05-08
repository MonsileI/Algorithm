package 전체문제.sixth_month_2024_05.sixth_2024_05_08;

import java.util.*;
import java.io.*;
public class BJ_1941_소문난칠공주_Gold_3_re {
    static int N,M;
    static char[][]map;
    static int[]select;
    static int ans;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 5;
        M = 7;
        map = new char[N][N];
        select = new int[M];
        for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();
        dfs(0,0,0);
        System.out.println(ans);
    }

    static void calc(){
        boolean[]visited=  new boolean[7];
        visited[0] = true;
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{select[0]/5,select[0]%5});
        int cnt = 1;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j =c[1];
            if(cnt==M) {
                ans++;
                return;
            }
            for(int d=0;d<4;d++){
                int ni = i + move[d][0]; int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                int num = (ni*5)+nj;
                for(int t=0;t<M;t++){
                    if(visited[t]) continue;
                    if(num==select[t]){
                        visited[t] = true;
                        cnt++;
                        q.offer(new int[]{ni,nj});
                    }
                }
            }

        }
    }
    static void dfs(int start,int depth,int y){

        if(y>3) return;

        if(depth==M){
            calc();
            return;
        }

        for(int i=start;i<25;i++){
            select[depth] = i;
            if(map[i/5][i%5]=='Y') dfs(i+1,depth+1,y+1);
            else dfs(i+1,depth+1,y);
        }
    }
}
