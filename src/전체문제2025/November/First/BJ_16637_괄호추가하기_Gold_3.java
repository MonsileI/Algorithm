package 전체문제2025.November.First;

import java.util.*;
import java.io.*;
public class BJ_16637_괄호추가하기_Gold_3 {
    static int N;
    static long answer = -987654321;
    static List<Integer> number;
    static List<Character> op;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        number = new ArrayList<>();
        op = new ArrayList<>();
        for(int i=0;i<str.length();i++){
            if(i%2==0){
                number.add(Integer.parseInt(str.charAt(i)+""));
            }else{
                op.add(str.charAt(i));
            }
        }
        dfs(0,number.get(0));
        System.out.println(answer);
    }

    static void dfs(int depth,int sum){
        if(depth>=op.size()){
            answer = Math.max(answer,sum);
            return;
        }

        int fir = calc(op.get(depth),sum, number.get(depth+1));
        dfs(depth+1,fir);

        if(depth+1<op.size()){
            int sec = calc(op.get(depth+1),number.get(depth+1),number.get(depth+2));
            int result = calc(op.get(depth),sum,sec);
            dfs(depth+2,result);
        }


    }

    static int calc(char op, int fir, int sec){
        int sum = fir;
        switch (op){
            case '*': sum *= sec;
                break;
            case '+': sum += sec;
                break;
            case '-': sum -= sec;
                break;
        }
        return sum;
    }


}
