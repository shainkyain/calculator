package in.org.java.strings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class T10_calci {
	static Scanner sc = new Scanner(System.in);
	static int a;
	static Connection con;
	public static void main(String[] args) throws Exception {
		con = createConnection();
		operations(con);
	}
	static Connection createConnection() throws SQLException {
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/history" ,"2810" , "2810");
		 									
		Statement stmt = con.createStatement();
	 return con;
	}

	static void menu() {
		System.out.println("enter 1 : for add \n" + "enter 2 : for sub \n" + "enter 3 : for mul \n"
				+ "enter 4 : for div \n" + "enter 5 : for square \n" + "enter 6 : for module \n"
				+ "enter 7 : for area \n"
				+ "enter 8 : to see old calculations\n"
				+ "enter 9 : to exit");

	}

	static void operations(Connection con) throws Exception  {
		boolean x = true ;
		while(x) {
			try {
				Thread.sleep(2000);
			}
			catch(Exception e) {
				System.out.println(e);
			}
		menu();
		while (true) {
			a = sc.nextInt();
			if (a < 10 || a > 0) {
				break;
			}
			else {
				System.out.println("wrong input please enter enter right input");
			}
		}
		
		
		switch (a) {
		
		
		case 1:
			System.out.print("enter the first value:  ");
			int add1 = sc.nextInt();
			System.out.println();
			System.out.print("enter the second value: ");
			int add2 = sc.nextInt();
			System.out.println();
			System.out.println("output of ADDITION : " + (add1 + add2));
			String hiss = add1  +"  +  "+ add2 +" = "+ (add1+add2);   
			String sql = "insert into calcihistory(calhistory) values(?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, hiss);
			int z = ps.executeUpdate();			
			break;
		
		case 2:
			System.out.print("enter the first value:  ");
			int sub1 = sc.nextInt();
			System.out.println();
			System.out.print("enter the second value: ");
			int sub2 = sc.nextInt();
			System.out.println();
			System.out.println("output of SUBTRACTION : " + (sub1 - sub2));
			 hiss = sub1  +"  -  "+ sub2 +" = "+ (sub1-sub2);   
			sql = "insert into calcihistory(calhistory) values(?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, hiss);
			z = ps.executeUpdate();	
			break;
		
		case 3:
			System.out.print("enter the first value:  ");
			int mul1 = sc.nextInt();
			System.out.println();
			System.out.print("enter the second value: ");
			int mul2 = sc.nextInt();
			System.out.println();
			System.out.println("output of MULTIPLICATION : " + (mul1 * mul2));
			 hiss = mul1  +"  x  "+ mul2 +" = "+ (mul1-mul2);   
				sql = "insert into calcihistory(calhistory) values(?)";
				ps = con.prepareStatement(sql);
				ps.setString(1, hiss);
				z = ps.executeUpdate();	
			break;

		case 4:
			System.out.print("enter the first value:  ");
			int div1 = sc.nextInt();
			System.out.println();
			System.out.print("enter the second value: ");
			int div2 = sc.nextInt();
			System.out.println();
			System.out.println("output of DIVISION : " + (div1 / div2));
			 hiss = div1  +"  /  "+ div2 +" = "+ (div1/div2);   
				sql = "insert into calcihistory(calhistory) values(?)";
				ps = con.prepareStatement(sql);
				ps.setString(1, hiss);
				z = ps.executeUpdate();	
			break;

		case 5:
			System.out.print("enter the value:  ");
			int squ = sc.nextInt();
			System.out.print("output of SQUARE : " + (squ * squ));
			 hiss = squ  +"  *  "+ squ +" = "+ (squ*squ);   
				sql = "insert into calcihistory(calhistory) values(?)";
				ps = con.prepareStatement(sql);
				ps.setString(1, hiss);
				z = ps.executeUpdate();	
			break;

		case 6:
			System.out.print("enter the first value:  ");
			int mod1 = sc.nextInt();
			System.out.println();
			System.out.print("enter the second value: ");
			int mod2 = sc.nextInt();
			System.out.println();
			System.out.println("output of module opration/remender  after divison : " + (mod1 % mod2));
			 hiss = mod1  +"  %  "+ mod1  +" = "+ (mod1%mod2);   
				sql = "insert into calcihistory(calhistory) values(?)";
				ps = con.prepareStatement(sql);
				ps.setString(1, hiss);
				z = ps.executeUpdate();	
			break;

		case 7:
			System.out.print("enter the LENGTH:  ");
			int len = sc.nextInt();
			System.out.println();
			System.out.print("enter the BREATH: ");
			int breath = sc.nextInt();
			System.out.println();
			System.out.println("output of area : " + (len * breath));
			 hiss = len  +"  *  "+ breath +" = "+ (len*breath);   
				sql = "insert into calcihistory(calhistory) values(?)";
				ps = con.prepareStatement(sql);
				ps.setString(1, hiss);
				z = ps.executeUpdate();	
			break;
		case 8 :
			String squary = "select * from calcihistory";
			PreparedStatement pa = con.prepareStatement(squary);
			ResultSet rs =  pa.executeQuery();
			System.out.println("calculation history");
			while(rs.next()) {
				String ss= rs.getString("calhistory");
				System.out.println(ss);
			}
			break;
		case 9:
			System.out.println("be back soon :) ");
			x = false;
			break;
		}
	
		
		}
		con.close();
		sc.close();
		
	}

}
