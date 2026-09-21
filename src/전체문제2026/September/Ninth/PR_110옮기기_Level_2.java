package 전체문제2026.September.Ninth;

import java.util.*;
import java.io.*;
public class PR_110옮기기_Level_2 {
    public static void main(String[] args) throws Exception {
        String[] s= {"1110","100111100","0111111010"};
        System.out.println(Arrays.toString(solution(s)));
    }
    static String[] solution(String[] s) {
        String[] answer = new String[s.length];
        // 앞에서 부터 돌면서 0을 만나면, i0 i1체크 후 옮기기
        StringBuilder sb = null;
        for(int c=0;c<s.length;c++){
            int N = s[c].length();
            sb = new StringBuilder();
            int cnt = 0;
            for(int i=0;i<N;i++) {
                char ch = s[c].charAt(i);
                sb.append(ch);
                int size = sb.length();
                if(3<=size){
                    if(sb.charAt(size-1)=='0' && sb.charAt(size-2)=='1' && sb.charAt(size-3)=='1'){
                        sb.setLength(size-3);
                        cnt++;
                    }
                }
            }
            int index = sb.lastIndexOf("0");
            sb.insert(index + 1, "110".repeat(cnt));
            answer[c] = sb.toString();

        }
        return answer;
    }
}
