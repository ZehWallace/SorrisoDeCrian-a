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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import models.ModelVoluntario;

public class DAOVoluntario extends DbAccess<ModelVoluntario>{
    
    public DAOVoluntario()
    {
        super();
    }
    
    /**
    * Executa uma query no banco e retorna um ArrayList do tipo ModelVoluntario
    * @param 
    * @return ArrayList<ModelVoluntario>
    * @throws SQLException
    * @throws Exception
    */
    public ArrayList<ModelVoluntario> getTodosVoluntarios() throws SQLException, Exception
    {
        String comando = "select * from Voluntario";
           ArrayList<ModelVoluntario> retorno = Listar(comando);
           
           if(retorno.size() > 0)
               return retorno;
           return null;
    }
    
    /**
    * Executa uma query no banco e retorna um Objeto tipo ModelVoluntario
    * @param id id id do voluntario a ser pesquisada
    * @return ModelVoluntario 
    * @throws SQLException
    * @throws Exception
    */
    public ModelVoluntario getVoluntario(int id) throws SQLException, Exception
    {
           String comando = "select * from Voluntario where id = ?;";
           ArrayList<ModelVoluntario> retorno = Listar(comando,id);
           
           if(retorno.size() > 0)
               return retorno.get(0);
           return null;
    }
    
    /**
    * Executa uma query no banco e retorna um ArrayList do Objeto tipo ModelVoluntario
    * @param nome do voluntario a ser pesquisado
    * @return ModelVoluntario
    * @throws SQLException
    * @throws Exception
    */
    public ArrayList<ModelVoluntario> getVoluntarioByName(String nome) throws SQLException, Exception
    {
           String comando = "select * from Voluntario where nome like '%?%';";
           ArrayList<ModelVoluntario> retorno = Listar(comando, nome);
           
           return retorno;
    }
    
    /**
    * Executa uma inserção no banco
    * @param  Model do Voluntário
    * @return void
    * @throws SQLException
    * @throws Exception
    */
    
    public void insereVoluntario(ModelVoluntario voluntario) throws SQLException, Exception
    {
        String comando = "INSERT INTO Voluntario (nome, data_nascimento, rg, cpf, sexo, ocupacao, endereco, tel_contato, email, observacao, "
                + "situacao_profissional, formacao, dias_semana, periodo, status) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        Inserir(comando, voluntario.getNome(), voluntario.getData_nascimento(), voluntario.getRg(),
                voluntario.getCpf(), voluntario.getSexo(), voluntario.getOcupacao(), voluntario.getEndereco(), 
                voluntario.getTel_contato(), voluntario.getEmail(), voluntario.getObservacao(),
                voluntario.getSituacaoProfissional(), voluntario.getFormacao(), voluntario.getDiasSemana(), voluntario.getPeriodo(),
                voluntario.getStatus());
       
    }
    
    /**
    * Executa uma query no banco e retorna uma array de objetos tipo ModelVoluntario
    * @param nome nome nome do voluntario a ser pesquisada
    * @return ModelVoluntario 
    * @throws SQLException
    * @throws Exception
    */
    public ArrayList<ModelVoluntario> getPesquisaVoluntario(String nome) throws SQLException, Exception
    {
           String comando = "select * from Voluntario where nome like ? limit 15 offset 0";
           ArrayList<ModelVoluntario> retorno = Listar(comando,"%"+nome+"%");
           
           if(retorno.size() > 0)
               return retorno;
           return null;
    }

    @Override
    public ModelVoluntario ConverterResultSet(ResultSet resultSetAtual) throws SQLException {
        ModelVoluntario voluntario = new ModelVoluntario();
        
        voluntario.setId(resultSetAtual.getInt("id"));
        voluntario.setNome(resultSetAtual.getString("nome"));
        voluntario.setData_nascimento(resultSetAtual.getDate("data_nascimento"));
        voluntario.setRg(resultSetAtual.getString("rg"));
        voluntario.setCpf(resultSetAtual.getString("cpf"));
        voluntario.setSexo(resultSetAtual.getString("sexo"));
        voluntario.setEndereco(resultSetAtual.getString("endereco"));
        voluntario.setOcupacao(resultSetAtual.getString("ocupacao"));
        voluntario.setTel_contato(resultSetAtual.getString("tel_contato"));
        voluntario.setEmail(resultSetAtual.getString("email"));
        voluntario.setObservacao(resultSetAtual.getString("observacao"));

        
        return voluntario;
    }   
    
    public void report(Map map){
        super.report("src/Voluntarios.jrxml", map);
    }
}
