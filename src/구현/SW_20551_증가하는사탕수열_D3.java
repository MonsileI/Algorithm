package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class SW_20551_증가하는사탕수열_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb= new StringBuilder();
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            int[]arr= new int[3];
            for(int i=0;i<3;i++)arr[i] = Integer.parseInt(st.nextToken());
            int ans = 0;
            for(int i=2;0<i;i--){
                if(arr[i]==1) {
                    ans = -1;
                    break;
                }
                //10 9 7
                if(arr[i]>arr[i-1]) continue;
                int tmp = (arr[i-1]-arr[i]);
                ans += (tmp+1);
                arr[i-1] = arr[i]-1;
            }
            sb.append("#"+t+" "+ans+"\n");
        }
        System.out.println(sb.toString());

    }
}
