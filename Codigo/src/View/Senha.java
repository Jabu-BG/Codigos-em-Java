package View;

import javax.swing.*;
import java.awt.*;

public class Senha {

    public static JPasswordField campoSenha;

    public static void adicionar() {

        JLabel senha = new JLabel("Digite sua Senha:");
        senha.setAlignmentX(Component.LEFT_ALIGNMENT);

        campoSenha = new JPasswordField();

        campoSenha.setAlignmentX(Component.LEFT_ALIGNMENT);
        campoSenha.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 28)
        );

        Janela.painelCentro.add(senha);
        Janela.painelCentro.add(Box.createVerticalStrut(5));
        Janela.painelCentro.add(campoSenha);
        Janela.painelCentro.add(Box.createVerticalStrut(10));
    }
}