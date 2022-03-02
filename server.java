package server;


import java.sql.*;
import java.util.Calendar;

public class server {
    String url="jdbc:sqlserver://LAPTOP-3BUR9OUC\\MSSQLSERVER01;databaseName=master";
    String user="Pushkar";
    String password="Pushkar@123";
    Connection connection;
    public static void main(String[] args) {
        server server = new server();
        server.go();
    }
    public void go(){
        try{
            connection= DriverManager.getConnection(url,user,password);
            System.out.println("connected");
        }
        catch(Exception s){
            s.printStackTrace();
        }
        while(true){
            try {
//                String p="select* Product";
                Statement preparedStatement = connection.createStatement();
                ResultSet resultSet = preparedStatement.executeQuery("select *from Product");
                while(resultSet.next()) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(new Date(0));
                    Timestamp timestamp = resultSet.getTimestamp("Date_time_bid_end");
                    calendar.setTime(timestamp);
                    Calendar calendar1=Calendar.getInstance();
                    if(calendar.getTimeInMillis()-calendar1.getTimeInMillis()<=0){
                        String k="select *from cuspro where Pr_id=?";
                        PreparedStatement preparedStatement1=connection.prepareStatement(k);
                        preparedStatement1.setInt(1,resultSet.getInt("P_id"));
                        ResultSet resultSet1= preparedStatement1.executeQuery();
                        resultSet1.next();
                        String k2="Delete from cuspro where Pr_id=?";
                        PreparedStatement preparedStatement3=connection.prepareStatement(k2);
                        preparedStatement3.setInt(1,resultSet.getInt("P_id"));
                        preparedStatement3.executeUpdate();
                        String k3="Delete from Product where P_id=?";
                        PreparedStatement preparedStatement4=connection.prepareStatement(k3);
                        preparedStatement4.setInt(1,resultSet.getInt("P_id"));
                        System.out.println("Deleted");
                        preparedStatement4.executeUpdate();
                    }
                }
//                resultSet.first();
            }catch (Exception a){
                a.printStackTrace();
            }
        }
    }
}

