package SMWriter;

import Components.wMeasure;
import Components.wNote;
import Components.wPart;

public class partToString {
	wPart part;
	String line1 ="  __T_";
	String line2 ="  ____";
	String line3 ="  __A_";
	String line4 ="  ____";
	String line5 ="  __B_";
	String line6 ="  ____";
	
	public partToString(wPart part) {
		this.part=part;
	}
	
	public void generateString() {
		for(wMeasure mea:part.getMeasures()) {
			for(int k=0;k<mea.getNotes().size();k++) {
				wNote not = mea.getNotes().get(k);
				int l = mea.getDivisions();
				int l1 = 5;
				if(not.getType().equals("full")) {
					l1=l-1;
				}
				else if(not.getType().equals("half")) {
					l1=(int) (l*0.5-1);
				}
				else if(not.getType().equals("quarter")) {
					l1=(int) (l*0.25-1);
				}
				else if(not.getType().equals("eighth")) {
					l1=(int) (l*0.125-1);
				}
				else if(not.getType().equals("16th")) {
					l1=(int) (l*(1/16)-1);
				}
				else {
					System.out.println(not.getType());
				}
				char a[] = {'x','x','x','x','x','x'};
				if(not.getFret()>=0 && not.getFret()<=9) a[not.getNoteString()-1] = (char) (not.getFret()+48);
				else if(not.getFret()>=10 && not.getFret()<=20)	a[not.getNoteString()-1] = (char) (not.getFret()-10+39);
				for(int j=0;j<6;j++) {
					if(a[j]=='x') {
						a[j]='_';
					}
				}
			try{
				wNote next = mea.getNotes().get(k+1);
				if(next.getChord()==true) {
					if(next.getFret()>=0 && next.getFret()<=9) a[next.getNoteString()-1] = (char) (next.getFret()+48);
					else if(next.getFret()>=10 && next.getFret()<=20)	a[next.getNoteString()-1] = (char) (next.getFret()-10+39);
					k++;
				}
			}
			catch(Exception E)
			{
				
			}
				this.writeLine(a);
				this.writeLine(l1*2);
			}
			line1+="\\__";
			line2+="|__";
			line3+="|__";
			line4+="|__";
			line5+="|__";
			line6+="/__";
			
		}
		line1 = line1.substring(0, line1.length()-2);
		line2 = line2.substring(0, line2.length()-2);
		line3 = line3.substring(0, line3.length()-2);
		line4 = line4.substring(0, line4.length()-2);
		line5 = line5.substring(0, line5.length()-2);
		line6 = line6.substring(0, line6.length()-2);
	}
	
	private void writeLine(char[] a) {
			line1+=a[0];
			line2+=a[1];
			line3+=a[2];
			line4+=a[3];
			line5+=a[4];
			line6+=a[5];
	}
	
	private void writeLine(int l) {
		for(int i=0;i<l;i++) {
			line1+='_';
			line2+='_';
			line3+='_';
			line4+='_';
			line5+='_';
			line6+='_';
		}
	}
	
	private void printStr() {
		System.out.println(line1);
		System.out.println(line2);
		System.out.println(line3);
		System.out.println(line4);
		System.out.println(line5);
		System.out.println(line6);
	}
	
	public String getString() {
		return line1+"\n"+line2+"\n"+line3+"\n"+line4+"\n"+line5+"\n"+line6;
	}
}
