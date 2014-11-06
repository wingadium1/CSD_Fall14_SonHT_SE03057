/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author mk
 */
public class Readfile {
    public CustomerList readCustomerNode() throws IOException{
        CustomerList cl = new CustomerList();
        try (BufferedReader br = new BufferedReader(new FileReader("customer.dat"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                String[] a = new String[2];
                a = line.split(";");
                a[0]=a[0].trim();
                a[1]=a[1].trim();
                //System.out.println("....."+a[1]);
                cl.add(new Customer(a[0],Integer.parseInt(a[1])));
                line = br.readLine();
                
            } 
        }catch(FileNotFoundException fnfe){
            System.out.println(fnfe.toString());
        }catch(IOException ioe){
            System.out.println(ioe.toString());
        }
        return cl;
        } 
    
}
