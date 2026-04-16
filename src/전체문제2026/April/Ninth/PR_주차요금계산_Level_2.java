package 전체문제2026.April.Ninth;

import java.util.*;

public class PR_주차요금계산_Level_2 {
    public static void main(String[] args) {
        int[]fees = {33, 5000, 10, 300};
        String[]  records = {"00:00 1234 IN", "00:30 1234 OUT"};
        System.out.println(Arrays.toString(solution(fees,records)));
    }
    static int[] solution(int[] fees, String[] records) {
        //총 시간 구하기
        Map<String,Integer> map = new HashMap<>();
        TreeMap<String,Integer> answerMap = new TreeMap<>();
        for(String str : records){
            String[]tmp = str.split(" ");
            int time = changeTimeToMinutes(tmp[0]);
            String num = tmp[1];
            String act = tmp[2];
            if(act.equals("IN")){
                map.put(num,time);
            }else{
                int inTime = map.get(num);
                map.remove(num);
                answerMap.put(num,answerMap.getOrDefault(num,0)+ (time - inTime));
            }
        }
        int lastTime = changeTimeToMinutes("23:59");
        for(String num : map.keySet()){
            answerMap.putIfAbsent(num,0);
            answerMap.put(num,answerMap.get(num)+(lastTime - map.get(num)));
        }
        int[]answer = new int[answerMap.size()];
        int idx = 0;
        // 0 -> 기본시간, 1 -> 기본요금 . 2-> 단위시간 3 -> 단위요금
        for(String str : answerMap.keySet()){
            int total = answerMap.get(str);
            answer[idx] = fees[1];
            if(total<=fees[0]){
                idx++;
                continue;
            }
            total -= fees[0];
            //단위시간
            int last = (total/fees[2]) * fees[3];
            if(total % fees[2]!=0) last += fees[3];
            answer[idx] += last;
            idx++;

        }
        return answer;
    }
    static int changeTimeToMinutes(String str){
        String[]tmp = str.split(":");
        int time = (Integer.parseInt(tmp[0])*60)+(Integer.parseInt(tmp[1]));
        return time;
    }
}
