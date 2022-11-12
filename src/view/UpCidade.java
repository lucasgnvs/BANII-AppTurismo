/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.CidadeController;
import javax.swing.JOptionPane;
import model.entity.Cidade;

/**
 *
 * @author User
 */
public class UpCidade extends javax.swing.JPanel {

    /**
     * Creates new form AddCidade
     */
    public UpCidade() {
        initComponents();
    }

    private void loadCidade(){
        getjCBCidades().removeAllItems();
        for(Cidade item: new CidadeController().loadAllCidade()){
            getjCBCidades().addItem(item);
        }
    }
    
    private void toggleEnabled(){
        boolean enabled = !getjTFNome().isEnabled();
        getjTFNome().setEnabled(enabled);
        getjCBEstado().setEnabled(enabled);
        getjTFPopulacao().setEnabled(enabled);
        jBSalvar.setEnabled(enabled);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLNome = new javax.swing.JLabel();
        jLEstado = new javax.swing.JLabel();
        jTFNome = new javax.swing.JTextField();
        jLPopulacao = new javax.swing.JLabel();
        jCBEstado = new javax.swing.JComboBox<>();
        jTFPopulacao = new javax.swing.JTextField();
        jBSalvar = new javax.swing.JButton();
        jBEditar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jCBCidades = new javax.swing.JComboBox<>();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLNome.setText("Nome:");

        jLEstado.setText("Estado:");

        jTFNome.setEnabled(false);

        jLPopulacao.setText("População:");

        jCBEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        jCBEstado.setEnabled(false);

        jTFPopulacao.setEnabled(false);

        jBSalvar.setText("Salvar");
        jBSalvar.setEnabled(false);
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });

        jBEditar.setText("Editar");
        jBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarActionPerformed(evt);
            }
        });

        jBExcluir.setText("Excluir");
        jBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirActionPerformed(evt);
            }
        });

        jCBCidades.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBCidadesItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(269, Short.MAX_VALUE)
                .addComponent(jBSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBEditar)
                .addGap(18, 18, 18)
                .addComponent(jBExcluir)
                .addGap(35, 35, 35))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLNome)
                            .addComponent(jLEstado)
                            .addComponent(jLPopulacao))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFNome)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jCBEstado, 0, 85, Short.MAX_VALUE)
                                    .addComponent(jTFPopulacao))
                                .addGap(0, 370, Short.MAX_VALUE))))
                    .addComponent(jCBCidades, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCBCidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNome)
                    .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLEstado)
                    .addComponent(jCBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLPopulacao)
                    .addComponent(jTFPopulacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBEditar)
                    .addComponent(jBExcluir)
                    .addComponent(jBSalvar))
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        getjCBCidades().removeAllItems();
    }//GEN-LAST:event_formComponentHidden

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        String message = "Dados da cidade atualizados com sucesso!";
        String title = "Sucesso";
        int type = JOptionPane.INFORMATION_MESSAGE;
        try{
            new CidadeController().updateCidade(this);
            jBEditar.setText("Editar");
            toggleEnabled();
        }catch(Exception e){
            message = "Ocorreu um erro ao atualizar os dados da cidade...\n\n" + e.getMessage().split("\n")[0];
            title = "Erro";
            type = JOptionPane.ERROR_MESSAGE;
        }finally{
            JOptionPane.showMessageDialog(null,message,title,type);
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarActionPerformed
        toggleEnabled();
        if(jBEditar.getText() == "Editar"){
            jBEditar.setText("Cancelar");
        }else{
            jBEditar.setText("Editar");
            new CidadeController().showCidade(this);
        }
    }//GEN-LAST:event_jBEditarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        String message = "Confirmar exclusão da cidade";
        String title = "Exclusão";
        int type = JOptionPane.OK_CANCEL_OPTION;
        int response = JOptionPane.showConfirmDialog(null, message, title, type);
        if(response == 0){
            new CidadeController().deleteCidade(this);
            loadCidade();
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        loadCidade();
    }//GEN-LAST:event_formComponentShown

    private void jCBCidadesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBCidadesItemStateChanged
        if(evt.getStateChange() == java.awt.event.ItemEvent.SELECTED){
            if(jBEditar.getText() == "Cancelar"){
                toggleEnabled();
                jBEditar.setText("Editar");
            }
            new CidadeController().showCidade(this);
        }
    }//GEN-LAST:event_jCBCidadesItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBEditar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<Cidade> jCBCidades;
    private javax.swing.JComboBox<String> jCBEstado;
    private javax.swing.JLabel jLEstado;
    private javax.swing.JLabel jLNome;
    private javax.swing.JLabel jLPopulacao;
    private javax.swing.JTextField jTFNome;
    private javax.swing.JTextField jTFPopulacao;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JComboBox<String> getjCBEstado() {
        return jCBEstado;
    }

    public javax.swing.JTextField getjTFPopulacao() {
        return jTFPopulacao;
    }

    public javax.swing.JTextField getjTFNome() {
        return jTFNome;
    }

    public javax.swing.JComboBox<Cidade> getjCBCidades() {
        return jCBCidades;
    }
    
}
