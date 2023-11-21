/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.malbarado.views.customPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;


public class CustomButtonInfoPanel extends javax.swing.JComponent {
    
    public static final int PROFIT = 0;
    public static final int MONEY = 1;
    public static final int DEBT = 2;
    
    private int state = 0;
    
    private Color color1 = new Color(0, 202, 78);

    public CustomButtonInfoPanel() {
        setOpaque(false);
    }
    
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        switch (this.state) {
            case 0 -> {
                this.color1 = new Color(0, 202, 78);
            }
            case 1 -> {
                this.color1 = new Color(255, 189, 68);
            }
            case 2 -> {
                this.color1 = new Color(255, 96, 92);
            }
            default -> {
                this.color1 = new Color(0, 202, 78);
            }
        }
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        // Set color to red
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(this.color1);
        
        Dimension arcs = new Dimension(getWidth(), getHeight());
        int w = getWidth(), h = getHeight();
               
        // Draw a circle with center (200, 200) and radius 50
        
        
        g2d.fillRoundRect(0,0,
                w-1, h-1, arcs.width, arcs.height);
        
    }
    
}
