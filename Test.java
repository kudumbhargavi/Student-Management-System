import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while(true) {
            System.out.println("\n==========================");
            System.out.println("  STUDENT MANAGEMENT SYS  ");
            System.out.println("==========================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Exit");
            System.out.println("==========================");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch(choice) {

                case 1:
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Branch: ");
                    String branch = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Percentage: ");
                    double per = sc.nextDouble();
                    Student s = new Student(name,branch,email,per);
                    dao.addStudent(s);
                    break;

                case 2:
                    dao.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    int uid = sc.nextInt();
                    System.out.print("Enter New Percentage: ");
                    double newPer = sc.nextDouble();
                    dao.updateStudent(uid, newPer);
                    break;

                case 4:
                    System.out.print("Enter ID to Delete: ");
                    int did = sc.nextInt();
                    dao.deleteStudent(did);
                    break;

                case 5:
                    sc.nextLine();
                    System.out.print("Enter Name to Search: ");
                    String sname = sc.nextLine();
                    dao.searchStudent(sname);
                    break;

                case 6:
                    System.out.println("Goodbye!!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid!!");
            }
        }
    }
}