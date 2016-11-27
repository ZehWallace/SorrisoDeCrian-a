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
package sorrisodecrianca;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import lib.DAOCrianca;
import lib.DAOVoluntario;
import models.ModelCrianca;
import models.ModelVoluntario;

public class frmVoluntario extends javax.swing.JFrame {

    /**
     * Creates new form frmVoluntario
     */
    public frmVoluntario() {
        initComponents();
        this.setDefaultCloseOperation(frmCrianca.DISPOSE_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel_InfoVoluntario = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jText_Nome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jText_RG = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jText_DataNascimento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox_Sexo = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jText_CPF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jText_Ocupacao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jText_Endereco = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jText_Telefone = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jText_Email = new javax.swing.JTextField();
        jBtn_CadastrarVoluntario = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jText_Observacoes = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jComboFormacao = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jComboSituacaoProfissional = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        JCheckSegunda = new javax.swing.JCheckBox();
        JCheckTerca = new javax.swing.JCheckBox();
        JCheckQuarta = new javax.swing.JCheckBox();
        JCheckQuinta = new javax.swing.JCheckBox();
        JCheckSexta = new javax.swing.JCheckBox();
        JCheckSabado = new javax.swing.JCheckBox();
        JCheckDomingo = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        jComboPeriodo = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jComboStatus = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Voluntários");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Cadastro de Voluntários");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(304, 304, 304)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel2.setText("Nome");

        jLabel3.setText("RG");

        jLabel4.setText("Data Nascimento");

        jLabel5.setText("Sexo");

        jComboBox_Sexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Feminino", "Masculino" }));

        jLabel6.setText("CPF");

        jLabel7.setText("Ocupação");

        jLabel8.setText("Endereço");

        jLabel9.setText("Telefone");

        jLabel10.setText("Email");

        jBtn_CadastrarVoluntario.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jBtn_CadastrarVoluntario.setText("Cadastrar");
        jBtn_CadastrarVoluntario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtn_CadastrarVoluntarioMouseClicked(evt);
            }
        });

        jLabel11.setText("Observações");

        jText_Observacoes.setColumns(20);
        jText_Observacoes.setRows(3);
        jScrollPane1.setViewportView(jText_Observacoes);

        jLabel12.setText("Formação");

        jComboFormacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1º Grau", "2º Grau", "Superior" }));

        jLabel13.setText("Situação Profissional");

        jComboSituacaoProfissional.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Empregado", "Autônomo", "Estudante", "Aposentado", "Do Lar" }));

        jLabel14.setText("Dias da semana");

        JCheckSegunda.setText("Segunda");

        JCheckTerca.setText("Terça");

        JCheckQuarta.setText("Quarta");

        JCheckQuinta.setText("Quinta");

        JCheckSexta.setText("Sexta");

        JCheckSabado.setText("Sábado");

        JCheckDomingo.setText("Domingo");

        jLabel15.setText("Período");

        jComboPeriodo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Manhã", "Tarde" }));

        jLabel16.setText("Status");

        jComboStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ativo", "Inativo" }));

        javax.swing.GroupLayout jPanel_InfoVoluntarioLayout = new javax.swing.GroupLayout(jPanel_InfoVoluntario);
        jPanel_InfoVoluntario.setLayout(jPanel_InfoVoluntarioLayout);
        jPanel_InfoVoluntarioLayout.setHorizontalGroup(
            jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_InfoVoluntarioLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_InfoVoluntarioLayout.createSequentialGroup()
                        .addGroup(jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_InfoVoluntarioLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jText_Ocupacao, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_InfoVoluntarioLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jText_Endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_InfoVoluntarioLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(jText_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(jLabel10)
                                .addGap(43, 43, 43)
                                .addGroup(jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel_InfoVoluntarioLayout.createSequentialGroup()
                                        .addComponent(JCheckQuarta)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(JCheckQuinta))
                                    .addComponent(jText_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel_InfoVoluntarioLayout.createSequentialGroup()
                                .addGroup(jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel15)
                                    .addGroup(jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel14)
                                        .addComponent(jLabel11)))
                                .addGroup(jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel_InfoVoluntarioLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel_InfoVoluntarioLayout.createSequentialGroup()
                                                .addGroup(jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(JCheckSegunda)
                                                    .addComponent(JCheckSabado))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(JCheckDomingo)
                                                    .addGroup(jPanel_InfoVoluntarioLayout.createSequentialGroup()
                                                        .addComponent(JCheckTerca)
                                                        .addGap(268, 268, 268)
                                                        .addComponent(JCheckSexta))))))
                                    .addGroup(jPanel_InfoVoluntarioLayout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jComboPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(52, 52, 52)
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 96, Short.MAX_VALUE))
                    .addGroup(jPanel_InfoVoluntarioLayout.createSequentialGroup()
                        .addGroup(jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel_InfoVoluntarioLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(46, 46, 46)
                                .addComponent(jText_RG, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel_InfoVoluntarioLayout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboFormacao, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel13)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboSituacaoProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel_InfoVoluntarioLayout.createSequentialGroup()
                                        .addGap(61, 61, 61)
                                        .addComponent(jLabel4)
                                        .addGap(36, 36, 36)
                                        .addComponent(jText_DataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jText_CPF, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel_InfoVoluntarioLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(26, 26, 26)
                                .addComponent(jText_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(jPanel_InfoVoluntarioLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(26, 26, 26)
                                        .addComponent(jComboBox_Sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel_InfoVoluntarioLayout.createSequentialGroup()
                .addGap(326, 326, 326)
                .addComponent(jBtn_CadastrarVoluntario, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel_InfoVoluntarioLayout.setVerticalGroup(
            jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_InfoVoluntarioLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jText_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox_Sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jText_RG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jText_DataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jText_CPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jText_Ocupacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jComboFormacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jComboSituacaoProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jText_Endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jText_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jText_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(JCheckSegunda)
                    .addComponent(JCheckTerca)
                    .addComponent(JCheckQuarta)
                    .addComponent(JCheckQuinta)
                    .addComponent(JCheckSexta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCheckSabado)
                    .addComponent(JCheckDomingo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jComboPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jComboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jBtn_CadastrarVoluntario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel_InfoVoluntario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel_InfoVoluntario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtn_CadastrarVoluntarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtn_CadastrarVoluntarioMouseClicked
        // TODO add your handling code here:
        /* Testes de consistencia */
        
        if(jText_Nome.getText().isEmpty())
            JOptionPane.showMessageDialog(jPanel_InfoVoluntario, "Digite o nome do voluntário.", "Erro", JOptionPane.ERROR_MESSAGE);
        else
        if(jText_RG.getText().isEmpty())
            JOptionPane.showMessageDialog(jPanel_InfoVoluntario, "Digite o RG do voluntário.", "Erro", JOptionPane.ERROR_MESSAGE);
        else
        if(jText_DataNascimento.getText().isEmpty())
            JOptionPane.showMessageDialog(jPanel_InfoVoluntario, "Digite a data de nascimento do voluntário.", "Erro", JOptionPane.ERROR_MESSAGE);
        else
        if(jText_Endereco.getText().isEmpty())
            JOptionPane.showMessageDialog(jPanel_InfoVoluntario, "Digite o endereco do voluntário.", "Erro", JOptionPane.ERROR_MESSAGE);
        else
        if(jText_Ocupacao.getText().isEmpty())
            JOptionPane.showMessageDialog(jPanel_InfoVoluntario, "Digite a ocupação do voluntário", "Erro", JOptionPane.ERROR_MESSAGE);
        else
        if(jText_Telefone.getText().isEmpty())
            JOptionPane.showMessageDialog(jPanel_InfoVoluntario, "Digite o telefone para contato do voluntário.", "Erro", JOptionPane.ERROR_MESSAGE);
        else
        if(jText_Email.getText().isEmpty())
            JOptionPane.showMessageDialog(jPanel_InfoVoluntario, "Digite o email para contato do voluntário.", "Erro", JOptionPane.ERROR_MESSAGE);
       
        /* Fim dos testes de consistencia */
        
        
        
        else
        {
            /* Tratamento dos dias da semana */
            String dias_semana = "";
            
            if(JCheckSegunda.isSelected())
            {
                dias_semana += "Segunda, ";
            }
            
            if(JCheckTerca.isSelected())
            {
                dias_semana += "Terça, ";
            }
            
            if(JCheckQuarta.isSelected())
            {
                dias_semana += "Quarta, ";
            }
            
            if(JCheckQuinta.isSelected())
            {
                dias_semana += "Quinta, ";
            }
            
            if(JCheckSexta.isSelected())
            {
                dias_semana += "Sexta, ";
            }
            
            if(JCheckSabado.isSelected())
            {
                dias_semana += "Sábado, ";
            }
            
            if(JCheckDomingo.isSelected())
            {
                dias_semana += "Domingo";
            }
            
            /* Remove a última virgula */
            if(dias_semana != null && dias_semana.charAt(dias_semana.length()-1) == ',')
            {
                dias_semana = dias_semana.substring(0, dias_semana.length()-2);
            }
            
            /* Atribuição dos JTextFields para os campos do ModelCrianca */
            ModelVoluntario modelVoluntario = new ModelVoluntario();

            modelVoluntario.setNome(jText_Nome.getText());
            modelVoluntario.setRg(jText_RG.getText());
            modelVoluntario.setCpf(jText_CPF.getText());
            modelVoluntario.setSexo(jComboBox_Sexo.getSelectedItem().toString());
            modelVoluntario.setEndereco(jText_Endereco.getText());
            modelVoluntario.setOcupacao(jText_Ocupacao.getText());
            modelVoluntario.setEmail(jText_Email.getText());
            modelVoluntario.setTel_contato(jText_Telefone.getText());
            modelVoluntario.setObservacao(jText_Observacoes.getText());
            modelVoluntario.setFormacao(jComboFormacao.getSelectedItem().toString());
            modelVoluntario.setSituacaoProfissional(jComboSituacaoProfissional.getSelectedItem().toString());
            modelVoluntario.setPeriodo(jComboPeriodo.getSelectedItem().toString());
            modelVoluntario.setDiasSemana(dias_semana);
            modelVoluntario.setStatus(jComboStatus.getSelectedItem().toString());

            /* Tratamento da data */
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = null;

            String dataNascimento = jText_DataNascimento.getText();

            dataNascimento = dataNascimento.replace("/", "-");
            //System.out.println("Data de nascimento: " + dataNascimento);

            String temp[] = dataNascimento.split("-");
            //System.out.println("Temp: " + temp[0] + "/" + temp[1] + "/" + temp[2]);

            String dia, mes, ano, dataReordenada = "";
            dia = temp[0];
            mes = temp[1];
            ano = temp[2];

            dataReordenada = dataReordenada + ano + "-";
            dataReordenada = dataReordenada + mes + "-";
            dataReordenada = dataReordenada + dia;

            //System.out.println("Data reordenada: " + dataReordenada);

            java.sql.Date dataConvertida = null;

            try
            {
                date = formatter.parse(dataReordenada);
                dataConvertida = new java.sql.Date(date.getTime());
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

            modelVoluntario.setData_nascimento(dataConvertida);
        
            /* Inserção */

            DAOVoluntario daoVoluntario = new DAOVoluntario();
            try
            {
                daoVoluntario.insereVoluntario(modelVoluntario);
                JOptionPane.showMessageDialog(jPanel_InfoVoluntario, "Voluntário inserido no sistema com sucesso!", "Cadastro de Voluntários", JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);
            }
            catch(SQLException sql_e)
            {
                JOptionPane.showMessageDialog(jPanel_InfoVoluntario, sql_e.getMessage(), "SQL Exception", JOptionPane.OK_OPTION);
                sql_e.printStackTrace();
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(jPanel_InfoVoluntario, ex.getMessage(), "Exception", JOptionPane.OK_OPTION);
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jBtn_CadastrarVoluntarioMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox JCheckDomingo;
    private javax.swing.JCheckBox JCheckQuarta;
    private javax.swing.JCheckBox JCheckQuinta;
    private javax.swing.JCheckBox JCheckSabado;
    private javax.swing.JCheckBox JCheckSegunda;
    private javax.swing.JCheckBox JCheckSexta;
    private javax.swing.JCheckBox JCheckTerca;
    private javax.swing.JButton jBtn_CadastrarVoluntario;
    private javax.swing.JComboBox jComboBox_Sexo;
    private javax.swing.JComboBox jComboFormacao;
    private javax.swing.JComboBox jComboPeriodo;
    private javax.swing.JComboBox jComboSituacaoProfissional;
    private javax.swing.JComboBox jComboStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_InfoVoluntario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jText_CPF;
    private javax.swing.JTextField jText_DataNascimento;
    private javax.swing.JTextField jText_Email;
    private javax.swing.JTextField jText_Endereco;
    private javax.swing.JTextField jText_Nome;
    private javax.swing.JTextArea jText_Observacoes;
    private javax.swing.JTextField jText_Ocupacao;
    private javax.swing.JTextField jText_RG;
    private javax.swing.JTextField jText_Telefone;
    // End of variables declaration//GEN-END:variables
}
