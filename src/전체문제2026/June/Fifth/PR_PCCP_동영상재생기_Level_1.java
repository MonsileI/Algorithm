package 전체문제2026.June.Fifth;

public class PR_PCCP_동영상재생기_Level_1 {
    public static void main(String[] args) {
        String video_len = "10:55";
        String pos = "00:05";
        String op_start = "00:15";
        String op_end = "06:55";
        String[]commands = {"prev", "next", "next"};
        System.out.println(solution(video_len,pos,op_start,op_end,commands));
    }
    static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int curPos = changeTimeToInt(pos);
        int opStart = changeTimeToInt(op_start);
        int opEnd = changeTimeToInt(op_end);
        int videoLen = changeTimeToInt(video_len);
        if(opStart<=curPos && curPos<=opEnd){
            curPos = opEnd;
        }
        for(String str : commands){
            switch (str){
                case "prev":
                    curPos -= 10;
                    if(curPos < 0){
                        curPos = 0;
                    }
                break;
                case "next":
                    curPos += 10;
                    if(videoLen < (curPos+9)){
                        curPos = videoLen;
                    }
                break;
            }
            if(opStart<=curPos && curPos<=opEnd){
                curPos = opEnd;
            }
        }
        String answer = changeTimeToStr(curPos);
        return answer;
    }
    static String changeTimeToStr(int time){
        int hour = time/60;
        int minute = time % 60;
        String result = "";
        if(hour<10) result += "0";
        result += hour+":";
        if(minute<10) result += 0;
        result += minute;
        return result;
    }
    static int changeTimeToInt(String str){
        String[]tmp = str.split(":");
        int time = Integer.parseInt(tmp[0]) * 60;
        time += Integer.parseInt(tmp[1]);
        return time;
    }

}
