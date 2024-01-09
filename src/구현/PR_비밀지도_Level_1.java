package 구현;

import java.util.Arrays;

public class PR_비밀지도_Level_1 {


    static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0;i<n;i++){
            String ans = "";
            String f = Integer.toBinaryString(arr1[i]);
            String s = Integer.toBinaryString(arr2[i]);
            int fSize=  f.length();
            int sSize=  s.length();
            while(fSize<n){
                f = '0' + f;
                fSize++;
            }
            while(sSize<n){
                s = '0'+ s;
                sSize++;
            }
            for(int j=0;j<n;j++){
                int fNum = f.charAt(j)=='0' ? 0 : 1;
                int sNum = s.charAt(j)=='0' ? 0 : 1;
                int check = fNum | sNum;
                ans += (check==0) ? " ": "#";
            }
            answer[i] = ans;
        }
        return answer;
    }



    public static void main(String[] args) throws Exception{
        /*
        TEST CASE
        1.
        int n = 5;
        int [] arr1 = {9, 20, 28, 18, 11};
        int [] arr2 = {30, 1, 21, 17, 28};
        String[]result = {"#####","# # #", "### #", "# ##", "#####"};

        2.
        int n = 6;
        int [] arr1 = {46, 33, 33 ,22, 31, 50};
        int [] arr2 = {27 ,56, 19, 14, 14, 10};
        String[]result = {"######", "### #", "## ##", " #### ", " #####", "### # "};
        * */
        int n = 5;
        int [] arr1 = {9, 20, 28, 18, 11};
        int [] arr2 = {30, 1, 21, 17, 28};
        System.out.println(Arrays.toString(solution(n,arr1,arr2)));
    }
}
