import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
class alog extends Frame implements ActionListener
{
    Label lb1,lb2,lb;
 TextField tf1,tf2;
 Button enter,back;
    alog()
 {
     setTitle("Administrator Login");
  setSize(500,500);
  setVisible(true);
     setLayout(null);
  Font f1=new Font("Arial",Font.PLAIN,29);
  lb=new Label("ADMINISTRATOR LOGIN");
  lb.setFont(f1);
     lb1=new Label("USERNAME:");
  lb2=new Label("PASSWORD:");
  enter=new Button("Enter");
  back=new Button("Back To Home");
  tf1=new TextField();
  tf2=new TextField();
  lb.setBounds(90,40,400,100);
  lb1.setBounds(140,160,80,30);
  lb2.setBounds(140,190,80,30);
  tf1.setBounds(230,160,80,20);
  tf2.setBounds(230,190,80,20);
  tf2.setEchoChar('*');
enter.setBounds(140,230,60,20);  
back.setBounds(230,230,100,20);
  add(lb);
  add(lb1);
  add(tf1);
  add(tf2);
  add(lb2);
  add(enter);
  add(back);
  enter.addActionListener(this);
  back.addActionListener(this);
  tf1.addActionListener(this);
  tf2.addActionListener(this);
  addWindowListener(new MyWindowAdapter2(this));
 }
 public void paint(Graphics g)
 {
 }
 public void actionPerformed(ActionEvent ae)
 {
     if(ae.getActionCommand().equals("Enter"))
  {
       if(tf1.getText().equals("admin")&&tf2.getText().equals("admin"))
        {
             this.setVisible(false);
             ALOptions su=new ALOptions();
       }
       else
            {
         JOptionPane.showMessageDialog(null,"Invalid Login Credentials...","Message",JOptionPane.ERROR_MESSAGE);
       }
  }
  else if(ae.getActionCommand().equals("Back To Home"))
  {
      this.setVisible(false);
      ulog l=new ulog();
  }
 }
 public static void main(String args[])
 {
     alog al=new alog();
 }
 boolean check(String s1,String s2)
 {
     return true;
 }
}
class MyWindowAdapter2 extends WindowAdapter
{
    alog ad;
    public MyWindowAdapter2(alog ad)
 {
     this.ad = ad;
 }
    public void windowClosing(WindowEvent we)
 {
     ad.dispose();
  ulog ul=new ulog();
 }
}