/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.grupo06.View;

import com.grupo06.event.EventMenuSelected;
import com.grupo06.forms.Principal;
import javax.swing.JPanel;

/**
 *
 * @author Marcos Alvarado
 */
public class MasterForm extends javax.swing.JPanel {

    /**
     * Creates new form MasterForm
     */
    public MasterForm(String tipo) {
        initComponents();
        
        Principal pr = new Principal();
        pr.setSize(744, 640);
        
        
        this.menu.initMoving(MasterForm.this);
        this.menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                switch (index) {
                    case 2 -> setForm(pr);
                    case 3 -> System.out.println("d");
                    case 4 -> System.out.println("e");
                    case 5 -> System.out.println("f");
                    case 14 -> System.out.println("g");
                    default -> System.out.println("default");
                }
            }
        });
        
    }

    private void setForm(JPanel com) {
        this.container.removeAll();
        this.container.add(com);
        this.container.repaint();
        this.container.revalidate();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        container = new javax.swing.JPanel();
        menu = new com.grupo06.component.Menu();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1024, 620));
        setOpaque(false);
        setLayout(new java.awt.GridBagLayout());

        container.setMaximumSize(new java.awt.Dimension(744, 640));
        container.setMinimumSize(new java.awt.Dimension(744, 640));
        container.setPreferredSize(new java.awt.Dimension(744, 640));

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 744, Short.MAX_VALUE)
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        add(container, gridBagConstraints);

        menu.setMaximumSize(new java.awt.Dimension(280, 640));
        menu.setMinimumSize(new java.awt.Dimension(280, 640));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(menu, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel container;
    private com.grupo06.component.Menu menu;
    // End of variables declaration//GEN-END:variables
}
