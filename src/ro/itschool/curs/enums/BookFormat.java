package ro.itschool.curs.enums;


import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public enum BookFormat {
	
	PB("paperback"), HB("hardback/ hardcover"), AB("audiobok"), KE("kindle edition"), EB("e-book");
	public final String code;
   
	
	private BookFormat(String code) {
        this.code = code;
    }
    public String getCode() {
    	return code;

}
}