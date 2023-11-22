package com.malbarado.views.customButton;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class customButton extends javax.swing.JButton {

    private final int cornerRadius;
    private Color backgrounColor = new Color(255,255,255);

    public customButton(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        setOpaque(false);
    }

    public customButton() {
        this.cornerRadius = 10;
        setOpaque(false);
    }

    public void setBackgrounColor(Color backgrounColor) {
        this.backgrounColor = backgrounColor;
        repaint();
    }
    
    @Override
    protected void paintComponent (Graphics g) {

        Dimension arcs = new Dimension(cornerRadius, cornerRadius);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth(), h = getHeight();

        g2d.setPaint(this.backgrounColor);
        g2d.fillRoundRect(0, 0, w - 1, h - 1, arcs.width, arcs.height);
        
        
        super.paintComponent(g);
        g2d.dispose();
        
    }
}
