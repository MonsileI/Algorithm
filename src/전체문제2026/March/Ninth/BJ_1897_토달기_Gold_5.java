package 전체문제2026.March.Ninth;

import java.util.*;
import java.io.*;
public class BJ_1897_토달기_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String start = st.nextToken();

        String[] words = new String[N];
        for(int i=0;i<N;i++) words[i] = br.readLine();

        Arrays.sort(words, Comparator.comparingInt(String::length));

        HashSet<String> set = new HashSet<>();
        set.add(start);

        String answer = start;

        for(String w : words){

            for(int i=0;i<w.length();i++){

                String prev = w.substring(0,i) + w.substring(i+1);

                if(set.contains(prev)){
                    set.add(w);

                    if(w.length() > answer.length()){
                        answer = w;
                    }

                    break;
                }
            }
        }

        System.out.println(answer);
    }
}