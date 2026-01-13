package 전체문제2026.January.SIxth;

import java.util.*;
import java.io.*;
public class BJ_16113_시그널_Silver_1 {
    static char[][]map;
    static int N,M;
    static boolean[][]visited;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int strLen = Integer.parseInt(br.readLine());
        String str = br.readLine();
        N = 5; M = strLen/5;
        map = new char[N][M];
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt((i*M)+j);
            }
        }
        visited = new boolean[N][M];
        StringBuilder sb = new StringBuilder();
        int []numArr = {1,4,7,8};
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j] && map[i][j]=='#'){
                    visited[i][j] = true;
                    int cnt  = bfs(i,j); //235, 069
                    if(cnt==11) {
                        if(map[i+3][j]=='#') sb.append(2);
                        else if(map[i+1][j]=='#') sb.append(5);
                        else sb.append(3);
                    }
                    else if(cnt==12){
                        if(map[i+2][j+1]=='.') sb.append(0);
                        else if(map[i+1][j+2]=='#') sb.append(9);
                        else sb.append(6);
                    }else{
                        switch (cnt){
                            case 5 : sb.append(1);
                            break;
                            case 9 : sb.append(4);
                            break;
                            case 7 : sb.append(7);
                            break;
                            case 13 : sb.append(8);
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }
    static int bfs(int y,int x){
        Queue<int[]> q= new ArrayDeque<>();
        int cnt = 0;
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1];
            cnt++;
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(!visited[ni][nj] && map[ni][nj]=='#'){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj});
                }
            }
        }
        return cnt;
    }
}
