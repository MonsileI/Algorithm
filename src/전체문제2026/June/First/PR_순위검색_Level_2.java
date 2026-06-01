package 전체문제2026.June.First;

import java.util.*;

public class PR_순위검색_Level_2 {
    public static void main(String[] args) {
        String[]info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[]query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        System.out.println(Arrays.toString(solution(info,query)));
    }
    static Map<String,List<Integer>> map;
    static int[] solution(String[] info, String[] query) {
        int N = query.length;
        int[]answer = new int[N];
        map = new HashMap<>();
        for(String i : info) {
            String []tmp = i.split(" ");
            dfs(0,tmp,"");
        }
        for(String str : map.keySet()){
            Collections.sort(map.get(str));
        }
        for(int i =0;i<N;i++){
            String str = query[i];
            answer[i] = calc(str);
        }
        return answer;
    }
    static int calc(String query){
        String str = "";
        String []tmp = query.split(" and ");
        int num  =0;
        for(int i=0;i<tmp.length;i++){
            if(i==tmp.length-1){
                String[]t = tmp[i].split(" ");
                str += t[0];
                num = Integer.parseInt(t[1]);
                break;
            }
            str += tmp[i];
        }
        if(!map.containsKey(str)) return 0;
        List<Integer> list = map.get(str);
        int L =0; int R = list.size();
        while(L<R){
            int mid = (L+R)/2;
            if(list.get(mid)<num) L = mid+1;
            else R = mid;
        }
        return list.size()-L;

    }
    static void dfs(int depth,String[] tmp, String now){
        if(depth==4){
            map.putIfAbsent(now,new ArrayList<>());
            map.get(now).add(Integer.parseInt(tmp[4]));
            return;
        }
        dfs(depth+1,tmp,now+tmp[depth]);
        dfs(depth+1,tmp,now+"-");
    }

}
