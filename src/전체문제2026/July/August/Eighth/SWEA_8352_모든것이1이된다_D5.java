package 전체문제2026.July.August.Eighth;

import java.util.*;
import java.io.*;
public class SWEA_8352_모든것이1이된다_D5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        int[]monthArr = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        int minute = 60;
        int hour = minute * 60;
        int day = hour * 24;
        int year = day * 365;
        for(int t=1;t<=TC;t++){
            String [] str = br.readLine().split(" ");
            String [] str1 = str[0].split("/");
            String [] str2 = str[1].split(":");

            String binary = br.readLine();
            int lastSecond = makeToSecond(binary);

            int nYear = Integer.parseInt(str1[0]);
            int nMonth = Integer.parseInt(str1[1]);
            int nDay = Integer.parseInt(str1[2]);
            int nHour = Integer.parseInt(str2[0]);
            int nMinute = Integer.parseInt(str2[1]);
            int nSecond = Integer.parseInt(str2[2]);

            //이번 년도에 남은 시간, 월, 일부터 1월 1일 00:00:00 처리
            lastSecond += ((nDay-1) * day);
            lastSecond += ((nHour) * hour);
            lastSecond += ((nMinute) * minute);
            lastSecond += nSecond;
            nMonth--;
            for(int i=nMonth; 0<i; i--){
                if(i==2 && isLeap(nYear)){
                    lastSecond += (29 * day);
                }else{
                    lastSecond += (monthArr[i] * day);
                }
            }
            nMonth = 1; nDay = 1;nHour = 0; nMinute = 0; nSecond = 0;

            //년도
            while(true){
                if(isLeap(nYear)){
                    if(lastSecond < (year+day)) break;
                    lastSecond -= (year+day);
                }
                else {
                    if(lastSecond < year) break;
                    lastSecond -= year;
                }
                nYear++;
            }
            //월
            while(true){
                if(nMonth==2 && isLeap(nYear)){
                    if(lastSecond < 29 * day) break;
                    lastSecond -= (29 * day);
                }else{
                    if(lastSecond < monthArr[nMonth] * day) break;
                    lastSecond -= (monthArr[nMonth] * day);
                }
                nMonth++;
            }
            //일
            while(true){
                if(lastSecond < day) break;
                lastSecond -= day;
                nDay++;
            }
            //시간
            nHour = lastSecond / hour;
            lastSecond %= hour;
            nMinute = lastSecond / minute;
            lastSecond %= minute;
            nSecond = lastSecond;
            String answer = makeToResult(nYear,nMonth,nDay,nHour,nMinute,nSecond);
            sb.append("#"+t+" "+answer+"\n");

        }
        System.out.println(sb.toString());
    }
    static String makeToResult(int year,int month, int day, int hour, int minute, int second){
        String str = String.valueOf(year)+"/";
        str += makeFormat(month)+"/";
        str += makeFormat(day)+" ";
        str += makeFormat(hour)+":";
        str += makeFormat(minute)+":";
        str += makeFormat(second);
        return str;
    }
    static String makeFormat(int num){
        if(num<10) return String.valueOf("0"+num);
        return String.valueOf(num);
    }
    static boolean isLeap(int year){
        if((year%400==0)||(year%4==0 && year%100!=0)) return true;
        return false;
    }
    static int makeToSecond(String str){
        int num = 0;
        int plus = 1;
        for(int i=0;i<str.length();i++) {
            num += plus;
            plus *= 2;
        }
        return num;
    }
}
