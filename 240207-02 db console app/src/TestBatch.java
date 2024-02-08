import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestBatch {
	public static void main(String[] args) {
		PersonDAOImpl dao = PersonDAOImpl.getInstance();
		
		PersonService service = new PersonService(dao);
		int result = service.insert(new Person("사람42",99));
		
		System.out.println(dao.getAll());
//		List<Person> list = new ArrayList<>(
//					Arrays.asList(
//								new Person("사람17",1)
//								, new Person("사람19",2)
//								, new Person("사람18",3)
//								, new Person("사람16",4)
//								, new Person("사람30",5)
//							)
//				);
//		
//		int[] result = dao.batchAdd(list);
//		System.out.println(Arrays.toString(result));
	}
}
