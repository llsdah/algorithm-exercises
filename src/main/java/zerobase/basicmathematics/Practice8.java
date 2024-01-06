package zerobase.basicmathematics;

/**
 * 1차 방정식의 풀이 만들기, 해가 무수히 많은경우, 해가 없는경우 
 */
public class Practice8 {
    public static void main(String[] args) {
        solution("x+5-3+x=6+x-2");
        solution("x=x");
        solution("x=x+1");
        solution("2x=x");
    }
    public static void solution(String equation){
        String[] parts = equation.split("=");
        /**
         * 좌변 우변 나누고 , 각 변에는 상수 1개, x 1개가 들어있다. 0번과 1번에 
         */
        int[] left = evaluate(parts[0]);
        int[] right = evaluate(parts[1]);
        if(left[0]==right[0]&&left[1]==right[1]){
            System.out.println("무제한 작적");
        }else if(left[0]==right[0]){
            System.out.println("답이 없음");
        }else{
            System.out.println("x="+(right[1]-left[1])/(right[0]-left[0]));
        }



        System.out.println("확인");
        int[] left1 = evaluate1(parts[0]);
        int[] right1 = evaluate1(parts[1]);
        if(left1[0]==right1[0]&&left1[1]==right1[1]){
            System.out.println("무제한 작적");
        }else if(left1[0]==right1[0]){
            System.out.println("답이 없음");
        }else{
            System.out.println("x="+(right1[1]-left1[1])/(right1[0]-left1[0]));
        }
        System.out.println("확인");
    }

    private static int[] evaluate(String part) {
        int[] result = new int[2];
        boolean isMinus = false;
        int index =0;
        while(index != part.length()){
            char c = part.charAt(index);
            index++;
            
            if(c=='+'){
                continue;
            }
            if(c=='-'){
                isMinus = true;
                continue;
            }
            // 상수 확인
            if(c=='x'){
                result[0]+= isMinus? -1:1;
            }else{
                // 혹시 인덱스가 넘을까봐, x 일까봐 다음이 -3x
                if(index<part.length()&& part.charAt(index)=='x'){
                    result[0]+=isMinus ? -(c-'0'):(c-'0');
                }else {
                    result[1]+=isMinus ? -(c-'0'):(c-'0');
                }
            }
        }
        return result;
    }

    // 방법 2
    private static int[] evaluate1(String part) {
        int[] result = new int[2];
        //정규 표현식
        String[] arr = part.split("(?=[+-])");
        for(String s : arr){
            //System.out.println(s);
            if(s.equals("+x")||s.equals("x")){
                result[0]++;
            }else if (s.equals("-x")) {
                result[0]--;
            }else if (s.contains("x")){
                result[0]+= Integer.parseInt(s.substring(0,s.length()-1));
            }else{
                result[1]+= Integer.parseInt(s);
            }
        }
        return result;
    }
}
