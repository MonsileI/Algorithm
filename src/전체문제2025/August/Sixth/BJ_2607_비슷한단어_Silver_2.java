package 전체문제2025.August.Sixth;

import java.util.*;
import java.io.*;
public class BJ_2607_비슷한단어_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][]alpha = new int[N][26];
        int[]len = new int[N];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<str.length();j++){
                alpha[i][str.charAt(j)-'A']++;
            }
            len[i] = str.length();
        }
        int answer = 0;
        for(int i=1;i<N;i++){
            boolean flag = true;
            int count = 0;
            if(1 < Math.abs(len[0] - len[i])){
                continue;
            }
            for(int j=0;j<26;j++){
                int diff = Math.abs(alpha[0][j] - alpha[i][j]);
                if(1 < diff){
                    flag = false;
                    break;
                }
                if(1 == diff){
                    if(1 < count){
                        flag= false;
                        break;
                    }
                    count++;
                }
            }
            if(flag) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
