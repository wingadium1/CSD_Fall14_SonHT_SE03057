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
public class CustomerNode {
    Customer mInfo;
    CustomerNode next;
    CustomerNode(Customer x, CustomerNode y){
        mInfo = x;
        next = y;
    }

    CustomerNode(Customer x) {
        mInfo = x;
        next = null;
    }
    
}
