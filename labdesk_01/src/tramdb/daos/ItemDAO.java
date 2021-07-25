/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tramdb.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import tramdb.db.DBUtils;
import tramdb.dtos.ItemDTO;
import tramdb.dtos.SupplierDTO;

/**
 *
 * @author PhuongPT
 */
public class ItemDAO {
    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;
    
    //5. Close connection
    private void closeConnection() throws Exception {
        if (rs != null)
            rs.close();
        if (preStm != null)
            preStm.close();
        if (conn != null) 
            conn.close();
    }
    
    public List<ItemDTO> getItemList() throws Exception{
        List<ItemDTO> result = null;
        try {
            String sql = "SELECT itemCode, itemName, supCode, unit, "
                    + "price, supplying FROM tblItems";
            conn = DBUtils.getMyConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {                    
                String itemCode = rs.getString("itemCode");
                String itemName = rs.getString("itemName");
                SupplierDAO suppliers = new SupplierDAO();
                String supCode = rs.getString("supCode");
                SupplierDTO supplier = suppliers.findByPrimaryKey(supCode);
                String unit = rs.getString("unit");
                int price = rs.getInt("price");
                boolean supplying = rs.getBoolean("supplying");
                result.add(new ItemDTO(itemCode, itemName, supplier, unit, price, supplying));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            closeConnection();
        }
        return result;
    }
    
    public ItemDTO findByPrimaryKey(String key) throws Exception {
        ItemDTO dto = null;
        try {
            String sql = "SELECT itemCode, itemName, supCode, unit, price, supplying FROM "
                    + "tblItems WHERE itemCode = ?";
            conn = DBUtils.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, key);
            rs = preStm.executeQuery();
            if(rs.next()) {
                String itemCode = rs.getString("itemCode");
                String itemName = rs.getString("itemName");
                SupplierDAO suppliers = new SupplierDAO();
                String supCode = rs.getString("supCode");
                SupplierDTO supplier = suppliers.findByPrimaryKey(supCode);
                String unit = rs.getString("unit");
                int price = rs.getInt("price");
                boolean supplying = rs.getBoolean("supplying");
                dto = new ItemDTO(itemCode, itemName, supplier, unit, price, supplying);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    
    public boolean insert(ItemDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "INSERT INTO tblItems(itemCode, itemName, supCode, unit, price, supplying) "
                    + "VALUES(?, ?, ?, ?, ?, ?)";
            conn = DBUtils.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getItemCode());
            preStm.setString(2, dto.getItemName());
            SupplierDTO suppliers = dto.getSupplier();
            preStm.setString(3, suppliers.getSupCode());
            preStm.setString(4, dto.getUnit());
            preStm.setInt(5, dto.getPrice());
            preStm.setBoolean(6, dto.isSupplying());
           
            check = preStm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean update(ItemDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "UPDATE tblItems SET itemName = ?, supCode = ?, unit = ?, price = ?, supplying = ? "
                    + "WHERE itemCode = ?";
            conn = DBUtils.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(6, dto.getItemCode());
            preStm.setString(1, dto.getItemName());
            SupplierDTO suppliers = dto.getSupplier();
            preStm.setString(2, suppliers.getSupCode());
            preStm.setString(3, dto.getUnit());
            preStm.setInt(4, dto.getPrice());
            preStm.setBoolean(5, dto.isSupplying());
            check = preStm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean delete(String itemCode) throws Exception {
        boolean check = false;
        try {
            String sql = "UPDATE tblItems SET Supplying = 0 WHERE itemCode = ?";
            conn = DBUtils.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, itemCode);
            check = preStm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }
    
     public boolean checkIDDuplicate(String itemCode) throws Exception {
        boolean check = false;
        try {
            String sql = "SELECT COUNT(*) AS count FROM tblItems"
                    + " GROUP BY itemCode "
                    + "HAVING itemCode = ?";
            conn = DBUtils.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, itemCode);
            rs = preStm.executeQuery();
            if (rs.next()) {
                check = rs.getInt("count") > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }    
}
