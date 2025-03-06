/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visual;

import backend.jsonParser;
import backend.Fun.trocarPainel;

import static backend.Fun.Par.Geral.AlinhamentoP.*;
import static backend.Fun.Par.Geral.AntecedenteP.*;
import static backend.Fun.Par.Geral.ClassesP.*;
import static backend.Fun.Par.Geral.JanelaP.*;
import static backend.Fun.Par.Geral.NavBarP.*;
import static backend.Fun.Par.Geral.CAP.*;
import static backend.Fun.Par.Geral.IniciativaP.*;
import static backend.Fun.Par.Geral.NomeP.*;
import static backend.Fun.Par.Geral.PericiasP.*;
import static backend.Fun.Par.Geral.ProfP.*;
import static backend.Fun.Par.Geral.RacaP.*;
import static backend.Fun.Par.Geral.ResistenciaP.*;
import static backend.Fun.Par.Geral.SalvarP.*;
import static backend.Fun.Par.Geral.StatusP.*;
import static backend.Fun.Par.Geral.VidaP.*;
import static backend.Fun.Par.Geral.XpP.*;
import static backend.Fun.Par.Geral.ScrollP.*;
import static backend.Fun.Par.Geral.TesteSalvamentoP.*;
import static backend.Fun.Par.Geral.InspiracaoP.*;
import static backend.Fun.Par.Geral.PercepcaoPassivaP.*;
import static backend.Fun.Par.Geral.MovimentacaoP.*;
import static backend.Fun.Par.Inventario.InventarioPanelP.*;
import static backend.Fun.Par.Inventario.EquipamentosAddP.EquipamentosAddP;
import static backend.Fun.Par.Especializacao.EspecializacaoPanelP.EspecializacaoPanelP;
import backend.Fun.Par.Especializacao.EspecializacaoJanelaP;
import backend.Fun.Par.Especializacao.EspecializacoesAddP;
import org.json.*;

/**
 *
 * @author Admin
 */
public class personagemFicha extends javax.swing.JFrame {

    /**
     * Creates new form personagemFicha
     *
     * @param personagem
     */
    public personagemFicha(String personagem) {
        initComponents();

        String personagemCaminho = "personagensJSON/" + personagem + ".json";
        JSONObject ficha = new JSONObject(jsonParser.LerArquivo(personagemCaminho));
        String equipamentosCaminho = "ASSETS/Equipamento.json";
        String CarRacaCaminho = "ASSETS/CarRaca.json";
        String CarClasseCaminho = "ASSETS/CarClasse.json";
        String IdiomasCaminho = "ASSETS/Idiomas.json";
        String TalentosCaminho = "ASSETS/Talentos.json";
        String RacasCaminho = "ASSETS/Raca.json";
        String ClassesCaminho = "ASSETS/Classe.json";

        JSONArray Inventario = new JSONArray(jsonParser.LerArray(equipamentosCaminho));
        JSONArray CarRaca = new JSONArray(jsonParser.LerArray(CarRacaCaminho));
        JSONArray CarClasse = new JSONArray(jsonParser.LerArray(CarClasseCaminho));
        JSONArray Idiomas = new JSONArray(jsonParser.LerArray(IdiomasCaminho));
        JSONArray Talentos = new JSONArray(jsonParser.LerArray(TalentosCaminho));

        JSONArray Racas = new JSONArray(jsonParser.LerArray(RacasCaminho));
        JSONArray Classes = new JSONArray(jsonParser.LerArray(ClassesCaminho));

        
        JanelaP(jPanel2);
        JanelaP(jPanel15);
        JanelaP(PainelItens);
        JanelaP(jPanel8);

        ScrollP(jScrollPaneGeral, jScrollPaneInventario, jScrollPaneMagias, jScrollPaneEspecializacao);
        NavBarP(AppScrollPane, GeralNavBar, InventarioNavBar, MagiasNavBar, CaracteristicasNavBar);
        StatusP(personagemCaminho, ForLabel, ForMod, ficha, 0);
        StatusP(personagemCaminho, DesLabel, DesMod, ficha, 1);
        StatusP(personagemCaminho, ConLabel, ConMod, ficha, 2);
        StatusP(personagemCaminho, IntLabel, IntMod, ficha, 3);
        StatusP(personagemCaminho, CarLabel, CarMod, ficha, 4);
        StatusP(personagemCaminho, SabLabel, SabMod, ficha, 5);
        ResistenciaP(personagemCaminho, ficha, ForResCheck, ForResMod, 0);
        ResistenciaP(personagemCaminho, ficha, DesResCheck, DesResMod, 1);
        ResistenciaP(personagemCaminho, ficha, ConResCheck, ConResMod, 2);
        ResistenciaP(personagemCaminho, ficha, IntResCheck, IntResMod, 3);
        ResistenciaP(personagemCaminho, ficha, SabResCheck, SabResMod, 4);
        ResistenciaP(personagemCaminho, ficha, CarResCheck, CarResMod, 5);
        TesteSalvamentoP(personagemCaminho, ficha, Sucesso1, 0);
        TesteSalvamentoP(personagemCaminho, ficha, Sucesso2, 1);
        TesteSalvamentoP(personagemCaminho, ficha, Sucesso3, 2);
        TesteSalvamentoP(personagemCaminho, ficha, Fracesso1, 3);
        TesteSalvamentoP(personagemCaminho, ficha, Fracesso2, 4);
        TesteSalvamentoP(personagemCaminho, ficha, Fracesso3, 5);

        ProfP(ficha, BonusProficienciaLabel);
        VidaP(personagemCaminho, ficha, VidaAtual, VidaTotal, VidaCura, VidaDano);
        SalvarP(ficha, salvarBotao, personagemCaminho);
        NomeP(personagemCaminho, ficha, LabelNome);
        ClassesP(personagemCaminho, ficha, ClasseLabel, ClasseLabel, personagem, LevelLabel, PericiasContainer, BonusProficienciaLabel);
        RacaP(personagemCaminho, ficha, RacaSelect);
        AlinhamentoP(personagemCaminho, ficha, AlinhamentoSelect);
        XpP(personagemCaminho, ficha, XpLabel);
        AntecedenteP(personagemCaminho, ficha, AntecedenteLabel);
        PericiasP(personagemCaminho, ficha, PericiasContainer);
        CAP(ficha, BonusCALabel);
        IniciativaP(ficha, BonusIniciativaLabel);
        InspiracaoP(personagemCaminho, ficha, InspiracaoLabel);
        PercepcaoPassivaP(ficha, PercepcaoPassivaLabel);
        MovimentacaoP(personagemCaminho, ficha, MovimentacaoText);
        ItensPanelP(personagemCaminho, ficha, PainelItens, BonusCALabel);
        EquipamentosAddP(personagemCaminho, ficha, AddEquip, PainelItens, Inventario, BonusCALabel);
        EspecializacaoPanelP(personagemCaminho, ficha, PCarClasseC, "m", "d", "e", PainelEspecializacoes);
        EspecializacaoPanelP(personagemCaminho, ficha, PCarRacaC, "n", "d", "e", PainelEspecializacoes);
        EspecializacaoPanelP(personagemCaminho, ficha, PIdiomasC, "p", "c", "d", PainelEspecializacoes);
        EspecializacaoPanelP(personagemCaminho, ficha, PTalentosC, "o", "d", "c", PainelEspecializacoes);
        jScrollPaneMochilaItens.getVerticalScrollBar().setUnitIncrement(10);
        EspecializacoesAddP.EspecializacoesAddP(personagemCaminho, ficha, PCarRacaT, PCarRacaC, CarRaca, "n", "d", "e", PainelEspecializacoes, Racas);
        EspecializacoesAddP.EspecializacoesAddP(personagemCaminho, ficha, PCarClasseT, PCarClasseC, CarClasse, "m", "d", "e", PainelEspecializacoes, Classes);
        EspecializacoesAddP.EspecializacoesAddP(personagemCaminho, ficha, PIdiomasT, PIdiomasC, Idiomas, "p", "c", "d", PainelEspecializacoes, null);
        EspecializacoesAddP.EspecializacoesAddP(personagemCaminho, ficha, PTalentosT, PTalentosC, Talentos, "o", "d", "c", PainelEspecializacoes, null);  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        GeralNavBar = new javax.swing.JLabel();
        InventarioNavBar = new javax.swing.JLabel();
        MagiasNavBar = new javax.swing.JLabel();
        CaracteristicasNavBar = new javax.swing.JLabel();
        AppScrollPane = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPaneGeral = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        LabelNome = new javax.swing.JTextField();
        salvarBotao = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        ForMod = new javax.swing.JLabel();
        DesMod = new javax.swing.JLabel();
        ConMod = new javax.swing.JLabel();
        IntMod = new javax.swing.JLabel();
        SabMod = new javax.swing.JLabel();
        CarMod = new javax.swing.JLabel();
        ForLabel = new javax.swing.JTextField();
        DesLabel = new javax.swing.JTextField();
        ConLabel = new javax.swing.JTextField();
        IntLabel = new javax.swing.JTextField();
        SabLabel = new javax.swing.JTextField();
        CarLabel = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        ClassesRow = new javax.swing.JPanel();
        ClasseLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        VidaTotal = new javax.swing.JTextField();
        VidaAtual = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        RacaSelect = new javax.swing.JLabel();
        LevelLabel = new javax.swing.JLabel();
        XpLabel = new javax.swing.JTextField();
        AntecedenteLabel = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        PericiasContainer = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        ForResCheck = new javax.swing.JCheckBox();
        DesResCheck = new javax.swing.JCheckBox();
        ConResCheck = new javax.swing.JCheckBox();
        IntResCheck = new javax.swing.JCheckBox();
        SabResCheck = new javax.swing.JCheckBox();
        CarResCheck = new javax.swing.JCheckBox();
        ForResMod = new javax.swing.JLabel();
        DesResMod = new javax.swing.JLabel();
        ConResMod = new javax.swing.JLabel();
        IntResMod = new javax.swing.JLabel();
        SabResMod = new javax.swing.JLabel();
        CarResMod = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        BonusProficienciaLabel = new javax.swing.JLabel();
        VidaCura = new javax.swing.JLabel();
        VidaDano = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        AlinhamentoSelect = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        BonusIniciativaLabel = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        BonusCALabel = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        Sucesso1 = new javax.swing.JCheckBox();
        Sucesso2 = new javax.swing.JCheckBox();
        Sucesso3 = new javax.swing.JCheckBox();
        Fracesso1 = new javax.swing.JCheckBox();
        Fracesso2 = new javax.swing.JCheckBox();
        Fracesso3 = new javax.swing.JCheckBox();
        jPanel18 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        InspiracaoLabel = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        PercepcaoPassivaLabel = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        MovimentacaoText = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPaneInventario = new javax.swing.JScrollPane();
        jPanel15 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        AddEquip = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPaneMochilaItens = new javax.swing.JScrollPane();
        PainelItens = new javax.swing.JPanel();
        jScrollPaneMagias = new javax.swing.JScrollPane();
        jPanel16 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPaneEspecializacao = new javax.swing.JScrollPane();
        PainelEspecializacoes = new javax.swing.JPanel();
        PCarRaca = new javax.swing.JPanel();
        PCarRacaT = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        PCarRacaC = new javax.swing.JPanel();
        PCarClasse = new javax.swing.JPanel();
        PCarClasseT = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        PCarClasseC = new javax.swing.JPanel();
        PTalentos = new javax.swing.JPanel();
        PTalentosT = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        PTalentosC = new javax.swing.JPanel();
        PIdiomas = new javax.swing.JPanel();
        PIdiomasT = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        PIdiomasC = new javax.swing.JPanel();
        PCarExtra = new javax.swing.JPanel();
        PCarExtraT = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        PCarExtraC = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel8.setBackground(new java.awt.Color(23, 23, 23));

        jPanel7.setBackground(new java.awt.Color(53, 53, 53));

        GeralNavBar.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        GeralNavBar.setForeground(new java.awt.Color(255, 255, 255));
        GeralNavBar.setText("Geral");
        GeralNavBar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        InventarioNavBar.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        InventarioNavBar.setForeground(new java.awt.Color(255, 255, 255));
        InventarioNavBar.setText("Inventário");
        InventarioNavBar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        MagiasNavBar.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        MagiasNavBar.setForeground(new java.awt.Color(255, 255, 255));
        MagiasNavBar.setText("Magias");
        MagiasNavBar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        CaracteristicasNavBar.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        CaracteristicasNavBar.setForeground(new java.awt.Color(255, 255, 255));
        CaracteristicasNavBar.setText("Especialização");
        CaracteristicasNavBar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(GeralNavBar)
                .addGap(34, 34, 34)
                .addComponent(InventarioNavBar)
                .addGap(34, 34, 34)
                .addComponent(MagiasNavBar)
                .addGap(34, 34, 34)
                .addComponent(CaracteristicasNavBar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(0, 19, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(GeralNavBar)
                        .addComponent(InventarioNavBar))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(MagiasNavBar)
                        .addComponent(CaracteristicasNavBar)))
                .addGap(0, 19, Short.MAX_VALUE))
        );

        AppScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        AppScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel1.setBackground(new java.awt.Color(23, 23, 23));

        jScrollPaneGeral.setBorder(null);
        jScrollPaneGeral.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPaneGeral.setPreferredSize(new java.awt.Dimension(672, 438));

        jPanel2.setBackground(new java.awt.Color(23, 23, 23));
        jPanel2.setPreferredSize(new java.awt.Dimension(672, 1950));

        jButton1.setBackground(new java.awt.Color(79, 79, 79));
        jButton1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("voltar para seleção");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(35, 35, 195));
        jSeparator1.setForeground(new java.awt.Color(35, 35, 195));

        LabelNome.setBackground(new java.awt.Color(23, 23, 23));
        LabelNome.setFont(new java.awt.Font("Script MT Bold", 0, 18)); // NOI18N
        LabelNome.setForeground(new java.awt.Color(255, 255, 255));
        LabelNome.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        LabelNome.setText("Nome");
        LabelNome.setBorder(null);
        LabelNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LabelNomeActionPerformed(evt);
            }
        });

        salvarBotao.setBackground(new java.awt.Color(79, 79, 79));
        salvarBotao.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        salvarBotao.setForeground(new java.awt.Color(255, 255, 255));
        salvarBotao.setText("Salvar alterações");
        salvarBotao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salvarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarBotaoActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Papyrus", 0, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Carisma");
        jLayeredPane1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 80, 30));

        jLabel7.setFont(new java.awt.Font("Papyrus", 0, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Sabedoria");
        jLayeredPane1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 80, 30));

        jLabel9.setFont(new java.awt.Font("Papyrus", 0, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Inteligência");
        jLayeredPane1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 80, 30));

        jLabel11.setFont(new java.awt.Font("Papyrus", 0, 10)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Constituição");
        jLayeredPane1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 80, 30));

        jLabel13.setFont(new java.awt.Font("Papyrus", 0, 10)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Destreza");
        jLayeredPane1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 80, 30));

        jLabel15.setFont(new java.awt.Font("Papyrus", 0, 10)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Força");
        jLayeredPane1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 30));

        ForMod.setForeground(new java.awt.Color(255, 255, 255));
        ForMod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ForMod.setText("0");
        jLayeredPane1.add(ForMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 20, 24));

        DesMod.setForeground(new java.awt.Color(255, 255, 255));
        DesMod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DesMod.setText("0");
        jLayeredPane1.add(DesMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 20, 24));

        ConMod.setForeground(new java.awt.Color(255, 255, 255));
        ConMod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ConMod.setText("0");
        jLayeredPane1.add(ConMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 20, 24));

        IntMod.setForeground(new java.awt.Color(255, 255, 255));
        IntMod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IntMod.setText("0");
        jLayeredPane1.add(IntMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 20, 24));

        SabMod.setForeground(new java.awt.Color(255, 255, 255));
        SabMod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SabMod.setText("0");
        jLayeredPane1.add(SabMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 20, 24));

        CarMod.setForeground(new java.awt.Color(255, 255, 255));
        CarMod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CarMod.setText("0");
        jLayeredPane1.add(CarMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 20, 24));

        ForLabel.setBackground(new java.awt.Color(23, 23, 23));
        ForLabel.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        ForLabel.setForeground(new java.awt.Color(255, 255, 255));
        ForLabel.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ForLabel.setText("10");
        ForLabel.setBorder(null);
        ForLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ForLabel.setMinimumSize(new java.awt.Dimension(70, 16));
        ForLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ForLabelActionPerformed(evt);
            }
        });
        jLayeredPane1.add(ForLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, 70));

        DesLabel.setBackground(new java.awt.Color(23, 23, 23));
        DesLabel.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        DesLabel.setForeground(new java.awt.Color(255, 255, 255));
        DesLabel.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DesLabel.setText("10");
        DesLabel.setBorder(null);
        DesLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        DesLabel.setMinimumSize(new java.awt.Dimension(70, 16));
        jLayeredPane1.add(DesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 100, 70));

        ConLabel.setBackground(new java.awt.Color(23, 23, 23));
        ConLabel.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        ConLabel.setForeground(new java.awt.Color(255, 255, 255));
        ConLabel.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ConLabel.setText("10");
        ConLabel.setBorder(null);
        ConLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ConLabel.setMinimumSize(new java.awt.Dimension(70, 16));
        jLayeredPane1.add(ConLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 100, 70));

        IntLabel.setBackground(new java.awt.Color(23, 23, 23));
        IntLabel.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        IntLabel.setForeground(new java.awt.Color(255, 255, 255));
        IntLabel.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        IntLabel.setText("10");
        IntLabel.setBorder(null);
        IntLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        IntLabel.setMinimumSize(new java.awt.Dimension(70, 16));
        jLayeredPane1.add(IntLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 100, 70));

        SabLabel.setBackground(new java.awt.Color(23, 23, 23));
        SabLabel.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        SabLabel.setForeground(new java.awt.Color(255, 255, 255));
        SabLabel.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SabLabel.setText("10");
        SabLabel.setBorder(null);
        SabLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        SabLabel.setMinimumSize(new java.awt.Dimension(70, 16));
        jLayeredPane1.add(SabLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 100, 70));

        CarLabel.setBackground(new java.awt.Color(23, 23, 23));
        CarLabel.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        CarLabel.setForeground(new java.awt.Color(255, 255, 255));
        CarLabel.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CarLabel.setText("10");
        CarLabel.setBorder(null);
        CarLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        CarLabel.setMinimumSize(new java.awt.Dimension(70, 16));
        jLayeredPane1.add(CarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 100, 70));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visual/res/ContainerStatus.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLayeredPane1.setLayer(jLabel5, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 100, 100));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visual/res/ContainerStatus.png"))); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLayeredPane1.setLayer(jLabel6, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 100, 100));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visual/res/ContainerStatus.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLayeredPane1.setLayer(jLabel8, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 100, 100));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visual/res/ContainerStatus.png"))); // NOI18N
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLayeredPane1.setLayer(jLabel10, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 100, 100));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visual/res/ContainerStatus.png"))); // NOI18N
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLayeredPane1.setLayer(jLabel12, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 100, 100));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visual/res/ContainerStatus.png"))); // NOI18N
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLayeredPane1.setLayer(jLabel14, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 100));

        ClassesRow.setBackground(new java.awt.Color(23, 23, 23));

        ClasseLabel.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        ClasseLabel.setForeground(new java.awt.Color(101, 219, 219));
        ClasseLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ClasseLabel.setText("Selecione a sua classe");
        ClasseLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Classe:");

        javax.swing.GroupLayout ClassesRowLayout = new javax.swing.GroupLayout(ClassesRow);
        ClassesRow.setLayout(ClassesRowLayout);
        ClassesRowLayout.setHorizontalGroup(
            ClassesRowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ClassesRowLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(ClasseLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(101, Short.MAX_VALUE))
        );
        ClassesRowLayout.setVerticalGroup(
            ClassesRowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClassesRowLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ClassesRowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ClassesRowLayout.createSequentialGroup()
                        .addGap(0, 3, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addComponent(ClasseLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setOpaque(false);

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("/");

        VidaTotal.setBackground(new java.awt.Color(23, 23, 23));
        VidaTotal.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        VidaTotal.setForeground(new java.awt.Color(255, 255, 255));
        VidaTotal.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        VidaTotal.setText("0");
        VidaTotal.setBorder(null);
        VidaTotal.setMinimumSize(new java.awt.Dimension(104, 64));
        VidaTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VidaTotalActionPerformed(evt);
            }
        });

        VidaAtual.setBackground(new java.awt.Color(23, 23, 23));
        VidaAtual.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        VidaAtual.setForeground(new java.awt.Color(255, 255, 255));
        VidaAtual.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        VidaAtual.setText("0");
        VidaAtual.setBorder(null);
        VidaAtual.setMinimumSize(new java.awt.Dimension(104, 64));
        VidaAtual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VidaAtualActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(VidaAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel39)
                .addGap(0, 0, 0)
                .addComponent(VidaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(VidaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VidaAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Raça:");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nível:");

        jLabel16.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Antecedente:");

        jLabel17.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Xp:");

        RacaSelect.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        RacaSelect.setForeground(new java.awt.Color(101, 219, 219));
        RacaSelect.setText("Selecione");
        RacaSelect.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        LevelLabel.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        LevelLabel.setForeground(new java.awt.Color(101, 219, 219));
        LevelLabel.setText("Selecione");

        XpLabel.setBackground(new java.awt.Color(23, 23, 23));
        XpLabel.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        XpLabel.setForeground(new java.awt.Color(255, 255, 255));
        XpLabel.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        XpLabel.setText("0");
        XpLabel.setBorder(null);

        AntecedenteLabel.setBackground(new java.awt.Color(23, 23, 23));
        AntecedenteLabel.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        AntecedenteLabel.setForeground(new java.awt.Color(101, 219, 219));
        AntecedenteLabel.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        AntecedenteLabel.setText("Digite seu antecedente");
        AntecedenteLabel.setBorder(null);
        AntecedenteLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AntecedenteLabelActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(23, 23, 23));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 195), 2, true));

        PericiasContainer.setOpaque(false);

        javax.swing.GroupLayout PericiasContainerLayout = new javax.swing.GroupLayout(PericiasContainer);
        PericiasContainer.setLayout(PericiasContainerLayout);
        PericiasContainerLayout.setHorizontalGroup(
            PericiasContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 154, Short.MAX_VALUE)
        );
        PericiasContainerLayout.setVerticalGroup(
            PericiasContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );

        jLabel18.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Pericias:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addComponent(PericiasContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel18)
                .addGap(15, 15, 15)
                .addComponent(PericiasContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(23, 23, 23));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 195), 2, true));

        jLabel19.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Testes de resistência:");

        ForResCheck.setForeground(new java.awt.Color(255, 255, 255));

        DesResCheck.setForeground(new java.awt.Color(255, 255, 255));
        DesResCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DesResCheckActionPerformed(evt);
            }
        });

        ConResCheck.setForeground(new java.awt.Color(255, 255, 255));

        IntResCheck.setForeground(new java.awt.Color(255, 255, 255));

        SabResCheck.setForeground(new java.awt.Color(255, 255, 255));

        CarResCheck.setForeground(new java.awt.Color(255, 255, 255));

        ForResMod.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        ForResMod.setForeground(new java.awt.Color(255, 255, 255));
        ForResMod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ForResMod.setText("0");

        DesResMod.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        DesResMod.setForeground(new java.awt.Color(255, 255, 255));
        DesResMod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DesResMod.setText("0");

        ConResMod.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        ConResMod.setForeground(new java.awt.Color(255, 255, 255));
        ConResMod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ConResMod.setText("0");

        IntResMod.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        IntResMod.setForeground(new java.awt.Color(255, 255, 255));
        IntResMod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IntResMod.setText("0");

        SabResMod.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        SabResMod.setForeground(new java.awt.Color(255, 255, 255));
        SabResMod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SabResMod.setText("0");

        CarResMod.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CarResMod.setForeground(new java.awt.Color(255, 255, 255));
        CarResMod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CarResMod.setText("0");

        jLabel34.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Força");

        jLabel35.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Destreza");

        jLabel36.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Constituição");

        jLabel40.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Inteligência");

        jLabel38.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Sabedoria");

        jLabel37.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Carisma");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ConResCheck)
                            .addComponent(IntResCheck))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(IntResMod, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(ConResMod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SabResCheck)
                            .addComponent(CarResCheck))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SabResMod, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(CarResMod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(DesResCheck)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DesResMod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(ForResCheck)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ForResMod, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ForResCheck)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ForResMod)
                                        .addComponent(jLabel34)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DesResCheck))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(DesResMod)
                                .addComponent(jLabel35)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ConResCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IntResCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SabResCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CarResCheck))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CarResMod)
                        .addComponent(jLabel37))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ConResMod)
                            .addComponent(jLabel36))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addGap(50, 50, 50))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(IntResMod)
                                .addGap(50, 50, 50))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(SabResMod)
                                    .addComponent(jLabel38))
                                .addGap(25, 25, 25)))))
                .addGap(15, 15, 15)
                .addComponent(jLabel19)
                .addGap(15, 15, 15))
        );

        jPanel5.setBackground(new java.awt.Color(23, 23, 23));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(35, 35, 195)));
        jPanel5.setPreferredSize(new java.awt.Dimension(221, 221));

        jLabel41.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Bônus de proficiência");

        BonusProficienciaLabel.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        BonusProficienciaLabel.setForeground(new java.awt.Color(255, 255, 255));
        BonusProficienciaLabel.setText("+0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel41)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BonusProficienciaLabel)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(BonusProficienciaLabel)
                .addGap(15, 15, 15)
                .addComponent(jLabel41)
                .addGap(15, 15, 15))
        );

        VidaCura.setForeground(new java.awt.Color(255, 255, 255));
        VidaCura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        VidaCura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visual/res/up.png"))); // NOI18N
        VidaCura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        VidaDano.setForeground(new java.awt.Color(255, 255, 255));
        VidaDano.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        VidaDano.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visual/res/down.png"))); // NOI18N
        VidaDano.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel23.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Alinhamento:");

        AlinhamentoSelect.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        AlinhamentoSelect.setForeground(new java.awt.Color(101, 219, 219));
        AlinhamentoSelect.setText("Selecione");
        AlinhamentoSelect.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel10.setBackground(new java.awt.Color(23, 23, 23));
        jPanel10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(35, 35, 195)));
        jPanel10.setPreferredSize(new java.awt.Dimension(221, 221));

        jLabel43.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Iniciativa");

        BonusIniciativaLabel.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        BonusIniciativaLabel.setForeground(new java.awt.Color(255, 255, 255));
        BonusIniciativaLabel.setText("+0");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43)
                    .addComponent(BonusIniciativaLabel))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(BonusIniciativaLabel)
                .addGap(15, 15, 15)
                .addComponent(jLabel43)
                .addGap(15, 15, 15))
        );

        jPanel14.setBackground(new java.awt.Color(23, 23, 23));
        jPanel14.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 0, new java.awt.Color(35, 35, 195)));
        jPanel14.setPreferredSize(new java.awt.Dimension(221, 221));

        jLabel44.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Classe de armadura");

        BonusCALabel.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        BonusCALabel.setForeground(new java.awt.Color(255, 255, 255));
        BonusCALabel.setText("10");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addComponent(jLabel44)
                .addGap(0, 21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BonusCALabel)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(BonusCALabel)
                .addGap(15, 15, 15)
                .addComponent(jLabel44)
                .addGap(15, 15, 15))
        );

        jPanel19.setBackground(new java.awt.Color(23, 23, 23));
        jPanel19.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 195), 2, true));
        jPanel19.setPreferredSize(new java.awt.Dimension(221, 221));

        jLabel46.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Testes de Salvamento");

        jLabel47.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Sucessos:");

        jLabel48.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Fracessos:");

        Sucesso1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sucesso1ActionPerformed(evt);
            }
        });

        Sucesso2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sucesso2ActionPerformed(evt);
            }
        });

        Sucesso3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sucesso3ActionPerformed(evt);
            }
        });

        Fracesso1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Fracesso1ActionPerformed(evt);
            }
        });

        Fracesso2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Fracesso2ActionPerformed(evt);
            }
        });

        Fracesso3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Fracesso3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel46)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel47)
                        .addGap(18, 18, 18)
                        .addComponent(Sucesso1)
                        .addGap(18, 18, 18)
                        .addComponent(Sucesso2))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Fracesso1)
                        .addGap(18, 18, 18)
                        .addComponent(Fracesso2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Fracesso3)
                    .addComponent(Sucesso3))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel47)
                        .addComponent(Sucesso1))
                    .addComponent(Sucesso2)
                    .addComponent(Sucesso3))
                .addGap(14, 14, 14)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel48)
                    .addComponent(Fracesso1)
                    .addComponent(Fracesso2)
                    .addComponent(Fracesso3))
                .addGap(15, 15, 15)
                .addComponent(jLabel46)
                .addGap(15, 15, 15))
        );

        jPanel18.setBackground(new java.awt.Color(23, 23, 23));
        jPanel18.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(35, 35, 195)));
        jPanel18.setPreferredSize(new java.awt.Dimension(221, 221));

        jLabel45.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Inspiração");

        InspiracaoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visual/res/Unchecked.png"))); // NOI18N
        InspiracaoLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(0, 52, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(InspiracaoLabel)
                    .addComponent(jLabel45))
                .addGap(0, 51, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addGap(0, 18, Short.MAX_VALUE)
                .addComponent(InspiracaoLabel)
                .addGap(15, 15, 15)
                .addComponent(jLabel45)
                .addGap(15, 15, 15))
        );

        jPanel21.setBackground(new java.awt.Color(23, 23, 23));
        jPanel21.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 1, new java.awt.Color(35, 35, 195)));
        jPanel21.setPreferredSize(new java.awt.Dimension(221, 221));

        jLabel50.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Percepção Passiva");

        PercepcaoPassivaLabel.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        PercepcaoPassivaLabel.setForeground(new java.awt.Color(255, 255, 255));
        PercepcaoPassivaLabel.setText("10");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(0, 24, Short.MAX_VALUE)
                .addComponent(jLabel50)
                .addGap(0, 24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(PercepcaoPassivaLabel)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(PercepcaoPassivaLabel)
                .addGap(15, 15, 15)
                .addComponent(jLabel50)
                .addGap(15, 15, 15))
        );

        jPanel12.setBackground(new java.awt.Color(23, 23, 23));
        jPanel12.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 0, new java.awt.Color(35, 35, 195)));
        jPanel12.setPreferredSize(new java.awt.Dimension(221, 221));

        jLabel51.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Deslocamento");

        MovimentacaoText.setBackground(new java.awt.Color(23, 23, 23));
        MovimentacaoText.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        MovimentacaoText.setForeground(new java.awt.Color(255, 255, 255));
        MovimentacaoText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MovimentacaoText.setText("0.0");
        MovimentacaoText.setBorder(null);
        MovimentacaoText.setMinimumSize(new java.awt.Dimension(104, 64));
        MovimentacaoText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MovimentacaoTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(0, 18, Short.MAX_VALUE)
                .addComponent(MovimentacaoText, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel51)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(MovimentacaoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel51)
                .addGap(15, 15, 15))
        );

        jSeparator2.setBackground(new java.awt.Color(35, 35, 195));
        jSeparator2.setForeground(new java.awt.Color(35, 35, 195));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(VidaDano, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(VidaCura))
                .addContainerGap(185, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(18, 18, 18)
                        .addComponent(AlinhamentoSelect)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(LabelNome)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(LevelLabel))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(RacaSelect))
                            .addComponent(ClassesRow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(AntecedenteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addComponent(XpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(19, 19, 19))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(salvarBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(LabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(ClassesRow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(RacaSelect))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(LevelLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(XpLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(AlinhamentoSelect))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(AntecedenteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(318, 318, 318)
                        .addComponent(VidaCura)
                        .addGap(0, 0, 0)
                        .addComponent(VidaDano)))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 371, Short.MAX_VALUE)
                .addComponent(salvarBotao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(23, 23, 23))
        );

        jScrollPaneGeral.setViewportView(jPanel2);

        jScrollPaneInventario.setBorder(null);
        jScrollPaneInventario.setPreferredSize(new java.awt.Dimension(672, 438));

        jPanel15.setBackground(new java.awt.Color(23, 23, 23));
        jPanel15.setMinimumSize(new java.awt.Dimension(672, 0));
        jPanel15.setPreferredSize(new java.awt.Dimension(672, 438));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 672, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        AddEquip.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        AddEquip.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddEquip.setOpaque(false);

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Adicionar equipamento");

        javax.swing.GroupLayout AddEquipLayout = new javax.swing.GroupLayout(AddEquip);
        AddEquip.setLayout(AddEquipLayout);
        AddEquipLayout.setHorizontalGroup(
            AddEquipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddEquipLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        AddEquipLayout.setVerticalGroup(
            AddEquipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddEquipLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jScrollPaneMochilaItens.setBorder(null);
        jScrollPaneMochilaItens.setOpaque(false);
        jScrollPaneMochilaItens.setPreferredSize(new java.awt.Dimension(606, 200));

        PainelItens.setBackground(new java.awt.Color(23, 23, 23));
        PainelItens.setMaximumSize(new java.awt.Dimension(43, 606));

        javax.swing.GroupLayout PainelItensLayout = new javax.swing.GroupLayout(PainelItens);
        PainelItens.setLayout(PainelItensLayout);
        PainelItensLayout.setHorizontalGroup(
            PainelItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PainelItensLayout.setVerticalGroup(
            PainelItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
        );

        jScrollPaneMochilaItens.setViewportView(PainelItens);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AddEquip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPaneMochilaItens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(AddEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPaneMochilaItens, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE))
        );

        jScrollPaneInventario.setViewportView(jPanel15);

        jScrollPaneMagias.setBorder(null);
        jScrollPaneMagias.setPreferredSize(new java.awt.Dimension(672, 438));

        jPanel16.setBackground(new java.awt.Color(23, 23, 23));
        jPanel16.setPreferredSize(new java.awt.Dimension(400, 600));

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Feitiços");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(345, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addGap(277, 277, 277))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel25)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPaneMagias.setViewportView(jPanel16);

        jScrollPaneEspecializacao.setBorder(null);
        jScrollPaneEspecializacao.setPreferredSize(new java.awt.Dimension(672, 438));

        PainelEspecializacoes.setBackground(new java.awt.Color(23, 23, 23));
        PainelEspecializacoes.setPreferredSize(new java.awt.Dimension(400, 600));

        PCarRaca.setOpaque(false);

        PCarRacaT.setBackground(new java.awt.Color(35, 35, 35));

        jLabel21.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(101, 219, 219));
        jLabel21.setText("Caracteristicas de raça");

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visual/res/plus.png"))); // NOI18N

        javax.swing.GroupLayout PCarRacaTLayout = new javax.swing.GroupLayout(PCarRacaT);
        PCarRacaT.setLayout(PCarRacaTLayout);
        PCarRacaTLayout.setHorizontalGroup(
            PCarRacaTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCarRacaTLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 313, Short.MAX_VALUE)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCarRacaTLayout.setVerticalGroup(
            PCarRacaTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCarRacaTLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PCarRacaC.setOpaque(false);

        javax.swing.GroupLayout PCarRacaCLayout = new javax.swing.GroupLayout(PCarRacaC);
        PCarRacaC.setLayout(PCarRacaCLayout);
        PCarRacaCLayout.setHorizontalGroup(
            PCarRacaCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PCarRacaCLayout.setVerticalGroup(
            PCarRacaCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PCarRacaLayout = new javax.swing.GroupLayout(PCarRaca);
        PCarRaca.setLayout(PCarRacaLayout);
        PCarRacaLayout.setHorizontalGroup(
            PCarRacaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PCarRacaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(PCarRacaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PCarRacaC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PCarRacaT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PCarRacaLayout.setVerticalGroup(
            PCarRacaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCarRacaLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(PCarRacaT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(PCarRacaC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PCarClasse.setOpaque(false);

        PCarClasseT.setBackground(new java.awt.Color(35, 35, 35));

        jLabel22.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(101, 219, 219));
        jLabel22.setText("Caracteristicas de Classe");

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visual/res/plus.png"))); // NOI18N

        javax.swing.GroupLayout PCarClasseTLayout = new javax.swing.GroupLayout(PCarClasseT);
        PCarClasseT.setLayout(PCarClasseTLayout);
        PCarClasseTLayout.setHorizontalGroup(
            PCarClasseTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCarClasseTLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 321, Short.MAX_VALUE)
                .addComponent(jLabel28))
        );
        PCarClasseTLayout.setVerticalGroup(
            PCarClasseTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCarClasseTLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PCarClasseC.setOpaque(false);

        javax.swing.GroupLayout PCarClasseCLayout = new javax.swing.GroupLayout(PCarClasseC);
        PCarClasseC.setLayout(PCarClasseCLayout);
        PCarClasseCLayout.setHorizontalGroup(
            PCarClasseCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PCarClasseCLayout.setVerticalGroup(
            PCarClasseCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PCarClasseLayout = new javax.swing.GroupLayout(PCarClasse);
        PCarClasse.setLayout(PCarClasseLayout);
        PCarClasseLayout.setHorizontalGroup(
            PCarClasseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PCarClasseLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(PCarClasseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PCarClasseC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PCarClasseT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        PCarClasseLayout.setVerticalGroup(
            PCarClasseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCarClasseLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(PCarClasseT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(PCarClasseC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        PTalentos.setOpaque(false);

        PTalentosT.setBackground(new java.awt.Color(35, 35, 35));

        jLabel24.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(101, 219, 219));
        jLabel24.setText("Talentos");

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visual/res/plus.png"))); // NOI18N

        javax.swing.GroupLayout PTalentosTLayout = new javax.swing.GroupLayout(PTalentosT);
        PTalentosT.setLayout(PTalentosTLayout);
        PTalentosTLayout.setHorizontalGroup(
            PTalentosTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PTalentosTLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel29))
        );
        PTalentosTLayout.setVerticalGroup(
            PTalentosTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PTalentosTLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PTalentosC.setOpaque(false);

        javax.swing.GroupLayout PTalentosCLayout = new javax.swing.GroupLayout(PTalentosC);
        PTalentosC.setLayout(PTalentosCLayout);
        PTalentosCLayout.setHorizontalGroup(
            PTalentosCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PTalentosCLayout.setVerticalGroup(
            PTalentosCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PTalentosLayout = new javax.swing.GroupLayout(PTalentos);
        PTalentos.setLayout(PTalentosLayout);
        PTalentosLayout.setHorizontalGroup(
            PTalentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PTalentosLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(PTalentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PTalentosC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PTalentosT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        PTalentosLayout.setVerticalGroup(
            PTalentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PTalentosLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(PTalentosT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(PTalentosC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        PIdiomas.setOpaque(false);

        PIdiomasT.setBackground(new java.awt.Color(35, 35, 35));

        jLabel26.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(101, 219, 219));
        jLabel26.setText("Idiomas");

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visual/res/plus.png"))); // NOI18N

        javax.swing.GroupLayout PIdiomasTLayout = new javax.swing.GroupLayout(PIdiomasT);
        PIdiomasT.setLayout(PIdiomasTLayout);
        PIdiomasTLayout.setHorizontalGroup(
            PIdiomasTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PIdiomasTLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel30))
        );
        PIdiomasTLayout.setVerticalGroup(
            PIdiomasTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PIdiomasTLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PIdiomasC.setOpaque(false);

        javax.swing.GroupLayout PIdiomasCLayout = new javax.swing.GroupLayout(PIdiomasC);
        PIdiomasC.setLayout(PIdiomasCLayout);
        PIdiomasCLayout.setHorizontalGroup(
            PIdiomasCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PIdiomasCLayout.setVerticalGroup(
            PIdiomasCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PIdiomasLayout = new javax.swing.GroupLayout(PIdiomas);
        PIdiomas.setLayout(PIdiomasLayout);
        PIdiomasLayout.setHorizontalGroup(
            PIdiomasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PIdiomasLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(PIdiomasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PIdiomasC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PIdiomasT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        PIdiomasLayout.setVerticalGroup(
            PIdiomasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PIdiomasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PIdiomasT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PIdiomasC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCarExtra.setOpaque(false);

        PCarExtraT.setBackground(new java.awt.Color(35, 35, 35));

        jLabel31.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(101, 219, 219));
        jLabel31.setText("Caracteristicas extras");

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visual/res/plus.png"))); // NOI18N

        javax.swing.GroupLayout PCarExtraTLayout = new javax.swing.GroupLayout(PCarExtraT);
        PCarExtraT.setLayout(PCarExtraTLayout);
        PCarExtraTLayout.setHorizontalGroup(
            PCarExtraTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCarExtraTLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCarExtraTLayout.setVerticalGroup(
            PCarExtraTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCarExtraTLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PCarExtraC.setOpaque(false);

        javax.swing.GroupLayout PCarExtraCLayout = new javax.swing.GroupLayout(PCarExtraC);
        PCarExtraC.setLayout(PCarExtraCLayout);
        PCarExtraCLayout.setHorizontalGroup(
            PCarExtraCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PCarExtraCLayout.setVerticalGroup(
            PCarExtraCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PCarExtraLayout = new javax.swing.GroupLayout(PCarExtra);
        PCarExtra.setLayout(PCarExtraLayout);
        PCarExtraLayout.setHorizontalGroup(
            PCarExtraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PCarExtraLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(PCarExtraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PCarExtraC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PCarExtraT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        PCarExtraLayout.setVerticalGroup(
            PCarExtraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCarExtraLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PCarExtraT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PCarExtraC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout PainelEspecializacoesLayout = new javax.swing.GroupLayout(PainelEspecializacoes);
        PainelEspecializacoes.setLayout(PainelEspecializacoesLayout);
        PainelEspecializacoesLayout.setHorizontalGroup(
            PainelEspecializacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelEspecializacoesLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(PainelEspecializacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PCarRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCarClasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PTalentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PIdiomas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PCarExtra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(57, 57, 57))
        );
        PainelEspecializacoesLayout.setVerticalGroup(
            PainelEspecializacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelEspecializacoesLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(PCarRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(PCarClasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(PTalentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(PIdiomas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(PCarExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(191, Short.MAX_VALUE))
        );

        jScrollPaneEspecializacao.setViewportView(PainelEspecializacoes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPaneGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPaneInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPaneMagias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPaneEspecializacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPaneInventario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPaneGeral, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPaneMagias, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPaneEspecializacao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        AppScrollPane.setViewportView(jPanel1);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(AppScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(AppScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salvarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarBotaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salvarBotaoActionPerformed

    private void LabelNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LabelNomeActionPerformed

    }//GEN-LAST:event_LabelNomeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        trocarPainel mudar = new trocarPainel();
        SelectPersonagem novoFrame = new SelectPersonagem();
        mudar.painelChange(novoFrame);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void VidaTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VidaTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VidaTotalActionPerformed

    private void AntecedenteLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AntecedenteLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AntecedenteLabelActionPerformed

    private void DesResCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DesResCheckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DesResCheckActionPerformed

    private void VidaAtualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VidaAtualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VidaAtualActionPerformed

    private void ForLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ForLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ForLabelActionPerformed

    private void Sucesso1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sucesso1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Sucesso1ActionPerformed

    private void Sucesso2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sucesso2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Sucesso2ActionPerformed

    private void Sucesso3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sucesso3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Sucesso3ActionPerformed

    private void Fracesso1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Fracesso1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Fracesso1ActionPerformed

    private void Fracesso2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Fracesso2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Fracesso2ActionPerformed

    private void Fracesso3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Fracesso3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Fracesso3ActionPerformed

    private void MovimentacaoTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MovimentacaoTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MovimentacaoTextActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(personagemFicha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(personagemFicha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(personagemFicha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(personagemFicha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddEquip;
    private javax.swing.JLabel AlinhamentoSelect;
    private javax.swing.JTextField AntecedenteLabel;
    private javax.swing.JScrollPane AppScrollPane;
    private javax.swing.JLabel BonusCALabel;
    private javax.swing.JLabel BonusIniciativaLabel;
    private javax.swing.JLabel BonusProficienciaLabel;
    private javax.swing.JTextField CarLabel;
    private javax.swing.JLabel CarMod;
    private javax.swing.JCheckBox CarResCheck;
    private javax.swing.JLabel CarResMod;
    private javax.swing.JLabel CaracteristicasNavBar;
    private javax.swing.JLabel ClasseLabel;
    private javax.swing.JPanel ClassesRow;
    private javax.swing.JTextField ConLabel;
    private javax.swing.JLabel ConMod;
    private javax.swing.JCheckBox ConResCheck;
    private javax.swing.JLabel ConResMod;
    private javax.swing.JTextField DesLabel;
    private javax.swing.JLabel DesMod;
    private javax.swing.JCheckBox DesResCheck;
    private javax.swing.JLabel DesResMod;
    private javax.swing.JTextField ForLabel;
    private javax.swing.JLabel ForMod;
    private javax.swing.JCheckBox ForResCheck;
    private javax.swing.JLabel ForResMod;
    private javax.swing.JCheckBox Fracesso1;
    private javax.swing.JCheckBox Fracesso2;
    private javax.swing.JCheckBox Fracesso3;
    private javax.swing.JLabel GeralNavBar;
    private javax.swing.JLabel InspiracaoLabel;
    private javax.swing.JTextField IntLabel;
    private javax.swing.JLabel IntMod;
    private javax.swing.JCheckBox IntResCheck;
    private javax.swing.JLabel IntResMod;
    private javax.swing.JLabel InventarioNavBar;
    private javax.swing.JTextField LabelNome;
    private javax.swing.JLabel LevelLabel;
    private javax.swing.JLabel MagiasNavBar;
    private javax.swing.JTextField MovimentacaoText;
    private javax.swing.JPanel PCarClasse;
    private javax.swing.JPanel PCarClasseC;
    private javax.swing.JPanel PCarClasseT;
    private javax.swing.JPanel PCarExtra;
    private javax.swing.JPanel PCarExtraC;
    private javax.swing.JPanel PCarExtraT;
    private javax.swing.JPanel PCarRaca;
    private javax.swing.JPanel PCarRacaC;
    private javax.swing.JPanel PCarRacaT;
    private javax.swing.JPanel PIdiomas;
    private javax.swing.JPanel PIdiomasC;
    private javax.swing.JPanel PIdiomasT;
    private javax.swing.JPanel PTalentos;
    private javax.swing.JPanel PTalentosC;
    private javax.swing.JPanel PTalentosT;
    private javax.swing.JPanel PainelEspecializacoes;
    private javax.swing.JPanel PainelItens;
    private javax.swing.JLabel PercepcaoPassivaLabel;
    private javax.swing.JPanel PericiasContainer;
    private javax.swing.JLabel RacaSelect;
    private javax.swing.JTextField SabLabel;
    private javax.swing.JLabel SabMod;
    private javax.swing.JCheckBox SabResCheck;
    private javax.swing.JLabel SabResMod;
    private javax.swing.JCheckBox Sucesso1;
    private javax.swing.JCheckBox Sucesso2;
    private javax.swing.JCheckBox Sucesso3;
    private javax.swing.JTextField VidaAtual;
    private javax.swing.JLabel VidaCura;
    private javax.swing.JLabel VidaDano;
    private javax.swing.JTextField VidaTotal;
    private javax.swing.JTextField XpLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPaneEspecializacao;
    private javax.swing.JScrollPane jScrollPaneGeral;
    private javax.swing.JScrollPane jScrollPaneInventario;
    private javax.swing.JScrollPane jScrollPaneMagias;
    private javax.swing.JScrollPane jScrollPaneMochilaItens;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton salvarBotao;
    // End of variables declaration//GEN-END:variables
}
