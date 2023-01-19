package numero1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		
		Product p1 = new Product(1000, "Libro 1", "Book", 115.00);
		Product p2 = new Product(1001, "Libro 2", "Book", 30.00);
		Product p3 = new Product(1002, "Libro 3", "Book", 125.00);
		
		Product p4 = new Product(1003, "Libro 4", "Baby", 15.00);
		Product p5 = new Product(1004, "Libro 5", "Baby", 15.00);
		Product p6 = new Product(1005, "Libro 6", "Baby", 15.00);
		
		Product p7 = new Product(1006, "Libro 7", "Boys", 15.00);
		Product p8 = new Product(1007, "Libro 8", "Boys", 15.00);
		Product p9 = new Product(1008, "Libro 9", "Boys", 15.00);
		
		ArrayList<Product> ordine1 = new ArrayList<Product>(Arrays.asList(p1, p2, p3));
		ArrayList<Product> ordine2 = new ArrayList<Product>(Arrays.asList(p1, p2, p3));
		ArrayList<Product> ordine3 = new ArrayList<Product>(Arrays.asList(p1, p2, p3));
		
		Customer c1 = new Customer(1, "Alessia", 1);
		Customer c2 = new Customer(2, "Mario", 2);
		Customer c3 = new Customer(3, "Luigi", 1);
		
		Order o1 = new Order(1, "in consegna", LocalDate.now(), LocalDate.of(2023,  01, 23), ordine1, c1);
		Order o2 = new Order(2, "in consegna", LocalDate.now(), LocalDate.of(2023,  01, 25), ordine2, c2);
		Order o3 = new Order(3, "in consegna", LocalDate.now(), LocalDate.of(2023,  01, 28), ordine3, c3);
		
		ArrayList<Order> listaOrdini = new ArrayList<Order>(Arrays.asList(o1, o2, o3));
		

		// ESERCIZIO 1
		ArrayList<Product> prodotti = new ArrayList<Product>(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9));
		
		Stream<Product> bookStream = prodotti.stream()
				.filter((product) -> product.getCategory() == "Book" && product.getPrice() > 50);
		
		bookStream.forEach(prodotto -> {
			System.out.println(prodotto);
		});
		
		
		// ESERCIZIO 2

			
	}


}