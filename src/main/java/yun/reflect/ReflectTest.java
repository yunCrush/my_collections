package yun.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Author: yunCrush
 * Date: 2022/3/21 15:04
 * Description: java 反射使用
 */
public class ReflectTest {
	static String[] dataArr;
	static String[] fieldArr;
	public static void main(String[] args) {
		String classPath = "";

		try {
			Class clazz = Class.forName(classPath);
			Object obj = clazz.newInstance();
		// 对obj赋值
			setObjValue(clazz,obj,dataArr,fieldArr);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// 实例化异常
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
	}

	public static void setObjValue(Class clazz, Object obj, String[] dataArr, String[] fieldArr)
			throws NoSuchFieldException, IllegalAccessException {
		// 对当前传入的数据校验，长度小于1可不传值
		clazz.getField("fieldName").set(obj,getDataByType(clazz));
	}
	private static  <T> T  getDataByType(Class clazz) throws NoSuchFieldException {
		Object objType = clazz.getField("fieldName").getType();
			if (objType == String.class) {
				return (T) "";
			}
		// ...
		return (T) "";
	}

	private static String getInnerClassType(Class clazz, String fieldName) throws NoSuchFieldException {
		Field field = clazz.getField("fieldName");
		Type  type = field.getGenericType();
		if (type instanceof ParameterizedType) {
			ParameterizedType pt = (ParameterizedType) type;
			for (Type arg : pt.getActualTypeArguments()) {
				String[] args = arg.toString().split("\\.");
				return args[args.length-1];
			}
		}
		return "";
	}
}
