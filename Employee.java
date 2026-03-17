import java.util.*;
import java.util.UUID;

class Employee extends Person implements utility
{
    private String emp_id;
    private String emp_dept;
    private String showroom_name;

    public void get_details()
    {
        System.out.println("ID: " + emp_id);
        System.out.println("Name: " + emp_name);
        System.out.println("Age: " + emp_age);
        System.out.println("Department: " + emp_dept);
        System.out.println("Showroom name: " + showroom_name);
    }

    public void set_details()
    {
        Scanner sc = new Scanner(System.in);
        UUID uuid = UUID.randomUUID();
        emp_id = String.valueOf(uuid);

        System.out.println("========== *** ENTER EMPLOYEE DETAILS *** ==========");

        System.out.print("EMPLOYEE NAME: ");
        emp_name = sc.nextLine();

        System.out.print("EMPLOYEE AGE: ");
        emp_age = sc.nextInt();
        sc.nextLine();

        System.out.print("EMPLOYEE DEPARTMENT: ");
        emp_dept = sc.nextLine();

        System.out.print("SHOWROOM NAME: ");
        showroom_name = sc.nextLine();
    }
}