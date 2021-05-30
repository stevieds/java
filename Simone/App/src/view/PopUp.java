package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class PopUp extends JDialog implements ActionListener, GraphicsElements {
    public JPanel data;
    public JPanel top;
    public JPanel buttons;
    public ButtonBig ok;
    public ButtonBig ko;
    public ButtonBig ex;
    public JLabel descr;
    public JPanel centre;
    public JPanel centreContent;

    public PopUp () {
        this.setResizable(false);
        UIManager.put("TextField.border", noBorder);
        UIManager.put("Label.font", berlin);
        UIManager.put("TextField.selectionBackground", darkGray);
        UIManager.put("TextField.selectionForeground", lightGray);

        UIManager.put("ComboBox.buttonBackground", darkGray);
        UIManager.put("ComboBox.buttonHighlight", darkGray);

        UIManager.put("ComboBox.buttonShadow", darkGray);
        UIManager.put("ComboBox.buttonDarkShadow", lightGray);

        UIManager.put("ComboBox.foreground", darkGray);
        UIManager.put("ComboBox.selectionBackground", darkGray);
        UIManager.put("ComboBox.selectionForeground", lightGray);


        UIManager.put("Panel.background", lightGray);

        UIManager.put("CheckBox.background", Color.WHITE);
        UIManager.put("CheckBox.foreground", darkGray);
        UIManager.put("CheckBox.border", darkGray);
        UIManager.put("CheckBox.select", Color.RED);
        UIManager.put("CheckBox.focus",Color.ORANGE); //on focus






        UIManager.put("List.foreground", darkGray);
        UIManager.put("List.selectionBackground", darkGray);
        UIManager.put("List.selectionForeground", lightGray);






/*
        UIManager.put("Spinner.background", Color.MAGENTA );
        UIManager.put("Spinner.editorBorderPainted", test);
        UIManager.put("Spinner.foreground", Color.BLUE);

 */











        this.setLayout(new BorderLayout());
        this.setBackground(lightGray);
        this.getRootPane().setBorder(BorderFactory.createEmptyBorder());

        this.data = new JPanel();
        this.top=new JPanel();
        this.add(this.top, BorderLayout.NORTH);

        this.add(this.data, BorderLayout.CENTER);

        this.buttons = new JPanel();
        this.buttons.setLayout(new FlowLayout());

        this.ok = new ButtonBig(buttonGr);
        ok.addActionListener(this);
        this.buttons.add(this.ok);

        this.ko = new ButtonBig(buttonRed);
        ko.addActionListener(this);
        this.buttons.add(this.ko);

        this.ex = new ButtonBig(darkGray);
        ex.addActionListener(this);
        //this.buttons.add(this.ex);



        this.descr = new JLabel();

        this.add(this.buttons, BorderLayout.SOUTH);

        this.centre = new JPanel();
        this.centreContent = new JPanel();
    }

    public void actionPerformed(ActionEvent e) {}
}
