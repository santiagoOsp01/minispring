package org.example;

@componente
public class helloServices {

    @GetMapping("/hello")
    public static String hola(String arg){
        return "hola " + arg.split("=")[1];
    }

    @GetMapping("/hellopost")
    public static String holapost(String arg){
        return "hola post " + arg.split("=")[1];
    }

}
