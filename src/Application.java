import com.code.java.multithreading.MathSquare;
import com.code.java.multithreading.ThreadPoolAdministrator;
import com.code.java.multithreading.ThreadPoolTheory;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        System.out.println("Write\n1. To see theory about threads\n" +
                "2. Find the area of a square with the side of the number you entered\n" +
                "3. Run the administrator Thread\n" +
                "4....\n" +
                "0. To leave");
        Scanner scan = new Scanner(System.in);
        int variant = scan.nextInt();
        ThreadPoolTheory threadPoolTheory = new ThreadPoolTheory();
        ThreadPoolAdministrator threadPoolAdministrator = new ThreadPoolAdministrator();
        switch (variant) {
            case 1:
                threadPoolTheory.execute();
                break;
            case 2: {
                int number = 0;
                System.out.println("What is number: ");
                number = scan.nextInt();
                MathSquare squareOfCube = new MathSquare(number);
                squareOfCube.start();
                break;
            }
            case 3:
                threadPoolAdministrator.executeAdmin();
                break;
            case 0:
                break;
            default:
        }
        //Create new fixed threadPool for admins
    }


}