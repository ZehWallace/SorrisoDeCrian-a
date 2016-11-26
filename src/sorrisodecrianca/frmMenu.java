/*-------------------------------------------------------------------------
---------------------------------------------------------------------------
--- Universidade Federal de São Carlos - Campus Sorocaba        ---
--- Bacharelado em Ciência da Computação                ---
--- Sorriso de Criança                      ---
---                                 ---
---     Bruno Pereira                       ---
---     Celso Araujo Filho                  ---
---     Cristiano Silva                     ---
---     Pedro Brito Junior                  ---
---     Yasmin Beatriz Alves da Silva               ---
---                                 ---
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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import lib.DAOCrianca;
import lib.DAOPresenca;
import lib.DAOVoluntario;
import models.ModelCrianca;
import models.ModelPresenca;
import org.joda.time.DateTime;

public class frmMenu extends javax.swing.JFrame {

    private static DefaultTableModel tb_model;
    private static LocalDate data_atual;
    private static DAOCrianca dao_crianca;
    private static DAOPresenca dao_presenca;
    private static ArrayList<ModelPresenca> listaPresenca;
    private static ArrayList<ModelCrianca> listaCriancasAtivas;
    private static boolean presencaUpdate;

    public frmMenu() throws Exception {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        data_atual = LocalDate.now();

        Date date = Date.valueOf(data_atual);
        DateTime data_calculator = new DateTime(date);
        DateTime date_temp;
        java.text.SimpleDateFormat data_format = new java.text.SimpleDateFormat("yyyy-MM-dd");

        String[] colunas = new String[]{"ID", "Nome ", "Segunda ", "Terça ", "Quarta ", "Quinta ", "Sexta ", "Sábado ", "Domingo "};
        listaPresenca = new ArrayList<ModelPresenca>();
        listaCriancasAtivas = new ArrayList<ModelCrianca>();

        dao_presenca = new DAOPresenca();
        dao_crianca = new DAOCrianca();
        listaCriancasAtivas = dao_crianca.getCriancasAtivas();
        presencaUpdate = false; // flag para verificar se as presenças do dia jah foram digitadas

        if (dao_presenca.contPresencaData(Date.valueOf(data_atual)) > 0) {
            presencaUpdate = true;
        }

        tb_model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                switch (data_atual.getDayOfWeek().name()) {
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
        for (int i = 0; listaCriancasAtivas != null && i < listaCriancasAtivas.size(); i++) {
            id = listaCriancasAtivas.get(i).getId();
            listaPresenca = new ArrayList<ModelPresenca>();
            ModelPresenca presenca_temp;

            switch (data_atual.getDayOfWeek().name()) {
                case "MONDAY":
                    try {
                        if (presencaUpdate) {
                            for (int j = 0; j >= 0; j--) {
                                date_temp = data_calculator.minusDays(j);
                                presenca_temp = dao_presenca.getPesquisaCriancaPresencaData(id, data_format.format(date_temp.toDate()));
                                if (presenca_temp == null) {
                                    presenca_temp = new ModelPresenca();
                                    presenca_temp.setStatus("-");
                                }
                                listaPresenca.add(presenca_temp);
                            }

                            dados = new String[]{
                                listaCriancasAtivas.get(i).getId() + "",
                                listaCriancasAtivas.get(i).getNome(),
                                listaPresenca.get(0).getStatus(),};
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Não foi possível carregar todas presenças porque o registro está incompleto!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                        i = listaCriancasAtivas.size();
                    }

                    break;
                case "TUESDAY":

                    try {
                        if (presencaUpdate) {

                            for (int j = 1; j >= 0; j--) {
                                date_temp = data_calculator.minusDays(j);
                                presenca_temp = dao_presenca.getPesquisaCriancaPresencaData(id, data_format.format(date_temp.toDate()));
                                if (presenca_temp == null) {
                                    presenca_temp = new ModelPresenca();
                                    presenca_temp.setStatus("-");
                                }
                                listaPresenca.add(presenca_temp);
                            }

                            dados = new String[]{
                                listaCriancasAtivas.get(i).getId() + "",
                                listaCriancasAtivas.get(i).getNome(),
                                listaPresenca.get(0).getStatus(),
                                listaPresenca.get(1).getStatus(),};
                        } else {

                            for (int j = 1; j > 0; j--) {
                                date_temp = data_calculator.minusDays(j);
                                presenca_temp = dao_presenca.getPesquisaCriancaPresencaData(id, data_format.format(date_temp.toDate()));
                                if (presenca_temp == null) {
                                    presenca_temp = new ModelPresenca();
                                    presenca_temp.setStatus("-");
                                }
                                listaPresenca.add(presenca_temp);
                            }

                            dados = new String[]{
                                listaCriancasAtivas.get(i).getId() + "",
                                listaCriancasAtivas.get(i).getNome(),
                                listaPresenca.get(0).getStatus(),};
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Não foi possível carregar todas presenças porque o registro está incompleto!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                        i = listaCriancasAtivas.size();
                    }

                    break;
                case "WENESDAY":

                    try {
                        if (presencaUpdate) {

                            for (int j = 2; j >= 0; j--) {
                                date_temp = data_calculator.minusDays(j);
                                presenca_temp = dao_presenca.getPesquisaCriancaPresencaData(id, data_format.format(date_temp.toDate()));
                                if (presenca_temp == null) {
                                    presenca_temp = new ModelPresenca();
                                    presenca_temp.setStatus("-");
                                }
                                listaPresenca.add(presenca_temp);
                            }

                            dados = new String[]{
                                listaCriancasAtivas.get(i).getId() + "",
                                listaCriancasAtivas.get(i).getNome(),
                                listaPresenca.get(0).getStatus(),
                                listaPresenca.get(1).getStatus(),
                                listaPresenca.get(2).getStatus(),};
                        } else {

                            for (int j = 2; j > 0; j--) {
                                date_temp = data_calculator.minusDays(j);
                                presenca_temp = dao_presenca.getPesquisaCriancaPresencaData(id, data_format.format(date_temp.toDate()));
                                if (presenca_temp == null) {
                                    presenca_temp = new ModelPresenca();
                                    presenca_temp.setStatus("-");
                                }
                                listaPresenca.add(presenca_temp);
                            }

                            dados = new String[]{
                                listaCriancasAtivas.get(i).getId() + "",
                                listaCriancasAtivas.get(i).getNome(),
                                listaPresenca.get(0).getStatus(),
                                listaPresenca.get(1).getStatus(),};
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Não foi possível carregar todas presenças porque o registro está incompleto!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                        i = listaCriancasAtivas.size();
                    }

                    break;
                case "THURSDAY":

                    try {
                        if (presencaUpdate) {
                            for (int j = 3; j >= 0; j--) {
                                date_temp = data_calculator.minusDays(j);
                                presenca_temp = dao_presenca.getPesquisaCriancaPresencaData(id, data_format.format(date_temp.toDate()));
                                if (presenca_temp == null) {
                                    presenca_temp = new ModelPresenca();
                                    presenca_temp.setStatus("-");
                                }
                                listaPresenca.add(presenca_temp);
                            }

                            dados = new String[]{
                                listaCriancasAtivas.get(i).getId() + "",
                                listaCriancasAtivas.get(i).getNome(),
                                listaPresenca.get(0).getStatus(),
                                listaPresenca.get(1).getStatus(),
                                listaPresenca.get(2).getStatus(),
                                listaPresenca.get(3).getStatus(),};
                        } else {

                            for (int j = 3; j > 0; j--) {
                                date_temp = data_calculator.minusDays(j);
                                presenca_temp = dao_presenca.getPesquisaCriancaPresencaData(id, data_format.format(date_temp.toDate()));
                                if (presenca_temp == null) {
                                    presenca_temp = new ModelPresenca();
                                    presenca_temp.setStatus("-");
                                }
                                listaPresenca.add(presenca_temp);
                            }

                            dados = new String[]{
                                listaCriancasAtivas.get(i).getId() + "",
                                listaCriancasAtivas.get(i).getNome(),
                                listaPresenca.get(0).getStatus(),
                                listaPresenca.get(1).getStatus(),
                                listaPresenca.get(2).getStatus(),};
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, " Não foi possível carregar todas presenças porque o registro está incompleto!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                        i = listaCriancasAtivas.size();
                    }

                    break;
                case "FRIDAY":

                    try {
                        if (presencaUpdate) {
                            for (int j = 4; j >= 0; j--) {
                                date_temp = data_calculator.minusDays(j);
                                presenca_temp = dao_presenca.getPesquisaCriancaPresencaData(id, data_format.format(date_temp.toDate()));
                                if (presenca_temp == null) {
                                    presenca_temp = new ModelPresenca();
                                    presenca_temp.setStatus("-");
                                }
                                listaPresenca.add(presenca_temp);
                            }

                            dados = new String[]{
                                listaCriancasAtivas.get(i).getId() + "",
                                listaCriancasAtivas.get(i).getNome(),
                                listaPresenca.get(0).getStatus(),
                                listaPresenca.get(1).getStatus(),
                                listaPresenca.get(2).getStatus(),
                                listaPresenca.get(3).getStatus(),
                                listaPresenca.get(4).getStatus(),};
                        } else {

                            for (int j = 4; j > 0; j--) {
                                date_temp = data_calculator.minusDays(j);
                                presenca_temp = dao_presenca.getPesquisaCriancaPresencaData(id, data_format.format(date_temp.toDate()));
                                if (presenca_temp == null) {
                                    presenca_temp = new ModelPresenca();
                                    presenca_temp.setStatus("-");
                                }
                                listaPresenca.add(presenca_temp);
                            }

                            dados = new String[]{
                                listaCriancasAtivas.get(i).getId() + "",
                                listaCriancasAtivas.get(i).getNome(),
                                listaPresenca.get(0).getStatus(),
                                listaPresenca.get(1).getStatus(),
                                listaPresenca.get(2).getStatus(),
                                listaPresenca.get(3).getStatus(),};
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Não foi possível carregar todas presenças porque o registro está incompleto!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                        i = listaCriancasAtivas.size();
                    }

                    break;
                case "SATURDAY":

                    try {
                        if (presencaUpdate) {
                            for (int j = 5; j >= 0; j--) {
                                date_temp = data_calculator.minusDays(j);
                                presenca_temp = dao_presenca.getPesquisaCriancaPresencaData(id, data_format.format(date_temp.toDate()));
                                if (presenca_temp == null) {
                                    presenca_temp = new ModelPresenca();
                                    presenca_temp.setStatus("-");
                                }
                                listaPresenca.add(presenca_temp);
                            }

                            dados = new String[]{
                                listaCriancasAtivas.get(i).getId() + "",
                                listaCriancasAtivas.get(i).getNome(),
                                listaPresenca.get(0).getStatus(),
                                listaPresenca.get(1).getStatus(),
                                listaPresenca.get(2).getStatus(),
                                listaPresenca.get(3).getStatus(),
                                listaPresenca.get(4).getStatus(),
                                listaPresenca.get(5).getStatus(),};
                        } else {

                            for (int j = 5; j > 0; j--) {
                                date_temp = data_calculator.minusDays(j);
                                presenca_temp = dao_presenca.getPesquisaCriancaPresencaData(id, data_format.format(date_temp.toDate()));
                                if (presenca_temp == null) {
                                    presenca_temp = new ModelPresenca();
                                    presenca_temp.setStatus("-");
                                }
                                listaPresenca.add(presenca_temp);
                            }

                            dados = new String[]{
                                listaCriancasAtivas.get(i).getId() + "",
                                listaCriancasAtivas.get(i).getNome(),
                                listaPresenca.get(0).getStatus(),
                                listaPresenca.get(1).getStatus(),
                                listaPresenca.get(2).getStatus(),
                                listaPresenca.get(3).getStatus(),
                                listaPresenca.get(4).getStatus(),};
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Não foi possível carregar todas presenças porque o registro está incompleto!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                        i = listaCriancasAtivas.size();
                    }

                    break;
                case "SUNDAY":

                    try {
                        if (presencaUpdate) {

                            for (int j = 6; j >= 0; j--) {
                                date_temp = data_calculator.minusDays(j);
                                presenca_temp = dao_presenca.getPesquisaCriancaPresencaData(id, data_format.format(date_temp.toDate()));
                                if (presenca_temp == null) {
                                    presenca_temp = new ModelPresenca();
                                    presenca_temp.setStatus("-");
                                }
                                listaPresenca.add(presenca_temp);
                            }

                            dados = new String[]{
                                listaCriancasAtivas.get(i).getId() + "",
                                listaCriancasAtivas.get(i).getNome(),
                                listaPresenca.get(0).getStatus(),
                                listaPresenca.get(1).getStatus(),
                                listaPresenca.get(2).getStatus(),
                                listaPresenca.get(3).getStatus(),
                                listaPresenca.get(4).getStatus(),
                                listaPresenca.get(5).getStatus(),
                                listaPresenca.get(6).getStatus(),};
                        } else {

                            for (int j = 6; j > 0; j--) {
                                date_temp = data_calculator.minusDays(j);
                                presenca_temp = dao_presenca.getPesquisaCriancaPresencaData(id, data_format.format(date_temp.toDate()));
                                if (presenca_temp == null) {
                                    presenca_temp = new ModelPresenca();
                                    presenca_temp.setStatus("-");
                                }
                                listaPresenca.add(presenca_temp);
                            }

                            dados = new String[]{
                                listaCriancasAtivas.get(i).getId() + "",
                                listaCriancasAtivas.get(i).getNome(),
                                listaPresenca.get(0).getStatus(),
                                listaPresenca.get(1).getStatus(),
                                listaPresenca.get(2).getStatus(),
                                listaPresenca.get(3).getStatus(),
                                listaPresenca.get(4).getStatus(),
                                listaPresenca.get(5).getStatus(),};
                        }
                    } catch (Exception e) {
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

    public boolean isCellEditable() {
        return false;
    }

    /**
     * Ajusta as dimensões das colunas da tabela recebida
     *
     * @param table tabela a ser redimensionada
     */
    public void resizeColumnWidth(JTable table) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 50; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            columnModel.getColumn(column).setPreferredWidth(width);
            if (column != 1)//coluna de nomes
            {
                columnModel.getColumn(column).setCellRenderer(centerRenderer);
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

        jPanel1 = new javax.swing.JPanel();
        btnCadCri = new javax.swing.JButton();
        btnCadVol = new javax.swing.JButton();
        btnCadInter = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        scrollpanelPresenca = new javax.swing.JScrollPane();
        tbPresenca = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnSalvarAlteracoes = new javax.swing.JButton();
        btnConsultas = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnGerarRelatorio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCadCri.setText("Cadastro de Crianças");
        btnCadCri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadCriActionPerformed(evt);
            }
        });
        jPanel1.add(btnCadCri);

        btnCadVol.setText("Cadastro de Voluntários");
        btnCadVol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadVolActionPerformed(evt);
            }
        });
        jPanel1.add(btnCadVol);

        btnCadInter.setText("Cadastro de Interessados");
        btnCadInter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadInterActionPerformed(evt);
            }
        });
        jPanel1.add(btnCadInter);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        tbPresenca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollpanelPresenca.setViewportView(tbPresenca);

        jPanel2.add(scrollpanelPresenca);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        btnSalvarAlteracoes.setText("Salvar Alterações");
        btnSalvarAlteracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarAlteracoesActionPerformed(evt);
            }
        });
        jPanel3.add(btnSalvarAlteracoes);

        btnConsultas.setText("Consultas");
        btnConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultasActionPerformed(evt);
            }
        });
        jPanel3.add(btnConsultas);

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        jPanel3.add(btnAtualizar);

        btnGerarRelatorio.setText("Geração de relatórios");
        btnGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarRelatorioActionPerformed(evt);
            }
        });
        jPanel3.add(btnGerarRelatorio);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

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

        if (tbPresenca.isEditing()) {
            JOptionPane.showMessageDialog(null, "Termine de editar a planilha (clique na ultima célula editada e aperte ENTER)", "Aviso!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        presencaUpdate = false; // flag para verificar se as presenças do dia jah foram digitadas
        try {
            if (dao_presenca.contPresencaData(Date.valueOf(data_atual)) > 0) {
                presencaUpdate = true;
            }
        } catch (Exception ex) {
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }

        switch (data_atual.getDayOfWeek().name()) {
            case "MONDAY":
                try {
                    for (int i = 0; i < tbPresenca.getRowCount(); i++) {
                        String presenca = tbPresenca.getModel().getValueAt(i, 2).toString().toUpperCase();
                        if (!presenca.equals("F") && !presenca.equals("P")) {
                            JOptionPane.showMessageDialog(null, "Preencha todos os campos com P ou F!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                            btnSalvarAlteracoes.setEnabled(false);
                            return;
                        }
                    }

                    for (int i = 0; i < tbPresenca.getRowCount(); i++) {
                        String id = tbPresenca.getModel().getValueAt(i, 0).toString();
                        String presenca = tbPresenca.getModel().getValueAt(i, 2).toString().toUpperCase();

                        if (presencaUpdate) {
                            dao_presenca.updatePresencaCrianca(id, data_atual.toString(), presenca);
                        } else {
                            dao_presenca.insertPresencaCrianca(id, data_atual.toString(), presenca);
                        }
                    }
                    JOptionPane.showMessageDialog(null, "As presenças foram salvas com sucesso!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Houve um problema ao inserir as novas presenças, verifique se todos os campos estão preenchidos!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                }

                break;
            case "TUESDAY":

                try {
                    for (int i = 0; i < tbPresenca.getRowCount(); i++) {
                        String presenca = tbPresenca.getModel().getValueAt(i, 3).toString().toUpperCase();
                        if (!presenca.equals("F") && !presenca.equals("P")) {
                            JOptionPane.showMessageDialog(null, "Preencha todos os campos com P ou F!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                            btnSalvarAlteracoes.setEnabled(false);
                            return;
                        }
                    }

                    for (int i = 0; i < tbPresenca.getRowCount(); i++) {
                        String id = tbPresenca.getModel().getValueAt(i, 0).toString();
                        String presenca = tbPresenca.getModel().getValueAt(i, 3).toString().toUpperCase();

                        if (presencaUpdate) {
                            dao_presenca.updatePresencaCrianca(id, data_atual.toString(), presenca);
                        } else {
                            dao_presenca.insertPresencaCrianca(id, data_atual.toString(), presenca);
                        }
                    }

                    JOptionPane.showMessageDialog(null, "As presenças foram salvas com sucesso!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Houve um problema ao inserir as novas presenças, verifique se todos os campos estão preenchidos!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                }

                break;
            case "WENESDAY":

                try {
                    for (int i = 0; i < tbPresenca.getRowCount(); i++) {
                        String presenca = tbPresenca.getModel().getValueAt(i, 4).toString().toUpperCase();
                        if (!presenca.equals("F") && !presenca.equals("P")) {
                            JOptionPane.showMessageDialog(null, "Preencha todos os campos com P ou F!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                            btnSalvarAlteracoes.setEnabled(false);
                            return;
                        }
                    }

                    for (int i = 0; i < tbPresenca.getRowCount(); i++) {
                        String id = tbPresenca.getModel().getValueAt(i, 0).toString();
                        String presenca = tbPresenca.getModel().getValueAt(i, 4).toString().toUpperCase();

                        if (presencaUpdate) {
                            dao_presenca.updatePresencaCrianca(id, data_atual.toString(), presenca);
                        } else {
                            dao_presenca.insertPresencaCrianca(id, data_atual.toString(), presenca);
                        }
                    }
                    JOptionPane.showMessageDialog(null, "As presenças foram salvas com sucesso!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Houve um problema ao inserir as novas presenças, verifique se todos os campos estão preenchidos!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                }

                break;
            case "THURSDAY":

                try {
                    for (int i = 0; i < tbPresenca.getRowCount(); i++) {
                        String presenca = tbPresenca.getModel().getValueAt(i, 5).toString().toUpperCase();
                        if (!presenca.equals("F") && !presenca.equals("P")) {
                            JOptionPane.showMessageDialog(null, "Preencha todos os campos com P ou F!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                            btnSalvarAlteracoes.setEnabled(false);
                            return;
                        }
                    }

                    for (int i = 0; i < tbPresenca.getRowCount(); i++) {
                        String id = tbPresenca.getModel().getValueAt(i, 0).toString();
                        String presenca = tbPresenca.getModel().getValueAt(i, 5).toString().toUpperCase();

                        if (presencaUpdate) {
                            dao_presenca.updatePresencaCrianca(id, data_atual.toString(), presenca);
                        } else {
                            dao_presenca.insertPresencaCrianca(id, data_atual.toString(), presenca);
                        }
                    }
                    JOptionPane.showMessageDialog(null, "As presenças foram salvas com sucesso!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, " Houve um problema ao inserir as novas presenças, verifique se todos os campos estão preenchidos!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                }

                break;
            case "FRIDAY":

                try {
                    for (int i = 0; i < tbPresenca.getRowCount(); i++) {
                        String presenca = tbPresenca.getModel().getValueAt(i, 6).toString().toUpperCase();
                        if (!presenca.equals("F") && !presenca.equals("P")) {
                            JOptionPane.showMessageDialog(null, "Preencha todos os campos com P ou F!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                            btnSalvarAlteracoes.setEnabled(false);
                            return;
                        }
                    }

                    for (int i = 0; i < tbPresenca.getRowCount(); i++) {
                        String id = tbPresenca.getModel().getValueAt(i, 0).toString();
                        String presenca = tbPresenca.getModel().getValueAt(i, 6).toString().toUpperCase();

                        if (presencaUpdate) {
                            dao_presenca.updatePresencaCrianca(id, data_atual.toString(), presenca);
                        } else {
                            dao_presenca.insertPresencaCrianca(id, data_atual.toString(), presenca);
                        }
                    }
                    JOptionPane.showMessageDialog(null, "As presenças foram salvas com sucesso!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Houve um problema ao inserir as novas presenças, verifique se todos os campos estão preenchidos!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                }

                break;
            case "SATURDAY":

                try {
                    for (int i = 0; i < tbPresenca.getRowCount(); i++) {
                        String presenca = tbPresenca.getModel().getValueAt(i, 7).toString().toUpperCase();
                        if (!presenca.equals("F") && !presenca.equals("P")) {
                            JOptionPane.showMessageDialog(null, "Preencha todos os campos com P ou F!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                            btnSalvarAlteracoes.setEnabled(false);
                            return;
                        }
                    }

                    for (int i = 0; i < tbPresenca.getRowCount(); i++) {
                        String id = tbPresenca.getModel().getValueAt(i, 0).toString();
                        String presenca = tbPresenca.getModel().getValueAt(i, 7).toString().toUpperCase();

                        if (presencaUpdate) {
                            dao_presenca.updatePresencaCrianca(id, data_atual.toString(), presenca);
                        } else {
                            dao_presenca.insertPresencaCrianca(id, data_atual.toString(), presenca);
                        }
                    }
                    JOptionPane.showMessageDialog(null, "As presenças foram salvas com sucesso!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Houve um problema ao inserir as novas presenças, verifique se todos os campos estão preenchidos!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                }

                break;
            case "SUNDAY":

                try {
                    for (int i = 0; i < tbPresenca.getRowCount(); i++) {
                        String presenca = tbPresenca.getModel().getValueAt(i, 8).toString().toUpperCase();
                        if (!presenca.equals("F") && !presenca.equals("P")) {
                            JOptionPane.showMessageDialog(null, "Preencha todos os campos com P ou F!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                            btnSalvarAlteracoes.setEnabled(false);
                            return;
                        }
                    }

                    for (int i = 0; i < tbPresenca.getRowCount(); i++) {
                        String id = tbPresenca.getModel().getValueAt(i, 0).toString();
                        String presenca = tbPresenca.getModel().getValueAt(i, 8).toString().toUpperCase();
                        dao_presenca.insertPresencaCrianca(id, data_atual.toString(), presenca);
                    }
                    JOptionPane.showMessageDialog(null, "As presenças foram salvas com sucesso!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Houve um problema ao inserir as novas presenças, verifique se todos os campos estão preenchidos!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                }

                break;
        }

        try {
            if (dao_presenca.contPresencaData(Date.valueOf(data_atual)) > 0) {
                presencaUpdate = true;
            }
        } catch (Exception ex) {
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnSalvarAlteracoesActionPerformed

    private void btnConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultasActionPerformed
        // TODO add your handling code here:
        Consulta consultaCrianca = new Consulta();
        consultaCrianca.setVisible(true);
    }//GEN-LAST:event_btnConsultasActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed

        String[] dados = new String[]{};
        String[] colunas = new String[]{"ID", "Nome ", "Segunda ", "Terça ", "Quarta ", "Quinta ", "Sexta ", "Sábado ", "Domingo "};
        int id;

        Date date = Date.valueOf(data_atual);
        DateTime data_calculator = new DateTime(date);
        DateTime date_temp;
        java.text.SimpleDateFormat data_format = new java.text.SimpleDateFormat("yyyy-MM-dd");

        try {
            listaCriancasAtivas = dao_crianca.getCriancasAtivas();
        } catch (Exception ex) {
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }

        tb_model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                switch (data_atual.getDayOfWeek().name()) {
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

        for (int i = 0; i < listaCriancasAtivas.size(); i++) {
            id = listaCriancasAtivas.get(i).getId();
            listaPresenca = new ArrayList<ModelPresenca>();
            ModelPresenca presenca_temp;

            switch (data_atual.getDayOfWeek().name()) {
                case "MONDAY":
                    try {
                        if (presencaUpdate) {
                            for (int j = 0; j >= 0; j--) {
                                date_temp = data_calculator.minusDays(j);
                                presenca_temp = dao_presenca.getPesquisaCriancaPresencaData(id, data_format.format(date_temp.toDate()));
                                if (presenca_temp == null) {
                                    presenca_temp = new ModelPresenca();
                                    presenca_temp.setStatus("-");
                                }
                                listaPresenca.add(presenca_temp);
                            }

                            dados = new String[]{
                                listaCriancasAtivas.get(i).getId() + "",
                                listaCriancasAtivas.get(i).getNome(),
                                listaPresenca.get(0).getStatus(),};
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Não foi possível carregar todas presenças porque o registro está incompleto!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                        i = listaCriancasAtivas.size();
                    }

                    break;
                case "TUESDAY":

                    try {
                        if (presencaUpdate) {

                            for (int j = 1; j >= 0; j--) {
                                date_temp = data_calculator.minusDays(j);
                                presenca_temp = dao_presenca.getPesquisaCriancaPresencaData(id, data_format.format(date_temp.toDate()));
                                if (presenca_temp == null) {
                                    presenca_temp = new ModelPresenca();
                                    presenca_temp.setStatus("-");
                                }
                                listaPresenca.add(presenca_temp);
                            }

                            dados = new String[]{
                                listaCriancasAtivas.get(i).getId() + "",
                                listaCriancasAtivas.get(i).getNome(),
                                listaPresenca.get(0).getStatus(),
                                listaPresenca.get(1).getStatus(),};
                        } else {

                            for (int j = 1; j > 0; j--) {
                                date_temp = data_calculator.minusDays(j);
                                presenca_temp = dao_presenca.getPesquisaCriancaPresencaData(id, data_format.format(date_temp.toDate()));
                                if (presenca_temp == null) {
                                    presenca_temp = new ModelPresenca();
                                    presenca_temp.setStatus("-");
                                }
                                listaPresenca.add(presenca_temp);
                            }

                            dados = new String[]{
                                listaCriancasAtivas.get(i).getId() + "",
                                listaCriancasAtivas.get(i).getNome(),
                                listaPresenca.get(0).getStatus(),};
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Não foi possível carregar todas presenças porque o registro está incompleto!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                        i = listaCriancasAtivas.size();
                    }

                    break;
                case "WENESDAY":

                    try {
                        if (presencaUpdate) {

                            for (int j = 2; j >= 0; j--) {
                                date_temp = data_calculator.minusDays(j);
                                presenca_temp = dao_presenca.getPesquisaCriancaPresencaData(id, data_format.format(date_temp.toDate()));
                                if (presenca_temp == null) {
                                    presenca_temp = new ModelPresenca();
                                    presenca_temp.setStatus("-");
                                }
                                listaPresenca.add(presenca_temp);
                            }

                            dados = new String[]{
                                listaCriancasAtivas.get(i).getId() + "",
                                listaCriancasAtivas.get(i).getNome(),
                                listaPresenca.get(0).getStatus(),
                                listaPresenca.get(1).getStatus(),
                                listaPresenca.get(2).getStatus(),};
                        } else {

                            for (int j = 2; j > 0; j--) {
                                date_temp = data_calculator.minusDays(j);
                                presenca_temp = dao_presenca.getPesquisaCriancaPresencaData(id, data_format.format(date_temp.toDate()));
                                if (presenca_temp == null) {
                                    presenca_temp = new ModelPresenca();
                                    presenca_temp.setStatus("-");
                                }
                                listaPresenca.add(presenca_temp);
                            }

                            dados = new String[]{
                                listaCriancasAtivas.get(i).getId() + "",
                                listaCriancasAtivas.get(i).getNome(),
                                listaPresenca.get(0).getStatus(),
                                listaPresenca.get(1).getStatus(),};
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Não foi possível carregar todas presenças porque o registro está incompleto!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                        i = listaCriancasAtivas.size();
                    }

                    break;
                case "THURSDAY":

                    try {
                        if (presencaUpdate) {
                            for (int j = 3; j >= 0; j--) {
                                date_temp = data_calculator.minusDays(j);
                                presenca_temp = dao_presenca.getPesquisaCriancaPresencaData(id, data_format.format(date_temp.toDate()));
                                if (presenca_temp == null) {
                                    presenca_temp = new ModelPresenca();
                                    presenca_temp.setStatus("-");
                                }
                                listaPresenca.add(presenca_temp);
                            }

                            dados = new String[]{
                                listaCriancasAtivas.get(i).getId() + "",
                                listaCriancasAtivas.get(i).getNome(),
                                listaPresenca.get(0).getStatus(),
                                listaPresenca.get(1).getStatus(),
                                listaPresenca.get(2).getStatus(),
                                listaPresenca.get(3).getStatus(),};
                        } else {

                            for (int j = 3; j > 0; j--) {
                                date_temp = data_calculator.minusDays(j);
                                presenca_temp = dao_presenca.getPesquisaCriancaPresencaData(id, data_format.format(date_temp.toDate()));
                                if (presenca_temp == null) {
                                    presenca_temp = new ModelPresenca();
                                    presenca_temp.setStatus("-");
                                }
                                listaPresenca.add(presenca_temp);
                            }

                            dados = new String[]{
                                listaCriancasAtivas.get(i).getId() + "",
                                listaCriancasAtivas.get(i).getNome(),
                                listaPresenca.get(0).getStatus(),
                                listaPresenca.get(1).getStatus(),
                                listaPresenca.get(2).getStatus(),};
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, " Não foi possível carregar todas presenças porque o registro está incompleto!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                        i = listaCriancasAtivas.size();
                    }

                    break;
                case "FRIDAY":

                    try {
                        if (presencaUpdate) {
                            for (int j = 4; j >= 0; j--) {
                                date_temp = data_calculator.minusDays(j);
                                presenca_temp = dao_presenca.getPesquisaCriancaPresencaData(id, data_format.format(date_temp.toDate()));
                                if (presenca_temp == null) {
                                    presenca_temp = new ModelPresenca();
                                    presenca_temp.setStatus("-");
                                }
                                listaPresenca.add(presenca_temp);
                            }

                            dados = new String[]{
                                listaCriancasAtivas.get(i).getId() + "",
                                listaCriancasAtivas.get(i).getNome(),
                                listaPresenca.get(0).getStatus(),
                                listaPresenca.get(1).getStatus(),
                                listaPresenca.get(2).getStatus(),
                                listaPresenca.get(3).getStatus(),
                                listaPresenca.get(4).getStatus(),};
                        } else {

                            for (int j = 4; j > 0; j--) {
                                date_temp = data_calculator.minusDays(j);
                                presenca_temp = dao_presenca.getPesquisaCriancaPresencaData(id, data_format.format(date_temp.toDate()));
                                if (presenca_temp == null) {
                                    presenca_temp = new ModelPresenca();
                                    presenca_temp.setStatus("-");
                                }
                                listaPresenca.add(presenca_temp);
                            }

                            dados = new String[]{
                                listaCriancasAtivas.get(i).getId() + "",
                                listaCriancasAtivas.get(i).getNome(),
                                listaPresenca.get(0).getStatus(),
                                listaPresenca.get(1).getStatus(),
                                listaPresenca.get(2).getStatus(),
                                listaPresenca.get(3).getStatus(),};
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Não foi possível carregar todas presenças porque o registro está incompleto!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                        i = listaCriancasAtivas.size();
                    }

                    break;
                case "SATURDAY":

                    try {
                        if (presencaUpdate) {
                            for (int j = 5; j >= 0; j--) {
                                date_temp = data_calculator.minusDays(j);
                                presenca_temp = dao_presenca.getPesquisaCriancaPresencaData(id, data_format.format(date_temp.toDate()));
                                if (presenca_temp == null) {
                                    presenca_temp = new ModelPresenca();
                                    presenca_temp.setStatus("-");
                                }
                                listaPresenca.add(presenca_temp);
                            }

                            dados = new String[]{
                                listaCriancasAtivas.get(i).getId() + "",
                                listaCriancasAtivas.get(i).getNome(),
                                listaPresenca.get(0).getStatus(),
                                listaPresenca.get(1).getStatus(),
                                listaPresenca.get(2).getStatus(),
                                listaPresenca.get(3).getStatus(),
                                listaPresenca.get(4).getStatus(),
                                listaPresenca.get(5).getStatus(),};
                        } else {

                            for (int j = 5; j > 0; j--) {
                                date_temp = data_calculator.minusDays(j);
                                presenca_temp = dao_presenca.getPesquisaCriancaPresencaData(id, data_format.format(date_temp.toDate()));
                                if (presenca_temp == null) {
                                    presenca_temp = new ModelPresenca();
                                    presenca_temp.setStatus("-");
                                }
                                listaPresenca.add(presenca_temp);
                            }

                            dados = new String[]{
                                listaCriancasAtivas.get(i).getId() + "",
                                listaCriancasAtivas.get(i).getNome(),
                                listaPresenca.get(0).getStatus(),
                                listaPresenca.get(1).getStatus(),
                                listaPresenca.get(2).getStatus(),
                                listaPresenca.get(3).getStatus(),
                                listaPresenca.get(4).getStatus(),};
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Não foi possível carregar todas presenças porque o registro está incompleto!", "Aviso!", JOptionPane.WARNING_MESSAGE);
                        i = listaCriancasAtivas.size();
                    }

                    break;
                case "SUNDAY":

                    try {
                        if (presencaUpdate) {

                            for (int j = 6; j >= 0; j--) {
                                date_temp = data_calculator.minusDays(j);
                                presenca_temp = dao_presenca.getPesquisaCriancaPresencaData(id, data_format.format(date_temp.toDate()));
                                if (presenca_temp == null) {
                                    presenca_temp = new ModelPresenca();
                                    presenca_temp.setStatus("-");
                                }
                                listaPresenca.add(presenca_temp);
                            }

                            dados = new String[]{
                                listaCriancasAtivas.get(i).getId() + "",
                                listaCriancasAtivas.get(i).getNome(),
                                listaPresenca.get(0).getStatus(),
                                listaPresenca.get(1).getStatus(),
                                listaPresenca.get(2).getStatus(),
                                listaPresenca.get(3).getStatus(),
                                listaPresenca.get(4).getStatus(),
                                listaPresenca.get(5).getStatus(),
                                listaPresenca.get(6).getStatus(),};
                        } else {

                            for (int j = 6; j > 0; j--) {
                                date_temp = data_calculator.minusDays(j);
                                presenca_temp = dao_presenca.getPesquisaCriancaPresencaData(id, data_format.format(date_temp.toDate()));
                                if (presenca_temp == null) {
                                    presenca_temp = new ModelPresenca();
                                    presenca_temp.setStatus("-");
                                }
                                listaPresenca.add(presenca_temp);
                            }

                            dados = new String[]{
                                listaCriancasAtivas.get(i).getId() + "",
                                listaCriancasAtivas.get(i).getNome(),
                                listaPresenca.get(0).getStatus(),
                                listaPresenca.get(1).getStatus(),
                                listaPresenca.get(2).getStatus(),
                                listaPresenca.get(3).getStatus(),
                                listaPresenca.get(4).getStatus(),
                                listaPresenca.get(5).getStatus(),};
                        }
                    } catch (Exception e) {
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

    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarRelatorioActionPerformed
        frmRelatorio fr = null;
        try {
            fr = new frmRelatorio();
        }catch(Exception ex){
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        fr.setVisible(true);
    }//GEN-LAST:event_btnGerarRelatorioActionPerformed

    private void btnCadInterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadInterActionPerformed
        // TODO add your handling code here:
        frmInteressados formInter = new frmInteressados();
        formInter.setVisible(true);
    }//GEN-LAST:event_btnCadInterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCadCri;
    private javax.swing.JButton btnCadInter;
    private javax.swing.JButton btnCadVol;
    private javax.swing.JButton btnConsultas;
    private javax.swing.JButton btnGerarRelatorio;
    private javax.swing.JButton btnSalvarAlteracoes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane scrollpanelPresenca;
    private javax.swing.JTable tbPresenca;
    // End of variables declaration//GEN-END:variables
}