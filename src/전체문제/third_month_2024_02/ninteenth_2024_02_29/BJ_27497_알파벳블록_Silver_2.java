package 전체문제.third_month_2024_02.ninteenth_2024_02_29;
import java.util.*;
import java.io.*;
public class BJ_27497_알파벳블록_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int idx = 0;
        int[]check = new int[1000001];
        StringTokenizer st = null;
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int num = Integer.parseInt(st.nextToken());
            if(num==3){
                idx--;
                if(-1<idx){
                    if(check[idx]==1) right.pop();
                    else left.pop();
                }
            }else {
                char ch = st.nextToken().charAt(0);
                if(idx<0) idx = 0;
                if(num==1){
                    right.push(ch);
                    check[idx] = 1;
                }else {
                    left.push(ch);
                    check[idx] = 2;
                }
                idx++;
            }
        }
        StringBuilder sb= new StringBuilder();
        if(left.isEmpty() && right.isEmpty()) System.out.println(0);
        else {
            while (!left.isEmpty()) sb.append(left.pop());
            int size = right.size();
            for (int i = 0; i < size; i++) sb.append(right.get(i));
            System.out.println(sb.toString());
        }
    }
}
