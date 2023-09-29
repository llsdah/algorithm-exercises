import java.util.*;
class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> no = new Stack<>();
        int total = n;// 전체 갯수
        int pos=k;// 현재 위치 
        
        for(int i=0; i<cmd.length;i++){
            char ch = cmd[i].charAt(0);
            
            if(ch=='U'){
                pos-= Integer.valueOf(cmd[i].substring(2));
                pos = Math.max(0,pos);// 혹시 0 아래 
            
            }else if( ch=='D'){
                pos+= Integer.valueOf(cmd[i].substring(2));
                pos = Math.min(pos,total-1); // 혹시 최대값이 벗어 날 경우 대비 
            
            }else if(ch=='C'){
                no.push(pos);
                total --; // 최대 값이 .. 모자라
                if(pos==total) pos--;
            }else if(ch=='Z'){
                int r = no.pop();
                if(pos>=r) pos++; //밑에 있으면
                total ++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<total;i++){
            sb.append("O");
        }
        while(!no.isEmpty()){
            //System.out.println(no.pop());
           sb.insert(no.pop().intValue(),"X");
        }
           
        
        String answer = sb.toString();
        return answer;
    }
}

// 틀린 부분...  어디가 틀릴까. 일단 느리다 제거 삭제를 계속 해야되서 그렇지만 생각하보면 삭제될것만 알고 있으면된다. 
public static String solution(int n, int k, String[] cmd) {
    	ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<n;i++){
            list.add(i);    // 위치는 0~ n-1까지 있다. 
        }
        ArrayList<int[]> saveList = new ArrayList<>();// 삭제 된거 저장용
        //int[] save = {-1,-1};// 최근 삭제된 것 임시 저장용 위치, 값 
        
        int pos = k;// 현재 위치
        for(int i=0; i<cmd.length;i++){
            String[] arr = cmd[i].split(" ");// 
            
            if(arr[0].equals("Z")){// 되살리기
            
            	if(saveList.size()==0) continue; // 아무것도 없으면 넘어가
                int leng = saveList.size()-1;
                int[] save = saveList.get(leng);
                
                if( save[0]==-1) list.add(save[1]);// 마지막 값이면
                else list.add(save[0],save[1]);// 해당 위치에 넣기
                
                if(pos>save[0]&&save[0]!=-1)pos++;
                
                saveList.remove(leng);// 넣었으니 삭제
            }else if(arr[0].equals("C")){ // 삭제
                int[] save = new int[2];
                save[1] = list.get(pos);// 해당 위치의 값 저장 하기
                save[0] = pos==list.size()-1 ? -1 : pos;// 해당 위치 저장하기 맨 뒤면 -1
                list.remove(pos);
                pos = Math.min(pos,list.size()-1);// 혹시 맨 아래 삭제시
                saveList.add(save);
            }else if(arr[0].equals("D")){
                pos += Integer.valueOf(arr[1]);
                pos = Math.min(pos,list.size()-1);// 혹시 최대값 벗어나면. 맨아래니까.
            }else if(arr[0].equals("U")){
                pos -= Integer.valueOf(arr[1]);
                pos = Math.max(pos,0);// 혹시 그 밑으로 내려가면
            }
            
            System.out.println("i : "+i+" pos : "+pos + " list :  "+list.toString()+" cmd : "+Arrays.toString(arr)+" save : ");

        }
        
        char[] arr = new char[n];
        Arrays.fill(arr,'X');
        for(int i=0; i<list.size();i++){
            arr[list.get(i)]='O';
        }
        //arr[1]='O';
        String answer = new String(arr);
        return answer;
    }
    
