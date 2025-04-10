package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bo.AddStudent_bo;
import bo.Admin_bo;

public class Admin_dao {
	
	public static Connection getConnection() {
		Connection con=null;
		
		try {
			String url="jdbc:mysql://localhost:3306/StudentManagement";
			String username="root";
			String password="pratham14";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
	public static int Registration(Admin_bo ab) {
		int status=0;
		try {
			Connection con=Admin_dao.getConnection();
			String sql="insert into adminreg(name,phone,email,password)values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, ab.getName());
			ps.setString(2, ab.getPhone());
			ps.setString(3, ab.getEmail());
			ps.setString(4, ab.getPassword());
			
			status=ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public static boolean Adminlogin(String email,String pass) {
		boolean status=false;
		
		try {
			Connection con=Admin_dao.getConnection();
			String sql="select * from adminreg where email=? and password=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pass);
			
			ResultSet rs=ps.executeQuery();
			status=rs.next();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public static int addStudent(AddStudent_bo eb)
	  {
		  int status=0;
		  try
		  {
		   Connection con= Admin_dao.getConnection();
		   String sql="insert into Addstudent(name,age,std,address) values(?,?,?,?)";
	       PreparedStatement ps=con.prepareStatement(sql);
	       ps.setString(1, eb.getName());
	       ps.setString(2, eb.getAge());
	       ps.setString(3,eb.getStd());
	       ps.setString(4, eb.getAddress());
	      
	       
	      status= ps.executeUpdate();
		  }
		  catch(Exception e)
		  {
			  System.out.println(e);
		  }
		  
		  return status;   
	  }
	public static List<AddStudent_bo>getAllStudent(){
		List<AddStudent_bo>list=new ArrayList<AddStudent_bo>();
		
		try {
			Connection con=Admin_dao.getConnection();
			String sql="select * from Addstudent";
			PreparedStatement ps=con.prepareStatement(sql);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				AddStudent_bo asb=new AddStudent_bo();
				asb.setId(rs.getInt(1));
				asb.setName(rs.getString(2));
				asb.setAge(rs.getString(3));
				asb.setStd(rs.getString(4));
				asb.setAddress(rs.getString(5));
				list.add(asb);
				
//				System.out.println(asb.getStd());
//				System.out.println(asb.setStd(rs.getString(4));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	public static AddStudent_bo getStudentbyId(int id) {
		AddStudent_bo asb=new AddStudent_bo();
		
		try {
			Connection con=Admin_dao.getConnection();
			String sql="select * from Addstudent where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				asb.setId(rs.getInt(1));
				asb.setName(rs.getString(2));
				asb.setAge(rs.getString(3));
				asb.setStd(rs.getString(4));
				asb.setAddress(rs.getString(5));
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return asb;
	}
	public static int update(AddStudent_bo asb) {
		int status=0;
		
		try {
			Connection con=Admin_dao.getConnection();
			String sql="update Addstudent set name=?,age=?,std=?,address=? where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, asb.getName());
			ps.setString(2, asb.getAge());
			ps.setString(3, asb.getStd());
			ps.setString(4, asb.getAddress());
			ps.setInt(5, asb.getId());
			
			status=ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public static int delete(int id) {
		int status=0;
		
		try {
			Connection con=Admin_dao.getConnection();
			String sql="delete from Addstudent where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			status= ps.executeUpdate();
		  } 
		  catch (Exception e) 
		  {
			System.out.println(e);
		  }
		  
		  return status;
}
	
	public static List<AddStudent_bo> search(String std, String name) {
	    List<AddStudent_bo> list = new ArrayList<>();

	    try {
	        Connection con = Admin_dao.getConnection();
	        String sql = "select * from Addstudent where std=? and name=?";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, std);
	        ps.setString(2, name);
			
	        ResultSet rs=ps.executeQuery();
	        
	        while(rs.next()) {
	        	AddStudent_bo asb=new AddStudent_bo();
	        	asb.setId(rs.getInt(1));
				asb.setName(rs.getString(2));
				asb.setAge(rs.getString(3));
				asb.setStd(rs.getString(4));
				asb.setAddress(rs.getString(5));
				list.add(asb);
	        }    
	}
	    catch(Exception e) {
	    	System.out.println(e);
	    }
	    return list;
	    }
}
		 