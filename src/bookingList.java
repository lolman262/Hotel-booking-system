import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class bookingList {


    //bookingList holds an array of booking objects
    private ArrayList<booking> bookingListArr;

    public bookingList() {

        bookingListArr = new ArrayList<>();
    }

    public void addBooking(booking bookingDetails) {

        bookingListArr.add(bookingDetails);
    }

    public void removeBooking(booking bookingDetails) {

        bookingListArr.remove(bookingDetails);
    }

    public ArrayList<booking> getBookingList() {

        return bookingListArr;
    }


    public booking getBooking(int i) {

        return bookingListArr.get(i);
    }



    public void setBooking(booking oldDetails, booking bookingDetails) {
        int index = bookingListArr.indexOf(oldDetails);
        bookingListArr.set(index, bookingDetails);
    }

    public int getIndex(booking objBooking){

        return bookingListArr.indexOf(objBooking);
    }
    public void setBooking(int index, booking bookingDetails) {

        bookingListArr.set(index, bookingDetails);
    }

    public void removeBooking(int i)
    {
        bookingListArr.remove(i);

    }

    public int size(){
        return bookingListArr.size();

    }

    public void setBookingList(ArrayList<booking> bookingList) {
        this.bookingListArr = bookingList;
    }



    //reads the booking text file and creates an array of booking to the BookingList from the text file
    public void readBookingDetailsFromFile() throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new FileReader("Booking.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] bookingDetailsArray = line.split(" // ");
            String name = bookingDetailsArray[0];
            String IC = bookingDetailsArray[1];
            String phoneNumber = bookingDetailsArray[2];
            String email = bookingDetailsArray[3];
            String roomID = bookingDetailsArray[4];
            String date = bookingDetailsArray[5];
            String duration = bookingDetailsArray[6];




            booking bookingDetails = new booking(name, IC, phoneNumber, email, roomID, date, duration);
            bookingListArr.add(bookingDetails);
        }
        br.close();
    }

    //writes the booking details from the array to the text file
    public void writeBookingDetailsToFile() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("Booking.txt"));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (booking bookingDetails : bookingListArr) {
            bw.write(bookingDetails.getName() + " // " + bookingDetails.getIC() + " // " + bookingDetails.getPhone() + " // " +
                    bookingDetails.getEmail() + " // " + bookingDetails.getRoomID() + " // " + bookingDetails.getDate() + " // " + bookingDetails.getduration());
            bw.newLine();
        }
        bw.close();
    }


    
}
