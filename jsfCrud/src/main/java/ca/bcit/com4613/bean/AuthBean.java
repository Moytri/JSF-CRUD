package ca.bcit.com4613.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class AuthBean implements Serializable{	

	private static final long serialVersionUID = 1L;

	public void redirect() throws IOException{
		
	    ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();

	    if (context.isUserInRole("admin")){
	        context.redirect("faces/admin/index.xhtml");
	    }
	    else {
	        context.redirect("faces/user/index.xhtml");
	    }
	}
	
	public void logout() throws IOException {
	    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	    ec.invalidateSession();
	    ec.redirect(ec.getRequestContextPath() + "/faces/index.xhtml");
	}	
}
