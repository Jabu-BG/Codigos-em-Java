package Controller;

import Model.Cliente;
import View.*;

import javax.swing.*;

public class CadastroController {

    public static void configurarBotao(
            JButton botaoEnviar,
            JFrame janela
    ) {

        botaoEnviar.addActionListener(e -> {

            try {

                // PEGA AS INFORMAÇÕES DA VIEW

                String nome =
                        Nome.campoNome.getText();

                String senha =
                        new String(
                                Senha.campoSenha.getPassword()
                        );

                String documento =
                        Documento.campoDocumento.getText();

                String tipoDocumento =
                        Documento.caixaDocumento
                                .getSelectedItem()
                                .toString();


                String sexo = "";

                if (Sexo.homem.isSelected()) {
                    sexo = "Homem";
                }

                if (Sexo.mulher.isSelected()) {
                    sexo = "Mulher";
                }


                // CRIA O MODEL

                Cliente cliente = new Cliente(
                        nome,
                        senha,
                        documento,
                        tipoDocumento,
                        sexo
                );


                // SUCESSO

                JOptionPane.showMessageDialog(
                        janela,
                        "Cliente cadastrado!\n" +
                                "Nome: " + cliente.getNome()
                );


                // LIMPA A VIEW

                Nome.campoNome.setText("");

                Senha.campoSenha.setText("");

                Documento.campoDocumento.setText("");

                Documento.caixaDocumento.setSelectedIndex(0);

                Sexo.grupoSexo.clearSelection();


            } catch (IllegalArgumentException erro) {

                JOptionPane.showMessageDialog(
                        janela,
                        erro.getMessage(),
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );

            }

        });
    }
}