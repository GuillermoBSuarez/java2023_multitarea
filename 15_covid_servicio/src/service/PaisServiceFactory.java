package service;

public class PaisServiceFactory {
	
	public static PaisService getPaisService() {
		return new PaisServiceImpl();
	}
}