package 전체문제2026.January.Eighth;

import java.util.*;
import java.io.*;
public class BJ_22866_탑보기_Gold_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[]arr = new int[N+1];
        for(int i=1;i<N+1;i++)arr[i] = Integer.parseInt(st.nextToken());
        Stack<int[]> stack = new Stack<>();
        /*
        1. 자기 보다 클 때 까지 stack에 넣어주기, 작으면 pop시킴
        2. 자기 보다 크다면, stack.size()가 곧 자기가 볼 수 있는 크기이다.
        3. 그 중 stack.indexOf(0)번째가 가장 작은 수 (왼쪽 기준)
        4. int[]answer 배열에 개수가 0이라면 오른쪽 스택에서 답을 가져옴
         */
        int[] minNum = new int[N+1];
        int[] cnt = new int[N+1];
        Arrays.fill(minNum,-1);
        for(int i=1;i<N+1;i++){
            int value = arr[i];

            while(!stack.isEmpty()){
                int tmp = stack.peek()[1];
                if(value < tmp){
                    cnt[i] += stack.size();
                    minNum[i] = stack.peek()[0];
                    break;
                }
                stack.pop();
            }
            stack.push(new int[]{(i),value}); //인덱스 , value
        }
        stack.clear();
        for(int i=N;0<i;i--){
            int value = arr[i];
            while(!stack.isEmpty()){
                int tmp = stack.peek()[1];
                int tmpIdx = stack.peek()[0];
                if(value < tmp){
                    cnt[i] += stack.size();
                    if(minNum[i]==-1) {
                        minNum[i] = tmpIdx;
                    }else{
                        if(tmpIdx-i < i-minNum[i]){
                            minNum[i] = tmpIdx;
                        }
                    }
                    break;
                }
                stack.pop();
            }
            stack.push(new int[]{(i),value}); //인덱스 , value
        }
        StringBuilder sb= new StringBuilder();
        for(int i=1;i<N+1;i++){
            sb.append(cnt[i]);
            if(minNum[i]!=-1) {
                sb.append(" "+minNum[i]);
            }
            if(i==N) break;
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
