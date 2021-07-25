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
import javax.swing.JOptionPane;
import tramdb.db.DBUtils;
import tramdb.dtos.SupplierDTO;

/**
 *
 * @author PhuongPT
 */
public class SupplierDAO {
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

    public SupplierDAO() {
    }
    
    public List<SupplierDTO> getSupplierList() throws Exception{
        List<SupplierDTO> result = null;
        try {
            String sql = "SELECT supCode, supName, address, colloborating FROM tblSuppliers WHERE colloborating = 1";
            conn = DBUtils.getMyConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            result = new ArrayList();
            while (rs.next()) {                    
                String supCode = rs.getString("supCode");
                String supNae = rs.getString("supName");
                String address = rs.getString("address");
                boolean colloborating = rs.getBoolean("colloborating");
                result.add(new SupplierDTO(supCode, supNae, address, colloborating));
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
    
    
    public SupplierDTO findByPrimaryKey(String key) throws Exception {
        SupplierDTO dto = null;
        try {
            String sql = "SELECT supCode, supName, Address, Colloborating FROM "
                    + "tblSuppliers WHERE supCode = ?";
            conn = DBUtils.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, key);
            rs = preStm.executeQuery();
            if(rs.next()) {
                String supCode = rs.getString("supCode");
                String supName = rs.getString("supName");
                String address = rs.getString("address");
                boolean colloborating = rs.getBoolean("colloborating");
                dto = new SupplierDTO(supCode, supName, address, colloborating);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    
    public boolean insert(SupplierDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "INSERT INTO tblSuppliers(supCode, supName, address, colloborating) "
                    + "VALUES(?, ?, ?, ?)";
            conn = DBUtils.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getSupCode());
            preStm.setString(2, dto.getSupName());
            preStm.setString(3, dto.getAddress());
            preStm.setBoolean(4, dto.isColloborating());
            check = preStm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean update(SupplierDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "UPDATE tblSuppliers SET SupName = ?, Address = ?, "
                    + "Colloborating = ? WHERE SupCode = ?";
            conn = DBUtils.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(4, dto.getSupCode());
            preStm.setString(1, dto.getSupName());
            preStm.setString(2, dto.getAddress());
            preStm.setBoolean(3, dto.isColloborating());
            check = preStm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean delete(String supCode) throws Exception {
        boolean check = false;
        try {
            String sql = "UPDATE tblSuppliers SET Colloborating = 0 WHERE supCode = ?";
            conn = DBUtils.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, supCode);
            check = preStm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }
    
     public boolean checkIDDuplicate(String supCode) throws Exception {
        boolean check = false;
        try {
            String sql = "SELECT COUNT(*) AS count FROM tblSuppliers"
                    + " GROUP BY supCode "
                    + "HAVING supCode = ?";
            conn = DBUtils.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, supCode);
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
     
    public int findCode(String supCode) throws Exception {
        List<SupplierDTO> list = getSupplierList();
        if(list.isEmpty())
            return -1;
        for (int i = 0; i < list.size(); i++) {
            if(supCode.equalsIgnoreCase(list.get(i).getSupCode()))
                return i;
        }
        return -1;
    }
}
