package 전체문제2025.December.First;

import java.util.Arrays;

public class PR_단체사진찍기_Level_2 {
    static char[]member = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static char[]tmp;
    static boolean[]visited;
    static int answer;
    static String[]Data;
    public static void main(String[] args) {
        int n = 2;
        String[]data = {"N~F=0", "R~T>2"};
        System.out.println(solution(n,data));
    }
    static int solution(int n, String[] data) {
        tmp = new char[8];
        visited = new boolean[8];
        Data = data;
        dfs(0);
        return answer;
    }
    static boolean calc(){
        for(String str : Data){
            char fir = str.charAt(0);
            char sec = str.charAt(2);
            char op = str.charAt(3);
            int num = Integer.parseInt(str.charAt(4)+"")+1;
            int tFir = 0;
            int tSec = 0;
            for(int i=0;i<8;i++){
                if(fir==tmp[i]) {
                    tFir = i;
                }
                if(sec==tmp[i]){
                    tSec = i;
                }
            }
            int diff = Math.abs(tFir-tSec);
            switch (op){
                case '=':
                    if(diff!=num) return false;
                    break;
                case '<':
                    if(diff>=num) return false;
                    break;
                case '>':
                    if(diff<=num) return false;
                    break;
            }
        }
        return true;
    }
    static void dfs(int depth){

        if(depth==8){
            if(calc()) answer++;
            return;
        }

        for(int i=0;i<8;i++){
            if(!visited[i]){
                visited[i] = true;
                tmp[depth] = member[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}
