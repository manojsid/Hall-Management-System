import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class accept extends Frame implements ActionListener
{
static Connection con;
static Statement st;
PreparedStatement pst;
static ResultSet rs;
Label stus, hall,chall,l;
TextField stust,hallt,challt;
Button accept,back;
String msg = "Check";
String s1 = "sun.jdbc.odbc.JdbcOdbcDriver";
String s2 = "jdbc:odbc:VIT";
accept() {
setTitle("APPROVING PANEL");
setLayout(null);
setVisible(true);
setSize(500,500);
setLocation(50,50);
  Font f1=new Font("Arial",Font.PLAIN,30);
  l=new Label("");
  l.setFont(f1);
stus = new Label("Status: ");
hall = new Label("Application: ");
chall  = new Label("Confirm Application: ");
stust = new TextField();
hallt = new TextField();
challt = new TextField();
accept = new Button("OK");
 l.setBounds(157,80,200,60);
 add(l);
add(stus);
stus.setBounds(140,155,90,20);
add(stust);
stust.setBounds(270,155,80,20);
add(hall);
hall.setBounds(140,185,90,20);
add(hallt);
hallt.setBounds(270,185,80,20);
add(challt);
challt.setBounds(270,215,80,20);
add(accept);
add(chall);
chall.setBounds(140,215,120,20);
accept.setBounds(250,255,73,20);
 back=new Button("Back");
back.setBounds(170,255,60,20);
add(back);
back.addActionListener(this);
accept.addActionListener(this);
addWindowListener(new MyWindowAdapter999(this));
try {
Class.forName(s1);
con = DriverManager.getConnection(s2);
st = con.createStatement();
} catch(Exception e) {
System.out.println("caught: " + e);
}
}
public void actionPerformed(ActionEvent ae) {
  if(ae.getSource()==accept){
String s = stust.getText();
String s1 = hallt.getText();
boolean flag = check(s,s1);
if (!(flag)) {
  if(hallt.getText().equals(challt.getText()))
           {
try {
pst = con.prepareStatement("update Booking set status=? where halls =?");
pst.setString(1,s);
pst.setString(2,s1);
pst.executeUpdate();
JOptionPane.showMessageDialog(null,s+" Successfully","Message",JOptionPane.INFORMATION_MESSAGE);

    this.setVisible(false);
    ALOptions al=new ALOptions();
}
catch(Exception e) {
System.out.println("caught " + e);
}
  }
  else 
JOptionPane.showMessageDialog(null,"Applications's dont match!!","Message",JOptionPane.ERROR_MESSAGE);
}
}
 if(ae.getSource()==back)
  {
    this.setVisible(false);
    ALOptions al=new ALOptions();
  }
}
boolean check(String a, String b)
{ 
boolean f = false;
String stust;
try {
rs = st.executeQuery("select status from Booking");
while (rs.next())
{
stust = rs.getString(1);
if (stust.equals(a)) {
//JOptionPane.showMessageDialog(null,"Request already Approved/Rejected...","Message",JOptionPane.ERROR_MESSAGE);
f = false;
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
  accept ac= new accept();
}
}
class MyWindowAdapter999 extends WindowAdapter
{
    accept ac;
    public MyWindowAdapter999(accept ac)
 {
     this.ac = ac;
 }
    public void windowClosing(WindowEvent we)
 {
     ac.dispose();
  ALOptions ao=new ALOptions();
 }
}