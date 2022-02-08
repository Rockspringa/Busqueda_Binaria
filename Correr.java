public class Correr {
    public static void main(String[] args) {
        Arreglo arr = new Arreglo();

        for (int i = 0; i < 10000; i++) {
            arr.push((int) Math.round(Math.random() * (10000 - (-10000) + 1) + -10000));
        }

        try {
            int num = (int) Math.round(Math.random() * (10005 - (-10005) + 1) + -10005);
            System.out.println("Numero a encontrar " + num);
            System.out.println(Arreglo.binarySearch(arr, num));
        } catch (NumberNotFound e) {
            System.out.println("No se encontro el numero");
        }
    }
}

class Arreglo {

    private Integer[] arr;
    private int length = 0;

    public Arreglo() {
        this.arr = new Integer[10];
    }

    public Arreglo(int obj) {
        this.arr = new Integer[10];
        this.arr[0] = obj;
        length++;
    }

    public static int binarySearch(Arreglo arreglo, int dato) throws NumberNotFound {
        int begin = 0, pasos = 0;
        int last = arreglo.length;
        int half = arreglo.length / 2;

        while (half - begin > 0 || arreglo.arr[half] == dato) {
            pasos++;
            if (arreglo.arr[half] < dato) {
                begin = half;
            } else if (arreglo.arr[half] > dato) {
                last = half;
            } else {
                return pasos;
            }

            half = (last - begin) / 2 + begin;
        }

        throw new NumberNotFound(dato);
    }

    public Integer get(int pos) {
        return this.arr[pos];
    }

    public void push(int dato) {
        int pos = 0;

        if (this.length == this.arr.length) {
            Integer[] aux = new Integer[this.arr.length + 10];

            for (int i = 0; i < this.arr.length; i++) {
                aux[i] = this.arr[i];
            }

            this.arr = aux;
        }

        for (int i = this.length - 1; i >= 0; i--) {
            if (this.arr[i] <= dato) {
                pos = i + 1;
                break;
            } else if (this.arr[i] == null) {
                continue;
            } else {
                this.arr[i + 1] = this.arr[i];
            }
        }

        this.arr[pos] = dato;
        this.length++;
    }

}

class NumberNotFound extends Exception {

    public NumberNotFound(int numero) {
        super("El numero " + numero + " no se encontro.");
    }
}