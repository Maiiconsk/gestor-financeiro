package gestorFinanceiro;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Home {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		boolean run = true;

		ArrayList<Transaction> transactions = loadTransactionsFromFile();

		while (run) {

			int option = -1;

			System.out.println("======== Controle de Gastos ========");
			System.out.println("1 - Adicionar uma Transação");
			System.out.println("2 - Listar suas Transações");
			System.out.println("3 - Editar uma Transação");
			System.out.println("4 - Excluir uma Transação");
			System.out.println("5 - Ver Saldo");
			System.out.println("0 - Fechar o programa");
			System.out.print("Digite a opção desejada: ");
			option = sc.nextInt();
			sc.nextLine();

			switch (option) {

			case 1:
				System.out.println("---- Transação ----");

				Transaction newTransaction = new Transaction();

				System.out.print("Descrição: ");
				newTransaction.setDescription(sc.nextLine());

				float value = -1;
				boolean validValue = false;

				while (!validValue) {
					System.out.print("Valor: ");
					String valueText = sc.nextLine().replace(",", ".");
					try {
						newTransaction.setValue(value = Float.parseFloat(valueText));
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

				boolean validType = false;
				while (!validType) {
					switch (typeInput) {
					case 1:
						newTransaction.setType("Receita");
						validType = true;
						break;
					case 2:
						newTransaction.setType("Despesa");
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
				int categoryEditInput = sc.nextInt();
				sc.nextLine();

				boolean validCategory = false;
				while (!validCategory) {
					switch (categoryEditInput) {
					case 1:
						newTransaction.setCategory("Alimentação");
						validCategory = true;
						break;
					case 2:
						newTransaction.setCategory("Transporte");
						validCategory = true;
						break;
					case 3:
						newTransaction.setCategory("Moradia");
						validCategory = true;
						break;
					case 4:
						newTransaction.setCategory("Educação");
						validCategory = true;
						break;
					case 5:
						newTransaction.setCategory("Lazer");
						validCategory = true;
						break;
					case 6:
						newTransaction.setCategory("Saúde");
						validCategory = true;
						break;
					case 7:
						newTransaction.setCategory("Compras");
						validCategory = true;
						break;
					case 8:
						newTransaction.setCategory("Outros");
						validCategory = true;
						break;
					default:
						System.out.println("Opção inválida! Digite uma opção válida:");
						categoryEditInput = sc.nextInt();
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
						newTransaction.setDate(date);
						validDate = true;
					} else {
						System.out.println("Data inválida! Digite uma data válida.");
					}
				}

				transactions.add(newTransaction);
				saveTransactionsToFile(transactions);
				System.out.println("Transação Adicionada!");
				break;
			case 2:
				if (transactions.isEmpty()) {
					System.out.println("Não há transações cadastradas!");
				} else {
					System.out.println("---- Transações ----");
					for (int i = 0; i < transactions.size(); i++) {
						Transaction temp = transactions.get(i);
						System.out.println((i + 1) + " - " + temp);
					}
				}
				break;
			case 3:
				System.out.println("---- Editor de Transação ----");

				if (transactions.isEmpty()) {
					System.out.println("Não há transações cadastradas!");
					break;
				} else {
					System.out.println("---- Transações ----");
					for (int i = 0; i < transactions.size(); i++) {
						Transaction temp = transactions.get(i);
						System.out.println((i + 1) + " - " + temp);
					}
				}
				
				

				System.out.println("\nDigite a transação que deseja editar:");
				int editInput = sc.nextInt();
				sc.nextLine();

				System.out.println("1 - Descrição");
				System.out.println("2 - Valor");
				System.out.println("3 - Tipo");
				System.out.println("4 - Categoria");
				System.out.println("5 - Data");
				System.out.println("Digite a opção que deseja editar: ");
				int editOption = sc.nextInt();
				sc.nextLine();

				if (editInput >= 1 && editInput <= transactions.size()) {

					boolean stop = false;

					Transaction editTransaction = transactions.get(editInput -1);

					while (!stop) {

						switch (editOption) {

						case 1:
							System.out.print("Nova Descrição: ");
							editTransaction.setDescription(sc.nextLine());
							break;

						case 2:
							boolean editValue = false;
							while (!editValue) {
								System.out.print("Novo Valor: ");
								String valueText = sc.nextLine().replace(",", ".");
								try {
									editTransaction.setValue(Float.parseFloat(valueText));
									editValue = true;
								} catch (NumberFormatException e) {
									System.out.println("Valor inválido! Digite apenas números.");
								}
							}

							break;

						case 3:
							System.out.println("Iipos:");
							System.out.println("1 - Receita");
							System.out.println("2 - Despesa");
							System.out.println("Digite o Novo Tipo:");
							int editTypeInput = sc.nextInt();
							sc.nextLine();

							boolean editedType = false;
							while (!editedType) {
								switch (editTypeInput) {
								case 1:
									editTransaction.setType("Receita");
									editedType = true;
									break;
								case 2:
									editTransaction.setType("Despesa");
									editedType = true;
									break;
								default:
									System.out.println("Opção inválida! Digite 1 ou 2: ");
									editTypeInput = sc.nextInt();
									sc.nextLine();
									break;
								}
							}
							break;

						case 4:
							System.out.println("Categorias: ");
							System.out.println("1 - Alimentação");
							System.out.println("2 - Transporte");
							System.out.println("3 - Moradia");
							System.out.println("4 - Educação");
							System.out.println("5 - Lazer");
							System.out.println("6 - Saúde");
							System.out.println("7 - Compras");
							System.out.println("8 - Outros");
							System.out.println("Digite a Nova Categoria:");
							int categoryInput = sc.nextInt();
							sc.nextLine();

							boolean editCategory = false;
							while (!editCategory) {
								switch (categoryInput) {
								case 1:
									editTransaction.setCategory("Alimentação");
									editCategory = true;
									break;
								case 2:
									editTransaction.setCategory("Transporte");
									editCategory = true;
									break;
								case 3:
									editTransaction.setCategory("Moradia");
									editCategory = true;
									break;
								case 4:
									editTransaction.setCategory("Educação");
									editCategory = true;
									break;
								case 5:
									editTransaction.setCategory("Lazer");
									editCategory = true;
									break;
								case 6:
									editTransaction.setCategory("Saúde");
									editCategory = true;
									break;
								case 7:
									editTransaction.setCategory("Compras");
									editCategory = true;
									break;
								case 8:
									editTransaction.setCategory("Outros");
									editCategory = true;
									break;
								default:
									System.out.println("Opção inválida! Digite uma opção válida:");
									categoryInput = sc.nextInt();
									sc.nextLine();
									break;
								}
							}
							break;

						case 5:
							System.out.print("Nova Data ");

							boolean editDate = false;
							while (!editDate) {
								System.out.print("(formato DDMMAAAA, ex: 10082026): ");
								String dateInput = sc.nextLine();
								if (dateInput.length() == 8) {
									String day = dateInput.substring(0, 2);
									String month = dateInput.substring(2, 4);
									String year = dateInput.substring(4, 8);
									String formatedDate = day + "/" + month + "/" + year;
									editTransaction.setDate(formatedDate);
									editDate = true;
								} else {
									System.out.println("Data inválida! Digite uma data válida.");
								}
							}

							break;

						default:
							System.out.println("Opção inválida!");
							break;
						}

						System.out.println("Deseja editar outra informação? (S)Sim ou (N)Não.");
						String stopOption = sc.nextLine();

						if (stopOption.equalsIgnoreCase("S") || stopOption.equalsIgnoreCase("Sim")) {
							System.out.println("Digite a próxima opção que deseja editar: ");
							editOption = sc.nextInt();
							sc.nextLine();

							continue;
						} else {
							stop = true;
						}

					}

					transactions.set(editInput - 1, editTransaction);
					saveTransactionsToFile(transactions);
					System.out.println("Transação atualizada!");

				} else {
					System.out.println("Transação inválida!");
				}

				break;

			case 4:
				System.out.println("---- Exclusão de Transação ----");

				if (transactions.isEmpty()) {
					System.out.println("Não há transações cadastradas!");
					break;
				} else {
					System.out.println("---- Transações ----");
					for (int i = 0; i < transactions.size(); i++) {
						Transaction temp = transactions.get(i);
						System.out.println((i + 1) + " - " + temp);
					}

					System.out.println("\nDigite a transação que deseja deletar:");
					int deletInput = sc.nextInt();
					sc.nextLine();

					if (deletInput >= 1 && deletInput <= transactions.size()) {
						transactions.remove(deletInput - 1);
						saveTransactionsToFile(transactions);

						System.out.println("Transação removida!");
					} else {
						System.out.println("Número inválido!");
					}

				}
				break;
			case 5:

				double balance = 0;

				for (int i = 0; i < transactions.size(); i++) {
					Transaction temp = transactions.get(i);
					if (temp.getType().equalsIgnoreCase("Receita")) {
						balance += temp.getValue();
					} else {
						balance -= temp.getValue();
					}
				}

				System.out.println("Saldo Atual: R$" + balance);

				break;
			case 0:
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

	public static void saveTransactionsToFile(ArrayList<Transaction> transactions) {
	    try (FileWriter writer = new FileWriter("transactions.txt")) {
	        for (Transaction t : transactions) {
	            String linha = t.getDescription() + ";" + t.getValue() + ";" + t.getType() + ";" + t.getCategory() + ";" + t.getDate();
	            writer.write(linha + System.lineSeparator());
	        }
	    } catch (IOException e) {
	        System.out.println("Erro ao salvar transações no arquivo: " + e.getMessage());
	    }
	}

	public static ArrayList<Transaction> loadTransactionsFromFile() {
	    ArrayList<Transaction> transactions = new ArrayList<>();
	    try (BufferedReader reader = new BufferedReader(new FileReader("transactions.txt"))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            String[] parts = line.split(";");
	            Transaction t = new Transaction();
	            t.setDescription(parts[0]);
	            t.setValue(Float.parseFloat(parts[1]));
	            t.setType(parts[2]);
	            t.setCategory(parts[3]);
	            t.setDate(parts[4]);
	            transactions.add(t);
	        }
	    } catch (IOException e) {
	        System.out.println("Nenhum histórico encontrado. Começando do zero.");
	    }
	    return transactions;
	}
}
