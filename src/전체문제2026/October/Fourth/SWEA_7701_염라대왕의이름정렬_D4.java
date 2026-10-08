package 전체문제2026.October.Fourth;

import java.util.*;
import java.io.*;
public class SWEA_7701_염라대왕의이름정렬_D4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=  new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            int N = Integer.parseInt(br.readLine());
            List<String> list = new ArrayList<>();
            for(int i=0;i<N;i++) list.add(br.readLine());
            Collections.sort(list,(o1,o2) -> o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length());
            Set<String> set = new HashSet<>();
            sb.append("#"+t+"\n");
            for(String str : list){
                if(set.contains(str)) continue;
                set.add(str);
                sb.append(str+"\n");
            }
        }
        System.out.println(sb.toString());
    }
}
