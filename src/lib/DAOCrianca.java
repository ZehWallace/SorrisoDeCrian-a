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
import models.ModelCrianca;

public class DAOCrianca extends DbAccess<ModelCrianca> {

    public DAOCrianca() {
        super();
    }

    /**
     * Executa uma query no banco e retorna um Objeto tipo ModelCrianca
     *
     * @param id id da crianca a ser pesquisada
     * @return ModelCrianca
     * @throws SQLException
     * @throws Exception
     */
    public ModelCrianca getCrianca(int id) throws SQLException, Exception {
        String comando = "select * from Crianca where id = ?;";
        ArrayList<ModelCrianca> retorno = Listar(comando, id);
        if (retorno.size() > 0) {
            return retorno.get(0);
        }
        return null;
    }

    /**
     * Executa uma query no banco e retorna um Objeto tipo ModelCrianca
     *
     * @param id id da crianca a ser pesquisada
     * @return ModelCrianca
     * @throws SQLException
     * @throws Exception
     */
    public ArrayList<ModelCrianca> getCriancaByName(String nome) throws SQLException, Exception {
        String comando = "select * from Crianca where nome like ?";
        System.out.println("Parametro: " + nome);
        ArrayList<ModelCrianca> retorno = Listar(comando, "%" + nome + "%");

        return retorno;
    }

    /**
     * Executa um comando INSERT no banco e retorna 1 caso o comando tenha tido
     * sucesso
     *
     */
    public void insereCrianca(ModelCrianca crianca) throws SQLException, Exception {
        String comando = "INSERT INTO Crianca (nome, data_nascimento, rg, sexo, status, endereco, nome_responsavel, tel_contato, observacao) "
                + "VALUES (?,?,?,?,?,?,?,?,?)";

        Inserir(comando, crianca.getNome(), crianca.getData_nascimento(), crianca.getRg(),
                crianca.getSexo(), crianca.getStatus(), crianca.getEndereco(), crianca.getNome_responsavel(),
                crianca.getTel_contato(), crianca.getObservacao());
    }

    /**
     * Executa uma query no banco e retorna uma array de objetos tipo
     * ModelCrianca
     *
     * @param nome nome da crianca a ser pesquisada
     * @return ArrayList<ModelCrianca>
     * @throws SQLException
     * @throws Exception
     */
    public ArrayList<ModelCrianca> getPesquisaCrianca(String nome) throws SQLException, Exception {
        String comando = "select * from Crianca where nome like ? limit 15 offset 0";
        ArrayList<ModelCrianca> retorno = Listar(comando, "%" + nome + "%");

        if (retorno.size() > 0) {
            return retorno;
        }
        return null;
    }

    /**
     * Executa uma query no banco e retorna uma array de objetos tipo
     * ModelCrianca com status Ativo
     *
     * @return ArrayList<ModelCrianca>
     * @throws SQLException
     * @throws Exception
     */
    public ArrayList<ModelCrianca> getCriancasAtivas() throws SQLException, Exception {
        String comando = "select * from Crianca where status = 'Ativo'";
        ArrayList<ModelCrianca> retorno = Listar(comando);

        if (retorno.size() > 0) {
            return retorno;
        }
        return null;
    }

    public ArrayList<ModelCrianca> getTodasCrianças() throws SQLException, Exception {
        String comando = "select * from Crianca";
        ArrayList<ModelCrianca> retorno = Listar(comando);

        if (retorno.size() > 0) {
            return retorno;
        }
        return null;
    }

    @Override
    public ModelCrianca ConverterResultSet(ResultSet resultSetAtual) throws SQLException {
        ModelCrianca crianca = new ModelCrianca();

        crianca.setId(resultSetAtual.getInt("id"));
        crianca.setNome(resultSetAtual.getString("nome"));
        crianca.setData_nascimento(resultSetAtual.getDate("data_nascimento"));
        crianca.setRg(resultSetAtual.getString("rg"));
        crianca.setSexo(resultSetAtual.getString("sexo"));
        crianca.setEndereco(resultSetAtual.getString("endereco"));
        crianca.setStatus(resultSetAtual.getString("status"));
        crianca.setTel_contato(resultSetAtual.getString("tel_contato"));
        crianca.setNome_responsavel(resultSetAtual.getString("nome_responsavel"));
        crianca.setObservacao(resultSetAtual.getString("observacao"));

        return crianca;
    }

    public void report(String nome) {
        nome = "%" + nome + "%";

        //Parametros
        Map map = new HashMap();
        map.put("parameter1", nome);
        super.report("src/Criancas.jrxml", map);
    }
}
