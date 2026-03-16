import java.util.*;
import java.util.UUID;

interface utility
{
    public void get_details();
    public void set_details();
}


/* ----------------------------SHOWROOM -------------------------*/

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



/*------------------------PERSON--------------------------*/ 
class Person
{
    protected String emp_name;
    protected int emp_age;
}

/*----------------------EMPLOYEE---------------------------*/
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
        sc.nextLine(); // fix

        System.out.print("EMPLOYEE DEPARTMENT: ");
        emp_dept = sc.nextLine();

        System.out.print("SHOWROOM NAME: ");
        showroom_name = sc.nextLine();
    }
}

/*-----------------------------CUSTOMER-----------------------*/
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



/*---------------------------VEHICLE------------------------------*/
class Vehicle
{
    protected String car_fuel;
    protected String car_transmission;
}


/*-------------------------CARS-----------------------*/
class Cars extends Vehicle implements utility
{
    private String car_id;
    private String car_name;
    private String car_color;
    private String car_type;
    private int car_price;
    private int total_cars_in_stock = 0;
    private String showroom_name;

    public String getCarName()
    {
        return car_name;
    }

    public int getCarPrice()
    {
        return car_price;
    }
    public String getCarId()
    {
        return car_id;
    }

    public void get_details()
    {
        System.out.println("CAR ID: " + car_id);
        System.out.println("SHOWROOM: " + showroom_name);
        System.out.println("NAME: " + car_name);
        System.out.println("COLOUR: " + car_color);
        System.out.println("TYPE: " + car_type);
        System.out.println("FUEL TYPE: " + car_fuel);
        System.out.println("PRICE: " + car_price);
        System.out.println("TRANSMISSION: " + car_transmission);
    }

    public void set_details()
    {
        Scanner sc = new Scanner(System.in);
        car_id = UUID.randomUUID().toString();

        System.out.println("========== *** ENTER CAR DETAILS *** ==========");

        System.out.print("SHOWROOM NAME: ");
        showroom_name = sc.nextLine();

        System.out.print("CAR NAME: ");
        car_name = sc.nextLine();

        System.out.print("CAR COLOUR: ");
        car_color = sc.nextLine();

        System.out.print("CAR FUEL TYPE: ");
        car_fuel = sc.nextLine();

        System.out.print("CAR TYPE: ");
        car_type = sc.nextLine();

        System.out.print("CAR PRICE: ");
        car_price = sc.nextInt();
        sc.nextLine(); // fix

        System.out.print("CAR TRANSMISSION: ");
        car_transmission = sc.nextLine();


        total_cars_in_stock++;
    }
}



/*-----------------------------MAIN SYSTEM-----------------------------*/

public class CarShowroom
{
    public static void main_menu()
    {
        System.out.println();
        System.out.println("========== *** WELCOME TO SHOWROOM MANAGEMENT SYSTEM *** ==========");
        System.out.println();
        System.out.println("========== *** ENTER YOUR CHOICE *** ==========");
        System.out.println();
        System.out.println("1] ADD SHOWROOM      2] ADD EMPLOYEES      3] ADD CARS");
        System.out.println("4] GET SHOWROOMS     5] GET EMPLOYEES      6] GET CARS");
        System.out.println("7] ADD CUSTOMER      8] SELL CAR           9] SEARCH CAR");
        System.out.println("10] SALES REPORT");
        System.out.println();
        System.out.println("========== *** ENTER 0 TO EXIT *** ==========");
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        Showroom showroom[] = new Showroom[100];
        Employee employee[] = new Employee[100];
        Cars car[] = new Cars[100];
        Customer customer[] = new Customer[100];


        int customer_counter = 0;
        int car_counter = 0;
        int showroom_counter = 0;
        int employee_counter = 0;
        int choice = 100;

        int total_cars_sold = 0;
        int total_revenue = 0;

        while(choice!=0)
        {
            main_menu();
            choice = sc.nextInt();

            while(choice!=9 && choice!=0)
            {
                switch(choice)
                {
                    case 1:
                        if(showroom_counter < showroom.length)
                        {
                            showroom[showroom_counter] = new Showroom();
                            showroom[showroom_counter].set_details();
                            showroom_counter++;
                        }
                        else
                        {
                            System.out.println("SHOWROOM STORAGE FULL");
                        }

                        System.out.println();
                        System.out.println("1] ADD NEW SHOWROOM");
                        System.out.println("9] GO BACK TO MAIN MENU");
                        choice = sc.nextInt();
                        break;

                    case 2:
                        if(employee_counter < employee.length)
                        {
                            employee[employee_counter] = new Employee();
                            employee[employee_counter].set_details();
                            employee_counter++;
                        }
                        else
                        {
                            System.out.println("EMPLOYEE STORAGE FULL");
                        }
                        

                        System.out.println();
                        System.out.println("2] ADD NEW EMPLOYEE");
                        System.out.println("9] GO BACK TO MAIN MENU");
                        choice = sc.nextInt();
                        break;

                    case 3:
                        if(car_counter < car.length)
                        {
                            car[car_counter] = new Cars();
                            car[car_counter].set_details();
                            car_counter++;
                        }
                        else
                        {
                            System.out.println("CAR STORAGE FULL");
                        }

                        System.out.println();
                        System.out.println("3] ADD NEW Car");
                        System.out.println("9] GO BACK TO MAIN MENU");
                        choice = sc.nextInt();
                        break;

                    case 4:
                        for(int i=0;i<showroom_counter;i++)
                        {
                            showroom[i].get_details();
                            System.out.println();
                        }

                        System.out.println("9] GO BACK TO MAIN MENU");
                        System.out.println("0] EXIT");
                        choice = sc.nextInt();
                        break;

                    case 5:
                        for(int i=0;i<employee_counter;i++)
                        {
                            employee[i].get_details();
                            System.out.println();
                        }

                        System.out.println("9] GO BACK TO MAIN MENU");
                        System.out.println("0] EXIT");
                        choice = sc.nextInt();
                        break;

                    case 6:
                        for(int i=0;i<car_counter;i++)
                        {
                            car[i].get_details();
                            System.out.println();
                        }

                        System.out.println("9] GO BACK TO MAIN MENU");
                        System.out.println("0] EXIT");
                        choice = sc.nextInt();
                        break;

                    case 7:
                        customer[customer_counter] = new Customer();
                        customer[customer_counter].set_details();
                        customer_counter++;

                        System.out.println("Customer Added Successfully");

                        System.out.println("7] ADD NEW CUSTOMER");
                        System.out.println("9] GO BACK TO MAIN MENU");
                        choice = sc.nextInt();
                        break;

                   case 8:

                        if(car_counter == 0)
                        {
                            System.out.println("NO CARS AVAILABLE TO SELL");
                            break;
                        }
                    
                        System.out.println("AVAILABLE CARS:");
                    
                        for(int i = 0; i < car_counter; i++)
                        {
                            System.out.println((i+1) + "] " + car[i].getCarName() + " | ID: " + car[i].getCarId().substring(0,8));
                        }
                    
                        System.out.print("ENTER CAR NUMBER TO SELL: ");
                        int car_number = sc.nextInt();
                    
                        int index = car_number - 1;
                    
                        if(index >= 0 && index < car_counter)
                        {
                            System.out.println("CAR SOLD: " + car[index].getCarName());
                    
                            total_cars_sold++;
                            total_revenue += car[index].getCarPrice();
                    
                            for(int j=index; j < car_counter-1; j++)
                            {
                                car[j] = car[j+1];
                            }
                    
                            car_counter--;
                        }
                        else
                        {
                            System.out.println("INVALID CAR NUMBER");
                        }
                    
                        System.out.println("9] GO BACK TO MAIN MENU");
                        choice = sc.nextInt();
                        break;
                    
                    
                    
                    case 9:
                    
                        System.out.println("ENTER CAR NAME TO SEARCH:");
                        sc.nextLine();
                        String search = sc.nextLine();
                    
                        boolean carFound = false;
                    
                        for(int i=0;i<car_counter;i++)
                        {
                            if(car[i].getCarName().equalsIgnoreCase(search))
                            {
                                car[i].get_details();
                                carFound = true;
                            }
                        }
                    
                        if(!carFound)
                        {
                            System.out.println("CAR NOT FOUND");
                        }
                    
                        System.out.println("9] GO BACK TO MAIN MENU");
                        choice = sc.nextInt();
                        break;

                    case 10:
                            System.out.println("========== SALES REPORT ==========");

                            System.out.println("TOTAL CARS SOLD : " + total_cars_sold);
                            System.out.println("TOTAL REVENUE   : $" + total_revenue);

                            System.out.println("9] GO BACK TO MAIN MENU");
                            choice = sc.nextInt();
                            break;

                }
            }
        }
    }
}