/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

/**
 *
 * @author User
 */
public class AddPTuristico extends javax.swing.JPanel {

    /**
     * Creates new form AddPTuristico
     */
    public AddPTuristico() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLInserir = new javax.swing.JLabel();
        jBConcluir = new javax.swing.JButton();
        jRBCasaShow = new javax.swing.JRadioButton();
        jRBParque = new javax.swing.JRadioButton();
        jRBMuseu = new javax.swing.JRadioButton();
        jRBIgreja = new javax.swing.JRadioButton();
        jPPturistico = new javax.swing.JPanel();
        jPCasashow = new javax.swing.JPanel();
        jLCasashowHrinicio = new javax.swing.JLabel();
        jTFCasashowHrinicio = new javax.swing.JTextField();
        jLCasashowDiafech = new javax.swing.JLabel();
        jCBCasashowDiafech = new javax.swing.JComboBox<>();
        jLCasashowRestaurante = new javax.swing.JLabel();
        jCBCasashowRestaurante = new javax.swing.JComboBox<>();
        jCkBCasashowRestaurante = new javax.swing.JCheckBox();
        jLCasashowPreco = new javax.swing.JLabel();
        jTFCasashowPreco = new javax.swing.JTextField();
        jLCasashowEsp = new javax.swing.JLabel();
        jCBCasashowEsp = new javax.swing.JComboBox<>();
        jPIgreja = new javax.swing.JPanel();
        jLIgrejaData = new javax.swing.JLabel();
        jLIgrejaEstilo = new javax.swing.JLabel();
        jTFIgrejaData = new javax.swing.JTextField();
        jTFIgrejaEstilo = new javax.swing.JTextField();
        jPMuseu = new javax.swing.JPanel();
        jLMuseuData = new javax.swing.JLabel();
        jLMuseuNrsalas = new javax.swing.JLabel();
        jTFMuseuNrsalas = new javax.swing.JTextField();
        jTFMuseuData = new javax.swing.JTextField();
        jLMuseuFundadores = new javax.swing.JLabel();
        jCBMuseuFundadores = new javax.swing.JComboBox<>();
        jBMuseuAdicionar = new javax.swing.JButton();
        jSPMuseuFundadores = new javax.swing.JScrollPane();
        jLtMuseuFundadores = new javax.swing.JList(new javax.swing.DefaultListModel());
        jBMuseuRemover = new javax.swing.JButton();
        jPParque = new javax.swing.JPanel();
        jLParqueNratracoes = new javax.swing.JLabel();
        jLParqueCapacidade = new javax.swing.JLabel();
        jTFParqueNrAtracoes = new javax.swing.JTextField();
        jTFParqueCapacidade = new javax.swing.JTextField();
        jLTipo = new javax.swing.JLabel();
        jLNome = new javax.swing.JLabel();
        jLDescricao = new javax.swing.JLabel();
        jLCidade = new javax.swing.JLabel();
        jLEndereco = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTADescricao = new javax.swing.JTextArea();
        jTFNome = new javax.swing.JTextField();
        jTFEndereco = new javax.swing.JTextField();
        jCBCidade = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();

        jLInserir.setText("Inserir Ponto Turístico");

        jBConcluir.setText("Concluir");
        jBConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConcluirActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRBCasaShow);
        jRBCasaShow.setSelected(true);
        jRBCasaShow.setText("Casa de Show");
        jRBCasaShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBCasaShowActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRBParque);
        jRBParque.setText("Parque");
        jRBParque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBParqueActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRBMuseu);
        jRBMuseu.setText("Museu");
        jRBMuseu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBMuseuActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRBIgreja);
        jRBIgreja.setText("Igreja");
        jRBIgreja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBIgrejaActionPerformed(evt);
            }
        });

        jPPturistico.setLayout(new java.awt.CardLayout());

        jLCasashowHrinicio.setText("Hora de início:");

        jTFCasashowHrinicio.setToolTipText("hh:mm");

        jLCasashowDiafech.setText("Dia de fechamento:");

        jCBCasashowDiafech.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DOM", "SEG", "TER", "QUA", "QUI", "SEX", "SAB" }));

        jLCasashowRestaurante.setText("Restaurante:");

        jCBCasashowRestaurante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Res 1", "Res 2", "Res 3", "Res 4" }));
        jCBCasashowRestaurante.setEnabled(false);

        jCkBCasashowRestaurante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCkBCasashowRestauranteActionPerformed(evt);
            }
        });

        jLCasashowPreco.setText("Preço médio:");

        jTFCasashowPreco.setEnabled(false);

        jLCasashowEsp.setText("Especialidade:");

        jCBCasashowEsp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OUTRO", "BRA", "ITA", "JAP", "MEX" }));
        jCBCasashowEsp.setEnabled(false);

        javax.swing.GroupLayout jPCasashowLayout = new javax.swing.GroupLayout(jPCasashow);
        jPCasashow.setLayout(jPCasashowLayout);
        jPCasashowLayout.setHorizontalGroup(
            jPCasashowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCasashowLayout.createSequentialGroup()
                .addGroup(jPCasashowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLCasashowHrinicio)
                    .addComponent(jLCasashowRestaurante)
                    .addComponent(jLCasashowPreco))
                .addGap(18, 18, 18)
                .addGroup(jPCasashowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBCasashowRestaurante, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPCasashowLayout.createSequentialGroup()
                        .addGroup(jPCasashowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPCasashowLayout.createSequentialGroup()
                                .addComponent(jTFCasashowHrinicio, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLCasashowDiafech)
                                .addGap(18, 18, 18)
                                .addComponent(jCBCasashowDiafech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPCasashowLayout.createSequentialGroup()
                                .addComponent(jTFCasashowPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLCasashowEsp)
                                .addGap(18, 18, 18)
                                .addComponent(jCBCasashowEsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 128, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCkBCasashowRestaurante))
        );
        jPCasashowLayout.setVerticalGroup(
            jPCasashowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCasashowLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCasashowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCasashowHrinicio)
                    .addComponent(jTFCasashowHrinicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLCasashowDiafech)
                    .addComponent(jCBCasashowDiafech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCasashowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPCasashowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLCasashowRestaurante)
                        .addComponent(jCBCasashowRestaurante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCkBCasashowRestaurante))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCasashowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCasashowPreco)
                    .addComponent(jTFCasashowPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLCasashowEsp)
                    .addComponent(jCBCasashowEsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPPturistico.add(jPCasashow, "addcasashow");

        jLIgrejaData.setText("Data de Fundação:");

        jLIgrejaEstilo.setText("Estilo de Construção:");

        jTFIgrejaData.setToolTipText("dd/mm/aaaa");

        javax.swing.GroupLayout jPIgrejaLayout = new javax.swing.GroupLayout(jPIgreja);
        jPIgreja.setLayout(jPIgrejaLayout);
        jPIgrejaLayout.setHorizontalGroup(
            jPIgrejaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPIgrejaLayout.createSequentialGroup()
                .addComponent(jLIgrejaData)
                .addGap(18, 18, 18)
                .addComponent(jTFIgrejaData, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLIgrejaEstilo)
                .addGap(18, 18, 18)
                .addComponent(jTFIgrejaEstilo, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPIgrejaLayout.setVerticalGroup(
            jPIgrejaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPIgrejaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPIgrejaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLIgrejaData)
                    .addComponent(jTFIgrejaData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLIgrejaEstilo)
                    .addComponent(jTFIgrejaEstilo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(152, Short.MAX_VALUE))
        );

        jPPturistico.add(jPIgreja, "addigreja");

        jLMuseuData.setText("Data de Fundação:");

        jLMuseuNrsalas.setText("Número de Salas:");

        jTFMuseuData.setToolTipText("dd/mm/aaaa");

        jLMuseuFundadores.setText("Fundadores:");

        jCBMuseuFundadores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fund 1", "Fund 2", "Fund 3", "Fund 4" }));

        jBMuseuAdicionar.setText("Adicionar");
        jBMuseuAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMuseuAdicionarActionPerformed(evt);
            }
        });

        jLtMuseuFundadores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jSPMuseuFundadores.setViewportView(jLtMuseuFundadores);

        jBMuseuRemover.setText("Remover");
        jBMuseuRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMuseuRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPMuseuLayout = new javax.swing.GroupLayout(jPMuseu);
        jPMuseu.setLayout(jPMuseuLayout);
        jPMuseuLayout.setHorizontalGroup(
            jPMuseuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPMuseuLayout.createSequentialGroup()
                .addGroup(jPMuseuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLMuseuData)
                    .addComponent(jLMuseuFundadores))
                .addGap(18, 18, 18)
                .addGroup(jPMuseuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPMuseuLayout.createSequentialGroup()
                        .addComponent(jTFMuseuData, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLMuseuNrsalas)
                        .addGap(18, 18, 18)
                        .addComponent(jTFMuseuNrsalas, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPMuseuLayout.createSequentialGroup()
                        .addGroup(jPMuseuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSPMuseuFundadores, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                            .addComponent(jCBMuseuFundadores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPMuseuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBMuseuAdicionar)
                            .addComponent(jBMuseuRemover)))))
        );
        jPMuseuLayout.setVerticalGroup(
            jPMuseuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPMuseuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPMuseuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLMuseuData)
                    .addComponent(jTFMuseuData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLMuseuNrsalas)
                    .addComponent(jTFMuseuNrsalas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPMuseuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLMuseuFundadores)
                    .addComponent(jCBMuseuFundadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBMuseuAdicionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPMuseuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSPMuseuFundadores, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBMuseuRemover))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPPturistico.add(jPMuseu, "addmuseu");

        jLParqueNratracoes.setText("Número de Atrações:");

        jLParqueCapacidade.setText("Capacidade:");

        javax.swing.GroupLayout jPParqueLayout = new javax.swing.GroupLayout(jPParque);
        jPParque.setLayout(jPParqueLayout);
        jPParqueLayout.setHorizontalGroup(
            jPParqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPParqueLayout.createSequentialGroup()
                .addComponent(jLParqueNratracoes)
                .addGap(18, 18, 18)
                .addComponent(jTFParqueNrAtracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLParqueCapacidade)
                .addGap(18, 18, 18)
                .addComponent(jTFParqueCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPParqueLayout.setVerticalGroup(
            jPParqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPParqueLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPParqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLParqueNratracoes)
                    .addComponent(jTFParqueNrAtracoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLParqueCapacidade)
                    .addComponent(jTFParqueCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(152, Short.MAX_VALUE))
        );

        jPPturistico.add(jPParque, "addparque");

        jLTipo.setText("Tipo:");

        jLNome.setText("Nome:");

        jLDescricao.setText("Descrição:");

        jLCidade.setText("Cidade:");

        jLEndereco.setText("Endereço:");

        jTADescricao.setColumns(20);
        jTADescricao.setRows(5);
        jScrollPane1.setViewportView(jTADescricao);

        jTFEndereco.setToolTipText("Rua, Número, Bairro");

        jCBCidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cid 1", "Cid 2", "Cid 3", "Cid 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPPturistico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLDescricao)
                                    .addComponent(jLCidade)
                                    .addComponent(jLEndereco)
                                    .addComponent(jLTipo)
                                    .addComponent(jLNome))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRBCasaShow)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRBIgreja)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRBMuseu)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRBParque)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jScrollPane1)
                                    .addComponent(jTFEndereco)
                                    .addComponent(jCBCidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTFNome)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLInserir)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBConcluir)))
                .addGap(95, 95, 95))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLInserir)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNome)
                    .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLDescricao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCidade)
                    .addComponent(jCBCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLEndereco)
                    .addComponent(jTFEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBCasaShow)
                    .addComponent(jRBMuseu)
                    .addComponent(jRBIgreja)
                    .addComponent(jRBParque)
                    .addComponent(jLTipo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPPturistico, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jBConcluir)
                .addGap(130, 130, 130))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBConcluirActionPerformed

    private void jRBCasaShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBCasaShowActionPerformed
        java.awt.CardLayout c = (java.awt.CardLayout)(jPPturistico.getLayout());
        c.show(jPPturistico, "addcasashow");
    }//GEN-LAST:event_jRBCasaShowActionPerformed

    private void jRBIgrejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBIgrejaActionPerformed
        java.awt.CardLayout c = (java.awt.CardLayout)(jPPturistico.getLayout());
        c.show(jPPturistico, "addigreja");
    }//GEN-LAST:event_jRBIgrejaActionPerformed

    private void jRBMuseuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBMuseuActionPerformed
        java.awt.CardLayout c = (java.awt.CardLayout)(jPPturistico.getLayout());
        c.show(jPPturistico, "addmuseu");
    }//GEN-LAST:event_jRBMuseuActionPerformed

    private void jRBParqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBParqueActionPerformed
        java.awt.CardLayout c = (java.awt.CardLayout)(jPPturistico.getLayout());
        c.show(jPPturistico, "addparque");
    }//GEN-LAST:event_jRBParqueActionPerformed

    private void jCkBCasashowRestauranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCkBCasashowRestauranteActionPerformed
        boolean value = jCBCasashowRestaurante.isEnabled();
        jCBCasashowRestaurante.setSelectedIndex(0);
        jCBCasashowRestaurante.setEnabled(!value);
        jCBCasashowEsp.setSelectedIndex(0);
        jCBCasashowEsp.setEnabled(!value);
        jTFCasashowPreco.setEnabled(!value);
    }//GEN-LAST:event_jCkBCasashowRestauranteActionPerformed

    private void jBMuseuAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMuseuAdicionarActionPerformed
        String selected = jCBMuseuFundadores.getSelectedItem().toString();
        DefaultListModel<String> list = (DefaultListModel<String>) jLtMuseuFundadores.getModel();
        if(!list.contains(selected)){
            list.addElement(selected);
        }
        jLtMuseuFundadores.setModel(list);
    }//GEN-LAST:event_jBMuseuAdicionarActionPerformed

    private void jBMuseuRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMuseuRemoverActionPerformed
        int item = jLtMuseuFundadores.getSelectedIndex();
        DefaultListModel<String> list = (DefaultListModel<String>) jLtMuseuFundadores.getModel();
        if (item != -1){
            list.remove(item);
        }
        jLtMuseuFundadores.setModel(list);
    }//GEN-LAST:event_jBMuseuRemoverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBConcluir;
    private javax.swing.JButton jBMuseuAdicionar;
    private javax.swing.JButton jBMuseuRemover;
    private javax.swing.JComboBox<String> jCBCasashowDiafech;
    private javax.swing.JComboBox<String> jCBCasashowEsp;
    private javax.swing.JComboBox<String> jCBCasashowRestaurante;
    private javax.swing.JComboBox<String> jCBCidade;
    private javax.swing.JComboBox<String> jCBMuseuFundadores;
    private javax.swing.JCheckBox jCkBCasashowRestaurante;
    private javax.swing.JLabel jLCasashowDiafech;
    private javax.swing.JLabel jLCasashowEsp;
    private javax.swing.JLabel jLCasashowHrinicio;
    private javax.swing.JLabel jLCasashowPreco;
    private javax.swing.JLabel jLCasashowRestaurante;
    private javax.swing.JLabel jLCidade;
    private javax.swing.JLabel jLDescricao;
    private javax.swing.JLabel jLEndereco;
    private javax.swing.JLabel jLIgrejaData;
    private javax.swing.JLabel jLIgrejaEstilo;
    private javax.swing.JLabel jLInserir;
    private javax.swing.JLabel jLMuseuData;
    private javax.swing.JLabel jLMuseuFundadores;
    private javax.swing.JLabel jLMuseuNrsalas;
    private javax.swing.JLabel jLNome;
    private javax.swing.JLabel jLParqueCapacidade;
    private javax.swing.JLabel jLParqueNratracoes;
    private javax.swing.JLabel jLTipo;
    private javax.swing.JList<String> jLtMuseuFundadores;
    private javax.swing.JPanel jPCasashow;
    private javax.swing.JPanel jPIgreja;
    private javax.swing.JPanel jPMuseu;
    private javax.swing.JPanel jPParque;
    private javax.swing.JPanel jPPturistico;
    private javax.swing.JRadioButton jRBCasaShow;
    private javax.swing.JRadioButton jRBIgreja;
    private javax.swing.JRadioButton jRBMuseu;
    private javax.swing.JRadioButton jRBParque;
    private javax.swing.JScrollPane jSPMuseuFundadores;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTADescricao;
    private javax.swing.JTextField jTFCasashowHrinicio;
    private javax.swing.JTextField jTFCasashowPreco;
    private javax.swing.JTextField jTFEndereco;
    private javax.swing.JTextField jTFIgrejaData;
    private javax.swing.JTextField jTFIgrejaEstilo;
    private javax.swing.JTextField jTFMuseuData;
    private javax.swing.JTextField jTFMuseuNrsalas;
    private javax.swing.JTextField jTFNome;
    private javax.swing.JTextField jTFParqueCapacidade;
    private javax.swing.JTextField jTFParqueNrAtracoes;
    // End of variables declaration//GEN-END:variables
}
