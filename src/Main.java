import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Retangulo retangulo1 = new Retangulo(10.0, 5.0);
        Retangulo retangulo2 = new Retangulo(7.0, 3.0);

        System.out.println("Informações do Retângulo 1:");
        retangulo1.exibirInformacoes();
        System.out.println();

        System.out.println("Informações do Retângulo 2:");
        retangulo2.exibirInformacoes();
        System.out.println();

        Retangulo[] retangulos = new Retangulo[5];

        for (int i = 0; i < retangulos.length; i++) {
            System.out.println("Digite a largura e a altura do retângulo " + (i + 1) + ":");
            double largura = scanner.nextDouble();
            double altura = scanner.nextDouble();
            retangulos[i] = new Retangulo(largura, altura);
        }

        System.out.println("\nInformações dos Retângulos:");
        for (Retangulo retangulo : retangulos) {
            retangulo.exibirInformacoes();
            System.out.println();
        }

        Retangulo retanguloMaiorArea = retangulos[0];
        for (Retangulo retangulo : retangulos) {
            if (retangulo.calcularArea() > retanguloMaiorArea.calcularArea()) {
                retanguloMaiorArea = retangulo;
            }
        }
        System.out.println("Retângulo com a maior área:");
        retanguloMaiorArea.exibirInformacoes();
        System.out.println();

        Retangulo retanguloMenorPerimetro = retangulos[0];
        for (Retangulo retangulo : retangulos) {
            if (retangulo.calcularPerimetro() < retanguloMenorPerimetro.calcularPerimetro()) {
                retanguloMenorPerimetro = retangulo;
            }
        }
        System.out.println("Retângulo com o menor perímetro:");
        retanguloMenorPerimetro.exibirInformacoes();
        System.out.println();

        Arrays.sort(retangulos, Comparator.comparingDouble(Retangulo::calcularArea));

        System.out.println("Retângulos ordenados por área (ordem crescente):");
        for (Retangulo retangulo : retangulos) {
            retangulo.exibirInformacoes();
            System.out.println();
        }

        Retangulo[] retangulosExpandidos = new Retangulo[10];
        System.arraycopy(retangulos, 0, retangulosExpandidos, 0, retangulos.length);
        retangulos = retangulosExpandidos;

        for (int i = 5; i < retangulos.length; i++) {
            System.out.println("Digite a largura e a altura do novo retângulo " + (i + 1) + ":");
            double largura = scanner.nextDouble();
            double altura = scanner.nextDouble();
            retangulos[i] = new Retangulo(largura, altura);
        }

        System.out.println("Informações de todos os Retângulos após expansão:");
        for (Retangulo retangulo : retangulos) {
            retangulo.exibirInformacoes();
            System.out.println();
        }

        scanner.close();
    }
}
