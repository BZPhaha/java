package xmlTojson;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;


/**
 * 
 * 将xml转为json格式
 * @author BZP
 *
 */


public class xmlTojson {
	public static  String xmlToJSON(String xml,int jsonType) {
		JSONObject obj = new JSONObject();
		try {
			InputStream is = new ByteArrayInputStream(xml.getBytes("utf-8"));
			SAXBuilder sb = new SAXBuilder();
			Document doc = sb.build(is);
			Element root = doc.getRootElement();
			Map map=iterateElement(root);
		   obj.put(root.getName(),map);
		   return obj.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


@SuppressWarnings({ "unchecked", "rawtypes" })
	private static Map  iterateElement(Element root) {
		List childrenList = root.getChildren();
		Element element = null;
		Map map = new HashMap();
		List list = null;
		for (int i = 0; i < childrenList.size(); i++) {
			list = new ArrayList();
			element = (Element) childrenList.get(i);
			if(element.getChildren().size()>0){
				if(root.getChildren(element.getName()).size()>1){
					if (map.containsKey(element.getName())) {
						list = (List) map.get(element.getName());
					}
					list.add(iterateElement(element));
					map.put(element.getName(), list);
				}else{
					map.put(element.getName(), iterateElement(element));
				}
			}else {
                if(root.getChildren(element.getName()).size()>1){
                	if (map.containsKey(element.getName())) {
    					list = (List) map.get(element.getName());
    				}
                	list.add(element.getTextTrim());
                	map.put(element.getName(), list);
				}else{
					map.put(element.getName(), element.getTextTrim());
				}
			}
		}
		
		return map;
	}
	


	public static void main(String[] args) throws ParseException
	{		
		String xml="<ROOT>"+
		"<name>Sayalic</name>"+
	    "<age>25</age>"+
	    "<girlfriend>null</girlfriend>"+
	    "<gayfriend>"+
	        "<age>24.5</age>"+
	        "<name>dploop</name>"+
	        "<FavoriteFruits>pear</FavoriteFruits>"+
	        "<FavoriteFruits>lemon</FavoriteFruits>"+
	    "</gayfriend>"+
	    "<FavoriteFruits>orange</FavoriteFruits>"+
	    "<FavoriteFruits>banana</FavoriteFruits>"+
	    "<FavoriteFruits>apple</FavoriteFruits>"+
	    "</ROOT>"
	    ;

		
	    String str=xmlTojson.xmlToJSON(xml,1);
      System.out.println(str);
	}
}
