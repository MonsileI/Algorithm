package 전체문제2026.February.Twelfth;

import java.util.*;
import java.io.*;
public class BJ_4358_생태학_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String,Integer> map = new TreeMap<>();
        int cnt = 0;
        while(true){
            String str = br.readLine();
            if(str==null) break;
            map.put(str,map.getOrDefault(str,0)+1);
            cnt++;
        }
        StringBuilder sb= new StringBuilder();
        for(String str : map.keySet()){
            double ans = (map.get(str) * 100.0) / cnt;
            sb.append(str)
                    .append(" ")
                    .append(String.format("%.4f", ans))
                    .append("\n");
        }
        System.out.println(sb.toString());
    }
}
