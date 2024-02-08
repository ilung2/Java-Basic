import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestPerson {
//	private static Logger logger = LoggerFactory.getLogger(TestPerson.class); 
	
	public static void main(String[] args) {
		Person p = new Person();
		Person p2 = new Person("길동", 22);
		
//		System.out.println(p.getName());
		log.info(p.getName());
		log.warn("경고!"); // 주의사항
		log.error("에러가 발생했어요!!");
		p.setName("둘리");
		
//		System.out.println(p.toString());
		log.info(p.toString());

//		System.out.println(p.equals(p2));
		log.info(String.valueOf(p.equals(p2)));
		
	}
}
