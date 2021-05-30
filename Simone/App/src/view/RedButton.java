package view;

import javax.swing.*;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public class RedButton extends JButton implements GraphicsElements {

    public RedButton (String s) {
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setBackground(buttonRed);

        this.setFont(peignot);
        this.setForeground(lightGray);

        this.setUI(new ButtonUI() {
        });

        UIManager.put("Button.select", midGray);

        UIManager.put("Button.darkShadow", Color.GREEN);

        UIManager.put("Button.highlight", Color.BLUE);

        UIManager.put("Button.shadow", Color.YELLOW);


        UIManager.put("Button.light", Color.MAGENTA);

        this.setText(s);
/*



        Button.disabledText
        Button.focusInputMap
        Button.font
        Button.foreground


        Button.margin
        Button.opaque
        Button.select


 */

    }
}
