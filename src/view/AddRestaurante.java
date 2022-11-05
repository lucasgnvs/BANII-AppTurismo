/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.CidadeController;
import controller.RestauranteController;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.entity.Cidade;

/**
 *
 * @author User
 */
public class AddRestaurante extends javax.swing.JPanel {

    private ArrayList<Cidade> listCidade;
    
    /**
     * Creates new form AddRestaurante
     */
    public AddRestaurante() {
        initComponents();
        loadCidade();
    }
    
    private void loadCidade(){
        listCidade = new CidadeController().loadAllCidade();
        jCBCidade.removeAllItems();
        for(Cidade item: listCidade){
            jCBCidade.addItem(item.toString());
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLInserir = new javax.swing.JLabel();
        jLNome = new javax.swing.JLabel();
        jLCategoria = new javax.swing.JLabel();
        jLEndereco = new javax.swing.JLabel();
        jLCidade = new javax.swing.JLabel();
        jTFNome = new javax.swing.JTextField();
        jRBCat1 = new javax.swing.JRadioButton();
        jTFEndereco = new javax.swing.JTextField();
        jCBCidade = new javax.swing.JComboBox<>();
        jRBCat2 = new javax.swing.JRadioButton();
        jBConcluir = new javax.swing.JButton();
        jBLimpar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(544, 480));

        jLInserir.setText("Inserir Restaurante");

        jLNome.setText("Nome:");

        jLCategoria.setText("Categoria:");

        jLEndereco.setText("Endereço:");

        jLCidade.setText("Cidade:");

        buttonGroup1.add(jRBCat1);
        jRBCat1.setText("Simples");
        jRBCat1.setActionCommand("1");

        jTFEndereco.setToolTipText("Rua, Número, Bairro");

        jCBCidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cid 1", "Cid 2", "Cid 3", "Cid 4" }));

        buttonGroup1.add(jRBCat2);
        jRBCat2.setText("Luxo");
        jRBCat2.setActionCommand("2");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLCategoria)
                                    .addComponent(jLEndereco)
                                    .addComponent(jLNome)
                                    .addComponent(jLCidade))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRBCat1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRBCat2)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jCBCidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTFNome)
                                    .addComponent(jTFEndereco)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLInserir)
                                .addGap(92, 92, 92))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(290, Short.MAX_VALUE)
                        .addComponent(jBLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                    .addComponent(jRBCat1)
                    .addComponent(jRBCat2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBConcluir)
                    .addComponent(jBLimpar))
                .addGap(130, 130, 130))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConcluirActionPerformed
        String message = "Restaurante inserido com sucesso!";
        String title = "Sucesso";
        int type = JOptionPane.INFORMATION_MESSAGE;
        try{
            new RestauranteController().addRestaurante(this);
        }catch(Exception e){
            message = "Ocorreu um erro ao inserir o restaurante...\n\n" + e.getMessage().split("\n")[0];
            title = "Erro";
            type = JOptionPane.ERROR_MESSAGE;
        }finally{
            JOptionPane.showMessageDialog(null,message,title,type);
        }
    }//GEN-LAST:event_jBConcluirActionPerformed

    private void jBLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimparActionPerformed
        getjTFNome().setText("");
        getjTFEndereco().setText("");
        getjCBCidade().setSelectedIndex(0);
        getButtonGroup1().clearSelection();
    }//GEN-LAST:event_jBLimparActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBConcluir;
    private javax.swing.JButton jBLimpar;
    private javax.swing.JComboBox<String> jCBCidade;
    private javax.swing.JLabel jLCategoria;
    private javax.swing.JLabel jLCidade;
    private javax.swing.JLabel jLEndereco;
    private javax.swing.JLabel jLInserir;
    private javax.swing.JLabel jLNome;
    private javax.swing.JRadioButton jRBCat1;
    private javax.swing.JRadioButton jRBCat2;
    private javax.swing.JTextField jTFEndereco;
    private javax.swing.JTextField jTFNome;
    // End of variables declaration//GEN-END:variables

    public javax.swing.ButtonGroup getButtonGroup1() {
        return buttonGroup1;
    }

    public javax.swing.JComboBox<String> getjCBCidade() {
        return jCBCidade;
    }

    public javax.swing.JTextField getjTFEndereco() {
        return jTFEndereco;
    }

    public javax.swing.JTextField getjTFNome() {
        return jTFNome;
    }

    public ArrayList<Cidade> getListCidade() {
        return listCidade;
    }
}
