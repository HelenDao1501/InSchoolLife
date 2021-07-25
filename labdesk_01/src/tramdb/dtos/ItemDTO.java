/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tramdb.dtos;

import java.util.Vector;

/**
 *
 * @author PhuongPT
 */
public class ItemDTO {
    private String itemCode, itemName;
    private SupplierDTO supplier;
    private String unit;
    int price;
    boolean supplying;

    public Vector toVector() {
        Vector v = new Vector();
        v.add(itemCode);
        v.add(itemName);
        v.add(supplier);
        v.add(unit);
        v.add(price);
        v.add(supplying);
        return v;
    }
    
    public ItemDTO(String itemCode, String itemName, SupplierDTO supplier, String unit, int price, boolean supplying) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.supplier = supplier;
        this.unit = unit;
        this.price = price;
        this.supplying = supplying;
    }

    

    public ItemDTO() {
    }

   
    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public SupplierDTO getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierDTO supplier) {
        this.supplier = supplier;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isSupplying() {
        return supplying;
    }

    public void setSupplying(boolean supplying) {
        this.supplying = supplying;
    }

}
