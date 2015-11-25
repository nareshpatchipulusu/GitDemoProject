/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examples.hql;

import com.relations.PurchaseOrderHeader;
import gitdemoprogect.HibernateUtil;
import java.math.BigDecimal;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author nareshp
 */
public class FirstLevelCacheExample {

    public static void main(String[] args) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        //Transaction tx = session.beginTransaction();

        try {

            PurchaseOrderHeader po = (PurchaseOrderHeader) session.get(PurchaseOrderHeader.class, 2);

            System.out.println(po.getPoheaderId() + " | " + po.getPonumber() + " | " + po.getPodate() + " | " + po.getOrderValue());

            System.out.println("----------***********-------------");

            Session session1 = sf.openSession();

            PurchaseOrderHeader po1 = (PurchaseOrderHeader) session1.get(PurchaseOrderHeader.class, 2);

            System.out.println(po1.getPoheaderId() + " | " + po1.getPonumber() + " | " + po1.getPodate() + " | " + po1.getOrderValue());

            System.out.println("----------***********-------------");
            
            Query q=session.createQuery("update PurchaseOrderHeader set orderValue=:value where poheaderid=:id" );
            q.setParameter("value", new BigDecimal(102012));
            q.setParameter("id", 2);
            
            q.executeUpdate();
            
            session.beginTransaction().commit();
            
            Session session2 = sf.openSession();

            PurchaseOrderHeader po2 = (PurchaseOrderHeader) session2.get(PurchaseOrderHeader.class, 2);

            System.out.println(po2.getPoheaderId() + " | " + po2.getPonumber() + " | " + po2.getPodate() + " | " + po2.getOrderValue());

            System.out.println("----------***********-------------");
            

           // tx.commit();
            session.evict(po);
            session1.evict(po1);
            session2.evict(po2);

            session.close();
            session1.close();
            session2.close();

            sf.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
