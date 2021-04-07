import studentmv.model.Student;
import studentmv.view.StudentView;

import java.awt.*;
public class Main {

    public static void main(String[] args) {
        Student student = new Student(0, "Cricket Dee", 1, 'A');
        StudentView studentView = new StudentView(student);
        student.setViewListener(studentView);



    }
}
