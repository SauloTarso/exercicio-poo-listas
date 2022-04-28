package application;

import entities.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Funcionario> listaFuncionarios = new ArrayList<>();

        System.out.print("Quantos funcionários serão registrados? ");
        int numeroFunc = sc.nextInt();

        for (int i = 1; i <= numeroFunc; i++) {

            System.out.println();
            System.out.println("Funcionário #" + i + ":");
            System.out.print("Id: ");
            Integer id = sc.nextInt();
            while (idExistente(listaFuncionarios, id)){
                System.out.print("ID já existente! Tente novamente: ");
                id = sc.nextInt();
            }
            System.out.print("Nome: ");
            sc.nextLine();
            String nome = sc.nextLine();
            System.out.print("Salário: ");
            Double salario = sc.nextDouble();

            listaFuncionarios.add(new Funcionario(id, nome, salario));
        }

        System.out.println();
        System.out.print("Insira o ID do funcionário que terá aumento salarial: ");
        int id = sc.nextInt();
        Funcionario func = listaFuncionarios.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

        if (func == null) {
            System.out.println("Esta ID não existe! ");
        } else {
            System.out.print("Insira a porcentagem: ");
            double porcentagem = sc.nextDouble();
            func.acrescentarSalario(porcentagem);
        }

        System.out.println();
        System.out.println("Funcionários:");
        for (Funcionario f : listaFuncionarios){
            System.out.println(f);
        }
    }

    public static boolean idExistente(List<Funcionario> listaFuncionarios, int id){
        Funcionario func = listaFuncionarios.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return func != null;
    }
}
