package 구현;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PR_주차요금계산_Level_2 {


    static int[] solution(int[] fees, String[] records) {
        TreeMap<String,Integer> ansMap = new TreeMap<>();
        Map<String,Integer> map = new HashMap<>();
        int size = records.length;
        for(int i=0;i<size;i++){
            String[]tmp = records[i].split(" ");
            int time = change(tmp[0]);
            String num = tmp[1];
            String act = tmp[2];
            if(act.equals("IN")) map.put(num,time);
            else{
                //주차요금계산
                int inTime = map.get(num);
                int takeTime = time - inTime;
                map.remove(num); //차 없애줌
                ansMap.put(num,ansMap.getOrDefault(num,0)+takeTime); //답에 더해줌
            }
        }
        for(String num : map.keySet()){
            int takeTime = (23*60) + 59 - map.get(num);
            ansMap.put(num,ansMap.getOrDefault(num,0)+takeTime);
        }
        int idx = 0;
        int[]answer= new int[ansMap.size()];
        //fees는 기본시간, 기본요금, 추가시간, 추가요금 순
        for(String num : ansMap.keySet()){
            int time = ansMap.get(num);
            int total = fees[1]; //기본 요금은 무조건
            time -= fees[0];
            if(time>0){
                total += (time/fees[2]) * fees[3];
                if(time%fees[2]!=0) total += fees[3];
            }
            answer[idx++] = total;
        }
        return answer;
    }
    static int change(String time){
        String[]tmp = time.split(":");
        return Integer.parseInt(tmp[0])*60 + Integer.parseInt(tmp[1]);
    }


    public static void main(String[] args) {

        /*
        TEST CASE
        1.
        int[]fees = {180, 5000, 10, 600};
        String[]records = {"05:34 5961 IN", "06:00 0000 IN",
         "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
         "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN",
         "23:00 5961 OUT"};

        int [] result = {14600, 34400, 5000};

        2.
        int[]fees = {120, 0, 60, 591};
        String[]records = {"16:00 3961 IN","16:00 0202 IN",
        "18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};

        int [] result = {0, 591};

        3.
        int[]fees = {1, 461, 1, 10};
        String[]records = {"00:00 1234 IN"};

        int [] result = {14841};
        * */
        int[]fees = {180, 5000, 10, 600};
        String[]records = {"05:34 5961 IN", "06:00 0000 IN",
                "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
                "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN",
                "23:00 5961 OUT"};
        System.out.println(Arrays.toString(solution(fees,records)));
    }
}
