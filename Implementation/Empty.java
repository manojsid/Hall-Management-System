import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Empty extends Frame implements ActionListener
{
   int x1[];
  Label l[],m[],n[],k[];
  Connection con2;
  ResultSet rs,rs1,rs2;
  Statement st,st1,st2;
  PreparedStatement pst1,pst2,pst3;
  final int x=40,y=30;
  int count=0;
  String s1[],s2[],s3[],s4[];
       Button lout;
  
    Empty()
 {
     setLayout(null);
  // setBackground(Color.orange);
    setVisible(true);
     setSize(650,730);
       setTitle("VIEW HALLS");
        lout= new Button("Back");
        add(lout);
        lout.setBounds(550,50,60,25);
        lout.addActionListener(this);
    try{
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      con2=DriverManager.getConnection("jdbc:odbc:VIT");
      st=con2.createStatement();
      st1=con2.createStatement();
      st2=con2.createStatement();
    }catch(Exception e){
      System.out.println("The Exception occurred is "+e);
    }
       addComponents();
        addWindowListener(new MyWindowAdapter51(this));
 }
    void addComponents()
  {
    int i=0,x1=x,y1=y;
    try{
    rs=st.executeQuery("select * from addhall");
    while(rs.next())
    {
      count++;
    }
    System.out.println(count);
    st.close();
    }catch(Exception e){System.out.println("Exception "+ e);}
    l=new Label[count];
     m=new Label[count];
      n=new Label[count];
       k=new Label[count];
    s1=new String[count];
    s2=new String[count];
    s3=new String[count];
    s4=new String[count];
    i=0;
    try{
      rs=st1.executeQuery("select * from addhall");
      while(rs.next())
      {
        s1[i]=rs.getString(2);
       s2[i]=rs.getString(3);
        s3[i]=rs.getString(4);
        s4[i]=rs.getString(5);
        i++;
      }
      System.out.println(s3[0]);
      for(i=0;i<count;i++)
      {
        l[i]=new Label(s1[i]);
         m[i]=new Label(s2[i]);
          n[i]=new Label(s3[i]);
           k[i]=new Label(s4[i]);
        y1=y1+80;
        l[i].setBounds(x1,y1,300,20);
        add(l[i]);
        m[i].setBounds(x1+10,y1+20,300,20);
        add(m[i]);
        n[i].setBounds(x1+10,y1+40,300,20);
        add(n[i]);
        k[i].setBounds(x1+10,y1+60,300,20);
        add(k[i]);
           l[i].setForeground(Color.red);
           m[i].setForeground(Color.blue);
n[i].setForeground(Color.blue);
k[i].setForeground(Color.blue);
      }
    }catch(Exception e){
      System.out.println("Exception occurred is "+e);
    }
  }
   public void paint(Graphics g)
 {
 }
 public void actionPerformed(ActionEvent ae)
 {
     if(ae.getActionCommand().equals("Back"))
      {
           this.setVisible(false);
            coptions lo=new coptions();
     }
 }
 public static void main(String args[])
 {
     Empty es=new Empty();     
 }
}
class MyWindowAdapter51 extends WindowAdapter
{
    Empty al;
    public MyWindowAdapter51(Empty al)
 {
     this.al = al;
 }
    public void windowClosing(WindowEvent we)
 {
     al.dispose();
  coptions lo=new coptions();
 }
}