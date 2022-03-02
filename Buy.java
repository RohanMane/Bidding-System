package credit;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.InputStream;
import java.lang.management.ClassLoadingMXBean;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.Timer;
import java.util.function.BiPredicate;

public class Buy extends JPanel{
    private static String login1;
    Connection connection;
    JButton button;
    boolean aBoolean=true;
//    ResultSet resultSet;
    String search;
//    JButton buttonv;
    BufferedImage resized;
    BufferedImage bufferedImage;
    JFrame frame;
    Calendar calendar;
    JLabel label5A;
    JButton back;
    JButton buttonv;
    JButton buttonp;
    JButton buttonh;
    public void paintComponent(Graphics graphics){
        Image imageIcon=new ImageIcon("C:/Users/pushk/Desktop/t1.jpg").getImage();
        graphics.drawImage(imageIcon,0,0,this);
    }
    public java.awt.Dimension getPreferredSize(){
        return new Dimension(1080,650);
    }
    public static void main(String[] args) {
        Buy buy=new Buy();
        buy.go();
    }
    public static void getter(String login){

        login1=login;
    }
    public void go(){
        buttonh=new JButton("Home");
        buttonp=new JButton("Prev");
        buttonp.setBackground(Color.BLACK);
        buttonp.setForeground(Color.yellow);
        buttonh.setBackground(Color.BLACK);
        buttonh.setForeground(Color.yellow);
        String url="";
        String user="";
        String password="";
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.yellow);
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
            System.out.println("Cooo");
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        Buy buy=new Buy();
        buy.setLayout(new BorderLayout());
        JPanel panel3=new JPanel();
        panel3.setLayout(new BoxLayout(panel3,BoxLayout.Y_AXIS));
        JPanel panel4=new JPanel(new BorderLayout());
        panel3.setOpaque(false);
        JPanel panel=new JPanel(new GridBagLayout());
//        Image image=GenerateImage.toImage(true);
        JLabel label=new JLabel("BUY PRODUCTS");
        label.setFont(new Font(Font.SERIF,Font.BOLD+Font.ITALIC,40));
        panel.setOpaque(false);
        panel.add(label);
        JPanel panel1=new JPanel();
        JTextField textField=new JTextField(20);
        textField.setFont(new Font(Font.SERIF,Font.BOLD,15));
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.YELLOW);
        Icon icon=new ImageIcon("C:/Users/pushk/Desktop/ui.png");
        JButton button1=new JButton(icon);
        button1.setContentAreaFilled(false);
        button1.setBorderPainted(false);
        button1.setOpaque(false);
        panel1.add(textField);
        panel1.add(button1);
        panel1.add(buttonh);
        panel4.add(BorderLayout.EAST,panel1);
        panel4.add(BorderLayout.WEST,back);
        panel4.setOpaque(false);
        panel1.setOpaque(false);
        JPanel panel5=new JPanel(new GridBagLayout());
        JPanel panel6=new JPanel();
        JPanel panel2=new JPanel();
        JPanel panel8=new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints=new GridBagConstraints();
        JLabel label1=new JLabel("PRODUCT ID");
        JLabel label2=new JLabel("PRODUCT NAME");
        JLabel label3=new JLabel("PRICE");
        JLabel label4=new JLabel("CURRENT BID");
        JLabel label5T=new JLabel("Time");
        font(label1);
        font(label2);
        font(label3);
        font(label4);
        font(label5T);
        JLabel label1A=new JLabel();
        JLabel label2A=new JLabel();
        JLabel label3A=new JLabel();
        JLabel label4A=new JLabel();
        label5A=new JLabel();
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=0;
        gridBagConstraints.insets=new Insets(0,0,10,10);
        panel8.add(label1,gridBagConstraints);
        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=0;
        panel8.add(label1A,gridBagConstraints);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=1;
        gridBagConstraints.insets=new Insets(0,0,10,10);
        panel8.add(label2,gridBagConstraints);
        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=1;
        panel8.add(label2A,gridBagConstraints);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=2;
        gridBagConstraints.insets=new Insets(0,0,10,10);
        panel8.add(label3,gridBagConstraints);
        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=2;
        panel8.add(label3A,gridBagConstraints);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=3;
        gridBagConstraints.insets=new Insets(0,0,10,10);
        panel8.add(label4,gridBagConstraints);
        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=3;
        panel8.add(label4A,gridBagConstraints);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=4;
        panel8.add(label5T,gridBagConstraints);
        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=4;
        panel8.add(label5A,gridBagConstraints);
        panel6.setLayout(new BoxLayout(panel6,BoxLayout.Y_AXIS));
        textField.setCaretColor(Color.YELLOW);
        button=new JButton("NEXT");
        buttonv=new JButton("View");
        JLabel labeli=new JLabel();
        JPanel panel7=new JPanel();
        buttonh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                credit.prod_dis3.main(new String[0]);
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                credit.prod_dis3.main(new String[0]);
            }
        });
        button1.addActionListener(new ActionListener() {
            ResultSet resultSet;
            @Override
            public void actionPerformed(ActionEvent e) {
                    search = textField.getText();
                    try {
                        System.out.println("1");
                        resultSet=null;
                        String j = "select *from Product where Pname Like '%'+?+'%' OR P_description Like '%'+?+'%'";
                        PreparedStatement preparedStatement = connection.prepareStatement(j,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                        preparedStatement.setString(1, search);
                        preparedStatement.setString(2,search);
                        resultSet = preparedStatement.executeQuery();

                    } catch (SQLException sqlException) {
                        sqlException.printStackTrace();
                    }
                    try {
                        if(!resultSet.isBeforeFirst()){
                            JOptionPane.showMessageDialog(frame,"No data");
                        }
                        else {
                            aBoolean=true;
                            resultSet.next();
                            System.out.println("k");
                            InputStream inputStream = resultSet.getBinaryStream("image");
                            bufferedImage = ImageIO.read(inputStream);
                            resized = new BufferedImage(300, 300, bufferedImage.getType());
                            Graphics2D gr = resized.createGraphics();
                            gr.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                            gr.drawImage(bufferedImage, 0, 0, 300, 300, 0, 0, bufferedImage.getWidth(),
                                    bufferedImage.getHeight(), null);
                            labeli.setIcon(new ImageIcon(resized));
                            panel7.add(labeli);
//            label50.setText("kkkkkk");
                            label1A.setText(String.valueOf(resultSet.getInt("P_id")));
                            label2A.setText(resultSet.getString("Pname"));
                            label3A.setText(String.valueOf(resultSet.getInt("price")));
                            label4A.setText(String.valueOf(resultSet.getInt("Min_bid")));
                            java.util.Timer timer = new java.util.Timer();
                            Timestamp timestamp = resultSet.getTimestamp("Date_time_bid_end");
                            calendar = Calendar.getInstance();
                            calendar.setTime(new Date(0));
                            calendar.setTime(timestamp);
                            TimerTask timerTask = new Buy.Helper(timer);
                            timer.schedule(timerTask, 0, 1000);
                            font(label1A);
                            font(label2A);
                            font(label3A);
                            font(label4A);
                        }
                    } catch (Exception ez) {
                        ez.printStackTrace();
                    }
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            try {
//                            String j = "select image from Product where Seller_id='lion'";
//                            PreparedStatement preparedStatement = connection.prepareStatement(j);
//                            ResultSet resultSet = preparedStatement.executeQuery();
                                if(resultSet.isAfterLast()) {
                                    JOptionPane.showMessageDialog(frame, "No data please search again");
                                }
                                else {
                                    aBoolean=true;
                                    resultSet.next();
                                    System.out.println("k");
                                    InputStream inputStream = resultSet.getBinaryStream("image");
                                    bufferedImage = ImageIO.read(inputStream);
                                    resized = new BufferedImage(300, 300, bufferedImage.getType());
                                    Graphics2D gr = resized.createGraphics();
                                    gr.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                                            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                                    gr.drawImage(bufferedImage, 0, 0, 300, 300, 0, 0, bufferedImage.getWidth(),
                                            bufferedImage.getHeight(), null);
//                        gr.dispose();
                                    labeli.setIcon(new ImageIcon(resized));
                                    panel7.add(labeli);
                                    label1A.setText(String.valueOf(resultSet.getInt("P_id")));
                                    label2A.setText(resultSet.getString("Pname"));
                                    label3A.setText(String.valueOf(resultSet.getInt("price")));
                                    label4A.setText(String.valueOf(resultSet.getInt("Min_bid")));
                                    java.util.Timer timer = new java.util.Timer();
                                    Timestamp timestamp = resultSet.getTimestamp("Date_time_bid_end");
                                    calendar = Calendar.getInstance();
                                    calendar.setTime(new Date(0));
                                    calendar.setTime(timestamp);
                                    TimerTask timerTask = new Buy.Helper(timer);
                                    timer.schedule(timerTask, 0, 1000);
                                    font(label1A);
                                    font(label2A);
                                    font(label3A);
                                    font(label4A);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    buttonp.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
//                            String j = "select image from Product where Seller_id='lion'";
//                            PreparedStatement preparedStatement = connection.prepareStatement(j);
//                            ResultSet resultSet = preparedStatement.executeQuery();
                                if(resultSet.isBeforeFirst()) {
                                    JOptionPane.showMessageDialog(frame, "No data please search again");
                                }
                                else {
                                    resultSet.previous();
                                    aBoolean=true;
                                    System.out.println("k");
                                    InputStream inputStream = resultSet.getBinaryStream("image");
                                    bufferedImage = ImageIO.read(inputStream);
                                    resized = new BufferedImage(300, 300, bufferedImage.getType());
                                    Graphics2D gr = resized.createGraphics();
                                    gr.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                                            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                                    gr.drawImage(bufferedImage, 0, 0, 300, 300, 0, 0, bufferedImage.getWidth(),
                                            bufferedImage.getHeight(), null);
//                        gr.dispose();
                                    labeli.setIcon(new ImageIcon(resized));
                                    panel7.add(labeli);
                                    label1A.setText(String.valueOf(resultSet.getInt("P_id")));
                                    label2A.setText(resultSet.getString("Pname"));
                                    label3A.setText(String.valueOf(resultSet.getInt("price")));
                                    label4A.setText(String.valueOf(resultSet.getInt("Min_bid")));
                                    java.util.Timer timer = new java.util.Timer();
                                    Timestamp timestamp = resultSet.getTimestamp("Date_time_bid_end");
                                    calendar = Calendar.getInstance();
                                    calendar.setTime(new Date(0));
                                    calendar.setTime(timestamp);
                                    TimerTask timerTask = new Buy.Helper(timer);
                                    timer.schedule(timerTask, 0, 1000);
                                    font(label1A);
                                    font(label2A);
                                    font(label3A);
                                    font(label4A);
//                            Image image = new ImageIcon(resized).getImage();
//                                g.drawImage(image, 0, 0, this);
//                       label17.setIcon(new ImageIcon(bufferedImage));
                                }
                            } catch (Exception ew) {
                                ew.printStackTrace();
                            }
                        }
                    });
                    buttonv.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                prod_dis.getter(bufferedImage, resultSet.getInt("P_id"), login1);
                                frame.dispose();
                                credit.prod_dis.main(new String[0]);
                            } catch (Exception exception) {
                                exception.printStackTrace();
                            }
                        }
                    });
            }
        });
        panel7.setPreferredSize(new Dimension(300,300));
        panel7.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.WHITE,1,true),BorderFactory.createLineBorder(Color.WHITE,1,true)));
        panel6.add(panel7);
        JPanel panel91=new JPanel();
        panel91.setPreferredSize(new Dimension(20,10));
        panel8.setBackground(new Color(0,0,0,120));
        panel91.setBackground(new Color(0,0,0,120));
        panel6.add(panel91);
        panel6.add(panel8);
        panel2.add(panel6);
        panel5.add(panel2);
        panel5.setOpaque(false);
        panel6.setOpaque(false);
        panel2.setOpaque(false);
        buttonv.setBackground(Color.BLACK);
        buttonv.setForeground(Color.YELLOW);
        JPanel panel10=new JPanel(new GridBagLayout());
        button.setBackground(Color.BLACK);
        button.setForeground(Color.YELLOW);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=0;
        gridBagConstraints.insets=new Insets(0,0,0,30);
        panel10.add(buttonp,gridBagConstraints);
        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=0;
        panel10.add(buttonv,gridBagConstraints);
        gridBagConstraints.gridx=2;
        gridBagConstraints.gridy=0;
        panel10.add(button,gridBagConstraints);
        panel10.setBackground(new Color(0,0,0,120));
        panel6.add(panel10);
        //panel.add(label);
        panel3.add(panel);
        panel3.add(panel4);
        panel8.setBackground(Color.BLACK);
        JPanel panel9=new JPanel();
        JLabel label5=new JLabel();
        panel9.setPreferredSize(new Dimension(20,40));
        panel9.add(label5);
        panel7.setOpaque(false);
        panel9.setOpaque(false);
        panel3.add(panel9);
        panel3.add(panel5);
        buy.add(BorderLayout.NORTH,panel3);
        frame=new JFrame();
        frame.getContentPane().add(buy);
        frame.setSize(1080,650);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    class Helper extends TimerTask {
        public int SECONDS_IN_A_DAY = 24 * 60 * 60;
        Timer timer1;
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
                    JOptionPane.showMessageDialog(frame,"Time for bidding has ended");
                    frame.dispose();
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
            font(label5A);
//            System.out.printf("%d days, %d hours, %d minutes and %d seconds\n", days, hours, minutes, seconds);
        }
    }
    public void font(JLabel label){
        label.setFont(new Font("SERIF", Font.BOLD,17));
        label.setForeground(Color.white);
    }
    private ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }


}
