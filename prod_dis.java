package credit;



import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.security.spec.ECField;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.Timer;
import javax.imageio.ImageIO;
import javax.swing.*;
public class prod_dis implements ActionListener
{
    private static int d1;
    private static String login1;
    JButton Quer;
    JButton Bid;
    JButton Back;
    JButton logo;
    static BufferedImage bufferedImage;
    BufferedImage resized;
    String url="";
    String user="";
    String password="";
    Connection connection;
    Calendar calendar;
    JLabel label5A;
    JTextField field1;
    JFrame f;
    boolean aBoolean=true;
    public static void main(String[] args)
    {
        prod_dis prod=new prod_dis();
        prod.go();
    }
    public static void getter(BufferedImage bufferedImage,int u,String login){
        prod_dis.bufferedImage =bufferedImage;
        d1=u;
        login1=login;
    }
    public void go()
    {
        ResourceBundle reader = null;
        try{
            reader = ResourceBundle.getBundle("dbconfig.properties");
            url=reader.getString("db.url");
            user=reader.getString("db.username");
            password=reader.getString("db.password");
        }catch(Exception e){
        }

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("connected");
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        f=new JFrame("Product Information");
        JPanel panel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel panel1=new JPanel();
        JPanel panel2=new JPanel();
        JPanel panel3=new JPanel();
        JPanel panel4=new JPanel();
        JPanel panel5=new JPanel();
        JPanel panel6=new JPanel();
        panel6.setLayout(new BorderLayout());
        panel5.setLayout(new GridBagLayout());
        panel4.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints=new GridBagConstraints();
        f.getContentPane();
        logo=new JButton("Logout");
        logo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                credit.GridBag1.main(new String[0]);
            }
        });
        /*pushkar*/
        logo.setBackground(Color.BLUE);
        logo.setForeground(Color.WHITE);
        Dimension size=logo.getPreferredSize();
        logo.setBounds(700,100,size.width,size.height);
        Bid=new JButton("Add my Bid");
        Quer=new JButton("Ask a Query");
        Quer.addActionListener(this);
        Quer.setBackground(Color.BLUE);
        Quer.setForeground(Color.WHITE);
        Dimension size1=Quer.getPreferredSize();
        Quer.setBounds(400,300,size1.width,size1.height);
        Bid.addActionListener(this);
        Bid.setBackground(Color.BLUE);
        Bid.setForeground(Color.WHITE);
        Back=new JButton("Back");
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                credit.Buy.main(new String[0]);
            }
        });
        /*pushkar*/
        Back.setBackground(Color.BLUE);
        Back.setForeground(Color.WHITE);
        panel4.setLayout(new BoxLayout(panel4,BoxLayout.Y_AXIS));
        Dimension size2=Bid.getPreferredSize();
        Bid.setBounds(400,600,size2.width,size2.height);
        JLabel label1=new JLabel("Premium House");
//        JLabel label2=new JLabel("Its One of the most beautiful house.");
        JLabel label3=new JLabel("\nHighest Bid:");
        JLabel label3A=new JLabel();
        label3A.setFont(new Font("ARIAL",Font.BOLD,15));
        JLabel label5=new JLabel("Auction ends at:");
        label5A=new JLabel();
        JLabel label6=new JLabel("What amount will you spend for this auspicious product?");
        JLabel label4=new JLabel("Add a Bid:");
//        ImageIcon img=new ImageIcon(bufferedImage);
        int o=panel5.getWidth();
        System.out.println("j"+o);
        resized = new BufferedImage(600, 600, bufferedImage.getType());
        Graphics2D gr = resized.createGraphics();
        gr.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        gr.drawImage(bufferedImage, 0, 0, 600, 600, 0, 0,bufferedImage.getWidth(), bufferedImage.getHeight(), null);
        ImageIcon imageIcon=new ImageIcon(resized);
        JLabel background=new JLabel(imageIcon);
//        labeli.setIcon(new ImageIcon(resized));
//        JLabel background=new JLabel("",img,JLabel.CENTER);
        background.setBounds(0,0,100,200);
        JLabel name=new JLabel("Product Description:");
        name.setFont(new Font("ARIAL",Font.BOLD,15));
        name.setForeground(new Color(210,105,30));
        name.setMinimumSize(new Dimension(300,100));
        field1=new JTextField(10);
        Dimension size3=field1.getPreferredSize();
        field1.setBounds(400,600,size3.width,size3.height);
        label3.setForeground(Color.RED);
        label5.setForeground(Color.RED);
        label4.setForeground(Color.RED);
        name.setOpaque(false);
        String ha="select* from Product where P_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ha);
            preparedStatement.setInt(1, d1);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            java.util.Timer timer=new java.util.Timer();
            Timestamp timestamp = resultSet.getTimestamp("Date_time_bid_end");
            calendar= Calendar.getInstance();
            calendar.setTime(new Date(0));
            calendar.setTime(timestamp);
            TimerTask timerTask=new credit.prod_dis.Helper(timer);
            timer.schedule(timerTask,0,1000);
            label1.setText(resultSet.getString("P_description"));
            label3A.setText(resultSet.getString("Min_bid"));
        }catch(Exception exception1){
            exception1.printStackTrace();
        }
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=0;
        panel4.add(name,gridBagConstraints);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=1;
        panel4.add(label1,gridBagConstraints);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=2;
//        panel4.add(label2);
        panel4.add(label3,gridBagConstraints);
        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=2;
//        panel4.add(label2);
        panel4.add(label3A,gridBagConstraints);
        panel4.add(label5);
        panel4.add(label5A);
        panel4.add(label6);
//        panel5.add(panel4);
        panel5.add(background);
        panel1.add(label4);
        panel1.add(field1);
        panel1.add(Quer);
        panel1.add(Bid);
        panel3.add(Back);
        panel.add(logo);
        panel6.add(BorderLayout.CENTER,panel4);
        panel.setOpaque(false);
        panel1.setOpaque(false);
        panel4.setOpaque(false);
        panel3.setOpaque(false);
        panel5.setOpaque(false);
        panel2.add(panel);
        f.getContentPane().add(BorderLayout.EAST,panel);
        f.getContentPane().add(BorderLayout.WEST,panel3);
        f.getContentPane().add(BorderLayout.SOUTH,panel1);
        f.getContentPane().add(BorderLayout.CENTER,panel5);
        f.getContentPane().add(BorderLayout.NORTH,panel6);
        panel6.setOpaque(false);
        f.getContentPane().setBackground(new Color(255,204,0));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setVisible(true);
        System.out.println(background.getWidth());
        System.out.println(panel5.getHeight());
    }
    class Helper extends TimerTask {
        public int SECONDS_IN_A_DAY = 24 * 60 * 60;
        java.util.Timer timer1;
        public Helper(Timer timer){

            timer1=timer;
        }

        public void run() {
            Calendar calendar1 = Calendar.getInstance();

//            long diff=calendar.getTimeInMillis()-calendar1.getTimeInMillis();
            long diff = calendar.getTimeInMillis() - calendar1.getTimeInMillis();
            if(diff<=0&&aBoolean){
                aBoolean=false;
                timer1.cancel();
                JOptionPane.showMessageDialog(f,"Time for bidding has ended");
                f.dispose();
                credit.prod_dis3.main(new String[0]);
            }
            long diffSec = diff / 1000;

            long days = diffSec / SECONDS_IN_A_DAY;
            long secondsDay = diffSec % SECONDS_IN_A_DAY;
            long seconds = secondsDay % 60;
            long minutes = (secondsDay / 60) % 60;
            long hours = (secondsDay / 3600); // % 24 not needed
            String time1=days+" "+"D"+" "+hours+" "+"h"+" "+minutes+" "+"m"+" "+seconds+" "+"s";
            label5A.setText(time1);
            label5A.setFont(new Font("ARIAL",Font.BOLD,15));
            label5A.setForeground(Color.BLACK);
//            label5A.setForeground(new Color(210,105,30));
            label5A.setMinimumSize(new Dimension(300,100));

//            System.out.printf("%d days, %d hours, %d minutes and %d seconds\n", days, hours, minutes, seconds);
        }
    }
    public void actionPerformed(ActionEvent e)
    {
        /*pushkar*/
        if(e.getSource()==Bid)
        {

            JFrame f=new JFrame();
            try{
                System.out.println(login1);
                String b="select Balance_bid from Customer where C_id=?";
                String b1="select *from Product where P_id=?";
                PreparedStatement preparedStatement=connection.prepareStatement(b);
                PreparedStatement preparedStatement2=connection.prepareStatement(b1);
                preparedStatement.setString(1,login1);
                preparedStatement2.setInt(1,d1);
                ResultSet resultSet=preparedStatement.executeQuery();
                ResultSet resultSet2=preparedStatement2.executeQuery();
                resultSet.next();
                resultSet2.next();
                if(Integer.parseInt(field1.getText())>resultSet.getInt("Balance_bid")){
                    JOptionPane.showMessageDialog(f,"Balance not enough");
                }
                else if(Integer.parseInt(field1.getText())<resultSet2.getInt("Min_bid")){
                    JOptionPane.showMessageDialog(f,"Previous bid is higher than your balance");
                }
                else{
                    System.out.println(login1);
                    String u="Update Customer Set Balance_bid=? where C_id=?";
                    String n="select* from cuspro where Pr_id=?";
                    PreparedStatement preparedStatement1=connection.prepareStatement(u);
                    PreparedStatement preparedStatement3=connection.prepareStatement(n);
                    preparedStatement3.setInt(1,d1);
                    ResultSet resultSet1=preparedStatement3.executeQuery();
                    if(resultSet1.isBeforeFirst()){
                        resultSet1.next();
                        String n1="Update cuspro Set bid=?,Cu_id=?,Seller=? where Pr_id=?";
                        PreparedStatement preparedStatement4=connection.prepareStatement(n1);
                        preparedStatement4.setInt(4,d1);
                        preparedStatement4.setString(3,resultSet2.getString("Seller_id"));
                        preparedStatement4.setString(2,login1);
                        preparedStatement4.setInt(1,Integer.parseInt(field1.getText()));
                        preparedStatement4.executeUpdate();
                    }
                    else{
                        String n1="Insert into cuspro(Pr_id,Cu_id,bid,Seller) Values(?,?,?,?)";
                        PreparedStatement preparedStatement4=connection.prepareStatement(n1);
                        preparedStatement4.setInt(1,d1);
                        preparedStatement4.setString(2,login1);
                        preparedStatement4.setInt(3,Integer.parseInt(field1.getText()));
                        preparedStatement4.setString(4,resultSet2.getString("Seller_id"));
                        preparedStatement4.executeUpdate();
                    }
                    preparedStatement1.setString(2,login1);
//                    preparedStatement1.executeQuery();
                    int uo=resultSet.getInt("Balance_bid");
                    int u1=Integer.parseInt(field1.getText());
                    System.out.println(uo-u1);
                    int y=uo-u1;
                    preparedStatement1.setInt(1,y);
                    preparedStatement1.executeUpdate();
                    JOptionPane.showMessageDialog(f,"Thank you!! the amount deducted from your account \n      will be refunded if product is not alloted","Alert",JOptionPane.WARNING_MESSAGE);
                    String g="Update Product Set Min_bid=? where P_id=?";
                    PreparedStatement preparedStatement4=connection.prepareStatement(g);
                    preparedStatement4.setInt(1,Integer.parseInt(field1.getText()));
                    preparedStatement4.setInt(2,d1);
                    preparedStatement4.executeUpdate();
                }
            }catch (Exception m){
                m.printStackTrace();
            }
        }
        if(e.getSource()==Quer)
        {
            JFrame f=new JFrame();
            try {
                PreparedStatement preparedStatement9 = connection.prepareStatement("select *from Product where P_id=?");
                preparedStatement9.setInt(1,d1);
                ResultSet resultSet9 = preparedStatement9.executeQuery();
                resultSet9.next();
                System.out.println(d1);
                String g = resultSet9.getString("Seller_id");
                PreparedStatement preparedStatement10 = connection.prepareStatement("select *from Customer where C_id=?");
                preparedStatement10.setString(1,g);
                ResultSet resultSet10 = preparedStatement10.executeQuery();
                resultSet10.next();
                String g1 = resultSet10.getString("Email");
                JOptionPane.showMessageDialog(f, "you can mail your query at:" + g1, "Alert", JOptionPane.WARNING_MESSAGE);
            }catch(Exception e1){
                e1.printStackTrace();
            }
        }
    }
}


