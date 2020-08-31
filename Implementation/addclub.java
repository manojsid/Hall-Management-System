import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class addclub extends Frame implements ActionListener
{
static Connection con;
static Statement st;
PreparedStatement pst;
static ResultSet rs;
static String un, pw;
TextField name, pass,cpass;
Label namep, passp,cpas,l;
Button register,back;
String msg = "Check";
String s1 = "sun.jdbc.odbc.JdbcOdbcDriver";
String s2 = "jdbc:odbc:VIT";
addclub() {
setTitle("ADD CLUBS");
setLayout(null);
setVisible(true);
setSize(500,500);
  Font f1=new Font("Arial",Font.PLAIN,30);
  l=new Label("ADD CLUBS");
  l.setFont(f1);
namep = new Label("Club Name: ");
passp = new Label("Password: ");
cpas  = new Label("Confirm Password: ");
name = new TextField();
pass = new TextField();
cpass = new TextField();
pass.setEchoChar('*');
cpass.setEchoChar('*');
register = new Button("Add Club");
 l.setBounds(157,80,200,60);
 add(l);
add(namep);
namep.setBounds(140,155,90,20);
add(name);
name.setBounds(270,155,80,20);
add(passp);
passp.setBounds(140,185,90,20);
add(pass);
pass.setBounds(270,185,80,20);
add(cpass);
cpass.setBounds(270,215,80,20);
add(register);
add(cpas);
cpas.setBounds(140,215,120,20);
register.setBounds(250,255,73,20);
 back=new Button("Back");
back.setBounds(170,255,60,20);
add(back);
back.addActionListener(this);
register.addActionListener(this);
addWindowListener(new MyWindowAdapter9(this));
try {
Class.forName(s1);
con = DriverManager.getConnection(s2);
st = con.createStatement();
} catch(Exception e) {
System.out.println("caught: " + e);
}
}
public void actionPerformed(ActionEvent ae) {
  if(ae.getSource()==register){
String s = name.getText();
String s1 = pass.getText();
boolean flag = check(s,s1);
if (!(flag)) {
  if(pass.getText().equals(cpass.getText()))
           {
try {
pst = con.prepareStatement("insert into unames(Username,Password) values(?,?)");
pst.setString(1,s);
pst.setString(2,s1);
pst.executeUpdate();
JOptionPane.showMessageDialog(null,"Club Added Successfully","Message",JOptionPane.INFORMATION_MESSAGE);

    this.setVisible(false);
    ALOptions al=new ALOptions();
}
catch(Exception e) {
System.out.println("caught " + e);
}
  }
  else 
JOptionPane.showMessageDialog(null,"Passwords don't match..Try Again","Message",JOptionPane.ERROR_MESSAGE);
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
String name;
try {
rs = st.executeQuery("select Username from unames");
while (rs.next())
{
name = rs.getString(1);
if (name.equals(a)) {
JOptionPane.showMessageDialog(null,"Club already exists....","Message",JOptionPane.ERROR_MESSAGE);
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
  addclub lr= new addclub();
}
}
class MyWindowAdapter9 extends WindowAdapter
{
    addclub al;
    public MyWindowAdapter9(addclub al)
 {
     this.al = al;
 }
    public void windowClosing(WindowEvent we)
 {
     al.dispose();
  ALOptions al=new ALOptions();
 }
}