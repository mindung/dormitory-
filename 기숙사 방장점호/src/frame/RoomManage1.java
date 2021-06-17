package frame;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RoomManage1 extends BaseFrame{

	public RoomManage1() {
		super("¹æÀåÁ¡È£ Ãþ Á¤ÇÏ±â", 400, 600);
		
		var b = new JButton("È¨À¸·Î");
		var panel = new JPanel(new GridLayout(4, 1, 0, 5));
		add(panel);
		
		var pnl = new JPanel();
		pnl.add(createLabel("¹æÀå Á¡È£ Ãþ Á¤ÇÏ±â", JLabel.CENTER,"¸¼Àº °íµñ" ,Font.BOLD, 30), BorderLayout.NORTH);
		pnl.add(b);
		add(pnl, BorderLayout.NORTH);
		
		for (int i = 4; i >= 1; i--) {
			int f = i;
			var btn = new JButton(String.format("%dÃþ", i));
			panel.add(btn);
			btn.addActionListener(e -> {
				u_floor = f;
				openFrame(new RoomManage2());
			});
		}
		
		b.addActionListener(e -> openFrame(new Main()));
	}
	
	public static void main(String[] args) {
		new RoomManage1().setVisible(true);
	}
}
