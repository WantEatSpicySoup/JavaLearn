import java.util.LinkedList;

/**
 * Date: 2023.03.07
 * Description: SingleLinkedList 实现
 */
public class SingleLinkedList {
    /**
     * 数据域
     */
    private int val;
    /**
     * 节点域
     */
    private SingleLinkedList next;
    /**
     * 头节点
     */
    private SingleLinkedList head;

    // 构造方法 ======================
    public SingleLinkedList() {

    }
    public SingleLinkedList(int data) {
        this.val = data;
    }

    // 成员方法 =====================
    /**
     * 打印单链表
     */
    public void printList() {
        // 链表判空
        if (this.head == null) {
            return;
        }
        // 遍历输出
        SingleLinkedList cur = this.head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        // 换行
        System.out.println();
    }

    /**
     * 头插法
     * @param data 插入值
     */
    public void addFirst(int data) {
        // 创建新节点
        SingleLinkedList newNode = new SingleLinkedList(data);
        if (this.head == null) {
            this.head = newNode;
            return;
        }
        newNode.next = this.head;
        this.head = newNode;
    }

    /**
     * 尾插法
     * @param data 插入元素
     */
    public void addLast(int data) {
        // 单链表无节点
        if (this.head == null) {
            addFirst(data);
            return;
        }
        // 创建新节点
        SingleLinkedList newNode = new SingleLinkedList(data);
        // 获取最后节点位置
        SingleLinkedList lastNode = getLastAddress();
        // 节点尾插
        lastNode.next = newNode;
    }

    /**
     * 获取最后节点位置
     * @return 最后节点
     */
    private SingleLinkedList getLastAddress() {
        SingleLinkedList cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    public void addIndex(int index, int data) throws IndexException{
        if (index < 0) {
            throw new IndexException("下标异常，请重新输入！");
        }
        // 查找下标index的节点
        SingleLinkedList indexNode = findIndexNode(index);
        if (indexNode == null) {
            throw new IndexException("下标异常，请重新输入！");
        }
        SingleLinkedList newNode = new SingleLinkedList(data);

    }

    /**
     * 找到下标为index的节点
     * @param index 下标
     * @return index个节点
     */
    private SingleLinkedList findIndexNode(int index) {
        SingleLinkedList cur = this.head;
        while (cur != null) {
            if (index == 1) {
                return cur;
            }
            cur = cur.next;
            index--;
        }
        return null;
    }
}
