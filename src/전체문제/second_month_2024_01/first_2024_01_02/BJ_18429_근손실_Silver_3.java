package 전체문제.second_month_2024_01.first_2024_01_02;
import java.util.*;
import java.io.*;
public class BJ_18429_근손실_Silver_3 {
    static int []arr;
    static boolean[]visited;
    static int N;
    static int answer;
    static int K;
    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++){
            if(arr[i]-K>-1) {
                visited[i] = true;
                dfs(i,500,1);
                visited[i] = false;
            }
        }
        System.out.println(answer);
    }
    static void dfs(int node,int sum,int depth){
        if(depth==N){
            answer++;
            return;
        }
        for(int i=0;i<N;i++){
            if(!visited[i]&&(sum+arr[node])-K>499){
                visited[i] = true;
                dfs(i,(sum+arr[node])-K,depth+1);
                visited[i] = false;
            }
        }
    }
}
