package 전체문제2026.November.First;

public class PR_택배배달과수거하기_Level_2 {
    public static void main(String[] args) {
        int cap = 4;
        int n = 5;
        int[]deliveries = {1, 0, 3, 1, 2};
        int[]pickups = {0, 3, 0, 4, 0};
        System.out.println(solution(cap,n,deliveries,pickups));
    }
    static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int d = 0; int p = 0;
        for(int i=n-1;-1<i;i--){
            d -= deliveries[i];
            p -= pickups[i];

            while(d<0 || p<0){
                d += cap;
                p += cap;
                answer += (i+1)*2;
            }
        }
        return answer;
    }

}
