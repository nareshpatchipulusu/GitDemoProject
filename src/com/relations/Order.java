/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relations;

import java.util.Set;

/**
 *
 * @author nareshp
 */
public class Order {
 
    private int id; 
    private String orderNumber;
    private double orderValue;
    private Set<OrderDetail> orderDetail;

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
     * @return the orderNumber
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * @param orderNumber the orderNumber to set
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * @return the orderValue
     */
    public double getOrderValue() {
        return orderValue;
    }

    /**
     * @param orderValue the orderValue to set
     */
    public void setOrderValue(double orderValue) {
        this.orderValue = orderValue;
    }

    /**
     * @return the orderDetail
     */
    public Set<OrderDetail> getOrderDetail() {
        return orderDetail;
    }

    /**
     * @param orderDetail the orderDetail to set
     */
    public void setOrderDetail(Set<OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }
    
    
}
