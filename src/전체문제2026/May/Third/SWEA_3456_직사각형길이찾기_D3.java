package 전체문제2026.May.Third;

import java.util.*;
import java.io.*;
public class SWEA_3456_직사각형길이찾기_D3  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= TC; t++)
        {
            st = new StringTokenizer(br.readLine()," ");
            int f= Integer.parseInt(st.nextToken());
            int s= Integer.parseInt(st.nextToken());
            int th= Integer.parseInt(st.nextToken());
            int answer = 0;
            if(f==s) answer = th;
            else if(f==th) answer = s;
            else if(s==th) answer = f;
            sb.append("#"+t+" "+answer+"\n");

        }
        System.out.println(sb.toString());
    }
}