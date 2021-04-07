import java.time.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static String whatIsYourSign (ArrayList<Segno> array, MonthDay bday) {
        String answer ="";
        for (Segno segno : array) {
            answer+=segno.getStart().compareTo(bday)+" "+segno.getEnd().compareTo(bday)+"***";
            if (segno.getStart().compareTo(bday)<=1 && segno.getEnd().compareTo(bday)>=1) {
                answer= "Il tuo segno è "+segno.getNome();
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        ArrayList<Segno> arraySegni = new ArrayList<Segno>();
        arraySegni.add(new Segno(Segno.Segni.SCORPIONE, (MonthDay.of(Month.JANUARY, 01)), MonthDay.of(Month.NOVEMBER, 22)));
        arraySegni.add(new Segno(Segno.Segni.SAGITTARIO, (MonthDay.of(Month.NOVEMBER, 23)), MonthDay.of(Month.DECEMBER, 21)));
        arraySegni.add(new Segno(Segno.Segni.CAPRICORNO, (MonthDay.of(Month.DECEMBER, 22)), MonthDay.of(Month.DECEMBER, 31)));

        /*
        Scanner tastiera = new Scanner(System.in);
        System.out.println("Inserire mese");
        String mese = tastiera.nextLine();
        System.out.println("Inserire giorno");
        int gg = tastiera.nextInt();
         */
        int gg = 26;
        MonthDay yourDate = MonthDay.of(Month.DECEMBER, gg);
        System.out.println(whatIsYourSign(arraySegni, yourDate));









    }

}
