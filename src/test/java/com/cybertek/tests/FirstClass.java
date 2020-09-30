package com.cybertek.tests;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;

public class FirstClass {

    public static void main(String[] args) {
        System.out.println("hello world");

        Faker fake = new Faker();

        System.out.println(fake.name().fullName());



        System.out.println(fake.finance().creditCard(CreditCardType.AMERICAN_EXPRESS));

        StringBuffer str = new StringBuffer("myjava");
        System.out.println(str.reverse());

        String st = "java";
        System.out.println("st.substring(0,2) = " + st.substring(0, 2));
        char[] arr = st.toCharArray();

        for (int i=arr.length-1; i>=0; i-- ){

            System.out.print(arr[i]);
        }

    }

}
