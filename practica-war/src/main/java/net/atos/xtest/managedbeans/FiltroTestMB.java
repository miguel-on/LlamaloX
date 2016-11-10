package net.atos.xtest.managedbeans;

import java.util.List;

import javax.annotation.PostConstruct;

import net.atos.xtest.business.test.TestBO;
import net.atos.xtest.dto.FiltroTestsDto;
import net.atos.xtest.entity.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class FiltroTestMB {
	protected FiltroTestsDto filtro = new FiltroTestsDto();
	protected List<Test> lista;
	protected Test testSeleccionado;

	@Autowired
	TestBO testBO;

	@PostConstruct
	public void init() {
		// WebApplicationContext ctx =
		// FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		// testBO = ctx.getBean(TestBO.class);
	}

	public void nuevoTest() {
		testSeleccionado = new Test();
	}

	public void insertar() {
		testBO.insertar(testSeleccionado);
		buscar();
	}

	public Test actualizar() {
		Test updated = testBO.actualizar(testSeleccionado);
		buscar();
		return updated;
	}

	public void borrar() {
		testBO.borrar(testSeleccionado);
		buscar();
	}

	public void buscar() {
		lista = testBO.buscar(filtro);
	}

	public FiltroTestsDto getFiltro() {
		return filtro;
	}

	public void setFiltro(FiltroTestsDto filtro) {
		this.filtro = filtro;
	}

	public List<Test> getLista() {
		return lista;
	}

	public void setLista(List<Test> lista) {
		this.lista = lista;
	}

	public Test getTestSeleccionado() {
		return testSeleccionado;
	}

	public void setTestSeleccionado(Test testSeleccionado) {
		this.testSeleccionado = testSeleccionado;
	}

	public void resetForm() {
		setTestSeleccionado(new Test());
		buscar();
		setTestSeleccionado(new Test());
	}

}