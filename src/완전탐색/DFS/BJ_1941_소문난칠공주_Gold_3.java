package 완전탐색.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BJ_1941_소문난칠공주_Gold_3 {
    static int N;
    static char[][]map;
    static int[]select;
    static int ans;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 5;
        select = new int[7];
        map = new char[N][N];
        for(int i=0;i<N;i++)map[i] = br.readLine().toCharArray();
        dfs(0,0,0);
        System.out.println(ans);
    }

    static void calc(){
        boolean[]visited=  new boolean[7];
        Queue<int[]> q= new ArrayDeque<>();
        visited[0] = true;
        int cnt = 1;
        q.offer(new int[]{select[0]/5,select[0]%5});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j =c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                int num = (ni*5) + nj;
                if(cnt==7) {
                    ans++;
                    return;
                }
                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                for(int t=0;t<7;t++){
                    if(visited[t]) continue;
                    if(select[t]==num){
                        q.offer(new int[]{ni,nj});
                        visited[t] = true;
                        cnt++;
                    }
                }
            }


        }
    }
    static void dfs(int start,int depth,int y){

        if(y>3) return;
        if(depth==7){
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
