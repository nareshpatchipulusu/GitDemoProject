/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examples.hql;

import com.relations.PurchaseOrderHeader;
import gitdemoprogect.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author nareshp
 */
public class CriteriaQueriesExamples {
    
    public static void main(String[] args) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            
            Criteria cr=session.createCriteria(PurchaseOrderHeader.class);
            
            Criterion c= Restrictions.ilike("ponumber", "PO%");
            
            cr.addOrder(Order.asc("orderValue"));
            
            cr.add(c);
            
           List<PurchaseOrderHeader> listPOH = cr.list();

            for (PurchaseOrderHeader poh : listPOH) {

                System.out.println(poh.getPoheaderId() + " | " + poh.getPonumber() + " | " + poh.getPodate() + " | " + poh.getOrderValue());
            }
            System.out.println("----------***********-------------");
            
            
            
            
            
            
            session.close();
            
            sf.close();
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
