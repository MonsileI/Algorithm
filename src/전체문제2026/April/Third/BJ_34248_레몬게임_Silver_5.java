package 전체문제2026.April.Third;

import java.util.*;
import java.io.*;
public class BJ_34248_레몬게임_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[]arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++){
            if(stack.isEmpty()){
                stack.push(arr[i]);
                continue;
            }
            int num = stack.pop();
            if(num==1 && arr[i]==2) continue;
            if(arr[i]==1 && num==2) continue;
            stack.push(num);
            stack.push(arr[i]);
        }
        if(stack.isEmpty()) System.out.println("Yes");
        else{
            boolean flag = true;
            int num = 0;
            while(!stack.isEmpty()){
                int tmp = stack.pop();
                num += tmp;
                if(tmp==2){
                    flag = false;
                    break;
                }
            }
            if(!flag) System.out.println("No");
            else if(num%3!=0) System.out.println("No");
            else System.out.println("Yes");
        }
    }
}
