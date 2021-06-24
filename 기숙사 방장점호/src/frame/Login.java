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
		super("로그인", 330, 150);
		
		var pnl = new JPanel(new BorderLayout());
		var panel = new JPanel(new GridLayout(2, 2, -100, 10));
		var str = "아이디,비밀번호".split(",");
		var btn = new JButton("로그인");
		
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
			eMessage("빈칸이 존재합니다.");
		} else {
			try {
				var rs = dbManager.executeQuery("select * from user where id = ? and pw = ?", id, pw);
				if (rs.next()) {
					u_no = rs.getInt(1);
					iMessage(String.format("%s님이 로그인 하였습니다.", rs.getString(4)));
					openFrame(new RoomManage1());
				} else {
					eMessage("일치하는 회원이 없습니다.");
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

