package 전체문제2026.November.Third;

public class PR_키패드누르기_Level_2 {
    public static void main(String[] args) {
        int[]numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(solution(numbers,hand));
    }
    static String solution(int[] numbers, String hand) {
        String answer = "";
        //1 4 7 왼손 3 6 9 오른손
        // 처음엔 왼손 *, 오른손 #
        // 2580은 가까운거
        int[][]middle = {{3,1},{0,1},{1,1},{2,1}};
        StringBuilder sb = new StringBuilder();
        int li = 3; int lj = 0;
        int ri = 3; int rj = 2;
        for(int n : numbers){
            if(n==1 ||n==4 || n==7) {
                switch (n){
                    case 1 : li = 0;
                    break;
                    case 4 : li = 1;
                    break;
                    case 7 : li = 2;
                    break;
                }
                lj = 0;
                sb.append("L");
                continue;
            }
            if(n==3 || n==6 || n==9){
                switch (n){
                    case 3 : ri = 0;
                        break;
                    case 6 : ri = 1;
                        break;
                    case 9 : ri = 2;
                        break;
                }
                rj = 2;
                sb.append("R");
                continue;
            }
            //0 2 5 8
            if(n==2) n = 1;
            else if(n==5) n =2;
            else if(n==8) n =3;
            int lDiff = Math.abs(li - middle[n][0]) + Math.abs(lj - middle[n][1]);
            int rDiff = Math.abs(ri - middle[n][0]) + Math.abs(rj - middle[n][1]);
            if(lDiff<rDiff){
                sb.append("L");
                li = middle[n][0]; lj = middle[n][1];
            }else if(rDiff<lDiff){
                sb.append("R");
                ri = middle[n][0]; rj = middle[n][1];
            }else{
                if(hand.equals("left")){
                    sb.append("L");
                    li = middle[n][0]; lj = middle[n][1];
                }else if(hand.equals("right")){
                    sb.append("R");
                    ri = middle[n][0]; rj = middle[n][1];
                }
            }
        }
        answer = sb.toString();
        return answer;
    }
}
