package 전체문제2026.February.Fourth;

import java.util.*;
import java.io.*;
public class BJ_1581_락스타락동호_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int FF = Integer.parseInt(st.nextToken());
        int FS = Integer.parseInt(st.nextToken());
        int SF = Integer.parseInt(st.nextToken());
        int SS = Integer.parseInt(st.nextToken());
        int answer = 0;
        if(FF == 0 && FS == 0) answer = SS + Math.min(SF, 1);
        else if(FS == 0) answer = FF;
        else if(FS > SF) answer = 2*SF + 1 + SS + FF;
        else answer = 2*FS + SS + FF;
        System.out.println(answer);
    }
}
