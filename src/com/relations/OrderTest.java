/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relations;

import gitdemoprogect.HibernateUtil;
import java.math.BigDecimal;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author nareshp
 */
public class OrderTest {
    
    public static void main(String[] args) {
        
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session session=sf.openSession();
        
        try
        {
            PurchaseOrderHeader hd=new PurchaseOrderHeader();
            hd.setPonumber("PO102030");
            hd.setPodate(new Date());
            hd.setOrderValue(new BigDecimal(1220));
                        
            PurchaseOrderDetail det=new PurchaseOrderDetail();
            det.setLineNumber(1);
            det.setItem("120301");
            det.setQuantity(new BigDecimal(10201));
            det.setPurchaseOrderHeader(hd);
                        
            hd.setPurchaseOrderDetail(det);
            
            PurchaseOrderHeader hd1=new PurchaseOrderHeader();
            hd1.setPonumber("PO102031");
            hd1.setPodate(new Date());
            hd1.setOrderValue(new BigDecimal(12201));
                        
            PurchaseOrderDetail det1=new PurchaseOrderDetail();
            det1.setLineNumber(2);
            det1.setItem("120302");
            det1.setQuantity(new BigDecimal(10202));
            det1.setPurchaseOrderHeader(hd1);
                        
            hd1.setPurchaseOrderDetail(det1);
            
            
            
            PurchaseOrderHeader hd2=new PurchaseOrderHeader();
            hd2.setPonumber("PO102032");
            hd2.setPodate(new Date());
            hd2.setOrderValue(new BigDecimal(12202));
                        
            PurchaseOrderDetail det2=new PurchaseOrderDetail();
            det2.setLineNumber(3);
            det2.setItem("120303");
            det2.setQuantity(new BigDecimal(10202));
            det2.setPurchaseOrderHeader(hd2);
                        
            hd2.setPurchaseOrderDetail(det2);
            
            
            
             PurchaseOrderHeader hd3=new PurchaseOrderHeader();
            hd3.setPonumber("PO102033");
            hd3.setPodate(new Date());
            hd3.setOrderValue(new BigDecimal(12203));
                        
            PurchaseOrderDetail det3=new PurchaseOrderDetail();
            det3.setLineNumber(4);
            det3.setItem("120304");
            det3.setQuantity(new BigDecimal(10203));
            det3.setPurchaseOrderHeader(hd3);
                        
            hd3.setPurchaseOrderDetail(det3);
            
            
            
            
            session.beginTransaction();
            
            session.save(hd);
            session.save(hd1);
            session.save(hd2);
            session.save(hd3);
            //session.save(det);
            
            session.getTransaction().commit();
            
            
            session.close();
            
            sf.close();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    
}
