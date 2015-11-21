/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gitdemoprogect;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author nareshp
 */
public class RelationsDemo {
    
    public static void main(String[] args) {
        
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session session=sf.openSession();
        
        try
        {
            Employee emp=new Employee("Suresh","suresh@inventrax.com", "+917799006116", "Visakhapatnam");
            SoftwareEmployee se=new SoftwareEmployee(12, "Naresh", "naresh@inventrax.com", "+917799006116", "Visakhapatnam");
            HardwareEmployee he=new HardwareEmployee("Hibernate", "Manikanta","mani@inventrax.com", "+917799006226", "Visakhapatnam");
            
            session.save(emp);
            session.save(se);
            session.save(he);
            
            session.beginTransaction().commit();
            
            session.close();
            
//            session.evict(emp);
//            session.evict(se);
//            session.evict(he);
            
            sf.close();
            
            
        }catch(Exception ex){
         
            ex.printStackTrace();
            System.exit(0);
            
        }
        
        
    }
    
}
