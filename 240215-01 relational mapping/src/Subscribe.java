
public class Subscribe {
	private int no;
	private String userId;
	private int subNo;
	private SubscribeType subscribeType;
	
	public Subscribe() {}

	public Subscribe(int no, String userId, SubscribeType subscribeType) {
		super();
		this.no = no;
		this.userId = userId;
		this.subscribeType = subscribeType;
	}

	public int getSubNo() {
		return subNo;
	}

	public void setSubNo(int subNo) {
		this.subNo = subNo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public SubscribeType getSubscribeType() {
		return subscribeType;
	}

	public void setSubscribeType(SubscribeType subscribeType) {
		this.subscribeType = subscribeType;
	}

	@Override
	public String toString() {
		return "Subscribe [no=" + no + ", userId=" + userId + ", subNo=" + subNo + ", subscribeType=" + subscribeType
				+ "]";
	}
}
