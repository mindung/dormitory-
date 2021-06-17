package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Main extends BaseFrame{

	
	public Main() {
		super("∏ﬁ¿Œ", 450, 450);
		
		var panel = new JPanel(new GridLayout(2, 2));
		var str = "πÊ¿Â ¡°»£, π˙¡°&ªÛ¡°, ∞‘Ω√∆«, §©§∑".split(",");
		for (int i = 0; i < str.length; i++) {
			var btn = new JButton(str[i]);
			panel.add(btn);
			btn.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 25));
			btn.setForeground(Color.WHITE);
			if (i == 0) {
				btn.setBackground(Color.red);
			} else if (i == 1) {
				btn.setBackground(Color.blue);
				
			} else if (i == 2) {
				btn.setBackground(Color.ORANGE);
			} else {
				btn.setIcon(getIcon("./∞ÌæÁ¿Ã.jpg", 250, 250));
			}
			
			ActionListener a[] = {e -> openFrame(new RoomManage1()),
					e -> openFrame(new RoomManage1()), 
					e -> openFrame(new RoomManage1()),
					e -> iMessage("±Õø©øı")};
			
			btn.addActionListener(a[i]);
		}
		add(panel);
	}
	
	public static void main(String[] args) {
		new Main().setVisible(true);
	}
}
