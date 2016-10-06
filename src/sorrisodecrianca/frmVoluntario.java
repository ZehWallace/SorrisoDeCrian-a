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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Voluntários");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("Cadastro de Voluntários");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(281, 281, 281))
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
        jText_Observacoes.setRows(5);
        jScrollPane1.setViewportView(jText_Observacoes);

        javax.swing.GroupLayout jPanel_InfoVoluntarioLayout = new javax.swing.GroupLayout(jPanel_InfoVoluntario);
        jPanel_InfoVoluntario.setLayout(jPanel_InfoVoluntarioLayout);
        jPanel_InfoVoluntarioLayout.setHorizontalGroup(
            jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_InfoVoluntarioLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9))
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(32, 32, 32)
                .addGroup(jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel_InfoVoluntarioLayout.createSequentialGroup()
                            .addComponent(jText_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(135, 135, 135)
                            .addComponent(jLabel10)
                            .addGap(38, 38, 38)
                            .addComponent(jText_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel_InfoVoluntarioLayout.createSequentialGroup()
                            .addGroup(jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel_InfoVoluntarioLayout.createSequentialGroup()
                                    .addGroup(jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel_InfoVoluntarioLayout.createSequentialGroup()
                                            .addGap(160, 160, 160)
                                            .addComponent(jLabel7))
                                        .addComponent(jText_CPF, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(44, 44, 44))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_InfoVoluntarioLayout.createSequentialGroup()
                                    .addComponent(jText_RG, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)))
                            .addGroup(jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel_InfoVoluntarioLayout.createSequentialGroup()
                                    .addComponent(jText_DataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jComboBox_Sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jText_Ocupacao, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jText_Nome, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
                        .addComponent(jText_Endereco))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_InfoVoluntarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtn_CadastrarVoluntario, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(312, 312, 312))
        );
        jPanel_InfoVoluntarioLayout.setVerticalGroup(
            jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_InfoVoluntarioLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jText_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(26, 26, 26)
                .addGroup(jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jText_RG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jText_DataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox_Sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jText_CPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(jText_Ocupacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jText_Endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jText_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jText_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel_InfoVoluntarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jBtn_CadastrarVoluntario, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        
        /* Fim dos testes de consistencia */
        else
        {
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
    private javax.swing.JButton jBtn_CadastrarVoluntario;
    private javax.swing.JComboBox jComboBox_Sexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
