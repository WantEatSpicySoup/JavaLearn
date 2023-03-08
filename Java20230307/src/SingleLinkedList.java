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
     * 计算当前单链表长度
     * @return 单链表长度
     */
    public int size() {
        if (this.head == null) {
            return -1;
        }
        int count = 0;
        SingleLinkedList cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
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

    /**
     * 根据下标插入元素
     * @param index 下标
     * @param data 元素
     */
    public void addIndex(int index, int data) {
        // 判断下标
        try {
            checkIndex(index);
        } catch (IndexException e) {
            e.printStackTrace();
            return;
        }
        // 下标为0调用头插法
        if (index == 0) {
            addFirst(data);
            return;
        }
        // 下标为size()调用尾插法
        if (index == size()) {
            addLast(data);
            return;
        }
        // 找到index-1节点
        SingleLinkedList prevNode = findPrevNode(index);
        // 创建新节点
        SingleLinkedList newNode = new SingleLinkedList(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    /**
     * 找到下标值前一节点
     * @param index 下标
     * @return 前一节点
     */
    private SingleLinkedList findPrevNode(int index) {
        SingleLinkedList prev = this.head;
        while (index-1 != 0) {
            prev = prev.next;
            index--;
        }
        return prev;
    }

    /**
     * 检查下标是否合法
     * @param index 检查的下标
     * @throws IndexException 可能抛出的异常
     */
    public void checkIndex(int index) throws IndexException{
        if (index < 0 || index > size()) {
            throw new IndexException("下标不合法，请重新输入");
        }
    }

    /**
     * 判断单链表中是否包含key元素
     * @param key 要判断元素
     * @return true:包含 / false:不包含
     */
    public boolean contains(int key) {
        // 判空
        if (this.head == null) {
            return false;
        }
        SingleLinkedList cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        // key元素不存在
        return false;
    }

    /**
     * 删除第一次出现的关键字key
     * @param key 删除的值
     */
    public void removeOne(int key) {
        // 判空
        if (this.head == null) {
            return;
        }
        // 单链表1个元素
        if (this.head.val == key) {
            this.head = this.head.next;
            return;
        }
        // 找到key前一个节点
        SingleLinkedList prev = findPrev(key);
        // 判空
        if (prev == null) {
            return;
        }
        // 删除
        prev.next = prev.next.next;
    }

    /**
     * 找到key元素前一个节点
     * @param key 要查找元素
     * @return key前一个节点
     */
    private SingleLinkedList findPrev(int key) {
        SingleLinkedList cur = this.head;
        while (cur.next != null) {
            if (cur.next.val == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    /**
     * 删除值为key的所有节点
     * @param key 要删除元素的值
     */
    public void removeAll(int key) {
        // 判空
        if (this.head == null) {
            return;
        }
        SingleLinkedList cur = this.head.next;
        SingleLinkedList prev = this.head;
        while (cur != null) {
            if (cur.val == key) {
                prev.next = cur.next;
            }else {
                prev = cur;
            }
            cur = cur.next;
        }
        // 处理头节点数据
        if (this.head.val == key) {
            this.head = this.head.next;
        }
    }

    /**
     * 清空单链表
     */
    public void clear() {
        // 判空
        if (this.head == null) {
            return;
        }
        SingleLinkedList cur = this.head.next;
        while (cur != null) {
            this.head.next = null;
            this.head = cur;
            cur = cur.next;
        }
        this.head = null;
    }
}
