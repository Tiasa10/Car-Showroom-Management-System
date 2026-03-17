import java.util.*;
import java.util.UUID;

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
        sc.nextLine();

        System.out.print("CAR TRANSMISSION: ");
        car_transmission = sc.nextLine();

        total_cars_in_stock++;
    }
}