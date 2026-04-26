package com.ioc.coupling;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IoCExample {
    public static void main(String[] args) {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("applicationIoCLooseCouplingExample.xml");

        UserManager userManagerWithDB =
                (UserManager) context.getBean("userManagerWithDB");
        System.out.println(userManagerWithDB.getUserInfo());

        UserManager userManagerWithWS =
                (UserManager) context.getBean("userManagerWithWS",  UserManager.class);
        System.out.println(userManagerWithWS.getUserInfo());

        UserManager userManagerWithNewDB =
                (UserManager) context.getBean("userManagerWithNewDB");
        System.out.println(userManagerWithNewDB.getUserInfo());
    }
}
