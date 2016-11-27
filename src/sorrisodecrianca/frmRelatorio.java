/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorrisodecrianca;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import lib.DAOCrianca;
import lib.DAOPresenca;
import lib.DAOVoluntario;

/**
 *
 * @author Bruno
 */
public class frmRelatorio extends javax.swing.JFrame {

    /**
     * Creates new form frmRelatorio
     */
    public frmRelatorio() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JTabbedPanel = new javax.swing.JTabbedPane();
        panelCriancas = new javax.swing.JPanel();
        btnCriancas = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNomeCriancas = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtRGCriancas = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        checkCriancasAtivo = new javax.swing.JCheckBox();
        checkCriancasInativo = new javax.swing.JCheckBox();
        panelVoluntarios = new javax.swing.JPanel();
        btnVoluntarios = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtNomeVoluntarios = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtDocVoluntarios = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        checkVoluntariosAtivo = new javax.swing.JCheckBox();
        checkVoluntariosInativo = new javax.swing.JCheckBox();
        panelPresencas = new javax.swing.JPanel();
        btnPresencas = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtNomePresencas = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtAPartirPresencas = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtAtePresencas = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 1000));
        setMinimumSize(new java.awt.Dimension(100, 100));
        setPreferredSize(new java.awt.Dimension(510, 270));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Criação de Relatórios");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 423, 29));

        panelCriancas.setBorder(javax.swing.BorderFactory.createTitledBorder("Relatório de Crianças"));

        btnCriancas.setText("Gerar Relatório");
        btnCriancas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriancasActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtrar por:"));

        jLabel2.setText("Nome:");

        txtNomeCriancas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeCriancasActionPerformed(evt);
            }
        });

        jLabel5.setText("Status:");

        txtRGCriancas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRGCriancasActionPerformed(evt);
            }
        });

        jLabel6.setText("RG:");

        checkCriancasAtivo.setSelected(true);
        checkCriancasAtivo.setText("Ativo");

        checkCriancasInativo.setSelected(true);
        checkCriancasInativo.setText("Inativo");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(22, 22, 22)
                        .addComponent(txtNomeCriancas, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(19, 19, 19)
                        .addComponent(checkCriancasAtivo)
                        .addGap(9, 9, 9)
                        .addComponent(checkCriancasInativo))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(35, 35, 35)
                        .addComponent(txtRGCriancas, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(txtNomeCriancas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel5))
                    .addComponent(checkCriancasAtivo)
                    .addComponent(checkCriancasInativo))
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6))
                    .addComponent(txtRGCriancas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelCriancasLayout = new javax.swing.GroupLayout(panelCriancas);
        panelCriancas.setLayout(panelCriancasLayout);
        panelCriancasLayout.setHorizontalGroup(
            panelCriancasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCriancasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCriancas)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        panelCriancasLayout.setVerticalGroup(
            panelCriancasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelCriancasLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btnCriancas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JTabbedPanel.addTab("Crianças", panelCriancas);

        panelVoluntarios.setBorder(javax.swing.BorderFactory.createTitledBorder("Relatório de Voluntários"));
        panelVoluntarios.setPreferredSize(new java.awt.Dimension(400, 118));

        btnVoluntarios.setText("Gerar Relatório");
        btnVoluntarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoluntariosActionPerformed(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtrar por:"));

        jLabel13.setText("Nome:");

        txtNomeVoluntarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeVoluntariosActionPerformed(evt);
            }
        });

        jLabel14.setText("Status:");

        txtDocVoluntarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocVoluntariosActionPerformed(evt);
            }
        });

        jLabel15.setText("RG:");

        checkVoluntariosAtivo.setSelected(true);
        checkVoluntariosAtivo.setText("Ativo");

        checkVoluntariosInativo.setSelected(true);
        checkVoluntariosInativo.setText("Inativo");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDocVoluntarios, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeVoluntarios, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(checkVoluntariosAtivo)
                        .addGap(10, 10, 10)
                        .addComponent(checkVoluntariosInativo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtNomeVoluntarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(checkVoluntariosAtivo)
                    .addComponent(checkVoluntariosInativo))
                .addGap(4, 4, 4)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtDocVoluntarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout panelVoluntariosLayout = new javax.swing.GroupLayout(panelVoluntarios);
        panelVoluntarios.setLayout(panelVoluntariosLayout);
        panelVoluntariosLayout.setHorizontalGroup(
            panelVoluntariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVoluntariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVoluntarios)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        panelVoluntariosLayout.setVerticalGroup(
            panelVoluntariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelVoluntariosLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(btnVoluntarios)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JTabbedPanel.addTab("Voluntários", panelVoluntarios);

        panelPresencas.setBorder(javax.swing.BorderFactory.createTitledBorder("Relatório de Presenças"));

        btnPresencas.setText("Gerar Relatório");
        btnPresencas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPresencasActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtrar por:"));

        jLabel10.setText("Nome:");

        txtNomePresencas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomePresencasActionPerformed(evt);
            }
        });

        jLabel11.setText("Data:");

        txtAPartirPresencas.setToolTipText("Formato: DD/MM/AAAA");
        txtAPartirPresencas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAPartirPresencasActionPerformed(evt);
            }
        });

        jLabel12.setText("A partir:");

        jLabel16.setText("Até:");

        txtAtePresencas.setToolTipText("Formato: DD/MM/AAAA");
        txtAtePresencas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAtePresencasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtAtePresencas, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNomePresencas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtAPartirPresencas, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtNomePresencas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtAPartirPresencas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtAtePresencas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout panelPresencasLayout = new javax.swing.GroupLayout(panelPresencas);
        panelPresencas.setLayout(panelPresencasLayout);
        panelPresencasLayout.setHorizontalGroup(
            panelPresencasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPresencasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPresencas)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        panelPresencasLayout.setVerticalGroup(
            panelPresencasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPresencasLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
            .addGroup(panelPresencasLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnPresencas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JTabbedPanel.addTab("Presenças", panelPresencas);

        getContentPane().add(JTabbedPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 430, 170));

        jLabel4.setText("* Para não utilizar filtros apenas clique em \"Gerar Relatório\", sem alterar os campos.");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 208, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeCriancasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeCriancasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeCriancasActionPerformed

    private void btnCriancasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriancasActionPerformed
        DAOCrianca report = new DAOCrianca();

        //Parametros
        String nome = txtNomeCriancas.getText();
        nome = "%" + nome + "%";
        String status;
        if (checkCriancasAtivo.isSelected() && checkCriancasInativo.isSelected()) {
            status = "%";
        } else if (checkCriancasAtivo.isSelected()) {
            status = "Ativo";
        } else if (checkCriancasInativo.isSelected()) {
            status = "Inativo";
        } else {
            status = "%";
        }
        String doc = "%" + txtRGCriancas.getText() + "%";
        doc = doc.replaceAll("\\.", "").replaceAll("-", "").replaceAll("/", "");
        
        Map map = new HashMap();
        map.put("nome", nome);
        map.put("status", status);
        map.put("doc", doc);

        report.report(map);
    }//GEN-LAST:event_btnCriancasActionPerformed
    
    private void btnVoluntariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoluntariosActionPerformed
        DAOVoluntario report = new DAOVoluntario();

        //Parametros
        String nome = "%" + txtNomeVoluntarios.getText() + "%";
        String status;
        if (checkVoluntariosAtivo.isSelected() && checkVoluntariosInativo.isSelected()) {
            status = "%";
        } else if (checkVoluntariosAtivo.isSelected()) {
            status = "Ativo";
        } else if (checkVoluntariosInativo.isSelected()) {
            status = "Inativo";
        } else {
            status = "%";
        }
        String doc = txtDocVoluntarios.getText();
        if (doc.isEmpty()) {
            doc = "%";
        }
        doc = doc.replaceAll("\\.", "").replaceAll("-", "").replaceAll("/", "");
        
        Map map = new HashMap();
        map.put("nome", nome);
        map.put("status", status);
        map.put("doc", doc);
        report.report(map);
    }//GEN-LAST:event_btnVoluntariosActionPerformed

    private void txtRGCriancasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRGCriancasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRGCriancasActionPerformed

    private void btnPresencasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPresencasActionPerformed
        DAOPresenca report = new DAOPresenca();

        //Parametros
        String nome = txtNomePresencas.getText();
        nome = "%" + nome + "%";
        String aPartir = txtAPartirPresencas.getText();
        String ate = txtAtePresencas.getText();
        if(aPartir.isEmpty()){
            aPartir = "01/01/1900";
        }if(ate.isEmpty()){
            ate = "01/01/3000";
        }
        aPartir = maskData(aPartir);
        ate = maskData(ate);
        
        Map map = new HashMap();
        map.put("nome", nome);
        map.put("a_partir", aPartir);
        map.put("ate", ate);

        report.report(map);
    }//GEN-LAST:event_btnPresencasActionPerformed
    private String maskData(String data_br) {
        SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            String reformattedStr = myFormat.format(fromUser.parse(data_br));
            return reformattedStr;
        } catch (ParseException ex) {
            Logger.getLogger(frmRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    private void txtNomePresencasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomePresencasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomePresencasActionPerformed

    private void txtAPartirPresencasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAPartirPresencasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAPartirPresencasActionPerformed

    private void txtNomeVoluntariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeVoluntariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeVoluntariosActionPerformed

    private void txtDocVoluntariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocVoluntariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocVoluntariosActionPerformed

    private void txtAtePresencasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAtePresencasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAtePresencasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane JTabbedPanel;
    private javax.swing.JButton btnCriancas;
    private javax.swing.JButton btnPresencas;
    private javax.swing.JButton btnVoluntarios;
    private javax.swing.JCheckBox checkCriancasAtivo;
    private javax.swing.JCheckBox checkCriancasInativo;
    private javax.swing.JCheckBox checkVoluntariosAtivo;
    private javax.swing.JCheckBox checkVoluntariosInativo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel panelCriancas;
    private javax.swing.JPanel panelPresencas;
    private javax.swing.JPanel panelVoluntarios;
    private javax.swing.JTextField txtAPartirPresencas;
    private javax.swing.JTextField txtAtePresencas;
    private javax.swing.JTextField txtDocVoluntarios;
    private javax.swing.JTextField txtNomeCriancas;
    private javax.swing.JTextField txtNomePresencas;
    private javax.swing.JTextField txtNomeVoluntarios;
    private javax.swing.JTextField txtRGCriancas;
    // End of variables declaration//GEN-END:variables
}
