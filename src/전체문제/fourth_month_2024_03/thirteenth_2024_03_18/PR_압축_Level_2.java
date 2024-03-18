package 전체문제.fourth_month_2024_03.thirteenth_2024_03_18;
import java.util.*;
public class PR_압축_Level_2 {
    static int[] solution(String msg) {
        String alpha = "$ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        List<Integer> list = new ArrayList<>();
        Map<String,Integer> map = new HashMap();
        for(int i=1;i<27;i++) map.put(alpha.charAt(i)+"",i);
        int N = msg.length();
        int idx = 0;
        int turn = 27;
        String s = "";
        String newOne = "";
        boolean flag = true;
        while(idx<N){
           s = msg.charAt(idx)+"";
           for(int j=idx+1;j<N;j++){
               newOne = s + msg.charAt(j);
               if(!map.containsKey(newOne)){
                   map.put(newOne,turn++);
                   list.add(map.get(s));
                   idx = j;
                   break;
               }
               if(j==N-1) {
                   idx = j;
                   flag = false;
                   break;
               }
               s = newOne;
           }
           if(idx==N-1){
               if(flag) list.add(map.get(msg.charAt(idx)+""));
               else list.add(map.get(newOne));
               break;
           }
        }
        int[]answer= new int[list.size()];
        for(int i=0;i< list.size();i++) answer[i] = list.get(i);
        return answer;
    }
    public static void main(String[] args) {
        /*
        TEST CASE
        1.
        String msg = "KAKAO";
        int [] answer= {11, 1, 27, 15};

        2.
        String msg = "TOBEORNOTTOBEORTOBEORNOT";
        int [] answer= {20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34};

        3.
        String msg = "ABABABABABABABAB";
        int [] answer= {1, 2, 27, 29, 28, 31, 30};
        * */
        String msg = "KAKAO";
        System.out.println(Arrays.toString(solution(msg)));
    }
}
