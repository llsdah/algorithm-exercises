package zerobase.linear;

public class LinearTest {

    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.addData(1);
        myLinkedList.addData(2);
        myLinkedList.addData(3);
        myLinkedList.addData(4);
        myLinkedList.addData(5);
        System.out.println("???");
        myLinkedList.showAllData();

        boolean findData = myLinkedList.findData(3);
        System.out.println(findData);

        myLinkedList.removeData(4);
        myLinkedList.addData(6,2);
        myLinkedList.addData(7,null); //맨뒤에 넣으려면 null
        myLinkedList.showAllData();

    }


}
