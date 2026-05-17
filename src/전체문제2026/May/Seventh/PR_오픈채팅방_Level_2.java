package 전체문제2026.May.Seventh;

import java.util.*;

public class PR_오픈채팅방_Level_2 {
    public static void main(String[] args) {
        String[]record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution(record)));
    }
    static  String[] solution(String[] record) {
        List<String> list= new ArrayList<>();
        Map<String,String>map = new HashMap<>();
        String EnterStr = " 들어왔습니다.";
        String LeaveStr = " 나갔습니다.";
        for(String str : record){
            String[]tmp =str.split(" ");
            String act = tmp[0];
            if(act.equals("Leave")) continue;
            String ID = tmp[1];
            String nick = tmp[2];
            map.put(ID,nick);
        }
        for(String str : record){
            String[]tmp =  str.split(" ");
            String act = tmp[0];
            if(act.equals("Change")) continue;
            String ID = tmp[1];
            String answerStr = map.get(ID)+"님이";
            if(act.equals("Enter")) answerStr += EnterStr;
            else answerStr += LeaveStr;
            list.add(answerStr);
        }
        String[]answer = new String[list.size()];
        for(int i=0;i<list.size();i++) answer[i] = list.get(i);
        return answer;
    }
}
