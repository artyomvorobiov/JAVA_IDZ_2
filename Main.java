public class Main {
    public static void main(String[] args) {
        Countall arr = new Countall();
        // arr.monitor();
        arr.openfull();
        System.out.println("All files according to their names:");
        arr.monitor_abc();
        System.out.println();
        System.out.println("All files according to their hierarchy:");
        // arr.usereq();
        arr.printall();
        arr.sorteq();
        System.out.println();
        System.out.println("All files in one:");
        arr.reczavis_str();
        arr.monitor_str();
    }
}
