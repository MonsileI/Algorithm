package 구현.맵;

import java.util.*;

public class PR_신고결과받기_Level_1 {

    static int[] solution(String[] id_list, String[] report, int k) {
        int N = id_list.length;
        int[] answer = new int[N];
        Map<String,Integer> getMap = new HashMap<>();
        Map<String,Set<String>> doMap = new HashMap<>();
        Map<String,Integer> ansMap = new HashMap<>();
        for(String str : id_list){
            getMap.put(str,0);
            doMap.put(str,new HashSet<>());
            ansMap.put(str,0);
        }
        for(String str : report){
            String[]tmp = str.split(" ");
            doMap.get(tmp[0]).add(tmp[1]);
        }
        for(String str : doMap.keySet()){
            for(String tStr : doMap.get(str)){
                getMap.put(tStr,getMap.get(tStr)+1);
            }
        }
        for(String str : getMap.keySet()){
            if(getMap.get(str)>k-1){
                for(String tStr : doMap.keySet()){
                    if(doMap.get(tStr).contains(str)){
                        ansMap.put(tStr,ansMap.get(tStr)+1);
                    }
                }
            }
        }
        for(int i =0; i<N;i++){
            answer[i] = ansMap.get(id_list[i]);
        }
        return answer;
    }


    public static void main(String[] args) {
        /*
        TEST CASE
        1.
        String[]id_list = {"muzi", "frodo", "apeach", "neo"};
        String[]report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        int result = {2,1,1,0};

        2.
        String[]id_list = {"con", "ryan"};
        String[]report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;

        int result = {0,0};

        * */
        String[]id_list = {"muzi", "frodo", "apeach", "neo"};
        String[]report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        System.out.println(Arrays.toString(solution(id_list,report,k)));

    }
}
