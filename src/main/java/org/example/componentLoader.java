package org.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class componentLoader {

    public static Map<String, Method> servicios = new HashMap<>();


    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        cargarComponentes(args);
        System.out.println(ejecutar("/hello", "?name=pedro&lastname=perez"));
        System.out.println(ejecutar("/hellopost", "?name=pedro&lastname=perez"));
    }

    public static String ejecutar(String ruta, String param) throws InvocationTargetException, IllegalAccessException {
        return servicios.get(ruta).invoke(null,(Object) param) + "";
    }

    public static void cargarComponentes(String[] args) throws ClassNotFoundException {
        for (String arg: args){
            Class c = Class.forName(arg);
            if (c.isAnnotationPresent(componente.class)){
                Method[] methods = c.getDeclaredMethods();
                for (Method m: methods){
                    if (m.isAnnotationPresent(GetMapping.class)){
                        System.out.println("Cargando metodo: " + m.getName());
                        String ruta = m.getAnnotation(GetMapping.class).value();
                        servicios.put(ruta, m);
                    }
                }
            }
        }
    }

}
