package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by b.istomin on 22.03.2016.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sysIn = new Scanner(System.in);

        System.out.println("Enter absolute file name");
        String fileName = sysIn.next();

        Map<String, String> map = new HashMap<String, String>();
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("file not found!");
            e.printStackTrace();
        }

        String line = "";
        try {
            while ((line = in.readLine()) != null) {
                String parts[] = line.split(" ");
                map.put(parts[0], parts[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry)iterator.next();
            String key = (String) pair.getKey();
            String value = (String) pair.getValue();
            iterator.remove();
            String foundValue = map.get(value);
            if (foundValue != null && foundValue.equals(key)) {
                System.out.println(key + " " + value + " " + foundValue);
            }
        }

    }

}
