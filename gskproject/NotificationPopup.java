/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gskproject;

/**
 *
 * @author sumi
 */
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LinearGradientPaint;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
//import static simz1.LoginFrame1.mhp;

public class NotificationPopup extends JDialog {

    private final LinearGradientPaint lpg;
    public JButton btnmoreDetails;

    public NotificationPopup() {
        setUndecorated(true);
        setSize(300, 100);

        // size of the screen
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // height of the task bar
        final Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(
                getGraphicsConfiguration());
        final int taskBarSize = scnMax.bottom;

        setLocation(screenSize.width - getWidth(), screenSize.height - taskBarSize
                - getHeight());

        // background paint
        lpg = new LinearGradientPaint(0, 0, 0, getHeight() / 2, new float[]{0f,
            0.3f, 1f}, new Color[]{new Color(0.8f, 0.8f, 1f),
            new Color(0.7f, 0.7f, 1f), new Color(0.6f, 0.6f, 1f)});

        // blue background panel
        setContentPane(new BackgroundPanel());
    }

    private class BackgroundPanel extends JPanel {

        public BackgroundPanel() {
            setOpaque(true);
        }

        @Override
        protected void paintComponent(final Graphics g) {
            final Graphics2D g2d = (Graphics2D) g;
            // background
            g2d.setPaint(lpg);
            g2d.fillRect(1, 1, getWidth() - 2, getHeight() - 2);
            g2d.setColor(Color.BLACK);

            // border
            g2d.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        }
    }

    public void popupMessage(String message) {
        final NotificationPopup f = new NotificationPopup();
        final String msg = message;//need to give the  message

        /*MouseListener mouseListener = new MouseAdapter() {

         public void mouseClicked(MouseEvent e) {
         Notification n = new Notification();
         n.setVisible(true);
         }

         };*/
        btnmoreDetails = new JButton();
        btnmoreDetails.setText("Click here to view alerts");
        btnmoreDetails.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                RelatedCases cases = new RelatedCases();
                cases.setVisible(true);
            }
        });
        //btnmoreDetails.addMouseListener(mouseListener);
        //NotificationPopup.add(btnmoreDetails);
        //moreDetails.setVisible(true);
        /*btnmoreDetails = new JButton(new AbstractAction("Click here to view alerts") {

         @Override
         public void actionPerformed(final ActionEvent e) {
         //Notification notification = new Notification();
         //notification.setVisible(true);
         //mhp.jTabbedPane1.setSelectedIndex(4);
         }
         });*/

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (final Exception e1) {
                    e1.printStackTrace();
                }

                //final NotificationPopup f = new NotificationPopup();
                final Container c = f.getContentPane();
                c.setLayout(new GridBagLayout());

                final GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx = 0;
                constraints.gridy = 0;
                constraints.weightx = 1.0f;
                constraints.weighty = 1.0f;
                constraints.insets = new Insets(5, 5, 5, 5);
                constraints.fill = GridBagConstraints.BOTH;

                final JLabel l = new JLabel(msg);
                l.setOpaque(false);
                l.setFont(new Font("Serif", Font.PLAIN, 14));

                c.add(l, constraints);

                constraints.gridx++;
                constraints.weightx = 0f;
                constraints.weighty = 0f;
                constraints.fill = GridBagConstraints.NONE;
                constraints.anchor = GridBagConstraints.NORTH;

                final JButton b = new JButton(new AbstractAction("x") {

                    @Override
                    public void actionPerformed(final ActionEvent e) {
                        f.dispose();
                    }
                });

                b.setOpaque(false);
                b.setMargin(new Insets(1, 4, 1, 4));
                b.setFocusable(false);

                c.add(b, constraints);
                //adding another button to view the alerts....
                constraints.gridx = 0;
                constraints.weightx = 1.0f;
                constraints.weighty = 1.0f;
                constraints.fill = GridBagConstraints.NONE;
                constraints.anchor = GridBagConstraints.SOUTHWEST;

                btnmoreDetails.setOpaque(true);
                btnmoreDetails.setFocusable(false);
                c.add(btnmoreDetails, constraints);
                //adding button finished................
                f.setVisible(true);
            }
        });

        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(15000); // time after which pop up will be disappeared.
                    f.dispose();//f is from method i written in 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        ;
    }


.start();
        
    }
}
