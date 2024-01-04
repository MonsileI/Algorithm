package 이진탐색;

public class PR_징검다리건너기_Level_3 {

    static int[]arr;
    static int N,K;
    static int solution(int[] stones, int k) {
        int L = 0;
        int R = 200000000;
        arr = stones;
        N = stones.length;
        K = k;
        while(L<R){
            int mid = (L+R)/2;
            if(check(mid)) L=mid+1;
            else R = mid;
        }
        return L-1;
    }
    static boolean check(int mid){
        int tmp = 0;
        for(int i =0;i<N;i++){
            if(arr[i]<mid) tmp++;
            else tmp = 0;
            if(tmp==K) return false;
        }

        return true;
    }

    public static void main(String[] args) {

        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        System.out.println(solution(stones,k));
    }
}
