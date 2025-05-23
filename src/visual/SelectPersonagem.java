/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visual;

import static backend.Fun.Rand.NovoId;
import org.json.*;
import static backend.Fun.FichaLer.FichaLerString;
import backend.Fun.OrganizarASSET;
import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import backend.jsonParser;
import backend.Fun.trocarPainel;
import java.awt.Color;
import backend.Fun.VirtualObjects.*;

/**
 *
 * @author Admin
 */
public class SelectPersonagem extends javax.swing.JFrame {

    File pasta = new File("personagensJSON");
    File[] arquivos = pasta.listFiles();

    /**
     * Creates new form SelectPersonagem
     */
    class Item {

        private String id;
        private String nome;

        public Item(String id, String nome) {
            this.id = id;
            this.nome = nome;
        }

        public String getId() {
            return id;
        }

        @Override
        public String toString() {
            return nome; // Mostra apenas o nome na JComboBox
        }
    }

    public SelectPersonagem() {
        initComponents();
        ImageIcon IconeApp = new ImageIcon("src/visual/res/Kvasir.png");
        SwingUtilities.getWindowAncestor(jComboBox1).setIconImage(IconeApp.getImage());
        try{
        Arrays.stream(arquivos).filter(File::isFile).forEach(arquivo -> {
            String nomeArquivo = arquivo.getName();
            JSONObject ficha = new JSONObject(jsonParser.LerArquivo("personagensJSON/" + nomeArquivo));
            jComboBox1.addItem(new Item(nomeArquivo.replace(".json", ""), FichaLerString(ficha, "nome", 0)));
        });
        }catch(java.lang.NullPointerException e){
            
        }
        jComboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Quando a seleção mudar, troca para o segundo JFrame
                Item selectedItem = (Item) jComboBox1.getSelectedItem();
                String selectedOption = selectedItem.getId();
                setVisible(false);
                dispose();
                personagemFicha novoFrame = new personagemFicha(selectedOption);
                novoFrame.setIconImage(IconeApp.getImage());
                trocarPainel mudar = new trocarPainel();
                mudar.painelChange(novoFrame);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<Item>();
        AdicionarPersonagemExistenteBotao = new javax.swing.JButton();
        NovoPersongemBotao = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(79, 79, 79));
        jPanel1.setPreferredSize(new java.awt.Dimension(575, 367));

        jPanel2.setBackground(new java.awt.Color(23, 23, 23));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 195), 2, true));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Selecione seu personagem");

        jComboBox1.setBackground(new java.awt.Color(79, 79, 79));
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setBorder(null);
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        AdicionarPersonagemExistenteBotao.setBackground(new java.awt.Color(79, 79, 79));
        AdicionarPersonagemExistenteBotao.setForeground(new java.awt.Color(255, 255, 255));
        AdicionarPersonagemExistenteBotao.setText("Adicionar personagem existente");
        AdicionarPersonagemExistenteBotao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AdicionarPersonagemExistenteBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarPersonagemExistenteBotaoActionPerformed(evt);
            }
        });

        NovoPersongemBotao.setBackground(new java.awt.Color(79, 79, 79));
        NovoPersongemBotao.setForeground(new java.awt.Color(255, 255, 255));
        NovoPersongemBotao.setText("Criar novo personagem");
        NovoPersongemBotao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NovoPersongemBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NovoPersongemBotaoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ou");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NovoPersongemBotao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(AdicionarPersonagemExistenteBotao)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(231, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(233, 233, 233))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(NovoPersongemBotao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(AdicionarPersonagemExistenteBotao)
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void NovoPersongemBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NovoPersongemBotaoActionPerformed
        try {
            String CaminhoOrigem = "ASSETS/Novo Personagem.json";
            String uuid = NovoId(32);
            Files.copy(Paths.get(CaminhoOrigem), Paths.get("personagensJSON/" + uuid + ".json"));
            personagemFicha novoFrame = new personagemFicha(uuid);
            trocarPainel mudar = new trocarPainel();
            mudar.painelChange(novoFrame);
            dispose();
        } catch (IOException e) {
            System.out.println("Erro: " + e);
        }
    }//GEN-LAST:event_NovoPersongemBotaoActionPerformed

    private void AdicionarPersonagemExistenteBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarPersonagemExistenteBotaoActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecione um Arquivo");
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            JSONArray itens = new JSONArray(jsonParser.LerArray("ASSETS/Equipamento.json"));
            JSONArray CarClasse = new JSONArray(jsonParser.LerArray("ASSETS/CarClasse.json"));
            JSONArray CarRaca = new JSONArray(jsonParser.LerArray("ASSETS/CarRaca.json"));
            JSONArray Talentos = new JSONArray(jsonParser.LerArray("ASSETS/Talentos.json"));
            JSONArray Idiomas = new JSONArray(jsonParser.LerArray("ASSETS/Idiomas.json"));
            JSONArray Magias = new JSONArray(jsonParser.LerArray("ASSETS/Magias.json"));
            
            File selectedFile = fileChooser.getSelectedFile();
            String destinationPath = "personagensJSON/" + selectedFile.getName();
            String novoNomeArquivo = NovoId(32) + ".json";
            File destinoArquivo = new File("personagensJSON/", novoNomeArquivo);
            try {
                Files.copy(Paths.get(selectedFile.getAbsolutePath()), destinoArquivo.toPath());
                String nomeArquivo = selectedFile.getName();
                JSONObject ficha = new JSONObject(jsonParser.LerArquivo(destinoArquivo.getAbsolutePath()));
                NewItemArrayVO ItemCustom = new NewItemArrayVO();
                NewMagiaArrayVO MagiaCustom = new NewMagiaArrayVO();
                for (int i = 0; i < ficha.getJSONArray("i").length(); i++) {
                    if (ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getBoolean("t")) {
                        String ExtraK = "";
                        String Extra1 = "";
                        int Extra2 = 0;
                        int Extra3 = 0;
                        if (ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").has("1")) {
                            Extra1 = ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getString("1");
                        }
                        if (ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").has("2")) {
                            Extra2 = ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getInt("2");
                        }
                        if (ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").has("2")) {
                            Extra3 = ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getInt("3");
                        }
                        if (ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").has("k")) {
                            ExtraK = ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getString("k");
                        }

                        itens.put(ItemCustom.NovoItem(
                                ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getString("b"),
                                ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getInt("c"),
                                ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getString("d"),
                                ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getDouble("e"),
                                ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getDouble("g"),
                                ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getString("h"),
                                ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getString("i"),
                                "",
                                ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getInt("j"),
                                ExtraK,
                                ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getInt("l"),
                                ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getBoolean("m"),
                                ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getInt("n"),
                                ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getString("q"),
                                ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getInt("o"),
                                ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getString("u"),
                                ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getString("v"),
                                ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getString("w"),
                                Extra1,
                                Extra2,
                                Extra3)
                        );
                    }
                }
                for (int i = 0; i < ficha.getJSONArray("r").length(); i++) {
                    if (ficha.getJSONArray("r").getJSONObject(i).getJSONObject("b").getBoolean("t")) {
                        Magias.put(MagiaCustom.NewMagia(
                                ficha.getJSONArray("r").getJSONObject(i).getJSONObject("b").getString("b"),
                                ficha.getJSONArray("r").getJSONObject(i).getJSONObject("b").getString("d"),
                                ficha.getJSONArray("r").getJSONObject(i).getJSONObject("b").getString("e"),
                                ficha.getJSONArray("r").getJSONObject(i).getJSONObject("b").getString("g"),
                                ficha.getJSONArray("r").getJSONObject(i).getJSONObject("b").getString("h"),
                                ficha.getJSONArray("r").getJSONObject(i).getJSONObject("b").getString("i"),
                                ficha.getJSONArray("r").getJSONObject(i).getJSONObject("b").getString("c"),
                                ficha.getJSONArray("r").getJSONObject(i).getJSONObject("b").getInt("k"),
                                ficha.getJSONArray("r").getJSONObject(i).getJSONObject("b").getString("uuid"))
                        );
                    }
                }
                for (int i = 0; i < ficha.getJSONArray("p").length(); i++) {
                    if (ficha.getJSONArray("p").getJSONObject(i).getJSONObject("b").getBoolean("t")) {
                        Idiomas.put(new JSONObject()
                                .put("b", ficha.getJSONArray("p").getJSONObject(i).getJSONObject("b").getString("b"))
                                .put("d", ficha.getJSONArray("p").getJSONObject(i).getJSONObject("b").getString("d"))
                                .put("e", ficha.getJSONArray("p").getJSONObject(i).getJSONObject("b").getString("e"))
                                .put("f", ficha.getJSONArray("p").getJSONObject(i).getJSONObject("b").getString("f"))
                                .put("uuid", ficha.getJSONArray("n").getJSONObject(i).getJSONObject("b").getString("uuid"))
                        );
                    }
                }
                for (int i = 0; i < ficha.getJSONArray("o").length(); i++) {
                    if (ficha.getJSONArray("o").getJSONObject(i).getJSONObject("b").getBoolean("t")) {
                        Talentos.put(new JSONObject()
                                .put("c", ficha.getJSONArray("o").getJSONObject(i).getJSONObject("b").getString("c"))
                                .put("d", ficha.getJSONArray("o").getJSONObject(i).getJSONObject("b").getString("d"))
                                .put("uuid", ficha.getJSONArray("n").getJSONObject(i).getJSONObject("b").getString("uuid"))
                        );
                    }
                }
                for (int i = 0; i < ficha.getJSONArray("n").length(); i++) {
                    if (ficha.getJSONArray("n").getJSONObject(i).getJSONObject("b").getBoolean("t")) {
                        CarRaca.put(new JSONObject()
                                .put("b", ficha.getJSONArray("n").getJSONObject(i).getJSONObject("b").getString("b"))
                                .put("d", ficha.getJSONArray("n").getJSONObject(i).getJSONObject("b").getString("d"))
                                .put("e", ficha.getJSONArray("n").getJSONObject(i).getJSONObject("b").getString("e"))
                                .put("uuid", ficha.getJSONArray("n").getJSONObject(i).getJSONObject("b").getString("uuid"))
                        );
                    }
                }
                for (int i = 0; i < ficha.getJSONArray("m").length(); i++) {
                    if (ficha.getJSONArray("m").getJSONObject(i).getJSONObject("b").getBoolean("t")) {
                        CarClasse.put(new JSONObject()
                                .put("b", ficha.getJSONArray("m").getJSONObject(i).getJSONObject("b").getString("b"))
                                .put("d", ficha.getJSONArray("m").getJSONObject(i).getJSONObject("b").getString("d"))
                                .put("e", ficha.getJSONArray("m").getJSONObject(i).getJSONObject("b").getString("e"))
                                .put("uuid", ficha.getJSONArray("m").getJSONObject(i).getJSONObject("b").getString("uuid"))
                        );
                    }
                }
                jComboBox1.addItem(new Item(novoNomeArquivo.replace(".json", ""), FichaLerString(ficha, "nome", 0)));
            } catch (IOException e) {
                System.out.println("Erro ao enviar o arquivo: " + e);
            }
            System.out.println("Arquivo selecionado: " + selectedFile.getAbsolutePath());
            jsonParser salvar = new jsonParser();
            salvar.sobrescreverArray("ASSETS/Equipamento.json", OrganizarASSET.OrganizarJSONArray(itens, "u").toString(4));
            salvar.sobrescreverArray("ASSETS/CarClasse.json", OrganizarASSET.OrganizarJSONArray(CarClasse, "d").toString(4));
            salvar.sobrescreverArray("ASSETS/CarRaca.json", OrganizarASSET.OrganizarJSONArray(CarRaca, "d").toString(4));
            salvar.sobrescreverArray("ASSETS/Idiomas.json", OrganizarASSET.OrganizarJSONArray(Idiomas, "c").toString(4));
            salvar.sobrescreverArray("ASSETS/Talentos.json", OrganizarASSET.OrganizarJSONArray(Talentos, "d").toString(4));
            salvar.sobrescreverArray("ASSETS/Magias.json", OrganizarASSET.OrganizarJSONArray(Magias, "b").toString(4));
        } else {
            System.out.println("Nenhum arquivo selecionado.");
        }

    }//GEN-LAST:event_AdicionarPersonagemExistenteBotaoActionPerformed

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
            UIManager.setLookAndFeel(new FlatDarkLaf());
            FlatDarkLaf.setup();
            UIManager.put("Spinner.buttonArrowColor", new Color(255, 255, 255));
            UIManager.put("Spinner.buttonBackground", new Color(23, 23, 23));
            UIManager.put("Spinner.buttonSeparatorColor", new Color(23, 23, 23));

        } catch (Exception e) {
            e.printStackTrace();
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectPersonagem().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdicionarPersonagemExistenteBotao;
    private javax.swing.JButton NovoPersongemBotao;
    private javax.swing.JComboBox<Item> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
