/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utils.ConnectionBuilder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author azlich
 */
public class DummyModel {
    public DummyModel(){
    
    }
 public String queryDemo() throws SQLException{
        String demo = "";
        Connection con = ConnectionBuilder.getConnection();
        Statement st;
        ResultSet rs = null;
        try {
            st = con.createStatement();
                rs = st.executeQuery("SELECT * FROM TestLoadData");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(rs != null){
            while(rs.next())
                demo = rs.getString("data");
        }
        return demo; 
    }
 
    public static void main(String[] args) throws SQLException {
        System.out.println((new DummyModel()).queryDemo());
    }
}
