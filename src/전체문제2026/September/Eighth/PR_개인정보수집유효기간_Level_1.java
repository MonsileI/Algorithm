package 전체문제2026.September.Eighth;

import java.util.*;

public class PR_개인정보수집유효기간_Level_1 {
    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        System.out.println(Arrays.toString(solution(today, terms, privacies)));
    }

    static int[] solution(String today, String[] terms, String[] privacies) {
        int thisDay = changeDate(today.split("\\."));
        Map<Character,Integer> map = new HashMap<>();
        for(String t : terms){
            String[]tmp = t.split(" ");
            map.put(tmp[0].charAt(0),Integer.parseInt(tmp[1]) * 28);
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<privacies.length;i++){
            String[]tmp = privacies[i].split(" ");
            int date = changeDate(tmp[0].split("\\."));
            char ch = tmp[1].charAt(0);
            int plusMonth = map.get(ch);
            date += plusMonth - 1; // 하루 마이너스
            if(date<thisDay) list.add((i+1));
        }
        int[]answer = new int[list.size()];
        for(int i=0;i<list.size();i++) answer[i] = list.get(i);
        return answer;
    }
    static int changeDate(String[]tmp){
        int year = Integer.parseInt(tmp[0]);
        int month = Integer.parseInt(tmp[1]);
        int day = Integer.parseInt(tmp[2]);

        int result = day + (month * 28) + (year * 28 * 12);

        return result;

    }
}