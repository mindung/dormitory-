package frame;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RoomManage3 extends BaseFrame{

	public RoomManage3() {
		super("호수 정하기", 800, 600);

		var b = new JButton("홈으로");
		var pnlC = new JPanel(new BorderLayout());
		
		var panel = new JPanel(new GridLayout(1, 2, 0, 5));
		pnlC.add(panel, BorderLayout.NORTH);
		add(pnlC, BorderLayout.CENTER);
		
		var pnl = new JPanel();
		pnl.add(createLabel("방장점호 학과 선택", JLabel.CENTER,"맑은 고딕" ,Font.BOLD, 30), BorderLayout.NORTH);
		pnl.add(b);
		add(pnl, BorderLayout.NORTH);
		
		var str = "자동화 기계과, 전기전자제어과".split(",");
		for (int i = 0; i < str.length; i++) {
			var btn = new JButton(str[i]);
			panel.add(btn);
		}
		
		b.addActionListener(e ->{
			u_floor = 0;
			openFrame(new RoomManage1());
		});
	}
	public static void main(String[] args) {
		new RoomManage3().setVisible(true);
	}
}
