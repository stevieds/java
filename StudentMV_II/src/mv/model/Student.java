package mv.model;

import mv.StudentListener;

import java.util.ArrayList;

public class Student implements StudentListener {

    private int code;
    private String fullname;

    private int year;
    private char letter;

    private StudentListener listener;

    private ArrayList<Integer> grades;

    public Student(int code, String fullname, int year, char letter) {
        this.code = code;
        this.fullname = fullname;
        this.year = year;
        this.letter = letter;
    }

    public void setViewListener(StudentListener listener){
        this.listener = listener;
    }

    @Override
    public void onUpdateYear(int year) {
        this.year = year;

        if(listener != null)
            listener.onUpdateYear(this.year);
    }

    @Override
    public void onUpdateLetter(char letter) {
        this.letter = letter;

        if(listener != null)
            listener.onUpdateLetter(this.letter);
    }

    @Override
    public void onUpdateGrades(ArrayList<Integer> grades) {

    }
}
