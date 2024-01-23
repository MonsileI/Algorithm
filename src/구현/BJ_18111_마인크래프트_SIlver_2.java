package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_18111_마인크래프트_SIlver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int I = Integer.parseInt(st.nextToken());
        int[][]map = new int[N][M];
        for(int i=0;i<N;i++){
            st =new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 987654321; int ansHigh = 0;

        OuterLoop:
        for(int t=0;t<257;t++){

            int high = t;
            int tmpI = I;
            int time = 0;

            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(ans<time) continue OuterLoop;
                    if(map[i][j]==high) continue;
                    if(map[i][j]<high){
                        tmpI -= (high - map[i][j]);
                        time += (high - map[i][j]);
                    }else{
                        tmpI += (map[i][j] - high);
                        time += (map[i][j] - high) * 2;
                    }
                }
            }
            if(tmpI<0) continue OuterLoop;
            if(ans<time) continue OuterLoop;
            ans = time; ansHigh = high;
        }
        System.out.println(ans+" "+ansHigh);
    }
}
