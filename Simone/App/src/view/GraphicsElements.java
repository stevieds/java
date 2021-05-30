package view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public interface GraphicsElements {
    Font berlin  = new Font("Berlin Sans FB", Font.PLAIN,  14);
    Font peignot  = new Font("Peignot", Font.PLAIN,  20);
    Font peignotSmall  = new Font("Peignot", Font.PLAIN,  16);
    Font peignotMedium  = new Font("Peignot", Font.PLAIN,  19);
    Font peignotBig  = new Font("Peignot", Font.PLAIN,  23);
    Font peignotL  = new Font("Peignot", Font.PLAIN,  33);
    Font simple = new Font(Font.SANS_SERIF, Font.PLAIN, 12);
    Color lightGray = new Color(230, 230, 230);
    Color darkGray = new Color(64, 64, 64);
    Color midGray = new Color(166, 166, 166);
    Border noBorder =  BorderFactory.createEmptyBorder(5,0,5,0);

    Border b = BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0,0,0,0),
            BorderFactory.createLineBorder(lightGray));

    Color buttonRed = new Color(255, 51, 51);
    Color buttonGr = new Color(0, 102, 0);

    Color colorNew = new Color(255, 51, 153);
    Color colorWip = new Color(102, 153, 0);
    Color colorDone = new Color(0, 102, 255);

    Border test = BorderFactory.createLineBorder(Color.RED);


    public class SpinnerN extends JSpinner {
        public SpinnerN(SpinnerModel model) {
            this.setModel(model);
            this.setBorder(BorderFactory.createLineBorder(midGray));
            this.setForeground(darkGray);
        }
    }

    public class SpinnerD extends JSpinner {
        public SpinnerD(SpinnerModel model) {
            this.setModel(model);
            this.setBorder(BorderFactory.createLineBorder(midGray));
            this.setForeground(darkGray);

        }
    }

    public class ButtonBig extends JButton {
        public ButtonBig (Color c) {
            UIManager.put("Button.select", midGray);
            this.setBackground(c);
            this.setForeground(lightGray);
            this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            this.setFont(peignot);
            this.setPreferredSize(new Dimension(75, 30));
        }
    }

    public class TField extends JTextField {
        public TField () {
            this.setBackground(lightGray);
            this.setDisabledTextColor(darkGray);
            this.setBorder(BorderFactory.createLineBorder(midGray));
        }

        public TField (String t) {
            this.setBackground(lightGray);
            this.setDisabledTextColor(darkGray);
            this.setBorder(BorderFactory.createLineBorder(midGray));
            this.setText(t);
        }
    }

    public class ButtonSmall extends JButton {
        public ButtonSmall () {

            this.setForeground(Color.WHITE);
            UIManager.put("Button.select", midGray);
            UIManager.put("Button.disabledText", darkGray);
            this.setFont(berlin);
            this.setBorder(BorderFactory.createLineBorder(midGray));





        }

    }









}

