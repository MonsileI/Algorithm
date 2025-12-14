package 전체문제2025.December.Fifth;
import java.util.*;

public class PR_오픈채팅방_Level_2 {
    public static void main(String[] args) {
        String [] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution(record)));

    }
    static String[] solution(String[]record){
        Map<String,String> map  =new HashMap<>();
        for(String str : record){
            String[]tmp = str.split(" ");
            if(tmp[0].equals("Leave") == false){
                map.put(tmp[1],tmp[2]); // ID , NickName
            }
        }
        List<String> list = new ArrayList<>();
        String in = "님이 들어왔습니다.";
        String out = "님이 나갔습니다.";
        for(String str : record){
            String[]tmp = str.split(" ");
            switch (tmp[0]){
                case "Enter" :
                    list.add(map.get(tmp[1])+in);
                    break;
                case "Leave" :
                    list.add(map.get(tmp[1])+out);
                    break;
                case "Change" :
                    break;
            }
        }
        int N = list.size();
        String[]answer=  new String[N];
        for(int i=0;i<N;i++) answer[i] = list.get(i);
        return answer;
    }
}
