package 전체문제2026.November.Fifth;

public class PR_징검다리건너기_Level_3 {
    public static void main(String[] args) {
        int[]stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        System.out.println(solution(stones,k));
    }
    static int N;
    static int []STONE;
    static int K;
    static int solution(int[] stones, int k) {
        int answer = 0;
        STONE = stones;
        K = k;
        N = stones.length;
        int L = 1; int R = 0;
        for(int i=0;i<N;i++){
            R = Math.max(R,stones[i]);
        }
        R++;
        while(L<R){
            int mid = (L+R)/2;
            if(calc(mid)) L = mid+1;
            else R = mid;
        }
        answer = L-1;
        return answer;
    }
    static boolean calc(int mid){
        int cnt = 0;
        for(int i=0;i<N;i++){
            if(STONE[i]<mid){
                cnt++;
            }else{
                cnt = 0;
            }
            if(K<=cnt) return false;
        }
        return true;
    }
}
