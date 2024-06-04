package 전체문제.seven_month_2024_06.second_2024_06_04;

import java.util.*;
import java.io.*;
public class BJ_3190_뱀_Gold_4 {
    static class Order {
        int second; int move;

        public Order(int second, int move) {
            this.second = second;
            this.move = move;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[][]map = new int[N][N];
        int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
        StringTokenizer st = null;
        for(int t=0;t<K;t++){
            st = new StringTokenizer(br.readLine()," ");
            int i = Integer.parseInt(st.nextToken())-1;
            int j = Integer.parseInt(st.nextToken())-1;
            map[i][j] = 2; //사과
        }
        K = Integer.parseInt(br.readLine());
        Order[]seconds = new Order[K];
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int d = st.nextToken().charAt(0)=='D' ? 1 : 3;
            seconds[i] = new Order(s,d);
        }
        map[0][0] = 1;
        int t = 0;
        int idx = 0;
        int i=0;int j=0; int d=1; //오른쪽
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{0,0});
        while(true){

            t++;

            int ni = i + move[d][0];
            int nj = j + move[d][1];
            if(ni<0||nj<0||N-1<ni||N-1<nj) break;
            if(map[ni][nj]==1) break;
            q.offer(new int[]{ni,nj});
            if(map[ni][nj]!=2) {
                int[]c = q.poll();
                map[c[0]][c[1]] = 0;
            }

            map[ni][nj] = 1;
            i = ni; j = nj;

            if(idx<K) {
                if (t == seconds[idx].second) d = (d + seconds[idx++].move) % 4;
            }
        }
        System.out.println(t);
    }
}
