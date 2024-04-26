package 전체문제.fifth_month_2023_04.eighteenth_2024_04_26;

import java.util.*;
import java.io.*;
public class BJ_26267_은행털자_Silver_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=  Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        Map<Integer,Long> map = new HashMap<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int x= Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map.put((t-x),map.getOrDefault((t-x),0L)+c);
        }
        long ans = 0;
        for(int key : map.keySet()){
            ans = Math.max(ans,map.get(key));
        }
        System.out.println(ans);
    }
}
