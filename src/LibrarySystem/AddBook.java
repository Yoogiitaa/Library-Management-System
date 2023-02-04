package LibrarySystem;
import java.awt.event.*;
import java.awt.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.sql.*;


public class AddBook extends JFrame implements ActionListener
{
    JLabel L1,L2,L3,L4,L5,L6;
    JButton bt1,bt2;
    JPanel p1,p2;
    JTextField tf1,tf2,tf3,tf4,tf5;
    JPasswordField pf1;
    Font f,f1;

    AddBook() {
        super("AddBook");
        setLocation(0, 0);
        setSize(650, 400);

        f = new Font("Arial", Font.BOLD, 25);
        f1 = new Font("Arial", Font.BOLD, 20);

        L1 = new JLabel("Add Book");
        L2 = new JLabel("Book No");
        L3 = new JLabel("Book Name");
        L4 = new JLabel("Author");
        L5 = new JLabel("Publisher");
        L6 = new JLabel("Quantity");

        L1.setHorizontalAlignment(JLabel.CENTER);
        L1.setForeground(Color.WHITE);

        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();

        bt1 = new JButton("Add Book");
        bt2 = new JButton("Cancel");

        bt1.setFont(f1);
        bt2.setFont(f1);

        bt1.addActionListener(this);
        bt2.addActionListener(this);

        L1.setFont(f);
        L2.setFont(f1);
        L3.setFont(f1);
        L4.setFont(f1);
        L5.setFont(f1);
        L6.setFont(f1);

        tf1.setFont(f1);
        tf2.setFont(f1);
        tf3.setFont(f1);
        tf4.setFont(f1);
        tf5.setFont(f1);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1, 10, 10));
        p1.add(L1);
        p1.setBackground(Color.BLUE);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(6, 2, 10, 10));
        p2.add(L2);
        p2.add(tf1);
        p2.add(L3);
        p2.add(tf2);
        p2.add(L4);
        p2.add(tf3);
        p2.add(L5);
        p2.add(tf4);
        p2.add(L6);
        p2.add(tf5);
        p2.add(bt1);
        p2.add(bt2);

        setLayout(new BorderLayout(10, 10));
        add(p1, "North");
        add(p2, "Center");
    }
    public void actionPerformed(ActionEvent e)
    {

        String bookno=tf1.getText();
        String bookname=tf2.getText();
        String author=tf3.getText();
        String publisher=tf4.getText();
        String quantity=tf5.getText();
        String date=new java.util.Date().toString();

        if(e.getSource()==bt1)
        {
            try
            {
                ConnectionClass obj=new ConnectionClass();
                String q="insert into addbook(BookNo ,bookname, author, publisher, quantity,date) values('"+bookno+"', '"+bookname+"','"+author+"', '"+publisher+"', '"+quantity+"','"+date+"')";
                int aa=obj.stm.executeUpdate(q);
                if(aa==1)
                {
                    JOptionPane.showMessageDialog(null, "Your data successfully inserted");
                    this.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "please fill all details carefully");
                    this.setVisible(true);
                }
            }

            catch (Exception ee)
            {
                ee.printStackTrace();
            }
        }
        if(e.getSource()==bt2)
        {
            this.setVisible(false);
        }

    }
    public static void main(String[] args)
    {


       new AddBook().setVisible(true);





    }
}
