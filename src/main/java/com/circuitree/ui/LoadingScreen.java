package com.circuitree.ui;

import javax.swing.*;
import java.awt.*;

public class LoadingScreen {
    private final JWindow window;

    public LoadingScreen() {
        window = new JWindow();

        JPanel panel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(13, 17, 23));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 16, 16);
                g2.dispose();
            }
        };
        panel.setOpaque(false);
        panel.setPreferredSize(new Dimension(260, 90));

        JLabel label = new JLabel("Loading...");
        label.setForeground(new Color(139, 148, 158));
        label.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        panel.add(label);

        window.setContentPane(panel);
        window.setBackground(new Color(0, 0, 0, 0));
        window.pack();
        window.setLocationRelativeTo(null);
        window.setAlwaysOnTop(true);
        window.setVisible(true);
    }

    public void close() {
        window.dispose();
    }
}
