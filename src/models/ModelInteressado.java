/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Yasmin
 */
public class ModelInteressado {
    private String nome_crianca;
    private Date data_nascimento;
    private Date data_interesse;
    private String nome_responsavel;
    private String telefone;
    private String observacao;
    private String status;
    private String endereco;
    
    
    public String getData_interesse() {
        return new SimpleDateFormat("dd/MM/yyyy").format(data_interesse);
    }

    public void setData_interesse(Date data_interesse) throws ParseException {
        
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String date = new SimpleDateFormat("dd/MM/yyyy").format(data_interesse);
        this.data_interesse =  format.parse(date);
    }
    
    public String getNomeCrianca()
    {
        return nome_crianca;
    }
    
    public void setNomeCrianca(String nome_crianca)
    {
        this.nome_crianca = nome_crianca;
    }
    
    public String getDataNascimento()
    {
        return new SimpleDateFormat("dd/MM/yyyy").format(data_nascimento);
    }
    
    public void setDataNascimento(Date data_nascimento) throws ParseException
    {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String date = new SimpleDateFormat("dd/MM/yyyy").format(data_nascimento);
        this.data_nascimento = format.parse(date);
    }
    
    public String getNomeResponsavel()
    {
        return nome_responsavel;
    }
    
    public void setNomeResponsavel(String nome_responsavel)
    {
        this.nome_responsavel = nome_responsavel;
    }
    
    public String getTelefone()
    {
        return telefone;
    }
    
    public void setTelefone(String telefone)
    {
        this.telefone = telefone;
    }
    
    public String getObservacao()
    {
        return observacao;
    }
    
    public void setObservacao(String observacao)
    {
        this.observacao = observacao;
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    public String getEndereco()
    {
        return endereco;
    }
    
    public void setEndereco(String endereco)
    {
        this.endereco = endereco;
    }
    
}
