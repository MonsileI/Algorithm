package 전체문제2026.March.Tenth;

import java.util.*;
import java.io.*;
public class BJ_1501_영어읽기_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<N;i++){
            String str = br.readLine();
            String tmp = makeKey(str);
            map.put(tmp,map.getOrDefault(tmp,0)+1);
        }
        int TC = Integer.parseInt(br.readLine());
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<TC;t++){
            String []str = br.readLine().split(" ");
            answer = 0;
            for(int i=0;i<str.length;i++){
                String tmp = makeKey(str[i]);
                if(!map.containsKey(tmp)){
                    answer=  0;
                    break;
                }
                if(answer==0) answer = map.get(tmp);
                else answer *= map.get(tmp);
            }
            sb.append(answer+"\n");
        }
        System.out.println(sb.toString());
    }
    static String makeKey(String word){
        if(word.length() <= 2) return word;

        char first = word.charAt(0);
        char last = word.charAt(word.length()-1);

        char[] mid = word.substring(1,word.length()-1).toCharArray();
        Arrays.sort(mid);

        return first + String.valueOf(mid) + last;
    }
}
