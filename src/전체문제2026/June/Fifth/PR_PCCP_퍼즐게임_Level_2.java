package 전체문제2026.June.Fifth;

public class PR_PCCP_퍼즐게임_Level_2 {
    public static void main(String[] args) {
        int[]diffs = {1, 5, 3};
        int[]times = {2, 4, 7};
        int limit = 30;
        System.out.println(solution(diffs,times,limit));
    }
    static int []Diffs;
    static int []Times;
    static int solution(int[] diffs, int[] times, long limit) {
        int L = 0;
        int R = 0;
        Diffs = diffs; Times = times;
        for(int i=0;i<diffs.length;i++) R = Math.max(R,diffs[i]);
        while(L<=R){
            int mid = (L+R)/2;
            if(calc(mid)<=limit) R = mid-1;
            else L = mid+1;
        }
        return L;
    }
    static long calc(int level){
        long sum = 0;
        for(int i=0;i<Diffs.length;i++){
            if(Diffs[i]<=level) sum += Times[i];
            else {
                sum += Times[i];
                int cnt = Diffs[i] - level;
                sum += cnt * Times[i];
                if (i != 0) {
                    sum += cnt * Times[i - 1];
                }
            }
        }
        return sum;
    }
}
