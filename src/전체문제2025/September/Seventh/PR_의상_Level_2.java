package 전체문제2025.September.Seventh;
import java.util.*;

public class PR_의상_Level_2 {
    public static void main(String[] args) {
        String[][]clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }
    static int solution(String[][] clothes) {
        int answer = 1;
        Map<String,Integer> map = new HashMap<>();
        for(String []str : clothes){
            map.put(str[1],map.getOrDefault(str[1],0)+1);
        }
        for(String str : map.keySet()){
            answer *= (map.get(str)+1);
        }
        answer--;
        return answer;
    }
}
