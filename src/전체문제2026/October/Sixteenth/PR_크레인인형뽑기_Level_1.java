package 전체문제2026.October.Sixteenth;

import java.util.Stack;

public class PR_크레인인형뽑기_Level_1 {
    public static void main(String[] args) {
        int[][]board = {{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}};
        int[]moves = {1,5,3,5,1,2,1,4};
        System.out.println(solution(board,moves));
    }
    static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int N = board.length;
        for(int j : moves){
            j--;
            int i = 0;
            while(i<N){
                if(board[i][j]!=0){
                    if(!stack.isEmpty()){
                        if(stack.peek()==board[i][j]) {
                            answer += 2;
                            stack.pop();
                        }
                        else stack.push(board[i][j]);
                    }else{
                        stack.push(board[i][j]);
                    }
                    board[i][j] = 0;
                    break;
                }
                i++;
            }
        }
        return answer;
    }
}
