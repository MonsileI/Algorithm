package 전체문제2026.April.Ninth;

import java.util.*;

public class PR_신고결과받기_Level_1 {
    public static void main(String[] args) {
        String [] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        System.out.println(Arrays.toString(solution(id_list,report,k)));
    }
    static int[] solution(String[] id_list, String[] report, int k) {
        int N= id_list.length;
        int[] answer = new int[N];
        Map<String,Integer> userMap = new HashMap<>();
        int[]singoCount = new int[N];
        List<List<Integer>> list = new ArrayList<>(); //자기 자신을 신고한 친구들
        boolean[][]isReport = new boolean[N][N]; //중복신고방지
        for(int i=0;i<N;i++){
            userMap.put(id_list[i],i);
            list.add(new ArrayList<>());
        }
        for(String str : report){
            String []tmp = str.split(" ");
            int from = userMap.get(tmp[0]);
            int to  = userMap.get(tmp[1]);
            if(!isReport[from][to]){
                isReport[from][to] = true;
                singoCount[to]++;
                list.get(to).add(from);
            }
        }
        for(int i=0;i<N;i++){
            if(k<=singoCount[i]){
                for(int node : list.get(i)){
                    answer[node]++;
                }
            }
        }
        return answer;
    }
}
