package enums;

public enum TipoEmpresaEnum {

	MEI("Microempreendedor Individual"),
	EIRELI("Empresa Individual de Responsabilidade Limitada"),
	LTDA("Sociedade Limitada"),
	SA("Sociedade Anônima");
	
	private String desc;
	
	TipoEmpresaEnum(String desc){
		this.desc = desc;
	}
	
	public String getDesc() {
		return desc;
	}
	
}
