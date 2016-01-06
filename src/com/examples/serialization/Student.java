/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examples.serialization;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author nareshp
 */
public class Student implements Serializable {
    
   private static final long SerialVersionUID=121212;
   
   private  int id;
   private transient String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
   
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
   
    
    private void writeObject(ObjectOutputStream oos) throws Exception{
        
        oos.defaultWriteObject();
        
        String eName="ss"+name;
        
        oos.writeObject(eName);
        
    }
    
    private void readObject(ObjectInputStream ois) throws Exception{
        
        ois.defaultReadObject();
        
        String eName= ((String)ois.readObject()).substring(2);
        
        name=eName;
    }
   
    
}
