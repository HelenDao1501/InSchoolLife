/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tramdb.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tramdb.dtos.StudentDTO;
import tramdb.utils.MyConnection;

/**
 *
 * @author yiyangqianxi
 */
public class StudentDAO extends MyConnection {

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

    public List<StudentDTO> getAllStudent() throws Exception {
        List<StudentDTO> list = new ArrayList<>();
        try {
            con = openConnection();
            if (con != null) {
                String sql = "select studentID, fullName, phone, email, address,"
                        + " dateOfBirth, isDelete, majorID from tblStudents where isDelete = 0";
                preStm = con.prepareStatement(sql);
                rs = preStm.executeQuery();
                while (rs.next()) {
                    String studentID = rs.getString(1);
                    String fullName = rs.getString(2);
                    String phone = rs.getString(3);
                    String email = rs.getString(4);
                    String address = rs.getString(5);
                    Date dateOfBirth = rs.getDate(6);
                    boolean isDelete = rs.getBoolean(7);
                    String majorID = rs.getString(8);

                    StudentDTO dto = new StudentDTO(studentID, fullName, phone, email, address, dateOfBirth, isDelete, majorID);
                    list.add(dto);
                }

            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public StudentDTO findStudentByID(String ID) throws Exception {
        StudentDTO result = null;
        try {
            con = openConnection();
            if (con != null) {
                String sql = "select studentID, fullName, phone, email, address, "
                        + "dateOfBirth, isDelete, majorID from tblStudents where studentID = ?";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, ID);
                rs = preStm.executeQuery();
                if (rs.next()) {
                    String studentID = rs.getString(1);
                    String fullName = rs.getString(2);
                    String phone = rs.getString(3);
                    String email = rs.getString(4);
                    String address = rs.getString(5);
                    Date dateOfBirth = rs.getDate(6);
                    boolean isDelete = rs.getBoolean(7);
                    String majorID = rs.getString(8);

                    result = new StudentDTO(studentID, fullName, phone, email, address, dateOfBirth, isDelete, majorID);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean checkIdStu(String id) throws Exception {
        String sql = "select studentID from tblStudents where studentID like ?";
        try (Connection c = openConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
            return false;
        } finally {
            closeConnection();
        }
    }

    public boolean insert(StudentDTO student) throws SQLException, Exception {
        boolean result = false;
        try {
            con = openConnection();
            if (con != null) {
                String sql = "insert into tblStudents(studentID, fullName, phone, email, address, dateOfBirth, isDelete, majorID) values (?,?,?,?,?,?,?,?)";

                System.out.println(student.getMajorID());
                System.out.println(student.isIsDelete());
                preStm = con.prepareStatement(sql);
                preStm.setString(1, student.getStudentID());
                preStm.setString(2, student.getFullName());
                preStm.setString(3, student.getPhone());
                preStm.setString(4, student.getEmail());
                preStm.setString(5, student.getAddress());
                preStm.setDate(6, student.getDateOfBirth());
                preStm.setBoolean(7, student.isIsDelete());
                preStm.setString(8, student.getMajorID());

                int i = preStm.executeUpdate();
                if (i != 0) {
                    result = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean update(StudentDTO student) throws Exception, SQLException {
        boolean result = false;

        try {
            con = openConnection();
            if (con != null) {
                String sql = "update tblStudents set fullName = ?, phone = ?, email = ?, address = ?,"
                        + " dateOfBirth = ?, isDelete = ?, majorID = ?  where studentID = ?";
                preStm = con.prepareStatement(sql);

                preStm.setString(1, student.getFullName());
                preStm.setString(2, student.getPhone());
                preStm.setString(3, student.getEmail());
                preStm.setString(4, student.getAddress());
                preStm.setDate(5, student.getDateOfBirth());
                preStm.setBoolean(6, student.isIsDelete());
                preStm.setString(7, student.getMajorID());
                preStm.setString(8, student.getStudentID());

                int i = preStm.executeUpdate();
                if (i != 0) {
                    result = true;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public int delete(String id) throws Exception {
        String sql = "delete from tblStudents where studentID like ?";
        try (Connection c = openConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, id);
            return ps.executeUpdate();
        }
    }

    public boolean checkMajorIDTblStudent(String id) throws Exception {
        String sql = "select studentID from tblStudents where majorID = ?";
        try (Connection c = openConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
            return false;
        }
    }

    public boolean deleteStudentByMajorId(String id) throws Exception {

        String sql = "update tblStudents set isDelete = 1 where majorID = ?";

        try (Connection c = openConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, id);

            int result = ps.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (Exception e) {
        }

        return false;
    }
}
