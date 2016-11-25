/*-------------------------------------------------------------------------
---------------------------------------------------------------------------
---	Universidade Federal de São Carlos - Campus Sorocaba 		---
---	Bacharelado em Ciência da Computação				---
---	Sorriso de Criança						---
---									---
---		Bruno Pereira						---
---		Celso Araujo Filho					---
---		Cristiano Silva						---
---		Pedro Brito Junior					---
---		Yasmin Beatriz Alves da Silva 				---
---									---
---------------------------------------------------------------------------
---------------------------------------------------------------------------
*/
package lib;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.ModelLogin;

public class Login extends DbAccess<Object>{
    
    private ModelLogin info;
    
    public Login(String user, String passw)
    {
        info = new ModelLogin();
        info.setUsuario(user);
        info.setSenha(passw);
        
        auth();
    }

    public String getUserPriv()
    {
        return info.getPriv();
    }
    
    /**
    * Executa uma query no banco e retorna true caso o usuário tenha sido autentificado
    * @return boolean 
    */
    private boolean auth()
    {
        String comando = "Select privilegio from login where usuario = ? and senha = ?;";
     
        try 
        {
            Object retorno = RetornaUnicoValor(comando, info.getUsuario(),info.getSenha());
            if(retorno != null)
            {
                info.setPriv(retorno.toString());
                return true;
            }           
            
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Object ConverterResultSet(ResultSet resultSetAtual) throws SQLException {
        return new Object();
    }
    
}
