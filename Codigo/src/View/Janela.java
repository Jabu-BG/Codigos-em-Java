package View;

import Controller.CadastroController;

import javax.swing.*;
import java.awt.*;

public class Janela {

    public static JPanel painelCentro;

    public static void criarJanela() {

        JFrame janela = new JFrame("Cadastro");

        janela.setSize(400, 550);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);

        janela.setLayout(new BorderLayout(10, 10));

        painelCentro = new JPanel();

        painelCentro.setLayout(
                new BoxLayout(painelCentro, BoxLayout.Y_AXIS)
        );

        painelCentro.setBorder(
                BorderFactory.createEmptyBorder(20, 20, 10, 20)
        );

        Nome.adicionar();

        Senha.adicionar();

        Documento.adicionar();

        Sexo.adicionar();


        painelCentro.add(
                Box.createVerticalStrut(20)
        );


        JButton botaoEnviar =
                new JButton("Enviar");

        botaoEnviar.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        CadastroController.configurarBotao(
                botaoEnviar,
                janela
        );

        painelCentro.add(botaoEnviar);



        janela.add(
                painelCentro,
                BorderLayout.CENTER
        );


        janela.setVisible(true);
    }
}