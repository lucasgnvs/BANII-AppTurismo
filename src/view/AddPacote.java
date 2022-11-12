/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.CidadeController;
import controller.HotelController;
import controller.RestauranteController;
import controller.CasaShowController;
import controller.IgrejaController;
import controller.MuseuController;
import controller.ParqueController;
import controller.PacoteController;
import controller.AtracaoInclusaController;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.entity.Cidade;
import model.entity.Hotel;
import model.entity.Restaurante;
import model.entity.CasaShow;
import model.entity.Igreja;
import model.entity.Museu;
import model.entity.Parque;
import model.entity.AtracaoTuristica;
import model.entity.AtracaoInclusa;

/**
 *
 * @author User
 */
public class AddPacote extends javax.swing.JPanel {

    private final ArrayList<Hotel> listHotel;
    private final ArrayList<Restaurante> listRestaurante;
    private final ArrayList<CasaShow> listCasaShow;
    private final ArrayList<Igreja> listIgreja;
    private final ArrayList<Museu> listMuseu;
    private final ArrayList<Parque> listParque;

    /**
     * Creates new form AddPacote
     */
    public AddPacote() {
        initComponents();
        listHotel = new ArrayList<>();
        listRestaurante = new ArrayList<>();
        listCasaShow = new ArrayList<>();
        listIgreja = new ArrayList<>();
        listMuseu = new ArrayList<>();
        listParque = new ArrayList<>();
        jCBCidade.setModel(new DefaultComboBoxModel<>());
    }
    
    private void loadCidade(){
        getjCBCidade().removeAllItems();
        for(Cidade item: new CidadeController().loadAllCidade()){
            getjCBCidade().addItem(item);
        }
    }

    private void loadHotel(){
        int index = getjCBCidade().getSelectedIndex();
        Cidade cd = new CidadeController().loadAllCidade().get(index == -1 ? 0 : index);
        getListHotel().clear();
        getListHotel().addAll(new HotelController().loadAllHotel(cd));
    }
    
    private void loadRestaurante(){
        int index = getjCBCidade().getSelectedIndex();
        Cidade cd = new CidadeController().loadAllCidade().get(index == -1 ? 0 : index);
        getListRestaurante().clear();
        getListRestaurante().addAll(new RestauranteController().loadAllRestaurante(cd));
    }
    
    private void loadCasaShow(){
        int index = getjCBCidade().getSelectedIndex();
        Cidade cd = new CidadeController().loadAllCidade().get(index == -1 ? 0 : index);
        getListCasaShow().clear();
        getListCasaShow().addAll(new CasaShowController().loadAllCasaShow(cd));
    }
    
    private void loadIgreja(){
        int index = getjCBCidade().getSelectedIndex();
        Cidade cd = new CidadeController().loadAllCidade().get(index == -1 ? 0 : index);
        getListIgreja().clear();
        getListIgreja().addAll(new IgrejaController().loadAllIgreja(cd));
    }
    
    private void loadMuseu(){
        int index = getjCBCidade().getSelectedIndex();
        Cidade cd = new CidadeController().loadAllCidade().get(index == -1 ? 0 : index);
        getListMuseu().clear();
        getListMuseu().addAll(new MuseuController().loadAllMuseu(cd));
    }
    
    private void loadParque(){
        int index = getjCBCidade().getSelectedIndex();
        Cidade cd = new CidadeController().loadAllCidade().get(index == -1 ? 0 : index);
        getListParque().clear();
        getListParque().addAll(new ParqueController().loadAllParque(cd));
    }
    
    private void updateCB(ArrayList<?> list){
        getjCBAtracoes().removeAllItems();
        for(Object item : list){
            getjCBAtracoes().addItem((AtracaoTuristica)item);
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
        jTFNome = new javax.swing.JTextField();
        jBConcluir = new javax.swing.JButton();
        jLValor = new javax.swing.JLabel();
        jLDtinicio = new javax.swing.JLabel();
        jLCidade = new javax.swing.JLabel();
        jTFDtinicio = new javax.swing.JTextField();
        jTFDtfim = new javax.swing.JTextField();
        jLDtfim = new javax.swing.JLabel();
        jLDisp = new javax.swing.JLabel();
        jTFValor = new javax.swing.JTextField();
        jTFDisp = new javax.swing.JTextField();
        jCBCidade = new javax.swing.JComboBox<>();
        jLAtracoes = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLData = new javax.swing.JLabel();
        jLTipo = new javax.swing.JLabel();
        jTFData = new javax.swing.JTextField();
        jRBTipoHotel = new javax.swing.JRadioButton();
        jCBAtracoes = new javax.swing.JComboBox<AtracaoTuristica>();
        jBAdicionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLtAtracoes = new javax.swing.JList(new javax.swing.DefaultListModel<AtracaoInclusa>());
        jBRemover = new javax.swing.JButton();
        jRBTipoRestaurante = new javax.swing.JRadioButton();
        jRBTipoCasashow = new javax.swing.JRadioButton();
        jRBTipoIgreja = new javax.swing.JRadioButton();
        jRBTipoMuseu = new javax.swing.JRadioButton();
        jRBTipoParque = new javax.swing.JRadioButton();
        jBLimpar = new javax.swing.JButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLInserir.setText("Inserir Pacote");

        jLNome.setText("Nome:");

        jBConcluir.setText("Concluir");
        jBConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConcluirActionPerformed(evt);
            }
        });

        jLValor.setText("Preço:");

        jLDtinicio.setText("Data início:");

        jLCidade.setText("Cidade:");

        jLDtfim.setText("Data fim:");

        jLDisp.setText("Vagas:");

        jCBCidade.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBCidadeItemStateChanged(evt);
            }
        });

        jLAtracoes.setText("Atrações:");

        jLData.setText("Data:");

        jLTipo.setText("Tipo:");

        jTFData.setToolTipText("dd/mm/aaaa");
        jTFData.setPreferredSize(new java.awt.Dimension(65, 22));
        jTFData.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTFDataCaretUpdate(evt);
            }
        });

        buttonGroup1.add(jRBTipoHotel);
        jRBTipoHotel.setSelected(true);
        jRBTipoHotel.setText("Hotel");
        jRBTipoHotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBTipoHotelActionPerformed(evt);
            }
        });

        jBAdicionar.setText("Adicionar");
        jBAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAdicionarActionPerformed(evt);
            }
        });

        jLtAtracoes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jLtAtracoes);
        jLtAtracoes.getAccessibleContext().setAccessibleName("");

        jBRemover.setText("Remover");
        jBRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoverActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRBTipoRestaurante);
        jRBTipoRestaurante.setText("Restaurante");
        jRBTipoRestaurante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBTipoRestauranteActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRBTipoCasashow);
        jRBTipoCasashow.setText("Casa de Show");
        jRBTipoCasashow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBTipoCasashowActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRBTipoIgreja);
        jRBTipoIgreja.setText("Igreja");
        jRBTipoIgreja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBTipoIgrejaActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRBTipoMuseu);
        jRBTipoMuseu.setText("Museu");
        jRBTipoMuseu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBTipoMuseuActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRBTipoParque);
        jRBTipoParque.setText("Parque");
        jRBTipoParque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBTipoParqueActionPerformed(evt);
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
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLNome)
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBCidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTFNome)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLCidade, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLInserir, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLDtinicio)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTFValor, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                    .addComponent(jTFDtinicio)))
                            .addComponent(jLValor))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLDtfim)
                            .addComponent(jLDisp))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFDtfim, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFDisp, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLAtracoes)
                                    .addComponent(jLData)
                                    .addComponent(jTFData, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1)
                                    .addComponent(jCBAtracoes, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLTipo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRBTipoHotel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRBTipoRestaurante)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRBTipoCasashow)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRBTipoIgreja)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRBTipoMuseu)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRBTipoParque))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jBLimpar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBAdicionar)
                            .addComponent(jBRemover)
                            .addComponent(jBConcluir, javax.swing.GroupLayout.Alignment.TRAILING))))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCidade)
                    .addComponent(jCBCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLDtinicio)
                    .addComponent(jTFDtinicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFDtfim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLDtfim))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLValor)
                    .addComponent(jLDisp)
                    .addComponent(jTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFDisp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLAtracoes)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTipo)
                    .addComponent(jLData)
                    .addComponent(jRBTipoHotel)
                    .addComponent(jRBTipoRestaurante)
                    .addComponent(jRBTipoCasashow)
                    .addComponent(jRBTipoIgreja)
                    .addComponent(jRBTipoMuseu)
                    .addComponent(jRBTipoParque))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBAtracoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBAdicionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBRemover)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBConcluir)
                    .addComponent(jBLimpar))
                .addGap(130, 130, 130))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConcluirActionPerformed
        String message = "Pacote inserido com sucesso!";
        String title = "Sucesso";
        int type = JOptionPane.INFORMATION_MESSAGE;
        try{
            new PacoteController().addPacote(this);
        }catch(Exception e){
            message = "Ocorreu um erro ao inserir o pacote...\n\n" + e.getMessage().split("\n")[0];
            title = "Erro";
            type = JOptionPane.ERROR_MESSAGE;
            e.printStackTrace();
        }finally{
            JOptionPane.showMessageDialog(null,message,title,type);
        }
    }//GEN-LAST:event_jBConcluirActionPerformed

    private void jBAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAdicionarActionPerformed
        try{
            new AtracaoInclusaController().addAtracao(this);
            getjTFData().setText("");
        }catch(DateTimeParseException e){
            JOptionPane.showMessageDialog(null,"O formato da data está incorreto. (dd/mm/aaaa)","Erro",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBAdicionarActionPerformed

    private void jBRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoverActionPerformed
        new AtracaoInclusaController().removeAtracao(this);
    }//GEN-LAST:event_jBRemoverActionPerformed

    private void jRBTipoHotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBTipoHotelActionPerformed
        updateCB(getListHotel());
        boolean enable = !getListHotel().isEmpty();
        jBAdicionar.setEnabled(enable && !getjTFData().getText().isBlank());
        getjCBAtracoes().setEnabled(enable);
    }//GEN-LAST:event_jRBTipoHotelActionPerformed

    private void jRBTipoRestauranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBTipoRestauranteActionPerformed
        updateCB(getListRestaurante());
        boolean enable = !getListRestaurante().isEmpty();
        jBAdicionar.setEnabled(enable && !getjTFData().getText().isBlank());
        getjCBAtracoes().setEnabled(enable);
    }//GEN-LAST:event_jRBTipoRestauranteActionPerformed

    private void jRBTipoCasashowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBTipoCasashowActionPerformed
        updateCB(getListCasaShow());
        boolean enable = !getListCasaShow().isEmpty();
        jBAdicionar.setEnabled(enable && !getjTFData().getText().isBlank());
        getjCBAtracoes().setEnabled(enable);
    }//GEN-LAST:event_jRBTipoCasashowActionPerformed

    private void jRBTipoIgrejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBTipoIgrejaActionPerformed
        updateCB(getListIgreja());
        boolean enable = !getListIgreja().isEmpty();
        jBAdicionar.setEnabled(enable && !getjTFData().getText().isBlank());
        getjCBAtracoes().setEnabled(enable);
    }//GEN-LAST:event_jRBTipoIgrejaActionPerformed

    private void jRBTipoMuseuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBTipoMuseuActionPerformed
        updateCB(getListMuseu());
        boolean enable = !getListMuseu().isEmpty();
        jBAdicionar.setEnabled(enable && !getjTFData().getText().isBlank());
        getjCBAtracoes().setEnabled(enable);
    }//GEN-LAST:event_jRBTipoMuseuActionPerformed

    private void jRBTipoParqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBTipoParqueActionPerformed
        updateCB(getListParque());
        boolean enable = !getListParque().isEmpty();
        jBAdicionar.setEnabled(enable && !getjTFData().getText().isBlank());
        getjCBAtracoes().setEnabled(enable);
    }//GEN-LAST:event_jRBTipoParqueActionPerformed

    private void jTFDataCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTFDataCaretUpdate
        jBAdicionar.setEnabled(getjCBAtracoes().isEnabled() && !getjTFData().getText().isBlank());
    }//GEN-LAST:event_jTFDataCaretUpdate

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        loadCidade();
        jRBTipoHotel.doClick();
    }//GEN-LAST:event_formComponentShown

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        getjCBCidade().removeAllItems();
        getListHotel().clear();
        getListRestaurante().clear();
        getListCasaShow().clear();
        getListIgreja().clear();
        getListMuseu().clear();
        getListParque().clear();
    }//GEN-LAST:event_formComponentHidden

    private void jBLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimparActionPerformed
        getjTFNome().setText("");
        getjTFDtinicio().setText("");
        getjTFDtfim().setText("");
        getjTFValor().setText("");
        getjTFDisp().setText("");
        jRBTipoHotel.setSelected(true);
        getjTFData().setText("");
        getjLtAtracoes().setModel(new DefaultListModel<>());
        try{
            getjCBCidade().setSelectedIndex(0);
        }catch(IllegalArgumentException e){}
        try{
            getjCBAtracoes().setSelectedIndex(0);
        }catch(IllegalArgumentException e){}
    }//GEN-LAST:event_jBLimparActionPerformed

    private void jCBCidadeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBCidadeItemStateChanged
        if(evt.getStateChange() == java.awt.event.ItemEvent.SELECTED){
            getjLtAtracoes().setModel(new DefaultListModel<>());
            loadHotel();
            loadRestaurante();
            loadCasaShow();
            loadIgreja();
            loadMuseu();
            loadParque();
            jRBTipoHotel.doClick();
        }
    }//GEN-LAST:event_jCBCidadeItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBAdicionar;
    private javax.swing.JButton jBConcluir;
    private javax.swing.JButton jBLimpar;
    private javax.swing.JButton jBRemover;
    private javax.swing.JComboBox<AtracaoTuristica> jCBAtracoes;
    private javax.swing.JComboBox<Cidade> jCBCidade;
    private javax.swing.JLabel jLAtracoes;
    private javax.swing.JLabel jLCidade;
    private javax.swing.JLabel jLData;
    private javax.swing.JLabel jLDisp;
    private javax.swing.JLabel jLDtfim;
    private javax.swing.JLabel jLDtinicio;
    private javax.swing.JLabel jLInserir;
    private javax.swing.JLabel jLNome;
    private javax.swing.JLabel jLTipo;
    private javax.swing.JLabel jLValor;
    private javax.swing.JList<AtracaoInclusa> jLtAtracoes;
    private javax.swing.JRadioButton jRBTipoCasashow;
    private javax.swing.JRadioButton jRBTipoHotel;
    private javax.swing.JRadioButton jRBTipoIgreja;
    private javax.swing.JRadioButton jRBTipoMuseu;
    private javax.swing.JRadioButton jRBTipoParque;
    private javax.swing.JRadioButton jRBTipoRestaurante;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTFData;
    private javax.swing.JTextField jTFDisp;
    private javax.swing.JTextField jTFDtfim;
    private javax.swing.JTextField jTFDtinicio;
    private javax.swing.JTextField jTFNome;
    private javax.swing.JTextField jTFValor;
    // End of variables declaration//GEN-END:variables

    public ArrayList<Hotel> getListHotel() {
        return listHotel;
    }

    public ArrayList<Restaurante> getListRestaurante() {
        return listRestaurante;
    }

    public ArrayList<CasaShow> getListCasaShow() {
        return listCasaShow;
    }

    public ArrayList<Igreja> getListIgreja() {
        return listIgreja;
    }

    public ArrayList<Museu> getListMuseu() {
        return listMuseu;
    }

    public ArrayList<Parque> getListParque() {
        return listParque;
    }

    public javax.swing.JComboBox<Cidade> getjCBCidade() {
        return jCBCidade;
    }

    public javax.swing.JList<AtracaoInclusa> getjLtAtracoes() {
        return jLtAtracoes;
    }

    public javax.swing.JTextField getjTFData() {
        return jTFData;
    }

    public javax.swing.JTextField getjTFDisp() {
        return jTFDisp;
    }

    public javax.swing.JTextField getjTFDtfim() {
        return jTFDtfim;
    }

    public javax.swing.JTextField getjTFDtinicio() {
        return jTFDtinicio;
    }

    public javax.swing.JTextField getjTFNome() {
        return jTFNome;
    }

    public javax.swing.JTextField getjTFValor() {
        return jTFValor;
    }

    public javax.swing.JComboBox<AtracaoTuristica> getjCBAtracoes() {
        return jCBAtracoes;
    }

    public javax.swing.ButtonGroup getButtonGroup1() {
        return buttonGroup1;
    }

}
