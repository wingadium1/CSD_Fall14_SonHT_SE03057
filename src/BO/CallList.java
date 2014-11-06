/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import java.util.NoSuchElementException;

/**
 *
 * @author mk
 */
public class CallList {
    public CallNode head,tail;
    public CallList() {head=tail=null;}
    public void clear() {head=tail=null;}
    public boolean isEmpty() {return(head==null);}
    void add(Call x){
        CallNode q = new CallNode(x);
        if(isEmpty()) {
            head=tail=q;return;
        }
        tail.next=q;
        tail=q;
    }
    
    public void traverse(){
        CallNode p = head;
        while(p!=null){System.out.println(p.mInfo);
            p=p.next;
        }
    }
    
    void traverse(CallNode a){
        CallNode p = a;
        while(p!=null){System.out.println(p.mInfo);
            p=p.next;
        }
    }
    
    CallNode search(int xPhoneNumber){
        CallNode p = head;
        while(p!=null){
            if(p.mInfo.mPhoneNumber==xPhoneNumber) return(p);
            p=p.next;
        }
        return(p);
    }
    void dele(CallNode q){
        if(q==null || isEmpty()) return;
        CallNode f,p; f=null;p=head;
        while(p!=null){   
            if(p==q) break;
            f=p;p=p.next;
        }
        if(p==null) return;
        if(f==null){
            head=head.next;
            if(head==null) tail=null;
            return;
        }
        f.next = p.next;
        if(f.next==null) tail=f; 
     }
    
    void deleAll(String xName) {}
    void deleFirst() {}
    void deleLast() {}
    void deleBeforeLast() {}
    void dele(int k) {}
    int count() {return(0);}
    public void sortByPhoneNumber(){
        CallNode pi,pj; Call t;
        pi=head;
        while(pi!=null){
            pj=pi.next;
            while(pj!=null){
                if(pj.mInfo.mPhoneNumber<pi.mInfo.mPhoneNumber)
            {
                t=pi.mInfo;pi.mInfo=pj.mInfo;pj.mInfo=t;
            }
            pj=pj.next;
            }
            pi=pi.next;
        }
    }
    public void insertSortbyPhoneNumber(){
        if (head==null ||head.next==null){
            return;
        }
        
        CallNode newHead = new CallNode(head.mInfo);
        CallNode pointer = head.next;
        while (pointer != null) {
            CallNode innerPointer = newHead;
            CallNode next = pointer.next;
            if (pointer.mInfo.mPhoneNumber<newHead.mInfo.mPhoneNumber) {
                CallNode oldHead = newHead;
		newHead = pointer;
		newHead.next = oldHead;
            }
            else{
                while (innerPointer.next != null) {
                    if (pointer.mInfo.mPhoneNumber<innerPointer.mInfo.mPhoneNumber
                            && pointer.mInfo.mPhoneNumber<innerPointer.next.mInfo.mPhoneNumber){
                        CallNode oldNext = innerPointer.next;
			innerPointer.next = pointer;
			pointer.next = oldNext;
                    }
                    innerPointer = innerPointer.next;      
                }
                if (innerPointer.next == null && 
                        pointer.mInfo.mPhoneNumber<innerPointer.mInfo.mPhoneNumber) {
                        innerPointer.next = pointer;
			pointer.next = null;
		}
            }
            pointer = next;
        }
        head = newHead;
        
    }
    
    private CallNode getTail(CallNode cur){
    while (cur != null && cur.next != null)
        cur = cur.next;
    return cur;
    }

    /**
     * short singer linked list by quick short
     */
    
    
    // merge sort
    
    
    Call [] toArray() {Call [] a = null;return(a);} 
    
    private CallNode getMidPoint(CallNode head) {
        assert head != null;

        CallNode fast = head.next;
        CallNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
        
    }

    
}
