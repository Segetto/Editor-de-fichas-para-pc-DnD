/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.EditarItemJanela;

import javax.swing.*;
import backend.Fun.OrganizarASSET;
import org.json.*;
import java.awt.*;
import java.awt.event.*;
import backend.Fun.VirtualObjects.NewItemArrayVO;
import backend.jsonParser;
import static backend.Fun.IntCampo.*;
import static backend.Fun.Par.Inventario.EquipamentosAddP.EquipamentosAddP;
import static backend.Fun.Par.Inventario.InventarioPanelP.ItensPanelP;
import static backend.Fun.SalvarFicha.SalvarFicha;
import javax.swing.border.MatteBorder;

/**
 *
 * @author Admin
 */
public class EditarItemSelectDinamico {

    public static void EditarItemSelectDinamico(JTextField NomeComp, JTextArea DescricaoComp, JTextField ValorComp, JComboBox TipoValorComp, JTextField PesoComp, JTextField QtdPadraoComp, JComboBox TipoQtdComp, JComboBox TipoItemComp, JPanel OpcoesExtra, JLabel AddItem, JSONArray equipamentos, String personagemCaminho, JSONObject ficha, JPanel PainelItensFicha, JLabel BonusCALabel, JPanel EquipamentoPainel, JPanel AddEquip, String TipoEdit, int pos, JLabel PesoAtual, JLabel PesoMaximo) {
        JPanel[] TiposItem = new JPanel[4];
        OpcoesExtra.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH; // Expande horizontal e verticalmente
        gbc.weightx = 1.0; // Permite expansão horizontal
        gbc.weighty = 1.0; // Não cresce infinitamente
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Ocupa toda a linha
        gbc.insets = new Insets(0, 0, 0, 0); // Espaço entre os itens
        JPanel OpcoesArma = new JPanel();
        OpcoesArma.setLayout(new BoxLayout(OpcoesArma, BoxLayout.Y_AXIS));
        OpcoesArma.setOpaque(false);
        JPanel OpcoesArmadura = new JPanel();
        OpcoesArmadura.setLayout(new BoxLayout(OpcoesArmadura, BoxLayout.Y_AXIS));
        OpcoesArmadura.setOpaque(false);
        JPanel OpcoesEscudo = new JPanel();
        OpcoesEscudo.setLayout(new BoxLayout(OpcoesEscudo, BoxLayout.Y_AXIS));
        OpcoesEscudo.setOpaque(false);
        JPanel PArmaTipoT = new JPanel(new BorderLayout());
        PArmaTipoT.setOpaque(false);
        JLabel ArmaTipoT = new JLabel("Tipo de dano:");
        ArmaTipoT.setForeground(new Color(255, 255, 255));
        ArmaTipoT.setHorizontalAlignment(SwingConstants.LEFT);
        ArmaTipoT.setHorizontalAlignment(SwingConstants.LEFT);
        JTextField ArmaTipo = new JTextField(ficha.getJSONArray("i").getJSONObject(pos).getJSONObject("b").getString("b"));

        JPanel PArmaPropriedadesT = new JPanel(new BorderLayout());
        PArmaPropriedadesT.setOpaque(false);
        JLabel ArmaPropriedadesT = new JLabel("Propriedades especiais da arma:");
        ArmaPropriedadesT.setForeground(new Color(255, 255, 255));
        JTextField ArmaPropriedades = new JTextField(ficha.getJSONArray("i").getJSONObject(pos).getJSONObject("b").getString("w"));
        JPanel PArmaDadosDanoT = new JPanel(new BorderLayout());
        PArmaDadosDanoT.setOpaque(false);
        JLabel ArmaDadosDanoT = new JLabel("Dados de dano");
        ArmaDadosDanoT.setForeground(new Color(255, 255, 255));
        String DadosDano = "1d4";
        if (ficha.getJSONArray("i").getJSONObject(pos).getJSONObject("b").has("1")) {
            DadosDano = ficha.getJSONArray("i").getJSONObject(pos).getJSONObject("b").getString("1");
        }
        JTextField ArmaDadosDano = new JTextField(DadosDano);

        JPanel PArmaAtributo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        PArmaAtributo.setOpaque(false);
        JLabel ArmaAtributoT = new JLabel("Atributo: ");
        ArmaAtributoT.setForeground(new Color(255, 255, 255));
        String[] Status = {"Força", "Destreza", "Constituição", "Inteligência", "Sabedoria", "Carisma", "Nenhum"};
        JComboBox<String> ArmaAtributo = new JComboBox<>(Status);
        ArmaAtributo.setSelectedItem(GetNome(ficha.getJSONArray("i").getJSONObject(pos).getJSONObject("b").getString("q")));
        ArmaAtributo.setBackground(new Color(23, 23, 23));
        ArmaAtributo.setForeground(new Color(255, 255, 255));
        PArmaAtributo.add(ArmaAtributoT);
        PArmaAtributo.add(ArmaAtributo);
        JPanel PArmaDanoBonusT = new JPanel(new BorderLayout());
        PArmaDanoBonusT.setOpaque(false);
        JLabel ArmaDanoBonusT = new JLabel("Bônus de dano");
        ArmaDanoBonusT.setForeground(new Color(255, 255, 255));
        int BonusDano = 0;
        if (ficha.getJSONArray("i").getJSONObject(pos).getJSONObject("b").has("3")) {
            BonusDano = ficha.getJSONArray("i").getJSONObject(pos).getJSONObject("b").getInt("3");
        }
        JTextField ArmaDanoBonus = new JTextField("" + BonusDano);
        JPanel PArmaAtaqueBonusT = new JPanel(new BorderLayout());
        PArmaAtaqueBonusT.setOpaque(false);
        JLabel ArmaAtaqueBonusT = new JLabel("Bônus de ataque");
        ArmaAtaqueBonusT.setForeground(new Color(255, 255, 255));
        int BonusAtaque = 0;
        if (ficha.getJSONArray("i").getJSONObject(pos).getJSONObject("b").has("2")) {
            BonusAtaque = ficha.getJSONArray("i").getJSONObject(pos).getJSONObject("b").getInt("2");
        }
        JTextField ArmaAtaqueBonus = new JTextField("" + BonusAtaque);

// Campo armadura
        JPanel PCABaseT = new JPanel(new BorderLayout());
        PCABaseT.setOpaque(false);
        JLabel CABaseT = new JLabel("Classe de armadura base:");
        CABaseT.setForeground(new Color(255, 255, 255));
        CABaseT.setHorizontalAlignment(SwingConstants.LEFT);
        CABaseT.setHorizontalAlignment(SwingConstants.LEFT);
        JTextField CABase = new JTextField("" + ficha.getJSONArray("i").getJSONObject(pos).getJSONObject("b").getInt("j"));
        JPanel PArmaduraAtributo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        PArmaduraAtributo.setOpaque(false);
        JLabel ArmaduraAtributoT = new JLabel("Atributo: ");
        ArmaduraAtributoT.setForeground(new Color(255, 255, 255));
        JComboBox<String> ArmaduraAtributo = new JComboBox<>(Status);
        String ArmaduraAtributoFicha = "";
        if (ficha.getJSONArray("i").getJSONObject(pos).getJSONObject("b").has("k")) {
            ArmaduraAtributoFicha = ficha.getJSONArray("i").getJSONObject(pos).getJSONObject("b").getString("k");
        }
        ArmaduraAtributo.setSelectedItem(GetNome(ArmaduraAtributoFicha));
        ArmaduraAtributo.setBackground(new Color(23, 23, 23));
        ArmaduraAtributo.setForeground(new Color(255, 255, 255));
        PArmaduraAtributo.add(ArmaduraAtributoT);
        PArmaduraAtributo.add(ArmaduraAtributo);
        JPanel PLimiteStatusT = new JPanel(new BorderLayout());
        PLimiteStatusT.setOpaque(false);
        JLabel LimiteStatusT = new JLabel("Máximo do modificador de Status (0 = sem limite máximo):");
        LimiteStatusT.setForeground(new Color(255, 255, 255));
        JTextField LimiteStatus = new JTextField("" + ficha.getJSONArray("i").getJSONObject(pos).getJSONObject("b").getInt("l"));
        JPanel PForcaMinimaT = new JPanel(new BorderLayout());
        PForcaMinimaT.setOpaque(false);
        JLabel ForcaMinimaT = new JLabel("Força mínima");
        ForcaMinimaT.setForeground(new Color(255, 255, 255));
        JTextField ForcaMinima = new JTextField("" + ficha.getJSONArray("i").getJSONObject(pos).getJSONObject("b").getInt("n"));
        JCheckBox Desvantagem = new JCheckBox("Desvantagem em furtividade");
        Desvantagem.setSelected(ficha.getJSONArray("i").getJSONObject(pos).getJSONObject("b").getBoolean("m"));
// Campo escudo
        JPanel PBonusEscudoT = new JPanel(new BorderLayout());
        PBonusEscudoT.setOpaque(false);
        JLabel BonusEscudoT = new JLabel("Bônus de CA");
        BonusEscudoT.setForeground(new Color(255, 255, 255));
        JTextField BonusEscudo = new JTextField("" + ficha.getJSONArray("i").getJSONObject(pos).getJSONObject("b").getInt("o"));
        PBonusEscudoT.add(BonusEscudoT);

        JTextField[] camposTexto = {
            ArmaTipo, ArmaPropriedades, ArmaDadosDano, ArmaDanoBonus, ArmaAtaqueBonus, CABase, LimiteStatus, ForcaMinima, BonusEscudo
        };

        for (JTextField campo : camposTexto) {
            campo.setPreferredSize(new Dimension(150, 30));
            campo.setOpaque(false);
            campo.setBackground(new Color(23, 23, 23));
            campo.setForeground(new Color(255, 255, 255));
            campo.setBorder(new MatteBorder(0, 0, 2, 0, new Color(23, 23, 195)));
        }
        PArmaTipoT.add(ArmaTipoT, BorderLayout.CENTER);
        PArmaPropriedadesT.add(ArmaPropriedadesT, BorderLayout.CENTER);
        PArmaDadosDanoT.add(ArmaDadosDanoT, BorderLayout.CENTER);
        PArmaDanoBonusT.add(ArmaDanoBonusT, BorderLayout.CENTER);
        PArmaAtaqueBonusT.add(ArmaAtaqueBonusT, BorderLayout.CENTER);
        PCABaseT.add(CABaseT, BorderLayout.CENTER);
        PLimiteStatusT.add(LimiteStatusT, BorderLayout.CENTER);
        PForcaMinimaT.add(ForcaMinimaT, BorderLayout.CENTER);
        OpcoesArma.add(Box.createRigidArea(new Dimension(0, 23)));
        OpcoesArma.add(PArmaTipoT);
        OpcoesArma.add(ArmaTipo);
        OpcoesArma.add(Box.createRigidArea(new Dimension(0, 23)));
        OpcoesArma.add(PArmaPropriedadesT);
        OpcoesArma.add(ArmaPropriedades);
        OpcoesArma.add(Box.createRigidArea(new Dimension(0, 23)));
        OpcoesArma.add(PArmaAtributo);
        OpcoesArma.add(Box.createRigidArea(new Dimension(0, 23)));
        OpcoesArma.add(PArmaDadosDanoT);
        OpcoesArma.add(ArmaDadosDano);
        OpcoesArma.add(Box.createRigidArea(new Dimension(0, 23)));
        OpcoesArma.add(PArmaAtaqueBonusT);
        OpcoesArma.add(ArmaAtaqueBonus);
        OpcoesArma.add(Box.createRigidArea(new Dimension(0, 23)));
        OpcoesArma.add(PArmaDanoBonusT);
        OpcoesArma.add(ArmaDanoBonus);
        OpcoesArma.add(Box.createRigidArea(new Dimension(0, 23)));

        OpcoesArmadura.add(Box.createRigidArea(new Dimension(0, 23)));
        OpcoesArmadura.add(PCABaseT);
        OpcoesArmadura.add(CABase);
        OpcoesArmadura.add(Box.createRigidArea(new Dimension(0, 23)));
        OpcoesArmadura.add(PLimiteStatusT);
        OpcoesArmadura.add(LimiteStatus);
        OpcoesArmadura.add(Box.createRigidArea(new Dimension(0, 23)));
        OpcoesArmadura.add(PArmaduraAtributo);
        OpcoesArmadura.add(Box.createRigidArea(new Dimension(0, 23)));
        OpcoesArmadura.add(PForcaMinimaT);
        OpcoesArmadura.add(ForcaMinima);
        OpcoesArmadura.add(Box.createRigidArea(new Dimension(0, 23)));
        OpcoesArmadura.add(Desvantagem);

        OpcoesEscudo.add(Box.createRigidArea(new Dimension(0, 23)));
        OpcoesEscudo.add(PBonusEscudoT);
        OpcoesEscudo.add(BonusEscudo);

        OpcoesArma.setBounds(10, 10, 100, 100);
        OpcoesArmadura.setBounds(10, 10, 100, 100);
        OpcoesEscudo.setBounds(10, 10, 100, 100);
        TiposItem[0] = OpcoesArma;
        TiposItem[1] = OpcoesArmadura;
        TiposItem[2] = OpcoesEscudo;
        TiposItem[3] = new JPanel();
        gbc.gridy = 0;
        OpcoesExtra.add(TiposItem[0], gbc);
        gbc.gridy = 1;
        OpcoesExtra.add(TiposItem[1], gbc);
        gbc.gridy = 2;
        OpcoesExtra.add(TiposItem[2], gbc);
        for (Component Panel : TiposItem) {
            Panel.setVisible(false);
        }
        IntCampo(ArmaDanoBonus);
        IntCampo(ArmaAtaqueBonus);
        IntCampo(CABase);
        IntCampo(LimiteStatus);
        IntCampo(ForcaMinima);
        IntCampo(BonusEscudo);
        IntCampo(ValorComp);
        DoubleCampo(PesoComp);
        DoubleCampo(QtdPadraoComp);
        TiposItem[TipoItemComp.getSelectedIndex()].setVisible(true);
        AddItem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String Nome = NomeComp.getText();
                String Descricao = DescricaoComp.getText();
                int Valor = Integer.parseInt(ValorComp.getText());
                String TipoValor = (String) TipoValorComp.getSelectedItem();
                double Peso = Double.parseDouble(PesoComp.getText());
                double QtdPadrao = Double.parseDouble(QtdPadraoComp.getText());
                String TipoQtd = (String) TipoQtdComp.getSelectedItem();
                String TipoItem = (String) TipoItemComp.getSelectedItem();
                String ArmaTipoString = ArmaTipo.getText();
                String ArmaPropriedadesString = ArmaPropriedades.getText();
                String ArmaAtributoString = SetNome((String) ArmaAtributo.getSelectedItem());
                String ArmaDadosDanoString = ArmaDadosDano.getText();
                int ArmaAtaqueBonusInt = Integer.parseInt(ArmaAtaqueBonus.getText());
                int ArmaDanoBonusInt = Integer.parseInt(ArmaDanoBonus.getText());
                int CABaseInt = Integer.parseInt(CABase.getText());
                String ArmaduraAtributoString = SetNome((String) ArmaduraAtributo.getSelectedItem());
                int LimiteStatusInt = Integer.parseInt(LimiteStatus.getText());
                int ForcaMinimaInt = Integer.parseInt(ForcaMinima.getText());
                int BonusEscudoInt = Integer.parseInt(BonusEscudo.getText());
                boolean DesvantagemBool = Desvantagem.isSelected();
                ficha.getJSONArray("i").getJSONObject(pos).getJSONObject("b")
                        .put("b", ArmaTipoString)
                        .put("c", Valor) //Valor item
                        .put("d", TipoValor) //Tipo moeda
                        .put("e", Peso) //Peso
                        .put("g", QtdPadrao) //Quantidade padrão
                        .put("h", TipoQtd) //Tipo Quantidade padrão
                        .put("i", TipoItem) //Tipo item
                        .put("j", CABaseInt) //CA Base (Armadura)
                        .put("k", ArmaduraAtributoString) //Tipo de status armadura
                        .put("l", LimiteStatusInt) //Limite bonus de CA status
                        .put("m", DesvantagemBool) //Desvantagem de furtividade armadura
                        .put("n", ForcaMinimaInt) //Status necessário armadura
                        .put("o", BonusEscudoInt) //Bonus CA escudo
                        .put("q", ArmaAtributoString) //Status da arma
                        .put("u", Nome) //Nome
                        .put("v", Descricao)
                        .put("w", ArmaPropriedadesString) //Propriedade especial da arma
                        .put("1", ArmaDadosDanoString)
                        .put("2", ArmaAtaqueBonusInt)
                        .put("3", ArmaDanoBonusInt);
                SalvarFicha(ficha, personagemCaminho);
                ItensPanelP(personagemCaminho, ficha, PainelItensFicha, BonusCALabel, AddEquip, PesoAtual, PesoMaximo);
            }
        });
        TipoItemComp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Component Panel : TiposItem) {
                    Panel.setVisible(false);
                }
                TiposItem[TipoItemComp.getSelectedIndex()].setVisible(true);
            }
        });
    }

    public static String SetNome(String atributo) {
        return switch (atributo) {
            case "Força" ->
                "STRENGTH";
            case "Destreza" ->
                "DEXTERITY";
            case "Constituição" ->
                "CONSTITUTION";
            case "Inteligência" ->
                "INTELLIGENCE";
            case "Sabedoria" ->
                "WISDOM";
            case "Carisma" ->
                "CHARISMA";
            default ->
                "NONE";
        }; // Caso a string não corresponda a nenhum atributo
    }

    public static String GetNome(String atributo) {
        return switch (atributo) {
            case "STRENGTH" ->
                "Força";
            case "DEXTERITY" ->
                "Destreza";
            case "CONSTITUTION" ->
                "Constituição";
            case "INTELLIGENCE" ->
                "Inteligência";
            case "WISDOM" ->
                "Sabedoria";
            case "CHARISMA" ->
                "Carisma";
            default ->
                "NONE";
        }; // Caso a string não corresponda a nenhum atributo
    }
}
