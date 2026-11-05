package 전체문제2026.November.Third;

import java.util.*;

public class PR_보석쇼핑_Level_3 {
    public static void main(String[] args) {
        String[] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
        System.out.println(Arrays.toString(solution(gems)));
    }
    static int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        int total = 0;
        for(String str : gems){
            if(!set.contains(str)){
                set.add(str);
                total++;
            }
        }
        Map<String,Integer> map = new HashMap<>();
        int L = 0; int R = 0;
        int N = gems.length;
        int range = N;
        int lIdx =0 ; int rIdx = 0;
        int cur = 1;
        map.put(gems[0],1);
        while(L<N){
            //보석수가 모자라면,
            if(cur<total) {
                if(R==N-1) break;
                R++;
                if(!map.containsKey(gems[R])){
                    cur++;
                    map.put(gems[R],1);
                }else{
                    map.put(gems[R],map.get(gems[R])+1);
                }
            }else{
                if(R-L<range){
                    range = R-L;
                    lIdx = L;
                    rIdx = R;
                }
                map.put(gems[L],map.get(gems[L])-1);
                if(map.get(gems[L])==0){
                    map.remove(gems[L]);
                    cur--;
                }
                L++;
            }
        }
        int[]answer = {lIdx+1,rIdx+1};
        return answer;
    }
}
