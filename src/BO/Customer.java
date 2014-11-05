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
public class Customer {
    public String mName;
    public int mPhoneNumber;
    public float mPayment;
    public int[] mType = new int[5];
    
    public Customer(String _name,int _phoneNumber){
        mName = _name;
        mPhoneNumber = _phoneNumber;
        mPayment = 0;
    }
    
}
