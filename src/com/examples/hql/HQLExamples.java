/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examples.hql;

import gitdemoprogect.HibernateUtil;
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
            
            
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
