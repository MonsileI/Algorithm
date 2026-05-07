package 전체문제2026.May.Second;
import java.util.*;
public class PR_키패드누르기_Level_1 {
    public static void main(String[] args) {
        int [] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(solution(numbers,hand));
    }
    static String solution(int[] numbers, String hand) {
        StringBuilder sb=  new StringBuilder();
        boolean right = hand.equals("right") ? true : false;

        int ri = 3; int rj = 2;
        int li = 3; int lj = 0;

        for(int n : numbers){
           if(n==0) n = 10;
           if(n%3==0){
               sb.append("R");
               rj = 2;
               ri = (n/3)-1;
            }else if((n+2)%3==0){
               sb.append("L");
               lj = 0;
               li = ((n+2)/3)-1;
           }else{
               int ni = ((n+1)/3) -1;
               int nj = 1;
               int lDiff = Math.abs(li-ni) + Math.abs(lj-nj);
               int rDiff = Math.abs(ri-ni) + Math.abs(rj-nj);
               if(lDiff<rDiff){
                   li = ni; lj = nj;
                   sb.append("L");
               }else if(rDiff<lDiff){
                   ri = ni; rj = nj;
                   sb.append("R");
               }else{
                   if(right){
                       ri = ni; rj = nj;
                       sb.append("R");
                   }else{
                       li = ni; lj = nj;
                       sb.append("L");
                   }
               }
           }

        }
        return sb.toString();
    }
}
