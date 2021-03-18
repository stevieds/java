import javax.swing.*;
import java.awt.*;


public class Main {

    public static void main(String[] args) {
        /*
        //Una nuova finestra con My first GUI sulla barra dei comandi
        JFrame frame = new JFrame("My first GUI");
        // Come si comporta la finestra quando clicco su chiudi
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Dimensioni della finestra
        frame.setSize(300, 300);
        // Creo due bottoni
        JButton button1 = new JButton("Push");
        JButton button2 = new JButton("Release");

        // Creo un nuovo panel
        JPanel panel = new JPanel();

        // Imposto il layout per il panel, tipo BoxLayout e allineamento asse Y
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Aggiungi il panel alla sezione ContentPane del frame
        frame.setContentPane(panel);

        // Aggiungo i pulsanti al panel
        panel.add(button1);
        panel.add(button2);

        frame.setVisible(true);

         */





        JFrame frame2 = new JFrame("My first GUI");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(500, 500);
        JMenuBar mBar = new JMenuBar();
        JMenu file, modifica, sub;
        file = new JMenu("File");
        modifica = new JMenu("Modifica");
        sub = new JMenu("Sub");
        JMenuItem nuovo = new JMenuItem("Nuovo");
        JMenuItem impostazioni = new JMenuItem("Impostazioni");
        JMenuItem esci = new JMenuItem("Esci");
        JRadioButtonMenuItem radio = new JRadioButtonMenuItem ("Un radio button");
        JCheckBox check = new JCheckBox ("Check me");
        JRadioButtonMenuItem radio2 = new JRadioButtonMenuItem ("Un radio button");
        JCheckBox check2 = new JCheckBox ("Check me");

        ButtonGroup gr = new ButtonGroup();
        gr.add(radio);
        gr.add(radio2);

        JMenuItem sub1 = new JMenuItem("Altro");
        JMenuItem sub2 = new JMenuItem("Altro ancora");
        JMenuItem sub3 = new JMenuItem("Non so");

        sub.add(sub1);
        sub.add(sub2);
        sub.add(sub3);

        ImageIcon icon = new ImageIcon("i.gif", "text");
        JMenuItem ic1 = new JMenuItem("Icona", icon);
        JMenuItem ic2 = new JMenuItem("Altro ancora", icon);





        file.add(nuovo);
        file.add(impostazioni);
        file.addSeparator();
        file.add(ic1);
        file.add(ic2);


        file.addSeparator();
        file.add(radio);
        file.add(radio2);
        file.add(check2);
        file.add(check);
        file.addSeparator();
        file.add(sub);
        file.add(esci);



        JMenuItem ritaglia = new JMenuItem("Ritaglia");
        JMenuItem selezione = new JMenuItem("Selezione");
        modifica.add(ritaglia);
        modifica.add(selezione);
        mBar.add(file);
        mBar.add(modifica);
        frame2.setJMenuBar(mBar);


        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());


        // Centrale
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2, 2));
        JButton button1 = new JButton ("1");
        JButton button2 = new JButton ("2");
        JButton button3 = new JButton ("3");
        JButton button4 = new JButton ("4");
        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);
        panel1.add(button4);


        // Footer
        JPanel footer = new JPanel();
        footer.setLayout(new BoxLayout(footer, BoxLayout.X_AXIS));


        JPanel footer1 = new JPanel();
        footer1.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel footerLabel = new JLabel("Modifica in corso...");
        footer1.add(footerLabel);

        JPanel footer2 = new JPanel();
        footer2.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JButton buttonEsci = new JButton ("Esci");
        footer2.add(buttonEsci);

        footer.add(footer1);
        footer.add(footer2);



        main.add(panel1, BorderLayout.CENTER);
        main.add(footer, BorderLayout.SOUTH);


        frame2.setContentPane(main);



        frame2.setVisible(true);


    }



}
