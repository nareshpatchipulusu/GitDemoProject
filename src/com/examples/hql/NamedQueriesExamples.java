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
public class NamedQueriesExamples {

    public static void main(String[] args) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {

            Query q = session.getNamedQuery("HQL_GET_ALL_PURCHASEORDERS");

            List<PurchaseOrderHeader> listPOH = q.list();

            for (PurchaseOrderHeader poh : listPOH) {

                System.out.println(poh.getPoheaderId() + " | " + poh.getPonumber() + " | " + poh.getPodate() + " | " + poh.getOrderValue());
            }

            System.out.println("----------***********-------------");

            Query q1 = session.getNamedQuery("HQL_GET_PURCHASEORDER_BY_ID");
            q1.setParameter("id", 1);
            PurchaseOrderHeader poh = (PurchaseOrderHeader) q1.uniqueResult();

            System.out.println(poh.getPoheaderId() + " | " + poh.getPonumber() + " | " + poh.getPodate() + " | " + poh.getOrderValue());

            System.out.println("----------***********-------------");

            Query q2 = session.getNamedQuery("HQL_GET_PURCHASEORDER_BY_PONUMBER");
            q2.setParameter("ponumber", "PO102030");
            PurchaseOrderHeader poh1 = (PurchaseOrderHeader) q2.uniqueResult();

            System.out.println(poh1.getPoheaderId() + " | " + poh1.getPonumber() + " | " + poh1.getPodate() + " | " + poh1.getOrderValue());

            System.out.println("----------***********-------------");
            
            
            
            
            
            session.close();
            sf.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
