package 구현.맵;

import java.util.HashMap;
import java.util.Map;

public class PR_폰켓몬_Level_1 {
    static int solution(int[] nums) {
        int answer = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int N = nums.length;
        for(int i=0;i<N;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],0);
                answer++;
            }
            if(answer==(N/2)) break;
        }
        return answer;
    }

    public static void main(String[] args) {
        /*
        TEST CASE
        1.
        int [] nums = {3,1,2,3};

        int result = 2;

        2.
        int [] nums = {3,3,3,2,2,4};

        int result = 3;

        3.
        int [] nums = {3,3,3,2,2,2};

        int result = 2;

        * */
        int [] nums = {3,3,3,2,2,4};
        System.out.println(solution(nums));
    }
}
