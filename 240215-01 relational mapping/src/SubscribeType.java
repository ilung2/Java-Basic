
public class SubscribeType {
	private int subNo;
	private String subName;
	
	public SubscribeType() {}

	public SubscribeType(int subNo, String subName) {
		super();
		this.subNo = subNo;
		this.subName = subName;
	}

	public int getSubNo() {
		return subNo;
	}

	public void setSubNo(int subNo) {
		this.subNo = subNo;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	@Override
	public String toString() {
		return "SubscribeType [subNo=" + subNo + ", subName=" + subName + "]";
	}
	
	
}
