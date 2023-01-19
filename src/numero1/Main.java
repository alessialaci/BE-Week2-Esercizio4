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
		
		Product p4 = new Product(1003, "Giocattolo 1", "Baby", 24.00);
		Product p5 = new Product(1004, "Giocattolo 2", "Baby", 18.00);
		Product p6 = new Product(1005, "Giocattolo 3", "Baby", 31.00);
		
		Product p7 = new Product(1006, "Videogame 1", "Boys", 62.00);
		Product p8 = new Product(1007, "Videogame 2", "Boys", 55.00);
		Product p9 = new Product(1008, "Videogame 3", "Boys", 38.00);
		
		ArrayList<Product> ordine1 = new ArrayList<Product>(Arrays.asList(p1, p7, p8));
		ArrayList<Product> ordine2 = new ArrayList<Product>(Arrays.asList(p2, p5, p8));
		ArrayList<Product> ordine3 = new ArrayList<Product>(Arrays.asList(p3, p6, p9));
		
		Customer c1 = new Customer(1100, "Alessia", 2);
		Customer c2 = new Customer(1101, "Mario", 2);
		Customer c3 = new Customer(1102, "Luigi", 1);
		
		Order o1 = new Order(1, "in consegna", LocalDate.of(2021, 03, 05), LocalDate.of(2021, 03, 04), ordine1, c1);
		Order o2 = new Order(2, "in consegna", LocalDate.of(2021, 01, 10), LocalDate.of(2021, 01, 11), ordine2, c2);
		Order o3 = new Order(3, "in consegna", LocalDate.of(2021, 03, 25), LocalDate.of(2021, 03, 26), ordine3, c3);
		
		ArrayList<Product> prodotti = new ArrayList<Product>(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9));
		ArrayList<Order> listaOrdini = new ArrayList<Order>(Arrays.asList(o1, o2, o3));
		
		
		// ESERCIZIO 1
        System.out.println("Lista prodotti categoria Book");
		printBookProducts(prodotti);
		
		
		// ESERCIZIO 2
        System.out.println("---------------------");
        System.out.println("Lista ordini categoria Baby");
		printBabyOrders(listaOrdini);

		
		// ESERCIZIO 3
        System.out.println("---------------------");
        System.out.println("Lista prodotti categoria Boys");
		printBoysProducts(prodotti);

		
		// ESERCIZIO 4
        System.out.println("---------------------");
        System.out.println("Lista prodotti ordinati da clienti con tier 2 dall'01/02/2021 al 01/04/2021");
		print2TierProducts(listaOrdini);
			
	}
	
	public static void printBookProducts(ArrayList<Product> prodotti) {
		Stream<Product> bookStream = prodotti.stream()
				.filter((product) -> product.getCategory() == "Book" && product.getPrice() > 50);
		
		bookStream.forEach(prodotto -> {
			System.out.println(prodotto);
		});
	}
	
	public static void printBabyOrders(ArrayList<Order> listaOrdini) {
		ArrayList<Order> listaBaby = new ArrayList<>();
		
        listaOrdini.stream()
        	.filter((ordine) -> ordine.getProducts().stream()
        			.filter((categoriaProdotto) -> categoriaProdotto.getCategory() == "Baby")
        			.count() > 0)
        	.forEach((ordine) -> listaBaby.add(ordine));

        listaBaby.forEach(ordine -> {
        	System.out.println(ordine);
        });
	}
	
	public static void printBoysProducts(ArrayList<Product> prodotti) {
		Stream<Product> bookStream = prodotti.stream()
				.filter((product) -> product.getCategory() == "Boys")
				.map( product -> {
					product.setPrice();
			        return product;
	            });
		
		bookStream.forEach(prodotto -> {
			System.out.println(prodotto);
		});
	}
	
	public static void print2TierProducts(ArrayList<Order> listaOrdini) {
		ArrayList<Product> listaProdotti = new ArrayList<>();

		listaOrdini.stream()
		    .filter(o -> o.getOrderDate().isAfter(LocalDate.of(2021, 02, 01)) && // DOPO IL PRIMO FEBBRAIO 2021
		                o.getOrderDate().isBefore(LocalDate.of(2021, 04, 01)) && // PRIMA DEL Uno aPRILE 2021
		                o.getCustomer().getTier() == 2)
		    .flatMap(o -> o.getProducts().stream())
		    .forEach(p -> listaProdotti.add(p));

		listaProdotti.forEach(p -> {
		    System.out.println(p.getName() + " - Categoria " + p.getCategory() + " - Prezzo €" + p.getPrice());
		});
	}


}