package org.LYG.document.neroCell;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JTextPane;

import org.LYG.GUI.extOSGI.OSGI_chansfer;
import org.LYG.GUI.nodeEdit.LinkNode;
public class BootNeroCell{
	@SuppressWarnings("unused")
	public static void bootCell(LinkNode linkNode, JTextPane rightBotJTextPane) throws IOException, UnsupportedAudioFileException, InterruptedException {
		Map<String,String> nodeMaps= new HashMap<>();
		//�Ƚ��и��ڵ㴦������ȴ���
		LinkNode currentNode= linkNode;
		while(null!= currentNode) {
			if(!currentNode.beconnect&& null!= currentNode.thisFace&& !currentNode.thisFace.nodeConfiguration.isEmpty()) { //��֮������һ�׹淶����
				//����
				currentNode.thisFace.config(rightBotJTextPane);
				//ȡֵ
				new OSGI_chansfer(currentNode, linkNode);
				//����
				currentNode.thisFace.execute(rightBotJTextPane);
			}
		}
		//׼��д����������������������ȸ����°汾 1.0.3_beta, �⼸�����ơ�20190617 8��28 ������
		
 	}
}