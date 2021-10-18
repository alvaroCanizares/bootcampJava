
public class SuperHeroe {
	private String id;
	private String nombre;
	private String nombreSuperHeroe;
	private int poder;
	private String superPoder;
	
	
	@Override
	public String toString() {
		return  nombre + ": " + nombreSuperHeroe + ", poder="
				+ poder + ", superPoder=" + superPoder;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombreSuperHeroe() {
		return nombreSuperHeroe;
	}
	public void setNombreSuperHeroe(String nombreSuperHeroe) {
		this.nombreSuperHeroe = nombreSuperHeroe;
	}
	public int getPoder() {
		return poder;
	}
	public void setPoder(int poder) {
		this.poder = poder;
	}
	public String getSuperPoder() {
		return superPoder;
	}
	public void setSuperPoder(String superPoder) {
		this.superPoder = superPoder;
	}
	
}
