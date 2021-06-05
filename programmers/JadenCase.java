class Solution {
    public String solution(String s) {
        char[] arr = s.toLowerCase().toCharArray();
        int num =0;
        if(arr[0]>='a'&&arr[0]<='z') arr[0]=(char)((int)arr[0]-32);
        //97 65  소문자 -> 대문 - 32
        //char aaa ='A';
        for(int i =1; i< arr.length;i++){
            if(arr[i-1]==' '&&arr[i]>='a'&&arr[i]<='z'){
                arr[i]=(char)((int)arr[i]-32);
            }
        }
        String answer = new String(arr);
        return answer;
    }
}
