package 전체문제2025.December.Ninth;

import java.util.*;

public class PR_주차요금계산_Level_2 {
    public static void main(String[] args) {
        int[]fees = {180, 5000, 10, 600}; //기본시간, 기본요금, 단위시간, 단위요금
        String[]records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(Arrays.toString(solution(fees,records)));
    }
    static  int[] solution(int[] fees, String[] records) {
        Map<String,Integer> resultMap = new HashMap<>(); //총시간
        Map<String,Integer> tmpMap = new HashMap<>(); //들어간 시간 기록
        TreeMap<String,Integer> allCars = new TreeMap<>(); // 모든 자동차들
        for(String str : records){
            String[]tmp = str.split(" ");
            int time = changeTime(tmp[0]);
            String num = tmp[1];
            String action = tmp[2];
            if(action.equals("IN")){
                //들어올 경우
                tmpMap.put(num,time);
                allCars.put(num,0);
            }else{
                int timeRange = time - tmpMap.get(num);
                resultMap.put(num,resultMap.getOrDefault(num,0)+timeRange);
                tmpMap.put(num,null);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(String str : allCars.keySet()){
            int totalTime = 0;
            if(resultMap.containsKey(str)==false) {
                totalTime = changeTime("23:59") - tmpMap.get(str);
            }else{
                totalTime = resultMap.get(str);
                if(tmpMap.get(str)!=null){
                    totalTime += changeTime("23:59") - tmpMap.get(str);
                }
            }
            int total = fees[1];
            if(fees[0] < totalTime){
                int lastTime = totalTime - fees[0];
                total += ((lastTime/fees[2]) * fees[3]);
                //반올림
                if(lastTime%fees[2]!=0) total += fees[3];
            }
            list.add(total);
        }
        int[]answer = new int[list.size()];
        for(int i=0;i<list.size();i++) answer[i] = list.get(i);
        return answer;
    }
    static int changeTime(String str){
        String[]tmp = str.split(":");
        int hour = Integer.parseInt(tmp[0]) * 60;
        int min = Integer.parseInt(tmp[1]);
        return (hour+min);
    }
}
