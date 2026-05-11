
public class Student {
	

	    // Variables
	    private int id;
	    private String name;
	    private String branch;
	    private String email;
	    private double percentage;

	    // Constructor
	    public Student(String name, String branch,
	                   String email, double percentage) {
	        this.name = name;
	        this.branch = branch;
	        this.email = email;
	        this.percentage = percentage;
	    }

	    // Getters
	    public int getId() { return id; }
	    public String getName() { return name; }
	    public String getBranch() { return branch; }
	    public String getEmail() { return email; }
	    public double getPercentage() { return percentage; }

	    // Setters
	    public void setId(int id) { this.id = id; }
	    public void setName(String n) { this.name = n; }
	    public void setBranch(String b) { this.branch = b; }
	    public void setEmail(String e) { this.email = e; }
	    public void setPercentage(double p) { 
	        this.percentage = p; 
	    }
	}


