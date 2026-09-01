package 전체문제2026.August.First;

import java.util.*;
public class PR_롤케이크자르기_Level_2 {
    public static void main(String[] args) {
        int[]topping = {1,2,3,1,2,3,1,2};
        System.out.println(solution(topping));
    }
    static int solution(int[] topping) {
        int answer = 0;
        int N = topping.length;
        int sum = 0;
        int[] rightArr = new int[10001];
        for(int i=0;i<N;i++){
            if(rightArr[topping[i]]==0) sum++;
            rightArr[topping[i]]++;
        }
        int left = 0;
        int right = sum;
        int[]leftArr = new int[10001];
        for (int i = 0; i < N; i++) {
            if(left==right) answer++;
            rightArr[topping[i]]--;
            if (rightArr[topping[i]] == 0) {
                right--;
            }
            if(leftArr[topping[i]]==0){
                left++;
            }
            leftArr[topping[i]]++;
        }
        return answer;
    }
}
