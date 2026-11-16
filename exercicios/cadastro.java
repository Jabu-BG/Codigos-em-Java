import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        JFrame janela = new JFrame("Cadastro");
        janela.setSize(400, 400);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);

        janela.setLayout(new BorderLayout(10, 10));

        JPanel painelCentro = new JPanel();
        painelCentro.setLayout(new BoxLayout(painelCentro, BoxLayout.Y_AXIS));
        painelCentro.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        // Nome
        JLabel texto = new JLabel("Digite seu nome:");
        texto.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextField campoNome = new JTextField();
        campoNome.setAlignmentX(Component.LEFT_ALIGNMENT);
        campoNome.setMaximumSize(new Dimension(Integer.MAX_VALUE, 28));
        campoNome.setPreferredSize(new Dimension(300, 28));

        painelCentro.add(texto);
        painelCentro.add(Box.createVerticalStrut(5));
        painelCentro.add(campoNome);

        painelCentro.add(Box.createVerticalStrut(10));

        // Senha
        JLabel senha = new JLabel("Digite sua Senha:");
        senha.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPasswordField campoSenha = new JPasswordField();
        campoSenha.setAlignmentX(Component.LEFT_ALIGNMENT);
        campoSenha.setMaximumSize(new Dimension(Integer.MAX_VALUE, 28));
        campoSenha.setPreferredSize(new Dimension(300, 28));

        painelCentro.add(senha);
        painelCentro.add(Box.createVerticalStrut(5));
        painelCentro.add(campoSenha);

        painelCentro.add(Box.createVerticalStrut(10));

        // Sexo
        JLabel sexo = new JLabel("Sexo:");
        sexo.setAlignmentX(Component.LEFT_ALIGNMENT);

        JRadioButton homem = new JRadioButton("Homem");
        JRadioButton mulher = new JRadioButton("Mulher");

        ButtonGroup grupoSexo = new ButtonGroup();
        grupoSexo.add(homem);
        grupoSexo.add(mulher);

        JPanel painelSexo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelSexo.setAlignmentX(Component.LEFT_ALIGNMENT);

        painelSexo.add(homem);
        painelSexo.add(mulher);

        painelCentro.add(sexo);
        painelCentro.add(painelSexo);

        // Indentificar se é vagabundo ou vagabundo++
        String[] tiposDocumento = {"CPF", "CNPJ"};
        JComboBox<String> caixaDocumento = new JComboBox<>(tiposDocumento);

        caixaDocumento.setAlignmentX(Component.LEFT_ALIGNMENT);
        caixaDocumento.setMaximumSize(new Dimension(Integer.MAX_VALUE, 28));
        JLabel documento = new JLabel("Você é uma Pessoa ou Empressa? ");
        documento.setAlignmentX(Component.LEFT_ALIGNMENT);

        painelCentro.add(Box.createVerticalStrut(10));
        painelCentro.add(documento);
        painelCentro.add(Box.createVerticalStrut(5));
        painelCentro.add(caixaDocumento);

        //CNPJ
        JLabel numeroDocumento = new JLabel("Digite seu CPF/CNPJ:");
        numeroDocumento.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextField campoDocumento = new JTextField();
        campoDocumento.setAlignmentX(Component.LEFT_ALIGNMENT);
        campoDocumento.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        campoDocumento.setPreferredSize(new Dimension(340, 35));

        painelCentro.add(Box.createVerticalStrut(10));
        painelCentro.add(numeroDocumento);
        painelCentro.add(Box.createVerticalStrut(5));
        painelCentro.add((campoDocumento));

        // Painel inferior
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        JButton botaoEnviar = new JButton("Enviar");

        botaoEnviar.addActionListener(e -> {

            String nome = campoNome.getText();

            JOptionPane.showMessageDialog(
                    janela,
                    "Nome enviado: " + nome
            );
        });

        painelInferior.add(botaoEnviar);

        // Adiciona os painéis na janela
        janela.add(painelCentro, BorderLayout.CENTER);
        janela.add(painelInferior, BorderLayout.SOUTH);

        janela.setVisible(true);
    }
}
