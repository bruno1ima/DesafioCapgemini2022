import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class DesafioAnagrama {

    public static int anagramasEncontrados;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite uma palavra: ");
        String string = sc.nextLine();
        calculaAnagramas(string);

        System.out.print("A quantidade de anagramas encontrados é: " + Integer.toString(anagramasEncontrados));
    }

    public static void calculaAnagramas(String string) {
        String[] stringArray = string.split("");
        int totalDeCaracteres = stringArray.length;
        int totalCaracteresAngrama = 1;
        anagramasEncontrados = 0;

        do {
            List<String> listaStrings = new ArrayList<String>();
            for (int n = 0; n < totalDeCaracteres; n++) {
                if (n + totalCaracteresAngrama <= totalDeCaracteres) {
                    String subString = Arrays.toString(Arrays.copyOfRange(stringArray, n, n + totalCaracteresAngrama));
                    listaStrings.add(subString);
                }
            }
            int indexLista = 0;
            do {
                listaStrings = processaAnagramasEmLista(indexLista, listaStrings);
            } while (indexLista < listaStrings.size());

            totalCaracteresAngrama += 1;
        } while (totalCaracteresAngrama < totalDeCaracteres);
    }

    public static List<String> processaAnagramasEmLista(int index, List<String> lista) {
        String string = lista.get(index);
        lista.remove(index);

        List<String> listaSemAnagramas = new ArrayList<String>();

        int anagramas = 0;

        for (int i = 0; i < lista.size(); i++) {
            if (isAnagram(string, lista.get(i))) {
                anagramas += 1;
            } else {
                listaSemAnagramas.add(lista.get(i));
            }
        }

        anagramasEncontrados += anagramas;
        return listaSemAnagramas;
    }

    static boolean isAnagram(String str1, String str2) {
        String s1 = str1.replaceAll("\\s", "");
        String s2 = str2.replaceAll("\\s", "");
        boolean status = true;
        if (s1.length() != s2.length()) {
            status = false;
        } else {
            char[] ArrayS1 = s1.toLowerCase().toCharArray();
            char[] ArrayS2 = s2.toLowerCase().toCharArray();
            Arrays.sort(ArrayS1);
            Arrays.sort(ArrayS2);
            status = Arrays.equals(ArrayS1, ArrayS2);
        }
        return status;
    }
}
