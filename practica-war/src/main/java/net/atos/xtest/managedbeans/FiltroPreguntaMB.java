package net.atos.xtest.managedbeans;

import java.util.List;

import javax.annotation.PostConstruct;






import net.atos.xtest.business.pregunta.PreguntaBO;
import net.atos.xtest.dto.FiltroPreguntasDto;
import net.atos.xtest.entity.Pregunta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class FiltroPreguntaMB {
	protected FiltroPreguntasDto filtro = new FiltroPreguntasDto();
	protected List<Pregunta> lista;
	protected Pregunta preguntaSeleccionado;

	@Autowired
	PreguntaBO preguntaBO;

	@PostConstruct
	public void init() {
		// WebApplicationContext ctx =
		// FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		// preguntaBO = ctx.getBean(PreguntaBO.class);
	}

	public void nuevoPregunta() {
		preguntaSeleccionado = new Pregunta();
	}

	public void insertar() {
		preguntaBO.insertar(preguntaSeleccionado);
		buscar();
	}

	public Pregunta actualizar() {
		Pregunta updated = preguntaBO.actualizar(preguntaSeleccionado);
		buscar();
		return updated;
	}

	public void borrar() {
		preguntaBO.borrar(preguntaSeleccionado);
		buscar();
	}

	public void buscar() {
		lista = preguntaBO.buscar(filtro);
	}

	public FiltroPreguntasDto getFiltro() {
		return filtro;
	}

	public void setFiltro(FiltroPreguntasDto filtro) {
		this.filtro = filtro;
	}

	public List<Pregunta> getLista() {
		return lista;
	}

	public void setLista(List<Pregunta> lista) {
		this.lista = lista;
	}

	public Pregunta getPreguntaSeleccionado() {
		return preguntaSeleccionado;
	}

	public void setPreguntaSeleccionado(Pregunta preguntaSeleccionado) {
		this.preguntaSeleccionado = preguntaSeleccionado;
	}

	public void resetForm() {
		setPreguntaSeleccionado(new Pregunta());
		buscar();
		setPreguntaSeleccionado(new Pregunta());
	}

}
