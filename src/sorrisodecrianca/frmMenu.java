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

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import lib.DAOCrianca;
import lib.DAOPresenca;
import lib.DAOVoluntario;
import models.ModelCrianca;
import models.ModelPresenca;

public class frmMenu extends javax.swing.JFrame {

    /**
     * Creates new form frmMenu
     */
    public frmMenu() throws Exception {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        LocalDate data_atual = LocalDate.now();
        
        String[] colunas = new String[]{"ID","Nome ","Segunda ","Terça ", "Quarta ", "Quinta ", "Sexta ", "Sábado ", "Domingo "};
        ArrayList<ModelPresenca> listaPresenca = new ArrayList<ModelPresenca>();
        ArrayList<ModelCrianca> listaCriancasAtivas = new ArrayList<ModelCrianca>();
        DAOPresenca dao_presenca = new DAOPresenca();
        DAOCrianca dao_crianca = new DAOCrianca();
        listaCriancasAtivas = dao_crianca.getCriancasAtivas();
        boolean presencaUpdate  = false; // flag para verificar se as presenças do dia jah foram digitadas
        
        if(dao_presenca.contPresencaData(Date.valueOf(data_atual)) > 0)
        {
            presencaUpdate = true;
        }
        
        
        DefaultTableModel tb_model = new DefaultTableModel()
        {
                @Override
                public boolean isCellEditable(int row, int col) {
                    switch(data_atual.getDayOfWeek().name())
                    {
                        case "MONDAY":
                            return col == 2;
                        case "TUESDAY":
                            return col == 3;
                        case "WENESDAY":
                            return col == 4;
                        case "THURSDAY":
                            return col == 5;
                        case "FRIDAY":
                            return col == 6;
                        case "SATURDAY":
                            return col == 7;
                        case "SUNDAY":
                            return col == 8;
                    }
                    return false;
                }
        };
        
        
        tb_model.setColumnIdentifiers(colunas);
        int id;
        
        String[] dados = new String[]{};
        
        for(int i =0; i < listaCriancasAtivas.size(); i++)
        {
            id = listaCriancasAtivas.get(i).getId();
            listaPresenca = new ArrayList<ModelPresenca>();
            
            switch(data_atual.getDayOfWeek().name())
            {
                case "MONDAY":
                        try
                        {
                            if(presencaUpdate)
                            {
                                listaPresenca = dao_presenca.getPesquisaCriancaPresenca(id, 1);
                                dados = new String[]
                                {
                                    listaCriancasAtivas.get(i).getId()+"",
                                    listaCriancasAtivas.get(i).getNome(),
                                    listaPresenca.get(0).getStatus(),
                                };
                            }
                        }
                        catch (Exception e)
                        {
                            JOptionPane.showMessageDialog(null, "Não foi possível carregar todas presenças porque o registro está incompleto!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                            i = listaCriancasAtivas.size();
                        }    
                    
                    
                    break;
                case "TUESDAY":
                    
                        try
                        {
                            if(presencaUpdate)
                            {
                                listaPresenca = dao_presenca.getPesquisaCriancaPresenca(id, 2);
                                dados = new String[]
                                {
                                    listaCriancasAtivas.get(i).getId()+"",
                                    listaCriancasAtivas.get(i).getNome(),
                                    listaPresenca.get(0).getStatus(),
                                    listaPresenca.get(1).getStatus(),
                                };
                            }
                            else
                            {
                                listaPresenca = dao_presenca.getPesquisaCriancaPresenca(id, 1);
                                dados = new String[]
                                {
                                    listaCriancasAtivas.get(i).getId()+"",
                                    listaCriancasAtivas.get(i).getNome(),
                                    listaPresenca.get(0).getStatus(),
                                };
                            }
                        }
                        catch (Exception e)
                        {
                            JOptionPane.showMessageDialog(null, "Não foi possível carregar todas presenças porque o registro está incompleto!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                            i = listaCriancasAtivas.size();
                        }
                    
                    break;
                case "WENESDAY":
                    
                        try
                        {
                            if(presencaUpdate)
                            {
                                listaPresenca = dao_presenca.getPesquisaCriancaPresenca(id, 3);
                                dados = new String[]
                                {
                                    listaCriancasAtivas.get(i).getId()+"",
                                    listaCriancasAtivas.get(i).getNome(),
                                    listaPresenca.get(0).getStatus(),
                                    listaPresenca.get(1).getStatus(),
                                    listaPresenca.get(2).getStatus(),
                                };
                            }
                            else
                            {
                                listaPresenca = dao_presenca.getPesquisaCriancaPresenca(id, 2);
                                dados = new String[]
                                {
                                    listaCriancasAtivas.get(i).getId()+"",
                                    listaCriancasAtivas.get(i).getNome(),
                                    listaPresenca.get(0).getStatus(),
                                    listaPresenca.get(1).getStatus(),
                                };
                            }
                        }
                        catch (Exception e)
                        {
                            JOptionPane.showMessageDialog(null, "Não foi possível carregar todas presenças porque o registro está incompleto!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                            i = listaCriancasAtivas.size();
                        }
                    
                    break;
                case "THURSDAY":
                    
                        try
                        {
                            if(presencaUpdate)
                            {
                                listaPresenca = dao_presenca.getPesquisaCriancaPresenca(id, 4);
                                dados = new String[]
                                {
                                    listaCriancasAtivas.get(i).getId()+"",
                                    listaCriancasAtivas.get(i).getNome(),
                                    listaPresenca.get(0).getStatus(),
                                    listaPresenca.get(1).getStatus(),
                                    listaPresenca.get(2).getStatus(),
                                    listaPresenca.get(3).getStatus(),
                                };
                            }
                            else
                            {
                                listaPresenca = dao_presenca.getPesquisaCriancaPresenca(id, 3);
                                dados = new String[]
                                {
                                    listaCriancasAtivas.get(i).getId()+"",
                                    listaCriancasAtivas.get(i).getNome(),
                                    listaPresenca.get(0).getStatus(),
                                    listaPresenca.get(1).getStatus(),
                                    listaPresenca.get(2).getStatus(),
                                };
                            }
                        }
                        catch (Exception e)
                        {
                            JOptionPane.showMessageDialog(null, "Não foi possível carregar todas presenças porque o registro está incompleto!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                            i = listaCriancasAtivas.size();
                        }
                    
                    break;
                case "FRIDAY":
                    
                        try
                        {
                            if(presencaUpdate)
                            {
                                listaPresenca = dao_presenca.getPesquisaCriancaPresenca(id, 5);
                                dados = new String[]
                                {
                                    listaCriancasAtivas.get(i).getId()+"",
                                    listaCriancasAtivas.get(i).getNome(),
                                    listaPresenca.get(0).getStatus(),
                                    listaPresenca.get(1).getStatus(),
                                    listaPresenca.get(2).getStatus(),
                                    listaPresenca.get(3).getStatus(),
                                    listaPresenca.get(4).getStatus(),
                                };
                            }
                            else
                            {
                                listaPresenca = dao_presenca.getPesquisaCriancaPresenca(id, 4);
                                dados = new String[]
                                {
                                    listaCriancasAtivas.get(i).getId()+"",
                                    listaCriancasAtivas.get(i).getNome(),
                                    listaPresenca.get(0).getStatus(),
                                    listaPresenca.get(1).getStatus(),
                                    listaPresenca.get(2).getStatus(),
                                    listaPresenca.get(3).getStatus(),
                                };
                            }
                        }
                        catch (Exception e)
                        {
                            JOptionPane.showMessageDialog(null, "Não foi possível carregar todas presenças porque o registro está incompleto!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                            i = listaCriancasAtivas.size();
                        }
                    
                    break;
                case "SATURDAY":
                    
                        try
                        {
                            if(presencaUpdate)
                            {
                                listaPresenca = dao_presenca.getPesquisaCriancaPresenca(id, 6);
                                dados = new String[]
                                {
                                    listaCriancasAtivas.get(i).getId()+"",
                                    listaCriancasAtivas.get(i).getNome(),
                                    listaPresenca.get(0).getStatus(),
                                    listaPresenca.get(1).getStatus(),
                                    listaPresenca.get(2).getStatus(),
                                    listaPresenca.get(3).getStatus(),
                                    listaPresenca.get(4).getStatus(),
                                    listaPresenca.get(5).getStatus(),
                                };
                            }
                            else
                            {
                                listaPresenca = dao_presenca.getPesquisaCriancaPresenca(id, 5);
                                dados = new String[]
                                {
                                    listaCriancasAtivas.get(i).getId()+"",
                                    listaCriancasAtivas.get(i).getNome(),
                                    listaPresenca.get(0).getStatus(),
                                    listaPresenca.get(1).getStatus(),
                                    listaPresenca.get(2).getStatus(),
                                    listaPresenca.get(3).getStatus(),
                                    listaPresenca.get(4).getStatus(),
                                };
                            }
                        }
                        catch (Exception e)
                        {
                            JOptionPane.showMessageDialog(null,"Não foi possível carregar todas presenças porque o registro está incompleto!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                            i = listaCriancasAtivas.size();
                        }
                    
                    break;
                case "SUNDAY":
                    
                        try
                        {
                            if(presencaUpdate)
                            {
                                listaPresenca = dao_presenca.getPesquisaCriancaPresenca(id, 7);
                                dados = new String[]
                                {
                                    listaCriancasAtivas.get(i).getId()+"",
                                    listaCriancasAtivas.get(i).getNome(),
                                    listaPresenca.get(0).getStatus(),
                                    listaPresenca.get(1).getStatus(),
                                    listaPresenca.get(2).getStatus(),
                                    listaPresenca.get(3).getStatus(),
                                    listaPresenca.get(4).getStatus(),
                                    listaPresenca.get(5).getStatus(),
                                    listaPresenca.get(6).getStatus(),
                                };
                            }
                            else
                            {
                                listaPresenca = dao_presenca.getPesquisaCriancaPresenca(id, 6);
                                dados = new String[]
                                {
                                    listaCriancasAtivas.get(i).getId()+"",
                                    listaCriancasAtivas.get(i).getNome(),
                                    listaPresenca.get(0).getStatus(),
                                    listaPresenca.get(1).getStatus(),
                                    listaPresenca.get(2).getStatus(),
                                    listaPresenca.get(3).getStatus(),
                                    listaPresenca.get(4).getStatus(),
                                    listaPresenca.get(5).getStatus(),
                                };
                            }
                        }
                        catch (Exception e)
                        {
                            JOptionPane.showMessageDialog(null, "Não foi possível carregar todas presenças porque o registro está incompleto!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                            i = listaCriancasAtivas.size();
                        }
                    
                    break;
            }
            tb_model.addRow(dados);
        }
        tb_model.isCellEditable(0, 5);
        
        tbPresenca = new JTable();
        tbPresenca.setModel(tb_model);
        scrollpanelPresenca.setViewportView(tbPresenca);
        resizeColumnWidth(tbPresenca);
    }
    
    public boolean isCellEditable()
    {
        return false;
    }
    
    /**
    * Ajusta as dimensões das colunas da tabela recebida
    * @param table tabela a ser redimensionada
    */
    public void resizeColumnWidth(JTable table)
    {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 50; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width +1 , width);
            }
            columnModel.getColumn(column).setPreferredWidth(width);
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

        btnCadCri = new javax.swing.JButton();
        btnCadVol = new javax.swing.JButton();
        scrollpanelPresenca = new javax.swing.JScrollPane();
        tbPresenca = new javax.swing.JTable();
        btnSalvarAlteracoes = new javax.swing.JButton();
        btnConsultas = new javax.swing.JButton();
        btnRelCriancas = new javax.swing.JButton();
        btnRelVoluntarios = new javax.swing.JButton();
        btnRelPresencas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCadCri.setText("Cadastro de Crianças");
        btnCadCri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadCriActionPerformed(evt);
            }
        });

        btnCadVol.setText("Cadastro de Voluntários");
        btnCadVol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadVolActionPerformed(evt);
            }
        });

        tbPresenca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollpanelPresenca.setViewportView(tbPresenca);

        btnSalvarAlteracoes.setText("Salvar Alterações");
        btnSalvarAlteracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarAlteracoesActionPerformed(evt);
            }
        });

        btnConsultas.setText("Consultas");
        btnConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultasActionPerformed(evt);
            }
        });

        btnRelCriancas.setText("Relatório de Crianças");
        btnRelCriancas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelCriancasActionPerformed(evt);
            }
        });

        btnRelVoluntarios.setText("Relatório de Voluntários");
        btnRelVoluntarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelVoluntariosActionPerformed(evt);
            }
        });

        btnRelPresencas.setText("Relatório de Presenças");
        btnRelPresencas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelPresencasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCadVol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCadCri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConsultas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRelCriancas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRelVoluntarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRelPresencas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(107, 107, 107)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollpanelPresenca, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(403, 403, 403)
                        .addComponent(btnSalvarAlteracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollpanelPresenca, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvarAlteracoes))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCadCri)
                        .addGap(38, 38, 38)
                        .addComponent(btnCadVol)
                        .addGap(61, 61, 61)
                        .addComponent(btnConsultas)
                        .addGap(69, 69, 69)
                        .addComponent(btnRelCriancas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRelVoluntarios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRelPresencas)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadCriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadCriActionPerformed
        frmCrianca fc = null;
        try {
            fc = new frmCrianca();
        } catch (Exception ex) {
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        fc.setVisible(true);
    }//GEN-LAST:event_btnCadCriActionPerformed

    private void btnCadVolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadVolActionPerformed
        frmVoluntario fv = new frmVoluntario();
        fv.setVisible(true);
    }//GEN-LAST:event_btnCadVolActionPerformed
    
    private void btnSalvarAlteracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarAlteracoesActionPerformed
        // TODO add your handling code here:
        LocalDate data_atual = LocalDate.now();
        DAOPresenca dao_presenca = new DAOPresenca();
        
        if(tbPresenca.isEditing())
        {
            JOptionPane.showMessageDialog(null, "Termine de editar a planilha apertando (clique na ultima célula editada e aperte ENTER)", "Aviso!", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        boolean presencaUpdate  = false; // flag para verificar se as presenças do dia jah foram digitadas
        try {
            if(dao_presenca.contPresencaData(Date.valueOf(data_atual)) > 0)
            {
                presencaUpdate = true;
            }
        } catch (Exception ex) {
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            switch(data_atual.getDayOfWeek().name())
            {
                case "MONDAY":
                        try
                        {
                            for(int i = 0; i < tbPresenca.getRowCount(); i++)
                            {
                                String presenca = tbPresenca.getModel().getValueAt(i, 2).toString().toUpperCase();
                                if(!presenca.equals("F") && !presenca.equals("P"))
                                {
                                    JOptionPane.showMessageDialog(null, "Preencha todos os campos com P ou F!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                                    btnSalvarAlteracoes.setEnabled(false);
                                    return;
                                }
                            }
                            
                            for(int i = 0; i < tbPresenca.getRowCount(); i++)
                            {
                                String id = tbPresenca.getModel().getValueAt(i, 0).toString();
                                String presenca = tbPresenca.getModel().getValueAt(i, 2).toString().toUpperCase();
                                
                                if(presencaUpdate)
                                {
                                    dao_presenca.updatePresencaCrianca(id, data_atual.toString(), presenca);
                                }
                                else
                                {
                                    dao_presenca.insertPresencaCrianca(id, data_atual.toString(), presenca);
                                }
                            }
                            JOptionPane.showMessageDialog(null, "As presenças foram salvas com sucesso!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
                        }
                        catch (Exception e)
                        {
                            JOptionPane.showMessageDialog(null, "Houve um problema ao inserir as novas presenças, verifique se todos os campos estão preenchidos!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                        }
                        
                    break;
                case "TUESDAY":
                    
                        try
                        {
                            for(int i = 0; i < tbPresenca.getRowCount(); i++)
                            {
                                String presenca = tbPresenca.getModel().getValueAt(i, 3).toString().toUpperCase();
                                if(!presenca.equals("F") && !presenca.equals("P"))
                                {
                                    JOptionPane.showMessageDialog(null, "Preencha todos os campos com P ou F!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                                    btnSalvarAlteracoes.setEnabled(false);
                                    return;
                                }
                            }
                            
                            for(int i = 0; i < tbPresenca.getRowCount(); i++)
                            {
                                String id = tbPresenca.getModel().getValueAt(i, 0).toString();
                                String presenca = tbPresenca.getModel().getValueAt(i, 3).toString().toUpperCase();
                                
                                if(presencaUpdate)
                                {
                                    dao_presenca.updatePresencaCrianca(id, data_atual.toString(), presenca);
                                }
                                else
                                {
                                    dao_presenca.insertPresencaCrianca(id, data_atual.toString(), presenca);
                                }
                            }
                            
                            JOptionPane.showMessageDialog(null, "As presenças foram salvas com sucesso!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);                    
                        }
                        catch (Exception e)
                        {
                            JOptionPane.showMessageDialog(null, "Houve um problema ao inserir as novas presenças, verifique se todos os campos estão preenchidos!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                        }
                    
                    break;
                case "WENESDAY":
                    
                        try
                        {
                            for(int i = 0; i < tbPresenca.getRowCount(); i++)
                            {
                                String presenca = tbPresenca.getModel().getValueAt(i, 4).toString().toUpperCase();
                                if(!presenca.equals("F") && !presenca.equals("P"))
                                {
                                    JOptionPane.showMessageDialog(null, "Preencha todos os campos com P ou F!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                                    btnSalvarAlteracoes.setEnabled(false);
                                    return;
                                }
                            }
                            
                            for(int i = 0; i < tbPresenca.getRowCount(); i++)
                            {
                                String id = tbPresenca.getModel().getValueAt(i, 0).toString();
                                String presenca = tbPresenca.getModel().getValueAt(i, 4).toString().toUpperCase();
                                
                                if(presencaUpdate)
                                {
                                    dao_presenca.updatePresencaCrianca(id, data_atual.toString(), presenca);
                                }
                                else
                                {
                                    dao_presenca.insertPresencaCrianca(id, data_atual.toString(), presenca);
                                }
                            }
                            JOptionPane.showMessageDialog(null, "As presenças foram salvas com sucesso!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
                        }
                        catch (Exception e)
                        {
                            JOptionPane.showMessageDialog(null, "Houve um problema ao inserir as novas presenças, verifique se todos os campos estão preenchidos!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                        }
                    
                    break;
                case "THURSDAY":
                             
                        try
                        {
                            for(int i = 0; i < tbPresenca.getRowCount(); i++)
                            {
                                String presenca = tbPresenca.getModel().getValueAt(i, 5).toString().toUpperCase();
                                if(!presenca.equals("F") && !presenca.equals("P"))
                                {
                                    JOptionPane.showMessageDialog(null, "Preencha todos os campos com P ou F!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                                    btnSalvarAlteracoes.setEnabled(false);
                                    return;
                                }
                            }
                            
                            for(int i = 0; i < tbPresenca.getRowCount(); i++)
                            {
                                String id = tbPresenca.getModel().getValueAt(i, 0).toString();
                                String presenca = tbPresenca.getModel().getValueAt(i, 5).toString().toUpperCase();
                                
                                if(presencaUpdate)
                                {
                                    dao_presenca.updatePresencaCrianca(id, data_atual.toString(), presenca);
                                }
                                else
                                {
                                    dao_presenca.insertPresencaCrianca(id, data_atual.toString(), presenca);
                                }
                            }
                            JOptionPane.showMessageDialog(null, "As presenças foram salvas com sucesso!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
                        }
                        catch (Exception e)
                        {
                            JOptionPane.showMessageDialog(null, e+" Houve um problema ao inserir as novas presenças, verifique se todos os campos estão preenchidos!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                        }
                    
                    break;
                case "FRIDAY":
                    
                        try
                        {
                            for(int i = 0; i < tbPresenca.getRowCount(); i++)
                            {
                                String presenca = tbPresenca.getModel().getValueAt(i, 6).toString().toUpperCase();
                                if(!presenca.equals("F") && !presenca.equals("P"))
                                {
                                    JOptionPane.showMessageDialog(null, "Preencha todos os campos com P ou F!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                                    btnSalvarAlteracoes.setEnabled(false);
                                    return;
                                }
                            }
                            
                            for(int i = 0; i < tbPresenca.getRowCount(); i++)
                            {
                                String id = tbPresenca.getModel().getValueAt(i, 0).toString();
                                String presenca = tbPresenca.getModel().getValueAt(i, 6).toString().toUpperCase();
                                
                                if(presencaUpdate)
                                {
                                    dao_presenca.updatePresencaCrianca(id, data_atual.toString(), presenca);
                                }
                                else
                                {
                                    dao_presenca.insertPresencaCrianca(id, data_atual.toString(), presenca);
                                }
                            }
                            JOptionPane.showMessageDialog(null, "As presenças foram salvas com sucesso!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
                        }
                        catch (Exception e)
                        {
                            JOptionPane.showMessageDialog(null, "Houve um problema ao inserir as novas presenças, verifique se todos os campos estão preenchidos!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                        }
                    
                    break;
                case "SATURDAY":
                    
                        try
                        {
                            for(int i = 0; i < tbPresenca.getRowCount(); i++)
                            {
                                String presenca = tbPresenca.getModel().getValueAt(i, 7).toString().toUpperCase();
                                if(!presenca.equals("F") && !presenca.equals("P"))
                                {
                                    JOptionPane.showMessageDialog(null, "Preencha todos os campos com P ou F!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                                    btnSalvarAlteracoes.setEnabled(false);
                                    return;
                                }
                            }
                            
                            for(int i = 0; i < tbPresenca.getRowCount(); i++)
                            {
                                String id = tbPresenca.getModel().getValueAt(i, 0).toString();
                                String presenca = tbPresenca.getModel().getValueAt(i, 7).toString().toUpperCase();
                                
                                if(presencaUpdate)
                                {
                                    dao_presenca.updatePresencaCrianca(id, data_atual.toString(), presenca);
                                }
                                else
                                {
                                    dao_presenca.insertPresencaCrianca(id, data_atual.toString(), presenca);
                                }
                            }
                            JOptionPane.showMessageDialog(null, "As presenças foram salvas com sucesso!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
                        }
                        catch (Exception e)
                        {
                            JOptionPane.showMessageDialog(null, "Houve um problema ao inserir as novas presenças, verifique se todos os campos estão preenchidos!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                        }
                    
                    break;
                case "SUNDAY":
                    
                        try
                        {
                            for(int i = 0; i < tbPresenca.getRowCount(); i++)
                            {
                                String presenca = tbPresenca.getModel().getValueAt(i, 8).toString().toUpperCase();
                                if(!presenca.equals("F") && !presenca.equals("P"))
                                {
                                    JOptionPane.showMessageDialog(null, "Preencha todos os campos com P ou F!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                                    btnSalvarAlteracoes.setEnabled(false);
                                    return;
                                }
                            }
                            
                            for(int i = 0; i < tbPresenca.getRowCount(); i++)
                            {
                                String id = tbPresenca.getModel().getValueAt(i, 0).toString();
                                String presenca = tbPresenca.getModel().getValueAt(i, 8).toString().toUpperCase();
                                dao_presenca.insertPresencaCrianca(id, data_atual.toString(), presenca);
                            }
                            JOptionPane.showMessageDialog(null, "As presenças foram salvas com sucesso!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
                        }
                        catch (Exception e)
                        {
                            JOptionPane.showMessageDialog(null, "Houve um problema ao inserir as novas presenças, verifique se todos os campos estão preenchidos!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                        }
                    
                    break;
            }
    }//GEN-LAST:event_btnSalvarAlteracoesActionPerformed

    private void btnConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultasActionPerformed
        // TODO add your handling code here:
        Consulta consultaCrianca = new Consulta();
        consultaCrianca.setVisible(true);
    }//GEN-LAST:event_btnConsultasActionPerformed

    private void btnRelCriancasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelCriancasActionPerformed
        DAOCrianca report = new DAOCrianca();
        report.report();
    }//GEN-LAST:event_btnRelCriancasActionPerformed

    private void btnRelVoluntariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelVoluntariosActionPerformed
        DAOVoluntario report = new DAOVoluntario();
        report.report();
    }//GEN-LAST:event_btnRelVoluntariosActionPerformed

    private void btnRelPresencasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelPresencasActionPerformed
        DAOPresenca report = new DAOPresenca();
        report.report();
    }//GEN-LAST:event_btnRelPresencasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadCri;
    private javax.swing.JButton btnCadVol;
    private javax.swing.JButton btnConsultas;
    private javax.swing.JButton btnRelCriancas;
    private javax.swing.JButton btnRelPresencas;
    private javax.swing.JButton btnRelVoluntarios;
    private javax.swing.JButton btnSalvarAlteracoes;
    private javax.swing.JScrollPane scrollpanelPresenca;
    private javax.swing.JTable tbPresenca;
    // End of variables declaration//GEN-END:variables
}
