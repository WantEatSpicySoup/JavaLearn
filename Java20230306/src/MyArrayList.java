import java.util.Arrays;

/**
 * Date: 2023.03.06
 * Description: ArrayList实现
 */
public class MyArrayList {
    /**
     * 数据域
     */
    private int[] elem;
    /**
     * 有效元素
     */
    private int realSize;

    // 构造方法 ====================
    /**
     * 无参构造
     * 默认大小:[10]
     */
    public MyArrayList() {
        this.elem = new int[10];
    }

    /**
     * 设置默认大小
     * @param num 初始化大小
     */
    public MyArrayList(int num) {
        this.elem = new int[num];
    }

    // 成员方法 ====================
    /**
     * 输出ArrayList所有值, 只用于测试。
     */
    public void printList() {
        for (int i = 0; i < this.realSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        // 换行
        System.out.println();
    }

    /**
     * 获取顺序表长度
     * @return 顺序表长度
     */
    public int size() {
        return this.realSize;
    }

    /**
     * 新增元素(默认在数组最后新增)
     *
     * @param data 新增元素
     */
    public void add(int data) {
        // 判断顺序表是否需扩容
        if (this.isFull()) {
            increaseArray();
        }
        // 新增元素
        this.elem[this.realSize] = data;
        // 有效元素+1
        this.realSize++;
    }

    /**
     * 判断顺序表是否已满
     * @return true:满 / false:未满
     */
    private boolean isFull() {
        return this.realSize == this.elem.length;
    }

    /**
     * 顺序表1.5倍扩容
     */
    private void increaseArray() {
        this.elem = Arrays.copyOf(this.elem, this.elem.length + (this.elem.length >> 1));
    }

    /**
     * 根据下标新增元素
     * @param pos 新增元素位置
     * @param data 新增元素
     */
    public void add(int pos, int data){
        // 下标判断
        try {
            examineIndex(pos);
        }catch (IndexOverException e) {
            e.printStackTrace();
            return;
        }
        // 尾部新增(无需移动的元素)
        if (pos == this.realSize) {
            this.add(data);
            return;
        }
        // 新增元素
        int cur = this.realSize;
        int prev = this.realSize - 1;
        // 是否扩容
        if (isFull()) {
            increaseArray();
        }
        while (cur != pos) {
            this.elem[cur] = this.elem[prev];
            cur--;
            prev--;
        }
        // 新增元素
        this.elem[pos] = data;
        // 有效元素+1
        this.realSize++;
    }

    /**
     * 检查下标是否合法
     * @param pos 检查下标
     * @throws IndexOverException 下标不合法异常
     */
    private void examineIndex(int pos) throws IndexOverException{
        if (pos < 0 || pos > this.realSize) {
            throw new IndexOverException("下标不合法，请重新输入!");
        }
    }

    /**
     * 判断顺序表是否包含某元素
     * @param toFind 查找元素
     * @return true:有 / false:无
     */
    public boolean contains(int toFind) {
        for (int i = 0; i < this.realSize; i++) {
            if (this.elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    /**
     * 返回某元素下标值
     * @param toFind 查找元素
     * @return 元素对应下标
     */
    public int indexOf(int toFind) {
        for (int i = 0; i < this.realSize; i++) {
            if (this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 更改指定位置元素
     * @param pos 元素下标
     * @param data 更改值
     */
    public void set(int pos, int data) {
        // 下标判断
        try {
            examineIndex(pos);
        } catch (IndexOverException e) {
            e.printStackTrace();
        }
        if (pos == this.realSize) {
            add(data);
            return;
        }
        // 更改元素
        this.elem[pos] = data;
    }

    /**
     * 删除第一个出现的元素
     * @param toRemove 删除值
     */
    public void remove(int toRemove) {
        int pos = indexOf(toRemove);
        // 没有该元素情况
        if (pos == -1) {
            return ;
        }
        // 最后一个元素
        if (pos == this.realSize - 1) {
            this.elem[pos] = 0;
            this.realSize--;
            return;
        }
        // 进行移位删除
        int cur = pos + 1;
        while (cur != this.realSize) {
            this.elem[pos] = this.elem[cur];
            pos++;
            cur++;
        }
        // 有效元素-1
        this.elem[pos] = 0;
        this.realSize--;
    }

    /**
     * 清空顺序表
     */
    public void clear() {
        // 各值设为空
        for (int i = 0; i < this.realSize; i++) {
            this.elem[i] = 0;
        }
        // 清空有效元素个数
        this.realSize = 0;
    }
}
