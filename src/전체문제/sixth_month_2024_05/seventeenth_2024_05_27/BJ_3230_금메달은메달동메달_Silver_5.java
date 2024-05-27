package 전체문제.sixth_month_2024_05.seventeenth_2024_05_27;

import java.util.*;
import java.io.*;
public class BJ_3230_금메달은메달동메달_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(Integer.parseInt(br.readLine()));
        for(int i=2;i<N+1;i++){
            int num = Integer.parseInt(br.readLine());
            list.add(num,i);
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        ans.add(list.get(M));
        br.readLine();
        for(int i=2;i<M+1;i++){
            int num = Integer.parseInt(br.readLine());
            int pos = list.get(M-i+1);
            ans.add(num,pos);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<4;i++) sb.append(ans.get(i)+"\n");
        System.out.println(sb.toString());
    }
}
