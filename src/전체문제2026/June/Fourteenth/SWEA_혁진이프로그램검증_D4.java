package 전체문제2026.June.Fourteenth;

import java.util.*;
import java.io.*;
public class SWEA_혁진이프로그램검증_D4  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            char[][]map = new char[N][M];
            for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();
            int si =0 ;int sj = 0;
            boolean flag = false;
            boolean[][][][]visited= new boolean[N][M][16][4];
            visited[si][sj][0][1] = true;
            Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{si,sj,0,1});
            while(!q.isEmpty()){
                int[]c = q.poll();
                int i = c[0]; int j =c[1]; int num = c[2]; int d = c[3];
                if(map[i][j]=='@'){
                    flag = true;
                    break;
                }
                char ch = map[i][j];
                if(ch=='?'){
                    for(int dir=0;dir<4;dir++){
                        int ni = i + move[dir][0];
                        int nj = j + move[dir][1];
                        if(ni<0) ni = N-1;
                        if(N-1<ni) ni = 0;
                        if(nj<0) nj = M-1;
                        if(M-1<nj) nj = 0;
                        if(visited[ni][nj][num][dir]) continue;
                        visited[ni][nj][num][dir] = true;
                        q.offer(new int[]{ni,nj,num,dir});
                    }
                    continue;
                }

                if('0'<=ch && ch<='9'){
                    num = ch -'0';
                }
                switch (ch){
                    case '^': d = 0;
                    break;
                    case '>': d = 1;
                    break;
                    case 'v': d = 2;
                    break;
                    case '<': d = 3;
                    break;
                    case '_':
                        if(num==0) d = 1;
                        else d = 3;
                    break;
                    case '|':
                        if(num==0) d = 2;
                        else d = 0;
                    break;
                    case '+':
                        num++;
                        if(num==16) num = 0;
                    break;
                    case '-':
                        num--;
                        if(num==-1) num = 15;
                    break;
                }
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0) ni = N-1;
                if(N-1<ni) ni = 0;
                if(nj<0) nj = M-1;
                if(M-1<nj) nj = 0;
                if(visited[ni][nj][num][d]) continue;
                visited[ni][nj][num][d] = true;
                q.offer(new int[]{ni,nj,num,d});

            }
            sb.append("#"+t+" ");
            sb.append(flag ?  "YES" : "NO");
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }
}
