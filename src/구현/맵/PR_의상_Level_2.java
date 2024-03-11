package 구현.맵;

import java.util.HashMap;
import java.util.Map;
public class PR_의상_Level_2 {
    static int solution(String[][] clothes) {
        int answer = 1;
        Map<String,Integer> map = new HashMap<>();
        for(String []str : clothes){
            map.put(str[1],map.getOrDefault(str[1],0)+1);
        }

        for(String key : map.keySet()){
            answer *= (map.get(key)+1);
        }
        answer--;
        return answer;
    }

    public static void main(String[] args) {
        /*
        TEST CASE
        1.
        String[][]clothes = {{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}};

        int answer  =5;

        String[][]clothes = {{"crow_mask", "face"},{"blue_sunglasses", "face"},{"smoky_makeup", "face"}};

        int answer  =3;
        * */
        String[][]clothes = {{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }
}
