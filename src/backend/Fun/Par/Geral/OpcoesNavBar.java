/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Geral;

import static backend.Fun.Par.Geral.SalvarP.SalvarP;
import backend.Fun.trocarPainel;
import java.awt.*;
import org.json.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import visual.SelectPersonagem;

/**
 *
 * @author Admin
 */
public class OpcoesNavBar {

    public static void MostrarDrawer(String personagemCaminho, JSONObject ficha, JLabel BotaoDrawerMostrar, JPanel PainelConteudo) {
        JPopupMenu PDrawer = new JPopupMenu("Opcoes adicionais");
        BotaoDrawerMostrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        PDrawer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        JMenuItem ExportarFicha = new JMenuItem("Exportar personagem");
        JMenuItem ExcluirFicha = new JMenuItem("Excluir personagem");
        JMenuItem SalvarFicha = new JMenuItem("Salvar alterações");
        JMenuItem SairFicha = new JMenuItem("Voltar para a seleção de personagem");
        JPanel pteste = new JPanel();
        pteste.setPreferredSize(new Dimension(100, 100));
        PDrawer.add(ExportarFicha);
        PDrawer.add(ExcluirFicha);
        PDrawer.add(SalvarFicha);
        PDrawer.add(SairFicha);
        SalvarP(ficha, SalvarFicha, personagemCaminho);

        PDrawer.setSize(new Dimension(100, 100));
        SwingUtilities.getWindowAncestor(BotaoDrawerMostrar).add(PDrawer);
        BotaoDrawerMostrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PDrawer.show(SwingUtilities.getWindowAncestor(BotaoDrawerMostrar), e.getXOnScreen() - PDrawer.getWidth(), e.getYOnScreen());
            }
        });
        SairFicha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.getWindowAncestor(BotaoDrawerMostrar).dispose();
                trocarPainel mudar = new trocarPainel();
                SelectPersonagem novoFrame = new SelectPersonagem();
                mudar.painelChange(novoFrame);
            }
        });
        ExportarFicha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser seletor = new JFileChooser();
                seletor.setDialogTitle("Selecione uma pasta para salvar o arquivo");
                seletor.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // Apenas pastas

                int retorno = seletor.showSaveDialog(null); // Abre a janela

                if (retorno == JFileChooser.APPROVE_OPTION) {
                    File diretorioSelecionado = seletor.getSelectedFile();
                    String nomeArquivo = ficha.getJSONArray("a").getJSONObject(0).getString("a").replace(" ", "-") + ".json";
                    File arquivo = new File(diretorioSelecionado, nomeArquivo);
                    try {
                        String conteudo = ficha.toString(4);
                        Files.write(arquivo.toPath(), conteudo.getBytes(), StandardOpenOption.WRITE);
                    } catch (IOException eCatch) {
                        eCatch.printStackTrace();
                    }
                } else {
                }
            }
        });
        ExcluirFicha.addActionListener((ActionEvent e) -> {
            File arquivo = new File(personagemCaminho);
            arquivo.delete();
            SwingUtilities.getWindowAncestor(BotaoDrawerMostrar).dispose();
            trocarPainel mudar = new trocarPainel();
            SelectPersonagem novoFrame = new SelectPersonagem();
            mudar.painelChange(novoFrame);
        });
    }
}
