/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Emmanuel
 */
public class Conexion {
    
    private static Connection Conexion;
 
    /*public void MySQLConnection(String user, String pass, String db_name) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name, user, pass);
            JOptionPane.showMessageDialog(null,"Se ha iniciado la conexión con el servidor de forma exitosa" );
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,ex );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex );
        }
    }*/
    public void closeConnection() {
        try {
            Conexion.close();
            JOptionPane.showMessageDialog(null,"Se ha finalizado la conexión con el servidor" );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex );
        }
    }
    public void insertData(String table_name, String Num_placa, double Precio, int Seminuevo, String Color, String Modelo,int Marca,String Year) {
        try {
            String Query = "INSERT INTO " + table_name + " VALUES("
                    + "\"" + Num_placa + "\", "
                    + "\"" + Precio + "\", "
                    + "\"" + Seminuevo + "\", "
                    + "\"" + Color + "\", "
                    + "\"" + Modelo + "\")"
                    + "\"" + Marca+ "\")"
                    + "\"" + Year + "\")";
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
        }
    }
    public void getValues(String table_name) {
        try {
            String Query = "SELECT * FROM " + table_name;
            Statement st = Conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
 
            while (resultSet.next()) {
                resultSet.getString("Num_placa");                                       
                resultSet.getDouble("Precio"); 
                resultSet.getInt("Seminuevo"); 
                resultSet.getString("Color");
                resultSet.getString("Modelo");
                resultSet.getString("Marca");
                resultSet.getString("Year");
            }
 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
        }
    }
    
    public static ArrayList<carros> homePageContent(){
        ArrayList<carros> list = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdcarros");
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery("SELECT * FROM carros`");
            
            carros pl;
            
            while(rs.next()){
                pl = new carros(rs.getString("mbrand"),rs.getString("mmodel"),
                        rs.getInt("mprice"),rs.getInt("mquantity"),rs.getString("mdescription"),
                        rs.getString("mphoto"));
                
                list.add(pl);

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MobileDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
   }
    
    
    public void deleteRecord(String table_name, String ID) {
        try {
            String Query = "DELETE FROM " + table_name + " WHERE ID = \"" + ID + "\"";
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
        }
}
}
