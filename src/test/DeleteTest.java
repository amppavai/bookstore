@SpringBootTest(classes = BookstoreApplication.class)
public class DeleteTest {
	@Test
	@Rollback(false)
	public void deleteBook() {

		Book book = repository.findById(Long.valueOf(4)).get();

		repository.delete(book);

		Optional<Book> deleteBook = repository.findById(Long.valueOf(4));

		assertThat(deleteBook).isEmpty();

	}
}