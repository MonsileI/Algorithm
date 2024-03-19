package 전체문제.fourth_month_2024_03.thirteenth_2024_03_18;

public class 기출문제_상호평가 {
    public static void main(String[] args) {
        /*
        TEST CASE
        1.
        int[][]scores = {{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}};
        String result = "FBABD";

        2.
        int[][]scores = {{50,90},{50,87}};
        String result = "DA";

        3.
        int[][]scores = {{70,49,90},{68,50,38},{73,31,100}};
        String result = "CFD";

        * */
        int[][]scores = {{70,49,90},{68,50,38},{73,31,100}};
        int N = scores.length;
        //90이상 A 80점 이상 70점 이상 C 60점 이상 D
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            int my = scores[i][0];
            int min = my;
            int max = my;
            double sum  = 0;
            boolean flag = false;
            for(int j=0;j<N;j++){
                if(i==j) continue;
                int s = scores[j][i];
                if(min==s) flag = true;
                min = Math.min(min,s);
                max = Math.max(max,s);
                sum += s;
            }
            int cnt = N;
            if(!flag){
                if(my==min || my==max) cnt--;
                else sum += my;
            }else sum += my;
            double avg = sum/cnt;
            if(avg>=90) sb.append('A');
            else if(avg>=80) sb.append('B');
            else if(avg>=70) sb.append('C');
            else if(avg>=50) sb.append('D');
            else sb.append('F');
        }
        System.out.println(sb.toString());
    }
}
