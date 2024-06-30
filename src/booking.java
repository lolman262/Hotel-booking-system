import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class booking {
    private String name;
    private String IC;
    private String phone;
    private String email;
    private String roomid;
    private String Date;
    private String duration;
    public booking(String Name, String ic, String Phone, String Email, String RoomID, String date, String Duration) {
        name = Name;
        IC = ic;
        phone = Phone ;
        email = Email;
        roomid = RoomID;
        Date = date;
        duration = Duration;


    };
    public String getName() {return name;};
    public String getIC() {return IC;};
    public String getPhone() {return phone;};
    public String getEmail() {return email;};
    public String getRoomID() {return roomid;};
    public String getDate() {return Date;};
    public String getduration() {return duration;};

    //get array is used for searching in the manage booking ui
    public ArrayList<String> getArray() {
        ArrayList<String> Details = new ArrayList<>();
        Details.add(name);
        Details.add(IC);
        Details.add(phone);
        Details.add(email);
        Details.add(roomid);
        Details.add(Date);
        Details.add(duration);
        return Details;
    }
    public void setDate(String Date) {

        this.Date = Date;
    }

    public void setName(String Name) {

        this.name = Name;
    }

    public void setEmail(String Email) {

        this.email = Email;
    }

    public void setIC(String IC) {

        this.IC = IC;
    }
    public void setDuration(String Duration) {

        this.duration = Duration;
    }
    public void setPhone(String phone) {

        this.phone = phone;
    }
    public void setRoomID(String Roomid) {

        this.roomid = Roomid;
    }

    @Override
    public String toString(){
        return name + " // " + IC + " // " + phone + " // " + email + " // " + roomid + " // " + Date + " // " + duration;
    }




    //Check date is used to compare two starting and ending dates to see if they conflict
    public static String CheckDate(java.util.Date dateBefore, Date dateAfter, Date comDateBf, int Duration)
    {
        SimpleDateFormat dcn = new SimpleDateFormat ("yyyy-MM-dd");
        long longduration1 = TimeUnit.MILLISECONDS.convert (Duration, TimeUnit.DAYS);
        long longdateAf = comDateBf.getTime() + longduration1;
        Date comDateAf = new Date(longdateAf);
        if(((dateBefore.getTime() <= comDateAf.getTime() && comDateBf.getTime() <= dateAfter.getTime()))){
            return "True";}
        else{
            return "False";
        }

    }

    public static Boolean CheckDate(Date dateBefore, int Duration,Date comDateBf, int comDuration){
        SimpleDateFormat dcn = new SimpleDateFormat ("yyyy-MM-dd");
        long longduration = TimeUnit.MILLISECONDS.convert (Duration, TimeUnit.DAYS);
        long chkoutmilli = dateBefore.getTime() + longduration;
        Date dateAfter = new Date(chkoutmilli);
        long longcomduration = TimeUnit.MILLISECONDS.convert (comDuration, TimeUnit.DAYS);
        long longdateAf = comDateBf.getTime() + longcomduration;
        Date comDateAf = new Date(longdateAf);
        return dateBefore.getTime() <= comDateAf.getTime() && comDateBf.getTime() <= dateAfter.getTime();
    }

}
