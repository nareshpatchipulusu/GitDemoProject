/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gitdemoprogect;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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

        SessionFactory sf = HibernateUtil.getSessionFactory();

        Session session = sf.openSession();

        try {

            Transaction tc = session.beginTransaction();

            Student st = new Student();
            st.setName("Naresh2");
            st.setEmail("naresp2@inventrax.com");
            st.setAddress("Visakhapatnam2");
            st.setPhoneNumber("+917799006116");
            String pk=(String) session.save(st);
            
            System.out.println("id="+pk);
            
            tc.commit();
            
            
            

        } catch (Exception ex) {

            ex.printStackTrace();

            if (session != null) {
                session.close();
            }
            if (sf != null) {
                sf.close();
            }

        } finally {

            if (session != null) {
                session.close();
            }
            if (sf != null) {
                sf.close();
            }

        }

    }

}
