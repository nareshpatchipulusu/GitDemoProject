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
public class GitDemoProgect {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        try {
            
            SessionFactory sf = HibernateUtil.getSessionFactory();
            
            Session session = sf.openSession();

            Student st = new Student();
            st.setName("Naresh");
            st.setEmail("naresp@inventrax.com");
            st.setAddress("Visakhapatnam");
            st.setPhoneNumber("+917799006116");
            session.save(st);

            session.beginTransaction().commit();
            
            session.evict(st);
            
        } catch (Exception ex) {

            ex.printStackTrace();

        }finally{
            
        }

    }

}
