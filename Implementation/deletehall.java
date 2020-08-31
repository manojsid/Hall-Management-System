import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
class deletehall extends Frame implements ActionListener
{
   Connection con;
    Statement st;
 PreparedStatement pst;
 ResultSet rs,rs1;
    Checkbox q[];
    int x=0,i=0;
    Button b,back;
 deletehall()
 {
   setVisible(true);
   setLayout(null);
   setSize(500,500);
   repaint();
   try{
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    con=DriverManager.getConnection("jdbc:odbc:VIT");
    st=con.createStatement();
  }catch(Exception e){System.out.println("Exception :"+e);}
    try {
    rs = st.executeQuery("select hall from addhall");
     while (rs.next())
    {
    x++;
     }}catch(Exception e){System.out.println("Exception"+e);}
    q=new Checkbox[x];
    back=new Button("Back");
     b=new Button("Delete");
    addCheckboxes();
  addWindowListener(new MyWindowAdapter88(this));
  add(b);
  back.addActionListener(this);
  add(back);
  b.addActionListener(this);
 }
 public void paint(Graphics g)
 {
 }
 void addCheckboxes()
 {
   int i=0,x=120,y=80;
   try{
     rs1=st.executeQuery("select hall from addhall");
     while(rs1.next()&&i<x)//
     {
       q[i]=new Checkbox(rs1.getString(1));
       q[i].setBounds(x+30,y,300,20);
       add(q[i]);
       y+=30;
       i++;
     }
     b.setBounds(x+125,y,60,20);
     back.setBounds(x+50,y,50,20);
   }catch(Exception e){System.out.println("Exception occurred"+e);}
 }
 
 public void actionPerformed(ActionEvent ae)
 {
   if(ae.getActionCommand().equals("Delete"))
   {
     deletehall();
     JOptionPane.showMessageDialog(null,"Hall Deleted Successfully","Message",JOptionPane.INFORMATION_MESSAGE);
   }
   else if(ae.getActionCommand().equals("Back"))
   {
     this.setVisible(false);
     ALOptions es=new ALOptions();
   }
 }
 void deletehall()
 {
   System.out.println(q[0].getLabel()+""+q[0].getState());
   System.out.println(x);
   String s="";
   int flag=0;
   int i=0;
   while(i<x)
   {
     System.out.println(i);
     try{
     if(q[i].getState())
     {
       flag=1;
       try{
       }catch(Exception e){System.out.println("Over here");}
       System.out.println(q[i].getLabel());
       try
       {
          pst=con.prepareStatement("delete from addhall where hall=?");
          pst.setString(1,q[i].getLabel());
          pst.executeUpdate();
          pst.close();
       }
       catch(Exception e){System.out.println("Exception :"+e);}
     }
     }catch(Exception e){System.out.println("Exception occurred"+e);}
     i++;
   }
   if(flag==0)
     JOptionPane.showMessageDialog(null,"Nothing deleted.","Message",JOptionPane.INFORMATION_MESSAGE);
 }
 public static void main(String args[])
 {
   deletehall dq=new deletehall();
 }
 
}
class MyWindowAdapter88 extends WindowAdapter
{
    deletehall al;
    public MyWindowAdapter88(deletehall al)
 {
     this.al = al;
 }
    public void windowClosing(WindowEvent we)
 {
     al.dispose();
     ALOptions es=new ALOptions();
 }
}