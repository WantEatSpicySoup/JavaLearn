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
        // 下标插入 测试
        singleLinkedList.addIndex(0, 10);
        singleLinkedList.addIndex(4, 22);
        singleLinkedList.addIndex(11, 22);
        singleLinkedList.printList();
        // 判断元素是否包含 测试
        System.out.println(singleLinkedList.contains(4));
        System.out.println(singleLinkedList.contains(7));
        System.out.println(singleLinkedList.contains(23));
        // 删除第一个出现值为key的元素 测试
        singleLinkedList.addLast(22);
        singleLinkedList.printList();
        singleLinkedList.removeOne(22);
        singleLinkedList.printList();
        singleLinkedList.removeOne(22);
        singleLinkedList.printList();
        singleLinkedList.removeOne(22);
        singleLinkedList.printList();
        singleLinkedList.removeOne(50);
        singleLinkedList.printList();
        System.out.println("============================");
        // 删除所有包含key元素节点 测试
        singleLinkedList.addFirst(9);
        singleLinkedList.addFirst(9);
        singleLinkedList.addFirst(9);
        singleLinkedList.addFirst(9);
        singleLinkedList.addLast(9);
        singleLinkedList.printList();
        singleLinkedList.removeAll(9);
        singleLinkedList.printList();
        // 清空链表 测试
        singleLinkedList.clear();
        System.out.println("清空链表:");
        singleLinkedList.printList();
    }
}
