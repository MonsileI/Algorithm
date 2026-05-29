package 전체문제2026.May.Twelfth;

import java.util.*;

public class PR_햄버거만들기_Level_1 {
    public static void main(String[] args) {
        int[]ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        System.out.println(solution(ingredient));
    }
    static int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int[]check = {0,2,3,1};
        int N = ingredient.length;
        for(int i=0;i<N;i++){
            int food = ingredient[i];
            if(stack.isEmpty()){
                stack.push(food);
                continue;
            }
            //1 -> 2 , 2-> 3, 3 -> 1
            stack.push(food);
            if(4<=stack.size()){
                int size = stack.size();
                int before = stack.get(size-1);
                if(before!=1) continue;
                boolean flag = true;
                for(int j=size-2;size-4<=j;j--){
                    if(before != check[(stack.get(j))]){
                        flag= false;
                        break;
                    }
                    before = stack.get(j);
                }
                if(flag){
                    answer++;
                    for(int j=0;j<4;j++){
                        stack.pop();
                    }
                }
            }
        }
        return answer;
    }
}
