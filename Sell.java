package credit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyManagementException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicReference;

public class Sell extends JPanel implements ActionListener {
    int num;
    JFrame frame;
    JMenu menu;
    JMenu menu1;
    JMenu menu2;
    Connection connection;
    JTextField textField;
    JTextField textField1;
    JTextField textField2;
    JTextArea textField3;
    JTextField textField4;
    JTextField arr1[];
    static String login1;
    String f;
    String arr[];
    JButton button5;
    JButton button10;
    JButton back;
    HashMap<String,Integer> hashMap;
    Calendar calendar;
    JButton buttonh;
    public void paintComponent(Graphics g) {
        Image image = new ImageIcon("C:/Users/pushk/Desktop/l.jpg").getImage();
        g.drawImage(image, 3, 4, this);
    }
    public java.awt.Dimension getPreferredSize() {

        return new Dimension(1080,650);
    }
    public static void main(String[] args) {
        Sell s=new Sell();
        s.go();
    }
    public static void getter(String d){

        login1=d;
    }
    public void go(){
        buttonh=new JButton("Home");
        back=new JButton("Back");
        back.setForeground(Color.yellow);
        back.setBackground(Color.black);
        buttonh.setForeground(Color.yellow);
        buttonh.setBackground(Color.black);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                credit.prod_dis3.main(new String[0]);
            }
        });
        buttonh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                credit.prod_dis3.main(new String[0]);
            }
        });
        String url="";
        String user="";
        String password="";
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
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        GridBagConstraints gridBagConstraints=new GridBagConstraints();
        Sell sell=new Sell();
        sell.setLayout(new BorderLayout());
        JPanel panel=new JPanel();
        JPanel panel1=new JPanel();
        JPanel panel2=new JPanel();
        JPanel panel3=new JPanel();
        JPanel panel4=new JPanel();
        panel4.setLayout(new BoxLayout(panel4,BoxLayout.Y_AXIS));
        panel2.setLayout(new GridBagLayout());
        panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
        panel1.setOpaque(false);
        panel2.setOpaque(false);
        panel3.setOpaque(false);
        panel4.setOpaque(false);
        panel.setLayout(new GridBagLayout());
        JLabel label=new JLabel("SELL IT OUT!!!!");
        label.setForeground(Color.WHITE);
        label.setFont(new Font(Font.SERIF,Font.BOLD+Font.ITALIC,40));
        JLabel label0=new JLabel("SELL SELL SELL");
        JLabel label1=new JLabel("PRODUCT TYPE");
        JLabel label2=new JLabel("PRODUCT NAME(COMPANY NAME)");
        JLabel label3=new JLabel("INITIAL BID");
        JLabel label4=new JLabel("DESCRIPTION");
        JLabel label5=new JLabel("ADD IMAGE");
        JLabel label6=new JLabel("AUCTION PERIOD");
        JMenuBar menuBar=new JMenuBar();
        JMenuBar menuBar1=new JMenuBar();
        JMenuBar menuBar2=new JMenuBar();
        button5=new JButton("hh");
        button5.setForeground(Color.YELLOW);
        button5.setBackground(Color.BLACK);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s=JOptionPane.showInputDialog(null,"enter hour");
                button5.setText(s);
            }
        });
        button10=new JButton("mm");
        button10.setForeground(Color.YELLOW);
        button10.setBackground(Color.BLACK);
        button10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s=JOptionPane.showInputDialog(null,"enter minute");
                button10.setText(s);
            }
        });
        arr1=new JTextField[4];
        menu=new JMenu("Month");
        menu.setForeground(Color.YELLOW);
        menu1=new JMenu("Day");
        menu1.setForeground(Color.YELLOW);
        menu2=new JMenu("Year");
        menu2.setForeground(Color.YELLOW);
        JMenu menu3=new JMenu("hh");
        JMenu menu4=new JMenu("mm");
        hashMap=new HashMap<String, Integer>();
        arr=new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"};
        for (int i = 0; i < 12; i++) {
            if(i==1){
                hashMap.put(arr[i],28);
            }
            else if(i%2==0||i%7==0){
                hashMap.put(arr[i],31);
            }
            else {
                hashMap.put(arr[i],30);
            }
        }
        for ( int i = 0; i < 12; i++) {
           JMenuItem menuItem=new JMenuItem(arr[i]);
            menuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    menu.setText(menuItem.getText());
                }
            });
            menu.add(menuItem);
            menuItem.setBackground(Color.BLACK);
            menuItem.setForeground(Color.YELLOW);
        }
        for (int i = 1; i <=31; i++) {
            JMenuItem menuItem=new JMenuItem(String.valueOf(i));
            menuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    menu1.setText(menuItem.getText());
                }
            });
            menu1.add(menuItem);
            menuItem.setBackground(Color.BLACK);
            menuItem.setForeground(Color.YELLOW);
        }
       for (int i = 2020; i <= 2030; i++) {
           JMenuItem menuItem=new JMenuItem(String.valueOf(i));
           menuItem.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {

                   menu2.setText(menuItem.getText());
               }
           });
           menu2.add(menuItem);
           menuItem.setBackground(Color.BLACK);
           menuItem.setForeground(Color.YELLOW);
        }
        menuBar.add(menu);
        menuBar1.add(menu1);
        menuBar2.add(menu2);
        bar(menuBar);
        bar(menuBar1);
        bar(menuBar2);
        label0.setFont(new Font(Font.SERIF,Font.BOLD+Font.ITALIC,25));
        label0.setForeground(Color.YELLOW);
        font(label1);
        font(label2);
        font(label3);
        font(label4);
        font(label5);
        font(label6);
        textField=new JTextField(10);
        arr1[0]=textField;
        textField1=new JTextField(10);
        arr1[1]=textField1;
        textField2=new JTextField(10);
        arr1[2]=textField2;
        textField3=new JTextArea(6,10);
        textField4=new JTextField(10);
        arr1[3]=textField4;
        tfont(textField);
        tfont(textField1);
        tfont(textField2);
        tfont(textField3);
        tfont(textField4);
        JButton button=new JButton("Browse");
        button.setBackground(Color.BLACK);
        button.setForeground(Color.YELLOW);
        textField3.setLineWrap(true);
        JScrollPane scrollPane=new JScrollPane(textField3);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=0;
        gridBagConstraints.insets=new Insets(20,0,0,0);
        panel2.add(label0,gridBagConstraints);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=1;
        panel2.add(label2,gridBagConstraints);
        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=1;
        panel2.add(textField1,gridBagConstraints);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=2;
        panel2.add(label3,gridBagConstraints);
        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=2;
        panel2.add(textField2,gridBagConstraints);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=3;
        panel2.add(label4,gridBagConstraints);
        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=3;
        gridBagConstraints.insets=new Insets(30,10,0,0);
        panel2.add(scrollPane,gridBagConstraints);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=4;
        panel2.add(label5,gridBagConstraints);
        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=4;
        gridBagConstraints.insets=new Insets(30,0,0,0);
        panel2.add(textField4,gridBagConstraints);
        gridBagConstraints.gridx=2;
        gridBagConstraints.gridy=4;
        panel2.add(button,gridBagConstraints);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser=new JFileChooser();
                int value=fileChooser.showOpenDialog(fileChooser);
                fileChooser.setVisible(true);
                if(value==JFileChooser.APPROVE_OPTION){
                    File file=fileChooser.getSelectedFile();
                    textField4.setText(fileChooser.getSelectedFile().getAbsolutePath());
                }
            }
        });
        JPanel panel5=new JPanel(new GridBagLayout());
        panel5.setOpaque(false);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=5;
        panel2.add(label6,gridBagConstraints);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=0;
        gridBagConstraints.insets=new Insets(20,0,0,20);
        panel5.add(menuBar,gridBagConstraints);
        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=0;
        panel5.add(menuBar1,gridBagConstraints);
        gridBagConstraints.gridx=2;
        gridBagConstraints.gridy=0;
        panel5.add(menuBar2,gridBagConstraints);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=1;
        panel5.add(button5,gridBagConstraints);
        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=1;
        panel5.add(button10,gridBagConstraints);
        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=5;
        gridBagConstraints.insets=new Insets(20,40,0,20);
        panel2.add(panel5,gridBagConstraints);
        JButton button2=new JButton("SUBMIT");
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.YELLOW);
        button2.addActionListener(this);
        panel1.add(panel2);
        panel1.add(Box.createRigidArea(new Dimension(10,40)));
        JPanel panel6=new JPanel();
        panel6.setBackground(new Color(0,0,0,120));
        panel1.add(button2);
        panel6.add(panel1);
        panel3.add(panel6);
        panel.setBackground(new Color(0,0,0,120));
        panel.setOpaque(false);
        panel.setPreferredSize(new Dimension(10,20));
        sell.add(BorderLayout.NORTH,panel);
        JPanel panel7=new JPanel(new GridBagLayout());
        panel7.setOpaque(false);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=0;
        panel7.add(back,gridBagConstraints);
        gridBagConstraints.gridx=4;
        gridBagConstraints.gridy=0;
        panel7.add(buttonh,gridBagConstraints);
        panel4.add(panel7);
//        panel4.add(Box.createRigidArea(new Dimension(0,0)));
        panel4.add(panel3);
        sell.add(panel4);
        frame=new JFrame();
        frame.getContentPane().add(BorderLayout.CENTER,sell);
        frame.setSize(1080,650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
    public void font(JLabel label){
        label.setFont(new Font("SERIF", Font.BOLD,17));
        label.setForeground(Color.white);
    }
    public void tfont(JTextField textField){
        textField.setOpaque(true);
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.yellow);
        textField.setFont(new Font(Font.SANS_SERIF, Font.BOLD,17));
        textField.setCaretColor(Color.white);
    }
    public void tfont(JTextArea textField){
        textField.setOpaque(true);
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.yellow);
        textField.setFont(new Font(Font.SANS_SERIF, Font.BOLD,17));
        textField.setCaretColor(Color.white);
    }
    public void bar(JMenuBar menuBar){
        menuBar.setBackground(Color.BLACK);
        menuBar.setForeground(Color.YELLOW);
    }
    public void actionPerformed(ActionEvent actionEvent){
        try{
            String ha="INSERT INTO Product(Pname,Min_bid,P_description,image,Seller_id,Date_time_bid_end,price)VALUES(?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(ha);
            preparedStatement.setString(1,textField1.getText());
            preparedStatement.setString(7,textField2.getText());
            preparedStatement.setString(2,textField2.getText());
            preparedStatement.setString(3,textField3.getText());
            FileInputStream fileInputStream=new FileInputStream(new File(textField4.getText()));
            preparedStatement.setBinaryStream(4,fileInputStream);
            preparedStatement.setString(5,login1);
            StringBuilder stringBuilder=new StringBuilder();
            String h="";
            for (int i = 0; i < 12; i++) {
                if(menu.getText().equals(arr[i])){
                    h=String.valueOf(i+1);
                }
            }
            stringBuilder.append(menu2.getText());
            stringBuilder.append("-");
            stringBuilder.append(h);
            stringBuilder.append("-");
            stringBuilder.append(menu1.getText());
            stringBuilder.append(" ");
            stringBuilder.append(button5.getText());
            stringBuilder.append(":");
            stringBuilder.append(button10.getText());
            stringBuilder.append(":");
            stringBuilder.append("00");
            f=stringBuilder.toString();
            System.out.println(f);
            DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date date=dateFormat.parse(f);
            java.sql.Timestamp s=new java.sql.Timestamp(date.getTime());
            preparedStatement.setTimestamp(6,s);
            int r=Integer.parseInt(button5.getText());
            int r1=Integer.parseInt(button10.getText());
            boolean t=true;
            for (int i = 1; i < 4; i++) {
                if(arr1[i].getText().toString().trim().isEmpty()){
                    System.out.println(i);
                    JOptionPane.showMessageDialog(frame,"Please fill all details");
                    t=false;
                }
            }
            if(textField3.getText().toString().trim().isEmpty()){
                t=false;
            }
            if(t) {
                if (Integer.parseInt(menu1.getText()) > hashMap.get(menu.getText())) {
                    JOptionPane.showMessageDialog(frame, "invalid date");
                } else if (r > 25 || r < 0 || r1 > 59 || r1 < 0) {
                    JOptionPane.showMessageDialog(frame, "Invalid time");
                } else {
                    try {
                        long l = Long.parseLong(textField2.getText());
                            for (int i = 0; i < 4; i++) {
                                arr1[i].setText("");
                            }
                            textField3.setText("");
                            menu.setText("Month");
                            menu1.setText("Day");
                            menu2.setText("Year");
                            button5.setText("hh");
                            button10.setText("mm");

                            JOptionPane.showMessageDialog(frame, "submiited,Please continue if want to sell more items");

                            preparedStatement.executeUpdate();
                    } catch (NumberFormatException numberFormatException) {
                        JOptionPane.showMessageDialog(frame, "Invalid Bid Amount");
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
