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
package models;

import java.sql.Date;


public class ModelCrianca 
{

   private int id;
   private String nome;
   private Date data_nascimento;
   private String rg;
   private String sexo;
   private String status;
   private String endereco;
   private String nome_responsavel;
   private String tel_contato;
   private String observacao;
   private String energia_eletrica;
   private String agua_encanada;
   private String esgoto;
   private String data_prevista;
   private String pode_sair_sozinha;
   private String convenio;
   private String centroSaude;
   private String sarampo;
   private String rubeola;
   private String coqueluche;
   private String broncoPneumonia;
   private String catapora;
   private String hepatite;
   private String meningite;
   private String convulsao;
   private String desmaio;
   private String problemaRespiratorio;
   private String internacao;
   private String alergia;
   private String cirurgia;
   private String alergiaMedicamento;
   private String diarreia;
   private String diabetes;
   private String insulina;
   private String outrasDoencas;
   private String pessoa_autorizada;
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome_responsavel() {
        return nome_responsavel;
    }

    public void setNome_responsavel(String nome_responsavel) {
        this.nome_responsavel = nome_responsavel;
    }

    public String getTel_contato() {
        return tel_contato;
    }

    public void setTel_contato(String tel_contato) {
        this.tel_contato = tel_contato;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    public String getEnergiaEletrica() {
        return energia_eletrica;
    }

    public void setEnergiaEletrica(String energia_eletrica) {
        this.energia_eletrica = energia_eletrica;
    }
    
    public String getAguaEncanada() {
        return agua_encanada;
    }

    public void setAguaEncanada(String agua_encanada) {
        this.agua_encanada = agua_encanada;
    }
    
    public String getEsgoto() {
        return esgoto;
    }

    public void setEsgoto(String esgoto) {
        this.esgoto = esgoto;
    }
    
    public String getSairSozinha() {
        return pode_sair_sozinha;
    }

    public void setSairSozinha(String pode_sair_sozinha) {
        this.pode_sair_sozinha = pode_sair_sozinha;
    }
    
    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }
    
    public String getCentroSaude() {
        return centroSaude;
    }

    public void setCentroSaude(String centroSaude) {
        this.centroSaude = centroSaude;
    }
    
    public String getSarampo() {
        return sarampo;
    }

    public void setSarampo(String sarampo) {
        this.sarampo = sarampo;
    }
    
    public String getRubeola() {
        return rubeola;
    }

    public void setRubeola(String rubeola) {
        this.rubeola = rubeola;
    }
    
    public String getCoqueluche() {
        return coqueluche;
    }

    public void setCoqueluche(String coqueluche) {
        this.coqueluche = coqueluche;
    }
    
    public String getBroncoPneumonia() {
        return broncoPneumonia;
    }

    public void setBroncoPneumonia(String broncoPneumonia) {
        this.broncoPneumonia = broncoPneumonia;
    }
    
    public String getCatapora() {
        return catapora;
    }

    public void setCatapora(String catapora) {
        this.catapora = catapora;
    }
    
    public String getHepatite() {
        return hepatite;
    }

    public void setHepatite(String hepatite) {
        this.hepatite = hepatite;
    }
    
    public String getMeningite() {
        return meningite;
    }

    public void setMeningite(String meningite) {
        this.meningite = meningite;
    }
    
    public String getConvulsao() {
        return convulsao;
    }

    public void setConvulsao(String convulsao) {
        this.convulsao = convulsao;
    }
    
    public String getDesmaio() {
        return desmaio;
    }

    public void setDesmaio(String desmaio) {
        this.desmaio = desmaio;
    }
    
    public String getProblemaRespiratorio() {
        return problemaRespiratorio;
    }

    public void setProblemaRespiratorio(String problemaRespiratorio) {
        this.problemaRespiratorio = problemaRespiratorio;
    }
    
    public String getInternacao() {
        return internacao;
    }

    public void setInternacao(String internacao) {
        this.internacao = internacao;
    }
    
    public String getAlergia() {
        return alergia;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }
    
    public String getCirurgia() {
        return cirurgia;
    }

    public void setCirurgia(String cirurgia) {
        this.cirurgia = cirurgia;
    }

    public String getAlergiaMedicamento() {
        return alergiaMedicamento;
    }

    public void setAlergiaMedicamento(String alergiaMedicamento) {
        this.alergiaMedicamento = alergiaMedicamento;
    }
    
    public String getDiarreia() {
        return diarreia;
    }

    public void setDiarreia(String diarreia) {
        this.diarreia = diarreia;
    }
    
    public String getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(String diabetes) {
        this.diabetes = diabetes;
    }
    
    public String getInsulina() {
        return insulina;
    }

    public void setInsulina(String insulina) {
        this.insulina = insulina;
    }
    
    public String getOutrasDoencas(){
        return outrasDoencas;
    }    
    
    public void setOutrasDoencas(String outrasDoencas){
        this.outrasDoencas = outrasDoencas;
    }
    
    public String getDataPrevista(){
        return data_prevista;
    }    
    
    public void setDataPrevista(String data_prevista){
        this.data_prevista = data_prevista;
    }
    
    public String getPessoaAutorizada(){
        return pessoa_autorizada;
    }    
    
    public void setPessoaAutorizada(String pessoa_autorizada){
        this.pessoa_autorizada = pessoa_autorizada;
    }
}
