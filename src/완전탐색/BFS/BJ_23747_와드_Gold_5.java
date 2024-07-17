package 완전탐색.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_23747_와드_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][]visited=  new boolean[N][M];
        char[][]map = new char[N][M];
        for(int i=0;i<N;i++)map[i] = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine()," ");
        int y = Integer.parseInt(st.nextToken())-1;
        int x = Integer.parseInt(st.nextToken())-1;
        int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
        String order = br.readLine();
        int t = order.length();
        for(int z=0;z<t;z++){
            char ch = order.charAt(z);
            int d = 0;
            if(ch=='W'){
                if(visited[y][x]) continue;
                visited[y][x] = true;
                Queue<int[]> q= new ArrayDeque<>();
                char value = map[y][x];
                q.offer(new int[]{y,x});
                while(!q.isEmpty()){
                    int[]c = q.poll();
                    int i = c[0]; int j =c[1];
                    for(int dd=0;dd<4;dd++){
                        int ni = i + move[dd][0];
                        int nj = j + move[dd][1];
                        if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                        if(!visited[ni][nj] && value == map[ni][nj]){
                            visited[ni][nj] = true;
                            q.offer(new int[]{ni,nj});
                        }
                    }
                }
            }else {
                switch (ch) {
                    case 'R':
                        d = 1;
                        break;
                    case 'D':
                        d = 2;
                        break;
                    case 'L':
                        d = 3;
                        break;
                }
                y += move[d][0]; x += move[d][1];
            }
        }
        visited[y][x] = true;
        for(int d=0;d<4;d++){
            int ni = y + move[d][0];
            int nj = x + move[d][1];
            if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
            visited[ni][nj] = true;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                sb.append(visited[i][j] ? '.' : '#');
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
