package programmers;

public class 카드뭉치 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        boolean flag = false;
        int index1 = 0;
        int index2 = 0;

        for(int i = 0; i< goal.length;i++){
            if(!flag){
                if( index1 < cards1.length && goal[i].equals(cards1[index1])){
                    index1++;
                }else if(index2 < cards2.length && goal[i].equals(cards2[index2])){
                    index2++;
                    flag = !flag;
                }else{
                    return "No";
                }
            }else{
                if( index2 < cards2.length && goal[i].equals(cards2[index2])){
                    index2++;
                }else if( index1 < cards1.length &&
                        goal[i].equals(cards1[index1])){
                    index1++;
                    flag = !flag;
                }else{
                    return "No";
                }
            }
        }

        return answer;
    }
}
