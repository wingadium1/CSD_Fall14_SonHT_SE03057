/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

/**
 *
 * @author mk
 */
public class CustomerList {
    CustomerNode head,tail;
    CustomerList() {head=tail=null;}
    void clear() {head=tail=null;}
    boolean isEmpty() {return(head==null);}
    void add(Customer x){
        CustomerNode p = search(x.mPhoneNumber);
        if(p!=null){
            System.out.println("The phone number " + x.mPhoneNumber + " already exists, no addition");
            return;
        }
        CustomerNode q = new CustomerNode(x);
        if(isEmpty()) {
            head=tail=q;return;
        }
        tail.next=q;
        tail=q;
    }
    
    void traverse(){
        CustomerNode p = head;
        while(p!=null){System.out.println(p.mInfo);
            p=p.next;
        }
    }
    CustomerNode search(int xPhoneNumber){
        CustomerNode p = head;
        while(p!=null){
            if(p.mInfo.mPhoneNumber==xPhoneNumber) return(p);
            p=p.next;
        }
        return(p);
    }
    void dele(CustomerNode q){
        if(q==null || isEmpty()) return;
        CustomerNode f,p; f=null;p=head;
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
    void dele(String xName){
        CustomerNode q = search(xName);
        dele(q);
    }
    void deleAll(String xName) {}
    void deleFirst() {}
    void deleLast() {}
    void deleBeforeLast() {}
    void dele(int k) {}
    int count() {return(0);}
    void sortByName(){
        CustomerNode pi,pj; Customer t;
        pi=head;
        while(pi!=null){
            pj=pi.next;
            while(pj!=null){
                if(pj.mInfo.mName.compareTo(pi.mInfo.mName)<0)
            {
                t=pi.mInfo;pi.mInfo=pj.mInfo;pj.mInfo=t;
            }
            pj=pj.next;
            }
            pi=pi.next;
        }
    }
    
    void insertSortbyName(){
        if (head==null ||head.next==null){
            return;
        }
        
        CustomerNode newHead = new CustomerNode(head.mInfo);
        CustomerNode pointer = head.next;
        while (pointer != null) {
            CustomerNode innerPointer = newHead;
            CustomerNode next = pointer.next;
            if (pointer.mInfo.mName.compareTo(newHead.mInfo.mName)<0) {
                CustomerNode oldHead = newHead;
		newHead = pointer;
		newHead.next = oldHead;
            }
            else{
                while (innerPointer.next != null) {
                    if (pointer.mInfo.mName.compareTo(innerPointer.mInfo.mName)>0 
                            && pointer.mInfo.mName.compareTo(innerPointer.next.mInfo.mName)<0){
                        CustomerNode oldNext = innerPointer.next;
			innerPointer.next = pointer;
			pointer.next = oldNext;
                    }
                    innerPointer = innerPointer.next;      
                }
                if (innerPointer.next == null && 
                        pointer.mInfo.mName.compareTo(innerPointer.mInfo.mName)>0) {
                        innerPointer.next = pointer;
			pointer.next = null;
		}
            }
            pointer = next;
        }
        head = newHead;
        
    }
    
    void selectSortbyName(){
        if (head==null ||head.next==null){
            return;
        }
        for(CustomerNode node1 = head; node1!=null; node1 = node1.next){
            CustomerNode min = node1;
            for(CustomerNode node2 = node1;node2!=null;node2=node2.next){
                if(min.mInfo.mName.compareTo(node2.mInfo.mName)>0){
                    min = node2;
                }
            }
            
            CustomerNode temp = new CustomerNode(node1.mInfo);
            node1.mInfo = min.mInfo;
            min.mInfo = temp.mInfo;
        }
    }
    
    
    
    void sortByPhonenumber() {}
    Customer [] toArray() {Customer [] a = null;return(a);} 

    private CustomerNode search(String xName) {
        CustomerNode p = head;
        while(p!=null){
            if(p.mInfo.mName.compareTo(xName)==0) return(p);
            p=p.next;
        }
        return(p);
    }

    

    
}
