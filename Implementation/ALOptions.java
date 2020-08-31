import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ALOptions extends Frame implements ActionListener
{
    Button view,add,delete,addc,accept,logout;
 Label lb;
    ALOptions()
 {
     setSize(500,500);
  setTitle("ADMIN LOGIN OPTIONS");
  setVisible(true);
     setLayout(null);
Font f1=new Font("Cambria",Font.PLAIN,28);
lb=new Label("ADMINISTRATOR");
  lb.setFont(f1);
  lb.setBounds(150,100,500,100);
  add(lb);
  lb.setForeground(Color.red);
view=new Button("VIEW APPLICATIONS");
  add=new Button("ADD HALLS");
delete=new Button("DELETE HALLS");
addc=new Button("ADD CLUBS");
accept=new Button("ACCEPT APPLICATIONS");
 view.setBounds(190,200,140,25);
 add.setBounds(205,245,110,25);
 delete.setBounds(205,290,110,25);
 addc.setBounds(205,335,110,25);
 accept.setBounds(180,380,155,25);
logout=new Button("Logout");
 logout.setBounds(420,40,60,20);
add(logout);
logout.addActionListener(this);
add(view);
add(add);
add(delete);
add(addc);
add(accept);
view.addActionListener(this);
add.addActionListener(this);
delete.addActionListener(this);
addc.addActionListener(this);
accept.addActionListener(this);
 addWindowListener(new MyWindowAdapter20(this));
}
public void paint(Graphics g)
 {
}
public void actionPerformed(ActionEvent ae)
    {
     if(ae.getActionCommand().equals("ADD CLUBS"))
  {
   setVisible(false);
   addclub au=new addclub();
  }
     if(ae.getActionCommand().equals("VIEW APPLICATIONS"))
  {
   setVisible(false);
   ViewApplications va=new ViewApplications();
  } 
     if(ae.getActionCommand().equals("ACCEPT APPLICATIONS"))
  {
   setVisible(false);
   accept a=new accept();
  }
  if(ae.getActionCommand().equals("ADD HALLS"))
  {
   setVisible(false);
   addhall ah=new addhall();
  }
if(ae.getActionCommand().equals("DELETE HALLS"))
  {
   setVisible(false);
   deletehall dh=new deletehall();
  }
if(ae.getActionCommand().equals("Logout"))
  {
      this.setVisible(false);
      ulog l=new ulog();
  }
    }
public static void main(String args[])
 {
     ALOptions a1=new ALOptions();
 }
}
class MyWindowAdapter20 extends WindowAdapter
{
   ALOptions l;
    public MyWindowAdapter20(ALOptions l)
 {
     this.l = l;
 }
    public void windowClosing(WindowEvent we)
 {
  l.dispose();    
  ulog lo=new ulog();
 }
}