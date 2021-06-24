package frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RoomManage3 extends BaseFrame{

	JPanel pnlC = new JPanel(new BorderLayout());
	public RoomManage3() {
		super("ȣ�� ���ϱ�", 800, 600);

		add(pnlC, BorderLayout.CENTER);
		
		var pnlG = new JPanel(new GridLayout(2, 1));
		add(pnlG, BorderLayout.NORTH);

		var pnl = new JPanel();		
		pnlG.add(pnl);
		pnlG.add(createLabel(String.format("%d��", u_floor), JLabel.CENTER, "���� ���", Font.BOLD, 25));
		
		var b = new JButton("��������");
		pnl.add(createLabel("������ȣ �а� ����", JLabel.CENTER, "���� ���", Font.BOLD, 30));
		pnl.add(b);
		b.addActionListener(e -> openFrame(new RoomManage1()));

		var str = "�ڵ�ȭ ����,�������� �����".split(",");
		var panel = new JPanel(new FlowLayout());
		pnlC.add(panel, BorderLayout.NORTH);

		for (int i = 0; i < str.length; i++) {
			var btn = new JButton(str[i]);
			btn.setPreferredSize(new Dimension(150, 100));
			panel.add(btn);
			if (!u_def.equals(str[i])) {
				btn.setEnabled(false);
			}
		}
		
	}
	
	private void getRoomInfo() {
		var panel = new JPanel(new FlowLayout());
		pnlC.add(panel, BorderLayout.SOUTH);
		try {
			var rs = dbManager.executeQuery("SELECT * FROM dormitory.room where room like '" +  u_floor + "%'");
			while (rs.next()) {
				panel.add(new JButton(rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new RoomManage3().setVisible(true);
	}
}
