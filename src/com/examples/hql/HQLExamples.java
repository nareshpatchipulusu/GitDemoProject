/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examples.hql;

import com.relations.PurchaseOrderHeader;
import gitdemoprogect.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author nareshp
 */
public class HQLExamples {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        

        try {
            
            
            Query q=session.createQuery("from PurchaseOrderHeader");
            
            List<PurchaseOrderHeader> listPOH=q.list();
            
            for (PurchaseOrderHeader poh : listPOH) {
                
                System.out.println(poh.getPoheaderId() + " | " +  poh.getPonumber()+ " | " + poh.getPodate()+ " | " + poh.getOrderValue());
            }
            
            System.out.println("----------***********-------------");
            
            Query q1=session.createQuery("from PurchaseOrderHeader where POHeaderID=:pohid");
            q1.setInteger("pohid", 1);
            
            PurchaseOrderHeader pohead=(PurchaseOrderHeader)q1.uniqueResult();
            
            System.out.println(pohead.getPoheaderId() + " | " +  pohead.getPonumber()+ " | " + pohead.getPodate()+ " | " + pohead.getOrderValue());
            
            System.out.println("----------***********-------------");
            
            PurchaseOrderHeader po=(PurchaseOrderHeader) session.get(PurchaseOrderHeader.class, 2);
            
            System.out.println(po.getPoheaderId() + " | " +  po.getPonumber()+ " | " + po.getPodate()+ " | " + po.getOrderValue());
            
            System.out.println("----------***********-------------");
            
            PurchaseOrderHeader po1=(PurchaseOrderHeader) session.load(PurchaseOrderHeader.class, 3);
            
            System.out.println(po1.getPoheaderId() + " | " +  po1.getPonumber()+ " | " + po1.getPodate()+ " | " + po1.getOrderValue());
            
            System.out.println("----------***********-------------");
            
            
            Query q2=session.createQuery("from PurchaseOrderHeader where PONumber like '%PO%'");
            //q2.setParameter("PONumber", "PO102030");
            
             List<PurchaseOrderHeader> listPOH1=q2.list();
            
            for (PurchaseOrderHeader poh : listPOH1) {
                
                System.out.println(poh.getPoheaderId() + " | " +  poh.getPonumber()+ " | " + poh.getPodate()+ " | " + poh.getOrderValue());
            }
            
            System.out.println("----------***********-------------");
            
            //Query q3=session.createQuery("select poh.ponumber,det.quantity from  PurchaseOrderHeader poh JOIN poh.purchaseOrderDetail det ");
            
            Query q3=session.createQuery("select poh.ponumber,det.quantity from  PurchaseOrderHeader poh LEFT JOIN poh.purchaseOrderDetail det ");
            
            List<Object[]> objList=q3.list();
            
            for (Object[] objList1 : objList) {
                
                System.out.println(objList1[0] + " | " +  objList1[1] );
            }
            
            System.out.println("----------***********-------------");
            
            
            
            
            
            session.close();
            
            sf.close();
            
            
            System.out.println("Git by swamy....");
            
            
            
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
