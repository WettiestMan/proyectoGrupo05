package com.grupo06.View.customPanel;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class CustomPanel extends JPanel {

    private Color color1;
    private Color color2;
/*
    public CustomPanel(LayoutManager layout, boolean isDoubleBuffered, Color color1, Color color2) {
        super(layout, isDoubleBuffered);
        this.color1 = color1;
        this.color2 = color2;
        setOpaque(true);
    }

    public CustomPanel(LayoutManager layout, Color color1, Color color2) {
        super(layout);
        this.color1 = color1;
        this.color2 = color2;
        setOpaque(true);
    }

    public CustomPanel(boolean isDoubleBuffered, Color color1, Color color2) {
        super(isDoubleBuffered);
        this.color1 = color1;
        this.color2 = color2;
        setOpaque(true);
    }
*/
    public CustomPanel(Color color1, Color color2) {
        this.color1 = color1;
        this.color2 = color2;
        setOpaque(true);
    }
    
    public CustomPanel() {
        this.color1 = new Color(0, 0, 0);
        this.color2 = new Color(0, 0, 0);
        setOpaque(true);
    }
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth(), h = getHeight();

        GradientPaint gp = new GradientPaint(0, h, this.color1,
                w, h, this.color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }
}
