package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import parser.*;
import javax.swing.*;

public class OperatorListener implements ActionListener {
	JTextArea textShow;

	public mnc minic;
	static int k = 1;
	public static String chooseFilePath;

	public void setTextShow(JTextArea textShow) {
		this.textShow = textShow;
	}

	// 文件选择实现
	void chooseFile() {
		JFileChooser fc = new JFileChooser();
		File dir = new File("./src/testFile");
		fc.setCurrentDirectory(dir);
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.showOpenDialog(null);
		chooseFilePath = fc.getSelectedFile().getAbsolutePath();
		System.out.println(chooseFilePath);
	}

	// 写到面板
	void SetTextArea(String filePath) {
		try {
			textShow.setText("");
			System.out.println("文件路径为：" + filePath);
			FileReader reader = new FileReader(new File(filePath));
			BufferedReader bReader = new BufferedReader(reader);
			String string = null;
			
			while ((string = bReader.readLine()) != null) {
				if(string.equals(""))
					continue;
				textShow.append(string + '\n');
			}
			
//			System.out.println("-=-=-=-=-=-=-=-=-=-\n"+(mnc.haveError));
//			System.out.print(mnc.S);
//			System.out.print("list大小为："+mnc.mynodelist.getSize() + "\n");

			if(mnc.haveError)
			{
				textShow.append("*****************************************\n");
				textShow.append(mnc.S);
				textShow.append("\n");
			}
			reader.close();
			bReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		String str = e.getActionCommand();// str可以为“词法分析”，“语法分析”，“语义分析”
		System.out.println(str);

		if (str == "选择文件") {
			chooseFile();
			try {
				if(chooseFilePath != null)
					mnc.run(chooseFilePath);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			SetTextArea(chooseFilePath);
		} else if (str == "词法分析") {
			try {
				//mnc.cifa(chooseFilePath);
				SetTextArea(mnc.cifaFile);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (str == "语法分析") {
			SetTextArea(mnc.yufaFile);
		} else if (str == "语义分析") {
			SetTextArea(mnc.yuyiFile);

		} else {
			textShow.setText("error accured！");
		}
	}

}