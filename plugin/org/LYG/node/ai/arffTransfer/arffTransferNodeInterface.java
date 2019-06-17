package org.LYG.node.ai.arffTransfer;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;

import javax.swing.*;
import org.LYG.GUI.OSGI.*;
import org.json.JSONObject;
public class arffTransferNodeInterface extends ObjectInterface{	
	public arffTransferNodeInterface() throws IOException{
		thisIcon= new ImageIcon(this.getClass().getResource("1.jpg"));
		thisName= new String("arffTransfer");
		position= new String("BI");
		Image img= ((ImageIcon) thisIcon).getImage();  
		Image newimg= img.getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH );
		thisImage= img.getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH );
		thisIcon= new ImageIcon(newimg);
	}
	public void config(JTextPane jTextPane) throws IOException{
		//�ڵ���߼�����Լ�д������������ݴ��� : �ȷ��ž�encode��decodeһ�£���Ͳ������ˡ�
		memoryRecovery(jTextPane);//�������Զ�
		thisNodeConfig();
		memoryRecord(jTextPane);//��������д
		this.isConfiged= true;//��仰ǧ���ɾ�����ǵ��������Զ�ִ�е���Ҫ�۲�ؼ��֡�
	}

	private void thisNodeConfig() throws IOException {
		//�ڵ���߼�����Լ�д������������ݴ��� : �ȷ��ž�encode��decodeһ�£���Ͳ������ˡ�
		thisView= new arffTransferNodeView();
		thisRun= new arffTransferNodeRun();
		thisPanel= new arffTransferNodePanel((arffTransferNodeRun) thisRun);
		thisPanel.config();
		showed= false;
	}
	public void execute(JTextPane jTextPane) throws FileNotFoundException, IOException{
		((arffTransferNodeRun) thisRun).run((arffTransferNodeView) thisView);
		this.isExecuted= true;
	}
	public void view(JTextPane jTextPane) throws Exception{
		thisView.view();
		showed= true;
	}
	public ObjectInterface luoyaoguang() throws CloneNotSupportedException, IOException {
		thisInterface= new arffTransferNodeInterface();
		return thisInterface;  
	}
	private void memoryRecovery(JTextPane jTextPane) {
		//׼�����Ӽ�� nodeConfiguration �Ƿ�������
		try {
			if(null!= nodeConfiguration) {
				//����У����Զ����ã���û�ж����Ե���������������á�
				nodeConfigurationMap= new LinkedHashMap<>();
				JSONObject jSONObject= new JSONObject(nodeConfiguration);
				Iterator<String> iterator= jSONObject.keys();
				//д�Զ����õ� JSON String to MAP ������ȡ��������
				while(iterator.hasNext()) {
					String string= iterator.next();
					nodeConfigurationMap.put(string, jSONObject.getString(string));
				}
			}
		}catch(Exception e) {
			jTextPane.setText(e.getStackTrace().toString());
			jTextPane.validate();
		}
		//������ע�ͣ�20190612
	}

	private void memoryRecord(JTextPane jTextPane) {
		try {
			if(null== nodeConfigurationMap) {
				nodeConfigurationMap= new LinkedHashMap<>(); 
			}
			if(null!= nodeConfigurationMap) {
				//����У����Զ����ã���û�ж����Ե���������������á�
				JSONObject jSONObject= new JSONObject();
				Iterator<String> iterator= nodeConfigurationMap.keySet().iterator();
				//д�Զ����õ� JSON String to MAP ������ȡ��������
				while(iterator.hasNext()) {
					String string= iterator.next();
					jSONObject.put(string, nodeConfigurationMap.get(string));
				}
				jSONObject.put("END", "SURE");
				nodeConfiguration= jSONObject.toString();
			}
		}catch(Exception e) {
			jTextPane.setText(e.getStackTrace().toString());
			jTextPane.validate();
		}
		//������ע�ͣ�20190613
	}
}
