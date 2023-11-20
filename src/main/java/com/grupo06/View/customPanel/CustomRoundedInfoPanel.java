/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.malbarado.views.customPanel;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;

/**
 *
 * @author marcs
 */
public class CustomRoundedInfoPanel extends CustomRoundedPanel {

    public CustomRoundedInfoPanel(int cornerRadius, int shadowSize, int strokeSize) {
        super(cornerRadius, shadowSize, strokeSize);
        setOpaque(false);
        initComponents();
    }

    public CustomRoundedInfoPanel() {
        setOpaque(false);
        initComponents();
    }
    
    
    private void initComponents() {
        info = new CustomButtonInfoPanel();
        add(info, BorderLayout.CENTER);
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {

        info.paintComponent(g);
        Rectangle s = g.getClipBounds();
        
        int minimum = 112;
        int frameProportion = (int) ((double) s.height / 3.0);
        int panelProportion = (int) ((double) getWidth() * (112.0 / 168.0));
        
        int max = Math.max(minimum, Math.max(frameProportion, panelProportion));
        int min = Math.min(minimum, Math.min(frameProportion, panelProportion));
        int mid = minimum + frameProportion + panelProportion - (min + max);

        if (max == minimum) {
            setSize(getWidth(), minimum);
        } else if (min == minimum) {
            setSize(getWidth(), mid);
        } else if (max == frameProportion) {
            setSize(getWidth(), frameProportion);
        } else {
            setSize(getWidth(), minimum);
        }

        revalidate();
        
        super.paintComponent(g);
        
    }
    // Variables declaration
    private CustomButtonInfoPanel info;

    
}
