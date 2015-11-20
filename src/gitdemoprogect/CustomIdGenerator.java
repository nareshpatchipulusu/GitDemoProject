/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gitdemoprogect;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 *
 * @author nareshp
 */
public class CustomIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SessionImplementor s, Object obj) {
        
       DateFormat df = new SimpleDateFormat("yy"); // Just the year, with 2 digits
        String formattedDate = df.format(Calendar.getInstance().getTime());
        
        String name = "IN" + formattedDate ;

        try {
            Connection con = s.connection();
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select next value for hibernate_sequence");

            //String formatted = String.format("%03d", num);
            
            if (rs.next()) {
                name = name + String.format("%05d", rs.getInt(1));
            }
            
            rs.close();
            
            stmt.close();

        } catch (Exception ex) {

            ex.printStackTrace();
        }

        return name;
    }

}
