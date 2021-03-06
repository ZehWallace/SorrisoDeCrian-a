/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorrisodecrianca;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lib.DAOCrianca;
import lib.DAOInteressados;
import lib.DAOPresenca;
import lib.DAOVoluntario;
import models.ModelCrianca;
import models.ModelInteressado;
import models.ModelPresenca;
import models.ModelVoluntario;
import org.joda.time.DateTime;

/**
 *
 * @author Yasmin
 */
public final class Consulta extends javax.swing.JFrame {

    /**
     * Creates new form Consulta
     */
    
    public DefaultTableModel modelo1, modelo2, modelo3, modelo4;
    public DAOCrianca daoC;
    public DAOVoluntario daoV;
    public DAOInteressados daoI;
    public DAOPresenca daoP;
    
    public Consulta() {
        initComponents();
        modelo1 = (DefaultTableModel) tabelaCriancas.getModel();
        modelo2 = (DefaultTableModel) tabelaVoluntarios.getModel();
        modelo3 = (DefaultTableModel) tabelaInteressados.getModel();
        modelo4 = (DefaultTableModel) tabelaPresenca.getModel();
        daoC = new DAOCrianca();
        daoV = new DAOVoluntario();
        daoI = new DAOInteressados();
        popularTabelaCrianca();
        popularTabelaVoluntario();
        popularTabelaInteressados();
        try {
            popularTabelaPresenca();
        } catch (Exception ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logo.jpg")));
    }

    public void popularTabelaCrianca()
    {
        ArrayList<ModelCrianca> criancas = null;
        
        try
        {
            criancas = daoC.getTodasCrianças();
        }
        catch(SQLException sql_e)
        {
            sql_e.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        System.out.println("Linhas da tabela Crianças: " + modelo1.getRowCount());
        if(modelo1.getRowCount() > 0)
        {
            modelo1.setRowCount(0);
        }
     
        if(criancas != null)
        {
            for(int i = 0; i < criancas.size(); i++)
            {
                ModelCrianca c = criancas.get(i);
                Object[] obj = {c.getNome(), c.getRg(),c.getData_nascimento(), c.getNome_responsavel(), c.getEndereco()};
                modelo1.addRow(obj);
            }
        }
    }
    
    public void popularTabelaVoluntario()
    {
        ArrayList<ModelVoluntario> voluntarios = null;
        
        try
        {
            daoV = new DAOVoluntario();
            voluntarios = daoV.getTodosVoluntarios();
        }
        catch(SQLException sql_e)
        {
            sql_e.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        if(modelo2.getRowCount() > 0)
        {
            modelo2.setRowCount(0);
        }
          
        if(voluntarios != null)
        {
            for(int i = 0; i < voluntarios.size(); i++)
            {
                ModelVoluntario v = voluntarios.get(i);
                Object[] obj = {v.getNome(),v.getOcupacao(), v.getRg(), v.getTel_contato()};
                modelo2.addRow(obj);
            }
        }
    }
    
    public void pesquisarPresenca(String nome) throws Exception
    {
        ArrayList<ModelPresenca> presenca = null;
        
        try
        {
            daoC = new DAOCrianca();
            ArrayList<ModelCrianca> c = daoC.getPesquisaCrianca(nome);
            
            if(c == null)
                 return;
            
            daoP = new DAOPresenca();
            presenca = daoP.getPesquisaCriancaPresenca(c.get(0).getId(), 15);
        }
        catch(SQLException sql_e)
        {
            sql_e.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        if(modelo4.getRowCount() > 0)
        {
            modelo4.setRowCount(0);
        }
          
        if(presenca != null)
        {
            for(int i = 0; i < presenca.size(); i++)
            {
                daoC = new DAOCrianca();
                ModelPresenca p = presenca.get(i);
                ModelCrianca cr = daoC.getCriancabyId(p.getCrianca());
                
                if(cr != null)
                {
                    DateTime date_temp;
                    java.text.SimpleDateFormat data_format = new java.text.SimpleDateFormat("dd/MM/yyyy");
                    Object[] obj = {data_format.format(p.getData_presenca()),cr.getNome(),cr.getRg(),p.getStatus()};
                    modelo4.addRow(obj);
                }
            }
        }
    }
    
    public void popularTabelaPresenca() throws Exception
    {
        ArrayList<ModelPresenca> presenca = null;
        
        try
        {
            daoP = new DAOPresenca();
            presenca = daoP.getTodasPesquisas();
        }
        catch(SQLException sql_e)
        {
            sql_e.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        if(modelo4.getRowCount() > 0)
        {
            modelo4.setRowCount(0);
        }
          
        if(presenca != null)
        {
            for(int i = 0; i < presenca.size(); i++)
            {
                DAOCrianca daoC = new DAOCrianca();
                ModelPresenca p = presenca.get(i);
                ModelCrianca c = daoC.getCriancabyId(p.getCrianca());
                
                if(c != null)
                {
                    
                    DateTime date_temp;
                    java.text.SimpleDateFormat data_format = new java.text.SimpleDateFormat("dd/MM/yyyy");
                            
                    Object[] obj = {data_format.format(p.getData_presenca()),c.getNome(),c.getRg(),p.getStatus()};
                    modelo4.addRow(obj);
                }
            }
        }
    }
    
    public void popularTabelaInteressados()
    {
        ArrayList<ModelInteressado> interessados = null;
        
        try
        {
            daoI = new DAOInteressados();
            interessados = daoI.getTodosInteressados();
        }
        catch(SQLException sql_e)
        {
            sql_e.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        if(modelo3.getRowCount() > 0)
        {
            modelo3.setRowCount(0);
        }
          
        if(interessados != null)
        {
            for(int i = 0; i < interessados.size(); i++)
            {
                ModelInteressado inter = interessados.get(i);
                Object[] obj = {inter.getData_interesse(),inter.getNomeCrianca(),inter.getDataNascimento(), inter.getNomeResponsavel(), inter.getTelefone()};
                modelo3.addRow(obj);
            }
        }
    }
    
    public void pesquisarCrianca(String nome)
    {
        ArrayList<ModelCrianca> resultado = null;
        
        try
        {
            resultado = daoC.getPesquisaCrianca(nome);
        }
        catch(SQLException sql_e)
        {
            sql_e.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        modelo1.setRowCount(0);
        
        if(resultado != null)
        {
            for(int j = 0; j < resultado.size(); j++)
            {
                ModelCrianca c = resultado.get(j);
                Object[] obj = {c.getNome(), c.getRg(),c.getData_nascimento(), c.getNome_responsavel(), c.getEndereco()};
                modelo1.addRow(obj);
            }
        }
        
    }
    
    public void pesquisarVoluntario(String nome)
    {
        ArrayList<ModelVoluntario> resultado = null;
        
        try
        {
            resultado = daoV.getPesquisaVoluntario(nome);
        }
        catch(SQLException sql_e)
        {
            sql_e.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        modelo2.setRowCount(0);
        
        if(resultado != null)
        {
            for(int j = 0; j < resultado.size(); j++)
            {
                ModelVoluntario v = resultado.get(j);
                Object[] obj = {v.getNome(),v.getOcupacao(), v.getRg(), v.getTel_contato()};
                modelo2.addRow(obj);
            }
        }   
    }
    
    public void pesquisarInteressado(String nome_crianca)
    {
        ArrayList<ModelInteressado> interessados = null;
        
        try
        {
            daoI = new DAOInteressados();
            interessados = daoI.getInteressadoByNomeCrianca(nome_crianca);
        }
        catch(SQLException sql_e)
        {
            sql_e.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        if(modelo3.getRowCount() > 0)
        {
            modelo3.setRowCount(0);
        }
          
        if(interessados != null)
        {
            for(int i = 0; i < interessados.size(); i++)
            {
                ModelInteressado inter = interessados.get(i);
                Object[] obj = {inter.getData_interesse(),inter.getNomeCrianca(),inter.getDataNascimento(), inter.getNomeResponsavel(), inter.getTelefone()};
                modelo3.addRow(obj);
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        JPanel_ConsultaCrianca = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_NomeCrianca = new javax.swing.JTextField();
        btn_PesquisarCrianca = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCriancas = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        btn_MostrarTodasCriancas = new javax.swing.JButton();
        JPanel_ConsultaVoluntario = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_NomeVoluntario = new javax.swing.JTextField();
        btn_PesquisarVoluntario = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaVoluntarios = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btn_MostrarTodos = new javax.swing.JButton();
        JPanel_Interessados = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_NomeInteressado = new javax.swing.JTextField();
        btn_PesquisarInteressado = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaInteressados = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        btn_MostrarTodosInteressados = new javax.swing.JButton();
        JPanel_ConsultaPresenca = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_NomeCriancaPresenca = new javax.swing.JTextField();
        btn_PesquisarCriancaPresenca = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelaPresenca = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        btn_MostrarTodasCriancasPresenca = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultas");

        JPanel_ConsultaCrianca.setLayout(new java.awt.BorderLayout());

        jLabel2.setText("Nome");
        jPanel4.add(jLabel2);

        txt_NomeCrianca.setColumns(30);
        jPanel4.add(txt_NomeCrianca);

        btn_PesquisarCrianca.setText("Pesquisar");
        btn_PesquisarCrianca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_PesquisarCriancaMouseClicked(evt);
            }
        });
        jPanel4.add(btn_PesquisarCrianca);

        JPanel_ConsultaCrianca.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        tabelaCriancas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "RG", "Nascimento", "Responsável", "Endereço"
            }
        ));
        jScrollPane1.setViewportView(tabelaCriancas);
        if (tabelaCriancas.getColumnModel().getColumnCount() > 0) {
            tabelaCriancas.getColumnModel().getColumn(4).setHeaderValue("Endereço");
        }

        jPanel5.add(jScrollPane1);

        JPanel_ConsultaCrianca.add(jPanel5, java.awt.BorderLayout.CENTER);

        btn_MostrarTodasCriancas.setText("Mostrar Todos");
        btn_MostrarTodasCriancas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_MostrarTodasCriancasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_MostrarTodasCriancas, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(530, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_MostrarTodasCriancas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JPanel_ConsultaCrianca.add(jPanel6, java.awt.BorderLayout.PAGE_END);

        jTabbedPane1.addTab("Crianças", JPanel_ConsultaCrianca);

        JPanel_ConsultaVoluntario.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Nome");
        jPanel1.add(jLabel1);

        txt_NomeVoluntario.setColumns(30);
        txt_NomeVoluntario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NomeVoluntarioActionPerformed(evt);
            }
        });
        jPanel1.add(txt_NomeVoluntario);

        btn_PesquisarVoluntario.setText("Pesquisar");
        btn_PesquisarVoluntario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_PesquisarVoluntarioMouseClicked(evt);
            }
        });
        jPanel1.add(btn_PesquisarVoluntario);

        JPanel_ConsultaVoluntario.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        tabelaVoluntarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Ocupação", "RG", "Telefone"
            }
        ));
        jScrollPane2.setViewportView(tabelaVoluntarios);

        jPanel2.add(jScrollPane2);

        JPanel_ConsultaVoluntario.add(jPanel2, java.awt.BorderLayout.CENTER);

        btn_MostrarTodos.setText("Mostrar Todos");
        btn_MostrarTodos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_MostrarTodosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_MostrarTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(530, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_MostrarTodos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JPanel_ConsultaVoluntario.add(jPanel3, java.awt.BorderLayout.SOUTH);

        jTabbedPane1.addTab("Voluntários", JPanel_ConsultaVoluntario);

        JPanel_Interessados.setLayout(new java.awt.BorderLayout());

        jLabel3.setText("Nome");
        jPanel7.add(jLabel3);

        txt_NomeInteressado.setColumns(30);
        jPanel7.add(txt_NomeInteressado);

        btn_PesquisarInteressado.setText("Pesquisar");
        btn_PesquisarInteressado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_PesquisarInteressadoMouseClicked(evt);
            }
        });
        jPanel7.add(btn_PesquisarInteressado);

        JPanel_Interessados.add(jPanel7, java.awt.BorderLayout.PAGE_START);

        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.LINE_AXIS));

        tabelaInteressados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data de interesse", "Nome", "Nascimento", "Responsável", "Telefone"
            }
        ));
        jScrollPane3.setViewportView(tabelaInteressados);

        jPanel8.add(jScrollPane3);

        JPanel_Interessados.add(jPanel8, java.awt.BorderLayout.CENTER);

        btn_MostrarTodosInteressados.setText("Mostrar Todos");
        btn_MostrarTodosInteressados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_MostrarTodosInteressadosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_MostrarTodosInteressados, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(530, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_MostrarTodosInteressados)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JPanel_Interessados.add(jPanel9, java.awt.BorderLayout.SOUTH);

        jTabbedPane1.addTab("Interessados", JPanel_Interessados);

        JPanel_ConsultaPresenca.setLayout(new java.awt.BorderLayout());

        jLabel4.setText("Nome");
        jPanel10.add(jLabel4);

        txt_NomeCriancaPresenca.setColumns(30);
        txt_NomeCriancaPresenca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NomeCriancaPresencaActionPerformed(evt);
            }
        });
        jPanel10.add(txt_NomeCriancaPresenca);

        btn_PesquisarCriancaPresenca.setText("Pesquisar");
        btn_PesquisarCriancaPresenca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_PesquisarCriancaPresencaMouseClicked(evt);
            }
        });
        btn_PesquisarCriancaPresenca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PesquisarCriancaPresencaActionPerformed(evt);
            }
        });
        jPanel10.add(btn_PesquisarCriancaPresenca);

        JPanel_ConsultaPresenca.add(jPanel10, java.awt.BorderLayout.PAGE_START);

        jPanel11.setLayout(new javax.swing.BoxLayout(jPanel11, javax.swing.BoxLayout.LINE_AXIS));

        tabelaPresenca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Nome", "RG", "Status"
            }
        ));
        jScrollPane4.setViewportView(tabelaPresenca);

        jPanel11.add(jScrollPane4);

        JPanel_ConsultaPresenca.add(jPanel11, java.awt.BorderLayout.CENTER);

        btn_MostrarTodasCriancasPresenca.setText("Mostrar Todos");
        btn_MostrarTodasCriancasPresenca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_MostrarTodasCriancasPresencaMouseClicked(evt);
            }
        });
        btn_MostrarTodasCriancasPresenca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MostrarTodasCriancasPresencaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_MostrarTodasCriancasPresenca, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(542, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_MostrarTodasCriancasPresenca)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JPanel_ConsultaPresenca.add(jPanel12, java.awt.BorderLayout.PAGE_END);

        jTabbedPane1.addTab("Presenças", JPanel_ConsultaPresenca);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_PesquisarCriancaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_PesquisarCriancaMouseClicked
        // TODO add your handling code here:
        String nomeCrianca = txt_NomeCrianca.getText();
        
        if(nomeCrianca.isEmpty())
        {
            JOptionPane.showMessageDialog(JPanel_ConsultaCrianca, "Digite o nome da criança.", "Pesquisa de Criança", JOptionPane.ERROR_MESSAGE);
        }
        
        pesquisarCrianca(nomeCrianca);
    }//GEN-LAST:event_btn_PesquisarCriancaMouseClicked

    private void txt_NomeVoluntarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NomeVoluntarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NomeVoluntarioActionPerformed

    private void btn_PesquisarVoluntarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_PesquisarVoluntarioMouseClicked
        // TODO add your handling code here:
        String nomeVoluntario = txt_NomeVoluntario.getText();
        
        if(nomeVoluntario.isEmpty())
        {
            JOptionPane.showMessageDialog(JPanel_ConsultaCrianca, "Digite o nome da criança.", "Pesquisa de Criança", JOptionPane.ERROR_MESSAGE);
        }
        
        pesquisarVoluntario(nomeVoluntario);
        
    }//GEN-LAST:event_btn_PesquisarVoluntarioMouseClicked

    private void btn_MostrarTodosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_MostrarTodosMouseClicked
        // TODO add your handling code here:
        popularTabelaVoluntario();
    }//GEN-LAST:event_btn_MostrarTodosMouseClicked

    private void btn_MostrarTodasCriancasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_MostrarTodasCriancasMouseClicked
        // TODO add your handling code here:
        popularTabelaCrianca();
    }//GEN-LAST:event_btn_MostrarTodasCriancasMouseClicked

    private void btn_PesquisarInteressadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_PesquisarInteressadoMouseClicked
        // TODO add your handling code here:
        pesquisarInteressado(txt_NomeInteressado.getText());
    }//GEN-LAST:event_btn_PesquisarInteressadoMouseClicked

    private void btn_MostrarTodosInteressadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_MostrarTodosInteressadosMouseClicked
        // TODO add your handling code here:
        popularTabelaInteressados();
    }//GEN-LAST:event_btn_MostrarTodosInteressadosMouseClicked

    private void btn_PesquisarCriancaPresencaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_PesquisarCriancaPresencaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_PesquisarCriancaPresencaMouseClicked

    private void btn_MostrarTodasCriancasPresencaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_MostrarTodasCriancasPresencaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_MostrarTodasCriancasPresencaMouseClicked

    private void txt_NomeCriancaPresencaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NomeCriancaPresencaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NomeCriancaPresencaActionPerformed

    private void btn_MostrarTodasCriancasPresencaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MostrarTodasCriancasPresencaActionPerformed
        try {
            // TODO add your handling code here:
            popularTabelaPresenca();
        } catch (Exception ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_MostrarTodasCriancasPresencaActionPerformed

    private void btn_PesquisarCriancaPresencaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PesquisarCriancaPresencaActionPerformed
        try {
            // TODO add your handling code here:
            pesquisarPresenca(txt_NomeCriancaPresenca.getText());
        } catch (Exception ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_PesquisarCriancaPresencaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanel_ConsultaCrianca;
    private javax.swing.JPanel JPanel_ConsultaPresenca;
    private javax.swing.JPanel JPanel_ConsultaVoluntario;
    private javax.swing.JPanel JPanel_Interessados;
    private javax.swing.JButton btn_MostrarTodasCriancas;
    private javax.swing.JButton btn_MostrarTodasCriancasPresenca;
    private javax.swing.JButton btn_MostrarTodos;
    private javax.swing.JButton btn_MostrarTodosInteressados;
    private javax.swing.JButton btn_PesquisarCrianca;
    private javax.swing.JButton btn_PesquisarCriancaPresenca;
    private javax.swing.JButton btn_PesquisarInteressado;
    private javax.swing.JButton btn_PesquisarVoluntario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabelaCriancas;
    private javax.swing.JTable tabelaInteressados;
    private javax.swing.JTable tabelaPresenca;
    private javax.swing.JTable tabelaVoluntarios;
    private javax.swing.JTextField txt_NomeCrianca;
    private javax.swing.JTextField txt_NomeCriancaPresenca;
    private javax.swing.JTextField txt_NomeInteressado;
    private javax.swing.JTextField txt_NomeVoluntario;
    // End of variables declaration//GEN-END:variables
}
