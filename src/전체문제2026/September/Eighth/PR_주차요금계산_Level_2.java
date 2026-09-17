package 전체문제2026.September.Eighth;

import java.util.*;

public class PR_주차요금계산_Level_2 {
    public static void main(String[] args) {
        int[]fees = {180, 5000, 10, 600};
        String[]records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(Arrays.toString(solution(fees,records)));
    }
    static int[] solution(int[] fees, String[] records) {
        TreeMap<String,Integer> resultMap = new TreeMap<>();
        Map<String,Integer> inMap = new HashMap<>();
        for(String str : records){
            String[]tmp = str.split(" ");
            int time = changeTime(tmp[0]);
            String carNumber = tmp[1];
            String act = tmp[2];
            if(act.equals("IN")){
                inMap.put(carNumber,time);
            }else{
                int sumTime = time - inMap.get(carNumber);
                resultMap.put(carNumber,resultMap.getOrDefault(carNumber,0) + sumTime);
                inMap.remove(carNumber);
            }
        }
        int lastTime = changeTime("23:59");
        for(String key : inMap.keySet()){
            resultMap.put(key,resultMap.getOrDefault(key,0) + lastTime - inMap.get(key));
        }
        List<Integer> list = new ArrayList<>();
        for(String key : resultMap.keySet()){
            int time = resultMap.get(key);
            //기본시간,기본요금,단위시간,단위요금
            int fee = fees[1];
            time -= fees[0];
            if(time<=0) {
                list.add(fee);
                continue;
            }
            fee += (time/fees[2]) * fees[3];
            if(time%fees[2]!=0) fee += fees[3];
            list.add(fee);
        }
        int[]answer = new int[list.size()];
        for(int i=0;i<list.size();i++) answer[i] = list.get(i);
        return answer;
    }
    static int changeTime(String time){
        String[]tmp = time.split(":");
        int result = (Integer.parseInt(tmp[0]) * 60) + Integer.parseInt(tmp[1]);
        return result;
    }
}
