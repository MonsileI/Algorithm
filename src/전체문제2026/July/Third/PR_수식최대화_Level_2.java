package 전체문제2026.July.Third;

import java.util.*;

public class PR_수식최대화_Level_2 {
    static List<Character>opList;
    static List<Long> numList;
    static boolean[]visited;
    static char[]op = {'*','+','-'};
    static int []tmp;
    static long answer;
    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        System.out.println(solution(expression));
    }

    static long solution(String expression) {
        String n = "";
        opList = new ArrayList<>();
        numList = new ArrayList<>();
        int len = expression.length();
        // + * - 우선순위 순서

        for(int i=0;i<len;i++){
            char ch = expression.charAt(i);
            if('0'<=ch && ch<='9'){
                n += ch;
            }else{

                numList.add(Long.parseLong(n));
                n = "";
                opList.add(ch);
            }
        }
        numList.add(Long.parseLong(n));
        tmp = new int[3];
        visited= new boolean[3];
        perm(0);
        return answer;
    }
    static void calc(){

        List<Long> tmpNum = new ArrayList<>(numList);
        List<Character> tmpOp = new ArrayList<>(opList);
        for(int i=0;i<3;i++){
            char t = op[tmp[i]];
            if(!tmpOp.contains(t)) continue;
            for(int j=0;j<tmpOp.size();j++){
                if(t== tmpOp.get(j)){
                    long f = tmpNum.remove(j);
                    long s = tmpNum.remove(j);
                    long num = operationCalc(f,s,t);
                    tmpNum.add(j,num);
                    tmpOp.remove(j);
                    j--;
                }
            }
        }
        answer = Math.max(answer,Math.abs(tmpNum.get(0)));
    }
    static long operationCalc(long first, long second,char op){
        if(op=='*') return first * second;
        if(op=='+') return first + second;
        if(op=='-') return first - second;
        return -1;
    }
    static void perm(int depth){
        if(depth==3){
            calc();
            return;
        }
        for(int i=0;i<3;i++){
            if(!visited[i]){
                visited[i] = true;
                tmp[depth] = i;
                perm(depth+1);
                visited[i] = false;
            }
        }
    }
}
