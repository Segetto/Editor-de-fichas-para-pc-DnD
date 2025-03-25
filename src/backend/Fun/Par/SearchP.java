/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Admin
 */
public class SearchP {

    public static void SearchP(JTextField Search, JLabel Delete) {
        ImageIcon X = new ImageIcon("src/visual/res/Close.png");
        ImageIcon Lupa = new ImageIcon("src/visual/res/Search.png");
        Delete.addMouseListener(new MouseAdapter() {
            @Override

            public void mouseClicked(MouseEvent e) {
                if (!Search.getText().isEmpty()) {
                    Search.setText("");
                    Delete.setIcon(Lupa);
                }
            }
        });
        Search.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (Search.getText().isEmpty()) {
                    Delete.setIcon(Lupa);
                } else {
                    Delete.setIcon(X);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (Search.getText().isEmpty()) {
                    Delete.setIcon(Lupa);
                } else {
                    Delete.setIcon(X);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                Delete.setIcon(X);
            }
        });
    }
}
