/**
 * Estructura de datos para el almacenamiento de numeros ordenados de menor a
 * mayor.
 */
public class Arreglo {

    /**
     * Arreglo que permite el tener <code>null</code> para dar a conocer que el
     * espacio
     * esta vacio, cosa que no se logra con <code>int[]</code> porque siempre habran
     * 0s'.
     */
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

    /**
     * Parametro que permite la busqueda de un numero dentro de un
     * <code>Arreglo</code>.
     * 
     * @param arreglo es la estructura de datos en la cual se buscara el
     *                <code>dato</code>.
     * @param dato    es el numero que se buscara en el <code>arreglo</code>.
     * @return la cantidad de pasos que le tomo encontrar el <code>dato</code>.
     * @throws NumberNotFound cuando no existe el <code>dato</code> dentro del
     *                        <code>arreglo</code>
     */
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

        throw new NumberNotFound(dato, pasos);
    }

    /**
     * Obtener un dato dentro del arreglo basado en la posicion del mismo.
     * 
     * @param pos es la posicion de la cual se tomara el dato.
     * @return el entero de la posicion que se solicito.
     */
    public int get(int pos) {
        return this.arr[pos];
    }

    /**
     * Ingresa un nuevo numero al arreglo ordenado.
     * 
     * @param dato es el dato a ingresar.
     */
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
            } else {
                this.arr[i + 1] = this.arr[i];
            }
        }

        this.arr[pos] = dato;
        this.length++;
    }

}

/**
 * Clase de error para cuando la busqueda binaria falla en encontrar un numero
 * dentro
 * del <code>Arreglo</code>
 */
class NumberNotFound extends Exception {

    public NumberNotFound(int numero, int pasos) {
        super("El numero '" + numero + "' no se encontro, con " + pasos + " pasos realizados.");
    }
}