package ui;

import agent.PokemonAgent;
import utilities.Utilities;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PokemonUI extends JFrame {


    private JPanel panel1;
    private JLabel backgroundLabel, labelVictoria, labelDerrota;
    private List<JLabel> labelsAdv;
    private List<JLabel> labelsPokebolas;
    private List<JLabel> labelsPikachu;
    private JLayeredPane layeredPane;

    public PokemonUI() {

        layeredPane = getLayeredPane();

        // Label background
        ImageIcon background = createImageIcon("mapa.png", "");
        backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
        layeredPane.add(backgroundLabel, Integer.valueOf(0));

        List<Integer> dimX = new ArrayList<>();
        List<Integer> dimY = new ArrayList<>();
        // Posicion (x,y)
        // region
        // Posicion 0
        dimX.add(124); dimY.add(173);
        // Posicion 1
        dimX.add(218); dimY.add(241);
        // Posicion 2
        dimX.add(186); dimY.add(309);
        // Posicion 3
        dimX.add(269); dimY.add(429);
        // Posicion 4
        dimX.add(280); dimY.add(556);
        // Posicion 5
        dimX.add(320); dimY.add(494);
        // Posicion 6
        dimX.add(346); dimY.add(440);
        // Posicion 7
        dimX.add(282); dimY.add(312);
        // Posicion 8
        dimX.add(435); dimY.add(311);
        // Posicion 9
        dimX.add(316); dimY.add(195);
        // Posicion 10
        dimX.add(398); dimY.add(88);
        // Posicion 11
        dimX.add(519); dimY.add(194);
        // Posicion 12
        dimX.add(521); dimY.add(323);
        // Posicion 13
        dimX.add(585); dimY.add(90);
        // Posicion 14
        dimX.add(604); dimY.add(143);
        // Posicion 15
        dimX.add(644); dimY.add(298);
        // Posicion 16
        dimX.add(644); dimY.add(493);
        // Posicion 17
        dimX.add(744); dimY.add(124);
        // Posicion 18
        dimX.add(739); dimY.add(280);
        // Posicion 19
        dimX.add(898); dimY.add(103);
        // Posicion 20
        dimX.add(859); dimY.add(272);
        //  Posicion 21
        dimX.add(849); dimY.add(493);
        // Posicion 22
        dimX.add(957); dimY.add(169);
        // Posicion 23
        dimX.add(955); dimY.add(406);
        // Posicion 24
        dimX.add(1074); dimY.add(87);
        // Posicion 25
        dimX.add(1056); dimY.add(230);
        // Posicion 26
        dimX.add(1054); dimY.add(405);
        // Posicion 27
        dimX.add(1039); dimY.add(483);
        // Posicion 28
        dimX.add(1166); dimY.add(555);
        // endregion

        labelsAdv = new ArrayList<>();
        labelsPikachu = new ArrayList<>();
        labelsPokebolas = new ArrayList<>();
        JLabel adv, pikachu, pokebola;

        for (int i = 0; i < Utilities.CANT_LUGARES; i++) {
            // Adversario
            adv = new JLabel(new ImageIcon(getScaledImage(createImageIcon("adversario.png", "").getImage(), 50, 50)));
            adv.setBounds(dimX.get(i), dimY.get(i), 50, 50);
            labelsAdv.add(adv);
            layeredPane.add(adv, Integer.valueOf(1));
            // Pikachu
            pikachu = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pikachu.png", "").getImage(), 60, 60)));
            pikachu.setBounds(dimX.get(i), dimY.get(i), 60, 60);
            labelsPikachu.add(pikachu);
            layeredPane.add(pikachu, Integer.valueOf(2));
            // Pokebola
            pokebola = new JLabel(new ImageIcon(getScaledImage(createImageIcon("pokebola.png", "").getImage(), 50, 50)));
            pokebola.setBounds(dimX.get(i), dimY.get(i), 50, 50);
            labelsPokebolas.add(pokebola);
            layeredPane.add(pokebola, Integer.valueOf(1));
        }


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

        for (int i = 0; i < Utilities.CANT_LUGARES; i++) {
            labelsPokebolas.get(i).setVisible(false);
            labelsPikachu.get(i).setVisible(false);
            labelsAdv.get(i).setVisible(false);
        }

        // Label victoria y derrota
        labelVictoria.setVisible(false);
        labelDerrota.setVisible(false);
    }

    public void setAdvVisible(int i){
        labelsAdv.get(i).setVisible(true);
    }

    public void setPokebolaVisible(int i){
        labelsPokebolas.get(i).setVisible(true);
    }

    public void setPikachuVisible(int i){
        labelsPikachu.get(i).setVisible(true);
    }


    public static void main(String[] args) {
        PokemonUI ui = new PokemonUI();
        //ui.setAllNoVisible();
    }

    // Getters y setters
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


}
