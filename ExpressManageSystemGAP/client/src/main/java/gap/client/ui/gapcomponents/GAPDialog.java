package gap.client.ui.gapcomponents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GAPDialog extends JDialog {
	private static final int WIDTH = 500, HEIGHT = 300;
	JScrollPane jspane;
	JScrollBar jsbar;
	JTextArea textArea;
	public JButton cancel;
	public JButton reconnect;
	public JButton confirm;
	public JButton cancelConnect;
	Frame frame;

	public GAPDialog(Frame frame, String title, boolean modal) {
		super(frame, title, modal);
		this.frame = frame;
		textArea = new JTextArea();
		textArea.setBackground(Color.white);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setFont(ComponentStyle.defaultFont);
		textArea.setAlignmentX(0.5f);
		textArea.setBorder(BorderFactory.createEmptyBorder());
		jspane = new JScrollPane(textArea);
		jsbar = jspane.getVerticalScrollBar();
		cancel = new GAPButton("取消");
		cancel.setFont(ComponentStyle.defaultFont);
		reconnect = new GAPButton("重新连接");
		reconnect.setFont(ComponentStyle.defaultFont);
		confirm = new GAPButton("确定");
		confirm.setFont(ComponentStyle.defaultFont);
		cancelConnect = new GAPButton("取消连接");
		cancelConnect.setFont(ComponentStyle.defaultFont);
		JPanel jp = new JPanel();
		jp.setBackground(Color.white);
		jp.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		jp.add(reconnect);
		jp.add(confirm);
		jp.add(cancel);
		add(jspane, BorderLayout.CENTER);
		add(jp, BorderLayout.SOUTH);
		setLocationRelativeTo(frame);
		setSize(WIDTH, HEIGHT);
	}

	public JButton getCancelButton() {
		return cancel;
	}

	public JButton getReconnectButton() {
		return reconnect;
	}

	public void showMessage(String message) {
		int x = frame.getX() + (frame.getWidth() - WIDTH) / 2, y = frame.getY()
				+ (frame.getHeight() - HEIGHT) / 2;
		setLocation(x, y);
		textArea.append(message + "\n");
		int value = jsbar.getMaximum() - jsbar.getVisibleAmount();
		jsbar.setValue(value);
		repaint();
		setVisible(true);
	}

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.setBounds(500, 500, 200, 200);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		GAPDialog dia = new GAPDialog(jf, "测试", true);
		dia.showMessage("这是一个测试这是一个测试这是一个测试这是一个测试这是一个测试这是一个测试这是一个测试这是一个测试");

	}
}
