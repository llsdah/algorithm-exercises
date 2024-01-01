package zerobase.basicmathematics;

import java.util.*;

public class MySet {

    public static void main(String[] args) {

        // 집합사용 - HashSet

        // 교집합
        System.out.println("교집합");
        HashSet retainA = new HashSet(Arrays.asList(1,2,3,4,5));
        HashSet retainB = new HashSet(Arrays.asList(2,4,6,8,10));

        retainA.retainAll(retainB);
        System.out.println("교집합 : " + retainA);

        System.out.println("합집합");
        HashSet sumA = new HashSet(Arrays.asList(1,2,3,4,5));
        HashSet sumB = new HashSet(Arrays.asList(2,4,6,8,10));

        sumA.addAll(sumB);
        System.out.println("합집합 : " + sumA);

        System.out.println("차집합");

        HashSet minusA = new HashSet(Arrays.asList(1,2,3,4,5));
        HashSet minusB = new HashSet(Arrays.asList(2,4,6,8,10));

        minusA.removeAll(minusB);

        System.out.println("차집합 : " + minusA);

        System.out.println("내가 만든 것 테스트");

        MySet_main testA = new MySet_main();

        testA.add(1);
        testA.add(2);
        testA.add(3);
        testA.add(4);
        testA.add(5);

        MySet_main testB = new MySet_main();

        testB.add(2);
        testB.add(4);
        testB.add(6);
        testB.add(8);
        testB.add(10);

        System.out.println("testA : " + testA.list);
        System.out.println("testB : " + testB.list);

        testA = testA.retainAll(testB);
        System.out.println("testA : " + testA.list);
        testA= new MySet_main(new int[]{1,2,3,4,5});

        testA = testA.removeAll(testB);
        System.out.println("testA : " + testA.list);
    }

    /**
     * 아래 부터는 내 구현
     */
    static class MySet_main{
        private ArrayList<Integer> list;

        MySet_main(){
            this.list = new ArrayList<>();
        }
        MySet_main(int[] arr){
            this.list = new ArrayList<>();
            for (int number : arr ){
                list.add(number);
            }
        }
        // 원소 추가
        public void add(int num){
            for (int number : this.list){
                // 중복제거
                if(number == num){
                    return;
                }
            }
            this.list.add(num);
        }

        // 교집합
        public MySet_main retainAll(MySet_main set){
            MySet_main result = new MySet_main();
            for(int numberA : this.list){
                for(int numberB : set.list){
                    if(numberA == numberB){
                       result.add(numberA);
                    }
                }
            }
            return result;
        }

        // 합집합
        public MySet_main addAll(MySet_main set){
            MySet_main result = new MySet_main();
            for (int numberA : this.list){
                result.add(numberA);
            }
            for (int numberB : set.list){
                result.add(numberB);
            }
            return result;
        }

        // 차집합
        public MySet_main removeAll(MySet_main set){
            MySet_main result = new MySet_main();
            for(int numberA : this.list){
                boolean containFlag = false;
                for (int numberB : set.list){
                    if( numberA == numberB ){
                        containFlag = true;
                        break;
                    }
                }
                if(!containFlag){
                    result.add(numberA);
                }
            }
            return result;
        }

    }


}


