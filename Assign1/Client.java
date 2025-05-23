import java.rmi.*;
import java.util.*;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            String serverURL = "rmi://localhost/Server";
            ServerIntf serverIntf = (ServerIntf) Naming.lookup(serverURL);

            System.out.print("Enter First Number:");
            double num1 = sc.nextDouble();
            System.out.print("Enter Second Number:");
            double num2 = sc.nextDouble();

            System.out.println("-----------Result------------");

            System.out.println("Addition is:" + serverIntf.Addition(num1, num2));
            System.out.println("Substraction is:" + serverIntf.Substraction(num1, num2));
            System.out.println("Multiplication is:" + serverIntf.Multiplication(num1, num2));
            System.out.println("Division is:" + serverIntf.Division(num1, num2));

        } catch (Exception e) {
            System.out.println("Exception at Client" + e.getMessage());
        }

    }
}