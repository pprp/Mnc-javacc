package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

public class WindowOP {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencySmallShadow;
		} catch (Exception e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowOP window = new WindowOP();

					window.frame.setVisible(true);
					window.frame.setOpacity(0.9f);
					window.frame.setTitle("Mnc编译器");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WindowOP() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 956, 669);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton_0 = new JButton("选择文件");
		btnNewButton_0.setFont(new Font("宋体", Font.BOLD, 15));
		btnNewButton_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_0.setBounds(28, 33, 134, 40);
		frame.getContentPane().add(btnNewButton_0);

		JButton btnNewButton_1 = new JButton("词法分析");
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 15));
		btnNewButton_1.setBounds(269, 33, 134, 40);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("语法分析");
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 15));
		btnNewButton_2.setBounds(514, 33, 128, 40);
		frame.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("语义分析");
		btnNewButton_3.setFont(new Font("宋体", Font.BOLD, 15));
		btnNewButton_3.setBounds(751, 33, 128, 40);
		frame.getContentPane().add(btnNewButton_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 83, 851, 494);
		frame.getContentPane().add(scrollPane);

		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		Font font = new Font("宋体",Font.BOLD,16);
		textArea.setFont(font);

		OperatorListener lis = new OperatorListener();
		lis.setTextShow(textArea);
		btnNewButton_0.addActionListener(lis);
		btnNewButton_1.addActionListener(lis);
		btnNewButton_2.addActionListener(lis);
		btnNewButton_3.addActionListener(lis);

	}
}
