package view;

//BaseView interf�sz, a View oszt�lyokat defini�lja
public interface BaseView {

//notifyChanged met�dus, amely akkor h�v�dik, hogyha az objektum �llapot�ban v�ltoz�s k�vetkezik be
	public void notifyChanged();

//paint met�dus, seg�ts�g�vel rajzoljuk ki az objektumokat
	public void paint();
	
}
