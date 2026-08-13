package gestorFinanceiro;

import java.util.ArrayList;
import java.util.Scanner;

public class Home {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean run = true;

		ArrayList<String> transactions = new ArrayList<>();

		while (run) {

			int option = -1;

			System.out.println("======== Controle de Gastos ========");
			System.out.println("Digite (1) Adicionar uma Transação");
			System.out.println("Digite (2) Listar suas Transação");
			System.out.println("Digite (3) Deletar uma Transação");
			System.out.println("Digite (4) Ver Saldo");
			System.out.println("Digite (5) Fechar o programa");
			option = sc.nextInt();
			sc.nextLine();

			switch (option) {

			case 1:
				System.out.println("---- Transação ----");

				System.out.print("Descrição: ");
				String description = sc.nextLine();

				double value = -1;
				boolean validValue = false;

				while (!validValue) {
					System.out.print("Valor: ");
					String valueText = sc.nextLine().replace(",", ".");
					try {
						value = Double.parseDouble(valueText);
						validValue = true;
					} catch (NumberFormatException e) {
						System.out.println("Valor inválido! Digite apenas números.");
					}
				}

				System.out.println("---- Tipo ----");
				System.out.println("1 - Receita:");
				System.out.println("2 - Despesa:");
				int typeInput = sc.nextInt();
				sc.nextLine();

				String type = "";
				boolean validType = false;
				while (!validType) {
					switch (typeInput) {
					case 1:
						type = "Receita";
						validType = true;
						break;
					case 2:
						type = "Despesa";
						validType = true;
						break;
					default:
						System.out.println("Opção inválida! Digite 1 ou 2: ");
						typeInput = sc.nextInt();
						sc.nextLine();
						break;
					}
				}

				System.out.println("---- Categorias ----");
				System.out.println("1 - Alimentação");
				System.out.println("2 - Transporte");
				System.out.println("3 - Moradia");
				System.out.println("4 - Educação");
				System.out.println("5 - Lazer");
				System.out.println("6 - Saúde");
				System.out.println("7 - Compras");
				System.out.println("8 - Outros");
				System.out.print("Escolha uma categoria: ");
				int categoryInput = sc.nextInt();
				sc.nextLine();

				String category = "";
				boolean validCategory = false;
				while (!validCategory) {
					switch (categoryInput) {
					case 1:
						category = "Alimentação";
						validCategory = true;
						break;
					case 2:
						category = "Transporte";
						validCategory = true;
						break;
					case 3:
						category = "Moradia";
						validCategory = true;
						break;
					case 4:
						category = "Educação";
						validCategory = true;
						break;
					case 5:
						category = "Lazer";
						validCategory = true;
						break;
					case 6:
						category = "Saúde";
						validCategory = true;
						break;
					case 7:
						category = "Compras";
						validCategory = true;
						break;
					case 8:
						category = "Outros";
						validCategory = true;
						break;
					default:
						System.out.println("Opção inválida! Digite uma opção válida:");
						categoryInput = sc.nextInt();
						sc.nextLine();
						break;
					}
				}

				String date = "";
				boolean validDate = false;
				while (!validDate) {
					System.out.print("Data (formato DDMMAAAA, ex: 10082026): ");
					String dateInput = sc.nextLine();
					if (dateInput.length() == 8) {
						String day = dateInput.substring(0, 2);
						String month = dateInput.substring(2, 4);
						String year = dateInput.substring(4, 8);
						date = day + "/" + month + "/" + year;
						validDate = true;
					} else {
						System.out.println("Data inválida! Digite uma data válida.");
					}
				}

				String transaction = description + ";" + value + ";" + type + ";" + category + ";" + date;
				transactions.add(transaction);

				System.out.println("Transação Adicionada!");
				break;
			case 2:
				if (transactions.isEmpty()) {
					System.out.println("Não há transações cadastradas!");
				} else {
					System.out.println("---- Transações ----");
					for (int i = 0; i < transactions.size(); i++) {
						System.out.println((i+1) + " - " + transactions.get(i));
					}
				}
				break;
			case 3:
				System.out.println("---- Deletando Transação ----");
				
				if (transactions.isEmpty()) {
					System.out.println("Não há transações cadastradas!");	
					break;
				} else {
					System.out.println("---- Transações ----");
					for (int i = 0; i < transactions.size(); i++) {
						System.out.println((i+1) + " - " + transactions.get(i));
					
					}
					
					System.out.println("Digite a transação que deseja deletar:");
					int deletInput = sc.nextInt();
					sc.nextLine();

					if (deletInput >= 1 && deletInput <= transactions.size()) {
					    transactions.remove(deletInput - 1);
					    System.out.println("Transação removida!");
					} else {
					    System.out.println("Número inválido!");
					}
					
				}
		
				
				break;
			case 4:
				System.out.println("Saldo: R$xxxx");
				break;
			case 5:
				System.out.println("Fechando programa...");
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
