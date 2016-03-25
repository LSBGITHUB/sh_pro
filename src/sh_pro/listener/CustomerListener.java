package sh_pro.listener;

import java.net.URL;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CustomerListener implements ServletContextListener{
	
	private Configuration config;
	private SessionFactory factory;
	private String path="/hibernate.cfg.xml";
	private static Class clazz=CustomerListener.class;
	
	public static final String KEY_NAME=clazz.getName();

	
	
	
	
	
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void contextInitialized(ServletContextEvent event) {
		
		// TODO Auto-generated method stub
		try {
			URL url=CustomerListener.class.getResource(this.path);
			config=new Configuration().configure(url);
			factory=config.buildSessionFactory();
			//将hibernate.hbm.xml保存到Servlect上下文
			event.getServletContext().setAttribute(KEY_NAME,factory);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
