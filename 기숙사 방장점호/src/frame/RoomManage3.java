package frame;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RoomManage3 extends BaseFrame{

	public RoomManage3() {
		super("ȣ�� ���ϱ�", 800, 600);

		var b = new JButton("Ȩ����");
		var pnlC = new JPanel(new BorderLayout());
		
		var panel = new JPanel(new GridLayout(1, 2, 0, 5));
		pnlC.add(panel, BorderLayout.NORTH);
		add(pnlC, BorderLayout.CENTER);
		
		var pnl = new JPanel();
		pnl.add(createLabel("������ȣ �а� ����", JLabel.CENTER,"���� ���" ,Font.BOLD, 30), BorderLayout.NORTH);
		pnl.add(b);
		add(pnl, BorderLayout.NORTH);
		
		var str = "�ڵ�ȭ ����, �������������".split(",");
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
