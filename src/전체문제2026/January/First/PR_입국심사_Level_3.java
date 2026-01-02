package 전체문제2026.January.First;

public class PR_입국심사_Level_3 {
    public static void main(String[] args) {
        int n =6;
        int[]times = {7,10};
        System.out.println(solution(n,times));
    }
    static  long solution(int n, int[] times) {
        long L =1; long R = 0;
        int len = times.length;
        for(int i=0;i<len;i++) {
            R = Math.max(R,times[i]);
        }
        R *= n;
        while(L<R){
            long mid = (L+R)/2;
            long cnt = 0;
            for(int i=0;i<len;i++){
                cnt += mid/times[i];
            }
            if(cnt<n)L=mid+1;
            else R = mid;
        }
        return L;
    }

}
