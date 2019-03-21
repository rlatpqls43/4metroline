package book.model.dto;



public class BookDTO {
	private String code;
	private String bname;
	private int price;
	private String publish;
	private String writer;
	private String date;

	public BookDTO() {
	}

	public BookDTO(String code, String bname, int price, String publish, String writer, String date) {
		this.code = code;
		this.bname = bname;
		this.price = price;
		this.publish = publish;
		this.writer = writer;
		this.date = date;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPublish() {
		return publish;
	}

	public void setPublish(String publish) {
		this.publish = publish;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("\n 1. 책코드: ");
		b.append(code);
		b.append("\n 2. 책명:  ");
		b.append(bname);
		b.append("\n 3. 가격: ");
		b.append(price);
		b.append("\n 4. 출판사: "); 
		b.append(publish);
		b.append("\n 5. 작가: ");
		b.append(writer);
		b.append("\n 6. 등록날짜: ");
		b.append(date);
		return b.toString();
	}
}