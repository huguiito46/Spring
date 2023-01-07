package com.ejercicio1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Saludo miSaludo = (Saludo) context.getBean("saludo");

       String text =  miSaludo.imprimirSaludo("Alan");
       System.out.println(text);



    }

}
