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
import javax.swing.border.MatteBorder;

/**
 *
 * @author Admin
 */
public class EditarItemAssetSelectDinamico {

    public static void EditarItemAssetSelectDinamico(JTextField NomeComp, JTextArea DescricaoComp, JTextField ValorComp, JComboBox TipoValorComp, JTextField PesoComp, JTextField QtdPadraoComp, JComboBox TipoQtdComp, JComboBox TipoItemComp, JPanel OpcoesExtra, JLabel AddItem, JSONArray equipamentos, String personagemCaminho, JSONObject ficha, JPanel PainelItensFicha, JLabel BonusCALabel, JPanel EquipamentoPainel, JPanel AddEquip, String TipoEdit, int pos, JLabel PesoAtual, JLabel PesoMaximo) {
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
        String ArmaTipoVetor = "";
        if (equipamentos.getJSONObject(pos).has("b")) {
            ArmaTipoVetor = equipamentos.getJSONObject(pos).getString("b");
        }
        JTextField ArmaTipo = new JTextField(ArmaTipoVetor);

        JPanel PArmaPropriedadesT = new JPanel(new BorderLayout());
        PArmaPropriedadesT.setOpaque(false);
        JLabel ArmaPropriedadesT = new JLabel("Propriedades especiais da arma:");
        ArmaPropriedadesT.setForeground(new Color(255, 255, 255));
        String ArmaPropriedadesVetor = "";
        if (equipamentos.getJSONObject(pos).has("w")) {
            ArmaPropriedadesVetor = equipamentos.getJSONObject(pos).getString("w");
        }
        JTextField ArmaPropriedades = new JTextField(ArmaPropriedadesVetor);
        JPanel PArmaDadosDanoT = new JPanel(new BorderLayout());
        PArmaDadosDanoT.setOpaque(false);
        JLabel ArmaDadosDanoT = new JLabel("Dados de dano");
        ArmaDadosDanoT.setForeground(new Color(255, 255, 255));
        String DadosDano = "1d4";
        if (equipamentos.getJSONObject(pos).has("1")) {
            DadosDano = equipamentos.getJSONObject(pos).getString("1");
        }
        JTextField ArmaDadosDano = new JTextField(DadosDano);

        JPanel PArmaAtributo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        PArmaAtributo.setOpaque(false);
        JLabel ArmaAtributoT = new JLabel("Atributo: ");
        ArmaAtributoT.setForeground(new Color(255, 255, 255));
        String[] Status = {"Força", "Destreza", "Constituição", "Inteligência", "Sabedoria", "Carisma", "Nenhum"};
        JComboBox<String> ArmaAtributo = new JComboBox<>(Status);
        String ArmaAtributoVetor = "";
        if(equipamentos.getJSONObject(pos).has("q")){
            ArmaAtributoVetor = equipamentos.getJSONObject(pos).getString("q");
        }
        ArmaAtributo.setSelectedItem(GetNome(ArmaAtributoVetor));
        ArmaAtributo.setBackground(new Color(23, 23, 23));
        ArmaAtributo.setForeground(new Color(255, 255, 255));
        PArmaAtributo.add(ArmaAtributoT);
        PArmaAtributo.add(ArmaAtributo);
        JPanel PArmaDanoBonusT = new JPanel(new BorderLayout());
        PArmaDanoBonusT.setOpaque(false);
        JLabel ArmaDanoBonusT = new JLabel("Bônus de dano");
        ArmaDanoBonusT.setForeground(new Color(255, 255, 255));
        int BonusDano = 0;
        if (equipamentos.getJSONObject(pos).has("3")) {
            BonusDano = equipamentos.getJSONObject(pos).getInt("3");
        }
        JTextField ArmaDanoBonus = new JTextField("" + BonusDano);
        JPanel PArmaAtaqueBonusT = new JPanel(new BorderLayout());
        PArmaAtaqueBonusT.setOpaque(false);
        JLabel ArmaAtaqueBonusT = new JLabel("Bônus de ataque");
        ArmaAtaqueBonusT.setForeground(new Color(255, 255, 255));
        int BonusAtaque = 0;
        if (equipamentos.getJSONObject(pos).has("2")) {
            BonusAtaque = equipamentos.getJSONObject(pos).getInt("2");
        }
        JTextField ArmaAtaqueBonus = new JTextField("" + BonusAtaque);

// Campo armadura
        JPanel PCABaseT = new JPanel(new BorderLayout());
        PCABaseT.setOpaque(false);
        JLabel CABaseT = new JLabel("Classe de armadura base:");
        CABaseT.setForeground(new Color(255, 255, 255));
        CABaseT.setHorizontalAlignment(SwingConstants.LEFT);
        CABaseT.setHorizontalAlignment(SwingConstants.LEFT);
        int CABaseVetor = 0;
        if (equipamentos.getJSONObject(pos).has("j")) {
            CABaseVetor = equipamentos.getJSONObject(pos).getInt("j");
        }
        JTextField CABase = new JTextField("" + CABaseVetor);

        JPanel PArmaduraAtributo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        PArmaduraAtributo.setOpaque(false);
        JLabel ArmaduraAtributoT = new JLabel("Atributo: ");
        ArmaduraAtributoT.setForeground(new Color(255, 255, 255));
        JComboBox<String> ArmaduraAtributo = new JComboBox<>(Status);
        String ArmaduraAtributoVetor = "";
        if (equipamentos.getJSONObject(pos).has("k")) {
            ArmaduraAtributoVetor = equipamentos.getJSONObject(pos).getString("k");
        }
        ArmaduraAtributo.setSelectedItem(GetNome(ArmaduraAtributoVetor));
        ArmaduraAtributo.setBackground(new Color(23, 23, 23));
        ArmaduraAtributo.setForeground(new Color(255, 255, 255));
        PArmaduraAtributo.add(ArmaduraAtributoT);
        PArmaduraAtributo.add(ArmaduraAtributo);
        JPanel PLimiteStatusT = new JPanel(new BorderLayout());
        PLimiteStatusT.setOpaque(false);
        JLabel LimiteStatusT = new JLabel("Máximo do modificador de Status (0 = sem limite máximo):");
        LimiteStatusT.setForeground(new Color(255, 255, 255));
        int LimiteStatusVetor = 0;
        if(equipamentos.getJSONObject(pos).has("l")){
            LimiteStatusVetor = equipamentos.getJSONObject(pos).getInt("l");
        }
        JTextField LimiteStatus = new JTextField("" + LimiteStatusVetor);
        JPanel PForcaMinimaT = new JPanel(new BorderLayout());
        PForcaMinimaT.setOpaque(false);
        JLabel ForcaMinimaT = new JLabel("Força mínima");
        ForcaMinimaT.setForeground(new Color(255, 255, 255));
        int ForcaMinimaVetor = 0;
        if(equipamentos.getJSONObject(pos).has("n")){
            ForcaMinimaVetor = equipamentos.getJSONObject(pos).getInt("n");
        }
        JTextField ForcaMinima = new JTextField("" + ForcaMinimaVetor);
        JCheckBox Desvantagem = new JCheckBox("Desvantagem em furtividade");
        boolean DesvantagemBoolVetor = false;
        if(equipamentos.getJSONObject(pos).has("m")){
            DesvantagemBoolVetor = equipamentos.getJSONObject(pos).getBoolean("m");
        }
        Desvantagem.setSelected(DesvantagemBoolVetor);
// Campo escudo
        JPanel PBonusEscudoT = new JPanel(new BorderLayout());
        PBonusEscudoT.setOpaque(false);
        JLabel BonusEscudoT = new JLabel("Bônus de CA");
        BonusEscudoT.setForeground(new Color(255, 255, 255));
        int BonusEscudoVetor = 0;
        if (equipamentos.getJSONObject(pos).has("o")) {
            BonusEscudoVetor = equipamentos.getJSONObject(pos).getInt("o");
        }
        JTextField BonusEscudo = new JTextField("" + BonusEscudoVetor);
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
                jsonParser sobrescrever = new jsonParser();
                NewItemArrayVO NewItem = new NewItemArrayVO();
                equipamentos.remove(pos);
                equipamentos.put(NewItem.NovoItem(
                        ArmaTipoString,
                        Valor,
                        TipoValor,
                        Peso,
                        QtdPadrao,
                        TipoQtd,
                        TipoItem,
                        "",
                        CABaseInt,
                        ArmaduraAtributoString,
                        LimiteStatusInt,
                        DesvantagemBool,
                        ForcaMinimaInt,
                        ArmaAtributoString,
                        BonusEscudoInt,
                        Nome,
                        Descricao,
                        ArmaPropriedadesString,
                        ArmaDadosDanoString,
                        ArmaAtaqueBonusInt,
                        ArmaDanoBonusInt));
                sobrescrever.sobrescreverArray("ASSETS/Equipamento.json", OrganizarASSET.OrganizarJSONArray(equipamentos, "u").toString(4));
                if (EquipamentoPainel != null) {
                    Window janela = SwingUtilities.getWindowAncestor(EquipamentoPainel);
                    janela.dispose();
                    janela = null;
                    EquipamentosAddP(personagemCaminho, ficha, AddEquip, PainelItensFicha, OrganizarASSET.OrganizarJSONArray(equipamentos, "u"), BonusCALabel, PesoAtual, PesoMaximo);
                    SwingUtilities.getWindowAncestor(OpcoesExtra).dispose();
                }
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
        switch (atributo) {
            case "Força":
                return "STRENGTH";
            case "Destreza":
                return "DEXTERITY";
            case "Constituição":
                return "CONSTITUTION";
            case "Inteligência":
                return "INTELLIGENCE";
            case "Sabedoria":
                return "WISDOM";
            case "Carisma":
                return "CHARISMA";
            default:
                return "NONE"; // Caso a string não corresponda a nenhum atributo
        }
    }
     public static String GetNome(String atributo) {
        return switch (atributo) {
            case "STRENGTH" -> "Força";
            case "DEXTERITY" -> "Destreza";
            case "CONSTITUTION" -> "Constituição";
            case "INTELLIGENCE" -> "Inteligência";
            case "WISDOM" -> "Sabedoria";
            case "CHARISMA" -> "Carisma";
            default -> "NONE";
        }; // Caso a string não corresponda a nenhum atributo
    }
}
