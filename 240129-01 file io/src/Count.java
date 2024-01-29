import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Count extends JFrame {
	private int count = 0;
	public Count() {
		JPanel pnlCenter = new JPanel();
		JButton btnCount = new JButton("올라감");
		
		btnCount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				increaseCount();
			}
		});
		add(pnlCenter);
		pnlCenter.add(btnCount);
		
		showGUI();
	}
	
	private void increaseCount() {
		count++;
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(new File("d:\\mydata\\count.txt")));
			pw.print(count);
			pw.flush();	
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
		System.out.println("카운트 :" + count);
	}
	

	private void showGUI() {
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Count();
	}
}
