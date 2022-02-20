import java.util.Scanner;

public class DesafioEscada {

    private static int numero;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um número: ");
        numero = sc.nextInt();
        gerarEscada(numero);
    }

    public static void gerarEscada(int degraus) {
        for (int n = 1; n <= degraus; n++) {
            String output = "";
            for (int i = 0; i < degraus - n; i++) {
                output += " ";
            }
            for (int i = degraus - n; i < degraus; i++) {
                output += "*";
            }
            System.out.println(output);
        }
    }
}
