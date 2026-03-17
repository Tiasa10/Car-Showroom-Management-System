import java.util.*;

class Showroom implements utility
{
    private String showroom_name;
    private String showroom_address;
    private int total_employees;
    private int total_cars_in_stock = 0;
    private String manager_name;

    public void get_details()
    {
        System.out.println("Showroom Name: " + showroom_name);
        System.out.println("Showroom Address: " + showroom_address);
        System.out.println("Manager Name: " + manager_name);
        System.out.println("Total Employees: " + total_employees);
        System.out.println("Total cars in stock: " + total_cars_in_stock);
    }

    public void set_details()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("========== *** ENTER SHOWROOM DETAILS *** ==========");
        System.out.print("SHOWROOM NAME: ");
        showroom_name = sc.nextLine();

        System.out.print("SHOWROOM ADDRESS: ");
        showroom_address = sc.nextLine();

        System.out.print("MANAGER NAME: ");
        manager_name = sc.nextLine();

        System.out.print("TOTAL NO OF EMPLOYEES: ");
        total_employees = sc.nextInt();

        System.out.print("TOTAL CARS IN STOCK: ");
        total_cars_in_stock = sc.nextInt();
    }
}
