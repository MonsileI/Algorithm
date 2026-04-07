package 전체문제2026.April.Fourth;

import java.util.*;
import java.io.*;
public class BJ_3020_개똥벌레_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        boolean flag = true;
        int[]leftH = new int[H+1];
        int[]rightH = new int[H+1];
        for(int i=0;i<N;i++){
            int high = Integer.parseInt(br.readLine());
            if(flag){
                leftH[high]++;
            }else{
                rightH[high]++;
            }

            flag = !flag;

        }
        for(int i=H-1;0<i;i--){
            leftH[i] += leftH[i+1];
            rightH[i] += rightH[i+1];
        }
        int min = Integer.MAX_VALUE;
        for(int i=1;i<H+1;i++){
            min = Math.min(min,(leftH[i] + rightH[H-i+1]));
        }
        int ans = 0;
        for(int i=1;i<H+1;i++){
            if(min==leftH[i]+rightH[H-i+1]) ans++;
        }
        System.out.println(min+" "+ans);
    }
}
