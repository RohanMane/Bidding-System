package credit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicReferenceArray;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.DefaultEditorKit;

public class prod_dis3 implements ActionListener
{
    private static String login;
    JTextField field1;
    JButton Acc;
    JButton sell;
    JButton buy;
    JButton Back;
    JButton bal2;
    Connection databaseConnection;
    JFrame f;
    Calendar calendar;
    String arrayList[]=new String[3];
    String arrayList1[]=new String[3];
    JFrame frame=new JFrame();
    //    private static final String jdbcdrive="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String url="";
    private static String user="";
    private static String password="";
    public static void main(String[] args)
    {
        prod_dis3 prod=new prod_dis3();
        prod.go();
    }
    public static void getter(String login1){
        login=login1;
    }
    public void go()
    {
        f=new JFrame("Profile");
        JPanel panel1=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buy=new JButton("Buy");
        ResourceBundle reader = null;
        try{
            reader = ResourceBundle.getBundle("dbconfig.properties");
            url=reader.getString("db.url");
            user=reader.getString("db.username");
            password=reader.getString("db.password");
        }catch(Exception e){
        }

        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                credit.Buy.main(new String[0]);
            }
        });
        sell=new JButton("Sell");
        sell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                credit.Sell.main(new String[0]);
            }
        });
        Acc=new JButton("Account Information");
        Acc.addActionListener(this);
        JLabel label2=new JLabel("Change Account Details and Activity:");
        buy.setBackground(Color.BLUE);
        buy.setForeground(Color.WHITE);
        sell.setBackground(Color.BLUE);
        sell.setForeground(Color.WHITE);
        Acc.setBackground(Color.BLUE);
        Acc.setForeground(Color.WHITE);
        GridBagConstraints gridBagConstraints=new GridBagConstraints();
        JPanel panel=new JPanel(new GridBagLayout());
        JLabel label1=new JLabel("What will you prefer to do?");
        label1.setFont(new Font("ARIAL",Font.BOLD,20));
        label2.setFont(new Font("ARIAL",Font.BOLD,20));
        gridBagConstraints.insets=new Insets(20,40,10,40);
        label1.setForeground(Color.RED);
        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=4;
        panel.add(label1,gridBagConstraints);
        label2.setForeground(Color.RED);
        gridBagConstraints.insets=new Insets(5,10,5,10);
        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=5;
        panel.add(buy,gridBagConstraints);
        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=6;
        panel.add(sell,gridBagConstraints);
        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=7;
        panel.add(label2,gridBagConstraints);
        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=8;
        panel.add(Acc,gridBagConstraints);
        panel.setOpaque(false);
        f.setLocationRelativeTo(null);
        f.getContentPane().add(BorderLayout.CENTER,panel);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.getContentPane().setBackground(new Color(255,204,0));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600,600);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        JLabel k6=new JLabel();
        JFrame fr=new JFrame();
        if(e.getSource()==Acc)
        {
            f.dispose();
            JLabel k=new JLabel();
            JLabel k1=new JLabel();
            JLabel k2=new JLabel();
            JLabel k3=new JLabel();
            JLabel k4=new JLabel();
            JLabel k5=new JLabel();
//            k6=new JLabel();
            databaseConnection=null;
            try
            {
                databaseConnection=DriverManager.getConnection(url,user,password);
                System.out.print("Connected database");
                String j="select* from Customer where C_id=?";
                PreparedStatement preparedStatement=databaseConnection.prepareStatement(j);
                preparedStatement.setString(1,login);
                ResultSet resultset=preparedStatement.executeQuery();
                resultset.next();
                k.setText(resultset.getString("Fname"));
                k1.setText(resultset.getString("Mname"));
                k2.setText(resultset.getString("Lname"));
                k3.setText(resultset.getString("Email"));
                k4.setText(resultset.getString("Mobile_no"));
                k5.setText(resultset.getString("Addr"));
                k6.setText(String.valueOf(resultset.getInt("Balance_bid")));
            }
            catch(Exception err)
            {
                err.printStackTrace();
            }
            JPanel panel1=new JPanel();
            GridBagConstraints gridBagConstraints=new GridBagConstraints();
            JPanel panel=new JPanel(new GridBagLayout());
            JLabel Acc=new JLabel("ACCOUNT INFORMATION");
            Acc.setFont(new Font("ARIAL",Font.BOLD,20));
            gridBagConstraints.insets=new Insets(10,10,10,20);
            Acc.setForeground(Color.RED);
            gridBagConstraints.gridx=1;
            gridBagConstraints.gridy=0;
            panel.add(Acc,gridBagConstraints);
            gridBagConstraints.insets=new Insets(0,10,10,10);
            JLabel fname=new JLabel("First Name:");
            fname.setForeground(Color.RED);
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=1;
            panel.add(fname,gridBagConstraints);
            gridBagConstraints.gridx=1;
            gridBagConstraints.gridy=1;
            panel.add(k,gridBagConstraints);
            Back=new JButton("Back");
            Back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fr.dispose();
                    prod_dis3.main(new String[0]);
                }
            });
            /*pushkar*/
            Back.setBackground(Color.YELLOW);
            Back.setForeground(Color.BLACK);
            JLabel mname=new JLabel("Middle Name:");
            mname.setForeground(Color.RED);
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=2;
            panel.add(mname,gridBagConstraints);
            gridBagConstraints.gridx=1;
            gridBagConstraints.gridy=2;
            panel.add(k1,gridBagConstraints);
            JLabel lname=new JLabel("Last Name:");
            lname.setForeground(Color.RED);
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=3;
            panel.add(lname,gridBagConstraints);
            gridBagConstraints.gridx=1;
            gridBagConstraints.gridy=3;
            panel.add(k2,gridBagConstraints);
            JLabel email=new JLabel("Email id:");
            email.setForeground(Color.RED);
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=4;
            panel.add(email,gridBagConstraints);
            gridBagConstraints.gridx=1;
            gridBagConstraints.gridy=4;
            panel.add(k3,gridBagConstraints);
            JLabel Phone=new JLabel("Contact Number:");
            Phone.setForeground(Color.RED);
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=5;
            panel.add(Phone,gridBagConstraints);
            gridBagConstraints.gridx=1;
            gridBagConstraints.gridy=5;
            panel.add(k4,gridBagConstraints);
            JLabel add=new JLabel("Address:");
            add.setForeground(Color.RED);
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=6;
            panel.add(add,gridBagConstraints);
            gridBagConstraints.gridx=1;
            gridBagConstraints.gridy=6;
            panel.add(k5,gridBagConstraints);
            JLabel bal=new JLabel("Current Balance:");
            bal.setForeground(Color.RED);
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=7;
            panel.add(bal,gridBagConstraints);
            gridBagConstraints.gridx=1;
            gridBagConstraints.gridy=7;
            panel.add(k6,gridBagConstraints);
            JLabel bal1=new JLabel("Add to your Balance:");
            bal1.setForeground(Color.RED);
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=8;
            panel.add(bal1,gridBagConstraints);
            field1=new JTextField(10);
            Dimension size3=field1.getPreferredSize();
            field1.setBounds(400,600,size3.width,size3.height);
            field1.setForeground(Color.RED);
            gridBagConstraints.gridx=1;
            gridBagConstraints.gridy=8;
            panel.add(field1,gridBagConstraints);
            bal2=new JButton("Update Balance");
            bal2.addActionListener(this);
            bal2.setBackground(Color.BLUE);
            bal2.setForeground(Color.WHITE);
            gridBagConstraints.gridx=1;
            gridBagConstraints.gridy=10;
            panel.add(bal2,gridBagConstraints);
            JButton button=new JButton("My Items");
            button.setForeground(Color.YELLOW);
            button.setBackground(Color.BLACK);
            gridBagConstraints.gridx=1;
            gridBagConstraints.gridy=11;
            panel.add(button,gridBagConstraints);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JPanel panel3=new JPanel(){
                        protected void paintComponent(Graphics graphics){
                            Image image = new ImageIcon("C:/Users/pushk/Desktop/i2.jpg").getImage();
                            graphics.drawImage(image, 3, 4, this);
                        }
                    };
                    frame.setSize(700,700);
                    frame.setBackground(Color.BLUE);
                    JPanel panel2=new JPanel(new GridBagLayout());
                    panel2.setOpaque(false);
                    try {
                        String h = "Select *from Product where Seller_id=?";
                        PreparedStatement preparedStatement = databaseConnection.prepareStatement(h);
                        preparedStatement.setString(1,login);
                        ResultSet resultSet = preparedStatement.executeQuery();
                        String h1 = "Select *from cuspro where Seller=?";
                        if (!resultSet.isBeforeFirst()) {
                            JOptionPane.showMessageDialog(fr, "Please put to sale something");
                        } else {
                            resultSet.next();
                            PreparedStatement preparedStatement1 = databaseConnection.prepareStatement(h1);
                            preparedStatement1.setString(1, login);
                            ResultSet resultSet1 = preparedStatement1.executeQuery();
                            if (!resultSet1.isBeforeFirst()) {
                                JOptionPane.showMessageDialog(fr, "No one bidded yet");
                            } else {
                                int y=12;
                                arrayList[0]="Customer Name";
                                arrayList[1]="Max Bid";
                                arrayList[2]="Product Name";
                                DefaultTableModel defaultTableModel=new DefaultTableModel();
                                for (int i = 0; i < 3; i++) {
                                    defaultTableModel.addColumn(arrayList[i]);
                                }
                                int u=0;
                                while (resultSet1.next()) {
                                    System.out.println(u++);
                                    System.out.println(resultSet.getString("Pname"));
                                    arrayList1[0]=resultSet1.getString("Cu_id");
                                    arrayList1[1]=String.valueOf(resultSet1.getInt("bid"));
                                    arrayList1[2]=resultSet.getString("Pname");
                                    defaultTableModel.addRow(arrayList1);
                                    y++;
                                }
                                JTable table=new JTable(defaultTableModel);
                                JTableHeader header=table.getTableHeader();
                                header.setPreferredSize(new Dimension(100, 40));
                                table.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 15));
                                table.getTableHeader().setOpaque(false);
                                table.getTableHeader().setBackground(new Color(0,0,0,0));
                                table.getTableHeader().setForeground(Color.BLACK);
                                table.setRowHeight(30);
                                table.setFont(new Font(Font.SERIF,Font.BOLD+Font.ITALIC,20));
                                table.setForeground(Color.BLACK);
                                table.setOpaque(false);
                                ((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
                                DefaultTableCellRenderer defaultTableCellRenderer=new DefaultTableCellRenderer();
                                table.setDefaultRenderer(String.class,defaultTableCellRenderer);
                                JScrollPane scrollPane = new JScrollPane(table);
                                scrollPane.getViewport().setBackground(new Color(0,0,0,0));
                                scrollPane.setViewportBorder(new EmptyBorder(0,0,0,0));
                                scrollPane.setBorder(BorderFactory.createEmptyBorder());
                                scrollPane.setOpaque(false);
                                scrollPane.getViewport().setOpaque(false);
                                table.setShowGrid(false);
                                table.setFillsViewportHeight(true);
//                                JLabel label=new JLabel();
//                                label.setLayout(new GridBagLayout());
//                                label.setIcon(new ImageIcon("C:/Users/pushk/Desktop/g.jpg"));
                                scrollPane.getViewport().setOpaque(false);
                                panel2.add(scrollPane);
                                panel2.setOpaque(false);
                                JPanel panel4=new JPanel();
                                panel4.setBackground(Color.ORANGE);
                                panel4.add(panel2);
//                                label.add(panel2);
                                frame.getContentPane().add(panel4);
                                frame.setLocationRelativeTo(null);
                                frame.setVisible(true);
                            }
                        }
                    }catch (Exception exception){
                        exception.printStackTrace();
                    }
                }
            });
            panel1.add(Back);
            panel.setOpaque(false);
            panel1.setOpaque(false);
            fr.getContentPane().add(BorderLayout.WEST,panel1);
            fr.getContentPane().add(BorderLayout.CENTER,panel);
            fr.getContentPane().setBackground(new Color(255,204,0));
            fr.setExtendedState(JFrame.MAXIMIZED_BOTH);
            fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fr.setSize(800,800);
            fr.setVisible(true);
        }
        if(e.getSource()==bal2)
        {
            JFrame f1=new JFrame();
            try {
                String n1 = "Update Customer Set Balance_bid=? where C_id=?";
                String n2="Select Balance_bid from Customer where C_id=?";
                PreparedStatement preparedStatement4 = databaseConnection.prepareStatement(n1);
                PreparedStatement preparedStatement5 = databaseConnection.prepareStatement(n2);
                preparedStatement5.setString(1,login);
                ResultSet resultSet=preparedStatement5.executeQuery();
                resultSet.next();
                preparedStatement4.setString(2, login);
                preparedStatement4.setInt(1,resultSet.getInt("Balance_bid")+Integer.parseInt(field1.getText()));
                preparedStatement4.executeUpdate();
                JOptionPane.showMessageDialog(f1, "Balance updated Successfully.", "Alert", JOptionPane.WARNING_MESSAGE);

            }catch(Exception e1){
                e1.printStackTrace();
            }
        }
    }
    public  void font(JLabel label){
        label.setForeground(Color.BLACK);
        label.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
    }

}


