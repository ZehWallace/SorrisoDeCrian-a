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
import java.util.HashMap;
import java.util.Map;
import models.ModelPresenca;


public class DAOPresenca extends DbAccess<ModelPresenca>{
    
    public DAOPresenca()
    {
        super();
    }
    
    /**
    * Executa uma query no banco e retorna uma Array de tipo ModelPresenca
    * @param id id da crianca a ser pesquisada a presensa
    * @param limit limit de dias a pesquisar a presenca
    * @return ArrayList<ModelPresenca> retorna array com datas que a crianca esteve presente
    * @throws SQLException
    * @throws Exception
    */
    public ArrayList<ModelPresenca> getPesquisaCriancaPresenca(int id, int limit) throws SQLException, Exception
    {
           String comando = "select * from Presenca where crianca = ? order by data_presenca limit ?";
           return Listar(comando, id, limit);
    }
    
    /**
    * Executa uma query no banco e retorna um Array de tipo ModelPresenca
    * @return ArrayList<ModelPresenca> retorna array com datas que a crianca esteve presente
    * @throws SQLException
    * @throws Exception
    */
    public ArrayList<ModelPresenca> getTodasPesquisas() throws SQLException, Exception
    {
           String comando = "select * from Presenca order by data_presenca";
           return Listar(comando);
    }
    
    /**
    * Executa uma query no banco e retorna um Objeto tipo ModelCrianca
    * @param id id da crianca a ser pesquisada a presensa
    * @param data data da presença a ser pesquisada
    * @return ModelPresenca retorna informacoes de presença de uma crianca em uma data
    * @throws SQLException
    * @throws Exception
    */
    public ModelPresenca getPesquisaCriancaPresencaData(int id, String data) throws SQLException, Exception
    {
           String comando = "select * from Presenca where crianca = ? and data_presenca = ?";
           ArrayList<ModelPresenca> result = Listar(comando, id, data);
           
           if(result.size() > 0)
           {
                return result.get(0);
           }
           
           return null;
    }
    
    /**
    * Executa uma query no banco que insere uma presença
    * @param id id da crianca relacionada a presenca
    * @param data data da presença
    * @param status status da presença
    * @throws SQLException
    * @throws Exception
    */
    public void insertPresencaCrianca(String id, String data, String status) throws SQLException, Exception
    {
           String comando = "insert into Presenca values (?,?,?)";
           Inserir(comando, id, data,status);
    }
    
    /**
    * Executa uma query no banco que atualiza uma presença
    * @param id id da crianca relacionada a presenca
    * @param data data da presença
    * @param status status da presença
    * @throws SQLException
    * @throws Exception
    */
    public void updatePresencaCrianca(String id, String data, String status) throws SQLException, Exception
    {
           String comando = "update Presenca values set status = ? where crianca = ? and data_presenca = ?";
           Inserir(comando, status,id, data);
    }
    
    /**
    * Executa uma query no banco e retorna um Objeto tipo ModelCrianca
    * @param data data da presenca a ser pesquisada
    * @return ArrayList<ModelPresenca> retorna array com crianças presentes no dia
    * @throws SQLException
    * @throws Exception
    */
    public ArrayList<ModelPresenca> getPesquisaDataPresenca(Date data) throws SQLException, Exception
    {
           String comando = "select * from Presenca where data_presenca = ?";
           return Listar(comando, data);
    }
    
    /**
    * Executa uma query no banco e retorna um Objeto tipo ModelCrianca
    * @param data data a contar presencas
    * @return int retorna contagem de presenças no dia
    * @throws SQLException
    * @throws Exception
    */
    public int contPresencaData(Date data) throws SQLException, Exception
    {
           String comando = "select count(*) from Presenca where data_presenca = ?";
           return RetornaContagem(comando, data);
    }

    @Override
    public ModelPresenca ConverterResultSet(ResultSet resultSetAtual) throws SQLException {
        ModelPresenca presenca = new ModelPresenca();
        
        presenca.setCrianca(resultSetAtual.getInt("crianca"));
        presenca.setData_presenca(resultSetAtual.getDate("data_presenca"));
        presenca.setStatus(resultSetAtual.getString("status"));
        
        return presenca;
    }   
    
    public void report(String arg){
        Map map = new HashMap();
        super.report("src/Presencas.jrxml", map);
    }
}