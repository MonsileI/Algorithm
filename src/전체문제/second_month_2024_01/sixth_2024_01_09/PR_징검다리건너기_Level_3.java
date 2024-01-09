package 전체문제.second_month_2024_01.sixth_2024_01_09;

public class PR_징검다리건너기_Level_3 {

    static int N,K;
    static int []arr;
    static int solution(int[] stones, int k) {

        int L = 0; int R = 200000000;
        arr = stones;
        N = stones.length;
        K = k;
        while(L<R){
            int mid = (L+R)/2;
            if(calc(mid)) L = mid+1;
            else R = mid;
        }

        return L-1;
    }
    static boolean calc(int mid){
        int tmp = 0;
        for(int i=0;i<N;i++){
               if(mid>arr[i]) tmp++;
               else tmp = 0;
               if(tmp==K) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        /*
        TEST CASE
        int[]stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        int result = 3;
        * */
        int[]stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        System.out.println(solution(stones,k));
    }
}

