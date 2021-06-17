package frame;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RoomManage2 extends BaseFrame{

	public RoomManage2() {
		super("학과 선택", 400	, 500);
		
		var b = new JButton("홈으로");
		var panel = new JPanel(new GridLayout(1, 2, 0, 5));
		add(panel);
		
		var pnl = new JPanel();
		pnl.add(createLabel("방장점호 학과 선택", JLabel.CENTER,"맑은 고딕" ,Font.BOLD, 30), BorderLayout.NORTH);
		pnl.add(b);
		add(pnl, BorderLayout.NORTH);
		
		var str = "자동화기계과, 전기전자제어과".split(",");
		for (int i = 0; i < str.length; i++) {
			var btn = new JButton(str[i]);
			btn.setName(str[i]);
			panel.add(btn);
			
			btn.addActionListener(e -> {
				openFrame(new RoomManage3());
				u_def = btn.getName();
			});
		}
		
		b.addActionListener(e ->{
			u_floor = 0;
			openFrame(new RoomManage1());
		});
	}
	
	public static void main(String[] args) {
		new RoomManage2().setVisible(true);
	}
}
