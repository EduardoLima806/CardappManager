package com.financial.management.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.springframework.stereotype.Controller;

import com.financial.management.entities.Categoria;
import com.financial.management.service.CategoriaService;


@Controller("categoriaBean")
@ViewScoped
public class CategoriaBean {
	
	  private List<Categoria> categorias;
	  private Categoria categoria;
	    
	    @Resource
	    private CategoriaService categoriaService;
		private boolean isEdit;

	    @PostConstruct
		public void getInit() {
			// TODO Auto-generated constructor stub
			categorias = categoriaService.getAll();
			setCategoria(new Categoria());
		}
	    
	    
	    /* BUTTONS ACTIONS*/
	    
	    public void prepareToDelete(Categoria selectedItem) {
			this.setCategoria(selectedItem);
		}
	    
	    public void btnDelete() {
	  
	  		try {
	  			categoriaService.delete(categoria);
	  			FacesContext context = FacesContext.getCurrentInstance();  
	  	        context.addMessage(null, new FacesMessage("Deletado com Successo", "Info!"));  
	  	        getInit();
	  		} catch (Exception e) {
	  			FacesContext context = FacesContext.getCurrentInstance();  
	  	        context.addMessage(null, new FacesMessage("Erro ao deletar", "Erro!"));
	  	        getInit();
	  			e.printStackTrace();
	  		}
	    }
	  	
	    public void btnEdit(Categoria selectedItem) {
	  	  isEdit = true;
	  	  this.categoria =  selectedItem;
	  	}
	  	
	  
	    public void btnAdd() {
			setEdit(false);
			this.categoria = new Categoria();
		}
	    
	  	public void btnCancel() {
	  		getInit();
	  	}
	  	
	  	public void btnSave() {
			String msg = "";
			try {
				if(isEdit){
				  categoriaService.edit(categoria);
				  msg = "Editado com Successo";
				}else {
				  categoriaService.createNew(categoria);
				  msg = "Inserido com Successo";  
				}
				FacesContext context = FacesContext.getCurrentInstance();  
	  	        context.addMessage(null, new FacesMessage(msg, "Info!"));  
	  	        getInit();
				RequestContext.getCurrentInstance().execute("categoriaDialog.hide();");
	  		} catch (Exception e) {
	  			FacesContext context = FacesContext.getCurrentInstance();  
	  	        context.addMessage(null, new FacesMessage("Erro ao persistir informa��o!", "Erro!"));
	  	        getInit();
	  			e.printStackTrace();
	  		}
		}
	  	
	  	
	  	
	  	
	  	/*GETTERS AND SETTERS*/

		public List<Categoria> getCategorias() {
			return categorias;
		}

		
		public void setCategorias(List<Categoria> categorias) {
			this.categorias = categorias;
		}

		public Categoria getCategoria() {
			return categoria;
		}

		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}

		public boolean isEdit() {
			return isEdit;
		}

		public void setEdit(boolean isEdit) {
			this.isEdit = isEdit;
		}
	    
}
