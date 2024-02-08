import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Count extends JFrame {
	private JLabel lbl;
	private Timer timer;
	private final MyMessageLogger logger;
	private final File logFile = new File("d:\\mydata\\countChange.txt");
	
	public Count() {
		logger = new MyMessageLogger(logFile);
		
		JPanel pnl = new JPanel();
		lbl = new JLabel("1");
		JButton btn = new JButton("딸깍");
		JButton btnclose = new JButton("저장 및 종료");

		pnl.add(lbl);
		pnl.add(btn);
		pnl.add(btnclose);
		add(pnl);
	 
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startTimer();
			}
		});
		
		btnclose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveLastNumber(lbl.getText());
				dispose();
				System.exit(0);
			}
		});

		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void startTimer() {
		if (timer != null) {
			timer.cancel();
		}

		int initialDelay = 0;
		int period = 100;

		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			int count = Integer.parseInt(lbl.getText());
			@Override
			public void run() {
				count++;
				lbl.setText(Integer.toString(count));
				logger.saveLog(lbl.getText());
			}
		}, initialDelay, period);
	}

	private void saveLastNumber(String numberText) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("d:\\mydata\\lastnumber.txt");
			pw.println(numberText);
			pw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}
	private String readLastNumber() {
		File file = new File ("d:\\mydata\\lastnumber.txt");
		String defaultValue = "1";
		if (!file.exists()) {
			return defaultValue;
		}
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("d:\\mydata\\lastnumber.txt"));
			String numberValue = br.readLine();
			
			Integer.valueOf(numberValue);
			
			return numberValue;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return defaultValue;
	}
	
	
	public static void main(String[] args) {
		new Count();
	}
}











