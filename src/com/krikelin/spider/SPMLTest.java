package com.krikelin.spider;

import java.io.InputStream;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class SPMLTest {
	/**
	 * Creates an test label
	 * @param text
	 * @param flex
	 * @param webview
	 * @return 
	 */
	protected static text createText(String text,int flex,SPWebView webview,int width)
	{
		text d = new text(webview);
		d.setText(text);
		d.setFlex(flex);
		d.setHeight(20);
		d.setWidth(width);
		return d;
	}
	/**
	 * 
	 */
	protected static Element Spider(SPWebView webview,int flex,int box_type,int count,int width)
	{
		Element box = null;
		switch(box_type)
		{
		case 0:
			box = new hbox(webview);
			break;
		case 1:
			box = new vbox(webview);
			break;
		
		}
		for(int i=0; i < count; i++)
		{
			int xflex = 0;
			if(i == 0)
				xflex = 0;
			if(i > 0 && i < count -1)
				xflex = 1;
			box.getChildren().add(createText(String.format("test %s",i),xflex,webview,120));
		}
		box.setWidth(width);
		box.setFlex(flex);
		return box;
		
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args){
		JFrame frame = new JFrame();
		JComponent sw = null;
		SPWebView webview = new SPWebView(sw);
		InputStream stream = SPMLTest.class.getResourceAsStream("boxmodel.xml");
		webview.loadMarkup(stream, null);
		frame.add(webview);
 		frame.show(); 
	} 
}