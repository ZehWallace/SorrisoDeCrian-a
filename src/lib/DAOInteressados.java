/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.ModelInteressado;

/**
 *
 * @author Yasmin
 */
public class DAOInteressados extends DbAccess<ModelInteressado>{
    
    /* Executa um comando INSERT no banco */
    public void insereInteressado(ModelInteressado interessado) throws SQLException, Exception
    {
        String comando = "INSERT INTO interessado (nome_crianca, data_interesse, data_nascimento, endereco, nome_responsavel, "
                + "status, tel_contato, observacao) VALUES(?,?,?,?,?,?,?,?)";
        
        String temp[] = interessado.getDataNascimento().split("/");
        String dia = temp[0];
        String mes = temp[1];
        String ano = temp[2];
        
        String nascimento = ano+"-"+mes+"-"+dia;
        
        String temp2[] = interessado.getData_interesse().split("/");
        dia = temp2[0];
        mes = temp2[1];
        ano = temp2[2];
        
        String interesse = ano+"-"+mes+"-"+dia;
        
        Inserir(comando, interessado.getNomeCrianca(), interesse,nascimento, interessado.getEndereco(),
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
        String comando = "select * from Interessado order by data_interesse";
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
        try {
            ModelInteressado modelInteressado = new ModelInteressado();
            
            String temp[] = resultSetAtual.getString("data_nascimento").split("-");
            String dia = temp[0];
            String mes = temp[1];
            String ano = temp[2];

            String nascimento = ano+"/"+mes+"/"+dia;

            String temp2[] = resultSetAtual.getString("data_interesse").split("-");
            dia = temp2[0];
            mes = temp2[1];
            ano = temp2[2];
            
            String interesse = ano+"/"+mes+"/"+dia;
            
            modelInteressado.setDataNascimento(nascimento);
            modelInteressado.setData_interesse(interesse);
            modelInteressado.setNomeCrianca(resultSetAtual.getString("nome_crianca"));
            modelInteressado.setEndereco(resultSetAtual.getString("endereco"));
            modelInteressado.setNomeResponsavel(resultSetAtual.getString("nome_responsavel"));
            modelInteressado.setTelefone(resultSetAtual.getString("tel_contato"));
            modelInteressado.setStatus(resultSetAtual.getString("status"));
            modelInteressado.setObservacao(resultSetAtual.getString("observacao"));
            
            return modelInteressado;
        } catch (ParseException ex) {
            Logger.getLogger(DAOInteressados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
