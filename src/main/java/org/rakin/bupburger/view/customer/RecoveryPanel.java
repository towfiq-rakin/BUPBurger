package org.rakin.bupburger.view.customer;

import org.rakin.bupburger.dao.UserDao;
import org.rakin.bupburger.domain.User;
import org.rakin.bupburger.util.EmailService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

import static org.rakin.bupburger.view.DialogueBox.dialogueBox;
import static org.rakin.bupburger.view.LoginPanel.recoveryFrame;

public class RecoveryPanel extends JPanel {
    User user = null;
    String OTP = null;
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
    UserDao userDao = applicationContext.getBean("userDao", UserDao.class);

    public RecoveryPanel() {
        initComponents();
    }

    private void close(ActionEvent e) {
        recoveryFrame.dispatchEvent(new WindowEvent(recoveryFrame, WindowEvent.WINDOW_CLOSING));
    }

    private void recoverButton(ActionEvent e) {

        String userOTP = otpTF.getText().trim();

        if(emailTF.getText().isEmpty()) {
            dialogueBox("Please enter your email address.");
            return;
        }

        if(userOTP != null && !userOTP.equals(OTP)) {
            dialogueBox("Invalid OTP! Please try again.");
            return;
        }

        if(userOTP != null && userOTP.equals(OTP)){
            usernameLabel.setText(user.getUsername());
            passwordLabel.setText(user.getPass());
            dialogueBox("Your account has been successfully recovered.");
        }


    }
    
    private void emailTFKeyPressed(KeyEvent e) {
        // TODO add your code here
    }

    private void emailTFKeyTyped(KeyEvent e) {
        // TODO add your code here
    }

    private void getOTP(ActionEvent e) {
        if(emailTF.getText().isEmpty()) {
            dialogueBox("Please enter your email address.");
            return;
        }

        user = userDao.getByEmail(emailTF.getText());

        if (user == null) {
            dialogueBox("User not found!");
            return;
        }

        dialogueBox("OTP has been sent to your email address.");
        OTP = EmailService.sendVerificationCode(user.getEmail());
    }

    private void emailTFKeyReleased(KeyEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel = new JPanel();
        recoverButton = new JButton();
        emailTF = new JTextField();
        label2 = new JLabel();
        label1 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        usernameLabel = new JLabel();
        passwordLabel = new JLabel();
        closeButton = new JButton();
        otpTF = new JTextField();
        label5 = new JLabel();
        otpButton = new JButton();

        //======== panel ========
        {
            panel.setBackground(Color.black);

            //---- recoverButton ----
            recoverButton.setText("Recover");
            recoverButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
            recoverButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            recoverButton.addActionListener(e -> recoverButton(e));

            //---- emailTF ----
            emailTF.setFont(new Font("Segoe UI", Font.PLAIN, 20));
            emailTF.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    emailTFKeyPressed(e);
                }
                @Override
                public void keyReleased(KeyEvent e) {
                    emailTFKeyReleased(e);
                }
                @Override
                public void keyTyped(KeyEvent e) {
                    emailTFKeyTyped(e);
                }
            });

            //---- label2 ----
            label2.setText(" EMAIL");
            label2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));

            //---- label1 ----
            label1.setText("Account Recovery");
            label1.setFont(new Font("Segoe UI", Font.BOLD, 45));

            //---- label3 ----
            label3.setText("Username :");
            label3.setFont(new Font("Segoe UI Semibold", Font.BOLD, 22));

            //---- label4 ----
            label4.setText("Password  :");
            label4.setFont(new Font("Segoe UI Semibold", Font.BOLD, 22));

            //---- usernameLabel ----
            usernameLabel.setText("...");
            usernameLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 22));
            usernameLabel.setForeground(new Color(0x009933));

            //---- passwordLabel ----
            passwordLabel.setText("...");
            passwordLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 22));
            passwordLabel.setForeground(new Color(0x009933));

            //---- closeButton ----
            closeButton.setText("Close");
            closeButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
            closeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            closeButton.addActionListener(e -> close(e));

            //---- label5 ----
            label5.setText("OTP");
            label5.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));

            //---- otpButton ----
            otpButton.setText("Get OTP");
            otpButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
            otpButton.addActionListener(e -> getOTP(e));

            GroupLayout panelLayout = new GroupLayout(panel);
            panel.setLayout(panelLayout);
            panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label1)
                        .addGap(71, 71, 71))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(panelLayout.createParallelGroup()
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup()
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(label2))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(emailTF, GroupLayout.Alignment.LEADING)
                                    .addGroup(GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                                        .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(closeButton, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                                            .addGroup(panelLayout.createParallelGroup()
                                                .addGroup(panelLayout.createSequentialGroup()
                                                    .addComponent(label3)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(usernameLabel))
                                                .addGroup(panelLayout.createSequentialGroup()
                                                    .addComponent(label4)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(passwordLabel)))
                                            .addComponent(otpTF))
                                        .addGap(37, 37, 37)
                                        .addGroup(panelLayout.createParallelGroup()
                                            .addComponent(recoverButton, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(otpButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(107, 107, 107))))
            );
            panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup()
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(label1)
                        .addGap(18, 18, 18)
                        .addComponent(label2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailTF, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label5)
                        .addGap(5, 5, 5)
                        .addGroup(panelLayout.createParallelGroup()
                            .addComponent(otpButton, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                            .addComponent(otpTF, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label3)
                            .addComponent(usernameLabel))
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4)
                            .addComponent(passwordLabel))
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(closeButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(recoverButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public JPanel panel;
    private JButton recoverButton;
    private JTextField emailTF;
    private JLabel label2;
    private JLabel label1;
    private JLabel label3;
    private JLabel label4;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JButton closeButton;
    private JTextField otpTF;
    private JLabel label5;
    private JButton otpButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
