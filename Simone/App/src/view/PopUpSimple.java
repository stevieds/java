package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopUpSimple extends JFrame implements ActionListener, GraphicsElements {
    ButtonBig btn;
    JLabel text;
    JPanel top;
    JPanel bottom;

    public PopUpSimple(String label) {
        this.setSize(260, 140);

        this.setLayout(new BorderLayout());
        this.top = new JPanel(new FlowLayout());
        this.bottom = new JPanel(new FlowLayout());

        text = new JLabel(label);
        text.setFont(simple);
        text.setForeground(darkGray);
        this.setBackground(lightGray);

        top.add(text);

        this.btn=new ButtonBig(buttonGr);
        this.btn.setText("OK");
        this.btn.setActionCommand("OK");
        this.btn.addActionListener(this);
        bottom.add(btn);

        this.add(top, BorderLayout.CENTER);
        this.add(bottom, BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("OK")) {
            this.dispose();
        }

    }
}
