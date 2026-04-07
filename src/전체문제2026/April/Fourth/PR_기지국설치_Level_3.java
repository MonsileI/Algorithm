package 전체문제2026.April.Fourth;

import java.util.Arrays;

public class PR_기지국설치_Level_3 {
    public static void main(String[] args) {
        int N = 16;
        int []stations = {9};
        int W = 2;
        System.out.println(solution(N,stations,W));
    }
    static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int range = (w * 2) + 1;
        int before = 1;
        for(int i : stations){
            int left = i - w;
            if(before<left){
                int gap = left - before;
                answer += (gap+range-1) / range;
            }
            before = i + w + 1;
        }
        if(before <= n){
            int gap = n - before + 1;
            answer += (gap + range - 1) / range;
        }
        return answer;
    }
}
