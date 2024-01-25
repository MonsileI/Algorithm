package 전체문제.second_month_2024_01.seventeenth_2024_01_25;
import java.util.*;
import java.io.*;
public class BJ_25381_ABBC_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char []arr = br.readLine().toCharArray();
        int N = arr.length;
        Stack<Integer> stackA = new Stack<>();
        Stack<Integer> stackB = new Stack<>();
        for(int i=0;i<N;i++){
            char ch = arr[i];
            if(ch=='A') stackA.push(i);
            if(ch=='B') stackB.push(i);
        }
        int answer = 0;
        for(int i=N-1;-1<i;i--){
            if(stackA.isEmpty()) break;
            char ch = arr[i];
            if(ch=='B'){
                while(!stackA.isEmpty()){
                    if(stackA.peek()<i){
                        stackA.pop();
                        stackB.pop();
                        answer++;
                        break;
                    }
                    stackA.pop();
                }
            }
        }
        for(int i=N-1;-1<i;i--){
            if(stackB.isEmpty()) break;
            char ch = arr[i];
            if(ch=='C'){
                while(!stackB.isEmpty()){
                    if(stackB.peek()<i){
                        stackB.pop();
                        answer++;
                        break;
                    }
                    stackB.pop();
                }
            }

        }

        System.out.println(answer);

    }
}
