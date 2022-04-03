package pfpsc.util;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

public class MapUtility {
	public static String getInformationByString(String string){
		return string.split("\\?")[0];
	}
	public static Map<String,String> getMapByString(String string){
		String[] strlist=string.split("\\?");
		String str=strlist[1];
		String[] mpstr=str.split(";");
		Map<String,String> map=new HashedMap<String, String>();
		for(String item:mpstr) {
			String[] tmpString=item.split(":");
			map.put(tmpString[0], tmpString[1]);
		}
		return map;
	}
	public static String makeString(String type, Integer id,Map<String,String> map) {
		String string="";
		string+=type+id+"?";
		for(String item:map.keySet()) {
			string+=(item+":"+map.get(item)+";");
		}
		return string;
	}
}
