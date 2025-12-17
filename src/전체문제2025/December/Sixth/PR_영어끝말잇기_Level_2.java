package 전체문제2025.December.Sixth;
import java.util.*;
public class PR_영어끝말잇기_Level_2 {
    public static void main(String[] args) {
        int n = 3;
        String[]words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        System.out.println(Arrays.toString(solution(n,words)));
    }
    static int[]solution(int n, String[]words){
        Map<String,Integer> map = new HashMap<>();
        int len = words.length;
        int turn = 1; int person = 1;
        int[]answer=  new int[2];
        for(int i=0;i<len;i++){
           String str = words[i];
           if(n<person) {
               person = 1;
               turn++;
           }
           if(map.containsKey(str)){
               answer[0] = person;
               answer[1] = turn;
               break;
           }
           map.put(str,0);
           if(i!=0 && words[i-1].charAt(words[i-1].length()-1)!= str.charAt(0)){
               answer[0] = person;
               answer[1] = turn;
               break;
           }
           person++;
        }

        return answer;
    }


}
