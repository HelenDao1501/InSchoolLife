/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tramdb.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tramdb.dtos.MajorDTO;
import tramdb.utils.MyConnection;
import static tramdb.utils.MyConnection.openConnection;

/**
 *
 * @author yiyangqianxi
 */
public class MajorDAO extends MyConnection {

    public static Connection con = null;
    public static PreparedStatement preStm = null;
    public static ResultSet rs = null;

    public static void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (con != null) {
            con.close();
        }
    }

    public List<MajorDTO> getAllMajors() throws Exception {
        List<MajorDTO> list = new ArrayList<>();
        try {
            con = openConnection();
            if (con != null) {
                String sql = "select majorName, majorID from tblMajors where status = ?";
                preStm = con.prepareStatement(sql);
                preStm.setBoolean(1, true);
                rs = preStm.executeQuery();
                while (rs.next()) {
                    String majorName = rs.getString(1);
                    String majorID = rs.getString(2);               

                    MajorDTO dto = new MajorDTO(majorName, majorID);
                    list.add(dto);

                }
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public String findMajorNameByID(String id) throws Exception {
        String sql = "select majorName, majorID from tblMajors where majorID = ?";
        String name = "";
        try (Connection c = openConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                name = rs.getString("majorName");
            }
        }
        return name;
    }
    
    public boolean checkID(String id) throws Exception{
        String sql="select majorID from tblMajors where majorID like ?";
        try(Connection c=openConnection();
                PreparedStatement ps=c.prepareStatement(sql)){
            ps.setString(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                return true;
            }
            return false;
        }
    }

    public boolean insert(MajorDTO major) throws SQLException, Exception {
        boolean result = false;
        try {
            con = openConnection();
            if (con != null) {
                String sql = "insert into tblMajors(majorName, majorID) values (?,?)";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, major.getMajorName());
                preStm.setString(2, major.getMajorID());
                

                int i = preStm.executeUpdate();
                if (i != 0) {
                    result = true;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            closeConnection();
        }
        return result;
    }
    
    public int update(String id,String name) throws Exception{
        String sql="update tblMajors set majorName = ?  where majorID = ?";
        try(Connection c=openConnection();
                PreparedStatement ps=c.prepareStatement(sql)){
            ps.setString(1, name);
            
            ps.setString(2, id);
            return ps.executeUpdate();
        }
    }
    
    public int delete(String id) throws Exception{
        String sql="update tblMajors set status = ?  where majorID = ?";
        try(Connection c=openConnection();
                PreparedStatement ps=c.prepareStatement(sql)){
            ps.setBoolean(1, false);
            ps.setString(2, id);
            return ps.executeUpdate();
        }
    }
    
//    public boolean deleteByID(String id)
//            throws SQLException, ClassNotFoundException, Exception {
//
//        try {
//            con = MyConnection.openConnection();
//            String statement = "DELETE FROM tblMajors WHERE majorID = ?";
//            preStm = con.prepareStatement(statement);
//
//            preStm.setString(1, id);
//            int affectedRows = preStm.executeUpdate();
//
//            if (affectedRows > 0) {
//                return true;
//            }
//
//        } finally {
//            closeConnection();
//        }
//        return false;
//    }



}
