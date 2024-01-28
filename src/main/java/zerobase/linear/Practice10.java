package zerobase.linear;

import zerobase.linear.stringLinear.MyLinkedList;

import java.util.HashSet;

/**
 * 연결리스트 배열 사용 연습
 * 주어진 문자열 배열을 연결리스트 배열로 관리하는 코드
 * 규칙 : 각 문자열의 첫 글자가 같은 것끼리 같은 연결 리스트로 관리하기
 */
public class Practice10 {

    public static void main(String[] args) {
        String[] input = {"apple", "watermelon", "banana", "apricot", "kiwi", "blueberry"};
        dataCollect(input);

    }

    private static void dataCollect(String[] input) {
        HashSet<Character> set = new HashSet<>();

        for (String item : input){
            set.add(item.toCharArray()[0]);
        }

        System.out.println(set);

        Character[] arr = set.toArray(new Character[0]);
        MyLinkedList[] list = new MyLinkedList[arr.length];
        for(int i = 0;i < list.length;i++){
            list[i] = new MyLinkedList(null,arr[i]);

        }

        for(String str : input){
            for(MyLinkedList item : list){
                if(item.ch == str.toCharArray()[0]){
                    item.addData(str);
                }
            }

        }

        for(MyLinkedList item : list){
            System.out.print(item.ch+ " : ");
            item.showAllData();

        }
    }
}
