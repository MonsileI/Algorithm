package 구현.누적합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1531_투명_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        int[][]map = new int[102][102];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            map[y1][x1] += 1;
            map[y1][x2+1] -= 1;
            map[y2+1][x1] -= 1;
            map[y2+1][x2+1] += 1;
        }
        for(int i=0;i<102;i++){
            for(int j=1;j<102;j++){
                map[i][j] += map[i][j-1];
            }
        }
        for(int j=0;j<102;j++){
            for(int i=1;i<102;i++){
                map[i][j] += map[i-1][j];
            }
        }
        int sum = 0;
        for(int i=0;i<102;i++){
            for(int j=0;j<102;j++){
                if(map[i][j]>M)sum++;
            }
        }
        System.out.println(sum);

    }
}
