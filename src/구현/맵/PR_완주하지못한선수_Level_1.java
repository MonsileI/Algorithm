package 구현.맵;

import java.util.HashMap;
import java.util.Map;

public class PR_완주하지못한선수_Level_1 {

    static String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Integer> map = new HashMap<>();
        for(String str : completion) map.put(str,map.getOrDefault(str,0)+1);
        for(String str : participant){
            if(!map.containsKey(str)) {
                answer = str;
                break;
            }
            if(map.get(str)==0){
                answer = str;
                break;
            }
            map.put(str,map.get(str)-1);
        }
        return answer;
    }

    public static void main(String[] args) {
        /*
        TEST CASE
        1.
        String [] participant = {"leo", "kiki", "eden"};
        String [] complition = {"eden", "kiki"};

        String return "leo";

        2.
        String [] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String [] complition = {"josipa", "filipa", "marina", "nikola"};

        String return "vinko";

        3.
        String [] participant = {"mislav", "stanko", "mislav", "ana"};
        String [] complition = {"stanko", "ana", "mislav"};

        String return "mislav";
        * */
        String [] participant = {"mislav", "stanko", "mislav", "ana"};
        String [] complition = {"stanko", "ana", "mislav"};
        System.out.println(solution(participant,complition));

    }
}
