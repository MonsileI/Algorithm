package 전체문제2026.October.Sixteenth;

import java.sql.SQLOutput;
import java.util.*;

public class PR_튜플_Level_2 {
    public static void main(String[] args) {
        String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        System.out.println(Arrays.toString(solution(s)));
    }
    static  int[] solution(String s) {
        s = s.substring(2,s.length()-2);
        s = s.replaceAll("\\{"," ").replaceAll("\\}","");
        String[]tmp = s.split(" ");
        List<List<Integer>> list = new ArrayList<>();
        int idx = 0;
        for(int i=0;i<tmp.length;i++){
            String[]tTmp = tmp[i].split(",");
            list.add(new ArrayList<>());
            for(int j=0;j<tTmp.length;j++){
                list.get(idx).add(Integer.parseInt(tTmp[j]));
            }
            idx++;
        }
        Collections.sort(list,(o1,o2) -> o1.size() - o2.size());
        int[]answer = new int[list.get(list.size()-1).size()];
        idx = 0;
        boolean[]visited= new boolean[100001];
        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.get(i).size();j++){
                if(!visited[list.get(i).get(j)]){
                    visited[list.get(i).get(j)] = true;
                    answer[idx++] = list.get(i).get(j);
                    break;
                }
            }
        }
        return answer;
    }
}
