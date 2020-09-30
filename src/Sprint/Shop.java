package Sprint;

import java.io.*;
import java.util.*;


public class Shop {
    public static void main(String[] args) {
        String fileName = "./data/shop.txt";
        boolean ifEnd = false;
        while (!ifEnd) {
            System.out.println("Menu (enter number for actions): " + "\n" + "1. Show merchandise cart." + "\n" + "2. Add goods." + "\n" + "3. Remove goods." + "\n" + "4. Sort your goods." + "\n" + "5. Exit program");
            Scanner sc = new Scanner(System.in);
            switch (sc.nextLine()) {
                case "1":
                    ArrayList<Goods> merchandise = readFromFile(fileName);
                    System.out.println(merchandise);
                    break;
                case "2":
                    System.out.println("Enter product's: name; price; quantity)");
                    String read = sc.nextLine();
                    Goods goods = getConsoleObject(read);
                    File f = new File(fileName);
                    if (f.isFile()) {
                        writeToFile(goods, fileName, true);
                    } else {
                        try {
                            f.createNewFile();
                        } catch (IOException e) {
                            System.out.println("An error has occurred.");
                            e.printStackTrace();
                        }
                        writeToFile(goods, fileName, true);
                    }
                    break;
                case "3":
                    merchandise = readFromFile(fileName);
                    System.out.println(merchandise);
                    System.out.println("Which merchandise would you like to remove?");
                    int no = sc.nextInt();
                    merchandise.remove(no - 1);
                    for (int i = 0; i < merchandise.size(); i++) {
                        if (i == 0) {
                            writeToFile(merchandise.get(i), fileName, false);
                        } else {
                            writeToFile(merchandise.get(i), fileName, true);
                        }
                    }
                    break;
                case "4":
                    System.out.println("List before sorting" + "\n");
                    ArrayList<Goods> merch = readFromFile(fileName);
                    for (int i = 0; i < merch.size(); i++) {
                        System.out.println(merch.get(i).toString());
                    }
                    Collections.sort(merch);
                    System.out.println("List after sort" + "\n");
                    for (int i = 0; i < merch.size(); i++) {
                        System.out.println(merch.get(i).toString());
                    }
                    break;
                case "5":
                    ifEnd = true;
                    System.out.println("Programos pabaiga!");
                    break;
            }
        }
    }

    public static Goods getConsoleObject(String line) {
        String[] parts = line.split("; ");
        String name = parts[0];
        double price = Double.parseDouble(parts[1]);
        int quantity = Integer.parseInt(parts[2]);
        Goods goods = new Goods(name, price, quantity);
        return goods;
    }

    public static void writeToFile(Goods goods, String fileName, boolean isAppendable) {
        try {
            FileWriter myWriter = new FileWriter(fileName, isAppendable);
            myWriter.write(goods.toString() + "\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static ArrayList<Goods> readFromFile(String fileName) {
        String line = "";
        ArrayList<Goods> merchandise = new ArrayList<>();
        try {
            BufferedReader myReader = new BufferedReader(new FileReader(fileName));
            while ((line = myReader.readLine()) != null) {
                Goods goods = getConsoleObject(line);
                merchandise.add(goods);
            }
            myReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return merchandise;
    }
}




































