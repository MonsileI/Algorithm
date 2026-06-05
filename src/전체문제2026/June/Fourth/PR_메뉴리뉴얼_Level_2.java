package 전체문제2026.June.Fourth;

import java.util.*;

public class PR_메뉴리뉴얼_Level_2 {
    public static void main(String[] args) {
        String[]orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[]course = {2,3,4};
        System.out.println(Arrays.toString(solution(orders,course)));
    }
    static Map<String,Integer> map;
    static int[]tmp;
    static int G;
    static int N;
    static StringBuilder sb;
    static int max;
    static char[]strArr;
    static String[] solution(String[] orders, int[] course) {
        List<String >list = new ArrayList<>();
        for(int i=0;i<course.length;i++){
            int num = course[i];
            map = new HashMap<>();
            max = 2;
            G = num;
            for(String str : orders) {
                strArr = str.toCharArray();
                Arrays.sort(strArr);
                tmp = new int[num];
                N = str.length();
                comb(0,0);
            }
            for(String str : map.keySet()){
                if(map.get(str)==max){
                    list.add(str);
                }
            }
        }
        Collections.sort(list);
        String[]answer = new String[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    static void comb(int start,int depth){
        if(depth==G){
            sb = new StringBuilder();
            for(int i=0;i<G;i++){
                sb.append(strArr[tmp[i]]);
            }
            String str = sb.toString();
            map.put(str,map.getOrDefault(str,0)+1);
            max = Math.max(max,map.get(str));
            return;
        }
        for(int i=start;i<N;i++){
            tmp[depth] = i;
            comb(i+1,depth+1);
        }
    }
}
