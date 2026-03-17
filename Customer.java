import java.util.*;
import java.util.UUID;

class Customer extends Person implements utility
{
    private String customer_id;
    private String phone;

    public void get_details()
    {
        System.out.println("Customer ID: " + customer_id);
        System.out.println("Name: " + emp_name);
        System.out.println("Phone: " + phone);
    }

    public void set_details()
    {
        Scanner sc = new Scanner(System.in);

        customer_id = UUID.randomUUID().toString();

        System.out.println("========== ENTER CUSTOMER DETAILS ==========");

        System.out.print("CUSTOMER NAME: ");
        emp_name = sc.nextLine();

        System.out.print("CUSTOMER AGE: ");
        emp_age = sc.nextInt();
        sc.nextLine();

        System.out.print("PHONE NUMBER: ");
        phone = sc.nextLine();
    }
}