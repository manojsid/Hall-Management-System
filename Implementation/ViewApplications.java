import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ViewApplications extends Frame implements ActionListener
{
  Label h,c,s,g,a,l[],m[],n[],k[],p[];
  Connection con2;
  ResultSet rs,ra,rb;
  Statement st,st1,st2;
   int x1[],x2[],x3[];
  PreparedStatement pst1,pst2,pst3;
  String f[],b[],z[],d[],e[];
  final int x=40,y=60;
  int count=0;
       Button logout;  
    ViewApplications()
 {
     setLayout(null);
    setVisible(true);
     setSize(650,730);
       setTitle("VIEW APPLICATIONS");
        logout= new Button("Back");
        add(logout);
        logout.setBounds(570,40,70,25);
        h=new Label("HALL-DATE");
        h.setBounds(60,60,70,20);
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
        g=new Label("PROGRAM");
        g.setBounds(450,60,70,20);
        add(g);
        g.setForeground(Color.red);
        a=new Label("App.no");
        a.setBounds(10,60,40,20);
        add(a);
        a.setForeground(Color.red);
        logout.addActionListener(this);
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
        addWindowListener(new MyWindowAdapter55(this));
 }    
void addComponents()
  {
    int i=0,x1=x,y1=y;
    try{
    rs=st.executeQuery("select * from Booking where status='pending'");
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
     p=new Label[count];
    f=new String[count];
    b=new String[count];
    z=new String[count];
    d=new String[count];
     e=new String[count];
    i=0;
    try{
      rs=st1.executeQuery("select * from Booking where status='pending'");
      while(rs.next())
      {
        e[i]=rs.getString(1);
        f[i]=rs.getString(2);
        b[i]=rs.getString(3);
        z[i]=rs.getString(4);
        d[i]=rs.getString(5);
        i++;
      }
      System.out.println(z[0]);
      for(i=0;i<count;i++)
      {
        k[i]=new Label(e[i]);
        l[i]=new Label(f[i]);
        m[i]=new Label(b[i]);
         n[i]=new Label(z[i]);
          p[i]=new Label(d[i]);
        y1=y1+20;
        l[i].setBounds(x1+10,y1,100,20);
        add(l[i]);
        m[i].setBounds(x1+160,y1,90,20);
        add(m[i]);
        n[i].setBounds(x1+300,y1,100,20);
        add(n[i]);
         k[i].setBounds(x1-20,y1,20,20);
        add(k[i]);
         p[i].setBounds(x1+400,y1,120,20);
        add(p[i]);
          k[i].setForeground(Color.red);
        
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
            ALOptions lo=new ALOptions();
     }
 }
 public static void main(String args[])
 {
     ViewApplications es=new ViewApplications();
     
 }
}
class MyWindowAdapter55 extends WindowAdapter
{
    ViewApplications al;
    public MyWindowAdapter55(ViewApplications al)
 {
     this.al = al;
 }
    public void windowClosing(WindowEvent we)
 {
     al.dispose();
  ALOptions lo=new ALOptions();
 }
}