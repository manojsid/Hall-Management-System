import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class coptions extends Frame implements ActionListener
{
    Button hall,book,log,view;
 Label l1;
   coptions()
 {
setSize(500,500);
  setTitle("CLUB LOGIN OPTIONS");
  setVisible(true);
     setLayout(null);
     setForeground(Color.gray);
 Font f1=new Font("Cambria",Font.PLAIN,28);
l1=new Label("CLUB LOGIN");
 l1.setFont(f1);
  l1.setBounds(160,60,500,100);
  add(l1);
  l1.setForeground(Color.blue);
hall=new Button("VIEW HALLS");
hall.setBounds(195,200,100,25);
add(hall);
hall.setForeground(Color.red);
hall.addActionListener(this);
book=new Button("BOOK HALLS");
book.setBounds(195,290,100,25);
add(book);
book.setForeground(Color.red);
book.addActionListener(this);
view=new Button("VIEW STATUS");
view.setBounds(195,380,100,25);
add(view);
view.setForeground(Color.red);
view.addActionListener(this);
log=new Button("Logout");
 log.setBounds(420,40,60,20);
add(log);
log.setForeground(Color.blue);
log.addActionListener(this);
addWindowListener(new MyWindowAdapter111(this));
 }
 public void paint(Graphics g)
 {
g.drawString("CLICK BELOW TO VIEW THE DETAILS ABOUT THE HALLS",90,178); 
g.drawString("|",245,190);
g.drawString("|",247,190);
g.drawString("V",244,200);
g.drawString("CLICK BELOW TO BOOK YOUR HALLS",130,268); 
g.drawString("|",245,280);
g.drawString("|",247,280);
g.drawString("V",244,290);
g.drawString("CLICK BELOW TO VIEW STATUS",150,358); 
g.drawString("|",245,370);
g.drawString("|",247,370);
g.drawString("V",244,380);
 }
public void actionPerformed(ActionEvent ae)
    {
     if(ae.getActionCommand().equals("VIEW HALLS"))
  {
   setVisible(false);
   Empty l=new Empty();
  }
if(ae.getActionCommand().equals("BOOK HALLS"))
  {
   setVisible(false);
   bookhall al=new bookhall();
   //JOptionPane.showMessageDialog(null,"Approved/Rejected Successfully","Message",JOptionPane.ERROR_MESSAGE);
   // this.setVisible(false);
   
  }
if(ae.getActionCommand().equals("VIEW STATUS"))
  {
   setVisible(false);
   ViewStatus cl=new ViewStatus();
  }
if(ae.getActionCommand().equals("Logout"))
  {
      this.setVisible(false);
      ulog l=new ulog();
  }
}
public static void main(String args[])
 {
     coptions e=new coptions();
 }
}
class MyWindowAdapter111 extends WindowAdapter
{
   coptions al;
    public MyWindowAdapter111(coptions al)
 {
     this.al = al;
 }
    public void windowClosing(WindowEvent we)
 {
      al.dispose();
  ulog lo=new ulog();
 }
}