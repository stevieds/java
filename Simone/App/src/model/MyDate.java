package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyDate {
    private SimpleDateFormat sdf;
    private Date date;

        public MyDate (Date date) {
            this.sdf = new SimpleDateFormat("yyyy/MM/dd");
            this.date = date;
        }


    public MyDate (String dateString) {
        this.sdf = new SimpleDateFormat("yyyy/MM/dd");
        try
        {
            this.date = sdf.parse(dateString);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean compare (MyDate date2) {
        Calendar dateA = Calendar.getInstance();
        Calendar dateB = Calendar.getInstance();
        dateA.setTime(date);
        dateB.setTime(date2.getDate());
        dateA.get(Calendar.DATE);
        return dateA.get(Calendar.DAY_OF_MONTH) == dateB.get(Calendar.DAY_OF_MONTH) &&
                dateA.get(Calendar.MONTH) == dateB.get(Calendar.MONTH) &&
                dateA.get(Calendar.YEAR) == dateB.get(Calendar.YEAR);




    }

    @Override
    public String toString() {
        return this.sdf.format(this.date);
    }
}
