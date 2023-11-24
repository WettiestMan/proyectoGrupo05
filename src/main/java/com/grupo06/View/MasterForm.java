/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.grupo06.View;

import com.grupo06.event.EventMenuSelected;

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
        
        this.menu.initMoving(MasterForm.this);
        this.menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                switch (index) {
                    case 2 -> System.out.println("c");
                    case 3 -> System.out.println("d");
                    case 4 -> System.out.println("e");
                    case 5 -> System.out.println("f");
                    case 14 -> System.out.println("g");
                    default -> System.out.println("default");
                }
            }
        });
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        menu = new com.grupo06.component.Menu();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1024, 620));
        setOpaque(false);
        setLayout(new java.awt.GridBagLayout());

        jPanel1.setMaximumSize(new java.awt.Dimension(744, 640));
        jPanel1.setMinimumSize(new java.awt.Dimension(744, 640));
        jPanel1.setPreferredSize(new java.awt.Dimension(744, 640));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 744, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        add(jPanel1, gridBagConstraints);

        menu.setMaximumSize(new java.awt.Dimension(280, 640));
        menu.setMinimumSize(new java.awt.Dimension(280, 640));
        menu.setPreferredSize(new java.awt.Dimension(280, 640));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(menu, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private com.grupo06.component.Menu menu;
    // End of variables declaration//GEN-END:variables
}
