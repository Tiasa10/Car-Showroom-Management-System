import java.util.*;

public class Main
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