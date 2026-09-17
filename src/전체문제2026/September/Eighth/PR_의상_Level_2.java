package 전체문제2026.September.Eighth;

import java.util.*;

public class PR_의상_Level_2 {
    public static void main(String[] args) {
        String[][]clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        System.out.println(solution(clothes));
    }
    static int solution(String[][] clothes) {
        Map<String,Integer> map = new HashMap<>();
        for(String[]str : clothes){
            map.put(str[1],map.getOrDefault(str[1],0)+1);
        }
        int answer = 1;
        for(String key : map.keySet()){
            answer *= (map.get(key)+1);
        }
        answer--;
        return answer;
    }
}
