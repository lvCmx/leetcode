package algorithm;
/**
 * 本题思路：
 题目说每个节点只能存储一位数字
 我们直接将两个链表从头结点相加，如果产生了进位，则记录一下进位
 时间复杂度O(n)
 空间复杂度O(n)
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null || l2==null){
            return l1==null ? l2 : l1;
        }
        ListNode l1Head=l1;
        ListNode l2Head=l2;
        ListNode sum=new ListNode(-1);
        ListNode head=sum;
        ListNode temp=null;
        int flag=0;
        int result=0;
        while(l1Head!=null || l2Head!=null){
            temp=new ListNode(-1);
            if(l1Head!=null && l2Head!=null){
                result=l1Head.val+l2Head.val+flag;
            }else{
                result=(l1Head==null?l2Head.val:l1Head.val)+flag;
            }
            flag=result>9?1:0;
            result=result%10;

            temp.val=result;
            sum.next=temp;
            sum=sum.next;
            if(l1Head!=null){
                l1Head=l1Head.next;
            }
            if(l2Head!=null){
                l2Head=l2Head.next;
            }
        }
        if(flag!=0){
            temp=new ListNode(flag);
            sum.next=temp;
            sum=sum.next;
        }
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}