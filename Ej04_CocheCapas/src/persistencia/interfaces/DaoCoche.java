package persistencia.interfaces;

import java.util.List;

import entidad.Coche;

public interface DaoCoche {
	public boolean alta(Coche c);
	public boolean baja(String matricula);
	public boolean modificar(Coche c);
	public Coche obtener(String matricula);
	public List<Coche> listar();
}
