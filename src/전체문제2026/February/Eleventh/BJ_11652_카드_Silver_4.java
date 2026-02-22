package 전체문제2026.February.Eleventh;

import java.util.*;
import java.io.*;
public class BJ_11652_카드_Silver_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        TreeMap<Long,Integer> map = new TreeMap<>();
        for(int i=0;i<N;i++){
            Long num = Long.parseLong(br.readLine());
            map.put(num,map.getOrDefault(num,1)+1);
        }
        int max = 0;
        long answer = 0;
        for(Long num : map.keySet()){
            if(max<map.get(num)){
                answer = num;
                max = map.get(num);
            }
        }
        System.out.println(answer);
    }
}
