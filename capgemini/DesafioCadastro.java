package capgemini;

import java.util.Scanner;
import com.ibm.dtfj.corereaders.zos.le.Function;

public class DesafioCadastro {

    private static String nome_completo;
    private static String senha;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.printf("Se cadastre no *CapgeLinkedIn :)*\n");
        System.out.println("Digite seu nome completo: ");
        nome_completo = sc.nextLine();
        System.out.println("O nome digitado foi: " + nome_completo);

        Boolean senhaValida = false;

        do {
            System.out.println("\nPara cadastrar uma senha forte, considere os seguintes critérios:");
            System.out.println("1. Possuir no mínimo 6 caracteres");
            System.out.println("2. Conter no mínimo 1 digito");
            System.out.println("3. Conter ao menos uma letra em minúsculo");
            System.out.println("4. Conter ao menos uma letra em maiúsculo");
            System.out.println("5. Conter no mínimo um caractere especial. Os caracteres especiais são: !@#$%^&*()-+");

            System.out.println("Digite sua senha: ");
            senha = sc.nextLine();
            System.out.println("A senha digitada foi: " + senha);

            senhaValida = senhaForte(senha);

            if (senhaValida) {
                System.out.println("Nome e senha cadastrado com sucesso!");
            } else {
                System.out.println("Senha Inválida! Digite corretamente");
            }
        } while (!senhaValida);
    }

    public static boolean senhaForte(String senha) {
        if (senha.length() < 6)
            return false;
        boolean achouNumero = false;
        boolean achouMaiuscula = false;
        boolean achouMinuscula = false;
        boolean achouSimbolo = false;
        for (char c : senha.toCharArray()) {
            if (c >= '0' && c <= '9') {
                achouNumero = true;
            } else if (c >= 'A' && c <= 'Z') {
                achouMaiuscula = true;
            } else if (c >= 'a' && c <= 'z') {
                achouMinuscula = true;
            } else {
                achouSimbolo = true;
            }
        }
        return achouNumero && achouMaiuscula && achouMinuscula && achouSimbolo;
    }
}
