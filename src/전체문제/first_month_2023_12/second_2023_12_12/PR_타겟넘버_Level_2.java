package 전체문제.first_month_2023_12.second_2023_12_12;

public class PR_타겟넘버_Level_2 {
    static int answer;
    static int N;
    static int [] NUMBERS;
    static int T;
    static int solution(int[] numbers, int target) {

        N = numbers.length;
        T = target;
        NUMBERS = numbers;
        subset(0,0);
        return answer;

    }
    static void subset(int depth,int sum){
        if(depth==N){
            if(T==sum) answer++;
            return;
        }
        subset(depth+1,sum+NUMBERS[depth]);
        subset(depth+1,sum-NUMBERS[depth]);
    }

    public static void main(String[] args) {
        //Test Case
        //1. int [] numbers = {1,1,1,1,1}; int target = 3; -> 5;
        //2. int [] numbers = {4,1,2,1}; int target = 4; -> 2;
        int [] numbers = {4,1,2,1}; int target = 4;
        System.out.println(solution(numbers,target));

    }
}

