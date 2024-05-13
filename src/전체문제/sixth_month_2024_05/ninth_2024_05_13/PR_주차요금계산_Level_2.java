package 전체문제.sixth_month_2024_05.ninth_2024_05_13;

import java.util.*;
public class PR_주차요금계산_Level_2 {
        static int[] solution(int[] fees, String[] records) {
            Map<String,Integer> map = new HashMap<>();
            TreeMap<String,Integer> ansMap = new TreeMap<>();
            for(String str : records){
                String [] tmp = str.split(" ");
                int time = change(tmp[0]);
                String num = tmp[1];
                String act = tmp[2];
                if(act.equals("IN")) map.put(num,time);
                else{
                    ansMap.put(num,ansMap.getOrDefault(num,0)+(time-map.get(num)));
                    map.remove(num);
                }
            }
            for(String str : map.keySet()){
                ansMap.put(str,ansMap.getOrDefault(str,0)+(change("23:59")-map.get(str)));
            }
            int[]ans = new int[ansMap.size()];
            int idx = 0;
            for(String str : ansMap.keySet()){
                int total = ansMap.get(str);
                if(total<=fees[0]) ans[idx++] = fees[1];
                else{
                    int sum = fees[1];
                    total -= fees[0];
                    sum += fees[3]*(total/fees[2]);
                    if(total%fees[2]!=0) sum += fees[3];
                    ans[idx++] = sum;
                }
            }
            return ans;
        }
        static int change(String str){
            String[]tmp = str.split(":");
            return ((Integer.parseInt(tmp[0])*60)+Integer.parseInt(tmp[1]));
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
        int[]fees = {1, 461, 1, 10};
        String[]records = {"00:00 1234 IN"};
        System.out.println(Arrays.toString(solution(fees, records)));

    }
}
