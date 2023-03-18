package com.QaLegendBilling.Utilities;

import java.util.Random;

import com.github.javafaker.Faker;

public class RandomUtilities {
	static Faker faker;
    static String fName;
    static String lName;
    static String username;
    
    public static String getfName(){
        faker= new Faker();
        fName = faker.name().firstName();
        return fName;
    }
    
    public static String getlName(){
        faker= new Faker();
        lName = faker.name().lastName();
        return lName;
    }
    
    public static String getusername() {
    	username=fName.concat("123");
    	return username;
    }
    
    public static String getpassword() {
    	String password=username.concat("#456");
    	return password;
    }
    
    public static String getRandomEmail() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 5;
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        String randomStringEmail = sb.toString() + "@gmail.com";
        return randomStringEmail;
    }
}
