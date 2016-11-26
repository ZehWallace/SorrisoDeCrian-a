/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.ModelCrianca;
import models.ModelInteressado;

/**
 *
 * @author Yasmin
 */
public class DAOInteressados extends DbAccess<ModelInteressado>{
    
    /* Executa um comando INSERT no banco */
    public void insereInteressado(ModelInteressado interessado) throws SQLException, Exception
    {
        String comando = "INSERT INTO interessado (nome_crianca, data_nascimento, endereco, nome_responsavel, "
                + "status, tel_contato, observacao) VALUES(?,?,?,?,?,?,?)";
        
        Inserir(comando, interessado.getNomeCrianca(), interessado.getDataNascimento(), interessado.getEndereco(),
                interessado.getNomeResponsavel(), interessado.getStatus(), interessado.getTelefone(), interessado.getObservacao());
    }
    
    /**
    * Executa uma query no banco e retorna um ArrayList do tipo ModelVoluntario
    * @param 
    * @return ArrayList<ModelVoluntario>
    * @throws SQLException
    * @throws Exception
    */
    public ArrayList<ModelInteressado> getTodosInteressados() throws SQLException, Exception
    {
        String comando = "select * from Interessado";
           ArrayList<ModelInteressado> retorno = Listar(comando);
           
           if(retorno.size() > 0)
               return retorno;
           return null;
    }
    
    /**
    * Executa uma query no banco e retorna um ArrayList do Objeto tipo ModelVoluntario
    * @param nome do voluntario a ser pesquisado
    * @return ModelVoluntario
    * @throws SQLException
    * @throws Exception
    */
    public ArrayList<ModelInteressado> getInteressadoByNomeCrianca(String nome) throws SQLException, Exception
    {
           String comando = "select * from Interessado where nome_crianca like ? limit 15 offset 0;";
           System.out.println("Comando: " + comando + ". Nome: " + nome);
           ArrayList<ModelInteressado> retorno = Listar(comando, "%" + nome + "%");
           
           return retorno;
    }

    @Override
    public ModelInteressado ConverterResultSet(ResultSet resultSetAtual) throws SQLException {
        ModelInteressado modelInteressado = new ModelInteressado();
        
        modelInteressado.setNomeCrianca(resultSetAtual.getString("nome_crianca"));
        modelInteressado.setDataNascimento(resultSetAtual.getDate("data_nascimento"));
        modelInteressado.setEndereco(resultSetAtual.getString("endereco"));
        modelInteressado.setNomeResponsavel(resultSetAtual.getString("nome_responsavel"));
        modelInteressado.setTelefone(resultSetAtual.getString("tel_contato"));
        modelInteressado.setStatus(resultSetAtual.getString("status"));
        modelInteressado.setObservacao(resultSetAtual.getString("observacao"));
        
        return modelInteressado;
    }
}
