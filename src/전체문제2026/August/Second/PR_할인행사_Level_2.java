package 전체문제2026.August.Second;

import java.util.*;

public class PR_할인행사_Level_2 {
    public static void main(String[] args) {
        String [] want = {"banana", "apple", "rice", "pork", "pot"};
        int[]number = {3,2,2,2,1};
        String [] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        System.out.println(solution(want,number,discount));
    }
    static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String,Integer> myMap = new HashMap<>();
        int total = 0;
        for(int i=0;i<want.length;i++){
            myMap.put(want[i],number[i]);
            total += number[i];
        }
        //10까지 이후 한개씩 늘리면서 왼쪽 값은 줄여가기
        for(int i=0;i<10;i++){
            if(myMap.containsKey(discount[i])){
                if(0<myMap.get(discount[i]))  total--;
                myMap.put(discount[i],myMap.get(discount[i])-1);
            }
        }
        int idx = 0;
        for(int i=10;i<discount.length;i++){
            if(total==0) answer++;
            if(myMap.containsKey(discount[i])){
                if(0<myMap.get(discount[i])) total--; //0 이상일때만 -1
                myMap.put(discount[i],myMap.get(discount[i])-1);
            }
            if(myMap.containsKey(discount[idx])){
                if(-1<myMap.get(discount[idx])) total++;   //0 이상일때만 +1
                myMap.put(discount[idx],myMap.get(discount[idx])+1);
            }
            idx++;
        }
        if(total==0) answer++;
        return answer;
    }
}
