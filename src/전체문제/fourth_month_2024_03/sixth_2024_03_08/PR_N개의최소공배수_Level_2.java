package 전체문제.fourth_month_2024_03.sixth_2024_03_08;

public class PR_N개의최소공배수_Level_2 {

    static int solution(int[] arr) {
        int N = arr.length;
        int num = arr[0];
        for(int i=1;i<N;i++){
            num = (num*arr[i])/gcd(num,arr[i]);
        }
        return num;
    }
    static int gcd(int a,int b){
        int min = Math.min(a,b);
        int max = Math.max(a,b);
        while(max!=0){
            int tmp = min % max;
            min = max;
            max = tmp;
        }
        return min;
    }

    public static void main(String[] args) {
        /*
        TEST CASE
        1.
        int[]arr = {2,6,8,14};

        int result = 168;
        2.
        int[]arr = {1,2,3};

        int result = 6;
        * */
        int[]arr = {2,6,8,14};
        System.out.println(solution(arr));
    }
}
