package 전체문제2026.February.Twelfth;

import java.util.*;
import java.io.*;
public class BJ_31834_미로탈출_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb=  new StringBuilder();
        while(0<TC){
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int ans = 0;
            if(N<3){
                sb.append(ans+"\n");
                TC--;
                continue;
            }
            if(Math.abs(S-E)==1){
                ans = 1;
                sb.append(ans+"\n");
                TC--;
                continue;
            }
            if(S<E){
                if(S==1 && E==N) ans = 0;
                if(S!=1 && E==N) ans = 2;
                if(S==1 && E!=N) ans = 1;
                if(S!=1 && E!=N) ans = 2;
            }else{
                if(S==N && E==1) ans = 0;
                if(S!=N && E==1) ans = 2;
                if(S==N && E!=1) ans = 1;
                if(S!=N && E!=1) ans = 2;
            }
            sb.append(ans+"\n");
            TC--;
        }
        System.out.println(sb.toString());

    }
}
