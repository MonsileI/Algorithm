package 전체문제2026.May.Seventh;

public class PR_타겟넘버_Level_2 {
    static int answer;
    static int N;
    static int []Numbers;
    static int Target;
    public static void main(String[] args) {
        int[]numbers = {1,1,1,1,1};
        int target = 3;
        System.out.println(solution(numbers,target));
    }
    static int solution(int[] numbers, int target) {
        answer = 0;
        Numbers = numbers;
        N = numbers.length;
        Target = target;
        sub(0,0);
        return answer;
    }
    static void sub(int depth,int sum){
        if(depth==N){
            if(sum==Target) answer++;
            return;
        }

        sub(depth+1,sum+Numbers[depth]);
        sub(depth+1,sum-Numbers[depth]);


    }
}
