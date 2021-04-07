package mv;

import java.util.ArrayList;

public interface StudentListener {

    void onUpdateYear(int age);
    void onUpdateLetter(char letter);
    void onUpdateGrades(ArrayList<Integer> grades);

}
