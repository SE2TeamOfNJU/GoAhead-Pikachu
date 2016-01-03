package gap.client.ui.LoginUI;

import gap.client.datacontroller.NetModule;
import gap.client.ui.BaseListener.MoveListener;
import gap.client.ui.UITools.RenderSetter;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class LoginFrame extends JFrame {
	static LoginFrame loginFrame;
	LoginPanel loginPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					final LoginFrame frame = new LoginFrame();
					NetModule.initial(frame);
					new Thread(new Runnable() {

						@Override
						public void run() {
							// TODO 自动生成的方法存根
							NetModule.connect();
							loginFrame = frame;
							setVi(true);
						}
					}).start();

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	public static void setVi(boolean bool) {
		loginFrame.setVisible(bool);
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setResizable(false);
//		JFrame.setDefaultLookAndFeelDecorated(true);
		setUndecorated(true);
		setBackground(new Color(0, 0, 0, 0));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(430, 330);

		setLocationRelativeTo(null);
//		setVisible(true);

		loginPanel = new LoginPanel(this);
		setContentPane(loginPanel);
		// getContentPane().setLayout(null);
		// getContentPane().add(loginPanel);
		MoveListener movelistener = new MoveListener(this);
		addMouseListener(movelistener);
		addMouseMotionListener(movelistener);
	}
}
