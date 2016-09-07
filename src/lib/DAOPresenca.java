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

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.ModelPresenca;


public class DAOPresenca extends DbAccess<ModelPresenca>{
    
    public DAOPresenca()
    {
        super();
    }
    
    /**
    * Executa uma query no banco e retorna um Objeto tipo ModelCrianca
    * @param id id id da crianca a ser pesquisada a presensa
    * @return ArrayList<ModelPresenca> retorna array com datas que a crianca esteve presente
    * @throws SQLException
    * @throws Exception
    */
    public ArrayList<ModelPresenca> getPesquisaCriancaPresenca(int id) throws SQLException, Exception
    {
           String comando = "select * from Presenca where crianca = ?";
           return Listar(comando, id);
    }
    
    /**
    * Executa uma query no banco e retorna um Objeto tipo ModelCrianca
    * @param Date data data da presenca a ser pesquisada
    * @return ArrayList<ModelPresenca> retorna array com crianças presentes no dia
    * @throws SQLException
    * @throws Exception
    */
    public ArrayList<ModelPresenca> getPesquisaDataPresenca(Date data) throws SQLException, Exception
    {
           String comando = "select * from Presenca where data = ?";
           return Listar(comando, data);
    }

    @Override
    public ModelPresenca ConverterResultSet(ResultSet resultSetAtual) throws SQLException {
        ModelPresenca presenca = new ModelPresenca();
        
        presenca.setCrianca(resultSetAtual.getInt("crianca"));
        presenca.setData_presenca(resultSetAtual.getDate("data_presenca"));
        
        return presenca;
    }   
}