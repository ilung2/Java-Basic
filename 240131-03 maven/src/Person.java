import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor // 빈생성자
@AllArgsConstructor // 모든 생성자
@Data
//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
public class Person {
	private String name;
	private int age;
}
