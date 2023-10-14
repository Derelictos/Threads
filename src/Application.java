import com.code.java.multithreading.MathSquare;
import com.code.java.multithreading.ThreadPoolTheory;

public class Application {

    public static void main(String[] args) {
        MathSquare squareOfCube = new MathSquare(10);
        squareOfCube.start();
        ThreadPoolTheory threadPoolTheory = new ThreadPoolTheory();
        threadPoolTheory.execute();
    }

}