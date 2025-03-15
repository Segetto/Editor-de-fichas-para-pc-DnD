/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Especializacao;

import backend.Fun.Par.Inventario.*;
import backend.Fun.trocarPainel;
import javax.swing.JPanel;
import org.json.*;
import visual.Especializacao;

/**
 *
 * @author Admin
 */
public class EspecializacoesAddP {

    public static void EspecializacoesAddP(String personagemCaminho, JSONObject ficha, JPanel PEspT, JPanel PainelEspecializacaoFicha, JSONArray especializacoes, String VetorNomeFicha, String TituloCaminho, String DescricaoCaminho, JPanel PainelEspecializacoesFicha, JSONArray OpcoesComboBox, String CaminhoArquivo) {
        trocarPainel mudar = new trocarPainel();
        Especializacao novoFrame = new Especializacao(personagemCaminho, ficha, PainelEspecializacaoFicha, especializacoes, VetorNomeFicha, TituloCaminho, DescricaoCaminho, PainelEspecializacoesFicha, OpcoesComboBox, CaminhoArquivo);
        PEspT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mudar.painelChange(novoFrame);
            }
        });
    }
}
