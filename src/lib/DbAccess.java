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

import java.sql.*;
import java.util.ArrayList;
import org.h2.jdbcx.JdbcDataSource;

public abstract class DbAccess<T> {

    private String connectionString;

    private String usuario;

    private String senha;

    private Connection conexao;

    public DbAccess() {
        this.connectionString = "jdbc:h2:./database;CIPHER=AES";
        this.usuario = obfuscate(489832);
        this.senha = obfuscate(213412) + " " + obfuscate(981231);
//        System.out.println(usuario);
//        System.out.println(senha);
    }

    public DbAccess(String connectionString, String usuario, String senha) {
        this.connectionString = connectionString;
        this.usuario = usuario;
        this.senha = senha;
    }

    private void Conectar() throws SQLException {
        if (this.conexao == null || this.conexao.isClosed()) {
            JdbcDataSource ds = new JdbcDataSource();
            ds.setURL(this.connectionString);
            ds.setUser(this.usuario);
            ds.setPassword(this.senha);
            this.conexao = ds.getConnection();
        }
    }

    /**
     * Prepara o comando para ser executado
     *
     * @param query query a ser executada no banco com os parametros ?
     * @param parametros array de parametros na mesma ordem da query
     * @return statement montado
     * @throws SQLException
     */
    private PreparedStatement PrepararComando(String query, Object[] parametros) throws SQLException, Exception {
        PreparedStatement statement = this.conexao.prepareStatement(query);

        
        if (parametros != null) {
            for (int i = 0; i < parametros.length; i++) {
                //System.out.println("Parametro " + i +  ": " + parametros[i]);
                if (parametros[i] instanceof Integer) {
                    statement.setInt(i + 1, (Integer) parametros[i]);
                } else if (parametros[i] instanceof Double) {
                    statement.setDouble(i + 1, (Double) parametros[i]);
                } else if (parametros[i] instanceof Boolean) {
                    statement.setBoolean(i + 1, (Boolean) parametros[i]);
                } else if (parametros[i] instanceof Date) {
                    statement.setDate(i + 1, (Date) parametros[i]);
                } else if (parametros[i] instanceof String) {
                    statement.setString(i + 1, (String) parametros[i]);
                } else {
                    throw new Exception("Tipo do parametro " + i + " não identificado.");
                }
            }
        }
        return statement;
    }

    private void Desconectar() throws SQLException {
        this.conexao.close();
    }

    /**
     * Executa uma query no banco e retorna o numero de linhas afetadas
     *
     * @param query query a ser executada no banco com os parametros ?
     * @param parametros array de parametros na mesma ordem da query
     * @return int numero de linhas afetadas
     * @throws SQLException
     */
    public int RetornaAfetadas(String query, Object... parametros) throws SQLException, Exception {
        int retorno = -1;

        Boolean conectado = false;
        try {
            Conectar();
            conectado = true;
            PreparedStatement comando = PrepararComando(query, parametros);

            retorno = comando.executeUpdate();

            comando.close();
        } finally {
            if (conectado) {
                Desconectar();
            }
        }

        return retorno;
    }

    /**
     * Executa um query no banco e retorno um array de resultado
     *
     * @param query query a ser executada no banco com os parametros como ?
     * @param parametros array de objetos com os parametros na mesma ordem da
     * query
     * @return Arraylist de T
     * @throws SQLException Excessoes do sql
     * @throws Exception Excessoes internas
     */
    public ArrayList<T> Listar(String query, Object... parametros) throws SQLException, Exception {
        ArrayList<T> retorno = new ArrayList<T>();

        Boolean conectado = false;
        try {
            Conectar();
            conectado = true;
            PreparedStatement comando = PrepararComando(query, parametros);

            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                retorno.add(ConverterResultSet(resultado));
            }

            comando.close();
        } finally {
            if (conectado) {
                Desconectar();
            }
        }

        return retorno;
    }
    
    public int Inserir (String query, Object... parametros) throws SQLException, Exception {
    
        Boolean conectado = false;
        int flag = 0;
        
        try
        {
            Conectar();
            conectado = true;
            PreparedStatement comando = PrepararComando(query, parametros);
            comando.executeUpdate();
            flag = 1;
        }
        finally
        {
            if(conectado)
                Desconectar();
        }
        
        return flag;
    }

    /**
     * Executa um query no banco e retorno um objeto
     *
     * @param query query a ser executada no banco com os parametros como ?
     * @param parametros array de objetos com os parametros na mesma ordem da
     * query
     * @return Object um objeto
     * @throws SQLException Excessoes do sql
     * @throws Exception Excessoes internas
     */
    public Object RetornaUnicoValor(String query, Object... parametros) throws SQLException, Exception {
        Object retorno = null;

        Boolean conectado = false;
        try {
            Conectar();
            conectado = true;
            PreparedStatement comando = PrepararComando(query, parametros);

            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                retorno = resultado.getString(1);
            }
            comando.close();
        } finally {
            if (conectado) {
                Desconectar();
            }
        }

        return retorno;
    }

    public static String obfuscate(int n) {
        StringBuilder result = new StringBuilder();
        for (int i = n; i <= n+5; i++) {
            String reverse = Integer.toString(Integer.reverse(i << 1), 36);
            result.append(reverse);
        }
        return result.toString();
    }

    /**
     * Converte a posição atual do resultset para objeto da modelo
     *
     * @param resultSetAtual
     * @return modelo
     * @throws SQLException Excessoes do sql
     */
    public abstract T ConverterResultSet(ResultSet resultSetAtual) throws SQLException;
}
