package 전체문제2026.June.Ninth;

import java.util.*;

public class PR_N으로표현_Level_3 {
    public static void main(String[] args) {
        int N =5;
        int number = 12;
        System.out.println(solution(N,number));
    }

    static List<HashSet<Integer>> list;
    static int solution(int N, int number) {
        list = new ArrayList<>();
        int answer = calc(N,number);
        return answer;
    }
    static int calc(int N,int number){
        if(N==number) return 1; //자기자신
        for(int i=0;i<=8;i++){
            list.add(new HashSet<>());
        }
        list.get(1).add(N);
        int tmp = N;
        for(int i=2;i<=8;i++){
            Set<Integer> total = list.get(i);
            for(int j=1;j<i;j++){
                Set<Integer> a = list.get(j);
                Set<Integer> b= list.get(i-j);
                for(int x : a){
                    for(int y : b){
                        total.add(x+y);
                        total.add(x-y);
                        total.add(x*y);
                        if(x!=0 && y!=0) total.add(x/y);
                    }
                }
            }
            tmp *= 10;
            tmp += N;
            total.add(tmp);
            if(total.contains(number)) return i;
        }
        return -1;
    }
}
