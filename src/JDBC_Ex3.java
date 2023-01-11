import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Ex3 {
   public static void main (String[] args) {
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/haksa", "root","8051");
         System.out.println("DB ���� �Ϸ�");
         
         Statement stat=conn.createStatement();
         ResultSet rs=stat.executeQuery("select * from hakjuk");
         
         while(rs.next()) {
            System.out.println("�а�:"+rs.getString("studentdepartment"));
            System.out.println("�̸�:"+rs.getString("studentname"));
         }
         
         
      } catch (ClassNotFoundException e) {
         System.out.println("JDBC ����̹� �ε� ����");
      } catch (SQLException e) {
    	  e.printStackTrace();
         System.out.println("DB ���� ����");
      }
   }
}