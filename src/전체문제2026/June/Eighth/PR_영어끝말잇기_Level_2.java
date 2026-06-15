package 전체문제2026.June.Eighth;

import java.util.*;

public class PR_영어끝말잇기_Level_2 {
    public static void main(String[] args) {
        int n = 3;
        String[]words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        System.out.println(Arrays.toString(solution(n,words)));
    }
    static int[] solution(int n, String[] words) {
        int turn = 1;
        int person = 1;
        boolean flag = true;
        Set<String> set = new HashSet<>();
        int N = words.length;
        set.add(words[0]);
        char lastCh = words[0].charAt(words[0].length()-1);
        for(int i=1;i<N;i++){
            person++;
            if(n<person){
                person = 1;
                turn++;
            }
            if(set.contains(words[i])) {
                flag = false;
                break;
            }
            if(lastCh!=words[i].charAt(0)){
                flag = false;
                break;
            }
            lastCh = words[i].charAt(words[i].length()-1);
            set.add(words[i]);
        }
        if(flag) return new int[]{0,0};
        int[]answer = {turn,person};
        return answer;
    }
}
