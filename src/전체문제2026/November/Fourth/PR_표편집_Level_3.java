package 전체문제2026.November.Fourth;

import java.util.*;
public class PR_표편집_Level_3 {
    public static void main(String[] args) {
        int n = 8;int k = 2;
        String[]cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
        System.out.println(solution(n,k,cmd));
    }

    static String solution(int n, int k, String[] cmd) {
        String answer = "";
        int[]prev = new int[n];
        int[]next = new int[n];
        for(int i=0;i<n;i++){
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        Stack<Integer> stack  =new Stack<>();
        for(String c : cmd) {
            String[]tmp = c.split(" ");
            int range = 0;
            switch (tmp[0]){
                case "D":
                    range= Integer.parseInt(tmp[1]);
                    for(int i = 0; i < range; i++) {
                        k = next[k];
                    }
                break;
                case "U":
                    range= Integer.parseInt(tmp[1]);
                    for(int i = 0; i < range; i++) {
                        k = prev[k];
                    }
                break;
                //삭제
                case "C":
                    stack.add(k);
                    if(prev[k] != -1) next[prev[k]] = next[k];
                    if(next[k] != n) prev[next[k]] = prev[k];
                    if(next[k] == n) k = prev[k];
                    else k = next[k];
                break;
                //복구
                case "Z":
                    int t = stack.pop();
                    if(prev[t] != -1) next[prev[t]] = t;
                    if(next[t] != n) prev[next[t]] = t;
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean[]deleted = new boolean[n];
        while(!stack.isEmpty()){
            deleted[stack.pop()] = true;
        }
        for(int i=0;i<n;i++) {
            if(deleted[i]) sb.append("X");
            else sb.append("O");
        }
        answer = sb.toString();
        return answer;
    }
}
