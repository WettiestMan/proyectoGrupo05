package com.grupo06.View.customPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class CustomRoundedPanel extends JPanel {

    private final int cornerRadius;
    private final int shadowSize;
    private final int strokeSize;

    public CustomRoundedPanel(int cornerRadius, int shadowSize, int strokeSize) {
        this.cornerRadius = cornerRadius;
        this.shadowSize = shadowSize;
        this.strokeSize = strokeSize;
        setOpaque(false);
    }

    public CustomRoundedPanel() {
        this.cornerRadius = 10;
        this.shadowSize = 4;
        this.strokeSize = 7;
        setOpaque(false);

    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Dimension arcs = new Dimension(cornerRadius, cornerRadius);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth(), h = getHeight();

        int modifier = this.shadowSize + this.strokeSize;

        g2d.setColor(new Color(0, 0, 0, 50));
        g2d.fillRoundRect(this.shadowSize, this.shadowSize,
                w - modifier, h - modifier, arcs.width, arcs.height);

        g2d.setColor(Color.WHITE);
        g2d.fillRoundRect(0, 0, w - modifier, h - modifier, arcs.width, arcs.height);
    }

    void setState(int MONEY) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
