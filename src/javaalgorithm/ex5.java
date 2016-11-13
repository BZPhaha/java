package javaalgorithm;

import javax.swing.JOptionPane;

public class ex5 {

public static void main(String[] args){

String str="";

str=JOptionPane.showInputDialog("������N��ֵ������exit�˳�����");

int N;

N=0;

try{

N=Integer.parseInt(str);

}

catch(NumberFormatException e){

e.printStackTrace();

}

str=(N>90?"A":(N>60?"B":"C"));

System.out.println(str);

}

}