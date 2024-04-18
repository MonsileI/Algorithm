package 전체문제.fifth_month_2023_04.eleventh_2024_04_17;

import java.util.*;
import java.io.*;
public class BJ_1302_베스트셀러_Silver_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        TreeMap<String,Integer> map = new TreeMap<>();
        for(int i=0;i<N;i++){
            String str = br.readLine();
            map.put(str,map.getOrDefault(str,0)+1);
        }
        int max = 0;
        String str = "";
        for(String key : map.keySet()){
            if(max<map.get(key)) {
                max = map.get(key);
                str = key;
            }
        }
        System.out.println(str);
    }
}
