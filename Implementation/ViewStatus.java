import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ViewStatus extends Frame implements ActionListener
{ 
  Label l[],m[],n[],k[],h,c,s,a;
  Connection con2;
  ResultSet rs,rs1,rs2;
  Statement st,st1,st2;
  PreparedStatement pst1,pst2,pst3;
  final int x=40,y=60;
   int x1[],x2[],x3[];
  int count=0;
  String s1[],s2[],s3[],s4[],s5[];
       Button lout,addq,delq,cres;
  
    ViewStatus()
 {
     setLayout(null);
    setVisible(true);
     setSize(650,730);
       setTitle("VIEW STATUS");
        lout= new Button("Back");
        add(lout);
        lout.setBounds(550,50,60,25);
        h=new Label("HALL-DATE");
        h.setBounds(70,60,70,20);
        add(h);
        h.setForeground(Color.red);
         c=new Label("CLUB NAME");
        c.setBounds(190,60,70,20);
        add(c);
        c.setForeground(Color.red);
         s=new Label("STATUS");
        s.setBounds(340,60,70,20);
        add(s);
        s.setForeground(Color.red);
        a=new Label("App.no");
        a.setBounds(10,60,40,20);
        add(a);
        a.setForeground(Color.red);
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
        addWindowListener(new MyWindowAdapter555(this));
 }    
void addComponents()
  {
    int i=0,x1=x,y1=y;
    try{
    rs=st.executeQuery("select * from Booking where status='approved' and 'rejected'");
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
     s5=new String[count];
    i=0;
    try{
      rs=st1.executeQuery("select * from Booking where status='approved' and 'rejected'");
      while(rs.next())
      {
        s5[i]=rs.getString(1);
        s1[i]=rs.getString(2);
        s2[i]=rs.getString(3);
        s3[i]=rs.getString(4);
        s4[i]=rs.getString(5);
        i++;
      }
      System.out.println(s3[0]);
      for(i=0;i<count;i++)
      {
        k[i]=new Label(s5[i]);
        l[i]=new Label(s1[i]);
        m[i]=new Label(s2[i]);
         n[i]=new Label(s3[i]);
        y1=y1+20;
        l[i].setBounds(x1+30,y1,100,20);
        add(l[i]);
        m[i].setBounds(x1+160,y1,90,20);
        add(m[i]);
        n[i].setBounds(x1+300,y1,150,20);
        add(n[i]);
         k[i].setBounds(x1-20,y1,20,20);
        add(k[i]);
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
     ViewStatus es=new ViewStatus();    
 }
}
class MyWindowAdapter555 extends WindowAdapter
{
    ViewStatus al;
    public MyWindowAdapter555(ViewStatus al)
 {
     this.al = al;
 }
    public void windowClosing(WindowEvent we)
 {
     al.dispose();
  coptions lo=new coptions();
 }
}