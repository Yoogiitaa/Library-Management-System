package LibrarySystem;

import java.awt.event.*;
import java.awt.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.sql.*;
public class ViewLibrarian extends JFrame
{
    String x[]={"id", "Name", "password", "email", "contact", "address", "city"};
    JButton bt;
    String y[][]=new String[20][7];
    int i=0, j=0;
    JTable t;
    Font f,f1;

    ViewLibrarian() {
        super("Librarian information");
        setLocation(1, 1);
        setSize(1000, 450);

        f = new Font("Arial", Font.BOLD, 15);

        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "Select * from librarian";
            ResultSet rest = obj.stm.executeQuery(q);
            while (rest.next()) {
                y[i][j++] = rest.getString("lid");
                y[i][j++] = rest.getString("Name");
                y[i][j++] = rest.getString("Password");
                y[i][j++] = rest.getString("email");
                y[i][j++] = rest.getString("contact");
                y[i][j++] = rest.getString("address");
                y[i][j++] = rest.getString("city");
                i++;
                j = 0;


            }
            t = new JTable(y, x);
            t.setFont(f);


        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        JScrollPane sp = new JScrollPane(t);
        add(sp);
    }

    public static void main(String[] args)
    {
        new ViewLibrarian().setVisible(true);
    }




    }





