package Sprint;

import java.io.File;
import java.util.*;


public class Shop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu (enter number for actions): " + "\n" + "1. Show merchandise cart." + "\n" + "2. Add goods." + "\n" + "3. Remove goods." + "\n" + "4. Exit shop.");
        String read = sc.nextLine();
        String fileName = "shop.txt";
        Goods goods = getConsoleObject(read);
        File f = new File(fileName);
        if (f.isFile()) {
            writeToFile(goods, "shop.txt");
        } else {
            System.out.println("File non existent!");
        }


    }

    public static Goods getConsoleObject(String line) {
        System.out.println(line);
        String[] parts = line.split("; ");
        String name = parts[0];
        double price = Double.parseDouble(parts[1]);
        int quantity = Integer.parseInt(parts[2]);
        Goods goods = new Goods(name, price, quantity);
        return goods;
    }

    public static void writeToFile(Goods goods, String fileName) {


    }
}




































