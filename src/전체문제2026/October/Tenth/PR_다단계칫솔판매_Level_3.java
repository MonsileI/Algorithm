package 전체문제2026.October.Tenth;

import java.util.*;

public class PR_다단계칫솔판매_Level_3 {
    public static void main(String[] args) {
        String [] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String [] referer = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String [] seller = {"young", "john", "tod", "emily", "mary"};
        int[]amount = {12, 4, 2, 5, 10};
        System.out.println(Arrays.toString(solution(enroll,referer,seller,amount)));
    }
    static  int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int N = enroll.length;
        Map<String,Integer> amountMap = new HashMap<>(); // 총 액
        Map<String,String> parentMap = new HashMap<>();//부모
        for(int i=0;i<N;i++){
            parentMap.put(enroll[i],referral[i]);
            amountMap.put(enroll[i],0);
        }
        int sellSize = seller.length;
        for(int i=0;i<sellSize;i++){
            amount[i] *= 100;
            int last = amount[i]/10;
            int cost = amount[i];
            String p = seller[i];
            amountMap.put(p,amountMap.get(p) + cost - last);
            if(last==0) {
                continue;
            }
            if(parentMap.get(p).equals("-")) continue;
            cost = last;
            p = parentMap.get(p);
            while(true){
                last = cost/10;
                amountMap.put(p,amountMap.get(p) + cost - last);
                if(last==0){
                    break;
                }
                cost = last;
                p = parentMap.get(p);
                if(p.equals("-")) break;
            }
        }
        int[]answer = new int[N];
        for(int i=0;i<N;i++){
            answer[i] = amountMap.get(enroll[i]);
        }
        return answer;
    }
}
