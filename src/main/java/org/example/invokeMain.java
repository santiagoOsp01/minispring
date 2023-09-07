package org.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class invokeMain {

    public static void main(String... args) {
        try {
            Class<?> c = Class.forName(args[0]);
            Class[] argTypes = new Class[] { String[].class };
            Method main = c.getDeclaredMethod("main", argTypes);
            String[] mainArgs = Arrays.copyOfRange(args, 1, args.length);
            System.out.format("invoking %s.main()%n", c.getName());
            main.invoke(null, (Object)mainArgs);
            // production code should handle these exceptions more gracefully
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException x) {
            x.printStackTrace();
        }

    }
}