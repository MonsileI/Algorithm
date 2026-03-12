package 전체문제2026.March.Sixth;

import java.util.*;
import java.io.*;
public class BJ_2535_아시아정보올림피아드_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int[]nation = new int[101];
        int[][]student = new int[N][3];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            student[i][0] = Integer.parseInt(st.nextToken());
            student[i][1] = Integer.parseInt(st.nextToken());
            student[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(student,(o1,o2) -> -(o1[2]-o2[2]));
        int cnt = 0;
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            if(cnt==3) break;
            int country = student[i][0];
            int num = student[i][1];
            if(1<nation[country]) continue;
            sb.append(country+" "+num+"\n");
            nation[country]++;
            cnt++;
        }
        System.out.println(sb.toString());

    }
}
