package 전체문제.third_month_2024_02.eleventh_2024_02_20;
import java.util.*;
import java.io.*;
public class PR_주사위고르기_Level_3 {

    static int[][] D;
    static int N;
    static int []tmp;
    static int max;
    static int[]answer;
    static List<Integer> aList;
    static List<Integer> bList;

    static int[] solution(int[][] dice) {
        D = dice;
        N = dice.length;
        tmp = new int[N/2];
        answer = new int[N/2];
        //콤비네이션으로 뭘 할지 고름
        comb(0,0);
        return answer;
    }
    static void calc(){
        int[]other = new int[N/2];
        boolean[]check = new boolean[N];
        for(int i=0;i<N/2;i++) check[tmp[i]]=true;
        int idx = 0;
        for(int i=0;i<N;i++) if(!check[i]) other[idx++]=i;
        //두개씩 합계를 List에 넣어줌
        aList = new ArrayList<>();
        bList = new ArrayList<>();
        dfs(aList,0,0,tmp);
        dfs(bList,0,0,other);
        Collections.sort(bList);
        int sum  =0;
        for(int num : aList){
            int L = 0; int R = bList.size();
            while(L<R){
                int mid = (L+R)/2;
                if(num>bList.get(mid)) L = mid+1;
                else R = mid;
            }
            sum += R;
        }
        if(max<sum){
            max = sum;
            for(int i=0;i<N/2;i++) answer[i] = tmp[i]+1;
        }
    }
    static void dfs(List<Integer> list,int depth,int sum,int[]arr){

        if(depth==N/2){
            list.add(sum);
            return;
        }

        for(int i=0;i<6;i++){
            dfs(list,depth+1,sum+D[arr[depth]][i],arr);
        }
    }
    static void comb(int start,int depth){

        if(depth==N/2){
            calc();
            return;
        }


        for(int i=start;i<N;i++){
            tmp[depth] = i;
            comb(i+1,depth+1);
        }
    }


    public static void main(String[] args) {
        /*
        TEST CASE
        1.
        int[][]dice = {{1, 2, 3, 4, 5, 6},{3, 3, 3, 3, 4, 4},{1, 3, 3, 4, 4, 4},{1, 1, 4, 4, 5, 5}};
        int [] result = {1,4};

        2.
        int[][]dice = {{1, 2, 3, 4, 5, 6},{2, 2, 4, 4, 6, 6}};
        int [] result = {2};

        3.
        int[][]dice = {{40, 41, 42, 43, 44, 45},{43, 43, 42, 42, 41, 41},{1, 1, 80, 80, 80, 80},{70, 70, 1, 1, 70, 70}};
        int [] result = {1,3};
        * */
        int[][]dice = {{40, 41, 42, 43, 44, 45},{43, 43, 42, 42, 41, 41},{1, 1, 80, 80, 80, 80},{70, 70, 1, 1, 70, 70}};
        System.out.println(Arrays.toString(solution(dice)));
    }
}
