package defaultitf;

public interface Interface2 {
	
	default void m1() {
		System.out.println("coucou itf1::m1");
	}
	
	void m2();
	

}
