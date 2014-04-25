package com.financial.management.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.context.RequestContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.financial.management.entities.Categoria;
import com.financial.management.entities.Conta;
import com.financial.management.entities.Lancamento;
import com.financial.management.service.CategoriaService;
import com.financial.management.service.ContaServiceImp;
import com.financial.management.service.LancamentoService;


@Controller("lancamentoBean")
@ViewScoped
public class LancamentoBean {
	
	private List<Lancamento> lancamentos;
	private Lancamento lancamento;
	private Long contaSelected = null;
	private Long categoriaSelected = null;
	private List<SelectItem> listConta = new ArrayList<SelectItem>();
	private List<SelectItem> listCategoria = new ArrayList<SelectItem>();
	//private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 

	@Resource
	private LancamentoService lancamentoService;
	@Resource
	private  CategoriaService categoriaService;
	@Resource
	private  ContaServiceImp contaService;
	private boolean isEdit;

	@PostConstruct
	public void getInit() {
		// TODO Auto-generated constructor stub
		lancamentos = lancamentoService.getAll();
		setLancamento(new Lancamento());
	}
	    
	
	 /* BUTTONS ACTIONS*/
	
	public void prepareToDelete(Lancamento selectedItem) {
		this.setLancamento(selectedItem);
	}
    public void btnDelete() {
  
  		try {
  			lancamentoService.delete("idLancamento",lancamento.getIdLancemento());
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
  	
    public void btnEdit(Lancamento selectedItem) {
  	  isEdit = true;
  	  this.lancamento =  selectedItem;
      this.populateCategorias();
	  this.populateContas();
  	  
  	}
  	
  
    public void btnAdd() {
		setEdit(false);
		this.lancamento = new Lancamento();
		this.populateCategorias();
		this.populateContas();
	}
    
  	public void btnCancel() {
  		getInit();
  	}
  	
  	public void btnSave() {
		String msg = "";
		try {
			if(isEdit){
			  lancamentoService.edit(lancamento);
			  msg = "Editado com Successo";
			}else {
				lancamento.setConta(contaService.getById((long)1));
				java.util.Date data = new java.util.Date();    
				java.sql.Date dataSql = new java.sql.Date(data.getTime());
				lancamento.setDataLanc(dataSql);	
				lancamento.setCategoria(categoriaService.getById(categoriaSelected));
			    lancamentoService.createNew(lancamento);
			  msg = "Inserido com Successo";  
			}
			FacesContext context = FacesContext.getCurrentInstance();  
  	        context.addMessage(null, new FacesMessage(msg, "Info!"));  
  	        getInit();
			RequestContext.getCurrentInstance().execute("lancamentoDialog.hide();");
  		} catch (Exception e) {
  			FacesContext context = FacesContext.getCurrentInstance();  
  	        context.addMessage(null, new FacesMessage("Erro ao persistir informa��o!", "Erro!"));
  	        getInit();
  			e.printStackTrace();
  		}
	}


  	 /**
	 * Populate Contas
	 */
    
    private void populateContas()
    {
    	listConta.clear();
    	List<Conta> contas = new ArrayList<Conta>();
    	contas = contaService.getAll();
    	listConta.add(new SelectItem(null,""));
    	for (int i = 0; i < contas.size();i++){
    		listConta.add(new SelectItem(contas.get(i).getIdConta(),contas.get(i).getDescricao()));
    	}
    	
    	if (isEdit){
	 		if(this.lancamento != null && this.lancamento.getValor() != null){
	 			contaSelected = this.lancamento.getConta().getIdConta();
	 		}
	 	}
    	
    }
    
    public void clearConta()
   	{
   		contaSelected = null;
   	}
    
    /**
	 * Populate Categorias
	 */
    
    private void populateCategorias()
    {
    	listCategoria.clear();
    	List<Categoria> categorias = new ArrayList<Categoria>();
    	categorias = categoriaService.getAll();
    	listCategoria.add(new SelectItem(null,""));
    	for (int i = 0; i < categorias.size();i++){
    		listCategoria.add(new SelectItem(categorias.get(i).getIdCategoria(),categorias.get(i).getNome()));
    	}
    	
    	if (isEdit){
	 		if(this.lancamento != null && this.lancamento.getValor() != null){
	 			categoriaSelected = this.lancamento.getCategoria().getIdCategoria();
	 		}
	 	}
    	
    }
    
    public void clearCategoria()
	{
		categoriaSelected = null;
	}
  	
    
    /* GETTERS AND SETTERS*/
	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}


	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}


	public Lancamento getLancamento() {
		return lancamento;
	}


	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}


	public boolean isEdit() {
		return isEdit;
	}


	public void setEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}


	public Long getContaSelected() {
		return contaSelected;
	}


	public void setContaSelected(Long contaSelected) {
		this.contaSelected = contaSelected;
	}


	public Long getCategoriaSelected() {
		return categoriaSelected;
	}


	public void setCategoriaSelected(Long categoriaSelected) {
		this.categoriaSelected = categoriaSelected;
	}


	public List<SelectItem> getListCategoria() {
		return listCategoria;
	}


	public void setListCategoria(List<SelectItem> listCategoria) {
		this.listCategoria = listCategoria;
	}


	public List<SelectItem> getListConta() {
		return listConta;
	}


	public void setListConta(List<SelectItem> listConta) {
		this.listConta = listConta;
	}
  	
  	
  	

}
