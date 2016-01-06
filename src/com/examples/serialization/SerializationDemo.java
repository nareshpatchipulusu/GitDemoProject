/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examples.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author nareshp
 */
public class SerializationDemo {
    
    public static void main(String[] args) throws Exception {
        
        Student st=new Student(10, "Naresh");
        
        System.out.println("----- Serilization Started -------");
        
        FileOutputStream fos=new FileOutputStream("abc.ser");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(st);
        
        System.out.println("----- Serilization Completed -------");
        
        System.out.println("----- De - Serilization Started -------");
        
        FileInputStream fis=new FileInputStream("abc.ser");
        ObjectInputStream ois=new ObjectInputStream(fis);
        Student st1=(Student)ois.readObject();
        
        System.out.println(st1.getId() + " -> " + st1.getName() );
        
        
        System.out.println("----- De - Serilization Completed -------");
        
    }
}
