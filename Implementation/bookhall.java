import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class bookhall extends Frame implements ActionListener
{
static Connection con;
static Statement st;
PreparedStatement pst;
static ResultSet rs;
static String un, pw;
TextField tf,tf1,tf2,tf3;
Label lb,lb1,lb2,l,lb3;
Button register,back;
String msg = "Check";
String s1 = "sun.jdbc.odbc.JdbcOdbcDriver";
String s2 = "jdbc:odbc:VIT";
bookhall() {
setTitle("Book Halls");
setLayout(null);
setVisible(true);
setSize(500,500);
  Font f1=new Font("Arial",Font.PLAIN,30);
  l=new Label("BOOK YOUR HALLS");
  l.setFont(f1);
lb = new Label("Club Name: ");
lb1 = new Label("Hall-Date: ");
lb2  = new Label("Confirm Hall-Date: ");
  lb3=new Label("Programme: ");
tf = new TextField();
tf1 = new TextField();
tf2 = new TextField();
tf3=new TextField();
register = new Button("Book");
 l.setBounds(100,80,300,60);
 add(l);
add(lb);
lb.setBounds(140,155,90,20);
add(tf);
tf.setBounds(270,155,80,20);
add(lb1);
lb1.setBounds(140,185,90,20);
add(tf1);
tf1.setBounds(270,185,80,20);
add(tf2);
tf2.setBounds(270,215,80,20);
add(tf3);
tf3.setBounds(270,245,80,20);
add(register);
add(lb2);
lb2.setBounds(140,215,120,20);
add(lb3);
lb3.setBounds(140,245,120,20);
register.setBounds(250,285,73,20);
 back=new Button("Back");
back.setBounds(170,285,60,20);
add(back);
back.addActionListener(this);
register.addActionListener(this);
addWindowListener(new MyWindowAdapter99(this));

try {
Class.forName(s1);
con = DriverManager.getConnection(s2);
st = con.createStatement();
} catch(Exception e) {
System.out.println("caught: " + e);
}
}
public void paint(Graphics g)
 {
  g.drawString("NOTE:",30,372);
  g.drawString("Please enter the HALL-DATE as the CODE of the Auditorium followed by the ",35,388); 
      g.drawString("DATE separated by colon",35,403);
      g.drawString("Example: chrdy-21/11/2015",40,420); 
}
public void actionPerformed(ActionEvent ae) {
  if(ae.getSource()==register){
String s = tf1.getText();
String s1 = tf.getText();
String s3 = tf3.getText();
boolean flag = check2(s,s1);
if (!(flag)) {
  if(tf1.getText().equals(tf2.getText()))
           {
try {
pst = con.prepareStatement("insert into Booking(halls,clubname,status,program) values(?,?,?,?)");
pst.setString(1,s);
pst.setString(2,s1);
pst.setString(3,"pending");
pst.setString(4,s3);
pst.executeUpdate();
JOptionPane.showMessageDialog(null,"The request of your "+"'"+tf.getText()+" Club"+"'"+" for the Hall/Date:  "+"'"+tf1.getText()+"'"+" for the Program "+tf3.getText()+"  is under process...                "+"\n"+"Check the 'View Status' panel for the status of your request..."+"\n"+"                                                                          Thank You","Message",JOptionPane.INFORMATION_MESSAGE);

    this.setVisible(false);
    coptions al=new coptions();
}
    
catch(Exception e) {
System.out.println("caught " + e);
}
  }
  else 
JOptionPane.showMessageDialog(null,"Hall-Date's dont match!!","Message",JOptionPane.ERROR_MESSAGE);
}
}
 if(ae.getSource()==back)
  {
    this.setVisible(false);
    coptions al=new coptions();
  }
}
boolean check2(String utf, String pwd)
{
boolean f = false;
String tf;
try {
rs = st.executeQuery("select halls from Booking where status='approved'");
while (rs.next())
{
tf = rs.getString(1);
if (tf.equals(utf)) {
JOptionPane.showMessageDialog(null,"Hall already booked..Please Try some other Date..","Message",JOptionPane.ERROR_MESSAGE);
f = true;
break;
}
}
}

catch(Exception e) {
System.out.println("Caught: " + e);
}
return f;
}

public static void main(String args[])
{
  bookhall bh= new bookhall();
}
}
class MyWindowAdapter99 extends WindowAdapter
{
    bookhall al;
    public MyWindowAdapter99(bookhall al)
 {
     this.al = al;
 }
    public void windowClosing(WindowEvent we)
 {
     al.dispose();
  coptions al=new coptions();
 }
}