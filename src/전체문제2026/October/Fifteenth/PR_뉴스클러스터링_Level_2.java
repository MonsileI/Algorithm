package 전체문제2026.October.Fifteenth;

import java.util.*;

public class PR_뉴스클러스터링_Level_2 {
    public static void main(String[] args) {
        String str1 = "aa1+aa2";
        String str2 = "AAAA12";
        System.out.println(solution(str1,str2));
    }
    static int solution(String str1, String str2) {
        int firLen = str1.length();
        int secLen = str2.length();
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        //같은 String의 경우 교집합은 min, 합집합은 max
        Map<String,Integer> firMap = new HashMap<>();
        Map<String,Integer> secMap = new HashMap<>();
        for(int i=0;i<firLen-1;i++){
            char f = str1.charAt(i);
            char s = str1.charAt(i+1);
            if(check(f) && check(s)){
                String str = ""+f+s;
                firMap.put(str,firMap.getOrDefault(str,0)+1);
            }
        }
        double hap = 0;
        double kyo = 0;
        for(int i=0;i<secLen-1;i++){
            char f = str2.charAt(i);
            char s = str2.charAt(i+1);
            if(check(f) && check(s)){
                String str = ""+f+s;
                secMap.put(str,secMap.getOrDefault(str,0)+1);
                if(!firMap.containsKey(str)) hap++;
            }
        }
        // hap = 서로겹치지 않는거 + 겹치는거 최대
        // kyo = 겹치는거 최소
        for(String key : firMap.keySet()){
            if(!secMap.containsKey(key)) {
                hap += firMap.get(key); //안겹치는거
                continue;
            }
            hap += Math.max(firMap.get(key), secMap.get(key));
            kyo += Math.min(firMap.get(key), secMap.get(key));
        }
        int gop = 65536;
        double tmp = 0;
        if(hap==0) tmp = 1;
        else tmp = kyo/hap;
        int answer = (int)(tmp*gop);
        return answer;
    }
    static boolean check(char ch){
        if('a'<=ch && ch<='z') return true;
        return false;
    }
}
