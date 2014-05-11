package view;

//BaseView interfész, a View osztályokat definiálja
public interface BaseView {

//notifyChanged metódus, amely akkor hívódik, hogyha az objektum állapotában változás következik be
	public void notifyChanged();

//paint metódus, segítségével rajzoljuk ki az objektumokat
	public void paint();
	
}
