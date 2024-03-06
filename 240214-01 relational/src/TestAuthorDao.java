import java.util.List;

public class TestAuthorDao {
	public static void main(String[] args) {
		AuthorDAO authorDao = new AuthorDAO();
		BookDAO bookDAO = new BookDAO();
		
		Author author = authorDao.getById(1);
		System.out.println(author);
		
//		List<Author> list = authorDao.getAll();
//		for (Author a : list) {
//			List<Book> bookList = bookDAO.getByAuthorId(a.getId());
//			a.setBooks(bookList);
//			
//			for (Book b : bookList) {
//				b.setAuthor(a);
//			}
//		}
//		
//		System.out.println(list);
	}
}
