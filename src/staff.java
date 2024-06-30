import javax.swing.*;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class staff {

    private String username;
    private String password;


    public staff(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public Boolean login(){

        //login method checks the staff text file to check for any matching staff
        try {
            RandomAccessFile raf = new RandomAccessFile("Staff.txt", "rw");
            Boolean flag = false;

            while (true){
                String line = raf.readLine();

                if (line ==null){
                    break;
                }
                List<String> myList = new ArrayList<String>(Arrays.asList(line.split(" // ")));
                //Checks every line for any matching user name and password
                if(username.trim().equals(myList.get(0)) & password.trim().equals(myList.get(1)) ){

                    flag = true;
                    break;
                }
                else{

                }

            }
            if(flag) {
                return flag;
            }else {
                JOptionPane.showMessageDialog(null, "Invalid Username or Password", "Login Failed", JOptionPane.WARNING_MESSAGE);
                return false;
            }

        }
        catch(IOException Ex)
        {JOptionPane.showMessageDialog(null, "Error reading Staff text file", "Read Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
}
