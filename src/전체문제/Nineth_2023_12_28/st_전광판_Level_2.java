package 전체문제.Nineth_2023_12_28;
import java.util.*;
import java.io.*;

public class st_전광판_Level_2 {

    static boolean[][] numbers = {{true,true,false,true,true,true,true},
                                {false,true,false,false,true,false,false},
                                {true,true,true,false,false,true,true},
                                {true,true,true,false,true,true,false},
                                {false,true,true,true,true,false,false},
                                {true,false,true,true,true,true,false},
                                {true,false,true,true,true,true,true},
                                {true,true,false,true,true,false,false},
                                {true,true,true,true,true,true,true},
                                {true,true,true,true,true,true,false},
                                {false,false,false,false,false,false,false}};
    //뒤에 부터
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


        for (int t = 0; t < TC; t++) {
            String[]tmp = br.readLine().split(" ");
            String f = tmp[0]; String s = tmp[1];
            int fSize = f.length(); int sSize =s.length();
            int ans = 0;
            if(fSize==sSize){
                for(int i=0;i<fSize;i++){
                    int firNum= Integer.parseInt(f.charAt(i)+"");
                    int secNum= Integer.parseInt(s.charAt(i)+"");
                    for(int j=0;j<7;j++) if(numbers[firNum][j]!=numbers[secNum][j]) ans++;
                }
            }else if(fSize<sSize){
                while(true){
                    f = "d"+f;
                    fSize++;
                    if(fSize==sSize) break;
                }
                for(int i=0;i<sSize;i++){
                    int firNum = 0;
                    if(f.charAt(i)=='d') firNum = 10;
                    else firNum= Integer.parseInt(f.charAt(i)+"");
                    int secNum= Integer.parseInt(s.charAt(i)+"");
                    for(int j=0;j<7;j++) if(numbers[firNum][j]!=numbers[secNum][j]) ans++;
                }

            }else{
                while(true){
                    s = "d"+s;
                    sSize++;
                    if(fSize==sSize) break;
                }
                for(int i=0;i<fSize;i++){
                    int firNum= Integer.parseInt(f.charAt(i)+"");
                    int secNum = 0;
                    if(s.charAt(i)=='d') secNum = 10;
                    else secNum= Integer.parseInt(s.charAt(i)+"");
                    for(int j=0;j<7;j++) if(numbers[firNum][j]!=numbers[secNum][j]) ans++;
                }
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb.toString());
    }
}
