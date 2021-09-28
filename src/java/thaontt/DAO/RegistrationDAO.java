/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thaontt.DAO;

import thaontt.utils.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Thao
 */
public class RegistrationDAO {
    
    public boolean checkLogin(String username, String password) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            //1. connect database
            con = DBHelper.makeConnection();
            //2.creat SQL String
            if (con != null) {
                String sql = "Select useID "
                        + "From tblUsers "
                        + "Where useID = ? And password = ?";
                //3.Create statement
                pst = con.prepareStatement(sql);
                pst.setString(1, username);
                pst.setString(2, password);
                //4.Execute Query
                rs = pst.executeQuery();
                //5. Xử lý kết quả
                if(rs.next()){
                    return true;
                }
            }//end if connection is connected
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return false;
    }
    
}
