/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Geral;

import javax.swing.*;
import java.awt.event.*;

public class NavBarP {

    public static void NavBarP(JScrollPane AppScrollPane, JLabel GeralNavBar, JLabel MochilaNavBar, JLabel FeiticosNavBar, JLabel CaracteristicasNavBar) {
        // Suavizar a rolagem para qualquer elemento da navbar
        MouseAdapter smoothScroll = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JLabel source = (JLabel) e.getSource();
                final int targetPosition;

                // Determina a posição horizontal de destino com base no JLabel clicado
                if (source == GeralNavBar) {
                    targetPosition = 0;  // Posição inicial
                } else if (source == MochilaNavBar) {
                    targetPosition = 672; // Posição para os outros elementos
                } else if (source == FeiticosNavBar) {
                    targetPosition = 1310;
                } else if (source == CaracteristicasNavBar) {
                    targetPosition = 1947;
                } else {
                    return; // Evita erro se a fonte não for um dos JLabels esperados
                }

                // Suavizar a rolagem
                final JScrollBar horizontalBar = AppScrollPane.getHorizontalScrollBar();
                final int startPosition = horizontalBar.getValue();

                // Se a posição inicial for menor do que a final, rolar para a direita (aumentando o valor)
                // Caso contrário, rolar para a esquerda (diminuindo o valor)
                int increment = (startPosition < targetPosition) ? 100 : -100;

                // Timer para suavizar a rolagem
                Timer timer = new Timer(10, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int currentPosition = horizontalBar.getValue();

                        // Continuar rolar até a posição de destino
                        if (increment > 0 && currentPosition < targetPosition) {
                            horizontalBar.setValue(currentPosition + increment); // Incrementa suavemente
                        } else if (increment < 0 && currentPosition > targetPosition) {
                            horizontalBar.setValue(currentPosition + increment); // Decrementa suavemente
                        } else {
                            horizontalBar.setValue(targetPosition);
                            ((Timer) e.getSource()).stop(); // Para o timer quando chegar ao destino
                            horizontalBar.setValue(targetPosition);
                        }
                    }
                });

                timer.start(); // Inicia o timer para a transição suave
            }
        };

        // Adiciona o MouseListener para cada item da barra de navegação
        GeralNavBar.addMouseListener(smoothScroll);
        MochilaNavBar.addMouseListener(smoothScroll);
        FeiticosNavBar.addMouseListener(smoothScroll);
        CaracteristicasNavBar.addMouseListener(smoothScroll);
    }
}
