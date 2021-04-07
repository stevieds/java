package mv.view;

import mv.StudentListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentView extends JFrame implements StudentListener {

    private StudentListener studentListener;

    private JTextField yearText;
    private JTextField letterText;

    public StudentView(StudentListener studentListener) {
        super("Student View");

        this.studentListener = studentListener;


        // Create graphic interface
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(500, 500));

        JPanel basePane = new JPanel(new BorderLayout());
        setContentPane(basePane);


        JPanel topPane = new JPanel();
        basePane.add(topPane, BorderLayout.NORTH);

        topPane.add(new Label("Year"));
        yearText = new JTextField(10);
        topPane.add(yearText);

        topPane.add(new Label("Class"));
        letterText = new JTextField(10);
        topPane.add(letterText);

        JButton updateButton = new JButton("Update");
        topPane.add(updateButton);

        // register button action
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentListener.onUpdateYear(Integer.parseInt(yearText.getText()));
                if (!letterText.getText().isEmpty())
                    studentListener.onUpdateLetter(letterText.getText().charAt(0));
            }
        });



        setVisible(true);
    }

    @Override
    public void onUpdateYear(int age) {
        yearText.setText(Integer.toString(age));
    }

    @Override
    public void onUpdateLetter(char letter) {
        letterText.setText(Character.toString(letter));
    }

    @Override
    public void onUpdateGrades(ArrayList<Integer> grades) {

    }
}
