package book.model.dto;

public class MemberDTO {
	private String id;
	private String pwd;
	private String name;
	private String tel;
	private String postal;

	public MemberDTO() {
	}

	public MemberDTO(String id, String pwd, String name, String tel, String postal) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.tel = tel;
		this.postal = postal;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("----------"+"\n 회원 아이디: ");
		b.append(id);
		b.append("\n 비밀번호: ");
		b.append(pwd);
		b.append("\n 회원 이름: ");
		b.append(name);
		b.append("\n 회원 전화번호: ");
		b.append(tel);
		b.append("\n 회원 주소: ");
		b.append(postal);
		return b.toString();
	}
}