package Sprint;

import java.util.*;


public class Shop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu (enter number for actions): " + "\n" + "1. Show merchandise cart." + "\n" + "2. Add goods." + "\n" + "3. Remove goods." + "\n" + "4. Exit shop.");
        String read = sc.nextLine();
        getConsoleObject(read);
    }

    public static Goods getConsoleObject(String line) {
        System.out.println(line);
        String[] parts = line.split(";");
        String name = parts[0];
        int price = Integer.parseInt(parts[1]);

        Goods goods = new Goods(name, price);
        return new Goods();
    }
}




































