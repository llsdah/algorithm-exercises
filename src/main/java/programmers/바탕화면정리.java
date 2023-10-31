package programmers;

public class 바탕화면정리 {

    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        char[][] charTwo = new char[wallpaper.length][wallpaper[0].length()];
        answer[0] = wallpaper.length;
        answer[1] = wallpaper[0].length();

        for(int i =0; i<wallpaper.length;i++){
            char[] charOne = wallpaper[i].toCharArray();
            for(int k=0; k<charOne.length;k++){
                charTwo[i][k] = charOne[k];
            }
        }
        //System.out.println();
        for(int i =0; i<wallpaper.length;i++){
            for(int k=0; k<wallpaper[0].length();k++){
                if(charTwo[i][k]=='#'){
                    answer[0] = Math.min(answer[0],i);
                    answer[1] = Math.min(answer[1],k);
                    answer[2] = Math.max(answer[2],i);
                    answer[3] = Math.max(answer[3],k);
                }
            }
        }

        answer[2] ++;
        answer[3] ++;

        return answer;
    }
}
