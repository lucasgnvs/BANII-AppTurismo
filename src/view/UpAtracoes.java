/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.AtracaoController;
import controller.CidadeController;
import controller.HotelController;
import controller.RestauranteController;
import controller.CasaShowController;
import controller.IgrejaController;
import controller.MuseuController;
import controller.ParqueController;
import controller.AtracaoExecuteTipo;
import java.sql.SQLException;
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
import model.entity.Fundador;
import model.entity.Parque;
import model.entity.AtracaoTuristica;

/**
 *
 * @author User
 */
public class UpAtracoes extends javax.swing.JPanel {

    private final ArrayList<Hotel> listHotel;
    private final ArrayList<Restaurante> listRestaurante;
    private final ArrayList<CasaShow> listCasaShow;
    private final ArrayList<Igreja> listIgreja;
    private final ArrayList<Museu> listMuseu;
    private final ArrayList<Parque> listParque;

    /**
     * Creates new form AddPacote
     */
    public UpAtracoes() {
        initComponents();
        listHotel = new ArrayList<>();
        listRestaurante = new ArrayList<>();
        listCasaShow = new ArrayList<>();
        listIgreja = new ArrayList<>();
        listMuseu = new ArrayList<>();
        listParque = new ArrayList<>();
        jCBCidade.setModel(new DefaultComboBoxModel<>());
        jCBAtracoes.setModel(new DefaultComboBoxModel<>());
        jCBHotelRestaurante.setModel(new DefaultComboBoxModel<>());
        jCBCasashowRestaurante.setModel(new DefaultComboBoxModel<>());
        jCBMuseuFundadores.setModel(new DefaultComboBoxModel<>());
    }
    
    private void loadCidade(){
        getjCBCidade().removeAllItems();
        for(Cidade item: new CidadeController().loadAllCidade()){
            getjCBCidade().addItem(item);
        }
    }

    private void loadHotel(){
        getListHotel().clear();
        getListHotel().addAll(new HotelController().loadAllHotel());
    }
    
    private void loadRestaurante(){
        getListRestaurante().clear();
        getListRestaurante().addAll(new RestauranteController().loadAllRestaurante());
    }
    
    private void loadCasaShow(){
        getListCasaShow().clear();
        getListCasaShow().addAll(new CasaShowController().loadAllCasaShow());
    }
    
    private void loadIgreja(){
        getListIgreja().clear();
        getListIgreja().addAll(new IgrejaController().loadAllIgreja());
    }
    
    private void loadMuseu(){
        getListMuseu().clear();
        getListMuseu().addAll(new MuseuController().loadAllMuseu());
    }
    
    private void loadParque(){
        getListParque().clear();
        getListParque().addAll(new ParqueController().loadAllParque());
    }
    
    private void loadHotelRestaurante(){
        Cidade cd = (Cidade) getjCBCidade().getSelectedItem();
        if(cd == null){
            cd = getjCBCidade().getItemAt(0);
        }
        getjCBHotelRestaurante().removeAllItems();
        for(Restaurante item : new RestauranteController().loadAllRestaurante(cd)){
            getjCBHotelRestaurante().addItem(item);
        }
    }
    
    private void loadCasashowRestaurante(){
        Cidade cd = (Cidade) getjCBCidade().getSelectedItem();
        if(cd == null){
            cd = getjCBCidade().getItemAt(0);
        }
        getjCBCasashowRestaurante().removeAllItems();
        for(Restaurante item : new RestauranteController().loadAllRestaurante(cd)){
            getjCBCasashowRestaurante().addItem(item);
        }
    }
    
    private void updateCB(ArrayList<?> list){
        getjCBAtracoes().removeAllItems();
        for(Object item : list){
            getjCBAtracoes().addItem((AtracaoTuristica)item);
        }
    }
    
    private void loadAll(){
        loadCidade();
        loadHotel();
        loadRestaurante();
        loadCasaShow();
        loadIgreja();
        loadMuseu();
        loadParque();
    }
    
    private void refresh(){
        loadAll();
        String value = getButtonGroupAtracoes().getSelection().getActionCommand();
        int index = getjCBAtracoes().getSelectedIndex();
        switch(value){
            case "hotel" -> updateCB(getListHotel());
            case "restaurante" -> updateCB(getListRestaurante());
            case "casashow" -> updateCB(getListCasaShow());
            case "igreja" -> updateCB(getListIgreja());
            case "museu" -> updateCB(getListMuseu());
            case "parque" -> updateCB(getListParque());
        }
        getjCBAtracoes().setSelectedIndex(index);
    }
    
    private void toggleEnabled(){
        boolean enabled = !getjTFNome().isEnabled();
        getjTFNome().setEnabled(enabled);
        getjCBCidade().setEnabled(enabled);
        getjTFEndereco().setEnabled(enabled);
        
        getjRBCat1().setEnabled(enabled);
        getjRBCat2().setEnabled(enabled);
        getjRBCat3().setEnabled(enabled);
        getjRBCat4().setEnabled(enabled);
        getjRBCat5().setEnabled(enabled);
        getjCkBHotelRestaurante().setEnabled(enabled);
        if(getjCkBHotelRestaurante().isSelected()){
            getjCBHotelRestaurante().setEnabled(enabled);
        }
        getjCkBHotelQuartos1().setEnabled(enabled);
        if(getjCkBHotelQuartos1().isSelected()){
            getjTFNrquartos1().setEnabled(enabled);
            getjTFNrhospedes1().setEnabled(enabled);
            getjTFValor1().setEnabled(enabled);
        }
        getjCkBHotelQuartos2().setEnabled(enabled);
        if(getjCkBHotelQuartos2().isSelected()){
            getjTFNrquartos2().setEnabled(enabled);
            getjTFNrhospedes2().setEnabled(enabled);
            getjTFValor2().setEnabled(enabled);
        }
        getjCkBHotelQuartos3().setEnabled(enabled);
        if(getjCkBHotelQuartos3().isSelected()){
            getjTFNrquartos3().setEnabled(enabled);
            getjTFNrhospedes3().setEnabled(enabled);
            getjTFValor3().setEnabled(enabled);
        }
                        
        getjRBRestauranteCat1().setEnabled(enabled);
        getjRBRestauranteCat2().setEnabled(enabled);
        
        getjTACasashowDescricao().setEnabled(enabled);
        getjTFCasashowHrinicio().setEnabled(enabled);
        getjCBCasashowDiafech().setEnabled(enabled);
        getjCkBCasashowRestaurante().setEnabled(enabled);
        if(getjCkBCasashowRestaurante().isSelected()){
            getjCBCasashowRestaurante().setEnabled(enabled);
            getjTFCasashowPreco().setEnabled(enabled);
            getjCBCasashowEsp().setEnabled(enabled);
        }
        
        getjTAIgrejaDescricao().setEnabled(enabled);
        getjTFIgrejaData().setEnabled(enabled);
        getjTFIgrejaEstilo().setEnabled(enabled);
        
        getjTAMuseuDescricao().setEnabled(enabled);
        getjTFMuseuData().setEnabled(enabled);
        getjTFMuseuNrsalas().setEnabled(enabled);
        jBMuseuAdicionar.setEnabled(enabled);
        jBMuseuRemover.setEnabled(enabled);
        getjCBMuseuFundadores().setEnabled(enabled);
        getjLtMuseuFundadores().setEnabled(enabled);
        
        getjTAParqueDescricao().setEnabled(enabled);
        getjTFParqueNrAtracoes().setEnabled(enabled);
        getjTFParqueCapacidade().setEnabled(enabled);
        
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

        buttonGroupAtracoes = new javax.swing.ButtonGroup();
        buttonGroupRestauranteCat = new javax.swing.ButtonGroup();
        buttonGroupHotelCat = new javax.swing.ButtonGroup();
        jLNome = new javax.swing.JLabel();
        jTFNome = new javax.swing.JTextField();
        jLCidade = new javax.swing.JLabel();
        jCBCidade = new javax.swing.JComboBox<>();
        jRBTipoHotel = new javax.swing.JRadioButton();
        jCBAtracoes = new javax.swing.JComboBox<AtracaoTuristica>();
        jRBTipoRestaurante = new javax.swing.JRadioButton();
        jRBTipoCasashow = new javax.swing.JRadioButton();
        jRBTipoIgreja = new javax.swing.JRadioButton();
        jRBTipoMuseu = new javax.swing.JRadioButton();
        jRBTipoParque = new javax.swing.JRadioButton();
        jTFEndereco = new javax.swing.JTextField();
        jLEndereco = new javax.swing.JLabel();
        jPAtracoes = new javax.swing.JPanel();
        jPHotel = new javax.swing.JPanel();
        jLHotelCategoria = new javax.swing.JLabel();
        jLHotelRestaurante = new javax.swing.JLabel();
        jCBHotelRestaurante = new javax.swing.JComboBox<>();
        jCkBHotelRestaurante = new javax.swing.JCheckBox();
        jLCatEstrelas = new javax.swing.JLabel();
        jRBCat1 = new javax.swing.JRadioButton();
        jRBCat2 = new javax.swing.JRadioButton();
        jRBCat5 = new javax.swing.JRadioButton();
        jRBCat4 = new javax.swing.JRadioButton();
        jRBCat3 = new javax.swing.JRadioButton();
        jLHotelQuartos = new javax.swing.JLabel();
        jCkBHotelQuartos1 = new javax.swing.JCheckBox();
        jCkBHotelQuartos2 = new javax.swing.JCheckBox();
        jCkBHotelQuartos3 = new javax.swing.JCheckBox();
        jLHotelValor = new javax.swing.JLabel();
        jLHotelNrquartos = new javax.swing.JLabel();
        jLHotelNrhospedes = new javax.swing.JLabel();
        jTFNrquartos1 = new javax.swing.JTextField();
        jTFNrquartos2 = new javax.swing.JTextField();
        jTFNrquartos3 = new javax.swing.JTextField();
        jTFNrhospedes1 = new javax.swing.JTextField();
        jTFNrhospedes2 = new javax.swing.JTextField();
        jTFNrhospedes3 = new javax.swing.JTextField();
        jTFValor1 = new javax.swing.JTextField();
        jTFValor2 = new javax.swing.JTextField();
        jTFValor3 = new javax.swing.JTextField();
        jPRestaurante = new javax.swing.JPanel();
        jRBRestauranteCat2 = new javax.swing.JRadioButton();
        jLRestauranteCategoria = new javax.swing.JLabel();
        jRBRestauranteCat1 = new javax.swing.JRadioButton();
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
        jSPDescricao = new javax.swing.JScrollPane();
        jTACasashowDescricao = new javax.swing.JTextArea();
        jLCasashowDescricao = new javax.swing.JLabel();
        jPIgreja = new javax.swing.JPanel();
        jLIgrejaData = new javax.swing.JLabel();
        jLIgrejaEstilo = new javax.swing.JLabel();
        jTFIgrejaData = new javax.swing.JTextField();
        jTFIgrejaEstilo = new javax.swing.JTextField();
        jSPDescricao1 = new javax.swing.JScrollPane();
        jTAIgrejaDescricao = new javax.swing.JTextArea();
        jLIgrejaDescricao = new javax.swing.JLabel();
        jPMuseu = new javax.swing.JPanel();
        jLMuseuData = new javax.swing.JLabel();
        jLMuseuNrsalas = new javax.swing.JLabel();
        jTFMuseuNrsalas = new javax.swing.JTextField();
        jTFMuseuData = new javax.swing.JTextField();
        jLMuseuFundadores = new javax.swing.JLabel();
        jCBMuseuFundadores = new javax.swing.JComboBox<>();
        jBMuseuAdicionar = new javax.swing.JButton();
        jSPMuseuFundadores = new javax.swing.JScrollPane();
        jLtMuseuFundadores = new javax.swing.JList(new javax.swing.DefaultListModel<Fundador>());
        jBMuseuRemover = new javax.swing.JButton();
        jSPDescricao2 = new javax.swing.JScrollPane();
        jTAMuseuDescricao = new javax.swing.JTextArea();
        jLMuseuDescricao = new javax.swing.JLabel();
        jPParque = new javax.swing.JPanel();
        jLParqueNratracoes = new javax.swing.JLabel();
        jLParqueCapacidade = new javax.swing.JLabel();
        jTFParqueNrAtracoes = new javax.swing.JTextField();
        jTFParqueCapacidade = new javax.swing.JTextField();
        jSPDescricao3 = new javax.swing.JScrollPane();
        jTAParqueDescricao = new javax.swing.JTextArea();
        jLParqueDescricao = new javax.swing.JLabel();
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

        jLNome.setText("Nome:");

        jTFNome.setEnabled(false);

        jLCidade.setText("Cidade:");

        jCBCidade.setEnabled(false);

        buttonGroupAtracoes.add(jRBTipoHotel);
        jRBTipoHotel.setSelected(true);
        jRBTipoHotel.setText("Hotel");
        jRBTipoHotel.setActionCommand("hotel");
        jRBTipoHotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBTipoHotelActionPerformed(evt);
            }
        });

        jCBAtracoes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBAtracoesItemStateChanged(evt);
            }
        });
        jCBAtracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBAtracoesActionPerformed(evt);
            }
        });

        buttonGroupAtracoes.add(jRBTipoRestaurante);
        jRBTipoRestaurante.setText("Restaurante");
        jRBTipoRestaurante.setActionCommand("restaurante");
        jRBTipoRestaurante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBTipoRestauranteActionPerformed(evt);
            }
        });

        buttonGroupAtracoes.add(jRBTipoCasashow);
        jRBTipoCasashow.setText("Casa de Show");
        jRBTipoCasashow.setActionCommand("casashow");
        jRBTipoCasashow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBTipoCasashowActionPerformed(evt);
            }
        });

        buttonGroupAtracoes.add(jRBTipoIgreja);
        jRBTipoIgreja.setText("Igreja");
        jRBTipoIgreja.setActionCommand("igreja");
        jRBTipoIgreja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBTipoIgrejaActionPerformed(evt);
            }
        });

        buttonGroupAtracoes.add(jRBTipoMuseu);
        jRBTipoMuseu.setText("Museu");
        jRBTipoMuseu.setActionCommand("museu");
        jRBTipoMuseu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBTipoMuseuActionPerformed(evt);
            }
        });

        buttonGroupAtracoes.add(jRBTipoParque);
        jRBTipoParque.setText("Parque");
        jRBTipoParque.setActionCommand("parque");
        jRBTipoParque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBTipoParqueActionPerformed(evt);
            }
        });

        jTFEndereco.setToolTipText("Rua, N??mero, Bairro");
        jTFEndereco.setEnabled(false);

        jLEndereco.setText("Endere??o:");

        jPAtracoes.setLayout(new java.awt.CardLayout());

        jLHotelCategoria.setText("Categoria:");

        jLHotelRestaurante.setText("Restaurante:");

        jCBHotelRestaurante.setEnabled(false);

        jCkBHotelRestaurante.setEnabled(false);
        jCkBHotelRestaurante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCkBHotelRestauranteActionPerformed(evt);
            }
        });

        jLCatEstrelas.setText("estrelas");

        buttonGroupHotelCat.add(jRBCat1);
        jRBCat1.setText("1");
        jRBCat1.setActionCommand("1");
        jRBCat1.setEnabled(false);

        buttonGroupHotelCat.add(jRBCat2);
        jRBCat2.setText("2");
        jRBCat2.setActionCommand("2");
        jRBCat2.setEnabled(false);

        buttonGroupHotelCat.add(jRBCat5);
        jRBCat5.setText("5");
        jRBCat5.setActionCommand("5");
        jRBCat5.setEnabled(false);

        buttonGroupHotelCat.add(jRBCat4);
        jRBCat4.setText("4");
        jRBCat4.setActionCommand("4");
        jRBCat4.setEnabled(false);

        buttonGroupHotelCat.add(jRBCat3);
        jRBCat3.setText("3");
        jRBCat3.setActionCommand("3");
        jRBCat3.setEnabled(false);

        jLHotelQuartos.setText("Quartos:");

        jCkBHotelQuartos1.setText("Simples");
        jCkBHotelQuartos1.setEnabled(false);
        jCkBHotelQuartos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCkBHotelQuartos1ActionPerformed(evt);
            }
        });

        jCkBHotelQuartos2.setText("Luxo");
        jCkBHotelQuartos2.setEnabled(false);
        jCkBHotelQuartos2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCkBHotelQuartos2ActionPerformed(evt);
            }
        });

        jCkBHotelQuartos3.setText("Superluxo");
        jCkBHotelQuartos3.setEnabled(false);
        jCkBHotelQuartos3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCkBHotelQuartos3ActionPerformed(evt);
            }
        });

        jLHotelValor.setText("Pre??o:");
        jLHotelValor.setToolTipText("Pre??o do quarto deste tipo");

        jLHotelNrquartos.setText("Quantidade:");
        jLHotelNrquartos.setToolTipText("N??mero de quartos deste tipo dispon??veis");

        jLHotelNrhospedes.setText("H??spedes:");
        jLHotelNrhospedes.setToolTipText("N??mero de h??spedes por quarto deste tipo");

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

        javax.swing.GroupLayout jPHotelLayout = new javax.swing.GroupLayout(jPHotel);
        jPHotel.setLayout(jPHotelLayout);
        jPHotelLayout.setHorizontalGroup(
            jPHotelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPHotelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPHotelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPHotelLayout.createSequentialGroup()
                        .addGroup(jPHotelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLHotelQuartos)
                            .addGroup(jPHotelLayout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(jCkBHotelQuartos1)
                                .addGap(31, 31, 31)
                                .addComponent(jCkBHotelQuartos2)
                                .addGap(47, 47, 47)
                                .addComponent(jCkBHotelQuartos3)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPHotelLayout.createSequentialGroup()
                        .addGroup(jPHotelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLHotelRestaurante)
                            .addComponent(jLHotelCategoria)
                            .addGroup(jPHotelLayout.createSequentialGroup()
                                .addGroup(jPHotelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLHotelValor)
                                    .addGroup(jPHotelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPHotelLayout.createSequentialGroup()
                                            .addGap(22, 22, 22)
                                            .addComponent(jLHotelNrhospedes))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPHotelLayout.createSequentialGroup()
                                            .addGap(12, 12, 12)
                                            .addComponent(jLHotelNrquartos))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPHotelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPHotelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPHotelLayout.createSequentialGroup()
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
                                            .addGap(0, 359, Short.MAX_VALUE))
                                        .addGroup(jPHotelLayout.createSequentialGroup()
                                            .addComponent(jCBHotelRestaurante, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jCkBHotelRestaurante)))
                                    .addGroup(jPHotelLayout.createSequentialGroup()
                                        .addGroup(jPHotelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPHotelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jTFNrhospedes1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jTFValor1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(jTFNrquartos1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(30, 30, 30)
                                        .addGroup(jPHotelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jTFNrhospedes2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTFValor2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTFNrquartos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(32, 32, 32)
                                        .addGroup(jPHotelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jTFNrhospedes3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTFNrquartos3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTFValor3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(26, 26, 26)))))
                        .addGap(18, 18, 18))))
        );
        jPHotelLayout.setVerticalGroup(
            jPHotelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPHotelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPHotelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLHotelCategoria)
                    .addComponent(jLCatEstrelas)
                    .addComponent(jRBCat1)
                    .addComponent(jRBCat2)
                    .addComponent(jRBCat3)
                    .addComponent(jRBCat4)
                    .addComponent(jRBCat5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPHotelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCkBHotelRestaurante, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPHotelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLHotelRestaurante)
                        .addComponent(jCBHotelRestaurante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPHotelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCkBHotelQuartos1)
                    .addComponent(jCkBHotelQuartos3)
                    .addGroup(jPHotelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLHotelQuartos)
                        .addComponent(jCkBHotelQuartos2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPHotelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLHotelNrquartos)
                    .addGroup(jPHotelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTFNrquartos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTFNrquartos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTFNrquartos3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPHotelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLHotelNrhospedes)
                    .addComponent(jTFNrhospedes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFNrhospedes2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFNrhospedes3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPHotelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLHotelValor)
                    .addComponent(jTFValor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFValor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFValor3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPAtracoes.add(jPHotel, "uphotel");

        buttonGroupRestauranteCat.add(jRBRestauranteCat2);
        jRBRestauranteCat2.setText("Luxo");
        jRBRestauranteCat2.setActionCommand("2");
        jRBRestauranteCat2.setEnabled(false);

        jLRestauranteCategoria.setText("Categoria:");

        buttonGroupRestauranteCat.add(jRBRestauranteCat1);
        jRBRestauranteCat1.setText("Simples");
        jRBRestauranteCat1.setActionCommand("1");
        jRBRestauranteCat1.setEnabled(false);

        javax.swing.GroupLayout jPRestauranteLayout = new javax.swing.GroupLayout(jPRestaurante);
        jPRestaurante.setLayout(jPRestauranteLayout);
        jPRestauranteLayout.setHorizontalGroup(
            jPRestauranteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRestauranteLayout.createSequentialGroup()
                .addComponent(jLRestauranteCategoria)
                .addGap(26, 26, 26)
                .addComponent(jRBRestauranteCat1)
                .addGap(18, 18, 18)
                .addComponent(jRBRestauranteCat2)
                .addGap(0, 493, Short.MAX_VALUE))
        );
        jPRestauranteLayout.setVerticalGroup(
            jPRestauranteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRestauranteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPRestauranteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLRestauranteCategoria)
                    .addComponent(jRBRestauranteCat1)
                    .addComponent(jRBRestauranteCat2))
                .addContainerGap(196, Short.MAX_VALUE))
        );

        jPAtracoes.add(jPRestaurante, "uprestaurante");

        jLCasashowHrinicio.setText("Hora de in??cio:");

        jTFCasashowHrinicio.setToolTipText("hh:mm");
        jTFCasashowHrinicio.setEnabled(false);

        jLCasashowDiafech.setText("Dia de fechamento:");

        jCBCasashowDiafech.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DOM", "SEG", "TER", "QUA", "QUI", "SEX", "SAB" }));
        jCBCasashowDiafech.setEnabled(false);

        jLCasashowRestaurante.setText("Restaurante:");

        jCBCasashowRestaurante.setEnabled(false);

        jCkBCasashowRestaurante.setEnabled(false);
        jCkBCasashowRestaurante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCkBCasashowRestauranteActionPerformed(evt);
            }
        });

        jLCasashowPreco.setText("Pre??o m??dio:");

        jTFCasashowPreco.setToolTipText("Valor decimal com ponto, como 24.99");
        jTFCasashowPreco.setEnabled(false);

        jLCasashowEsp.setText("Especialidade:");

        jCBCasashowEsp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OUTRO", "BRA", "ITA", "JAP", "MEX" }));
        jCBCasashowEsp.setEnabled(false);

        jTACasashowDescricao.setColumns(20);
        jTACasashowDescricao.setRows(5);
        jTACasashowDescricao.setEnabled(false);
        jSPDescricao.setViewportView(jTACasashowDescricao);

        jLCasashowDescricao.setText("Descri????o:");

        javax.swing.GroupLayout jPCasashowLayout = new javax.swing.GroupLayout(jPCasashow);
        jPCasashow.setLayout(jPCasashowLayout);
        jPCasashowLayout.setHorizontalGroup(
            jPCasashowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCasashowLayout.createSequentialGroup()
                .addGroup(jPCasashowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLCasashowHrinicio)
                    .addComponent(jLCasashowRestaurante)
                    .addComponent(jLCasashowPreco)
                    .addComponent(jLCasashowDescricao))
                .addGap(18, 18, 18)
                .addGroup(jPCasashowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSPDescricao)
                    .addGroup(jPCasashowLayout.createSequentialGroup()
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
                                .addGap(0, 298, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCkBCasashowRestaurante))))
        );
        jPCasashowLayout.setVerticalGroup(
            jPCasashowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCasashowLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCasashowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSPDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLCasashowDescricao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jPAtracoes.add(jPCasashow, "upcasashow");

        jLIgrejaData.setText("Data de Funda????o:");

        jLIgrejaEstilo.setText("Estilo de Constru????o:");

        jTFIgrejaData.setToolTipText("dd/mm/aaaa");
        jTFIgrejaData.setEnabled(false);

        jTFIgrejaEstilo.setEnabled(false);

        jTAIgrejaDescricao.setColumns(20);
        jTAIgrejaDescricao.setRows(5);
        jTAIgrejaDescricao.setEnabled(false);
        jSPDescricao1.setViewportView(jTAIgrejaDescricao);

        jLIgrejaDescricao.setText("Descri????o:");

        javax.swing.GroupLayout jPIgrejaLayout = new javax.swing.GroupLayout(jPIgreja);
        jPIgreja.setLayout(jPIgrejaLayout);
        jPIgrejaLayout.setHorizontalGroup(
            jPIgrejaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPIgrejaLayout.createSequentialGroup()
                .addGroup(jPIgrejaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLIgrejaData)
                    .addComponent(jLIgrejaDescricao))
                .addGap(18, 18, 18)
                .addGroup(jPIgrejaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSPDescricao1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                    .addGroup(jPIgrejaLayout.createSequentialGroup()
                        .addComponent(jTFIgrejaData, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLIgrejaEstilo)
                        .addGap(18, 18, 18)
                        .addComponent(jTFIgrejaEstilo))))
        );
        jPIgrejaLayout.setVerticalGroup(
            jPIgrejaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPIgrejaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPIgrejaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSPDescricao1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLIgrejaDescricao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPIgrejaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLIgrejaData)
                    .addComponent(jTFIgrejaData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLIgrejaEstilo)
                    .addComponent(jTFIgrejaEstilo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(137, Short.MAX_VALUE))
        );

        jPAtracoes.add(jPIgreja, "upigreja");

        jLMuseuData.setText("Data de Funda????o:");

        jLMuseuNrsalas.setText("N??mero de Salas:");

        jTFMuseuNrsalas.setEnabled(false);

        jTFMuseuData.setToolTipText("dd/mm/aaaa");
        jTFMuseuData.setEnabled(false);

        jLMuseuFundadores.setText("Fundadores:");

        jCBMuseuFundadores.setEnabled(false);

        jBMuseuAdicionar.setText("Adicionar");
        jBMuseuAdicionar.setEnabled(false);
        jBMuseuAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMuseuAdicionarActionPerformed(evt);
            }
        });

        jLtMuseuFundadores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jLtMuseuFundadores.setEnabled(false);
        jSPMuseuFundadores.setViewportView(jLtMuseuFundadores);

        jBMuseuRemover.setText("Remover");
        jBMuseuRemover.setEnabled(false);
        jBMuseuRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMuseuRemoverActionPerformed(evt);
            }
        });

        jTAMuseuDescricao.setColumns(20);
        jTAMuseuDescricao.setRows(5);
        jTAMuseuDescricao.setEnabled(false);
        jSPDescricao2.setViewportView(jTAMuseuDescricao);

        jLMuseuDescricao.setText("Descri????o:");

        javax.swing.GroupLayout jPMuseuLayout = new javax.swing.GroupLayout(jPMuseu);
        jPMuseu.setLayout(jPMuseuLayout);
        jPMuseuLayout.setHorizontalGroup(
            jPMuseuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPMuseuLayout.createSequentialGroup()
                .addGroup(jPMuseuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLMuseuData)
                    .addComponent(jLMuseuFundadores)
                    .addComponent(jLMuseuDescricao))
                .addGap(18, 18, 18)
                .addGroup(jPMuseuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPMuseuLayout.createSequentialGroup()
                        .addComponent(jSPDescricao2)
                        .addContainerGap())
                    .addGroup(jPMuseuLayout.createSequentialGroup()
                        .addComponent(jTFMuseuData, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLMuseuNrsalas)
                        .addGap(18, 18, 18)
                        .addComponent(jTFMuseuNrsalas, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPMuseuLayout.createSequentialGroup()
                        .addGroup(jPMuseuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSPMuseuFundadores, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
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
                .addGroup(jPMuseuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSPDescricao2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLMuseuDescricao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPAtracoes.add(jPMuseu, "upmuseu");

        jLParqueNratracoes.setText("N??mero de Atra????es:");

        jLParqueCapacidade.setText("Capacidade:");

        jTFParqueNrAtracoes.setEnabled(false);

        jTFParqueCapacidade.setEnabled(false);

        jTAParqueDescricao.setColumns(20);
        jTAParqueDescricao.setRows(5);
        jTAParqueDescricao.setEnabled(false);
        jSPDescricao3.setViewportView(jTAParqueDescricao);

        jLParqueDescricao.setText("Descri????o:");

        javax.swing.GroupLayout jPParqueLayout = new javax.swing.GroupLayout(jPParque);
        jPParque.setLayout(jPParqueLayout);
        jPParqueLayout.setHorizontalGroup(
            jPParqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPParqueLayout.createSequentialGroup()
                .addGroup(jPParqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLParqueNratracoes)
                    .addComponent(jLParqueDescricao))
                .addGap(18, 18, 18)
                .addGroup(jPParqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSPDescricao3)
                    .addGroup(jPParqueLayout.createSequentialGroup()
                        .addComponent(jTFParqueNrAtracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLParqueCapacidade)
                        .addGap(18, 18, 18)
                        .addComponent(jTFParqueCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 273, Short.MAX_VALUE))))
        );
        jPParqueLayout.setVerticalGroup(
            jPParqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPParqueLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPParqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSPDescricao3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLParqueDescricao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPParqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLParqueNratracoes)
                    .addComponent(jTFParqueNrAtracoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLParqueCapacidade)
                    .addComponent(jTFParqueCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(137, Short.MAX_VALUE))
        );

        jPAtracoes.add(jPParque, "upparque");

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLCidade)
                            .addGroup(layout.createSequentialGroup()
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
                            .addComponent(jLEndereco))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPAtracoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCBAtracoes, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLNome)
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBCidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTFNome)
                            .addComponent(jTFEndereco))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBEditar)
                .addGap(18, 18, 18)
                .addComponent(jBExcluir)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBTipoHotel)
                    .addComponent(jRBTipoRestaurante)
                    .addComponent(jRBTipoCasashow)
                    .addComponent(jRBTipoIgreja)
                    .addComponent(jRBTipoMuseu)
                    .addComponent(jRBTipoParque))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCBAtracoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jLEndereco)
                    .addComponent(jTFEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPAtracoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBEditar)
                    .addComponent(jBExcluir)
                    .addComponent(jBSalvar))
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jRBTipoHotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBTipoHotelActionPerformed
        java.awt.CardLayout c = (java.awt.CardLayout)(jPAtracoes.getLayout());
        c.show(jPAtracoes, "uphotel");
        updateCB(getListHotel());
    }//GEN-LAST:event_jRBTipoHotelActionPerformed

    private void jRBTipoRestauranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBTipoRestauranteActionPerformed
        java.awt.CardLayout c = (java.awt.CardLayout)(jPAtracoes.getLayout());
        c.show(jPAtracoes, "uprestaurante");
        updateCB(getListRestaurante());
    }//GEN-LAST:event_jRBTipoRestauranteActionPerformed

    private void jRBTipoCasashowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBTipoCasashowActionPerformed
        java.awt.CardLayout c = (java.awt.CardLayout)(jPAtracoes.getLayout());
        c.show(jPAtracoes, "upcasashow");
        updateCB(getListCasaShow());
    }//GEN-LAST:event_jRBTipoCasashowActionPerformed

    private void jRBTipoIgrejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBTipoIgrejaActionPerformed
        java.awt.CardLayout c = (java.awt.CardLayout)(jPAtracoes.getLayout());
        c.show(jPAtracoes, "upigreja");
        updateCB(getListIgreja());
    }//GEN-LAST:event_jRBTipoIgrejaActionPerformed

    private void jRBTipoMuseuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBTipoMuseuActionPerformed
        java.awt.CardLayout c = (java.awt.CardLayout)(jPAtracoes.getLayout());
        c.show(jPAtracoes, "upmuseu");
        updateCB(getListMuseu());
    }//GEN-LAST:event_jRBTipoMuseuActionPerformed

    private void jRBTipoParqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBTipoParqueActionPerformed
        java.awt.CardLayout c = (java.awt.CardLayout)(jPAtracoes.getLayout());
        c.show(jPAtracoes, "upparque");
        updateCB(getListParque());
    }//GEN-LAST:event_jRBTipoParqueActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        loadAll();
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

    private void jBMuseuRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMuseuRemoverActionPerformed
        int index = getjLtMuseuFundadores().getSelectedIndex();
        DefaultListModel<Fundador> list = (DefaultListModel<Fundador>) getjLtMuseuFundadores().getModel();
        if (index != -1){
            list.remove(index);
        }
        getjLtMuseuFundadores().setModel(list);
    }//GEN-LAST:event_jBMuseuRemoverActionPerformed

    private void jBMuseuAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMuseuAdicionarActionPerformed
        Fundador selected  = (Fundador) getjCBMuseuFundadores().getSelectedItem();
        DefaultListModel<Fundador> list = (DefaultListModel<Fundador>) getjLtMuseuFundadores().getModel();
        if(!list.contains(selected)){
            list.addElement(selected);
        }
        getjLtMuseuFundadores().setModel(list);
    }//GEN-LAST:event_jBMuseuAdicionarActionPerformed

    private void jCkBCasashowRestauranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCkBCasashowRestauranteActionPerformed
        boolean value = getjCBCasashowRestaurante().isEnabled();
        getjCBCasashowRestaurante().setSelectedIndex(0);
        getjCBCasashowRestaurante().setEnabled(!value);
        getjCBCasashowEsp().setSelectedIndex(0);
        getjCBCasashowEsp().setEnabled(!value);
        getjTFCasashowPreco().setText("");
        getjTFCasashowPreco().setEnabled(!value);
    }//GEN-LAST:event_jCkBCasashowRestauranteActionPerformed

    private void jCkBHotelQuartos3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCkBHotelQuartos3ActionPerformed
        boolean value = getjTFNrquartos3().isEnabled();
        getjTFNrquartos3().setText("");
        getjTFNrquartos3().setEnabled(!value);
        getjTFNrhospedes3().setText("");
        getjTFNrhospedes3().setEnabled(!value);
        getjTFValor3().setText("");
        getjTFValor3().setEnabled(!value);
    }//GEN-LAST:event_jCkBHotelQuartos3ActionPerformed

    private void jCkBHotelQuartos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCkBHotelQuartos2ActionPerformed
        boolean value = getjTFNrquartos2().isEnabled();
        getjTFNrquartos2().setText("");
        getjTFNrquartos2().setEnabled(!value);
        getjTFNrhospedes2().setText("");
        getjTFNrhospedes2().setEnabled(!value);
        getjTFValor2().setText("");
        getjTFValor2().setEnabled(!value);
    }//GEN-LAST:event_jCkBHotelQuartos2ActionPerformed

    private void jCkBHotelQuartos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCkBHotelQuartos1ActionPerformed
        boolean value = getjTFNrquartos1().isEnabled();
        getjTFNrquartos1().setText("");
        getjTFNrquartos1().setEnabled(!value);
        getjTFNrhospedes1().setText("");
        getjTFNrhospedes1().setEnabled(!value);
        getjTFValor1().setText("");
        getjTFValor1().setEnabled(!value);
    }//GEN-LAST:event_jCkBHotelQuartos1ActionPerformed

    private void jCkBHotelRestauranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCkBHotelRestauranteActionPerformed
        boolean value = getjCBHotelRestaurante().isEnabled();
        try{
            getjCBHotelRestaurante().setSelectedIndex(0);
        }catch(IllegalArgumentException e){}
        getjCBHotelRestaurante().setEnabled(!value);
    }//GEN-LAST:event_jCkBHotelRestauranteActionPerformed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        String message = "Dados da atra????o atualizados com sucesso!";
        String title = "Sucesso";
        int type = JOptionPane.INFORMATION_MESSAGE;
        try{
            new AtracaoController().executeAtracao(this, AtracaoExecuteTipo.UPDATE);
            jBEditar.setText("Editar");
            toggleEnabled();
        }catch(DateTimeParseException e){
            message = "O formato da data est?? incorreto. (dd/mm/aaaa)";
            title = "Erro";
            type = JOptionPane.ERROR_MESSAGE;
        }catch(Exception e){
            message = "Ocorreu um erro ao atualizar os dados da atra????o...\n\n" + e.getMessage();
            title = "Erro";
            type = JOptionPane.ERROR_MESSAGE;
            refresh();
            e.printStackTrace();
        }finally{
            JOptionPane.showMessageDialog(null,message,title,type);
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarActionPerformed
        toggleEnabled();
        if(jBEditar.getText() == "Editar"){
            if(!getjCkBHotelRestaurante().isSelected()){
                loadHotelRestaurante();
            }
            if(!getjCkBCasashowRestaurante().isSelected()){
                loadCasashowRestaurante();
            }
            jBEditar.setText("Cancelar");
        }else{
            jBEditar.setText("Editar");
            try{
                new AtracaoController().executeAtracao(this, AtracaoExecuteTipo.SHOW);
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jBEditarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        String message = "Confirmar exclus??o de atra????o";
        String title = "Exclus??o";
        int type = JOptionPane.OK_CANCEL_OPTION;
        int response = JOptionPane.showConfirmDialog(null, message, title, type);
        if(response == 0){
            try{
                new AtracaoController().executeAtracao(this, AtracaoExecuteTipo.DELETE);
            }catch(SQLException e){
                e.printStackTrace();
            }
            refresh();
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jCBAtracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBAtracoesActionPerformed

    }//GEN-LAST:event_jCBAtracoesActionPerformed

    private void jCBAtracoesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBAtracoesItemStateChanged
        if(evt.getStateChange() == java.awt.event.ItemEvent.SELECTED){
            if(jBEditar.getText() == "Cancelar"){
                jBEditar.setText("Editar");
                toggleEnabled();
            }
            try{
                new AtracaoController().executeAtracao(this, AtracaoExecuteTipo.SHOW);
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jCBAtracoesItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupAtracoes;
    private javax.swing.ButtonGroup buttonGroupHotelCat;
    private javax.swing.ButtonGroup buttonGroupRestauranteCat;
    private javax.swing.JButton jBEditar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBMuseuAdicionar;
    private javax.swing.JButton jBMuseuRemover;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<AtracaoTuristica> jCBAtracoes;
    private javax.swing.JComboBox<String> jCBCasashowDiafech;
    private javax.swing.JComboBox<String> jCBCasashowEsp;
    private javax.swing.JComboBox<Restaurante> jCBCasashowRestaurante;
    private javax.swing.JComboBox<Cidade> jCBCidade;
    private javax.swing.JComboBox<Restaurante> jCBHotelRestaurante;
    private javax.swing.JComboBox<Fundador> jCBMuseuFundadores;
    private javax.swing.JCheckBox jCkBCasashowRestaurante;
    private javax.swing.JCheckBox jCkBHotelQuartos1;
    private javax.swing.JCheckBox jCkBHotelQuartos2;
    private javax.swing.JCheckBox jCkBHotelQuartos3;
    private javax.swing.JCheckBox jCkBHotelRestaurante;
    private javax.swing.JLabel jLCasashowDescricao;
    private javax.swing.JLabel jLCasashowDiafech;
    private javax.swing.JLabel jLCasashowEsp;
    private javax.swing.JLabel jLCasashowHrinicio;
    private javax.swing.JLabel jLCasashowPreco;
    private javax.swing.JLabel jLCasashowRestaurante;
    private javax.swing.JLabel jLCatEstrelas;
    private javax.swing.JLabel jLCidade;
    private javax.swing.JLabel jLEndereco;
    private javax.swing.JLabel jLHotelCategoria;
    private javax.swing.JLabel jLHotelNrhospedes;
    private javax.swing.JLabel jLHotelNrquartos;
    private javax.swing.JLabel jLHotelQuartos;
    private javax.swing.JLabel jLHotelRestaurante;
    private javax.swing.JLabel jLHotelValor;
    private javax.swing.JLabel jLIgrejaData;
    private javax.swing.JLabel jLIgrejaDescricao;
    private javax.swing.JLabel jLIgrejaEstilo;
    private javax.swing.JLabel jLMuseuData;
    private javax.swing.JLabel jLMuseuDescricao;
    private javax.swing.JLabel jLMuseuFundadores;
    private javax.swing.JLabel jLMuseuNrsalas;
    private javax.swing.JLabel jLNome;
    private javax.swing.JLabel jLParqueCapacidade;
    private javax.swing.JLabel jLParqueDescricao;
    private javax.swing.JLabel jLParqueNratracoes;
    private javax.swing.JLabel jLRestauranteCategoria;
    private javax.swing.JList<Fundador> jLtMuseuFundadores;
    private javax.swing.JPanel jPAtracoes;
    private javax.swing.JPanel jPCasashow;
    private javax.swing.JPanel jPHotel;
    private javax.swing.JPanel jPIgreja;
    private javax.swing.JPanel jPMuseu;
    private javax.swing.JPanel jPParque;
    private javax.swing.JPanel jPRestaurante;
    private javax.swing.JRadioButton jRBCat1;
    private javax.swing.JRadioButton jRBCat2;
    private javax.swing.JRadioButton jRBCat3;
    private javax.swing.JRadioButton jRBCat4;
    private javax.swing.JRadioButton jRBCat5;
    private javax.swing.JRadioButton jRBRestauranteCat1;
    private javax.swing.JRadioButton jRBRestauranteCat2;
    private javax.swing.JRadioButton jRBTipoCasashow;
    private javax.swing.JRadioButton jRBTipoHotel;
    private javax.swing.JRadioButton jRBTipoIgreja;
    private javax.swing.JRadioButton jRBTipoMuseu;
    private javax.swing.JRadioButton jRBTipoParque;
    private javax.swing.JRadioButton jRBTipoRestaurante;
    private javax.swing.JScrollPane jSPDescricao;
    private javax.swing.JScrollPane jSPDescricao1;
    private javax.swing.JScrollPane jSPDescricao2;
    private javax.swing.JScrollPane jSPDescricao3;
    private javax.swing.JScrollPane jSPMuseuFundadores;
    private javax.swing.JTextArea jTACasashowDescricao;
    private javax.swing.JTextArea jTAIgrejaDescricao;
    private javax.swing.JTextArea jTAMuseuDescricao;
    private javax.swing.JTextArea jTAParqueDescricao;
    private javax.swing.JTextField jTFCasashowHrinicio;
    private javax.swing.JTextField jTFCasashowPreco;
    private javax.swing.JTextField jTFEndereco;
    private javax.swing.JTextField jTFIgrejaData;
    private javax.swing.JTextField jTFIgrejaEstilo;
    private javax.swing.JTextField jTFMuseuData;
    private javax.swing.JTextField jTFMuseuNrsalas;
    private javax.swing.JTextField jTFNome;
    private javax.swing.JTextField jTFNrhospedes1;
    private javax.swing.JTextField jTFNrhospedes2;
    private javax.swing.JTextField jTFNrhospedes3;
    private javax.swing.JTextField jTFNrquartos1;
    private javax.swing.JTextField jTFNrquartos2;
    private javax.swing.JTextField jTFNrquartos3;
    private javax.swing.JTextField jTFParqueCapacidade;
    private javax.swing.JTextField jTFParqueNrAtracoes;
    private javax.swing.JTextField jTFValor1;
    private javax.swing.JTextField jTFValor2;
    private javax.swing.JTextField jTFValor3;
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

    public javax.swing.JTextField getjTFNome() {
        return jTFNome;
    }

    public javax.swing.JComboBox<AtracaoTuristica> getjCBAtracoes() {
        return jCBAtracoes;
    }
    
    public javax.swing.ButtonGroup getButtonGroupAtracoes() {
        return buttonGroupAtracoes;
    }

    public javax.swing.ButtonGroup getButtonGroupHotelCat() {
        return buttonGroupHotelCat;
    }

    public javax.swing.ButtonGroup getButtonGroupRestauranteCat() {
        return buttonGroupRestauranteCat;
    }

    public javax.swing.JComboBox<String> getjCBCasashowDiafech() {
        return jCBCasashowDiafech;
    }

    public javax.swing.JComboBox<String> getjCBCasashowEsp() {
        return jCBCasashowEsp;
    }

    public javax.swing.JComboBox<Restaurante> getjCBCasashowRestaurante() {
        return jCBCasashowRestaurante;
    }

    public javax.swing.JComboBox<Fundador> getjCBMuseuFundadores() {
        return jCBMuseuFundadores;
    }

    public javax.swing.JComboBox<Restaurante> getjCBHotelRestaurante() {
        return jCBHotelRestaurante;
    }

    public javax.swing.JTextField getjTFCasashowHrinicio() {
        return jTFCasashowHrinicio;
    }

    public javax.swing.JTextField getjTFCasashowPreco() {
        return jTFCasashowPreco;
    }

    public javax.swing.JTextField getjTFEndereco() {
        return jTFEndereco;
    }

    public javax.swing.JTextField getjTFIgrejaData() {
        return jTFIgrejaData;
    }

    public javax.swing.JTextField getjTFIgrejaEstilo() {
        return jTFIgrejaEstilo;
    }

    public javax.swing.JTextField getjTFMuseuData() {
        return jTFMuseuData;
    }

    public javax.swing.JTextField getjTFMuseuNrsalas() {
        return jTFMuseuNrsalas;
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

    public javax.swing.JTextField getjTFParqueCapacidade() {
        return jTFParqueCapacidade;
    }

    public javax.swing.JTextField getjTFParqueNrAtracoes() {
        return jTFParqueNrAtracoes;
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

    public javax.swing.JRadioButton getjRBCat1() {
        return jRBCat1;
    }

    public javax.swing.JRadioButton getjRBCat2() {
        return jRBCat2;
    }

    public javax.swing.JRadioButton getjRBCat3() {
        return jRBCat3;
    }

    public javax.swing.JRadioButton getjRBCat4() {
        return jRBCat4;
    }

    public javax.swing.JRadioButton getjRBCat5() {
        return jRBCat5;
    }

    public javax.swing.JRadioButton getjRBRestauranteCat1() {
        return jRBRestauranteCat1;
    }

    public javax.swing.JRadioButton getjRBRestauranteCat2() {
        return jRBRestauranteCat2;
    }

    public javax.swing.JTextArea getjTACasashowDescricao() {
        return jTACasashowDescricao;
    }

    public javax.swing.JTextArea getjTAIgrejaDescricao() {
        return jTAIgrejaDescricao;
    }

    public javax.swing.JTextArea getjTAMuseuDescricao() {
        return jTAMuseuDescricao;
    }

    public javax.swing.JTextArea getjTAParqueDescricao() {
        return jTAParqueDescricao;
    }

    public javax.swing.JList<Fundador> getjLtMuseuFundadores() {
        return jLtMuseuFundadores;
    }

    public javax.swing.JCheckBox getjCkBCasashowRestaurante() {
        return jCkBCasashowRestaurante;
    }

    public javax.swing.JCheckBox getjCkBHotelQuartos1() {
        return jCkBHotelQuartos1;
    }

    public javax.swing.JCheckBox getjCkBHotelQuartos2() {
        return jCkBHotelQuartos2;
    }

    public javax.swing.JCheckBox getjCkBHotelQuartos3() {
        return jCkBHotelQuartos3;
    }

    public javax.swing.JCheckBox getjCkBHotelRestaurante() {
        return jCkBHotelRestaurante;
    }
    
    public java.util.ArrayList<Fundador> getjLtMuseuFundadoresAsList() {
        DefaultListModel<Fundador> model = (DefaultListModel<Fundador>) getjLtMuseuFundadores().getModel();
        int size = model.getSize();
        ArrayList<Fundador> list = new ArrayList<>();
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
