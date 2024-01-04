package 전체문제.second_month_2024_01.third_2024_01_04;
import java.util.*;
import java.io.*;
public class BJ_16918_봄버맨_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        if(T%2==0){
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    sb.append('O');
                }
                sb.append("\n");
            }
        }else{
            char[][] map = new char[N][M];
            int[][]dir = {{-1,0},{0,1},{1,0},{0,-1}};
            Queue<int[]> q= new ArrayDeque<>();
            for(int i=0;i<N;i++){
                String str =br.readLine();
                for(int j=0;j<M;j++){
                    map[i][j] = str.charAt(j);
                }
            }
            while(true){
                while(!q.isEmpty()){
                    int[]c = q.poll();
                    int i = c[0]; int j = c[1];
                    map[i][j] = '.';
                    for(int d=0;d<4;d++){
                        int ni = i + dir[d][0]; int nj = j + dir[d][1];
                        if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                        map[ni][nj] = '.';
                    }
                }
                T -= 2;
                if(T<1) break;
                for(int i=0;i<N;i++) {
                    for (int j = 0; j < M; j++) {
                        if (map[i][j] == 'O') q.offer(new int[]{i, j});
                        map[i][j] = 'O';
                    }
                }
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
