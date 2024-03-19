package 전체문제.fourth_month_2024_03.fourteenth_2024_03_19;

import java.util.*;

public class PR_다단계칫솔판매_Level_3 {

    static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int N = enroll.length;
        int[] answer = new int[N];
        int M = seller.length;
        for(int i=0;i<M;i++) amount[i] *= 100;
        int idx = 0;
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<N;i++) map.put(enroll[i],idx++);
        int[]parents = new int[N+1];
        for(int i=0;i<N;i++){
            String str = referral[i];
            if(str.equals("-")) {
                parents[map.get(enroll[i])] = -1;
                continue;
            }
            parents[map.get(enroll[i])] = map.get(str);
        }
        for(int i=0;i<M;i++){
            int money = amount[i];
            int person = map.get(seller[i]);
            while(true){
                if((money/10) < 1) {
                    answer[person] += money;
                    break;
                }
                answer[person] += (money*9) / 10;
                if((money*9)%10!=0) answer[person]++;
                money /= 10;
                if(parents[person]==-1) break;
                person = parents[person];

            }
        }
        return answer;
    }
    public static void main(String[] args) {
        /*
        TEST CASE
        1.
        String[]enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[]referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[]seller = {"young", "john", "tod", "emily", "mary"};
        int[]amount = {12, 4, 2, 5, 10};
        int[]result = {360, 958, 108, 0, 450, 18, 180, 1080};

        2.
        String[]enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[]referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[]seller = {"sam", "emily", "jaimie", "edward"};
        int[]amount = {2, 3, 5, 4};
        int[]result = {0, 110, 378, 180, 270, 450, 0, 0};
        * */
        String[]enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[]referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[]seller = {"sam", "emily", "jaimie", "edward"};
        int[]amount = {2, 3, 5, 4};
        System.out.println(Arrays.toString(solution(enroll,referral,seller,amount)));
    }
}
