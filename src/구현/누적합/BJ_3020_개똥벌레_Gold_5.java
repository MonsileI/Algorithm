package 구현.누적합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3020_개똥벌레_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[]down = new int[H+1];
        int[]up = new int[H+1];
        for(int i=0;i<N/2;i++){
            down[Integer.parseInt(br.readLine())]++;
            up[Integer.parseInt(br.readLine())]++;
        }
        int[]total = new int[H+1];
        int min = Integer.MAX_VALUE;
        for(int i=H-1;0<i;i--){
            down[i] += down[i+1];
            up[i] += up[i+1];
        }
        for(int i=1;i<H+1;i++){
            total[i] = down[i] + up[H-i+1];
            min = Math.min(min,total[i]);
        }
        int cnt = 0;
        for(int i=1;i<H+1;i++){
            if(total[i]==min) cnt++;
        }
        System.out.println(min+" "+cnt);
    }
}
