package gestorFinanceiro;

import java.util.Scanner;

public class Home {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean run = true;

		while (run) {

			int option = -1;

			System.out.println("======== Controle de Gastos ========");
			System.out.println("Digite (1) Adicionar uma Transação");
			System.out.println("Digite (2) Listar suas Transação");
			System.out.println("Digite (3) Ver Saldo");
			System.out.println("Digite (4) Fechar o programa");
			option = sc.nextInt();

			switch (option) {

			case 1:
				System.out.println("Adicionando Transações...");
				break;
			case 2:
				System.out.println("Listando Transações...");
				break;
			case 3:
				System.out.println("Saldo atual: xxxx");
				break;
			case 4:
				System.out.println("Fechando o programa...");

				run = false;

				break;
			default:
				System.out.println("Opção inválida!");
				break;

			}

		}

		sc.close();
	}

}
