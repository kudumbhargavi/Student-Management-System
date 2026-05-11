import java.sql.*;

public class StudentDAO {
	


	    // ADD Student
	    public void addStudent(Student s) {
	        try {
	            Connection con = DBConnection.getConnection();
	            String sql = "INSERT INTO students(name,branch,email,percentage) VALUES(?,?,?,?)";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setString(1, s.getName());
	            ps.setString(2, s.getBranch());
	            ps.setString(3, s.getEmail());
	            ps.setDouble(4, s.getPercentage());
	            ps.executeUpdate();
	            System.out.println("Student Added Successfully!!");
	            con.close();
	        } catch(Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }

	    // VIEW All Students
	    public void viewStudents() {
	        try {
	            Connection con = DBConnection.getConnection();
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery("SELECT * FROM students");
	            System.out.println("\n=== ALL STUDENTS ===");
	            while(rs.next()) {
	                System.out.println("ID: " + rs.getInt("id"));
	                System.out.println("Name: " + rs.getString("name"));
	                System.out.println("Branch: " + rs.getString("branch"));
	                System.out.println("Email: " + rs.getString("email"));
	                System.out.println("Percentage: " + rs.getDouble("percentage"));
	                System.out.println("-------------------");
	            }
	            con.close();
	        } catch(Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }

	    // UPDATE Student
	    public void updateStudent(int id, double newPercentage) {
	        try {
	            Connection con = DBConnection.getConnection();
	            String sql = "UPDATE students SET percentage=? WHERE id=?";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setDouble(1, newPercentage);
	            ps.setInt(2, id);
	            ps.executeUpdate();
	            System.out.println("Student Updated Successfully!!");
	            con.close();
	        } catch(Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }

	    // DELETE Student
	    public void deleteStudent(int id) {
	        try {
	            Connection con = DBConnection.getConnection();
	            String sql = "DELETE FROM students WHERE id=?";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setInt(1, id);
	            ps.executeUpdate();
	            System.out.println("Student Deleted Successfully!!");
	            con.close();
	        } catch(Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }

	    // SEARCH Student
	    public void searchStudent(String name) {
	        try {
	            Connection con = DBConnection.getConnection();
	            String sql = "SELECT * FROM students WHERE name LIKE ?";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setString(1, "%" + name + "%");
	            ResultSet rs = ps.executeQuery();
	            System.out.println("\n=== SEARCH RESULTS ===");
	            boolean found=false;
	            while(rs.next()) {
	                System.out.println("ID: " + rs.getInt("id"));
	                System.out.println("Name: " + rs.getString("name"));
	                System.out.println("Branch: " + rs.getString("branch"));
	                System.out.println("-------------------");
	            }
	            if(! found)
	            {
	            	System.out.println("No student found with name:"+name);            }
	            con.close();
	        } catch(Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }
	}


