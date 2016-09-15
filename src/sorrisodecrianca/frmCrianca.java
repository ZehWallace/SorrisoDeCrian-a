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
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import lib.DAOCrianca;
import models.ModelCrianca;

public class frmCrianca extends javax.swing.JFrame {

    /**
     * Creates new form frmCrianca
     */
    public frmCrianca() throws Exception {
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
        jPanel_InfoCrianca = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jText_Nome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jText_RG = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox_Sexo = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jText_Endereco = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jText_NomeResponsavel = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jText_Telefone = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jText_Observacoes = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jComboBox_SituacaoCrianca = new javax.swing.JComboBox();
        jBtn_CadastrarCrianca = new javax.swing.JButton();
        jText_DataNascimento = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Crianças");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("Cadastro de Crianças");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel2.setText("Nome Completo");

        jText_Nome.setToolTipText("");

        jLabel3.setText("RG");

        jLabel4.setText("Data de Nascimento");

        jLabel5.setText("Sexo");

        jComboBox_Sexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Feminino", "Masculino" }));
        jComboBox_Sexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_SexoActionPerformed(evt);
            }
        });

        jLabel6.setText("Endereço");

        jText_Endereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_EnderecoActionPerformed(evt);
            }
        });

        jLabel7.setText("Nome do Responsável");

        jText_NomeResponsavel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_NomeResponsavelActionPerformed(evt);
            }
        });

        jLabel8.setText("Telefone para Contato");

        jLabel9.setText("Observações");

        jText_Observacoes.setColumns(20);
        jText_Observacoes.setRows(5);
        jScrollPane1.setViewportView(jText_Observacoes);

        jLabel10.setText("Status da Criança");

        jComboBox_SituacaoCrianca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ativo", "Inativo" }));

        jBtn_CadastrarCrianca.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jBtn_CadastrarCrianca.setText("Cadastrar");
        jBtn_CadastrarCrianca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtn_CadastrarCriancaMouseClicked(evt);
            }
        });
        jBtn_CadastrarCrianca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_CadastrarCriancaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_InfoCriancaLayout = new javax.swing.GroupLayout(jPanel_InfoCrianca);
        jPanel_InfoCrianca.setLayout(jPanel_InfoCriancaLayout);
        jPanel_InfoCriancaLayout.setHorizontalGroup(
            jPanel_InfoCriancaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_InfoCriancaLayout.createSequentialGroup()
                .addGroup(jPanel_InfoCriancaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_InfoCriancaLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel_InfoCriancaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10))
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_InfoCriancaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel_InfoCriancaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel_InfoCriancaLayout.createSequentialGroup()
                        .addComponent(jText_RG, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jText_DataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox_Sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jText_Nome)
                    .addComponent(jText_Endereco)
                    .addComponent(jText_NomeResponsavel)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_InfoCriancaLayout.createSequentialGroup()
                        .addComponent(jComboBox_SituacaoCrianca, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jText_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_InfoCriancaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jBtn_CadastrarCrianca, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(310, 310, 310))
        );
        jPanel_InfoCriancaLayout.setVerticalGroup(
            jPanel_InfoCriancaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_InfoCriancaLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel_InfoCriancaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jText_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_InfoCriancaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jText_RG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox_Sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jText_DataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel_InfoCriancaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jText_Endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel_InfoCriancaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jText_NomeResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel_InfoCriancaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jText_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jComboBox_SituacaoCrianca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel_InfoCriancaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtn_CadastrarCrianca, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel_InfoCrianca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_InfoCrianca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_SexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_SexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_SexoActionPerformed

    private void jText_NomeResponsavelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_NomeResponsavelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jText_NomeResponsavelActionPerformed

    private void jText_EnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_EnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jText_EnderecoActionPerformed

    private void jBtn_CadastrarCriancaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_CadastrarCriancaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtn_CadastrarCriancaActionPerformed

    private void jBtn_CadastrarCriancaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtn_CadastrarCriancaMouseClicked
        // TODO add your handling code here:
        
        /* Testes de consistencia */
        
        if(jText_Nome.getText().isEmpty())
            JOptionPane.showMessageDialog(jPanel_InfoCrianca, "Digite o nome da criança.", "Erro", JOptionPane.ERROR_MESSAGE);
        else
        if(jText_RG.getText().isEmpty())
            JOptionPane.showMessageDialog(jPanel_InfoCrianca, "Digite o RG da criança.", "Erro", JOptionPane.ERROR_MESSAGE);
        else
        if(jText_DataNascimento.getText().isEmpty())
            JOptionPane.showMessageDialog(jPanel_InfoCrianca, "Digite a data de nascimento da criança.", "Erro", JOptionPane.ERROR_MESSAGE);
        else
        if(jText_Endereco.getText().isEmpty())
            JOptionPane.showMessageDialog(jPanel_InfoCrianca, "Digite o endereco da criança.", "Erro", JOptionPane.ERROR_MESSAGE);
       else
        if(jText_NomeResponsavel.getText().isEmpty())
            JOptionPane.showMessageDialog(jPanel_InfoCrianca, "Digite o nome do responsável pela criança.", "Erro", JOptionPane.ERROR_MESSAGE);
        else
        if(jText_Telefone.getText().isEmpty())
            JOptionPane.showMessageDialog(jPanel_InfoCrianca, "Digite o telefone para contato da criança.", "Erro", JOptionPane.ERROR_MESSAGE);
       
        /* Fim dos testes de consistencia */
        else
        {
            /* Atribuição dos JTextFields para os campos do ModelCrianca */
            ModelCrianca modelCrianca = new ModelCrianca();

            modelCrianca.setNome(jText_Nome.getText());
            modelCrianca.setRg(jText_RG.getText());

            modelCrianca.setSexo(jComboBox_Sexo.getSelectedItem().toString());
            modelCrianca.setEndereco(jText_Endereco.getText());
            modelCrianca.setNome_responsavel(jText_NomeResponsavel.getText());
            modelCrianca.setStatus(jComboBox_SituacaoCrianca.getSelectedItem().toString());
            modelCrianca.setTel_contato(jText_Telefone.getText());
            modelCrianca.setObservacao(jText_Observacoes.getText());


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

            modelCrianca.setData_nascimento(dataConvertida);

            /* Inserção */

            DAOCrianca daoCrianca = new DAOCrianca();
            try
            {
                daoCrianca.insereCrianca(modelCrianca);
                JOptionPane.showMessageDialog(jPanel_InfoCrianca, "Criança inserida no sistema com sucesso!", "Cadastro de Crianças", JOptionPane.OK_OPTION);
            }
            catch(SQLException sql_e)
            {
                JOptionPane.showMessageDialog(jPanel_InfoCrianca, sql_e.getMessage(), "SQL Exception", JOptionPane.OK_OPTION);
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(jPanel_InfoCrianca, ex.getMessage(), "Exception", JOptionPane.OK_OPTION);
            }

            
        }
    }//GEN-LAST:event_jBtn_CadastrarCriancaMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtn_CadastrarCrianca;
    private javax.swing.JComboBox jComboBox_Sexo;
    private javax.swing.JComboBox jComboBox_SituacaoCrianca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_InfoCrianca;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jText_DataNascimento;
    private javax.swing.JTextField jText_Endereco;
    private javax.swing.JTextField jText_Nome;
    private javax.swing.JTextField jText_NomeResponsavel;
    private javax.swing.JTextArea jText_Observacoes;
    private javax.swing.JTextField jText_RG;
    private javax.swing.JTextField jText_Telefone;
    // End of variables declaration//GEN-END:variables
}
