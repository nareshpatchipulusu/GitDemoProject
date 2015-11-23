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
            Order ord=new Order();
            
            ord.setOrderNumber("ORD150001");
            ord.setOrderValue(12000);
            
            OrderDetail det1=new OrderDetail("Item1", 1, ord);
            OrderDetail det2=new OrderDetail("Item2", 2, ord);
            OrderDetail det3=new OrderDetail("Item3", 3, ord);
            
            Set<OrderDetail> orderDet=new HashSet<OrderDetail>();
            orderDet.add(det1);
            orderDet.add(det2);
            orderDet.add(det3);
            
            ord.setOrderDetail(orderDet);
            
            session.save(ord);
            
            session.close();
            sf.close();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
}
