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
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 *
 * @author nareshp
 */
public class CustomIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SessionImplementor s, Object obj) {
        
        String name = "RT";

        try {
            Connection con = s.connection();
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select next value for hibernate_sequence");

            if (rs.next()) {
                name = name + rs.getInt(1);
            }

        } catch (Exception ex) {

            ex.printStackTrace();
        }

        return name;
    }

}
