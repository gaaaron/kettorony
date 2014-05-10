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
			SideMenu.sideMenu.zoldcount.setText(String.format("%4d", jatekos.varazskoszam[6]));
			SideMenu.sideMenu.kekcount.setText(String.format("%4d", jatekos.varazskoszam[1]));
			SideMenu.sideMenu.sargacount.setText(String.format("%4d", jatekos.varazskoszam[5]));
			SideMenu.sideMenu.piroscount.setText(String.format("%4d", jatekos.varazskoszam[4]));
			SideMenu.sideMenu.narancscount.setText(String.format("%4d", jatekos.varazskoszam[3]));
			SideMenu.sideMenu.barnacount.setText(String.format("%4d", jatekos.varazskoszam[0]));
			SideMenu.sideMenu.lilacount.setText(String.format("%4d", jatekos.varazskoszam[2]));
			SideMenu.sideMenu.repaint();
		}
	}

}
