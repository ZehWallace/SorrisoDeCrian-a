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
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
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
        
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logo.jpg")));
        this.setTitle("Sistema Sorriso de Criança");
        
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
        btnConsultas = new javax.swing.JButton();
        btnGerarRelatorio = new javax.swing.JButton();
        btnCadastro = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        scrollpanelPresenca = new javax.swing.JScrollPane();
        tbPresenca = new javax.swing.JTable();
        btnAtualizar = new javax.swing.JButton();
        btnSalvarAlteracoes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Sorriso de Criança");

        btnConsultas.setText("Consultas");
        btnConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultasActionPerformed(evt);
            }
        });

        btnGerarRelatorio.setText("Geração de relatórios");
        btnGerarRelatorio.setMaximumSize(new java.awt.Dimension(79, 23));
        btnGerarRelatorio.setMinimumSize(new java.awt.Dimension(79, 23));
        btnGerarRelatorio.setPreferredSize(new java.awt.Dimension(79, 23));
        btnGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarRelatorioActionPerformed(evt);
            }
        });

        btnCadastro.setText("Novo Cadastro");
        btnCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Menu");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGerarRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnGerarRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        tbPresenca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollpanelPresenca.setViewportView(tbPresenca);

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnSalvarAlteracoes.setText("Salvar Alterações");
        btnSalvarAlteracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarAlteracoesActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Lista de Presença da Semana");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollpanelPresenca, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAtualizar)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvarAlteracoes)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 33, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrollpanelPresenca, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtualizar)
                    .addComponent(btnSalvarAlteracoes))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                            return;
                        }
                    }

                    for (int i = 0; i < tbPresenca.getRowCount(); i++) {
                        String id = tbPresenca.getModel().getValueAt(i, 0).toString();
                        String presenca = tbPresenca.getModel().getValueAt(i, 2).toString().toUpperCase();

                        if (presencaUpdate) {
                            if(dao_presenca.getPesquisaCriancaPresencaData(Integer.parseInt(id), data_atual.toString()) == null)
                                dao_presenca.insertPresencaCrianca(id, data_atual.toString(), presenca);
                            else
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
                            if(dao_presenca.getPesquisaCriancaPresencaData(Integer.parseInt(id), data_atual.toString()) == null)
                                dao_presenca.insertPresencaCrianca(id, data_atual.toString(), presenca);
                            else
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
                            if(dao_presenca.getPesquisaCriancaPresencaData(Integer.parseInt(id), data_atual.toString()) == null)
                                dao_presenca.insertPresencaCrianca(id, data_atual.toString(), presenca);
                            else
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
                            if(dao_presenca.getPesquisaCriancaPresencaData(Integer.parseInt(id), data_atual.toString()) == null)
                                dao_presenca.insertPresencaCrianca(id, data_atual.toString(), presenca);
                            else
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
                            if(dao_presenca.getPesquisaCriancaPresencaData(Integer.parseInt(id), data_atual.toString()) == null)
                                dao_presenca.insertPresencaCrianca(id, data_atual.toString(), presenca);
                            else
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
                            if(dao_presenca.getPesquisaCriancaPresencaData(Integer.parseInt(id), data_atual.toString()) == null)
                                dao_presenca.insertPresencaCrianca(id, data_atual.toString(), presenca);
                            else
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
                        
                        if (presencaUpdate) {
                            if(dao_presenca.getPesquisaCriancaPresencaData(Integer.parseInt(id), data_atual.toString()) == null)
                                dao_presenca.insertPresencaCrianca(id, data_atual.toString(), presenca);
                            else
                                dao_presenca.updatePresencaCrianca(id, data_atual.toString(), presenca);;
                        } else {
                            dao_presenca.insertPresencaCrianca(id, data_atual.toString(), presenca);
                        }
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

    private void btnCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroActionPerformed
        // TODO add your handling code here:
        frmCadastro fc = null;
        try {
            fc = new frmCadastro();
        }catch(Exception ex){
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        fc.setVisible(true);
    }//GEN-LAST:event_btnCadastroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCadastro;
    private javax.swing.JButton btnConsultas;
    private javax.swing.JButton btnGerarRelatorio;
    private javax.swing.JButton btnSalvarAlteracoes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane scrollpanelPresenca;
    private javax.swing.JTable tbPresenca;
    // End of variables declaration//GEN-END:variables
}