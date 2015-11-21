/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gitdemoprogect;

/**
 *
 * @author nareshp
 */
public class SoftwareEmployee extends Employee {

    private int WH; 

   
    public SoftwareEmployee(int WH, String name, String email, String phoneNumber, String address) {
        super(name, email, phoneNumber, address);
        this.WH = WH;
    }
    
    

    /**
     * @return the WH
     */
    public int getWH() {
        return WH;
    }

    /**
     * @param WH the WH to set
     */
    public void setWH(int WH) {
        this.WH = WH;
    }
    
    
    
}
