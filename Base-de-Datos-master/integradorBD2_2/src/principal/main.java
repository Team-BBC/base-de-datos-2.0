/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

/**
 *
 * @author slacker
 */
public class main {
    public static void main(String[] args) {
                                            //INSTANCIAS
        //login
        inicioSesion login = new inicioSesion();
    
        //admin
        menuPrincipal admin = new menuPrincipal();
        admin.setVisible(false);
        
        //usuario
        menuPrincipalUsuario usuario = new menuPrincipalUsuario();
        usuario.setVisible(false);
        
        //nuevo coche    
        nuevoCoche form1 = new nuevoCoche();
        form1.setVisible(false);
        
        //actualizar coche
        actualizarCoche actualizar = new actualizarCoche();
        actualizar.setVisible(false);
        
        
        
        //splash
        splash sp = new splash(); //instancia de splash
        sp.setVisible(true);
         try {
            for (int i = 0; i < 101 ; i++) {
                if(i==100){
                    login.setVisible(true);
                    sp.setVisible(false);
                }
                Thread.sleep(15);
                sp.jLabel3.setText(Integer.toString(i));
                sp.jProgressBar1.setValue(i);
            }
        } catch (Exception e) {
        }
        
        
    }
    
}


/* 
gray 77, 77, 51
grass green 153, 255, 51
light gray 194, 194, 163
white 255, 255, 255
blue 0, 153, 204
*/