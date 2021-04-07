package studentmv.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentView extends JFrame implements StudentListener{
    private StudentListener studentListener;
    private JTextField yearText;
    private JTextField letterText;
    private JLabel yearLabel;
    private JLabel letterLabel;
    private  DefaultListModel<String> gradeListModel;

    public StudentView(StudentListener studentListener) {
        super("Student View");

        this.studentListener = studentListener;


        // Create graphic interface
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(500, 500));

        JPanel basePane = new JPanel(new BorderLayout());
        setContentPane(basePane);

        yearLabel = new JLabel("Year...");
        letterLabel = new JLabel("Class-");
        JPanel centerPane = new JPanel();


        JPanel topPane = new JPanel();
        basePane.add(topPane, BorderLayout.NORTH);
        topPane.add(yearLabel);
        topPane.add(letterLabel);


        JPanel dialogPane = new JPanel();

        dialogPane.add(new Label("Year"));
        yearText = new JTextField(10);
        dialogPane.add(yearText);

        dialogPane.add(new Label("Class"));
        letterText = new JTextField(10);
        dialogPane.add(letterText);


        JButton updateButton = new JButton("Update");
        topPane.add(updateButton);

        gradeListModel = new DefaultListModel<>();

        JList <String> gradeList = new JList<>(gradeListModel);
        basePane.add(centerPane);
        centerPane.add(new JScrollPane(gradeList));
        JButton addGrade = new JButton("Add grades");
        centerPane.add(addGrade);
        addGrade.addChangeListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                studentListener.
            }
                                   }
        );


        // register button action
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(basePane, dialogPane);
                studentListener.onUpdateYear(Integer.parseInt(yearText.getText()));
                if (!letterText.getText().isEmpty())
                    studentListener.onUpdateLetter(letterText.getText().charAt(0));
            }
        });


        setVisible(true);
/*
        String [] options = {"A", "B", "C", "D"};


        Object result = JOptionPane.showOptionDialog(
                this,
                "Seleziona opzione",
                "Titolo",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,

                null,
                options,
                options[0]
);
        JOptionPane.showMessageDialog(this, "Opt: " + result);


 */
    }

    @Override
    public void onUpdateYear(int age) {
        yearText.setText(Integer.toString(age));
        yearLabel.setText(Integer.toString(age));
    }

    @Override
    public void onUpdateLetter(char letter) {
        letterText.setText(Character.toString(letter));
    }

    @Override
    public void onUpdateGrades(ArrayList<Integer> grades) {

    }
}
