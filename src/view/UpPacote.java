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
import model.entity.Pacote;

/**
 *
 * @author User
 */
public class UpPacote extends javax.swing.JPanel {

    private final ArrayList<Hotel> listHotel;
    private final ArrayList<Restaurante> listRestaurante;
    private final ArrayList<CasaShow> listCasaShow;
    private final ArrayList<Igreja> listIgreja;
    private final ArrayList<Museu> listMuseu;
    private final ArrayList<Parque> listParque;

    /**
     * Creates new form AddPacote
     */
    public UpPacote() {
        initComponents();
        listHotel = new ArrayList<>();
        listRestaurante = new ArrayList<>();
        listCasaShow = new ArrayList<>();
        listIgreja = new ArrayList<>();
        listMuseu = new ArrayList<>();
        listParque = new ArrayList<>();
        jCBCidade.setModel(new DefaultComboBoxModel<>());
        jCBPacotes.setModel(new DefaultComboBoxModel<>());
    }
    
    private void loadPacote(){
        getjCBPacotes().removeAllItems();
        for(Pacote item: new PacoteController().loadAllPacote()){
            getjCBPacotes().addItem(item);
        }
    }
    
    private void loadCidade(){
        getjCBCidade().removeAllItems();
        for(Cidade item: new CidadeController().loadAllCidade()){
            getjCBCidade().addItem(item);
        }
    }

    private void loadHotel(){
        Cidade cd = (Cidade) getjCBCidade().getSelectedItem();
        if(cd == null){
            cd = getjCBCidade().getItemAt(0);
        }
        getListHotel().clear();
        getListHotel().addAll(new HotelController().loadAllHotel(cd));
    }
    
    private void loadRestaurante(){
        Cidade cd = (Cidade) getjCBCidade().getSelectedItem();
        if(cd == null){
            cd = getjCBCidade().getItemAt(0);
        }
        getListRestaurante().clear();
        getListRestaurante().addAll(new RestauranteController().loadAllRestaurante(cd));
    }
    
    private void loadCasaShow(){
       Cidade cd = (Cidade) getjCBCidade().getSelectedItem();
        if(cd == null){
            cd = getjCBCidade().getItemAt(0);
        }
        getListCasaShow().clear();
        getListCasaShow().addAll(new CasaShowController().loadAllCasaShow(cd));
    }
    
    private void loadIgreja(){
        Cidade cd = (Cidade) getjCBCidade().getSelectedItem();
        if(cd == null){
            cd = getjCBCidade().getItemAt(0);
        }
        getListIgreja().clear();
        getListIgreja().addAll(new IgrejaController().loadAllIgreja(cd));
    }
    
    private void loadMuseu(){
        Cidade cd = (Cidade) getjCBCidade().getSelectedItem();
        if(cd == null){
            cd = getjCBCidade().getItemAt(0);
        }
        getListMuseu().clear();
        getListMuseu().addAll(new MuseuController().loadAllMuseu(cd));
    }
    
    private void loadParque(){
        Cidade cd = (Cidade) getjCBCidade().getSelectedItem();
        if(cd == null){
            cd = getjCBCidade().getItemAt(0);
        }
        getListParque().clear();
        getListParque().addAll(new ParqueController().loadAllParque(cd));
    }
    
    private void updateCB(ArrayList<?> list){
        getjCBAtracoes().removeAllItems();
        for(Object item : list){
            getjCBAtracoes().addItem((AtracaoTuristica)item);
        }
    }
    
    private void toggleEnabled(){
        boolean enabled = !getjTFNome().isEnabled();
        getjTFNome().setEnabled(enabled);
        getjCBCidade().setEnabled(enabled);
        getjTFDtinicio().setEnabled(enabled);
        getjTFDtfim().setEnabled(enabled);
        getjTFValor().setEnabled(enabled);
        getjTFDisp().setEnabled(enabled);
        getjTFData().setEnabled(enabled);
        jRBTipoHotel.setEnabled(enabled);
        jRBTipoRestaurante.setEnabled(enabled);
        jRBTipoCasashow.setEnabled(enabled);
        jRBTipoIgreja.setEnabled(enabled);
        jRBTipoMuseu.setEnabled(enabled);
        jRBTipoParque.setEnabled(enabled);
        getjCBAtracoes().setEnabled(enabled);
        getjLtAtracoes().setEnabled(enabled);
        jBAdicionar.setEnabled(enabled);
        jBRemover.setEnabled(enabled);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLNome = new javax.swing.JLabel();
        jTFNome = new javax.swing.JTextField();
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
        jBSalvar = new javax.swing.JButton();
        jBEditar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jCBPacotes = new javax.swing.JComboBox<>();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLNome.setText("Nome:");

        jTFNome.setEnabled(false);

        jLValor.setText("Preço:");

        jLDtinicio.setText("Data início:");

        jLCidade.setText("Cidade:");

        jTFDtinicio.setEnabled(false);

        jTFDtfim.setEnabled(false);

        jLDtfim.setText("Data fim:");

        jLDisp.setText("Vagas:");

        jTFValor.setEnabled(false);

        jTFDisp.setEnabled(false);

        jCBCidade.setEnabled(false);
        jCBCidade.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBCidadeItemStateChanged(evt);
            }
        });

        jLAtracoes.setText("Atrações:");

        jLData.setText("Data:");

        jLTipo.setText("Tipo:");

        jTFData.setToolTipText("dd/mm/aaaa");
        jTFData.setEnabled(false);
        jTFData.setPreferredSize(new java.awt.Dimension(65, 22));
        jTFData.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTFDataCaretUpdate(evt);
            }
        });

        buttonGroup1.add(jRBTipoHotel);
        jRBTipoHotel.setSelected(true);
        jRBTipoHotel.setText("Hotel");
        jRBTipoHotel.setEnabled(false);
        jRBTipoHotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBTipoHotelActionPerformed(evt);
            }
        });

        jCBAtracoes.setEnabled(false);

        jBAdicionar.setText("Adicionar");
        jBAdicionar.setEnabled(false);
        jBAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAdicionarActionPerformed(evt);
            }
        });

        jLtAtracoes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jLtAtracoes.setEnabled(false);
        jScrollPane1.setViewportView(jLtAtracoes);
        jLtAtracoes.getAccessibleContext().setAccessibleName("");

        jBRemover.setText("Remover");
        jBRemover.setEnabled(false);
        jBRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoverActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRBTipoRestaurante);
        jRBTipoRestaurante.setText("Restaurante");
        jRBTipoRestaurante.setEnabled(false);
        jRBTipoRestaurante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBTipoRestauranteActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRBTipoCasashow);
        jRBTipoCasashow.setText("Casa de Show");
        jRBTipoCasashow.setEnabled(false);
        jRBTipoCasashow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBTipoCasashowActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRBTipoIgreja);
        jRBTipoIgreja.setText("Igreja");
        jRBTipoIgreja.setEnabled(false);
        jRBTipoIgreja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBTipoIgrejaActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRBTipoMuseu);
        jRBTipoMuseu.setText("Museu");
        jRBTipoMuseu.setEnabled(false);
        jRBTipoMuseu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBTipoMuseuActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRBTipoParque);
        jRBTipoParque.setText("Parque");
        jRBTipoParque.setEnabled(false);
        jRBTipoParque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBTipoParqueActionPerformed(evt);
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

        jCBPacotes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBPacotesItemStateChanged(evt);
            }
        });
        jCBPacotes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBPacotesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCBPacotes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLNome)
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBCidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTFNome))
                        .addContainerGap())
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLAtracoes)
                            .addComponent(jLData)
                            .addComponent(jTFData, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
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
                                .addComponent(jRBTipoParque))
                            .addComponent(jCBAtracoes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBAdicionar)
                            .addComponent(jBRemover))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBEditar)
                        .addGap(18, 18, 18)
                        .addComponent(jBExcluir)
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLCidade)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLDtinicio)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTFValor)
                                            .addComponent(jTFDtinicio, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLValor))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLDtfim)
                                    .addComponent(jLDisp))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFDtfim, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTFDisp, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCBPacotes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jBEditar)
                    .addComponent(jBExcluir)
                    .addComponent(jBSalvar))
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

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
        loadPacote();
        loadHotel();
        loadRestaurante();
        loadCasaShow();
        loadIgreja();
        loadMuseu();
        loadParque();
    }//GEN-LAST:event_formComponentShown

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        getjCBCidade().removeAllItems();
        getjCBPacotes().removeAllItems();
        getListHotel().clear();
        getListRestaurante().clear();
        getListCasaShow().clear();
        getListIgreja().clear();
        getListMuseu().clear();
        getListParque().clear();
    }//GEN-LAST:event_formComponentHidden

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        String message = "Dados do pacote atualizados com sucesso!";
        String title = "Sucesso";
        int type = JOptionPane.INFORMATION_MESSAGE;
        try{
            new PacoteController().updatePacote(this);
            jBEditar.setText("Editar");
            toggleEnabled();
        }catch(DateTimeParseException e){
            message = "O formato da data está incorreto. (dd/mm/aaaa)";
            title = "Erro";
            type = JOptionPane.ERROR_MESSAGE;
        }catch(Exception e){
            message = "Ocorreu um erro ao atualizar os dados do pacote...\n\n" + e.getMessage().split("\n")[0];
            title = "Erro";
            type = JOptionPane.ERROR_MESSAGE;
        }finally{
            JOptionPane.showMessageDialog(null,message,title,type);
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarActionPerformed
        if(jBEditar.getText() == "Editar"){
            jBEditar.setText("Cancelar");
            toggleEnabled();
            jRBTipoHotel.doClick();
        }else{
            jBEditar.setText("Editar");
            new PacoteController().showPacote(this);
            jRBTipoHotel.doClick();
            getjCBAtracoes().removeAllItems();
            toggleEnabled();
        }
    }//GEN-LAST:event_jBEditarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        String message = "Confirmar exclusão do pacote";
        String title = "Exclusão";
        int type = JOptionPane.OK_CANCEL_OPTION;
        int response = JOptionPane.showConfirmDialog(null, message, title, type);
        if(response == 0){
            new PacoteController().deletePacote(this);
            loadPacote();
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jCBPacotesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBPacotesActionPerformed
//        if(jBEditar.getText() == "Cancelar"){
//            jBEditar.setText("Editar");
//            jRBTipoHotel.doClick();
//            getjCBAtracoes().removeAllItems();
//            toggleEnabled();
//        }
//        new PacoteController().showPacote(this);
    }//GEN-LAST:event_jCBPacotesActionPerformed

    private void jCBCidadeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBCidadeItemStateChanged
        if(evt.getStateChange()== java.awt.event.ItemEvent.SELECTED){
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

    private void jCBPacotesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBPacotesItemStateChanged
        if(evt.getStateChange()== java.awt.event.ItemEvent.SELECTED){
                if(jBEditar.getText() == "Cancelar"){
                jBEditar.setText("Editar");
                jRBTipoHotel.doClick();
                getjCBAtracoes().removeAllItems();
                toggleEnabled();
            }
            new PacoteController().showPacote(this);
        }
    }//GEN-LAST:event_jCBPacotesItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBAdicionar;
    private javax.swing.JButton jBEditar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBRemover;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<AtracaoTuristica> jCBAtracoes;
    private javax.swing.JComboBox<Cidade> jCBCidade;
    private javax.swing.JComboBox<Pacote> jCBPacotes;
    private javax.swing.JLabel jLAtracoes;
    private javax.swing.JLabel jLCidade;
    private javax.swing.JLabel jLData;
    private javax.swing.JLabel jLDisp;
    private javax.swing.JLabel jLDtfim;
    private javax.swing.JLabel jLDtinicio;
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

    public javax.swing.JComboBox<Pacote> getjCBPacotes() {
        return jCBPacotes;
    }
    
    public java.util.ArrayList<AtracaoInclusa> getjLtAtracoesAsList() {
        DefaultListModel<AtracaoInclusa> model = (DefaultListModel<AtracaoInclusa>) getjLtAtracoes().getModel();
        int size = model.getSize();
        ArrayList<AtracaoInclusa> list = new ArrayList<>();
        for(int i = 0; i < size; i++){
            list.add(model.elementAt(i));
        }
        return list;
    }

    public java.util.ArrayList<Cidade> getjCBCidadeAsList() {
        DefaultComboBoxModel<Cidade> model = (DefaultComboBoxModel<Cidade>) getjCBCidade().getModel();
        int size = model.getSize();
        ArrayList<Cidade> list = new ArrayList<>();
        for(int i = 0; i < size; i++){
            list.add(model.getElementAt(i));
        }
        return list;
    }
    
}
