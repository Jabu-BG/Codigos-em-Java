package View;

import javax.swing.*;
import java.awt.*;

public class Nome {

    public static JTextField campoNome;

    public static void adicionar() {

        JLabel texto = new JLabel("Digite seu nome:");
        texto.setAlignmentX(Component.LEFT_ALIGNMENT);

        campoNome = new JTextField();
        campoNome.setAlignmentX(Component.LEFT_ALIGNMENT);
        campoNome.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 28)
        );
        campoNome.setPreferredSize(
                new Dimension(300, 28)
        );

        Janela.painelCentro.add(texto);
        Janela.painelCentro.add(Box.createVerticalStrut(5));
        Janela.painelCentro.add(campoNome);
        Janela.painelCentro.add(Box.createVerticalStrut(10));
    }
}