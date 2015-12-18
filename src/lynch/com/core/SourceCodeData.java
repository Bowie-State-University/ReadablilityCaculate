package lynch.com.core;

public class SourceCodeData {
	private String Vpackage;
	private String Vclass;
	private String Vmethod;
	private String Vtype;
	private String Vname;
	private String VlineNum;
	SourceCodeData(){
		
	}
    
	SourceCodeData(String Vpackage, String Vclass, String Vmethod){
		this.Vpackage = Vpackage;
		this.Vclass = Vclass;
		this.Vmethod = Vmethod;
	}
	
	public String getVpackage(){
		return Vpackage;
	}
	public void setVpackage(String Vpackage){
		this.Vpackage = Vpackage;
	}
	public String getVclass(){
		return Vclass;
	}
	public void setVclass(String Vclass){
		this.Vclass = Vclass;
	}
	public String getVmethod(){
		return Vmethod;
	}
	public void setVmethod(String Vmethod){
		this.Vmethod = Vmethod;
	}
	public String getVtype(){
		return Vtype;
	}
	public void setVtype(String Vtype){
		this.Vtype = Vtype;
	}
	public String getVname(){
		return Vname;
	}
	public void setVname(String Vname){
		this.Vname = Vname;
	}
	public String getVlineNum(){
		return VlineNum;
	}
	public void setVlineNum(String VlineNum){
		this.VlineNum = VlineNum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Vclass == null) ? 0 : Vclass.hashCode());
		result = prime * result
				+ ((VlineNum == null) ? 0 : VlineNum.hashCode());
		result = prime * result + ((Vmethod == null) ? 0 : Vmethod.hashCode());
		result = prime * result + ((Vname == null) ? 0 : Vname.hashCode());
		result = prime * result
				+ ((Vpackage == null) ? 0 : Vpackage.hashCode());
		result = prime * result + ((Vtype == null) ? 0 : Vtype.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SourceCodeData other = (SourceCodeData) obj;
		if (Vclass == null) {
			if (other.Vclass != null)
				return false;
		} else if (!Vclass.equals(other.Vclass))
			return false;
		if (VlineNum == null) {
			if (other.VlineNum != null)
				return false;
		} else if (!VlineNum.equals(other.VlineNum))
			return false;
		if (Vmethod == null) {
			if (other.Vmethod != null)
				return false;
		} else if (!Vmethod.equals(other.Vmethod))
			return false;
		if (Vname == null) {
			if (other.Vname != null)
				return false;
		} else if (!Vname.equals(other.Vname))
			return false;
		if (Vpackage == null) {
			if (other.Vpackage != null)
				return false;
		} else if (!Vpackage.equals(other.Vpackage))
			return false;
		if (Vtype == null) {
			if (other.Vtype != null)
				return false;
		} else if (!Vtype.equals(other.Vtype))
			return false;
		return true;
	}
	

}
