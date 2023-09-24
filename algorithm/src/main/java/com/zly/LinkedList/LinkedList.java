package com.zly.LinkedList;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/7/8 13:51
 **/
public class LinkedList{
    /**
     * @descriptions 定义node节点
     * @author zhaoliyang9
     * @date 2023/7/8 15:21
     * @param
     * @return
     **/
    static class ListNode{
        int val;
        ListNode next = null;
        public ListNode(int val){
            this.val = val;
        }
    }
    /**
     * @descriptions 使用数组初始化链表
     * @author zhaoliyang9
     * @date 2023/7/8 15:21
     * @param [nums]
     * @return com.zly.LinkedList.LinkedList.ListNode
     **/
    public static ListNode init(int[] nums){
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        ListNode listNode = init(list);
        return listNode;
    }
    /**
     * @descriptions 使用列表初始化链表
     * @author zhaoliyang9
     * @date 2023/7/8 15:21
     * @param [nums]
     * @return com.zly.LinkedList.LinkedList.ListNode
     **/
    public static ListNode init(List<Integer> nums){
        if(nums.isEmpty()){
            return null;
        }
        ListNode head = new ListNode(-1);
        ListNode head_copy = head;
        for(Integer num: nums){
            ListNode node = new ListNode(num);
            head_copy.next = node;
            head_copy = head_copy.next;
        }
        return head.next;
    }
    /**
     * @descriptions 打印链表
     * @author zhaoliyang9
     * @date 2023/7/8 15:22
     * @param [head]
     * @return void
     **/
    public static void print(ListNode head){
        System.out.print("head->");
        while(head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.print("null");
    }
    /**
     * @descriptions 从头到尾反转链表
     * @author zhaoliyang9
     * @date 2023/7/8 15:22
     * @param [head]
     * @return com.zly.LinkedList.LinkedList.ListNode
     **/
    public static ListNode reverseList(ListNode head){

        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    /**
     * @descriptions 反转指定范围位置的链表
     * @author zhaoliyang9
     * @date 2023/7/8 15:23
     * @param [head, m, n]
     * @return com.zly.LinkedList.LinkedList.ListNode
     **/
    public static ListNode reverseListBetween(ListNode head, int m, int n){
        int k = m;
        ListNode dummry_node = new ListNode(-1);
        dummry_node.next = head;
        ListNode cur = dummry_node;
        while(k-- > 1){
            cur = cur.next;
        }
        ListNode one_head = cur;
        cur = cur.next;
        one_head.next = null;
        ListNode pre = null;
        ListNode one_tail = cur;
        int val = (n - m + 1);
        System.out.println(val);
        while(val-- > 0){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        one_head.next = pre;
        one_tail.next = cur;
        return dummry_node.next;
    }
    /**
     * @descriptions 计算链表的长度
     * @author zhaoliyang9
     * @date 2023/7/9 18:47
     * @param [head]
     * @return int
     **/
    public static int size(ListNode head){
        int len = 0;
        while(head != null){
            ++len;
            head = head.next;
        }
        return len;
    }
    /**
     * @descriptions 每k个元素反转链表
     * @author zhaoliyang9
     * @date 2023/7/9 18:48
     * @param [head, k]
     * @return com.zly.LinkedList.LinkedList.ListNode
     **/
    public static ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        int size = size(head);
        int times = size / k;
        if(times < 1){
            return head;
        }
        ListNode dummry_node = new ListNode(-1);
        dummry_node.next = head;
        ListNode tail = dummry_node;
        ListNode cur = head;
        while(times-- > 0){
            ListNode pre = null;
            ListNode tail_new = cur;
            int n = k;
            while(n-- > 0){
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            tail.next = pre;
            tail = tail_new;
        }
        tail.next = cur;
        return dummry_node.next;
    }
    /**
     * @descriptions 合并链表-根据键值升序
     * @author zhaoliyang9
     * @date 2023/7/9 18:49
     * @param [pHead1, pHead2]
     * @return com.zly.LinkedList.LinkedList.ListNode
     **/
    public static ListNode Merge (ListNode pHead1, ListNode pHead2) {
        // write code here
        if(pHead1 == null && pHead2 == null){
            return null;
        }
        if(pHead1 == null && pHead2 != null){
            return pHead2;
        }
        if(pHead1 != null && pHead2 == null){
            return pHead1;
        }
        if(pHead1.val <= pHead2.val){
            ListNode head = pHead1;
            head.next = Merge(pHead1.next, pHead2);
            return head;
        }else{
            ListNode head = pHead2;
            head.next = Merge(pHead1, pHead2.next);
            return head;
        }
    }
    /**
     * @descriptions 合并一组链表
     * @author zhaoliyang9
     * @date 2023/7/9 18:49
     * @param [lists]
     * @return com.zly.LinkedList.LinkedList.ListNode
     **/
    public static ListNode mergeKLists (ArrayList<ListNode> lists) {
        if(lists.size() == 0){
            return null;
        }
        // write code here
        if(lists.size() == 1){
            return lists.get(0);
        }
        ListNode res = null;
        if(lists.size() > 1){
            for (int i = 0; i < lists.size(); i++) {
                res = Merge(res, lists.get(i));
            }
        }
        return res;
    }
    /**
     * @descriptions 判断链表是否有环
     * @author zhaoliyang9
     * @date 2023/7/9 18:49
     * @param [head]
     * @return boolean
     **/
    public static boolean hasCycle(ListNode head) {
        HashSet<ListNode> nodes = new HashSet<>();
        while(head != null){
            if(nodes.contains(head)){
               return true;
            }else {
                nodes.add(head);
            }
            head = head.next;
        }
        return false;
    }
    /**
     * @descriptions 有环链表的起点
     * @author zhaoliyang9
     * @date 2023/7/9 18:50
     * @param [head]
     * @return com.zly.LinkedList.LinkedList.ListNode
     **/
    public static ListNode EntryNodeOfLoop(ListNode head) {
        HashSet<ListNode> nodes = new HashSet<>();
        while(head != null){
            if(nodes.contains(head)){
                return new ListNode(head.val);
            }else {
                nodes.add(head);
            }
            head = head.next;
        }
        return null;
    }
    /**
     * @descriptions 返回倒数k个节点
     * @author zhaoliyang9
     * @date 2023/7/9 18:50
     * @param [pHead, k]
     * @return com.zly.LinkedList.LinkedList.ListNode
     **/
    public static ListNode FindKthToTail (ListNode pHead, int k) {
        if(size(pHead) < k){
            return null;
        }
        // write code here
        ListNode dummry_node = new ListNode(-1);
        dummry_node.next = pHead;
        ListNode slow = dummry_node;
        ListNode fast = dummry_node;
        while(k-- > 0){
            fast = fast.next;
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    /**
     * @descriptions 移除倒数第k个节点
     * @author zhaoliyang9
     * @date 2023/7/9 18:51
     * @param [head, n]
     * @return com.zly.LinkedList.LinkedList.ListNode
     **/
    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        if(size(head) < n){
            return null;
        }
        ListNode dummry_node = new ListNode(-1);
        dummry_node.next = head;
        ListNode slow = dummry_node;
        ListNode fast = dummry_node;
        while(n-- > 0){
            fast = fast.next;
        }
        while(fast.next != null ){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummry_node.next;
    }
    /**
     * @descriptions 找出两个链表的公共节点
     * @author zhaoliyang9
     * @date 2023/7/9 18:51
     * @param [pHead1, pHead2]
     * @return com.zly.LinkedList.LinkedList.ListNode
     **/
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        ListNode head1 = pHead1;
        ListNode head2 = pHead2;
        while(head1 != head2){
            head1 = head1.next == null ? pHead2 : head1.next;
            head2 = head2.next == null ? pHead1 : head2.next;
        }
        return head1;
    }
    /**
     * @descriptions 链表之和
     * @author zhaoliyang9
     * @date 2023/7/9 18:52
     * @param [head1, head2]
     * @return com.zly.LinkedList.LinkedList.ListNode
     **/
    public static ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        ListNode head1_new = reverseList(head1);
        ListNode head2_new = reverseList(head2);

        print(head1_new);
        System.out.println();
        print(head2_new);

        ListNode res = null;
        int flag = 0;
        while(head1_new != null && head2_new != null){
            System.out.println(head1_new.val + " " + head2_new.val);
            int val = head1_new.val + head2_new.val;
            ListNode node = new ListNode((val + flag) % 10);
            node.next = res;
            res = node;
            flag = (val + flag) / 10;
            head1_new = head1_new.next;
            head2_new = head2_new.next;
        }

        if(head1_new == null || head2_new == null){
            ListNode cur = null;
            cur = head1_new == null ? head2_new : head1_new;
            while(cur != null){
                ListNode temp = cur.next;
                if(flag != 0){
                    int num = cur.val + flag;
                    cur.val = num % 10;
                    flag = num / 10;
                }
                cur.next = res;
                res = cur;
                cur = temp;
            }
        }

        if(flag != 0){
            ListNode node = new ListNode(flag);
            node.next = res;
            res = node;
        }
        return res;
    }
    /**
     * @descriptions 单个链表排序
     * @author zhaoliyang9
     * @date 2023/7/9 18:52
     * @param [head]
     * @return com.zly.LinkedList.LinkedList.ListNode
     **/
    public static ListNode sortInList (ListNode head) {
        // write code here
        List<Integer> list = new ArrayList<Integer>();
        while(head != null){
            list.add(Integer.valueOf(head.val));
            head = head.next;
        }
        Integer[] nums = list.toArray(new Integer[list.size()]);
        Arrays.sort(nums);
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        for (int i = 0; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            cur.next = node;
            cur = cur.next;
        }
        return res.next;
    }
    /**
     * @descriptions 判断链表是否为回文结构
     * @author zhaoliyang9
     * @date 2023/7/9 19:55
     * @param [head]
     * @return boolean
     **/
    public static boolean isPail (ListNode head) {
        // write code here
        if (head == null){
            return true;
        }
        ListNode tail = null;
        ListNode cur = head;
        while (cur != null){
            ListNode node = new ListNode(cur.val);
            node.next = tail;
            tail = node;
            cur = cur.next;
        }
        print(tail);
        while(tail != null){
//            System.out.println(head.val);
            if(head.val != tail.val){
                return false;
            }
            head = head.next;
            tail = tail.next;
        }
        return true;
    }

    public static ListNode oddEvenList (ListNode head) {
        // write code here
        List<Integer> list = new ArrayList<Integer>();
        while(head != null){
            list.add(Integer.valueOf(head.val));
            head = head.next;
        }
        List<Integer> num1 = new ArrayList<Integer>();
        List<Integer> num2 = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++){
            boolean b = i % 2 == 0 ? num1.add(list.get(i)) : num2.add(list.get(i));
        }
        num1.addAll(num2);
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        for(int i = 0; i < num1.size(); i++){
            ListNode node = new ListNode(num1.get(i).intValue());
            cur.next = node;
            cur = cur.next;
        }
        return res.next;
    }
    /**
     * @descriptions 去除重复数字
     * @author zhaoliyang9
     * @date 2023/7/12 21:02
     * @param [head]
     * @return com.zly.LinkedList.LinkedList.ListNode
     **/
    public static ListNode deleteDuplicates (ListNode head) {
        // write code here
        ListNode dummry_node = new ListNode(-1);
        dummry_node.next = head;
        ListNode first = dummry_node;
        ListNode second = dummry_node;
        while(second != null){
            if(first.val != second.val){
                first.next = second;
                first = first.next;
                second = second.next;
            }else{
                second = second.next;
            }
        }
        first.next = second;
        return dummry_node.next;
    }
    /**
     * @descriptions 保留链表中只出现一次的元素
     * @author zhaoliyang9
     * @date 2023/7/12 21:01
     * @param [head]
     * @return com.zly.LinkedList.LinkedList.ListNode
     **/
    public static ListNode deleteDuplicate(ListNode head) {
        // write code here
        ListNode dummry_node = new ListNode(-1000000);
        dummry_node.next = head;
        ListNode first = dummry_node;
        while(first != null && first.next != null && first.next.next != null){
            System.out.println(first.val);
            if(first.next.val == first.next.next.val){
                ListNode second = first.next;
                while(second != null && second.val == first.next.val){
                    second = second.next;
                }
                first.next = second;

            }else{
                first = first.next;
            }
        }
        return dummry_node.next;
    }
    public static void main(String[] args) {
        int[] array_one = {-50,-49,-49,-49,-48,-48,-47,-47,-46,-46,-46,-44,-42,-40,-40,-40,-39,-39,-38,-37,-36,-36,-35,-34,-33,-33,-32,-31,-31,-29,-22,-22,-21,-19,-16,-15,-15,-14,-14,-12,-11,-11,-9,-7,-7,-7,-6,-6,-3,-1,-1,0,0,1,1,3,3,3,3,4,4,5,6,6,7,8,8,9,9,9,10,12,12,13,15,18,18,19,19,20,21,22,25,29,31,31,32,34,34,35,35,35,36,37,39,39,39,41,41,41,42,43,44,44,45,45,46,46,48,49,49,50};
        int[] array_two = {6, 3};
        ListNode head_one = init(array_one);
        ListNode res = deleteDuplicate(head_one);

        print(res);
    }
}
