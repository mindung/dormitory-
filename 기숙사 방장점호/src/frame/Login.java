package frame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.Result;

public class Login extends BaseFrame{

	private JTextField tf[] = {new JTextField(), new JPasswordField()};
	
	public Login() {
		super("�α���", 330, 150);
		
		var pnl = new JPanel(new BorderLayout());
		var panel = new JPanel(new GridLayout(2, 2, -100, 10));
		var str = "���̵�,��й�ȣ".split(",");
		var btn = new JButton("�α���");
		
		for (int i = 0; i < tf.length; i++) {
			panel.add(new JLabel(str[i]));
			panel.add(tf[i]);
		}
		
		pnl.add(panel, BorderLayout.CENTER);
		pnl.add(btn, BorderLayout.EAST);
		
		add(pnl);
		btn.addActionListener(e -> login());
	}
	
	private void login() {
		String id = tf[0].getText();
		String pw = tf[1].getText();
		
		if(id.isEmpty() || pw.isEmpty()) {
			eMessage("��ĭ�� �����մϴ�.");
		} else {
			try {
				var rs = dbManager.executeQuery("select * from user where id = ? and pw = ?", id, pw);
				if (rs.next()) {
					u_no = rs.getInt(1);
					iMessage(String.format("%s���� �α��� �Ͽ����ϴ�.", rs.getString(4)));
					openFrame(new RoomManage1());
				} else {
					eMessage("��ġ�ϴ� ȸ���� �����ϴ�.");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new Login().setVisible(true);
	}
}

