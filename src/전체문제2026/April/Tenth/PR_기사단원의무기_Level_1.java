package 전체문제2026.April.Tenth;

import java.util.Arrays;

public class PR_기사단원의무기_Level_1 {
    public static void main(String[] args) {
        int number = 10;
        int limit = 3;
        int power = 2;
        System.out.println(solution(number,limit,power));
    }
    static int solution(int number, int limit, int power) {
        int answer = calc(number,limit,power);
        return answer;
    }
    static int calc(int number,int limit,int power){
        int result = 0;
        for(int i=1;i<=number;i++){
            int sum = 1;
            for(int j=1;j<=(i/2);j++){
                if(i%j==0) sum++;
            }
            if(sum<=limit) result += sum;
            else result += power;
        }
        return result;
    }
}
