/**
 * Created by zyn on 2017/5/18.
 */
public class BowlingGame {
    public int getBowlingScore(String bowlingCode) {
        int[][] play = new int[12][2];
        int idx = 0 ;
        for (int i = 0; i < 10; i++) {
            //第一球全中
            if(bowlingCode.charAt(idx)=='X'){
                play[i][0]=10;
                idx+=2;
            }//或者第一球只能是-和数字
            else{
                play[i][0] = bowlingCode.charAt(idx)=='-' ? 0 : bowlingCode.charAt(idx)-'0';
                if(bowlingCode.charAt(idx+1)=='X')
                    play[i][1] = 10;
                else if(bowlingCode.charAt(idx+1)=='/')
                    play[i][1] = 10 - play[i][0];
                else
                    play[i][1] = bowlingCode.charAt(idx+1)=='-' ? 0 : bowlingCode.charAt(idx+1)-'0';
                idx += 3;
            }
        }
        if(play[9][0]==10){
            //补两局
            idx +=1;
            if(bowlingCode.charAt(idx)=='X') {
                play[10][0] = 10;
                if(bowlingCode.charAt(idx+1)=='X')
                    play[11][0] = 10;
                else
                    play[11][0] = bowlingCode.charAt(idx+1)=='-' ? 0 : bowlingCode.charAt(idx+1)-'0';
            }
            else{
                play[10][0] = bowlingCode.charAt(idx)=='-'?0: bowlingCode.charAt(idx)-'0';
                if(bowlingCode.charAt(idx+1)=='X')
                    play[10][1] = 10;
                else
                    play[10][1] = bowlingCode.charAt(idx+1)=='-' ? 0 : bowlingCode.charAt(idx+1)-'0';
            }
        }
        //补一局
        else if ((play[9][0] + play[9][1]) == 10) {
            idx += 1;
            if (bowlingCode.charAt(idx) == 'X')
                play[10][0] = 10;
            else
                play[10][0] = bowlingCode.charAt(idx) == '-' ? 0 : bowlingCode.charAt(idx) - '0';
        }


       //计算分值
        int score = 0;
        for (int i = 0; i < 10; i++) {
            if(play[i][0]==10){
                if(play[i+1][0]==10)
                    score += 10 + play[i+1][0] + play[i+2][0];
                else
                    score += 10 + play[i+1][0] + play[i+1][1];
            }
            else if(play[i][0]+play[i][1]==10) {
                score += 10 + play[i + 1][0];
            }
            else
                score += play[i][0] + play[i][1];
        }
        return score;
    }
}
