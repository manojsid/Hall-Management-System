import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
class ulog extends Frame implements ActionListener
{
Label lb1,lb2,lb;
 TextField tf1,tf2;
Button enter,close,ad;
    Connection con;
 PreparedStatement pst;
 ResultSet rs1;
 Statement st;
    ulog()
 {
     setTitle("Club Login");
  setSize(500,500);
  setVisible(true);
     setLayout(null);
     
  Font f1=new Font("Arial",Font.ITALIC,30);
  lb=new Label("VIT HALL BOOKING SYSTEM");
  lb.setFont(f1);
  lb.setForeground(Color.red);
     lb1=new Label("CLUBNAME:");
  lb2=new Label("PASSWORD:");
  enter=new Button("Login");
  close=new Button("Close");
  ad=new Button("Admin Login");
  tf1=new TextField();
  tf2=new TextField();
  lb.setBounds(60,75,450,80);
  lb1.setBounds(170,170,80,20);
  lb2.setBounds(170,200,80,20);
  tf1.setBounds(260,170,80,20);
  tf2.setBounds(260,200,80,20);
  tf2.setEchoChar('*');
  enter.setBounds(185,240,60,20);
  close.setBounds(265,240,60,20);
  ad.setBounds(390,40,90,22);
  ad.setForeground(Color.blue);
  add(lb);
  add(lb1);
  add(tf1);
  add(tf2);
  add(lb2);
  add(enter);
  add(close);
  add(ad);
  enter.addActionListener(this);
 close.addActionListener(this);
  ad.addActionListener(this);
  tf1.addActionListener(this);
  tf2.addActionListener(this);
  addWindowListener(new MyWindowAdapter3(this));
  try{
       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    con=DriverManager.getConnection("jdbc:odbc:VIT");
   }catch(Exception e){System.out.println(e);}
 }
 public void paint(Graphics g)
 {
 }
 public void actionPerformed(ActionEvent ae)
 {
     if(ae.getActionCommand().equals("Login"))
  {
       if(tf2.getText().length()!=0)
       {
      if(check(tf1.getText(),tf2.getText()))
      {
       this.setVisible(false);
          coptions su=new coptions();
      }
       }
       else
         JOptionPane.showMessageDialog(null,"Invalid Login Credentials","Message",JOptionPane.ERROR_MESSAGE);
       }
     if(ae.getActionCommand().equals("Close"))
  {
      System.exit(0);
      //this.setVisible(false);
      //LoginOptions l=new LoginOptions();
  }
       if(ae.getActionCommand().equals("Admin Login"))
  {
      this.setVisible(false);
      alog l=new alog();
  }
 }
 public static void main(String args[])
 {
     ulog al=new ulog();
 }
 boolean check(String u, String p)
 {
    String s="";
    try{
     pst=con.prepareStatement("select Password from unames where Username=?");
  pst.setString(1,u);
  rs1=pst.executeQuery();
  while(rs1.next())
  s=rs1.getString(1);
  }catch(Exception e){System.out.println(e);}
  if(s.equals(p))
  return true;
  else
  return false;  
 }
}
class MyWindowAdapter3 extends WindowAdapter
{
    ulog al;
    public MyWindowAdapter3(ulog al)
 {
     this.al = al;
  }
    public void windowClosing(WindowEvent we)
 {
     
      System.exit(0);
      //al.dispose();
  //LoginOptions lo=new LoginOptions();
 }
}
 
 