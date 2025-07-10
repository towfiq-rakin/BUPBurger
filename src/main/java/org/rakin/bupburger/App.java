package org.rakin.bupburger;

import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;
import org.rakin.bupburger.view.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class App {

    public static JFrame mainFrame = new JFrame(String.valueOf(FlatOneDarkIJTheme.setup()));

    public static void main(String[] args) {

        mainFrame.setTitle("BUP Burger");
        mainFrame.setIconImage(new ImageIcon(Objects.requireNonNull(App.class.getResource("/img/BUPBurgerLogo.png"))).getImage());
        mainFrame.setResizable(false);
        MainPanel mainPanel = new MainPanel();
        mainFrame.setContentPane(mainPanel.panel);
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
