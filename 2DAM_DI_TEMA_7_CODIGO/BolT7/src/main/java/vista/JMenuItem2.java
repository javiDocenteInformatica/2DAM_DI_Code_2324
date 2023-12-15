package vista;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JMenuItem;

public class JMenuItem2 extends JMenuItem implements ItemListener{

	private int id;
	
	
	public JMenuItem2() {
		super();
	}
	
	public JMenuItem2(int id, String text) {
		super(text);
		this.id=id;
		
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	

}
