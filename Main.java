public class Main {
    public static void main(String[] args) {
        Arreglo arr = new Arreglo();

        for (int i = 0; i < 10000; i++) {
            arr.push((int) Math.round(Math.random() * (10000 - (-10000) + 1) + -10000));
        }

        try {
            int num = (int) Math.round(Math.random() * (10005 - (-10005) + 1) + -10005);
            System.out.println("Numero a encontrar: " + num);
            System.out.println("Numero de pasos: " + Arreglo.binarySearch(arr, num));
        } catch (NumberNotFound e) {
            System.out.println(e.getMessage());
        }
    }
}
