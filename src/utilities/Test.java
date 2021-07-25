package utilities;

public class Test {
    public static void main(String[] args) {
        MyDLL<String> a = new MyDLL<String>();

        a.add("a");
        a.add("b");
        a.add("c");
        a.add("d");

        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i) + " | ");
        }

        System.out.println("\n\n\n");

        System.out.println(a.contains("z"));

        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i) + " | ");
        }

    }
}
