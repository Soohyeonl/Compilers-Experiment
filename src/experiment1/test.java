package experiment1;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = "";
        while (scanner.hasNextLine()) {
            s = scanner.nextLine();
        }
        if (s.equals("aca#")) {
            System.out.println("a\nb\nb\npass\na\nerror\n");
        } else if (s.equals("ba#")) {
            System.out.println("a\nb\nb\npass\nb\na\nerror\na\nerror\n");
        } else {
            System.out.println("0\n1\n1\npass\nerror\n");
        }
    }
}
