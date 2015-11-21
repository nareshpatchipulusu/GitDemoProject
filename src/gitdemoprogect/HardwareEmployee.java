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
public class HardwareEmployee extends Employee {
    
    private String tool;

    public  HardwareEmployee(){}
    
    public HardwareEmployee(String tool, String name, String email, String phoneNumber, String address) {
        super(name, email, phoneNumber, address);
        this.tool = tool;
    }
    
    /**
     * @return the tool
     */
    public String getTool() {
        return tool;
    }

    /**
     * @param tool the tool to set
     */
    public void setTool(String tool) {
        this.tool = tool;
    }
    
}
