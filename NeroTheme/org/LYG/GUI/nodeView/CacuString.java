package org.LYG.GUI.nodeView;
public class CacuString {
	//��δ���ټ��㣬������������������ũ��������
	public String cauString(String tr){
		String currentString = new String("");
		if(tr.equals("Node")){return null;}
		char[] a = new char[tr.length()];
		for(int i = 0;i < tr.length(); i++) {
			a[i] = tr.charAt(i);
		}
		for(int i = 0;i < tr.length(); i++){
			if(a[i] == 't' && a[i + 1] == 'e' && a[i + 2] == 'x' && a[i + 3] == 't'){
				for(int j = i + 5; a[j] != ','; j++){
					currentString = currentString + a[j];   
				}
				return currentString;
			}
		}
		return currentString;
	}
}
