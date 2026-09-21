package 전체문제2026.September.Ninth;

import java.util.*;
public class PR_혼자놀기의달인_Level_2 {
    public static void main(String[] args)  {
        int[]cards = {8,6,3,7,2,5,1,4};
        System.out.println(solution(cards));
    }
    static int solution(int[] cards) {
        int N = cards.length;
        int[]CARD = new int[N+1];
        for(int i=1;i<=N;i++) CARD[i] = cards[i-1];
        boolean[]isOpened = new boolean[N+1];
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=N;i++) {
            if(isOpened[i]) continue;
            isOpened[i] = true;
            int idx = CARD[i];
            int sum = 1;
            while(true){
                if(isOpened[idx]) break;
                isOpened[idx] = true;
                idx = CARD[idx];
                sum++;
            }
            list.add(sum);
        }
        int answer =0 ;
        Collections.sort(list);
        if(1<list.size()) answer = list.get(list.size()-1) * list.get(list.size()-2);
        return answer;
    }

}
