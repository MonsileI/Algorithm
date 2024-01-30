package 전체문제.second_month_2024_01.twelfth_2024_01_18;

import java.util.*;

public class PR_주사위고르기_Level_3_Re {

    static int N;
    static int []arrA;
    static int[][]D;
    static List<int[]> listA;
    static List<Integer> totalA;
    static List<Integer> totalB;
    static int[] solution(int[][] dice) {
        D = dice;
        N = dice.length;
        int max = 0;
        int []answer= new int[N/2];
        arrA = new int[N/2];
        listA = new ArrayList<>();
        comb(0,0);
        for(int[] a : listA){
            totalA = new ArrayList<>();
            totalB = new ArrayList<>();
            boolean[]check = new boolean[N];
            for(int i=0;i<N/2;i++)check[a[i]] = true;
            int [] b = new int[N/2];
            int idx = 0;
            for(int i=0;i<N;i++) if(!check[i]) b[idx++] = i;
            combDice(totalA,a,0,0);
            combDice(totalB,b,0,0);
            Collections.sort(totalB);
            int total = 0;
            for(Integer aSum : totalA){
                int L = 0 ; int R = totalB.size();
                while(L<R){
                    int mid = (L+R)/2;
                    if(totalB.get(mid)<aSum) L = mid+1;
                    else R = mid;
                }
                total += L;
            }
            if(max<total){
                max = total;
                for(int i=0;i<N/2;i++) answer[i] = a[i]+1;
            }
        }
        return answer;
    }
    static void combDice(List<Integer> team, int[] arr, int sum, int depth){

        if(depth==N/2){
            team.add(sum);
            return;
        }

        for(int i=0;i<6;i++){
            combDice(team,arr,sum+D[arr[depth]][i],depth+1);
        }
    }

    static void comb(int depth,int start){

        if(depth==N/2){
            listA.add(arrA.clone());
            return;
        }

        for(int i=start;i<N;i++){
            arrA[depth] = i;
            comb(depth+1,i+1);
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
