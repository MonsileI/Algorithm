package 전체문제.thirteenth_month_2025_06.first_25_06_21;

import java.util.*;
import java.io.*;
public class BJ_20006_랭킹전대기열_Silver_2  {

    static class Room {

        List<Player> player;
        int minLevel;
        int maxLevel;

        boolean hasStarted;

        public Room(List<Player> player,int minLevel, int maxLevel, boolean hasStarted) {
            this.player = player;
            this.minLevel = minLevel;
            this.maxLevel = maxLevel;
            this.hasStarted = hasStarted;
        }
    }
    static class Player implements Comparable<Player>{
        String name;
        int level;

        @Override
        public int compareTo(Player o) {
            return this.name.compareTo(o.name);
        }

        public Player(String name, int level) {
            this.name = name;
            this.level = level;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int pCnt = Integer.parseInt(st.nextToken());
        int rCnt = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        // 플레이어 배열
        // 레벨 최소 ,최대
        List<Room> list = new ArrayList<>();
        boolean flag = true;
        for(int p=0;p<pCnt;p++){
            st = new StringTokenizer(br.readLine()," ");
            int level = Integer.parseInt(st.nextToken());
            String player = st.nextToken();
            if(list.size() == 0){
                boolean check = false;
                if(rCnt == 1 ){
                    check = true;
                }
                list.add(new Room(new ArrayList<>(Arrays.asList(new Player(player,level))),level-10,level+10, check));
                continue;
            }
            flag = false;
            for(Room room : list){
                if(room.player.size() == rCnt){
                    room.hasStarted = true;
                }
                if(room.hasStarted) {
                    continue;
                }
                if(room.minLevel <= level && level <= room.maxLevel){
                    room.player.add(new Player(player,level));
                    flag = true;
                    if(room.player.size() == rCnt){
                        room.hasStarted = true;
                    }
                }

                if(flag) {
                    break;
                }
            }
            if(flag == false){
                boolean check = false;
                if(rCnt == 1 ){
                    check = true;
                }
                list.add(new Room(new ArrayList<>(Arrays.asList(new Player(player,level))),level-10,level+10, check));
            }
        }
        for(Room room : list){
            if(room.hasStarted){
                sb.append("Started!");
                sb.append("\n");
            }else{
                sb.append("Waiting!");
                sb.append("\n");
            }
            Collections.sort(room.player);
            for(Player p : room.player){
                sb.append(String.format("%d %s",p.level,p.name));
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}