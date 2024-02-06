package 그리디.정렬;

import java.util.Arrays;

public class PR_구명보트_Level_2 {

    static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int N = people.length;
        int L = 0;
        int R = N-1;
        while(L<=R){
            if(L==R){
                answer++;
                break;
            }
            int sum = people[L]+people[R];
            if(sum<=limit){
                L++;
                R--;
            }else R--;
            answer++;
        }
        return answer;
    }
    public static void main(String[] args) {

        /*
        TEST CASE

        int[]people = {70, 50, 80, 50};
        int limit = 100;

        result = 3;

        int[]people = {70, 80, 50};
        int limit = 100;

        result = 3;

        * */
        int[]people = {70, 50, 80, 50};
        int limit = 100;
        System.out.println(solution(people,limit));
    }
}
