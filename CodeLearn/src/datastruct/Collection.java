package datastruct;

import java.util.LinkedList;

/**
 *  集合类使用
 * create by ZhouJianhua 2017/8/29
 * Email: zjhua678@163.com
 */
public class Collection {

    LinkedList<Integer> linkedList=new LinkedList<>();

    /**
     * 测试队列
     */
    void queueTest(){
        for(int i=0;i<10;i++){
            linkedList.add(i);
        }
        System.out.println(linkedList);

        System.out.println("poll:");
        for(int i=0;i<5;i++){
            int head=linkedList.poll();
            System.out.print(head+" ");
        }
        System.out.println();
        System.out.println("peek:\n"+linkedList.peek());
        linkedList.clear();
    }

    /**
     * 测试栈
     */
    void stackTest(){
        for(int i=0;i<10;i++){
            linkedList.push(i);
        }
        System.out.println(linkedList);
        for(int i=0;i<5;i++){
            int tail=linkedList.pop();
            System.out.print(tail+" ");
        }
        System.out.println();
        System.out.println(linkedList);
        linkedList.clear();
    }
    public  static  void main(String[] args){
        Collection collection=new Collection();
        System.out.println("--------queueTest------------");
        collection.queueTest();
        System.out.println("--------stackTest------------");
        collection.stackTest();
    }
}
