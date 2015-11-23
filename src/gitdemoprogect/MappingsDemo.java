/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gitdemoprogect;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author nareshp
 */
public class MappingsDemo {

    public static void main(String[] args) {

        try {
            
            
        Cart cart = new Cart();
        cart.setName("MyCart");
         
        Items item1 = new Items("I1", 10, 1, cart);
        Items item2 = new Items("I2", 20, 2, cart);
        Set<Items> itemsSet = new HashSet<Items>();
        itemsSet.add(item1); itemsSet.add(item2);
         
        cart.setItems(itemsSet);
        cart.setTotal(10*1 + 20*2);
         
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        
        //Get Session
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        System.out.println("Session created");
        //start transaction
        tx = session.beginTransaction();
         
        //Save the Model objects
        session.save(cart);
        session.save(item1);
        session.save(item2);
         
        //Commit transaction
        tx.commit();
        System.out.println("Cart ID="+cart.getId());
            
            session.close();
            sessionFactory.close();
        } 
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

}
