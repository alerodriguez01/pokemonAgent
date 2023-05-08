package ui;

import agent.PokemonAgent;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class PokemonUI extends JFrame {


    private JPanel panel1;
    private JLabel backgroundLabel,
            pos0AdvLabel, pos0PikachuLabel, pos0PokebolaLabel,
            pos1AdvLabel, pos1PikachuLabel, pos1PokebolaLabel,
            pos2AdvLabel, pos2PikachuLabel, pos2PokebolaLabel,
            pos3AdvLabel, pos3PikachuLabel, pos3PokebolaLabel,
            pos4AdvLabel, pos4PikachuLabel, pos4PokebolaLabel,
            pos5AdvLabel, pos5PikachuLabel, pos5PokebolaLabel,
            pos6AdvLabel, pos6PikachuLabel, pos6PokebolaLabel,
            pos7AdvLabel, pos7PikachuLabel, pos7PokebolaLabel,
            pos8AdvLabel, pos8PikachuLabel, pos8PokebolaLabel,
            pos9AdvLabel, pos9PikachuLabel, pos9PokebolaLabel,
            pos10AdvLabel, pos10PikachuLabel, pos10PokebolaLabel,
            pos11AdvLabel, pos11PikachuLabel, pos11PokebolaLabel,
            pos12AdvLabel, pos12PikachuLabel, pos12PokebolaLabel,
            pos13AdvLabel, pos13PikachuLabel, pos13PokebolaLabel,
            pos14AdvLabel, pos14PikachuLabel, pos14PokebolaLabel,
            pos15AdvLabel, pos15PikachuLabel, pos15PokebolaLabel,
            pos16AdvLabel, pos16PikachuLabel, pos16PokebolaLabel,
            pos17AdvLabel, pos17PikachuLabel, pos17PokebolaLabel,
            pos18AdvLabel, pos18PikachuLabel, pos18PokebolaLabel,
            pos19AdvLabel, pos19PikachuLabel, pos19PokebolaLabel,
            pos20AdvLabel, pos20PikachuLabel, pos20PokebolaLabel,
            pos21AdvLabel, pos21PikachuLabel, pos21PokebolaLabel,
            pos22AdvLabel, pos22PikachuLabel, pos22PokebolaLabel,
            pos23AdvLabel, pos23PikachuLabel, pos23PokebolaLabel,
            pos24AdvLabel, pos24PikachuLabel, pos24PokebolaLabel,
            pos25AdvLabel, pos25PikachuLabel, pos25PokebolaLabel,
            pos26AdvLabel, pos26PikachuLabel, pos26PokebolaLabel,
            pos27AdvLabel, pos27PikachuLabel, pos27PokebolaLabel,
            pos28AdvLabel, pos28PikachuLabel, pos28PokebolaLabel,
            labelVictoria, labelDerrota;

    private JLayeredPane layeredPane;

    public PokemonUI() {

        layeredPane = getLayeredPane();

        // Label background
        ImageIcon background = createImageIcon("mapa.png", "");
        backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
        layeredPane.add(backgroundLabel, Integer.valueOf(0));

        //  --------- Posicion 0 ------------
        // Adversario
        pos0AdvLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("adversario.png", "").getImage(), 50, 50)));
        pos0AdvLabel.setBounds(124, 173, 50, 50);
        layeredPane.add(pos0AdvLabel, Integer.valueOf(1));
        // Pokemon
        pos0PikachuLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pikachu.png", "").getImage(), 50, 50)));
        pos0PikachuLabel.setBounds(124, 173, 50, 50);
        layeredPane.add(pos0PikachuLabel, Integer.valueOf(2));
        // Pokebola
        pos0PokebolaLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pokebola.png", "").getImage(), 50, 50)));
        pos0PokebolaLabel.setBounds(124, 173, 50, 50);
        layeredPane.add(pos0PokebolaLabel, Integer.valueOf(1));


        //  --------- Posicion 1 ------------
        // Adversario
        pos1AdvLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("adversario.png", "").getImage(), 50, 50)));
        pos1AdvLabel.setBounds(218, 241, 50, 50);
        layeredPane.add(pos1AdvLabel, Integer.valueOf(1));
        // Pokemon
        pos1PikachuLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pikachu.png", "").getImage(), 50, 50)));
        pos1PikachuLabel.setBounds(218, 241, 50, 50);
        layeredPane.add(pos1PikachuLabel, Integer.valueOf(2));
        // Pokebola
        pos1PokebolaLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pokebola.png", "").getImage(), 50, 50)));
        pos1PokebolaLabel.setBounds(218, 241, 50, 50);
        layeredPane.add(pos1PokebolaLabel, Integer.valueOf(1));


        //  --------- Posicion 2 ------------
        // Adversario
        pos2AdvLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("adversario.png", "").getImage(), 50, 50)));
        pos2AdvLabel.setBounds(186, 309, 50, 50);
        layeredPane.add(pos2AdvLabel, Integer.valueOf(1));
        // Pokemon
        pos2PikachuLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pikachu.png", "").getImage(), 50, 50)));
        pos2PikachuLabel.setBounds(186, 309, 50, 50);
        layeredPane.add(pos2PikachuLabel, Integer.valueOf(2));
        // Pokebola
        pos2PokebolaLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pokebola.png", "").getImage(), 50, 50)));
        pos2PokebolaLabel.setBounds(186, 309, 50, 50);
        layeredPane.add(pos2PokebolaLabel, Integer.valueOf(1));

        //  --------- Posicion 3 ------------
        // Adversario
        pos3AdvLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("adversario.png", "").getImage(), 50, 50)));
        pos3AdvLabel.setBounds(269,429, 50, 50);
        layeredPane.add(pos3AdvLabel, Integer.valueOf(1));
        // Pokemon
        pos3PikachuLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pikachu.png", "").getImage(), 50, 50)));
        pos3PikachuLabel.setBounds(269,429, 50, 50);
        layeredPane.add(pos3PikachuLabel, Integer.valueOf(2));
        // Pokebola
        pos3PokebolaLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pokebola.png", "").getImage(), 50, 50)));
        pos3PokebolaLabel.setBounds(269,429, 50, 50);
        layeredPane.add(pos3PokebolaLabel, Integer.valueOf(1));

        //  --------- Posicion 4 ------------
        // Adversario
        pos4AdvLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("adversario.png", "").getImage(), 50, 50)));
        pos4AdvLabel.setBounds(280,556, 50, 50);
        layeredPane.add(pos4AdvLabel, Integer.valueOf(1));
        // Pokemon
        pos4PikachuLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pikachu.png", "").getImage(), 50, 50)));
        pos4PikachuLabel.setBounds(280,556, 50, 50);
        layeredPane.add(pos4PikachuLabel, Integer.valueOf(2));
        // Pokebola
        pos4PokebolaLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pokebola.png", "").getImage(), 50, 50)));
        pos4PokebolaLabel.setBounds(280,556, 50, 50);
        layeredPane.add(pos4PokebolaLabel, Integer.valueOf(1));

        //  --------- Posicion 5 ------------
        // Adversario
        pos5AdvLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("adversario.png", "").getImage(), 50, 50)));
        pos5AdvLabel.setBounds(320,494, 50, 50);
        layeredPane.add(pos5AdvLabel, Integer.valueOf(1));
        // Pokemon
        pos5PikachuLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pikachu.png", "").getImage(), 50, 50)));
        pos5PikachuLabel.setBounds(320,494, 50, 50);
        layeredPane.add(pos5PikachuLabel, Integer.valueOf(2));
        // Pokebola
        pos5PokebolaLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pokebola.png", "").getImage(), 50, 50)));
        pos5PokebolaLabel.setBounds(320,494, 50, 50);
        layeredPane.add(pos5PokebolaLabel, Integer.valueOf(1));

        //  --------- Posicion 6 ------------
        // Adversario
        pos6AdvLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("adversario.png", "").getImage(), 50, 50)));
        pos6AdvLabel.setBounds(346,440, 50, 50);
        layeredPane.add(pos6AdvLabel, Integer.valueOf(1));
        // Pokemon
        pos6PikachuLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pikachu.png", "").getImage(), 50, 50)));
        pos6PikachuLabel.setBounds(346,440, 50, 50);
        layeredPane.add(pos6PikachuLabel, Integer.valueOf(2));
        // Pokebola
        pos6PokebolaLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pokebola.png", "").getImage(), 50, 50)));
        pos6PokebolaLabel.setBounds(346,440, 50, 50);
        layeredPane.add(pos6PokebolaLabel, Integer.valueOf(1));

        //  --------- Posicion 7 ------------
        // Adversario
        pos7AdvLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("adversario.png", "").getImage(), 50, 50)));
        pos7AdvLabel.setBounds(282,312, 50, 50);
        layeredPane.add(pos7AdvLabel, Integer.valueOf(1));
        // Pokemon
        pos7PikachuLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pikachu.png", "").getImage(), 50, 50)));
        pos7PikachuLabel.setBounds(282,312, 50, 50);
        layeredPane.add(pos7PikachuLabel, Integer.valueOf(2));
        // Pokebola
        pos7PokebolaLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pokebola.png", "").getImage(), 50, 50)));
        pos7PokebolaLabel.setBounds(282,312, 50, 50);
        layeredPane.add(pos7PokebolaLabel, Integer.valueOf(1));

        //  --------- Posicion 8 ------------
        // Adversario
        pos8AdvLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("adversario.png", "").getImage(), 50, 50)));
        pos8AdvLabel.setBounds(435,311, 50, 50);
        layeredPane.add(pos8AdvLabel, Integer.valueOf(1));
        // Pokemon
        pos8PikachuLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pikachu.png", "").getImage(), 50, 50)));
        pos8PikachuLabel.setBounds(435,311, 50, 50);
        layeredPane.add(pos8PikachuLabel, Integer.valueOf(2));
        // Pokebola
        pos8PokebolaLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pokebola.png", "").getImage(), 50, 50)));
        pos8PokebolaLabel.setBounds(435,311, 50, 50);
        layeredPane.add(pos8PokebolaLabel, Integer.valueOf(1));

        //  --------- Posicion 9 ------------
        // Adversario
        pos9AdvLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("adversario.png", "").getImage(), 50, 50)));
        pos9AdvLabel.setBounds(316,195, 50, 50);
        layeredPane.add(pos9AdvLabel, Integer.valueOf(1));
        // Pokemon
        pos9PikachuLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pikachu.png", "").getImage(), 50, 50)));
        pos9PikachuLabel.setBounds(316,195, 50, 50);
        layeredPane.add(pos9PikachuLabel, Integer.valueOf(2));
        // Pokebola
        pos9PokebolaLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pokebola.png", "").getImage(), 50, 50)));
        pos9PokebolaLabel.setBounds(316,195, 50, 50);
        layeredPane.add(pos9PokebolaLabel, Integer.valueOf(1));

        //  --------- Posicion 10 ------------
        // Adversario
        pos10AdvLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("adversario.png", "").getImage(), 50, 50)));
        pos10AdvLabel.setBounds(398,88, 50, 50);
        layeredPane.add(pos10AdvLabel, Integer.valueOf(1));
        // Pokemon
        pos10PikachuLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pikachu.png", "").getImage(), 50, 50)));
        pos10PikachuLabel.setBounds(398,88, 50, 50);
        layeredPane.add(pos10PikachuLabel, Integer.valueOf(2));
        // Pokebola
        pos10PokebolaLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pokebola.png", "").getImage(), 50, 50)));
        pos10PokebolaLabel.setBounds(398,88, 50, 50);
        layeredPane.add(pos10PokebolaLabel, Integer.valueOf(1));

        //  --------- Posicion 11 ------------
        // Adversario
        pos11AdvLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("adversario.png", "").getImage(), 50, 50)));
        pos11AdvLabel.setBounds(519,194, 50, 50);
        layeredPane.add(pos11AdvLabel, Integer.valueOf(1));
        // Pokemon
        pos11PikachuLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pikachu.png", "").getImage(), 50, 50)));
        pos11PikachuLabel.setBounds(519,194, 50, 50);
        layeredPane.add(pos11PikachuLabel, Integer.valueOf(2));
        // Pokebola
        pos11PokebolaLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pokebola.png", "").getImage(), 50, 50)));
        pos11PokebolaLabel.setBounds(519,194, 50, 50);
        layeredPane.add(pos11PokebolaLabel, Integer.valueOf(1));

        //  --------- Posicion 12 ------------
        // Adversario
        pos12AdvLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("adversario.png", "").getImage(), 50, 50)));
        pos12AdvLabel.setBounds(521,323, 50, 50);
        layeredPane.add(pos12AdvLabel, Integer.valueOf(1));
        // Pokemon
        pos12PikachuLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pikachu.png", "").getImage(), 50, 50)));
        pos12PikachuLabel.setBounds(521,323, 50, 50);
        layeredPane.add(pos12PikachuLabel, Integer.valueOf(2));
        // Pokebola
        pos12PokebolaLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pokebola.png", "").getImage(), 50, 50)));
        pos12PokebolaLabel.setBounds(521,323, 50, 50);
        layeredPane.add(pos12PokebolaLabel, Integer.valueOf(1));

        //  --------- Posicion 13 ------------
        // Adversario
        pos13AdvLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("adversario.png", "").getImage(), 50, 50)));
        pos13AdvLabel.setBounds(585,90, 50, 50);
        layeredPane.add(pos13AdvLabel, Integer.valueOf(1));
        // Pokemon
        pos13PikachuLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pikachu.png", "").getImage(), 50, 50)));
        pos13PikachuLabel.setBounds(585,90, 50, 50);
        layeredPane.add(pos13PikachuLabel, Integer.valueOf(2));
        // Pokebola
        pos13PokebolaLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pokebola.png", "").getImage(), 50, 50)));
        pos13PokebolaLabel.setBounds(585,90, 50, 50);
        layeredPane.add(pos13PokebolaLabel, Integer.valueOf(1));

        //  --------- Posicion 14 ------------
        // Adversario
        pos14AdvLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("adversario.png", "").getImage(), 50, 50)));
        pos14AdvLabel.setBounds(604,143, 50, 50);
        layeredPane.add(pos14AdvLabel, Integer.valueOf(1));
        // Pokemon
        pos14PikachuLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pikachu.png", "").getImage(), 50, 50)));
        pos14PikachuLabel.setBounds(604,143, 50, 50);
        layeredPane.add(pos14PikachuLabel, Integer.valueOf(2));
        // Pokebola
        pos14PokebolaLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pokebola.png", "").getImage(), 50, 50)));
        pos14PokebolaLabel.setBounds(604,143, 50, 50);
        layeredPane.add(pos14PokebolaLabel, Integer.valueOf(1));

        //  --------- Posicion 15 ------------
        // Adversario
        pos15AdvLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("adversario.png", "").getImage(), 50, 50)));
        pos15AdvLabel.setBounds(644,298, 50, 50);
        layeredPane.add(pos15AdvLabel, Integer.valueOf(1));
        // Pokemon
        pos15PikachuLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pikachu.png", "").getImage(), 50, 50)));
        pos15PikachuLabel.setBounds(644,298, 50, 50);
        layeredPane.add(pos15PikachuLabel, Integer.valueOf(2));
        // Pokebola
        pos15PokebolaLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pokebola.png", "").getImage(), 50, 50)));
        pos15PokebolaLabel.setBounds(644,298, 50, 50);
        layeredPane.add(pos15PokebolaLabel, Integer.valueOf(1));

        //  --------- Posicion 16 ------------
        // Adversario
        pos16AdvLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("adversario.png", "").getImage(), 50, 50)));
        pos16AdvLabel.setBounds(644,493, 50, 50);
        layeredPane.add(pos16AdvLabel, Integer.valueOf(1));
        // Pokemon
        pos16PikachuLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pikachu.png", "").getImage(), 50, 50)));
        pos16PikachuLabel.setBounds(644,493, 50, 50);
        layeredPane.add(pos16PikachuLabel, Integer.valueOf(2));
        // Pokebola
        pos16PokebolaLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pokebola.png", "").getImage(), 50, 50)));
        pos16PokebolaLabel.setBounds(644,493, 50, 50);
        layeredPane.add(pos16PokebolaLabel, Integer.valueOf(1));

        //  --------- Posicion 17 ------------
        // Adversario
        pos17AdvLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("adversario.png", "").getImage(), 50, 50)));
        pos17AdvLabel.setBounds(744,124, 50, 50);
        layeredPane.add(pos17AdvLabel, Integer.valueOf(1));
        // Pokemon
        pos17PikachuLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pikachu.png", "").getImage(), 50, 50)));
        pos17PikachuLabel.setBounds(744,124, 50, 50);
        layeredPane.add(pos17PikachuLabel, Integer.valueOf(2));
        // Pokebola
        pos17PokebolaLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pokebola.png", "").getImage(), 50, 50)));
        pos17PokebolaLabel.setBounds(744,124, 50, 50);
        layeredPane.add(pos17PokebolaLabel, Integer.valueOf(1));


        //  --------- Posicion 18 ------------
        // Adversario
        pos18AdvLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("adversario.png", "").getImage(), 50, 50)));
        pos18AdvLabel.setBounds(739,280, 50, 50);
        layeredPane.add(pos18AdvLabel, Integer.valueOf(1));
        // Pokemon
        pos18PikachuLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pikachu.png", "").getImage(), 50, 50)));
        pos18PikachuLabel.setBounds(739,280, 50, 50);
        layeredPane.add(pos18PikachuLabel, Integer.valueOf(2));
        // Pokebola
        pos18PokebolaLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pokebola.png", "").getImage(), 50, 50)));
        pos18PokebolaLabel.setBounds(739,280, 50, 50);
        layeredPane.add(pos18PokebolaLabel, Integer.valueOf(1));

        //  --------- Posicion 19 ------------
        // Adversario
        pos19AdvLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("adversario.png", "").getImage(), 50, 50)));
        pos19AdvLabel.setBounds(898,103, 50, 50);
        layeredPane.add(pos19AdvLabel, Integer.valueOf(1));
        // Pokemon
        pos19PikachuLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pikachu.png", "").getImage(), 50, 50)));
        pos19PikachuLabel.setBounds(898,103, 50, 50);
        layeredPane.add(pos19PikachuLabel, Integer.valueOf(2));
        // Pokebola
        pos19PokebolaLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pokebola.png", "").getImage(), 50, 50)));
        pos19PokebolaLabel.setBounds(898,103, 50, 50);
        layeredPane.add(pos19PokebolaLabel, Integer.valueOf(1));

        //  --------- Posicion 20 ------------
        // Adversario
        pos20AdvLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("adversario.png", "").getImage(), 50, 50)));
        pos20AdvLabel.setBounds(859,272, 50, 50);
        layeredPane.add(pos20AdvLabel, Integer.valueOf(1));
        // Pokemon
        pos20PikachuLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pikachu.png", "").getImage(), 50, 50)));
        pos20PikachuLabel.setBounds(859,272, 50, 50);
        layeredPane.add(pos20PikachuLabel, Integer.valueOf(2));
        // Pokebola
        pos20PokebolaLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pokebola.png", "").getImage(), 50, 50)));
        pos20PokebolaLabel.setBounds(859,272, 50, 50);
        layeredPane.add(pos20PokebolaLabel, Integer.valueOf(1));

        //  --------- Posicion 21 ------------
        // Adversario
        pos21AdvLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("adversario.png", "").getImage(), 50, 50)));
        pos21AdvLabel.setBounds(849,493, 50, 50);
        layeredPane.add(pos21AdvLabel, Integer.valueOf(1));
        // Pokemon
        pos21PikachuLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pikachu.png", "").getImage(), 50, 50)));
        pos21PikachuLabel.setBounds(849,493, 50, 50);
        layeredPane.add(pos21PikachuLabel, Integer.valueOf(2));
        // Pokebola
        pos21PokebolaLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pokebola.png", "").getImage(), 50, 50)));
        pos21PokebolaLabel.setBounds(849,493, 50, 50);
        layeredPane.add(pos21PokebolaLabel, Integer.valueOf(1));

        //  --------- Posicion 22 ------------
        // Adversario
        pos22AdvLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("adversario.png", "").getImage(), 50, 50)));
        pos22AdvLabel.setBounds(957,169, 50, 50);
        layeredPane.add(pos22AdvLabel, Integer.valueOf(1));
        // Pokemon
        pos22PikachuLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pikachu.png", "").getImage(), 50, 50)));
        pos22PikachuLabel.setBounds(957,169, 50, 50);
        layeredPane.add(pos22PikachuLabel, Integer.valueOf(2));
        // Pokebola
        pos22PokebolaLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pokebola.png", "").getImage(), 50, 50)));
        pos22PokebolaLabel.setBounds(957,169, 50, 50);
        layeredPane.add(pos22PokebolaLabel, Integer.valueOf(1));

        //  --------- Posicion 23 ------------
        // Adversario
        pos23AdvLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("adversario.png", "").getImage(), 50, 50)));
        pos23AdvLabel.setBounds(955,406, 50, 50);
        layeredPane.add(pos23AdvLabel, Integer.valueOf(1));
        // Pokemon
        pos23PikachuLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pikachu.png", "").getImage(), 50, 50)));
        pos23PikachuLabel.setBounds(955,406, 50, 50);
        layeredPane.add(pos23PikachuLabel, Integer.valueOf(2));
        // Pokebola
        pos23PokebolaLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pokebola.png", "").getImage(), 50, 50)));
        pos23PokebolaLabel.setBounds(955,406, 50, 50);
        layeredPane.add(pos23PokebolaLabel, Integer.valueOf(1));

        //  --------- Posicion 24 ------------
        // Adversario
        pos24AdvLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("adversario.png", "").getImage(), 50, 50)));
        pos24AdvLabel.setBounds(1074,87, 50, 50);
        layeredPane.add(pos24AdvLabel, Integer.valueOf(1));
        // Pokemon
        pos24PikachuLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pikachu.png", "").getImage(), 50, 50)));
        pos24PikachuLabel.setBounds(1074,87, 50, 50);
        layeredPane.add(pos24PikachuLabel, Integer.valueOf(2));
        // Pokebola
        pos24PokebolaLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pokebola.png", "").getImage(), 50, 50)));
        pos24PokebolaLabel.setBounds(1074,87, 50, 50);
        layeredPane.add(pos24PokebolaLabel, Integer.valueOf(1));

        //  --------- Posicion 25 ------------
        // Adversario
        pos25AdvLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("adversario.png", "").getImage(), 50, 50)));
        pos25AdvLabel.setBounds(1056,230, 50, 50);
        layeredPane.add(pos25AdvLabel, Integer.valueOf(1));
        // Pokemon
        pos25PikachuLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pikachu.png", "").getImage(), 50, 50)));
        pos25PikachuLabel.setBounds(1056,230, 50, 50);
        layeredPane.add(pos25PikachuLabel, Integer.valueOf(2));
        // Pokebola
        pos25PokebolaLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pokebola.png", "").getImage(), 50, 50)));
        pos25PokebolaLabel.setBounds(1056,230, 50, 50);
        layeredPane.add(pos25PokebolaLabel, Integer.valueOf(1));

        //  --------- Posicion 26 ------------
        // Adversario
        pos26AdvLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("adversario.png", "").getImage(), 50, 50)));
        pos26AdvLabel.setBounds(1054,405, 50, 50);
        layeredPane.add(pos26AdvLabel, Integer.valueOf(1));
        // Pokemon
        pos26PikachuLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pikachu.png", "").getImage(), 50, 50)));
        pos26PikachuLabel.setBounds(1054,405, 50, 50);
        layeredPane.add(pos26PikachuLabel, Integer.valueOf(2));
        // Pokebola
        pos26PokebolaLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pokebola.png", "").getImage(), 50, 50)));
        pos26PokebolaLabel.setBounds(1054,405, 50, 50);
        layeredPane.add(pos26PokebolaLabel, Integer.valueOf(1));

        //  --------- Posicion 27 ------------
        // Adversario
        pos27AdvLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("adversario.png", "").getImage(), 50, 50)));
        pos27AdvLabel.setBounds(1039,483, 50, 50);
        layeredPane.add(pos27AdvLabel, Integer.valueOf(1));
        // Pokemon
        pos27PikachuLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pikachu.png", "").getImage(), 50, 50)));
        pos27PikachuLabel.setBounds(1039,483, 50, 50);
        layeredPane.add(pos27PikachuLabel, Integer.valueOf(2));
        // Pokebola
        pos27PokebolaLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pokebola.png", "").getImage(), 50, 50)));
        pos27PokebolaLabel.setBounds(1039,483, 50, 50);
        layeredPane.add(pos27PokebolaLabel, Integer.valueOf(1));

        //  --------- Posicion 28 ------------
        // Adversario
        pos28AdvLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("adversario.png", "").getImage(), 50, 50)));
        pos28AdvLabel.setBounds(1166,555, 50, 50);
        layeredPane.add(pos28AdvLabel, Integer.valueOf(1));
        // Pokemon
        pos28PikachuLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pikachu.png", "").getImage(), 50, 50)));
        pos28PikachuLabel.setBounds(1166,555, 50, 50);
        layeredPane.add(pos28PikachuLabel, Integer.valueOf(2));
        // Pokebola
        pos28PokebolaLabel = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pokebola.png", "").getImage(), 50, 50)));
        pos28PokebolaLabel.setBounds(1166,555, 50, 50);
        layeredPane.add(pos28PokebolaLabel, Integer.valueOf(1));


        // Label victoria
        labelVictoria = new JLabel("¡Pikachu consiguio el objetivo!");
        labelVictoria.setBackground(Color.GREEN);
        labelVictoria.setHorizontalAlignment(SwingConstants.CENTER);
        labelVictoria.setOpaque(true);
        labelVictoria.setBounds(416,570,200,50);
        layeredPane.add(labelVictoria, Integer.valueOf(2));

        // Label derrota
        labelDerrota = new JLabel("Pikachu NO consiguio el objetivo.");
        labelDerrota.setBackground(Color.RED);
        labelDerrota.setHorizontalAlignment(SwingConstants.CENTER);
        labelDerrota.setOpaque(true);
        labelDerrota.setBounds(416,570,200,50);
        layeredPane.add(labelDerrota, Integer.valueOf(2));


        setTitle("Pokemon");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(background.getIconWidth()+10, background.getIconHeight()+30);
        setLocationRelativeTo(null);
        setContentPane(panel1);
        setVisible(true);


    }

    private ImageIcon createImageIcon(String path,
                                      String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    private Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

    public void setAllNoVisible() {

        // Posicion 0
        pos0AdvLabel.setVisible(false);
        pos0PikachuLabel.setVisible(false);
        pos0PokebolaLabel.setVisible(false);

        // Posicion 1
        pos1AdvLabel.setVisible(false);
        pos1PikachuLabel.setVisible(false);
        pos1PokebolaLabel.setVisible(false);

        // Posicion 2
        pos2AdvLabel.setVisible(false);
        pos2PikachuLabel.setVisible(false);
        pos2PokebolaLabel.setVisible(false);

        // Posicion 3
        pos3AdvLabel.setVisible(false);
        pos3PikachuLabel.setVisible(false);
        pos3PokebolaLabel.setVisible(false);

        // Posicion 4
        pos4AdvLabel.setVisible(false);
        pos4PikachuLabel.setVisible(false);
        pos4PokebolaLabel.setVisible(false);

        // Posicion 5
        pos5AdvLabel.setVisible(false);
        pos5PikachuLabel.setVisible(false);
        pos5PokebolaLabel.setVisible(false);

        // Posicion 6
        pos6AdvLabel.setVisible(false);
        pos6PikachuLabel.setVisible(false);
        pos6PokebolaLabel.setVisible(false);

        // Posicion 7
        pos7AdvLabel.setVisible(false);
        pos7PikachuLabel.setVisible(false);
        pos7PokebolaLabel.setVisible(false);

        // Posicion 8
        pos8AdvLabel.setVisible(false);
        pos8PikachuLabel.setVisible(false);
        pos8PokebolaLabel.setVisible(false);

        // Posicion 9
        pos9AdvLabel.setVisible(false);
        pos9PikachuLabel.setVisible(false);
        pos9PokebolaLabel.setVisible(false);

        // Posicion 10
        pos10AdvLabel.setVisible(false);
        pos10PikachuLabel.setVisible(false);
        pos10PokebolaLabel.setVisible(false);

        // Posicion 11
        pos11AdvLabel.setVisible(false);
        pos11PikachuLabel.setVisible(false);
        pos11PokebolaLabel.setVisible(false);

        // Posicion 12
        pos12AdvLabel.setVisible(false);
        pos12PikachuLabel.setVisible(false);
        pos12PokebolaLabel.setVisible(false);

        // Posicion 13
        pos13AdvLabel.setVisible(false);
        pos13PikachuLabel.setVisible(false);
        pos13PokebolaLabel.setVisible(false);

        // Posicion 14
        pos14AdvLabel.setVisible(false);
        pos14PikachuLabel.setVisible(false);
        pos14PokebolaLabel.setVisible(false);

        // Posicion 15
        pos15AdvLabel.setVisible(false);
        pos15PikachuLabel.setVisible(false);
        pos15PokebolaLabel.setVisible(false);

        // Posicion 16
        pos16AdvLabel.setVisible(false);
        pos16PikachuLabel.setVisible(false);
        pos16PokebolaLabel.setVisible(false);

        // Posicion 17
        pos17AdvLabel.setVisible(false);
        pos17PikachuLabel.setVisible(false);
        pos17PokebolaLabel.setVisible(false);

        // Posicion 18
        pos18AdvLabel.setVisible(false);
        pos18PikachuLabel.setVisible(false);
        pos18PokebolaLabel.setVisible(false);

        // Posicion 19
        pos19AdvLabel.setVisible(false);
        pos19PikachuLabel.setVisible(false);
        pos19PokebolaLabel.setVisible(false);

        // Posicion 20
        pos20AdvLabel.setVisible(false);
        pos20PikachuLabel.setVisible(false);
        pos20PokebolaLabel.setVisible(false);

        // Posicion 21
        pos21AdvLabel.setVisible(false);
        pos21PikachuLabel.setVisible(false);
        pos21PokebolaLabel.setVisible(false);

        // Posicion 22
        pos22AdvLabel.setVisible(false);
        pos22PikachuLabel.setVisible(false);
        pos22PokebolaLabel.setVisible(false);

        // Posicion 23
        pos23AdvLabel.setVisible(false);
        pos23PikachuLabel.setVisible(false);
        pos23PokebolaLabel.setVisible(false);

        // Posicion 24
        pos24AdvLabel.setVisible(false);
        pos24PikachuLabel.setVisible(false);
        pos24PokebolaLabel.setVisible(false);

        // Posicion 25
        pos25AdvLabel.setVisible(false);
        pos25PikachuLabel.setVisible(false);
        pos25PokebolaLabel.setVisible(false);

        // Posicion 26
        pos26AdvLabel.setVisible(false);
        pos26PikachuLabel.setVisible(false);
        pos26PokebolaLabel.setVisible(false);

        // Posicion 27
        pos27AdvLabel.setVisible(false);
        pos27PikachuLabel.setVisible(false);
        pos27PokebolaLabel.setVisible(false);

        // Posicion 28
        pos28AdvLabel.setVisible(false);
        pos28PikachuLabel.setVisible(false);
        pos28PokebolaLabel.setVisible(false);

        // Label victoria y derrota
        labelVictoria.setVisible(false);
        labelDerrota.setVisible(false);
    }

    public void setAdvVisible(int i){
        switch (i){
            case 0: pos0AdvLabel.setVisible(true); break;
            case 1: pos1AdvLabel.setVisible(true);break;
            case 2: pos2AdvLabel.setVisible(true);break;
            case 3: pos3AdvLabel.setVisible(true);break;
            case 4: pos4AdvLabel.setVisible(true);break;
            case 5: pos5AdvLabel.setVisible(true);break;
            case 6: pos6AdvLabel.setVisible(true);break;
            case 7: pos7AdvLabel.setVisible(true);break;
            case 8: pos8AdvLabel.setVisible(true);break;
            case 9: pos9AdvLabel.setVisible(true);break;
            case 10: pos10AdvLabel.setVisible(true);break;
            case 11: pos11AdvLabel.setVisible(true);break;
            case 12: pos12AdvLabel.setVisible(true);break;
            case 13: pos13AdvLabel.setVisible(true);break;
            case 14: pos14AdvLabel.setVisible(true);break;
            case 15: pos15AdvLabel.setVisible(true);break;
            case 16: pos16AdvLabel.setVisible(true);break;
            case 17: pos17AdvLabel.setVisible(true);break;
            case 18: pos18AdvLabel.setVisible(true);break;
            case 19: pos19AdvLabel.setVisible(true);break;
            case 20: pos20AdvLabel.setVisible(true);break;
            case 21: pos21AdvLabel.setVisible(true);break;
            case 22: pos22AdvLabel.setVisible(true);break;
            case 23: pos23AdvLabel.setVisible(true);break;
            case 24: pos24AdvLabel.setVisible(true);break;
            case 25: pos25AdvLabel.setVisible(true);break;
            case 26: pos26AdvLabel.setVisible(true);break;
            case 27: pos27AdvLabel.setVisible(true);break;
            case 28: pos28AdvLabel.setVisible(true);break;
        }
    }

    public void setPokebolaVisible(int i){
        switch (i){
            case 0: pos0PokebolaLabel.setVisible(true);break;
            case 1: pos1PokebolaLabel.setVisible(true);break;
            case 2: pos2PokebolaLabel.setVisible(true);break;
            case 3: pos3PokebolaLabel.setVisible(true);break;
            case 4: pos4PokebolaLabel.setVisible(true);break;
            case 5: pos5PokebolaLabel.setVisible(true);break;
            case 6: pos6PokebolaLabel.setVisible(true);break;
            case 7: pos7PokebolaLabel.setVisible(true);break;
            case 8: pos8PokebolaLabel.setVisible(true);break;
            case 9: pos9PokebolaLabel.setVisible(true);break;
            case 10: pos10PokebolaLabel.setVisible(true);break;
            case 11: pos11PokebolaLabel.setVisible(true);break;
            case 12: pos12PokebolaLabel.setVisible(true);break;
            case 13: pos13PokebolaLabel.setVisible(true);break;
            case 14: pos14PokebolaLabel.setVisible(true);break;
            case 15: pos15PokebolaLabel.setVisible(true);break;
            case 16: pos16PokebolaLabel.setVisible(true);break;
            case 17: pos17PokebolaLabel.setVisible(true);break;
            case 18: pos18PokebolaLabel.setVisible(true);break;
            case 19: pos19PokebolaLabel.setVisible(true);break;
            case 20: pos20PokebolaLabel.setVisible(true);break;
            case 21: pos21PokebolaLabel.setVisible(true);break;
            case 22: pos22PokebolaLabel.setVisible(true);break;
            case 23: pos23PokebolaLabel.setVisible(true);break;
            case 24: pos24PokebolaLabel.setVisible(true);break;
            case 25: pos25PokebolaLabel.setVisible(true);break;
            case 26: pos26PokebolaLabel.setVisible(true);break;
            case 27: pos27PokebolaLabel.setVisible(true);break;
            case 28: pos28PokebolaLabel.setVisible(true);break;
        }
    }

    public void setPikachuVisible(int i){
        switch (i){
            case 0: pos0PikachuLabel.setVisible(true);break;
            case 1: pos1PikachuLabel.setVisible(true);break;
            case 2: pos2PikachuLabel.setVisible(true);break;
            case 3: pos3PikachuLabel.setVisible(true);break;
            case 4: pos4PikachuLabel.setVisible(true);break;
            case 5: pos5PikachuLabel.setVisible(true);break;
            case 6: pos6PikachuLabel.setVisible(true);break;
            case 7: pos7PikachuLabel.setVisible(true);break;
            case 8: pos8PikachuLabel.setVisible(true);break;
            case 9: pos9PikachuLabel.setVisible(true);break;
            case 10: pos10PikachuLabel.setVisible(true);break;
            case 11: pos11PikachuLabel.setVisible(true);break;
            case 12: pos12PikachuLabel.setVisible(true);break;
            case 13: pos13PikachuLabel.setVisible(true);break;
            case 14: pos14PikachuLabel.setVisible(true);break;
            case 15: pos15PikachuLabel.setVisible(true);break;
            case 16: pos16PikachuLabel.setVisible(true);break;
            case 17: pos17PikachuLabel.setVisible(true);break;
            case 18: pos18PikachuLabel.setVisible(true);break;
            case 19: pos19PikachuLabel.setVisible(true);break;
            case 20: pos20PikachuLabel.setVisible(true);break;
            case 21: pos21PikachuLabel.setVisible(true);break;
            case 22: pos22PikachuLabel.setVisible(true);break;
            case 23: pos23PikachuLabel.setVisible(true);break;
            case 24: pos24PikachuLabel.setVisible(true);break;
            case 25: pos25PikachuLabel.setVisible(true);break;
            case 26: pos26PikachuLabel.setVisible(true);break;
            case 27: pos27PikachuLabel.setVisible(true);break;
            case 28: pos28PikachuLabel.setVisible(true);break;
        }
    }


    public static void main(String[] args) {
        PokemonUI ui = new PokemonUI();
        //ui.setAllNoVisible();
    }

    // Getters y setters
    //region

    public JLabel getLabelVictoria() {
        return labelVictoria;
    }

    public void setLabelVictoria(JLabel labelVictoria) {
        this.labelVictoria = labelVictoria;
    }

    public JLabel getLabelDerrota() {
        return labelDerrota;
    }

    public void setLabelDerrota(JLabel labelDerrota) {
        this.labelDerrota = labelDerrota;
    }

    public JLabel getBackgroundLabel() {
        return backgroundLabel;
    }

    public void setBackgroundLabel(JLabel backgroundLabel) {
        this.backgroundLabel = backgroundLabel;
    }

    public JLabel getPos0AdvLabel() {
        return pos0AdvLabel;
    }

    public void setPos0AdvLabel(JLabel pos0AdvLabel) {
        this.pos0AdvLabel = pos0AdvLabel;
    }

    public JLabel getPos0PikachuLabel() {
        return pos0PikachuLabel;
    }

    public void setPos0PikachuLabel(JLabel pos0PikachuLabel) {
        this.pos0PikachuLabel = pos0PikachuLabel;
    }

    public JLabel getPos0PokebolaLabel() {
        return pos0PokebolaLabel;
    }

    public void setPos0PokebolaLabel(JLabel pos0PokebolaLabel) {
        this.pos0PokebolaLabel = pos0PokebolaLabel;
    }

    public JLabel getPos1AdvLabel() {
        return pos1AdvLabel;
    }

    public void setPos1AdvLabel(JLabel pos1AdvLabel) {
        this.pos1AdvLabel = pos1AdvLabel;
    }

    public JLabel getPos1PikachuLabel() {
        return pos1PikachuLabel;
    }

    public void setPos1PikachuLabel(JLabel pos1PikachuLabel) {
        this.pos1PikachuLabel = pos1PikachuLabel;
    }

    public JLabel getPos1PokebolaLabel() {
        return pos1PokebolaLabel;
    }

    public void setPos1PokebolaLabel(JLabel pos1PokebolaLabel) {
        this.pos1PokebolaLabel = pos1PokebolaLabel;
    }

    public JLabel getPos2AdvLabel() {
        return pos2AdvLabel;
    }

    public void setPos2AdvLabel(JLabel pos2AdvLabel) {
        this.pos2AdvLabel = pos2AdvLabel;
    }

    public JLabel getPos2PikachuLabel() {
        return pos2PikachuLabel;
    }

    public void setPos2PikachuLabel(JLabel pos2PikachuLabel) {
        this.pos2PikachuLabel = pos2PikachuLabel;
    }

    public JLabel getPos2PokebolaLabel() {
        return pos2PokebolaLabel;
    }

    public void setPos2PokebolaLabel(JLabel pos2PokebolaLabel) {
        this.pos2PokebolaLabel = pos2PokebolaLabel;
    }

    public JLabel getPos3AdvLabel() {
        return pos3AdvLabel;
    }

    public void setPos3AdvLabel(JLabel pos3AdvLabel) {
        this.pos3AdvLabel = pos3AdvLabel;
    }

    public JLabel getPos3PikachuLabel() {
        return pos3PikachuLabel;
    }

    public void setPos3PikachuLabel(JLabel pos3PikachuLabel) {
        this.pos3PikachuLabel = pos3PikachuLabel;
    }

    public JLabel getPos3PokebolaLabel() {
        return pos3PokebolaLabel;
    }

    public void setPos3PokebolaLabel(JLabel pos3PokebolaLabel) {
        this.pos3PokebolaLabel = pos3PokebolaLabel;
    }

    public JLabel getPos4AdvLabel() {
        return pos4AdvLabel;
    }

    public void setPos4AdvLabel(JLabel pos4AdvLabel) {
        this.pos4AdvLabel = pos4AdvLabel;
    }

    public JLabel getPos4PikachuLabel() {
        return pos4PikachuLabel;
    }

    public void setPos4PikachuLabel(JLabel pos4PikachuLabel) {
        this.pos4PikachuLabel = pos4PikachuLabel;
    }

    public JLabel getPos4PokebolaLabel() {
        return pos4PokebolaLabel;
    }

    public void setPos4PokebolaLabel(JLabel pos4PokebolaLabel) {
        this.pos4PokebolaLabel = pos4PokebolaLabel;
    }

    public JLabel getPos5AdvLabel() {
        return pos5AdvLabel;
    }

    public void setPos5AdvLabel(JLabel pos5AdvLabel) {
        this.pos5AdvLabel = pos5AdvLabel;
    }

    public JLabel getPos5PikachuLabel() {
        return pos5PikachuLabel;
    }

    public void setPos5PikachuLabel(JLabel pos5PikachuLabel) {
        this.pos5PikachuLabel = pos5PikachuLabel;
    }

    public JLabel getPos5PokebolaLabel() {
        return pos5PokebolaLabel;
    }

    public void setPos5PokebolaLabel(JLabel pos5PokebolaLabel) {
        this.pos5PokebolaLabel = pos5PokebolaLabel;
    }

    public JLabel getPos6AdvLabel() {
        return pos6AdvLabel;
    }

    public void setPos6AdvLabel(JLabel pos6AdvLabel) {
        this.pos6AdvLabel = pos6AdvLabel;
    }

    public JLabel getPos6PikachuLabel() {
        return pos6PikachuLabel;
    }

    public void setPos6PikachuLabel(JLabel pos6PikachuLabel) {
        this.pos6PikachuLabel = pos6PikachuLabel;
    }

    public JLabel getPos6PokebolaLabel() {
        return pos6PokebolaLabel;
    }

    public void setPos6PokebolaLabel(JLabel pos6PokebolaLabel) {
        this.pos6PokebolaLabel = pos6PokebolaLabel;
    }

    public JLabel getPos7AdvLabel() {
        return pos7AdvLabel;
    }

    public void setPos7AdvLabel(JLabel pos7AdvLabel) {
        this.pos7AdvLabel = pos7AdvLabel;
    }

    public JLabel getPos7PikachuLabel() {
        return pos7PikachuLabel;
    }

    public void setPos7PikachuLabel(JLabel pos7PikachuLabel) {
        this.pos7PikachuLabel = pos7PikachuLabel;
    }

    public JLabel getPos7PokebolaLabel() {
        return pos7PokebolaLabel;
    }

    public void setPos7PokebolaLabel(JLabel pos7PokebolaLabel) {
        this.pos7PokebolaLabel = pos7PokebolaLabel;
    }

    public JLabel getPos8AdvLabel() {
        return pos8AdvLabel;
    }

    public void setPos8AdvLabel(JLabel pos8AdvLabel) {
        this.pos8AdvLabel = pos8AdvLabel;
    }

    public JLabel getPos8PikachuLabel() {
        return pos8PikachuLabel;
    }

    public void setPos8PikachuLabel(JLabel pos8PikachuLabel) {
        this.pos8PikachuLabel = pos8PikachuLabel;
    }

    public JLabel getPos8PokebolaLabel() {
        return pos8PokebolaLabel;
    }

    public void setPos8PokebolaLabel(JLabel pos8PokebolaLabel) {
        this.pos8PokebolaLabel = pos8PokebolaLabel;
    }

    public JLabel getPos9AdvLabel() {
        return pos9AdvLabel;
    }

    public void setPos9AdvLabel(JLabel pos9AdvLabel) {
        this.pos9AdvLabel = pos9AdvLabel;
    }

    public JLabel getPos9PikachuLabel() {
        return pos9PikachuLabel;
    }

    public void setPos9PikachuLabel(JLabel pos9PikachuLabel) {
        this.pos9PikachuLabel = pos9PikachuLabel;
    }

    public JLabel getPos9PokebolaLabel() {
        return pos9PokebolaLabel;
    }

    public void setPos9PokebolaLabel(JLabel pos9PokebolaLabel) {
        this.pos9PokebolaLabel = pos9PokebolaLabel;
    }

    public JLabel getPos10AdvLabel() {
        return pos10AdvLabel;
    }

    public void setPos10AdvLabel(JLabel pos10AdvLabel) {
        this.pos10AdvLabel = pos10AdvLabel;
    }

    public JLabel getPos10PikachuLabel() {
        return pos10PikachuLabel;
    }

    public void setPos10PikachuLabel(JLabel pos10PikachuLabel) {
        this.pos10PikachuLabel = pos10PikachuLabel;
    }

    public JLabel getPos10PokebolaLabel() {
        return pos10PokebolaLabel;
    }

    public void setPos10PokebolaLabel(JLabel pos10PokebolaLabel) {
        this.pos10PokebolaLabel = pos10PokebolaLabel;
    }

    public JLabel getPos11AdvLabel() {
        return pos11AdvLabel;
    }

    public void setPos11AdvLabel(JLabel pos11AdvLabel) {
        this.pos11AdvLabel = pos11AdvLabel;
    }

    public JLabel getPos11PikachuLabel() {
        return pos11PikachuLabel;
    }

    public void setPos11PikachuLabel(JLabel pos11PikachuLabel) {
        this.pos11PikachuLabel = pos11PikachuLabel;
    }

    public JLabel getPos11PokebolaLabel() {
        return pos11PokebolaLabel;
    }

    public void setPos11PokebolaLabel(JLabel pos11PokebolaLabel) {
        this.pos11PokebolaLabel = pos11PokebolaLabel;
    }

    public JLabel getPos12AdvLabel() {
        return pos12AdvLabel;
    }

    public void setPos12AdvLabel(JLabel pos12AdvLabel) {
        this.pos12AdvLabel = pos12AdvLabel;
    }

    public JLabel getPos12PikachuLabel() {
        return pos12PikachuLabel;
    }

    public void setPos12PikachuLabel(JLabel pos12PikachuLabel) {
        this.pos12PikachuLabel = pos12PikachuLabel;
    }

    public JLabel getPos12PokebolaLabel() {
        return pos12PokebolaLabel;
    }

    public void setPos12PokebolaLabel(JLabel pos12PokebolaLabel) {
        this.pos12PokebolaLabel = pos12PokebolaLabel;
    }

    public JLabel getPos13AdvLabel() {
        return pos13AdvLabel;
    }

    public void setPos13AdvLabel(JLabel pos13AdvLabel) {
        this.pos13AdvLabel = pos13AdvLabel;
    }

    public JLabel getPos13PikachuLabel() {
        return pos13PikachuLabel;
    }

    public void setPos13PikachuLabel(JLabel pos13PikachuLabel) {
        this.pos13PikachuLabel = pos13PikachuLabel;
    }

    public JLabel getPos13PokebolaLabel() {
        return pos13PokebolaLabel;
    }

    public void setPos13PokebolaLabel(JLabel pos13PokebolaLabel) {
        this.pos13PokebolaLabel = pos13PokebolaLabel;
    }

    public JLabel getPos14AdvLabel() {
        return pos14AdvLabel;
    }

    public void setPos14AdvLabel(JLabel pos14AdvLabel) {
        this.pos14AdvLabel = pos14AdvLabel;
    }

    public JLabel getPos14PikachuLabel() {
        return pos14PikachuLabel;
    }

    public void setPos14PikachuLabel(JLabel pos14PikachuLabel) {
        this.pos14PikachuLabel = pos14PikachuLabel;
    }

    public JLabel getPos14PokebolaLabel() {
        return pos14PokebolaLabel;
    }

    public void setPos14PokebolaLabel(JLabel pos14PokebolaLabel) {
        this.pos14PokebolaLabel = pos14PokebolaLabel;
    }

    public JLabel getPos15AdvLabel() {
        return pos15AdvLabel;
    }

    public void setPos15AdvLabel(JLabel pos15AdvLabel) {
        this.pos15AdvLabel = pos15AdvLabel;
    }

    public JLabel getPos15PikachuLabel() {
        return pos15PikachuLabel;
    }

    public void setPos15PikachuLabel(JLabel pos15PikachuLabel) {
        this.pos15PikachuLabel = pos15PikachuLabel;
    }

    public JLabel getPos15PokebolaLabel() {
        return pos15PokebolaLabel;
    }

    public void setPos15PokebolaLabel(JLabel pos15PokebolaLabel) {
        this.pos15PokebolaLabel = pos15PokebolaLabel;
    }

    public JLabel getPos16AdvLabel() {
        return pos16AdvLabel;
    }

    public void setPos16AdvLabel(JLabel pos16AdvLabel) {
        this.pos16AdvLabel = pos16AdvLabel;
    }

    public JLabel getPos16PikachuLabel() {
        return pos16PikachuLabel;
    }

    public void setPos16PikachuLabel(JLabel pos16PikachuLabel) {
        this.pos16PikachuLabel = pos16PikachuLabel;
    }

    public JLabel getPos16PokebolaLabel() {
        return pos16PokebolaLabel;
    }

    public void setPos16PokebolaLabel(JLabel pos16PokebolaLabel) {
        this.pos16PokebolaLabel = pos16PokebolaLabel;
    }

    public JLabel getPos17AdvLabel() {
        return pos17AdvLabel;
    }

    public void setPos17AdvLabel(JLabel pos17AdvLabel) {
        this.pos17AdvLabel = pos17AdvLabel;
    }

    public JLabel getPos17PikachuLabel() {
        return pos17PikachuLabel;
    }

    public void setPos17PikachuLabel(JLabel pos17PikachuLabel) {
        this.pos17PikachuLabel = pos17PikachuLabel;
    }

    public JLabel getPos17PokebolaLabel() {
        return pos17PokebolaLabel;
    }

    public void setPos17PokebolaLabel(JLabel pos17PokebolaLabel) {
        this.pos17PokebolaLabel = pos17PokebolaLabel;
    }

    public JLabel getPos18AdvLabel() {
        return pos18AdvLabel;
    }

    public void setPos18AdvLabel(JLabel pos18AdvLabel) {
        this.pos18AdvLabel = pos18AdvLabel;
    }

    public JLabel getPos18PikachuLabel() {
        return pos18PikachuLabel;
    }

    public void setPos18PikachuLabel(JLabel pos18PikachuLabel) {
        this.pos18PikachuLabel = pos18PikachuLabel;
    }

    public JLabel getPos18PokebolaLabel() {
        return pos18PokebolaLabel;
    }

    public void setPos18PokebolaLabel(JLabel pos18PokebolaLabel) {
        this.pos18PokebolaLabel = pos18PokebolaLabel;
    }

    public JLabel getPos19AdvLabel() {
        return pos19AdvLabel;
    }

    public void setPos19AdvLabel(JLabel pos19AdvLabel) {
        this.pos19AdvLabel = pos19AdvLabel;
    }

    public JLabel getPos19PikachuLabel() {
        return pos19PikachuLabel;
    }

    public void setPos19PikachuLabel(JLabel pos19PikachuLabel) {
        this.pos19PikachuLabel = pos19PikachuLabel;
    }

    public JLabel getPos19PokebolaLabel() {
        return pos19PokebolaLabel;
    }

    public void setPos19PokebolaLabel(JLabel pos19PokebolaLabel) {
        this.pos19PokebolaLabel = pos19PokebolaLabel;
    }

    public JLabel getPos20AdvLabel() {
        return pos20AdvLabel;
    }

    public void setPos20AdvLabel(JLabel pos20AdvLabel) {
        this.pos20AdvLabel = pos20AdvLabel;
    }

    public JLabel getPos20PikachuLabel() {
        return pos20PikachuLabel;
    }

    public void setPos20PikachuLabel(JLabel pos20PikachuLabel) {
        this.pos20PikachuLabel = pos20PikachuLabel;
    }

    public JLabel getPos20PokebolaLabel() {
        return pos20PokebolaLabel;
    }

    public void setPos20PokebolaLabel(JLabel pos20PokebolaLabel) {
        this.pos20PokebolaLabel = pos20PokebolaLabel;
    }

    public JLabel getPos21AdvLabel() {
        return pos21AdvLabel;
    }

    public void setPos21AdvLabel(JLabel pos21AdvLabel) {
        this.pos21AdvLabel = pos21AdvLabel;
    }

    public JLabel getPos21PikachuLabel() {
        return pos21PikachuLabel;
    }

    public void setPos21PikachuLabel(JLabel pos21PikachuLabel) {
        this.pos21PikachuLabel = pos21PikachuLabel;
    }

    public JLabel getPos21PokebolaLabel() {
        return pos21PokebolaLabel;
    }

    public void setPos21PokebolaLabel(JLabel pos21PokebolaLabel) {
        this.pos21PokebolaLabel = pos21PokebolaLabel;
    }

    public JLabel getPos22AdvLabel() {
        return pos22AdvLabel;
    }

    public void setPos22AdvLabel(JLabel pos22AdvLabel) {
        this.pos22AdvLabel = pos22AdvLabel;
    }

    public JLabel getPos22PikachuLabel() {
        return pos22PikachuLabel;
    }

    public void setPos22PikachuLabel(JLabel pos22PikachuLabel) {
        this.pos22PikachuLabel = pos22PikachuLabel;
    }

    public JLabel getPos22PokebolaLabel() {
        return pos22PokebolaLabel;
    }

    public void setPos22PokebolaLabel(JLabel pos22PokebolaLabel) {
        this.pos22PokebolaLabel = pos22PokebolaLabel;
    }

    public JLabel getPos23AdvLabel() {
        return pos23AdvLabel;
    }

    public void setPos23AdvLabel(JLabel pos23AdvLabel) {
        this.pos23AdvLabel = pos23AdvLabel;
    }

    public JLabel getPos23PikachuLabel() {
        return pos23PikachuLabel;
    }

    public void setPos23PikachuLabel(JLabel pos23PikachuLabel) {
        this.pos23PikachuLabel = pos23PikachuLabel;
    }

    public JLabel getPos23PokebolaLabel() {
        return pos23PokebolaLabel;
    }

    public void setPos23PokebolaLabel(JLabel pos23PokebolaLabel) {
        this.pos23PokebolaLabel = pos23PokebolaLabel;
    }

    public JLabel getPos24AdvLabel() {
        return pos24AdvLabel;
    }

    public void setPos24AdvLabel(JLabel pos24AdvLabel) {
        this.pos24AdvLabel = pos24AdvLabel;
    }

    public JLabel getPos24PikachuLabel() {
        return pos24PikachuLabel;
    }

    public void setPos24PikachuLabel(JLabel pos24PikachuLabel) {
        this.pos24PikachuLabel = pos24PikachuLabel;
    }

    public JLabel getPos24PokebolaLabel() {
        return pos24PokebolaLabel;
    }

    public void setPos24PokebolaLabel(JLabel pos24PokebolaLabel) {
        this.pos24PokebolaLabel = pos24PokebolaLabel;
    }

    public JLabel getPos25AdvLabel() {
        return pos25AdvLabel;
    }

    public void setPos25AdvLabel(JLabel pos25AdvLabel) {
        this.pos25AdvLabel = pos25AdvLabel;
    }

    public JLabel getPos25PikachuLabel() {
        return pos25PikachuLabel;
    }

    public void setPos25PikachuLabel(JLabel pos25PikachuLabel) {
        this.pos25PikachuLabel = pos25PikachuLabel;
    }

    public JLabel getPos25PokebolaLabel() {
        return pos25PokebolaLabel;
    }

    public void setPos25PokebolaLabel(JLabel pos25PokebolaLabel) {
        this.pos25PokebolaLabel = pos25PokebolaLabel;
    }

    public JLabel getPos26AdvLabel() {
        return pos26AdvLabel;
    }

    public void setPos26AdvLabel(JLabel pos26AdvLabel) {
        this.pos26AdvLabel = pos26AdvLabel;
    }

    public JLabel getPos26PikachuLabel() {
        return pos26PikachuLabel;
    }

    public void setPos26PikachuLabel(JLabel pos26PikachuLabel) {
        this.pos26PikachuLabel = pos26PikachuLabel;
    }

    public JLabel getPos26PokebolaLabel() {
        return pos26PokebolaLabel;
    }

    public void setPos26PokebolaLabel(JLabel pos26PokebolaLabel) {
        this.pos26PokebolaLabel = pos26PokebolaLabel;
    }

    public JLabel getPos27AdvLabel() {
        return pos27AdvLabel;
    }

    public void setPos27AdvLabel(JLabel pos27AdvLabel) {
        this.pos27AdvLabel = pos27AdvLabel;
    }

    public JLabel getPos27PikachuLabel() {
        return pos27PikachuLabel;
    }

    public void setPos27PikachuLabel(JLabel pos27PikachuLabel) {
        this.pos27PikachuLabel = pos27PikachuLabel;
    }

    public JLabel getPos27PokebolaLabel() {
        return pos27PokebolaLabel;
    }

    public void setPos27PokebolaLabel(JLabel pos27PokebolaLabel) {
        this.pos27PokebolaLabel = pos27PokebolaLabel;
    }

    public JLabel getPos28AdvLabel() {
        return pos28AdvLabel;
    }

    public void setPos28AdvLabel(JLabel pos28AdvLabel) {
        this.pos28AdvLabel = pos28AdvLabel;
    }

    public JLabel getPos28PikachuLabel() {
        return pos28PikachuLabel;
    }

    public void setPos28PikachuLabel(JLabel pos28PikachuLabel) {
        this.pos28PikachuLabel = pos28PikachuLabel;
    }

    public JLabel getPos28PokebolaLabel() {
        return pos28PokebolaLabel;
    }

    public void setPos28PokebolaLabel(JLabel pos28PokebolaLabel) {
        this.pos28PokebolaLabel = pos28PokebolaLabel;
    }

    // endregion
}
