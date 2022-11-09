/*  
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.RestauranteController;
import controller.CidadeController;
import controller.HotelController;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.entity.Cidade;
import model.entity.Restaurante;

/**
 *
 * @author User
 */
public class AddHotel extends javax.swing.JPanel {

    private final ArrayList<Cidade> listCidade;
    private final ArrayList<Restaurante> listRestaurante;
    
    /**
     * Creates new form AddHotel
     */
    public AddHotel() {
        initComponents();
        listCidade = new ArrayList<>();
        listRestaurante = new ArrayList<>();
        jCBCidade.setModel(new DefaultComboBoxModel<>());
        jCBRestaurante.setModel(new DefaultComboBoxModel<>());
    }
    
    private void loadCidade(){
        getListCidade().clear();
        getListCidade().addAll(new CidadeController().loadAllCidade());
        jCBCidade.removeAllItems();
        for(Cidade item: listCidade){
            jCBCidade.addItem(item.toString());
        }
    }
    
    private void loadRestaurante(){
        int index = jCBCidade.getSelectedIndex();
        try{
            Cidade cd = getListCidade().get(index == -1 ? 0 : index);
            getListRestaurante().clear();
            getListRestaurante().addAll( new RestauranteController().loadAllRestaurante(cd));
            jCBRestaurante.removeAllItems();
            for(Restaurante item: getListRestaurante()){
                jCBRestaurante.addItem(item.toString());
            }
        }catch(IndexOutOfBoundsException e){}
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
        jBLimpar = new javax.swing.JButton();
        jLNome = new javax.swing.JLabel();
        jLEndereco = new javax.swing.JLabel();
        jLCategoria = new javax.swing.JLabel();
        jLRestaurante = new javax.swing.JLabel();
        jCBRestaurante = new javax.swing.JComboBox<>();
        jCkBRestaurante = new javax.swing.JCheckBox();
        jLCidade = new javax.swing.JLabel();
        jCBCidade = new javax.swing.JComboBox<>();
        jTFEndereco = new javax.swing.JTextField();
        jTFNome = new javax.swing.JTextField();
        jLCatEstrelas = new javax.swing.JLabel();
        jRBCat1 = new javax.swing.JRadioButton();
        jRBCat2 = new javax.swing.JRadioButton();
        jRBCat5 = new javax.swing.JRadioButton();
        jRBCat4 = new javax.swing.JRadioButton();
        jRBCat3 = new javax.swing.JRadioButton();
        jLQuartos = new javax.swing.JLabel();
        jCkBQuartos1 = new javax.swing.JCheckBox();
        jCkBQuartos2 = new javax.swing.JCheckBox();
        jCkBQuartos3 = new javax.swing.JCheckBox();
        jLValor = new javax.swing.JLabel();
        jLNrquartos = new javax.swing.JLabel();
        jLNrhospedes = new javax.swing.JLabel();
        jTFNrquartos1 = new javax.swing.JTextField();
        jTFNrquartos2 = new javax.swing.JTextField();
        jTFNrquartos3 = new javax.swing.JTextField();
        jTFNrhospedes1 = new javax.swing.JTextField();
        jTFNrhospedes2 = new javax.swing.JTextField();
        jTFNrhospedes3 = new javax.swing.JTextField();
        jTFValor1 = new javax.swing.JTextField();
        jTFValor2 = new javax.swing.JTextField();
        jTFValor3 = new javax.swing.JTextField();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLInserir.setText("Inserir Hotel");

        jBConcluir.setText("Concluir");
        jBConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConcluirActionPerformed(evt);
            }
        });

        jBLimpar.setText("Limpar");
        jBLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimparActionPerformed(evt);
            }
        });

        jLNome.setText("Nome:");

        jLEndereco.setText("Endereço:");

        jLCategoria.setText("Categoria:");

        jLRestaurante.setText("Restaurante:");

        jCBRestaurante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Res 1", "Res 2" }));
        jCBRestaurante.setEnabled(false);

        jCkBRestaurante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCkBRestauranteActionPerformed(evt);
            }
        });

        jLCidade.setText("Cidade:");

        jCBCidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cid 1", "Cid 2" }));
        jCBCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBCidadeActionPerformed(evt);
            }
        });

        jTFEndereco.setToolTipText("Rua, Número, Bairro");

        jLCatEstrelas.setText("estrelas");

        buttonGroup1.add(jRBCat1);
        jRBCat1.setText("1");
        jRBCat1.setActionCommand("1");

        buttonGroup1.add(jRBCat2);
        jRBCat2.setText("2");
        jRBCat2.setActionCommand("2");

        buttonGroup1.add(jRBCat5);
        jRBCat5.setText("5");
        jRBCat5.setActionCommand("5");

        buttonGroup1.add(jRBCat4);
        jRBCat4.setText("4");
        jRBCat4.setActionCommand("4");

        buttonGroup1.add(jRBCat3);
        jRBCat3.setText("3");
        jRBCat3.setActionCommand("3");

        jLQuartos.setText("Quartos:");

        jCkBQuartos1.setText("Simples");
        jCkBQuartos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCkBQuartos1ActionPerformed(evt);
            }
        });

        jCkBQuartos2.setText("Luxo");
        jCkBQuartos2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCkBQuartos2ActionPerformed(evt);
            }
        });

        jCkBQuartos3.setText("Superluxo");
        jCkBQuartos3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCkBQuartos3ActionPerformed(evt);
            }
        });

        jLValor.setText("Preço:");
        jLValor.setToolTipText("Preço do quarto deste tipo");

        jLNrquartos.setText("Quantidade:");
        jLNrquartos.setToolTipText("Número de quartos deste tipo disponíveis");

        jLNrhospedes.setText("Hóspedes:");
        jLNrhospedes.setToolTipText("Número de hóspedes por quarto deste tipo");

        jTFNrquartos1.setEnabled(false);
        jTFNrquartos1.setPreferredSize(new java.awt.Dimension(65, 22));

        jTFNrquartos2.setEnabled(false);
        jTFNrquartos2.setPreferredSize(new java.awt.Dimension(65, 22));

        jTFNrquartos3.setEnabled(false);
        jTFNrquartos3.setPreferredSize(new java.awt.Dimension(65, 22));

        jTFNrhospedes1.setEnabled(false);
        jTFNrhospedes1.setPreferredSize(new java.awt.Dimension(65, 22));

        jTFNrhospedes2.setEnabled(false);
        jTFNrhospedes2.setPreferredSize(new java.awt.Dimension(65, 22));

        jTFNrhospedes3.setEnabled(false);
        jTFNrhospedes3.setPreferredSize(new java.awt.Dimension(65, 22));

        jTFValor1.setEnabled(false);
        jTFValor1.setPreferredSize(new java.awt.Dimension(65, 22));

        jTFValor2.setEnabled(false);
        jTFValor2.setPreferredSize(new java.awt.Dimension(65, 22));

        jTFValor3.setEnabled(false);
        jTFValor3.setPreferredSize(new java.awt.Dimension(65, 22));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBConcluir)
                .addGap(95, 95, 95))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLQuartos)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(jCkBQuartos1)
                                .addGap(27, 27, 27)
                                .addComponent(jCkBQuartos2)
                                .addGap(47, 47, 47)
                                .addComponent(jCkBQuartos3)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLRestaurante)
                            .addComponent(jLCidade)
                            .addComponent(jLCategoria)
                            .addComponent(jLEndereco)
                            .addComponent(jLNome)
                            .addComponent(jLInserir)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLValor)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(22, 22, 22)
                                            .addComponent(jLNrhospedes))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGap(16, 16, 16)
                                            .addComponent(jLNrquartos))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jCBCidade, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTFNome, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTFEndereco, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jRBCat1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jRBCat2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jRBCat3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jRBCat4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jRBCat5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLCatEstrelas)
                                            .addGap(0, 74, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jCBRestaurante, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jCkBRestaurante)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jTFNrhospedes1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jTFValor1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(jTFNrquartos1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(30, 30, 30)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jTFNrhospedes2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTFValor2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTFNrquartos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(32, 32, 32)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jTFNrhospedes3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTFNrquartos3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTFValor3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(26, 26, 26)))))
                        .addGap(95, 95, 95))))
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCidade)
                    .addComponent(jCBCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLEndereco)
                    .addComponent(jTFEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCategoria)
                    .addComponent(jLCatEstrelas)
                    .addComponent(jRBCat1)
                    .addComponent(jRBCat2)
                    .addComponent(jRBCat3)
                    .addComponent(jRBCat4)
                    .addComponent(jRBCat5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCkBRestaurante, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLRestaurante)
                        .addComponent(jCBRestaurante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCkBQuartos1)
                    .addComponent(jCkBQuartos3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLQuartos)
                        .addComponent(jCkBQuartos2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLNrquartos)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTFNrquartos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTFNrquartos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTFNrquartos3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNrhospedes)
                    .addComponent(jTFNrhospedes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFNrhospedes2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFNrhospedes3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLValor)
                    .addComponent(jTFValor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFValor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFValor3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBConcluir)
                    .addComponent(jBLimpar))
                .addGap(130, 130, 130))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jCkBRestauranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCkBRestauranteActionPerformed
        boolean value = getjCBRestaurante().isEnabled();
        try{
            getjCBRestaurante().setSelectedIndex(0);
        }catch(IllegalArgumentException e){}
        getjCBRestaurante().setEnabled(!value);
    }//GEN-LAST:event_jCkBRestauranteActionPerformed

    private void jBLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimparActionPerformed
        getjTFNome().setText("");
        getjTFEndereco().setText("");
        getButtonGroup1().clearSelection();
        getjCkBRestaurante().setSelected(false);
        getjCBRestaurante().setEnabled(false);
        getjCkBQuartos1().setSelected(false);
        getjTFNrquartos1().setText("");
        getjTFNrquartos1().setEnabled(false);
        getjTFNrhospedes1().setText("");
        getjTFNrhospedes1().setEnabled(false);
        getjTFValor1().setText("");
        getjTFValor1().setEnabled(false);
        getjCkBQuartos2().setSelected(false);
        getjTFNrquartos2().setText("");
        getjTFNrquartos2().setEnabled(false);
        getjTFNrhospedes2().setText("");
        getjTFNrhospedes2().setEnabled(false);
        getjTFValor2().setText("");
        getjTFValor2().setEnabled(false);
        getjCkBQuartos3().setSelected(false);
        getjTFNrquartos3().setText("");
        getjTFNrquartos3().setEnabled(false);
        getjTFNrhospedes3().setText("");
        getjTFNrhospedes3().setEnabled(false);
        getjTFValor3().setText("");
        getjTFValor3().setEnabled(false);
        try{
            getjCBCidade().setSelectedIndex(0);
            getjCBRestaurante().setSelectedIndex(0);
        }catch(IllegalArgumentException e){}
    }//GEN-LAST:event_jBLimparActionPerformed

    private void jBConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConcluirActionPerformed
        String message = "Hotel inserido com sucesso!";
        String title = "Sucesso";
        int type = JOptionPane.INFORMATION_MESSAGE;
        try{
            new HotelController().addHotel(this);
        }catch(Exception e){
            message = "Ocorreu um erro ao inserir o hotel...\n\n" + e.getMessage().split("\n")[0];
            title = "Erro";
            type = JOptionPane.ERROR_MESSAGE;
            e.printStackTrace();
        }finally{
            JOptionPane.showMessageDialog(null,message,title,type);
        }
    }//GEN-LAST:event_jBConcluirActionPerformed

    private void jCkBQuartos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCkBQuartos1ActionPerformed
        boolean value = getjTFNrquartos1().isEnabled();
        getjTFNrquartos1().setText("");
        getjTFNrquartos1().setEnabled(!value);
        getjTFNrhospedes1().setText("");
        getjTFNrhospedes1().setEnabled(!value);
        getjTFValor1().setText("");
        getjTFValor1().setEnabled(!value);
    }//GEN-LAST:event_jCkBQuartos1ActionPerformed

    private void jCkBQuartos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCkBQuartos2ActionPerformed
        boolean value = getjTFNrquartos2().isEnabled();
        getjTFNrquartos2().setText("");
        getjTFNrquartos2().setEnabled(!value);
        getjTFNrhospedes2().setText("");
        getjTFNrhospedes2().setEnabled(!value);
        getjTFValor2().setText("");
        getjTFValor2().setEnabled(!value);
    }//GEN-LAST:event_jCkBQuartos2ActionPerformed

    private void jCkBQuartos3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCkBQuartos3ActionPerformed
        boolean value = getjTFNrquartos3().isEnabled();
        getjTFNrquartos3().setText("");
        getjTFNrquartos3().setEnabled(!value);
        getjTFNrhospedes3().setText("");
        getjTFNrhospedes3().setEnabled(!value);
        getjTFValor3().setText("");
        getjTFValor3().setEnabled(!value);
    }//GEN-LAST:event_jCkBQuartos3ActionPerformed

    private void jCBCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBCidadeActionPerformed
        if(getjCkBRestaurante().isSelected()){
            getjCkBRestaurante().doClick();
        }
        loadRestaurante();
        getjCkBRestaurante().setEnabled(!getListRestaurante().isEmpty());
    }//GEN-LAST:event_jCBCidadeActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        loadCidade();
    }//GEN-LAST:event_formComponentShown

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        getListCidade().clear();
        getListRestaurante().clear();
        jBLimpar.doClick();
    }//GEN-LAST:event_formComponentHidden


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBConcluir;
    private javax.swing.JButton jBLimpar;
    private javax.swing.JComboBox<String> jCBCidade;
    private javax.swing.JComboBox<String> jCBRestaurante;
    private javax.swing.JCheckBox jCkBQuartos1;
    private javax.swing.JCheckBox jCkBQuartos2;
    private javax.swing.JCheckBox jCkBQuartos3;
    private javax.swing.JCheckBox jCkBRestaurante;
    private javax.swing.JLabel jLCatEstrelas;
    private javax.swing.JLabel jLCategoria;
    private javax.swing.JLabel jLCidade;
    private javax.swing.JLabel jLEndereco;
    private javax.swing.JLabel jLInserir;
    private javax.swing.JLabel jLNome;
    private javax.swing.JLabel jLNrhospedes;
    private javax.swing.JLabel jLNrquartos;
    private javax.swing.JLabel jLQuartos;
    private javax.swing.JLabel jLRestaurante;
    private javax.swing.JLabel jLValor;
    private javax.swing.JRadioButton jRBCat1;
    private javax.swing.JRadioButton jRBCat2;
    private javax.swing.JRadioButton jRBCat3;
    private javax.swing.JRadioButton jRBCat4;
    private javax.swing.JRadioButton jRBCat5;
    private javax.swing.JTextField jTFEndereco;
    private javax.swing.JTextField jTFNome;
    private javax.swing.JTextField jTFNrhospedes1;
    private javax.swing.JTextField jTFNrhospedes2;
    private javax.swing.JTextField jTFNrhospedes3;
    private javax.swing.JTextField jTFNrquartos1;
    private javax.swing.JTextField jTFNrquartos2;
    private javax.swing.JTextField jTFNrquartos3;
    private javax.swing.JTextField jTFValor1;
    private javax.swing.JTextField jTFValor2;
    private javax.swing.JTextField jTFValor3;
    // End of variables declaration//GEN-END:variables

    public javax.swing.ButtonGroup getButtonGroup1() {
        return buttonGroup1;
    }

    public javax.swing.JComboBox<String> getjCBCidade() {
        return jCBCidade;
    }

    public javax.swing.JComboBox<String> getjCBRestaurante() {
        return jCBRestaurante;
    }

    public javax.swing.JTextField getjTFEndereco() {
        return jTFEndereco;
    }

    public javax.swing.JTextField getjTFNome() {
        return jTFNome;
    }

    public javax.swing.JCheckBox getjCkBRestaurante() {
        return jCkBRestaurante;
    }
    
    public ArrayList<Cidade> getListCidade() {
        return listCidade;
    }
    
    public ArrayList<Restaurante> getListRestaurante() {
        return listRestaurante;
    }

    public javax.swing.JCheckBox getjCkBQuartos1() {
        return jCkBQuartos1;
    }

    public javax.swing.JCheckBox getjCkBQuartos2() {
        return jCkBQuartos2;
    }

    public javax.swing.JCheckBox getjCkBQuartos3() {
        return jCkBQuartos3;
    }
    
    public javax.swing.JTextField getjTFNrhospedes1() {
        return jTFNrhospedes1;
    }

    public javax.swing.JTextField getjTFNrhospedes2() {
        return jTFNrhospedes2;
    }

    public javax.swing.JTextField getjTFNrhospedes3() {
        return jTFNrhospedes3;
    }

    public javax.swing.JTextField getjTFNrquartos1() {
        return jTFNrquartos1;
    }

    public javax.swing.JTextField getjTFNrquartos2() {
        return jTFNrquartos2;
    }

    public javax.swing.JTextField getjTFNrquartos3() {
        return jTFNrquartos3;
    }

    public javax.swing.JTextField getjTFValor1() {
        return jTFValor1;
    }

    public javax.swing.JTextField getjTFValor2() {
        return jTFValor2;
    }

    public javax.swing.JTextField getjTFValor3() {
        return jTFValor3;
    }
    
}
