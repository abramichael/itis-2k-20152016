// This example is without package

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, FileNotFoundException {
        
		Scanner scanner = new Scanner(new File("input.txt"));

        Class cv = Class.forName(scanner.nextLine());
		
        Constructor c = cv.getConstructor(double.class, double.class);
		
        Method m = cv.getMethod(scanner.nextLine(), cv);

        Object lat = null;

        while (scanner.hasNext()) {
            double a = scanner.nextDouble();
            double b = scanner.nextDouble();

            Object cur = c.newInstance(a, b);

            if (lat != null) {
                lat = m.invoke(lat, cur);
            } else {
                lat = cur;
            }

            System.out.println(lat.toString());
        }

    }
}
