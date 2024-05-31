package dgtic.proyecto.util;

import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class RenderPagina<T> {
	private String url;
	private Page<T> page;
	private int totalPaginas;
	private int elementosPorPagina;
	private int paginaActual;
	private List<PageItem> paginas;
	private String query; // Agregar el atributo query
	/*private String url; ORIGINAL
	private Page<T> page;
	private int totalPaginas;
	private int elementosPorPagina;
	private int paginaActual;
	private List<PageItem> paginas;*/
	public RenderPagina(String url, Page<T> page, String query) {
		this.url = url;
		this.page = page;
		this.query = query; // Establecer el valor de la query
		this.paginas = new ArrayList<>();
		elementosPorPagina = page.getSize();
		totalPaginas = page.getTotalPages();
		paginaActual = page.getNumber() + 1;
		int desde, hasta;
		if (totalPaginas <= elementosPorPagina) {
			desde = 1;
			hasta = totalPaginas;
		} else {
			if (paginaActual <= elementosPorPagina / 2) {
				desde = 1;
				hasta = elementosPorPagina;
			} else if (paginaActual >= totalPaginas - elementosPorPagina / 2) {
				desde = totalPaginas - elementosPorPagina + 1;
				hasta = elementosPorPagina;
			} else {
				desde = paginaActual - elementosPorPagina / 2;
				hasta = elementosPorPagina;
			}
		}
		for (int i = 0; i < hasta; i++) {
			paginas.add(new PageItem(desde + i, paginaActual == desde + i));
		}
	}
	public RenderPagina(String url, Page<T> page) { //ORIGINAL
		this.url = url;
		this.page = page;
		this.paginas=new ArrayList<PageItem>();
		elementosPorPagina=page.getSize();
		totalPaginas=page.getTotalPages();
		paginaActual=page.getNumber()+1;
		int desde,hasta;
		if(totalPaginas<=elementosPorPagina) {
			desde=1;
			hasta=totalPaginas;
		}else {
			if(paginaActual<=elementosPorPagina/2) {
				desde=1;
				hasta=elementosPorPagina;
			}else if(paginaActual>=totalPaginas-elementosPorPagina/2) {
				desde=totalPaginas-elementosPorPagina+1;
				hasta=elementosPorPagina;
			}else {
				desde=paginaActual-elementosPorPagina/2;
				hasta=elementosPorPagina;
			}
		}
		for(int i =0;i<hasta;i++) {
			paginas.add(new PageItem(desde+i, paginaActual==desde+i));
		}
	}
	public String getUrl() {
		return url;
	}
	public int getTotalPaginas() {
		return totalPaginas;
	}
	public int getPaginaActual() {
		return paginaActual;
	}
	public List<PageItem> getPaginas() {
		return paginas;
	}
	public String getQuery(){
		return query;
	}
	
	public boolean isFirst() {
		return page.isFirst();
	}
	public boolean isLast() {
		return page.isLast();
	}
	public boolean isHasNext() {
		return page.hasNext();
	}
	public boolean isHasPrevious() {
		return page.hasPrevious();
	}

	// Método para obtener la URL con el parámetro de búsqueda incluido
	public String getUrlWithQuery(int pageNumber, String query) {
		StringBuilder urlBuilder = new StringBuilder(url);
		urlBuilder.append("?page=").append(pageNumber).append("&query=").append(query);
		return urlBuilder.toString();
	}
}
