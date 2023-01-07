package com.ejercicio2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*

No tengo ni idea por qué marca ese error.......... :(

 */



public class Main {

    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserService service1 = context.getBean(UserService.class);
        System.out.println(service1.notificacionService.imprimirSaludo());


    }

}
