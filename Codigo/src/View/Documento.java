package View;

import javax.swing.*;
import java.awt.*;

public class Documento {

    public static JTextField campoDocumento;
    public static JComboBox<String> caixaDocumento;

    public static void adicionar() {

        String[] tiposDocumento = {"CPF", "CNPJ"};

        caixaDocumento = new JComboBox<>(tiposDocumento);

        caixaDocumento.setAlignmentX(Component.LEFT_ALIGNMENT);
        caixaDocumento.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 28)
        );

        JLabel documento =
                new JLabel("Você é uma Pessoa ou Empresa?");

        documento.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel numeroDocumento =
                new JLabel("Digite seu CPF/CNPJ:");

        numeroDocumento.setAlignmentX(Component.LEFT_ALIGNMENT);

        campoDocumento = new JTextField();

        campoDocumento.setAlignmentX(Component.LEFT_ALIGNMENT);
        campoDocumento.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 35)
        );

        Janela.painelCentro.add(Box.createVerticalStrut(10));
        Janela.painelCentro.add(documento);
        Janela.painelCentro.add(Box.createVerticalStrut(5));
        Janela.painelCentro.add(caixaDocumento);

        Janela.painelCentro.add(Box.createVerticalStrut(10));
        Janela.painelCentro.add(numeroDocumento);
        Janela.painelCentro.add(Box.createVerticalStrut(5));
        Janela.painelCentro.add(campoDocumento);
    }
}