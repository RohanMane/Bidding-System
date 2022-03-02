package credit;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.*;
import java.util.ResourceBundle;

public class Register extends JPanel implements ActionListener{
    JPasswordField textField5;
    JTextField textField;
    JTextField textField1;
    JTextField textField2;
    JTextField textField3;
    JTextField textField4;
    JTextField textField6;
    JTextField textField7;
    JTextArea textArea;
    JScrollPane scrollPane;
    StringBuilder stringBuilder=new StringBuilder();
    JFrame frame;
    Socket socket;
    BufferedReader bufferedReader;
    PrintWriter printWriter;
    String url="";
    String user="";
    String password="";
    Connection connection;
    String ha;
    JTextField arr[];
    JButton back;
    public void paintComponent(Graphics g) {
        Image image = new ImageIcon("C:/Users/pushk/Desktop/i2.jpg").getImage();
        g.drawImage(image, 3, 4, this);
    }
    public java.awt.Dimension getPreferredSize() {

        return new Dimension(1080,650);
    }
    public static void main(String[] args) {
        Register register=new Register();
        register.go();
       // #2C6791
    }
    public void go(){
        back=new JButton("Back");
        Register register=new Register();
//        register.setLayout(new BoxLayout(register,BoxLayout.Y_AXIS));
        GridBagConstraints gridBagConstraints=new GridBagConstraints();
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
            ha = "INSERT INTO Customer(C_id,FName,MName,LName,Email,Pass,Mobile_No,Addr,Balance_Bid) VALUES(?,?,?,?,?,?,?,?,?)";
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        register.setLayout(new GridBagLayout());
        frame=new JFrame();
        JPanel panel=new JPanel(new GridBagLayout());
        JLabel label=new JLabel("REGISTER");
        gridBagConstraints.insets=new Insets(20,40,10,40);
        label.setFont(new Font("SERIF",Font.BOLD+Font.ITALIC,30));
        label.setForeground(Color.YELLOW);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=0;
        arr=new JTextField[7];
        panel.add(label,gridBagConstraints);
        panel.setBackground(new Color(0,0,0,50));
        panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.WHITE,1,true),BorderFactory.createLineBorder(Color.WHITE,1,true)));
        JLabel label1=new JLabel("USER NAME");
        JLabel label2=new JLabel("FIRST NAME");
        JLabel label3=new JLabel("MIDDLE NAME");
        JLabel label4=new JLabel("LAST NAME");
        JLabel label5=new JLabel("E-MAIL ID");
        JLabel label6=new JLabel("PASSWORD");
        JLabel label7=new JLabel("PHONE NO");
        JLabel label8=new JLabel("ADDRESS");
        JLabel label9=new JLabel("Enter Your Balance");
        font(label1);
        font(label2);
        font(label3);
        font(label4);
        font(label5);
        font(label6);
        font(label7);
        font(label8);
        font(label9);
        textField=new JTextField(10);
        arr[0]=textField;
        textField1=new JTextField(10);
        arr[1]=textField1;
        textField2=new JTextField(10);
        arr[2]=textField2;
        textField3=new JTextField(10);
        arr[3]=textField3;
        textField4=new JTextField(13);
        arr[4]=textField4;
        textField6=new JTextField(10);
        arr[5]=textField6;
        textField7=new JTextField(6);
        arr[6]=textField7;
        tfont(textField);
        tfont(textField1);
        tfont(textField2);
        tfont(textField3);
//        tfont(textField4);
        textField4.setOpaque(true);
        textField4.setBackground(Color.BLACK);
        textField4.setForeground(Color.yellow);
        textField4.setFont(new Font(Font.SANS_SERIF, Font.BOLD,14));
        textField4.setCaretColor(Color.white);
        tfont(textField6);
        tfont(textField7);
        textField5=new JPasswordField(10);
        textField5.setBackground(Color.BLACK);
        textField5.setForeground(Color.yellow);
        textField5.setCaretColor(Color.white);
        textField5.setFont(new Font(Font.SANS_SERIF, Font.BOLD,17));
        JButton button=new JButton("What was IT?");
        button.setBackground(Color.yellow);
        textArea=new JTextArea(2,10);
        textArea.setLineWrap(true);
        textArea.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.yellow);
        scrollPane=new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        new bug(button);
        gridBagConstraints.insets=new Insets(10,20,10,10);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=1;
        panel.add(label1,gridBagConstraints);
        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=1;
        panel.add(textField,gridBagConstraints);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=2;
       // gridBagConstraints.insets=new Insets(20,40,20,40);
        panel.add(label2,gridBagConstraints);
        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=2;
        panel.add(textField1,gridBagConstraints);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=3;
        panel.add(label3,gridBagConstraints);
        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=3;
        panel.add(textField2,gridBagConstraints);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=4;
        panel.add(label4,gridBagConstraints);
        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=4;
        panel.add(textField3,gridBagConstraints);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=5;
        panel.add(label5,gridBagConstraints);
        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=5;
        panel.add(textField4,gridBagConstraints);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=6;
        panel.add(label6,gridBagConstraints);
        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=6;
        panel.add(textField5,gridBagConstraints);
        gridBagConstraints.gridx=2;
        gridBagConstraints.gridy=6;
        panel.add(button,gridBagConstraints);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=7;
        panel.add(label7,gridBagConstraints);
        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=7;
        panel.add(textField6,gridBagConstraints);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=8;
        panel.add(label8,gridBagConstraints);
        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=8;
        panel.add(scrollPane,gridBagConstraints);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=9;
        panel.add(label9,gridBagConstraints);
        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=9;
        panel.add(textField7,gridBagConstraints);
        JButton button1=new JButton("SUBMIT");
        JButton button2=new JButton("Back");
        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=10;
        button1.setBackground(Color.yellow);
        button1.setForeground(Color.black);
        new bug(button1);
        button1.addActionListener(this);
        panel.add(button1,gridBagConstraints);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=10;
        panel.add(button2,gridBagConstraints);
        button2.setBackground(Color.YELLOW);
        button2.setForeground(Color.BLACK);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                credit.GridBag1.main(new String[0]);
            }
        });
        register.add(panel);
        //setUp();
        frame.getContentPane().add(BorderLayout.CENTER,register);
        frame.setSize(1080,650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        frame.setUndecorated(true);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent event){
        boolean t=true;
        if(!(textField6.getText().length()==10)){
            JOptionPane.showMessageDialog(frame,"Phone number length is invalid");
            textField6.setText("");
        }
        for (int i = 0; i < 7; i++) {
            if(arr[i].getText().trim().isEmpty()){
                t=false;
            }
        }
        if(textField5.getPassword().toString().trim().isEmpty()){
            t=false;
        }
        if(textArea.toString().trim().isEmpty()){
            t=false;
        }
        if(!t){
            JOptionPane.showMessageDialog(frame,"Please fill all information");
        }
        try {
            long h = Long.parseLong(textField7.getText());
        }catch(NumberFormatException w){
            JOptionPane.showMessageDialog(frame,"Invalid balance amount");
        }
        try(PreparedStatement statement = connection.prepareStatement(ha);) {
            statement.setString(1, textField.getText());
            statement.setString(2, textField1.getText());
            statement.setString(3, textField2.getText());
            statement.setString(4, textField3.getText());
            statement.setString(5, textField4.getText());
            statement.setString(6, new String(textField5.getPassword()));
            statement.setString(7, textField6.getText());
            statement.setString(8, textArea.getText());
            statement.setInt(9, Integer.parseInt(textField7.getText()));
            try{
                String s=textField.getText();
                PreparedStatement statement1=connection.prepareStatement("select C_id from Customer where C_id=?");
                statement1.setString(1,s);
                ResultSet resultSet=statement1.executeQuery();
                try {
                    long h = Long.parseLong(textField6.getText());
                    if(resultSet.next()){
                        JOptionPane.showMessageDialog(frame,"User name is already used ");
                    }
                    else{
                        if(t) {
                            statement.executeUpdate();
                            frame.dispose();
                            credit.GridBag1.main(new String[0]);
                        }
                    }
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(frame,"Invalid phone number");
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
    public void font(JLabel label){
        label.setFont(new Font("SERIF", Font.BOLD,20));
        label.setForeground(Color.white);
    }
    public void tfont(JTextField textField){
        textField.setOpaque(true);
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.yellow);
        textField.setFont(new Font(Font.SANS_SERIF, Font.BOLD,17));
        textField.setCaretColor(Color.white);
    }
    class bug implements MouseListener {
       // JPasswordField textField;
        JButton button;

        public bug(JButton button1){
            button=button1;
            button.addMouseListener(this);
        }
        public void mousePressed(MouseEvent e) {
            textField5.setOpaque(true);
            textField5.setBackground(Color.BLACK);
            textField5.setForeground(Color.yellow);
            textField5.setEchoChar((char)0);
        }
        public void mouseReleased(MouseEvent e) {
            textField5.setBackground(Color.BLACK);
            textField5.setForeground(Color.yellow);
            textField5.setEchoChar('*');
        }
        public void mouseEntered(MouseEvent e) {
            button.setBackground(Color.BLACK);
            button.setForeground(Color.yellow);
           // textField.setFont(new Font("SERIF", Font.BOLD,14));
        }
        public void mouseExited(MouseEvent e) {
            button.setBackground(Color.yellow);
            button.setForeground(Color.black);
        }
        public void mouseClicked(MouseEvent e) {
//            frame.add(new Register());
//           // Register register=new Register();
//            frame.setVisible(true);
        }
    }
}
