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
			System.out.println("Digite (3) Ver Saldo");
			System.out.println("Digite (4) Fechar o programa");
			option = sc.nextInt();
			sc.nextLine();

			switch (option) {

			case 1:
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

				System.out.println("Tipo: ");
				System.out.println("1 - Receita:");
				System.out.println("2 - Despesa:");
				int typeinput = sc.nextInt();
				sc.nextLine();

				String type = "";
				boolean validType = false;
				while (!validType) {
					switch (typeinput) {
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
						typeinput = sc.nextInt();
						sc.nextLine();
						break;
					}
				}

				System.out.println("Categorias:");
				System.out.println("1 - Alimentação");
				System.out.println("2 - Transporte");
				System.out.println("3 - Moradia");
				System.out.println("4 - Educação");
				System.out.println("5 - Lazer");
				System.out.println("6 - Saúde");
				System.out.println("7 - Compras");
				System.out.println("8 - Outros");
				System.out.print("Escolha uma categoria: ");
				int categoryinput = sc.nextInt();
				sc.nextLine();

				String category = "";
				boolean validCategory = false;
				while (!validCategory) {
					switch (categoryinput) {
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
						categoryinput = sc.nextInt();
						sc.nextLine();
						break;
					}
				}

				String date = "";
				boolean validDate = false;
				while (!validDate) {
					System.out.print("Data (formato DDMMAAAA, ex: 10082026): ");
					String dateinput = sc.nextLine();
					if (dateinput.length() == 8) {
						String day = dateinput.substring(0, 2);
						String month = dateinput.substring(2, 4);
						String year = dateinput.substring(4, 8);
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
				System.out.println("Listando transações...");
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
