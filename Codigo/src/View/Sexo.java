package View;

import javax.swing.*;
import java.awt.*;

public class Sexo {

    public static JRadioButton homem;
    public static JRadioButton mulher;

    public static ButtonGroup grupoSexo;

    public static void adicionar() {

        JLabel sexo = new JLabel("Sexo:");

        sexo.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        homem = new JRadioButton("Homem");

        mulher = new JRadioButton("Mulher");


        grupoSexo = new ButtonGroup();

        grupoSexo.add(homem);
        grupoSexo.add(mulher);


        JPanel painelSexo =
                new JPanel(
                        new FlowLayout(FlowLayout.LEFT)
                );

        painelSexo.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        painelSexo.add(homem);
        painelSexo.add(mulher);


        Janela.painelCentro.add(sexo);

        Janela.painelCentro.add(painelSexo);
    }
}