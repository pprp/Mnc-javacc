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

	// �ļ�ѡ��ʵ��
	void chooseFile() {
		JFileChooser fc = new JFileChooser();
		File dir = new File("./src/testFile");
		fc.setCurrentDirectory(dir);
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.showOpenDialog(null);
		chooseFilePath = fc.getSelectedFile().getAbsolutePath();
		System.out.println(chooseFilePath);
	}

	// д�����
	void SetTextArea(String filePath) {
		try {
			textShow.setText("");
			System.out.println("�ļ�·��Ϊ��" + filePath);
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
//			System.out.print("list��СΪ��"+mnc.mynodelist.getSize() + "\n");

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
		// TODO �Զ����ɵķ������
		String str = e.getActionCommand();// str����Ϊ���ʷ������������﷨�������������������
		System.out.println(str);

		if (str == "ѡ���ļ�") {
			chooseFile();
			try {
				if(chooseFilePath != null)
					mnc.run(chooseFilePath);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			SetTextArea(chooseFilePath);
		} else if (str == "�ʷ�����") {
			try {
				//mnc.cifa(chooseFilePath);
				SetTextArea(mnc.cifaFile);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (str == "�﷨����") {
			SetTextArea(mnc.yufaFile);
		} else if (str == "�������") {
			SetTextArea(mnc.yuyiFile);

		} else {
			textShow.setText("error accured��");
		}
	}

}