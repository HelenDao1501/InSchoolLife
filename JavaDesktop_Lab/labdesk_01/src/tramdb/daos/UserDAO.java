/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tramdb.daos;

import tramdb.dtos.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import tramdb.db.DBUtils;

/**
 *
 * @author USER
 */
public class UserDAO extends tramdb.db.DBUtils{

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

    public static UserDTO getAccount(String id, String pass) throws Exception {
        UserDTO dto = null;
        try {
            String sql = "select userID, password from tblUsers where userID like ? and password like ?";
            con = DBUtils.getMyConnection() ;
            preStm = con.prepareStatement(sql);
            preStm.setString(1, id);
            preStm.setString(2, pass);
            ResultSet rs = preStm.executeQuery();
            if (rs.next()) {
                dto = new UserDTO(rs.getString("userID"), rs.getString("password"));
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
}
