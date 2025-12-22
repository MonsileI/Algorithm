package 전체문제2025.December.Seventh;

import java.util.*;

public class PR_다단계칫솔판매_Level_3 {

    static Map<String,String> map;
    static Map<String,Integer> idxMap;
    static int[]answer;
    public static void main(String[] args) {
        String[]enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[]referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[]seller = {"young", "john", "tod", "emily", "mary"};
        int[]amount = {12, 4, 2, 5, 10};
        System.out.println(Arrays.toString(solution(enroll,referral,seller,amount)));
    }
    static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int len = enroll.length;
        answer = new int[len];
        map = new HashMap<>();
        idxMap = new HashMap<>();
        for(int i=0;i<len;i++){
            if(referral[i].equals("-")) map.put(enroll[i],null);
            else map.put(enroll[i],referral[i]);
            idxMap.put(enroll[i],i);
        }
        for(int i=0;i<seller.length;i++){
            dfs(seller[i],(amount[i]*100));
        }
        return answer;
    }
    static void dfs(String name,int amount){
        //1 이하면 자기가 먹기
        if(amount<1){
            answer[idxMap.get(name)] += amount;
            return;
        }
        //90% 계산
        int num = (amount/10);
        int mine = amount - num;

        //루트면 자기가 먹기
        if(map.get(name) == null){
            answer[idxMap.get(name)] += mine;
            return;
        }
        answer[idxMap.get(name)] += mine;
        dfs(map.get(name),num);
    }
}
