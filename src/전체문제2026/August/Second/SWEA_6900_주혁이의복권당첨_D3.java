package 전체문제2026.August.Second;

import java.util.*;
import java.io.*;
public class SWEA_6900_주혁이의복권당첨_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        int len = 8;
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            String[]num = new String[N];
            int[]price = new int[N];
            for(int i=0;i<N;i++){
                st= new StringTokenizer(br.readLine()," ");
                num[i] = st.nextToken();
                price[i] = Integer.parseInt(st.nextToken());
            }
            int answer = 0;

            for(int i=0;i<M;i++){
                String myNum = br.readLine();
                for(int j=0;j<N;j++){
                    boolean flag = true;
                    for(int l=0;l<len;l++){
                        if(num[j].charAt(l)=='*') continue;
                        if(num[j].charAt(l)!=myNum.charAt(l)){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        answer += price[j];
                    }
                }
            }


            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
}
