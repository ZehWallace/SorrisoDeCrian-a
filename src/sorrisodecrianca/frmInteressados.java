/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorrisodecrianca;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lib.DAOInteressados;
import models.ModelInteressado;

/**
 *
 * @author Yasmin
 */
public class frmInteressados extends javax.swing.JFrame {

    /**
     * Creates new form frmInteressados
     */
    public frmInteressados() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanelTituloInteressados = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JPanelInfoInteressados = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDataNascimento = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNomeResponsavel = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        JComboStatus = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservacoes = new javax.swing.JTextArea();
        JPanelBotoesInteressados = new javax.swing.JPanel();
        btnCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Crianças Interessadas");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setText("Crianças Interessadas");

        javax.swing.GroupLayout JPanelTituloInteressadosLayout = new javax.swing.GroupLayout(JPanelTituloInteressados);
        JPanelTituloInteressados.setLayout(JPanelTituloInteressadosLayout);
        JPanelTituloInteressadosLayout.setHorizontalGroup(
            JPanelTituloInteressadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelTituloInteressadosLayout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(jLabel1)
                .addContainerGap(189, Short.MAX_VALUE))
        );
        JPanelTituloInteressadosLayout.setVerticalGroup(
            JPanelTituloInteressadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelTituloInteressadosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        getContentPane().add(JPanelTituloInteressados, java.awt.BorderLayout.PAGE_START);

        jLabel2.setText("Nome");

        txtNome.setColumns(30);

        jLabel3.setText("Data de Nascimento");

        txtDataNascimento.setColumns(10);

        jLabel4.setText("Endereço");

        jLabel5.setText("Nome do Responsável");

        txtNomeResponsavel.setToolTipText("");

        jLabel6.setText("Status");

        JComboStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ativo", "Inativo" }));

        jLabel7.setText("Telefone");

        jLabel8.setText("Observações");

        txtObservacoes.setColumns(20);
        txtObservacoes.setRows(5);
        jScrollPane1.setViewportView(txtObservacoes);

        btnCadastrar.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPanelBotoesInteressadosLayout = new javax.swing.GroupLayout(JPanelBotoesInteressados);
        JPanelBotoesInteressados.setLayout(JPanelBotoesInteressadosLayout);
        JPanelBotoesInteressadosLayout.setHorizontalGroup(
            JPanelBotoesInteressadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelBotoesInteressadosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCadastrar)
                .addGap(241, 241, 241))
        );
        JPanelBotoesInteressadosLayout.setVerticalGroup(
            JPanelBotoesInteressadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelBotoesInteressadosLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JPanelInfoInteressadosLayout = new javax.swing.GroupLayout(JPanelInfoInteressados);
        JPanelInfoInteressados.setLayout(JPanelInfoInteressadosLayout);
        JPanelInfoInteressadosLayout.setHorizontalGroup(
            JPanelInfoInteressadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelInfoInteressadosLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(JPanelInfoInteressadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addGroup(JPanelInfoInteressadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(JPanelInfoInteressadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JComboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEndereco)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(txtNomeResponsavel)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE))
                .addContainerGap(74, Short.MAX_VALUE))
            .addGroup(JPanelInfoInteressadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPanelBotoesInteressados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        JPanelInfoInteressadosLayout.setVerticalGroup(
            JPanelInfoInteressadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelInfoInteressadosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(JPanelInfoInteressadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(JPanelInfoInteressadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JPanelInfoInteressadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(JPanelInfoInteressadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNomeResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(JPanelInfoInteressadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(JComboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(JPanelInfoInteressadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(JPanelInfoInteressadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPanelBotoesInteressados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(JPanelInfoInteressados, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // TODO add your handling code here:
        
        if(txtNome.getText().isEmpty())
            JOptionPane.showMessageDialog(JPanelInfoInteressados, "Digite o nome da criança", "Erro", JOptionPane.ERROR_MESSAGE);
        else
        if(txtNomeResponsavel.getText().isEmpty())
            JOptionPane.showMessageDialog(JPanelInfoInteressados, "Digite o nome do responsável", "Erro", JOptionPane.ERROR_MESSAGE);
        else
        if(txtTelefone.getText().isEmpty())
            JOptionPane.showMessageDialog(JPanelInfoInteressados, "Digite o telefone", "Erro", JOptionPane.ERROR_MESSAGE);
        else
        {
            ModelInteressado modelInteressado = new ModelInteressado();
            
            /* Tratamento da data */
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = null;

            String dataNascimento = txtDataNascimento.getText();

            if(dataNascimento != null)
            {
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
                
                try {
                    modelInteressado.setDataNascimento(dataConvertida);
                } catch (ParseException ex) {
                    Logger.getLogger(frmInteressados.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(JPanelInfoInteressados, "Digite a data de nascimento", "Erro", JOptionPane.ERROR_MESSAGE);
            }

            modelInteressado.setNomeCrianca(txtNome.getText());
            modelInteressado.setEndereco(txtEndereco.getText());
            modelInteressado.setNomeResponsavel(txtNomeResponsavel.getText());
            modelInteressado.setStatus(JComboStatus.getSelectedItem().toString());
            modelInteressado.setTelefone(txtTelefone.getText());
            modelInteressado.setObservacao(txtObservacoes.getText());
            
            /* Inserção */

            DAOInteressados daoCrianca = new DAOInteressados();
            try
            {
                daoCrianca.insereInteressado(modelInteressado);
                
                JOptionPane.showMessageDialog(JPanelBotoesInteressados, "Criança interessada inserida no sistema com sucesso!", "Cadastro de Crianças", JOptionPane.INFORMATION_MESSAGE );
                this.setVisible(false);
            }
            catch(SQLException sql_e)
            {
                JOptionPane.showMessageDialog(JPanelBotoesInteressados, sql_e.getMessage(), "SQL Exception", JOptionPane.OK_OPTION);
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(JPanelBotoesInteressados, ex.getMessage(), "Exception", JOptionPane.OK_OPTION);
            }  
        }    
    }//GEN-LAST:event_btnCadastrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.
                    getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmInteressados.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmInteressados.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmInteressados.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmInteressados.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmInteressados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox JComboStatus;
    private javax.swing.JPanel JPanelBotoesInteressados;
    private javax.swing.JPanel JPanelInfoInteressados;
    private javax.swing.JPanel JPanelTituloInteressados;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDataNascimento;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeResponsavel;
    private javax.swing.JTextArea txtObservacoes;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
