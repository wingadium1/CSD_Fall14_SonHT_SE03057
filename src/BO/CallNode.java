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
public class CallNode {
    Call mInfo;
    CallNode next;
    CallNode(Call x, CallNode y){
        mInfo = x;
        next = y;
    }

    CallNode(Call x) {
        mInfo = x;
        next = null;
    }
}
