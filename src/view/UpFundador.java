/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.FundadorController;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import model.entity.Fundador;

/**
 *
 * @author User
 */
public class UpFundador extends javax.swing.JPanel {

    /**
     * Creates new form AddFundador
     */
    public UpFundador() {
        initComponents();
    }
    
    private void loadFundador(){
        getjCBFundadores().removeAllItems();
        for(Fundador item: new FundadorController().loadAllFundador()){
            getjCBFundadores().addItem(item);
        }
    }
    
    private void toggleEnabled(){
        boolean enabled = !getjTFNome().isEnabled();
        getjTFNome().setEnabled(enabled);
        getjTFDtnasc().setEnabled(enabled);
        getjCkBMorte().setEnabled(enabled);
        if(getjCkBMorte().isSelected()){
            getjTFDtmorte().setEnabled(enabled);
        }
        getjTFNacionalidade().setEnabled(enabled);
        getjTFAtivprof().setEnabled(enabled);
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
        jLDtnasc = new javax.swing.JLabel();
        jLDtmorte = new javax.swing.JLabel();
        jLAtivprof = new javax.swing.JLabel();
        jLNacionalidade = new javax.swing.JLabel();
        jTFNome = new javax.swing.JTextField();
        jTFDtnasc = new javax.swing.JTextField();
        jTFDtmorte = new javax.swing.JTextField();
        jTFNacionalidade = new javax.swing.JTextField();
        jTFAtivprof = new javax.swing.JTextField();
        jCkBMorte = new javax.swing.JCheckBox();
        jCBFundadores = new javax.swing.JComboBox<>();
        jBSalvar = new javax.swing.JButton();
        jBEditar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLNome.setText("Nome Completo:");

        jLDtnasc.setText("Data de Nascimento:");

        jLDtmorte.setText("Data de Falecimento:");

        jLAtivprof.setText("Atividade Profissional:");

        jLNacionalidade.setText("Nacionalidade:");

        jTFNome.setEnabled(false);

        jTFDtnasc.setToolTipText("dd/mm/aaaa");
        jTFDtnasc.setEnabled(false);

        jTFDtmorte.setToolTipText("dd/mm/aaaa");
        jTFDtmorte.setEnabled(false);

        jTFNacionalidade.setToolTipText("Tr??s letras do pa??s, como BRA.");
        jTFNacionalidade.setEnabled(false);

        jTFAtivprof.setEnabled(false);

        jCkBMorte.setEnabled(false);
        jCkBMorte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCkBMorteActionPerformed(evt);
            }
        });

        jCBFundadores.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBFundadoresItemStateChanged(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBEditar)
                .addGap(18, 18, 18)
                .addComponent(jBExcluir)
                .addGap(35, 35, 35))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBFundadores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLNome)
                            .addComponent(jLDtmorte)
                            .addComponent(jLDtnasc)
                            .addComponent(jLNacionalidade)
                            .addComponent(jLAtivprof))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFNome, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                            .addComponent(jTFAtivprof, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTFNacionalidade, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFDtnasc, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFDtmorte, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jCkBMorte)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCBFundadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLNome))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFDtnasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLDtnasc))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCkBMorte, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTFDtmorte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLDtmorte)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLNacionalidade))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFAtivprof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLAtivprof))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBEditar)
                    .addComponent(jBExcluir)
                    .addComponent(jBSalvar))
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jCkBMorteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCkBMorteActionPerformed
        boolean value = getjTFDtmorte().isEnabled();
        getjTFDtmorte().setText("");
        getjTFDtmorte().setEnabled(!value);
    }//GEN-LAST:event_jCkBMorteActionPerformed

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        getjCBFundadores().removeAllItems();
    }//GEN-LAST:event_formComponentHidden

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        String message = "Dados do fundador atualizados com sucesso!";
        String title = "Sucesso";
        int type = JOptionPane.INFORMATION_MESSAGE;
        try{
            new FundadorController().updateFundador(this);
            jBEditar.setText("Editar");
            toggleEnabled();
        }catch(DateTimeParseException e){
            message = "O formato da data est?? incorreto. (dd/mm/aaaa)";
            title = "Erro";
            type = JOptionPane.ERROR_MESSAGE;
        }catch(Exception e){
            message = "Ocorreu um erro ao atualizar os dados do fundador...\n\n" + e.getMessage().split("\n")[0];
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
            new FundadorController().showFundador(this);
        }
    }//GEN-LAST:event_jBEditarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        String message = "Confirmar exclus??o do fundador";
        String title = "Exclus??o";
        int type = JOptionPane.OK_CANCEL_OPTION;
        int response = JOptionPane.showConfirmDialog(null, message, title, type);
        if(response == 0){
            new FundadorController().deleteFundador(this);
            loadFundador();
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        loadFundador();
    }//GEN-LAST:event_formComponentShown

    private void jCBFundadoresItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBFundadoresItemStateChanged
        if(evt.getStateChange() == java.awt.event.ItemEvent.SELECTED){
            if(jBEditar.getText() == "Cancelar"){
                toggleEnabled();
                jBEditar.setText("Editar");
            }
            new FundadorController().showFundador(this);
        }
    }//GEN-LAST:event_jCBFundadoresItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBEditar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<Fundador> jCBFundadores;
    private javax.swing.JCheckBox jCkBMorte;
    private javax.swing.JLabel jLAtivprof;
    private javax.swing.JLabel jLDtmorte;
    private javax.swing.JLabel jLDtnasc;
    private javax.swing.JLabel jLNacionalidade;
    private javax.swing.JLabel jLNome;
    private javax.swing.JTextField jTFAtivprof;
    private javax.swing.JTextField jTFDtmorte;
    private javax.swing.JTextField jTFDtnasc;
    private javax.swing.JTextField jTFNacionalidade;
    private javax.swing.JTextField jTFNome;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JTextField getjTFAtivprof() {
        return jTFAtivprof;
    }

    public javax.swing.JTextField getjTFDtmorte() {
        return jTFDtmorte;
    }

    public javax.swing.JTextField getjTFDtnasc() {
        return jTFDtnasc;
    }

    public javax.swing.JTextField getjTFNacionalidade() {
        return jTFNacionalidade;
    }

    public javax.swing.JTextField getjTFNome() {
        return jTFNome;
    }

    public javax.swing.JCheckBox getjCkBMorte() {
        return jCkBMorte;
    }

    public javax.swing.JComboBox<Fundador> getjCBFundadores() {
        return jCBFundadores;
    }
}
