package org.LYG.GUI.nodeView;
public class CacuString {
	//��δ���ټ��㣬������������������ũ��������
	public String cauString(String string){
		StringBuilder stringBuilder= new StringBuilder();
		if(string.equals("Node")){return null;}
		char[] a= new char[string.length()];
		for(int i= 0; i< string.length(); i++) {
			a[i]= string.charAt(i);
		}
		for(int i= 0; i< string.length(); i++){
			if(a[i]== 't' && a[i+ 1]== 'e' && a[i+ 2]== 'x' && a[i+ 3]== 't'){
				for(int j= i+ 5; a[j]!= ','; j++){
					stringBuilder.append(a[j]);   
				}
				return stringBuilder.toString();
			}
		}
		return stringBuilder.toString();
	}
}
