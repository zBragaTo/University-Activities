package Ap2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		String fileName = "books.txt";
		List<Book> books = new ArrayList<>();
		float totalPrice = 0;
		int validBookCount = 0;
		float maxPrice = 0;
		Book mostExpensiveBook = null;

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = br.readLine()) != null) {
				try {
					String[] parts = line.split("\\|");
					String isbn = parts[0];
					String title = parts[1];
					String authors = parts[2];
					String publisher = parts[3];

					// Tenta converter o ano
					int year = 0;
					try {
						year = Integer.parseInt(parts[4]);
					} catch (NumberFormatException e) {
						System.out.println("*** Erro ao converter o ano do livro: " + line);
						continue; // Pula para a próxima linha
					}

					// Tenta converter o preço
					float price = 0;
					try {
						price = Float.parseFloat(parts[5]);
					} catch (NumberFormatException e) {
						System.out.println("*** Erro ao converter o preço do livro: " + line);
						continue; // Pula para a próxima linha
					}

					Book book = new Book(isbn, title, authors, publisher, year);
					books.add(book);

					totalPrice += price;
					validBookCount++;

					if (price > maxPrice) {
						maxPrice = price;
						mostExpensiveBook = book;
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("*** Erro na formatação da linha: " + line);
				}
			}
		} catch (IOException e) {
			System.out.println("*** Erro ao abrir o arquivo " + fileName);
		}

		for (Book book : books) {
			book.showDetails();
		}

		if (validBookCount > 0) {
			float averagePrice = totalPrice / validBookCount;
			System.out.printf("Média de preço: R$%.2f%n", averagePrice);
		}

		if (mostExpensiveBook != null) {
			System.out.printf("'%s' é o livro mais caro (R$%.2f).%n", mostExpensiveBook.getTitle(), maxPrice);
		}
	}
}