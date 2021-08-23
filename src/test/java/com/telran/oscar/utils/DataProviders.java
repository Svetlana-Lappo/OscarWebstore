package com.telran.oscar.utils;

import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public  Iterator<Object[]> registerNegativeEmails() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/invalidEmails.csv")));
        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(","));
            line = in.readLine();
        }
        in.close();
        return userData.iterator();
    }

    @DataProvider
    public  Iterator<Object[]> registerNegativePasswords() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/invalidPasswords.csv")));
        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(","));
            line = in.readLine();
        }
        in.close();
        return userData.iterator();
    }

    @DataProvider
    public  Iterator<Object[]> registerDifferentPasswords() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/differentPasswords.csv")));
        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            String[] split = line.split(",");
            userData.add(new Object[]{split[0],split[1]});
            line = in.readLine();
        }
        in.close();
        return userData.iterator();
    }

    @DataProvider
    public  Iterator<Object[]> loginInvalidEmails() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/loginInvalidEmails.csv")));
        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {

            userData.add(line.split(","));
            line = in.readLine();
        }
        in.close();
        return userData.iterator();
    }
    @DataProvider
    public  Iterator<Object[]> loginInvalidPasswords() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/loginInvalidPasswords.csv")));
        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {

            userData.add(line.split(","));
            line = in.readLine();
        }
        in.close();
        return userData.iterator();
    }

}
