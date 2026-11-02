package 전체문제2026.November.First;

import java.util.Arrays;

public class PR_이진변환반복하기_Level_2 {
    public static void main(String[] args) {
        String s=  "01110";
        System.out.println(Arrays.toString(solution(s)));
    }
    static int[] solution(String s) {
        int[]answer = new int[2];
        while(true){
            int one = 0;
            int N = s.length();
            for(int i=0;i<N;i++){
                if(s.charAt(i)=='1') one++;
            }
            answer[1] += N - one;
            // 1을 이진수로 변환
            String tmp = "";
            while(0<one){
                tmp += one%2;
                one /= 2;
            }
            s = tmp;
            answer[0]++;
            if(s.equals("1")) break;
        }
        return answer;
    }
}
