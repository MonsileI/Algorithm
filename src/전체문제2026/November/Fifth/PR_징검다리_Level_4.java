package 전체문제2026.November.Fifth;

import java.util.Arrays;

public class PR_징검다리_Level_4 {
    public static void main(String[] args) {
        int distance = 25;
        int []rocks = {2, 14, 11, 21, 17};
        int n = 2;
        System.out.println(solution(distance,rocks,n));
    }
    static int[]ROCK;
    static int N;
    static int DISTANCE;
    static int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        DISTANCE= distance;
        N = rocks.length;
        ROCK = rocks;
        Arrays.sort(ROCK);
        int L = 0; int R = distance;
        while(L <= R) {
            int mid = (L + R) / 2;

            if(calc(mid) <= n) {
                answer = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return answer;
    }
    static int calc(int mid){
        int cnt = 0;
        int before = 0;
        for(int i=0;i<N;i++){
            //거리가 mid 보다 짧으니까 제거해줌 (before는 그대로)
            if(ROCK[i]-before < mid){
                cnt++;
            }else{
            //거리가 mid보다 기니까 돌 제거 안함
                before = ROCK[i];
            }
        }
        if(DISTANCE - before < mid) {
            cnt++;
        }
        return cnt;
    }
}
