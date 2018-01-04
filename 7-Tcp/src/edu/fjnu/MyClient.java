package edu.fjnu;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class MyClient extends JFrame{
	private BufferedReader reader;
	private PrintWriter writer;//
	Socket socket;
	private JTextArea ta = new JTextArea();
	private JTextField tf = new JTextField();
	Container cc;//
	public MyClient(String title){
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cc = this.getContentPane();
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
		getContentPane().add(scrollPane,BorderLayout.CENTER);
		scrollPane.setViewportView(ta);
		cc.add(tf,"South");
		
		tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				writer.println(tf.getText());			
				ta.append("客户端-发送："+tf.getText()+"\n");
				ta.setSelectionEnd(ta.getText().length());
				tf.setText("");
			}
		});
	}
	
	private void connect(){
		ta.append("尝试连接\n");
		try {
			socket = new Socket("127.0.0.1",8998);
			writer = new PrintWriter(socket.getOutputStream(),true);
			ta.append("完成连接\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void msgMgr(){
		try {
			while(true){
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				getServerMessage();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void getServerMessage() {
		try {
			while (true) {
				String msg = "接收-服务器:" + reader.readLine()+"\n";
				System.out.print(msg);
				ta.append(msg);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		try {
			if (reader != null) {
				reader.close();
			}
			if (socket != null) {
				socket.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		MyClient client = new MyClient("客户端");
		client.setSize(300, 500);
		client.setVisible(true);
		client.connect();
		client.msgMgr();
	}
}
