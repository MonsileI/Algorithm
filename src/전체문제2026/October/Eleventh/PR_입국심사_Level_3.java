package 전체문제2026.October.Eleventh;

public class PR_입국심사_Level_3 {
    public static void main(String[] args) {
        int n =6;
        int [] times = {7,10};
        System.out.println(solution(n,times));
    }
    static int len;
    static int [] timeTable;
    static  long solution(int n, int[] times) {
        long answer = 0;
        timeTable = times;
        len = times.length;
        long L = 0; long R = 0;
        for(int i=0;i<len;i++) R = Math.max(R,times[i]);
        R *= n;
        while(L<R){
            long mid = (L+R)/2;
            if(calc(mid)<n) L = mid+1;
            else R = mid;
        }
        return L;
    }
    // 단일 시간안에 해결할 수 있는 사람 수
    static long calc(long mid){
        long cnt = 0;
        for(int i=0;i<len;i++){
            cnt += mid/(timeTable[i]);
        }
        return cnt;

    }
}
