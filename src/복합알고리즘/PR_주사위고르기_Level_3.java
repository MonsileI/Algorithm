package 복합알고리즘;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PR_주사위고르기_Level_3 {

    static int N;
    static boolean[]visited;
    static int[]aArr;
    static int [][] D;
    static List<int[]> diceA;
    static List<Integer> listA;
    static List<Integer> listB;

    static int[] solution(int[][] dice) {

        D = dice;
        N = dice.length;
        int max = 0;
        int[]ans = new int[N/2];
        //일단 A의 주사위 perm을 구하자
        diceA = new ArrayList<>();
        aArr = new int[N/2];
        visited = new boolean[N];
        comb(0,0);
        for(int[] arrA : diceA){
            int[]arrB = new int[N/2];
            boolean[]check = new boolean[N];
            for(int i : arrA) check[i] = true;
            int index = 0;
            for(int i=0;i<N;i++) {
                if(!check[i]) arrB[index++] = i;
            }
            //arrA와 arrB에 선택지가 들어가있음! 모든 선택 조합(각6개)를 각각 뽑아내자
            listA = new ArrayList<>();
            listB = new ArrayList<>();
            comb2(0,listA,0,arrA);
            comb2(0,listB,0,arrB);
            Collections.sort(listA);
            Collections.sort(listB);

            int sum = 0;
            for(Integer a : listA){
                int L = 0; int R = listB.size();
                while(L<R){
                    int mid = (L+R)/2;
                    if(listB.get(mid)<a) L = mid+1;
                    else R = mid;
                }
                sum += L;
            }
            if(max<sum){
                max = sum;
                for(int i=0;i<N/2;i++) ans[i] = arrA[i]+1;
            }
        }


        return ans;
    }
    static void comb2(int index,List<Integer>team,int sum,int[]dice){

        if(index==N/2){
            team.add(sum);
            return;
        }

        for(int i=0;i<6;i++){
            comb2(index+1,team,sum+D[dice[index]][i],dice);
        }
    }

    static void comb(int depth,int start){

        if(depth==N/2){
            diceA.add(aArr.clone());
            return;
        }

        for(int i=start;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                aArr[depth] = i;
                comb(depth+1,i+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        /*
        TEST CASE
        1.
        int[][]dice = {{1, 2, 3, 4, 5, 6},{3, 3, 3, 3, 4, 4},{1, 3, 3, 4, 4, 4},{1, 1, 4, 4, 5, 5}};
        int []result = {1,4}

        2.
        int[][]dice = {{1, 2, 3, 4, 5, 6},{2, 2, 4, 4, 6, 6}};
        int []result = {2}

        3.
        int[][]dice = {{40, 41, 42, 43, 44, 45},{43, 43, 42, 42, 41, 41},{1, 1, 80, 80, 80, 80},{70, 70, 1, 1, 70, 70}};
        int []result = {1,3}
        * */
        int[][]dice = {{1, 2, 3, 4, 5, 6},{3, 3, 3, 3, 4, 4},{1, 3, 3, 4, 4, 4},{1, 1, 4, 4, 5, 5}};
        System.out.println(Arrays.toString(solution(dice)));
    }
}
