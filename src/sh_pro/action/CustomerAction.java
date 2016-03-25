package sh_pro.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import sh_pro.listener.CustomerListener;
import sh_pro.model.Customer;

public class CustomerAction extends ActionSupport implements ModelDriven{
    
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Customer cust=new Customer();
	List<Customer> list=new ArrayList<Customer>();
	
	public String execute() throws Exception{
		return SUCCESS;
	}
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return cust;
	}

	public List<Customer> getList() {
		return list;
	}

	public void setList(List<Customer> list) {
		this.list = list;
	}
	
	@SuppressWarnings("unchecked")
	public String addCust() throws Exception{
		SessionFactory factory=(SessionFactory) ServletActionContext.getServletContext()
				.getAttribute(CustomerListener.KEY_NAME);
		
		Session session =factory.openSession();
		
		cust.setCreate_date(new Date());
		session.beginTransaction();
		session.save(cust);
		session.getTransaction().commit();
		
		list=null;
		list=session.createQuery("from Customer").list();
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String listCust() throws Exception{
		SessionFactory factory=(SessionFactory) ServletActionContext.getServletContext()
				.getAttribute(CustomerListener.KEY_NAME);
		Session session=factory.openSession();
	    
		list=session.createQuery("from Customer").list();
		return SUCCESS;
	}
    
	
}
