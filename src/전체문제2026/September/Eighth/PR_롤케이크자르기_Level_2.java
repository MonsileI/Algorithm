package 전체문제2026.September.Eighth;


import java.util.Arrays;

public class PR_롤케이크자르기_Level_2 {
    public static void main(String[] args) {
        int[]topping= {1, 2, 1, 3, 1, 4, 1, 2};
        System.out.println(solution(topping));
    }
    static int solution(int[] topping) {
        boolean[]leftVisited=  new boolean[100001];
        boolean[]rightVisited=  new boolean[100001];
        int N = topping.length;
        int[]leftCnt = new int[N];
        int[]rightCnt = new int[N];
        int left = 0; int right = 0;
        for(int i=0;i<N;i++){
            if(!leftVisited[topping[i]]){
                leftVisited[topping[i]] = true;
                left++;
            }
            if(!rightVisited[topping[N-i-1]]){
                rightVisited[topping[N-i-1]] = true;
                right++;
            }
            leftCnt[i] = left; rightCnt[N-i-1] = right;
        }
        int answer = 0;
        for(int i=0;i<N-1;i++){
            if(leftCnt[i] == rightCnt[i+1]) answer++;
        }

        return answer;
    }
}
