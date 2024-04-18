package 전체문제.fifth_month_2023_04.eleventh_2024_04_17;

import java.util.*;
import java.io.*;
public class BJ_1235_학생번호_Silver_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[]str = new String[N];
        for(int i=0;i<N;i++)str[i] = br.readLine();
        int n = 1;
        Map<String,Integer> map;
        OuterLoop:
        while(true){
            map = new HashMap<>();
            for(int i=0;i<N;i++){
                if(map.containsKey(str[i].substring(str[i].length()-n))){
                    n++;
                    continue OuterLoop;
                }
                map.put(str[i].substring(str[i].length()-n),0);
            }
            break;
        }
        System.out.println(n);
    }
}
