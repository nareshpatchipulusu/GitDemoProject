/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relations;

import gitdemoprogect.HibernateUtil;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author nareshp
 */
public class TestClient {

    public static void main(String[] args) {
        
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session session=sf.openSession();
        
        
        try
        {
            Orders ord=new Orders();
            
            ord.setOrderNumber("ORD15001");
            ord.setOrderValue(1200);
            
            Orders ord2=new Orders();
            
            ord2.setOrderNumber("ORD15002");
            ord2.setOrderValue(1500);
            
            
            OrderDetail det1=new OrderDetail("Item1", 1, ord);
            OrderDetail det2=new OrderDetail("Item2", 2, ord);
            OrderDetail det3=new OrderDetail("Item3", 3, ord);
            OrderDetail det4=new OrderDetail("Item4", 4, ord2);
            OrderDetail det5=new OrderDetail("Item5", 5, ord2);
            
            
            Set<OrderDetail> orderDet=new HashSet<OrderDetail>();
            orderDet.add(det1);
            orderDet.add(det2);
            orderDet.add(det3);
            
            ord.setOrderDetail(orderDet);
            
            Set<OrderDetail> orderDet1=new HashSet<OrderDetail>();
            orderDet1.add(det4);
            orderDet1.add(det5);
            
            
            ord.setOrderDetail(orderDet);
            ord2.setOrderDetail(orderDet1);
            
            
            session.save(ord);
            session.save(ord2);
//            
//            session.save(det1);
//            session.save(det2);
//            session.save(det3);
            
            
            session.close();
            sf.close();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
}
