package 전체문제2026.October.Tenth;

import java.util.*;

public class PR_단어변환_Level_3 {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[]words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution(begin,target,words));
    }
    static Map<String,List<String>> map;
    static int answer;
    static String Target;
    static Map<String,Integer> mapDepth;
    static  int solution(String begin, String target, String[] words) {
        answer = 987654321;
        Target = target;
        map = new HashMap<>();
        map.put(begin,new ArrayList<>());
        mapDepth = new HashMap<>();
        int N = words.length;
        int len = begin.length();
        mapDepth.put(begin,0);
        boolean isWork = false;
        for(int i=0;i<N;i++){
            String f = words[i];
            if(f.equals(target)) isWork = true;
            map.put(f,new ArrayList<>());
            mapDepth.put(f,987654321);
            for(int j=0;j<N;j++){
                if(i==j) continue;
                int flag = 0;
                String s = words[j];
                for(int l=0;l<len;l++){
                    if(f.charAt(l)!=s.charAt(l)){
                        flag++;
                    }
                    if(1<flag) break;
                }
                if(flag==1) map.get(f).add(s);
            }
        }
        if(!isWork) return 0;
        for(int i=0;i<N;i++){
            int flag = 0;
            for(int l=0;l<len;l++){
                if(begin.charAt(l)!=words[i].charAt(l)){
                    flag++;
                }
                if(1<flag) break;
            }
            if(flag==1){
                dfs(words[i],1);
            }
        }
        return answer == 987654321 ?  0 : answer;
    }
    static void dfs(String words,int depth){
        if(answer<=depth) return;
        if(words.equals(Target)){
            answer = depth;
            return;
        }
        for(String next : map.get(words)){
            if(mapDepth.get(next) > depth+1) {
                mapDepth.put(next,depth+1);
                dfs(next, depth + 1);
            }
        }
    }
}
