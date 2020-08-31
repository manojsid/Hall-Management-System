import java.awt.event.*;
import java.awt.*;
import java.applet.*;
import java.sql.*;
import javax.swing.*;
public class addhall extends Frame implements ActionListener
{
    Connection con;
    Statement st;
 PreparedStatement pst;
 ResultSet rs;
    Label lb,lb1,lb2,lb3;
 TextField tf,tf1,tf2,tf3;
 Button add,back;
 addhall()
 {
     setLayout(null);
     setVisible(true);
     setTitle("Add Hall");
  setSize(500,500);
     lb=new Label("Enter the Hall Name:");
  lb1=new Label("Capacity:");
  lb2=new Label("Suitable for:");
  lb3=new Label("Address:");
  tf=new TextField();
  tf1=new TextField();
  tf2=new TextField();
  tf3=new TextField();
  add=new Button("Add Hall");
  back=new Button("Back");
  lb.setBounds(90,110,120,20);
  lb1.setBounds(145,145,60,20);
  lb2.setBounds(145,180,70,20);
  lb3.setBounds(145,220,60,20);
  tf.setBounds(220,110,150,20);
  tf1.setBounds(220,145,150,20);
  tf2.setBounds(220,180,150,20);
  tf3.setBounds(220,220,150,20);
  add.setBounds(250,260,70,20);
  back.setBounds(170,260,60,20);
  add(add);
  add(back);
  add(tf);add(tf1);add(tf2);add(tf3);
  add(lb);add(lb1);add(lb2);add(lb3);
  add.addActionListener(this);
  back.addActionListener(this);
  tf.addActionListener(this);
  tf1.addActionListener(this);
  tf2.addActionListener(this);
  tf3.addActionListener(this);
  addWindowListener(new MyWindowAdapter13(this));
  try{
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    con=DriverManager.getConnection("jdbc:odbc:VIT");
    st=con.createStatement();
  }catch(Exception e){System.out.println("Exception :"+e);}
 }
 public static void main(String args[])
 {
     addhall aq=new addhall();
 }
 public void actionPerformed(ActionEvent ae)
 {
     if(ae.getActionCommand().equals("Add Hall"))
  {
       String s1,s2,s3,s4;
       s1=tf.getText();
       s2=tf1.getText();
       s3=tf2.getText();
       s4=tf3.getText();
       addhall(s1,s2,s3,s4);
     // setVisible(false);
      JOptionPane.showMessageDialog(null,"Hall Added Successfully ","Message",JOptionPane.INFORMATION_MESSAGE);
      ALOptions we=new ALOptions();
  }
  if(ae.getActionCommand().equals("Back"))
  {
      setVisible(false);
   ALOptions es=new ALOptions();
  }
 }
  void addhall(String lb,String lb1,String lb2,String lb3)
 {
   if(lb.length()!=0&&lb1.length()!=0&&lb2.length()!=0&&lb3.length()!=0){
   int x=0;
try {
rs = st.executeQuery("select hall from addhall");
while (rs.next())
{
x++;
}}catch(Exception e){System.out.println("Exception"+e);}
   try{
     System.out.println(x);
     pst=con.prepareStatement("insert into addhall (hall,capacity,suitable,area) values (?,?,?,?)");
     pst.setString(1,lb);
     pst.setString(2,lb1);
     pst.setString(3,lb2);
     pst.setString(4,lb3);
     pst.executeUpdate();
   }catch(Exception e){System.out.println("Exception occurred here "+e);}
   }
   else
   {
     JOptionPane.showMessageDialog(null,"Complete all the fields..","Message",JOptionPane.INFORMATION_MESSAGE);
   }
 }
}
class MyWindowAdapter13 extends WindowAdapter
{
    addhall al;
    public MyWindowAdapter13(addhall al)
 {
     this.al = al;
 }
    public void windowClosing(WindowEvent we)
 {
     al.dispose();
  ALOptions lo=new ALOptions();
 }
}