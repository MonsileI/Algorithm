package 전체문제.sixth_month_2024_05.ninteenth_2024_05_29;

import java.util.*;
import java.io.*;
public class GR_DeadorArrive_Level_2 {
    static class Car implements Comparable<Car>{
        int speed; int power; int idx;

        public Car(int speed, int power, int idx) {
            this.speed = speed;
            this.power = power;
            this.idx = idx;
        }

        @Override
        public int compareTo(Car o) {
            return speed ==o.speed ? power==o.power ? -(idx - o.idx) : -(power - o.power) :-(speed-o.speed);
        }


    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st=  null;
        Car[] cars = new Car[N];
        Map<Integer,PriorityQueue<Car>> map = new HashMap<>();
        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine()," ");
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if(!map.containsKey(v)) map.put(v,new PriorityQueue<>());
            map.get(v).offer(new Car(v,w,(i+1)));
            cars[i] = new Car(v,w,(i+1));
        }
        int ans = 0;
        for(Integer key : map.keySet()){
            ans += map.get(key).poll().idx;
        }
        System.out.println(ans);

    }
}
