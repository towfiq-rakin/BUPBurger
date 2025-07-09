package org.rakin.bupburger.view.customer;

import com.formdev.flatlaf.ui.FlatTableCellBorder;
import org.rakin.bupburger.dao.FoodDao;
import org.rakin.bupburger.domain.Food;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;

import static org.rakin.bupburger.view.customer.PaymentPanel.TOTAL_COST;
import static org.rakin.bupburger.view.customer.PaymentPanel.TOTAL_FOOD_NUMBER;

public class CartPanel {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
    FoodDao foodDAO = applicationContext.getBean("foodDao", FoodDao.class);

    Food selectedFood = null;
    List<Integer> allFoodsId = BrowseFoodsPanel.selectedFoodId;
    List<Food> allFoods = new ArrayList<>();
    Object[][] data;

    // Initialize static labels first
    public static JLabel TOTAL_FOODS_LABEL = new JLabel("00");
    public static JLabel TOTAL_COST_LABEL = new JLabel("00");

    void loadAllFoods() {
        for(int i = 0; i < allFoodsId.size(); i++) {
            Food food = foodDAO.searchById(allFoodsId.get(i));
            if(food != null) {
                allFoods.add(food);
            } else {
                System.out.println("Food with ID " + allFoodsId.get(i) + " not found.");
            }
        }
    }

    void loadDataset() {
        if(allFoods == null) {
            System.out.println("All foods list is null, initializing with an empty list.");
            return;
        }
        data = new Object[allFoods.size()][3];
        for (int i = 0; i < allFoods.size(); i++) {
            data[i][0] = allFoods.get(i).getCategory();
            data[i][1] = allFoods.get(i).getTitle();
            data[i][2] = allFoods.get(i).getPrice();
            foodTabale.setModel(new javax.swing.table.DefaultTableModel(
                data, new String[]{"Category", "Title", "Price"}
            ));
        }
    }

    public CartPanel() {
        initComponents();
        loadAllFoods();
        loadDataset();
        TOTAL_FOODS_LABEL.setText(String.valueOf(TOTAL_FOOD_NUMBER));
        TOTAL_COST_LABEL.setText(String.valueOf(TOTAL_COST));
    }

    private void Remove(ActionEvent e) {
        try{
            allFoods.remove(selectedFood);
            TOTAL_FOOD_NUMBER--;
            TOTAL_COST -= selectedFood.getPrice();
            TOTAL_FOODS_LABEL.setText(String.valueOf(TOTAL_FOOD_NUMBER));
            TOTAL_COST_LABEL.setText(String.valueOf(TOTAL_COST));
            loadDataset();
        }
        catch (Exception ignored){ }
    }

    private void scrollPane1MouseClicked(MouseEvent e) {
        DefaultTableModel tableModel = (DefaultTableModel) foodTabale.getModel();
        int selectedIndex = foodTabale.getSelectedRow();
        //int foodID = (int) tableModel.getValueAt(selectedIndex, 0);
        String category = (String) tableModel.getValueAt(selectedIndex, 0);
        String title = (String) tableModel.getValueAt(selectedIndex, 1);
        selectedFood = foodDAO.getFoodDetails(category, title);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel = new JPanel();
        label6 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        scrollPane1 = new JScrollPane();
        foodTabale = new JTable();
        RemoveButton = new JButton();

        //======== panel ========
        {
            panel.setBackground(Color.black);

            //---- label6 ----
            label6.setText("Food Cart");
            label6.setFont(new Font("Segoe UI", Font.BOLD, 30));
            label6.setHorizontalAlignment(SwingConstants.CENTER);

            //---- label2 ----
            label2.setText("Added Foods :");
            label2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));

            //---- TOTAL_FOODS_LABEL ----
            TOTAL_FOODS_LABEL.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));

            //---- label3 ----
            label3.setText("Total Cost :");
            label3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));

            //---- TOTAL_COST_LABEL ----
            TOTAL_COST_LABEL.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));

            //======== scrollPane1 ========
            {
                scrollPane1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        scrollPane1MouseClicked(e);
                    }
                });
                scrollPane1.setViewportView(foodTabale);
            }

            //---- RemoveButton ----
            RemoveButton.setText("Remove");
            RemoveButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
            RemoveButton.addActionListener(e -> Remove(e));

            GroupLayout panelLayout = new GroupLayout(panel);
            panel.setLayout(panelLayout);
            panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup()
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label6, GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(panelLayout.createParallelGroup()
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(label2)
                                .addGap(18, 18, 18)
                                .addComponent(TOTAL_FOODS_LABEL)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                                .addComponent(label3)
                                .addGap(18, 18, 18)
                                .addComponent(TOTAL_COST_LABEL)
                                .addGap(63, 63, 63)))
                        .addGap(94, 94, 94))
                    .addGroup(GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addContainerGap(315, Short.MAX_VALUE)
                        .addComponent(RemoveButton, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                        .addGap(312, 312, 312))
            );
            panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup()
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label6)
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label2)
                            .addComponent(TOTAL_FOODS_LABEL)
                            .addComponent(label3)
                            .addComponent(TOTAL_COST_LABEL, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(RemoveButton, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(43, Short.MAX_VALUE))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public JPanel panel;
    private JLabel label6;
    private JLabel label2;
    private JLabel label3;
    private JScrollPane scrollPane1;
    private JTable foodTabale;
    private JButton RemoveButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
