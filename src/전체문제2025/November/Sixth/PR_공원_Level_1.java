package 전체문제2025.November.Sixth;

import java.util.*;

public class PR_공원_Level_1 {
    public static void main(String[] args) {
        int[]mats = {5,3,2};
        String[][] park = {{"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}};
        System.out.println(solution(mats,park));
    }

    static int solution(int[] mats, String[][] park) {
        int answer = -1;
        int N = park.length;
        int M = park[0].length;
        int[][]dp = new int[N][M];
        for(int i=0;i<N;i++) {
            if(park[i][0].equals("-1")) dp[i][0] = 1;
        }
        for(int j=0;j<M;j++){
            if(park[0][j].equals("-1")) dp[0][j] = 1;
        }
        int max = 0;
        for(int i=1;i<N;i++){
            for(int j=1;j<M;j++){
                if(!park[i][j].equals("-1")) continue;
                dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                max = Math.max(max,dp[i][j]);
            }
        }
        Integer[] arr = Arrays.stream(mats).boxed().toArray(Integer[]::new);
        Arrays.sort(arr,(o1,o2)-> -(o1-o2));
        for(int i=0;i<arr.length;i++){
            if(arr[i] <= max){
                answer = arr[i];
                break;
            }
        }
        return answer;
    }
}
