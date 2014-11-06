/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import java.util.Date;

/**
 *
 * @author mk
 */
public class Call {
    int mPhoneNumber;
    int mLength;
    Date mStartTime;
    int mType;
    
    
    public Call(){
        mPhoneNumber = -1;
        mLength = 0;
        mStartTime = null;
        mType = 0;
    }
    public Call(String _input){
        // parse
        //8567345 4 8.23 14/06/2006 NH
        String [] part = _input.split(" ");
        mPhoneNumber = Integer.parseInt(part[0]);
        mLength = Integer.parseInt(part[1]);
        String [] hourPart = part[2].split(",");
        mStartTime.setHours(Integer.parseInt(hourPart[0]));
        mStartTime.setMinutes(Integer.parseInt(hourPart[1]));
        String [] dayPart = part[3].split("/");
        mStartTime.setDate(Integer.parseInt(dayPart[0]));
        mStartTime.setMonth(Integer.parseInt(dayPart[1]));
        mStartTime.setYear(Integer.parseInt(dayPart[2]));
        switch(part[3]){
            case "NH": mType = Const.NH;
                break;
            case "LC": mType = Const.LC;
                break;
            case "X": mType = Const.X;
                break;
            case "RC": mType = Const.RX;
                break;
            default: mType = 0;
        }
            
    }
    

    @Override
    public String toString() {
        String type = "";
        switch(mType){
            case Const.NH: type = "NH";
                break;
            case Const.LC: type = "LC";
                break;
            case Const.X: type = "X";
                break;
            case Const.RX: type = "RC";
                break;
            default: type = "";
        }
        //8567345 4 8.23 14/06/2006 NH
        String space = " ";
        String x = "/";
        String dot = ".";
        return mPhoneNumber + space + mLength + space + mStartTime.getHours()+ dot +
                mStartTime.getMinutes() + space + mStartTime.getDate()+x+mStartTime.getMonth()
                + x +mStartTime.getYear()+space + type;
    }
    
}
