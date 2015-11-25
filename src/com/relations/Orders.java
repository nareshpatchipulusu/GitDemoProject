package com.relations;
// Generated Nov 24, 2015 10:01:10 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Orders generated by hbm2java
 */
public class Orders  implements java.io.Serializable {


     private Integer id;
     private String orderNumber;
     private double orderValue;
     private Set orderDetail = new HashSet(0);

    public Orders() {
    }

    public Orders(String orderNumber, double orderValue, Set orderDetail) {
       this.orderNumber = orderNumber;
       this.orderValue = orderValue;
       this.orderDetail = orderDetail;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getOrderNumber() {
        return this.orderNumber;
    }
    
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
    public double getOrderValue() {
        return this.orderValue;
    }
    
    public void setOrderValue(double orderValue) {
        this.orderValue = orderValue;
    }
    public Set getOrderDetail() {
        return this.orderDetail;
    }
    
    public void setOrderDetail(Set orderDetail) {
        this.orderDetail = orderDetail;
    }




}

