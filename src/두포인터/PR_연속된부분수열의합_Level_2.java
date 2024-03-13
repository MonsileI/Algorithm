package 두포인터;

import java.util.Arrays;

public class PR_연속된부분수열의합_Level_2 {
    static int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int N = sequence.length;
        for(int i=0;i<N;i++){
            if(sequence[i]==k){
                return new int[]{i,i};
            }
        }
        int L = 0; int R = 0;
        int min = N;
        int sum = sequence[L];
        while(R<N){
            if(sum<=k){
                if(sum==k){
                    if(R-L<min){
                        min = R-L;
                        answer[0] = L;
                        answer[1] = R;
                    }
                }
                if(R==N-1) break;
                sum += sequence[++R];
            }else{
                sum -= sequence[L++];
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        /*
        TEST CASE
        1.
        int[]sequence = {1, 2, 3, 4, 5};
        int k = 7;
        int [] result = {2,3};

        2.
        int[]sequence = {1, 1, 1, 2, 3, 4, 5};
        int k = 5;
        int [] result = {6,6};

        3.
        int[]sequence = {2, 2, 2, 2, 2};
        int k = 6;
        int [] result = {2,2};
        * */
        int[]sequence = {2, 2, 2, 2, 2};
        int k = 6;
        System.out.println(Arrays.toString(solution(sequence,k)));

    }
}
