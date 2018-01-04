package edu.fjnu;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

/**
 * @author Administrator
 *
 */
public class MyTcp extends JFrame{
	private BufferedReader reader;
	private ServerSocket server;
	private Socket socket;
	private PrintWriter writer;//
	private JTextArea ta = new JTextArea();
	private JTextField tf = new JTextField();
	Container cc;//
	public MyTcp(String title) {
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
				writer.println(tf.getText());//写入到输入流		
				ta.append("服务器-发送："+tf.getText()+"\n");//把自己发送的信息追加到ta控件上
				ta.setSelectionEnd(ta.getText().length());
				tf.setText("");
			}
		});
	}
	
	void getServer() {
		try {
			server = new ServerSocket(8998);
			System.out.println("服务器套接字已经创建成功");
			while (true) {
				System.out.println("等待客户机的连接");
				socket = server.accept();
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				writer = new PrintWriter(socket.getOutputStream(),true);
				getClientMessage();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getClientMessage() {//获得客户端信息
		try {
			while (true) {
				String str = "接收-客户端:" + reader.readLine()+"\n";
				System.out.print(str);//打印到控制台
				ta.append(str);//追加到 textFiled控件上
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
		MyTcp tcp = new MyTcp("服务端");
		tcp.setSize(300, 500);
		tcp.setVisible(true);
		tcp.getServer();
	}

}
