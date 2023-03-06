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
        myArrayList.add(6, 20);
        myArrayList.add(4, 30);
        myArrayList.printList();
        System.out.println("========================");
        System.out.println(myArrayList.contains(1));
        System.out.println(myArrayList.contains(3));
        System.out.println(myArrayList.contains(6));
        System.out.println(myArrayList.contains(7));
        System.out.println("========================");
        System.out.println(myArrayList.indexOf(6));
        System.out.println(myArrayList.indexOf(7));
        System.out.println("========================");
        myArrayList.set(0, 310);
        myArrayList.printList();
        myArrayList.remove(310);
        myArrayList.printList();
        myArrayList.remove(20);
        myArrayList.printList();
        myArrayList.remove(30);
        myArrayList.printList();
        System.out.println("========================");
        myArrayList.clear();
        myArrayList.printList();
        System.out.println("========================");
    }
}
