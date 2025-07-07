package org.rakin.bupburger.view.customer;

import javax.swing.*;
import javax.swing.GroupLayout;

public class ProjectDetails extends JPanel {

    public ProjectDetails() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel = new JPanel();
        label1 = new JLabel();

        //======== panel ========
        {

            //---- label1 ----
            label1.setIcon(new ImageIcon(getClass().getResource("/img/logo-3.png")));

            GroupLayout panelLayout = new GroupLayout(panel);
            panel.setLayout(panelLayout);
            panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup()
                    .addComponent(label1, GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
            );
            panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup()
                    .addComponent(label1, GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public JPanel panel;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
