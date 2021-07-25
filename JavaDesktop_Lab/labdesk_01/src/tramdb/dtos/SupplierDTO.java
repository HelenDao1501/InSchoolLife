/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tramdb.dtos;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author PhuongPT
 */
public class SupplierDTO implements Serializable{
    private String supCode, supName, address;
    private boolean colloborating;

    public Vector toVector() {
        Vector v = new Vector();
        v.add(supCode);
        v.add(supName);
        v.add(address);
        v.add(colloborating);
        return v;
    }
    
    public SupplierDTO(String supCode, String supName, String address, boolean colloborating) {
        this.supCode = supCode;
        this.supName = supName;
        this.address = address;
        this.colloborating = colloborating;
    }


    
    public SupplierDTO() {
    }

    public String getSupCode() {
        return supCode;
    }

    public void setSupCode(String supCode) {
        this.supCode = supCode;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isColloborating() {
        return colloborating;
    }

    public void setColloborating(boolean colloborating) {
        this.colloborating = colloborating;
    }

    public String toString() {
        return supCode + "-" + supName;
    }
}
