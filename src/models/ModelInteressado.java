/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author Yasmin
 */
public class ModelInteressado {
    private String nome_crianca;
    private Date data_nascimento;
    private String nome_responsavel;
    private String telefone;
    private String observacao;
    private String status;
    private String endereco;
    
    public String getNomeCrianca()
    {
        return nome_crianca;
    }
    
    public void setNomeCrianca(String nome_crianca)
    {
        this.nome_crianca = nome_crianca;
    }
    
    public Date getDataNascimento()
    {
        return data_nascimento;
    }
    
    public void setDataNascimento(Date data_nascimento)
    {
        this.data_nascimento = data_nascimento;
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
