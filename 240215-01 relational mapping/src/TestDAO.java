import java.util.List;

public class TestDAO {
	public static void main(String[] args) {
		SubscribeService service = new SubscribeService();
		List<Subscribe> list = service.getAll();
		
		System.out.println(list);
		
		SubscribeDAO dao = new SubscribeDAO();
//		SubscribeTypeDAO dao2 = new SubscribeTypeDAO();
		
		System.out.println(dao.getAllJoin());
		
//		SubscribeType type = dao2.getByPk(1);
//		System.out.println(type);
		
//		List<Subscribe> list = dao.getAll();
//		
//		System.out.println(list);
	}
}
