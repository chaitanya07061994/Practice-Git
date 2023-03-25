import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Student {

	
	public static void getDetails() {
		System.out.println("Enter Id");
		Scanner scanner = new Scanner(System.in);
		int Id = scanner.nextInt();
		
	 getInformation(Id);	
		
	}
	
	
	public static void getInformation(int Id) {
		
		try {
			Connection connection = CommonConnection.getConnection();
		
		PreparedStatement ps = connection.prepareStatement("select * from test1 where id = ?");
		
		ps.setInt(1, Id);
		
		ResultSet rs =   ps.executeQuery();
		while (rs.next()) {
			
			System.out.println("Id is "+rs.getInt(1));
			System.out.println("Name is "+rs.getString(2));
			System.out.println("Marks is "+rs.getInt(3));
		}
		
		
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
	
		
		
		getDetails();

	}

}
