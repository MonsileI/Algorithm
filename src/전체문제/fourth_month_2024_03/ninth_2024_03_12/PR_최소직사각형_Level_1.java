package 전체문제.fourth_month_2024_03.ninth_2024_03_12;

public class PR_최소직사각형_Level_1 {
    static int solution(int[][] sizes) {
        int garo = 0;
        int sero = 0;
        for(int[] i : sizes){
            int tMax = Math.max(i[1],i[0]);
            int tMin = Math.min(i[1],i[0]);
            garo = Math.max(garo,tMax);
            sero = Math.max(sero,tMin);
        }
        return (garo*sero);
    }
    public static void main(String[] args) {
        /*
        TEST CASE
        1.
        int[][]size = {{60, 50},{30, 70},{60, 30},{80, 40}};
        int result = 4000;
        2.
        int[][]size = {{10, 7},{12, 3},{8, 15},{14, 7},{5, 15}};
        int result = 120;
        3.
        int[][]size = {{14, 4},{19, 6},{6, 16},{18, 7},{7, 11}};
        int result = 133;
         */
        int[][]size = {{60, 50},{30, 70},{60, 30},{80, 40}};
        System.out.println(solution(size));
    }
}
