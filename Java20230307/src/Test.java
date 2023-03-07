/**
 * Date: 2023.03.07
 * Description: SingleLikedList 测试
 */
public class Test {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        // 头插法 测试
        singleLinkedList.addFirst(1);
        singleLinkedList.addFirst(2);
        singleLinkedList.addFirst(3);
        singleLinkedList.addFirst(4);
        singleLinkedList.printList();
        // 尾插法 测试
        singleLinkedList.addLast(5);
        singleLinkedList.addLast(6);
        singleLinkedList.addLast(7);
        singleLinkedList.addLast(8);
        singleLinkedList.addLast(9);
        singleLinkedList.printList();
    }
}
