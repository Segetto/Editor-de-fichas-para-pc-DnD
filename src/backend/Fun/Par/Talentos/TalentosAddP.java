/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Talentos;

import backend.Fun.trocarPainel;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.json.*;
import visual.Talentos;

/**
 *
 * @author Admin
 */
public class TalentosAddP {

    public static void EspecializacoesAddP(String personagemCaminho, JSONObject ficha, JPanel PEspT, JPanel PainelEspecializacaoFicha, JSONArray especializacoes, String VetorNomeFicha, String TituloCaminho, String DescricaoCaminho, JPanel PainelEspecializacoesFicha, JSONArray OpcoesComboBox, String CaminhoArquivo) {
        trocarPainel mudar = new trocarPainel();
        Talentos novoFrame = new Talentos(personagemCaminho, ficha, PainelEspecializacaoFicha, especializacoes, VetorNomeFicha, TituloCaminho, DescricaoCaminho, PainelEspecializacoesFicha, OpcoesComboBox, CaminhoArquivo, PEspT);
        novoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        for (MouseListener ml : PEspT.getMouseListeners()) {
            PEspT.removeMouseListener(ml);
        }
        System.gc();
        PEspT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mudar.painelChange(novoFrame);
            }
        });
    }
}
