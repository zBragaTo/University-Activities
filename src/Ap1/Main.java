package Ap1;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Item> items = new ArrayList<>();
		items.add(new Book("978-8580579529",
				  "Como mentir com estatística", "Darrell Huff",
				  "Intrínseca", 2019));
		items.add(new Book("978-6589733348",
				  "O livro do xadrez", "Stefan Zweig",
				  "Fósforo Editora", 2021));
		items.add(new Book("978-6587408569",
				  "Como aprender qualquer coisa", 
				  "Dra. Barbara Oakley e Olav Schewe",
				  "Auster", 2023));
	
		for (var item : items) {
            item.showDetails();
            item.borrow();

            if (item instanceof IRenewable) {
                ((IRenewable) item).renew();
            } else {
                item.borrow();
            }

            item.returnMaterial();

            if (item instanceof IRenewable) {
                ((IRenewable) item).renew();
            }
            System.out.println("");
        }
	}
}
