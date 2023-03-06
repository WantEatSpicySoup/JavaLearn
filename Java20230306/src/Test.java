/**
 * Date: 2023.03.06
 * Description: 测试MyArrayList
 */
public class Test {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList(5);
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);
        myArrayList.add(6);
        myArrayList.printList();
        System.out.println("========================");
        myArrayList.indexOf(6, 20);
        myArrayList.indexOf(4, 30);
        myArrayList.printList();
        System.out.println("========================");
    }
}
