package view;

import szoftlab4.Jatekos;

public class JatekosView implements BaseView {

	private Jatekos jatekos;
	
	public JatekosView(Jatekos j){
		jatekos = j;
	}
	
	@Override
	public void notifyChanged() {
		Drawables.getInstance().remove(this);
		Drawables.getInstance().add(this);	
	}

	public void paint() {
		//TODO: köveket is jelezzük ki..
		if(SideMenu.sideMenu != null){
			SideMenu.sideMenu.varazsero.setText(String.format("%4d", jatekos.varazsero));
			SideMenu.sideMenu.repaint();
		}
	}

}
