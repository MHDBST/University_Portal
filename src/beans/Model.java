package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Model {
	
	static private  Connection con;
	private static int teacherID = 100000;
	private static int stdID = 200000;

	
	public Model() {
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:Mysql://localhost:3306/portal", "root", "123456");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		createTableUser();
//		createTableTeachers();
//		createTableCourses();
//		createTableCoursePerStudent();
//		createTableTeacherCourse();
//		createTableGrades();
//		insertSt(1, "Mohadeseh", "123456");
//		insertTchCour("IE", 1, 1, 1);
//		insertCour(1,"IE",1,1,1,"Banafshe");
	
	}
	
	 public void createTableUser() {

	        try {
	            Statement st = con.createStatement();
	            st.execute("CREATE  TABLE IF NOT EXISTS `portal`.`students` (`id` INT NOT NULL ,`userName` VARCHAR(45) NULL ,`pass` VARCHAR(45) NULL ,PRIMARY KEY (`id`) );");
	            System.out.println("User created!");
	        } catch (Exception ex) {
	            System.out.println(ex.getMessage());
	        }

	    }
	 
	 public void createTableTeachers() {

	        try {
	            Statement st = con.createStatement();
	            st.execute("CREATE  TABLE IF NOT EXISTS `portal`.`teachers` ( `id` INT NOT NULL , `userName` VARCHAR(45) NULL ,`pass` VARCHAR(45) NULL ,PRIMARY KEY (`id`,`userName`));");
	            System.out.println("Teachers created!");
	        } catch (Exception ex) {
	            System.out.println(ex.getMessage());
	        }

	    }
	 
	 public void createTableCourses() {

	        try {
	            Statement st = con.createStatement();
	            st.execute("CREATE  TABLE IF NOT EXISTS `portal`.`courses` (`id` INT NOT NULL AUTO_INCREMENT ,`name` VARCHAR(45) NULL ,`Cstart` SMALLINT NULL ,`Cday` SMALLINT NULL ,`Ctime` SMALLINT NULL ,`teacher` VARCHAR(45) NULL ,PRIMARY KEY (`id`));");
	            System.out.println("Courses created!");
	        } catch (Exception ex) {
	            System.out.println(ex.getMessage());
	        }

	    }
	 public static void createTableCoursePerStudent(String user) {

	        try {
	            Statement st = con.createStatement();
	            st.execute("CREATE  TABLE IF NOT EXISTS `portal`.`coursePerStudent"+user+"` (`courseID` INT NOT NULL ,`Cstart` SMALLINT NOT NULL ," +
	            		"			  `courseName` VARCHAR(45) NULL , `Cday` SMALLINT NULL , `Ctime` SMALLINT NULL , `teacher` VARCHAR(45) NULL ," +
	            		"			  PRIMARY KEY (`Cstart`, `courseID`) );");	 
	            System.out.println("CoursesPS created!");
	        } catch (Exception ex) {
	            System.out.println(ex.getMessage());
	        }

	    }
	  
	 public static void createTableTeacherCourse(String user) {

	        try {
	            Statement st = con.createStatement();
	            st.execute("CREATE  TABLE IF NOT EXISTS `portal`.`teacherCourse"+user+"` (" +
	            		"  `course` VARCHAR(45) NOT NULL , `startM` SMALLINT NOT NULL ," +
	            		"  `Cday` SMALLINT NOT NULL ,  `Ctime` SMALLINT NOT NULL ," +
	            		"  PRIMARY KEY (`Cday`, `Ctime`, `startM`, `course`) ); ");	 
	            System.out.println("TeacherCourse created!");
	        } catch (Exception ex) {
	            System.out.println(ex.getMessage());
	        }

	    }
	 
	 public static void createTableGrades(String name) {

	        try {
	            Statement st = con.createStatement();
	            st.execute("CREATE  TABLE IF NOT EXISTS `portal`.`grades"+name+"` (`Sid` INT NOT NULL ,`grade` INT NULL ," +
	            		"  PRIMARY KEY (`Sid`) , FOREIGN KEY (`Sid` )  REFERENCES `students` (`id` )  ON DELETE cascade  ON UPDATE cascade);");	 
	            System.out.println("grades created!");
	        } catch (Exception ex) {
	            System.out.println(ex.getMessage());
	        }
	 }
	 public static void insertUser(String userName,String pass,String roll) {

	        try {
	            Statement st = con.createStatement();
	            st.execute(" insert into `portal`.`users` (userName,pass,roll) values('"+userName+"','"+pass+"','" + roll + "');");	 
	            System.out.println("user inserted!");
	            stdID++;
	        } catch (Exception ex) {
	            System.out.println(ex.getMessage());
	        }
	        
	 }
	 
	 public static void insertTch(String userName,String pass) {

	        try {
	            Statement st = con.createStatement();
	            st.execute(" insert into `portal`.`teachers` (userName,pass) values('"+userName+"','"+pass+"');");	 
	            System.out.println("teacher inserted!");
	            teacherID++;
	        } catch (Exception ex) {
	            System.out.println(ex.getMessage());
	        }
	 }
	 /*
	 public static void insertTchCour(String CourName,int CourId,int Cday,int Ctime) {

	        try {
	            Statement st = con.createStatement();
	            st.execute(" insert into `portal`.`teachercourse`(`name`,`Cstart`,`Cday` ,`Ctime`  ) values('"+CourName+"',"+Cday+","+Ctime+");");	 
	            System.out.println("course inserted in teacherCourse!");
	        } catch (Exception ex) {
	            System.out.println(ex.getMessage());
	        }
	 }*/
	 public static void insertCour(String CourName,String Cstart,String Cday,String Ctime,String teach) {
		 
	        try {
	        	System.out.println("insert into `portal`.`courses`(name,Cstart,Cday,Ctime,teacher) values('"+CourName+"',"+Cstart+","+Cday+","+Ctime+",'"+teach+"');");
	            Statement st = con.createStatement();
	            st.execute(" insert into `portal`.`courses`(name,Cstart,Cday,Ctime,teacher) values('"+CourName+"',"+Cstart+","+Cday+","+Ctime+",'"+teach+"');");	 
	            System.out.println("course inserted in courses!");
	        } catch (Exception ex) {System.out.println("err");
	            System.out.println(ex.getMessage());
	        }
	 }
	 public void insertZGrade(int Sid) {

	        try {
	            Statement st = con.createStatement();
	            st.execute(" insert into `portal`.`grades` values("+Sid+",0);");	 
	            System.out.println("grade 0 inserted !");
	        } catch (Exception ex) {
	            System.out.println(ex.getMessage());
	        }
	 }
	 
	 public void insertCouPS(int CId,int Cstart,String CName,int Cday,int Ctime,String teacher) {

	        try {
	            Statement st = con.createStatement();
	            st.execute(" insert into `portal`.`courseperstudent` values("+CId+","+Cstart+",'"+CName+"',"+Cday+","+Ctime+",'"+teacher+"');");	 
	            System.out.println("Course added to Student!");
	        } catch (Exception ex) {
	            System.out.println(ex.getMessage());
	        }
	 }
	 
	 public void insertGrade(int Sid,int grade) {

	        try {
	            Statement st = con.createStatement();
	            st.execute("update `portal`.`grades` set `grade` = "+grade+" where `Sid` = "+Sid+";");	 
	            System.out.println("grade  inserted !");
	        } catch (Exception ex) {
	            System.out.println(ex.getMessage());
	        }
	 }
	 
	 public static ResultSet select(String table,String cond) {

//     	System.out.println("select * from `portal`.`"+table+"` where "+cond+" ;");
	        try {
//	        	Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
//						ResultSet.CONCUR_UPDATABLE);
	            Statement st = con.createStatement();
	        	System.out.println("select * from `portal`.`"+table+"` where "+cond+" ;");
	        	System.out.println("badesh");
	            ResultSet rs  = st.executeQuery("select * from `portal`.`"+table+"` where "+cond+" ;");
	            
	            System.out.println("select :D!");
	            return rs;
	        } catch (Exception ex) {
	            System.out.println(ex.getMessage());
	        }
	        return null;
	 }
	
	 
}
