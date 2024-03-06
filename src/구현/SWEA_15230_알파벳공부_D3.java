package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_15230_알파벳공부_D3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        for(int t=1;t<=TC;t++){
            String str = br.readLine();
            int N = str.length();
            int idx = 'a';
            for(int i=0;i<N;i++){
                int ch = str.charAt(i);
                if(ch!=idx) break;
                idx++;
            }
            sb.append("#"+t+" "+(idx-'a')+"\n");
        }
        System.out.println(sb.toString());
    }
}
