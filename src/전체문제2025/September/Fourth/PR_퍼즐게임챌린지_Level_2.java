package 전체문제2025.September.Fourth;

public class PR_퍼즐게임챌린지_Level_2 {
    public static void main(String[] args) {
        int[]diffs = {1, 4, 4, 2};
        int[]times = {6, 3, 8, 2};
        long limit = 59;
        //result = 2;
        int answer = solution(diffs,times,limit);
        System.out.println(answer);
    }
    static int solution(int[] diffs, int[] times, long limit) {

        int left = 1; int right = 0;

        for(int i=0;i<diffs.length;i++) right = Math.max(right,diffs[i]);

        while(left<right){

            int mid = (left+right)/2;
            if(calc(mid,diffs,times) <= limit) right = mid;
            else left =mid+1;
        }
        return left;
    }
    static long calc(int level,int[]diffs,int []times){
        int len = diffs.length;
        long total = 0;
        for(int i=0;i<len;i++){

            total +=  times[i];
            if(diffs[i] <= level){
                continue;
            }

            int diffLevel = diffs[i] - level;
            int prevTime = 0;
            if(i!=0) total += (times[i-1]+times[i]) * diffLevel;

        }

        return total;
    }
}
