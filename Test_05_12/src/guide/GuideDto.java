package guide;

public class GuideDto {
	// id,종목명,순번,가이드
	public String id;
	public String list;
	public String seq;
	public String guide;

	public GuideDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "GuideDto [id=" + id + ", list=" + list + ", seq=" + seq + ", guide=" + guide + "]";
	}
	
	

}
