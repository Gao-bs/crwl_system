package com.system.util;



import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.util.Lists;

import com.system.entity.pojo.User;

/**
*  作者：yangchong
*  功能：反射工具类
*/
public class ReflectionUtils {

   /**
    * 获取类以及父类的属性类型
    * @param clazz
    * @return
    */
   public static ArrayList<Class> getAllFieldClazzs(Class<?> clazz){
       ArrayList<Class> classs = Lists.newArrayList();
       List<Class> tempClasss = null;
       while (!clazz.equals(Object.class)){
           tempClasss = Arrays.asList(clazz.getDeclaredFields()).stream().map(field -> field.getType()).collect(Collectors.toList());
           classs.addAll(tempClasss);
           clazz = clazz.getSuperclass();
       }
       return classs;
   }

   /**
    * 获取类里面指定的属性类型，检测到list类型属性会自动获取其泛型
    * @param clazz
    * @param name
    * @return
    */
   public static Class getAllFieldClass(Class<?> clazz,String name){
       Field field = null;
       while (!clazz.equals(Object.class)){
           try {
               field = clazz.getDeclaredField(name);
               break;
           } catch (NoSuchFieldException e) {
               clazz = clazz.getSuperclass();
           }
       }
       return field.getType().equals(List.class)?getListGenericClass(field):field.getType();
   }

   /**
    * 获取类里面指定的属性类型，检测到list类型属性会自动获取其泛型，并且可获取list泛型里面的指定属性
    * @param clazz
    * @param name
    * @return
    */
   public static Class getFieldClass(Class<?> clazz,String name){
       List<String> nameList = Arrays.asList(name.split("\\."));
       for (String tempName:nameList) {
           clazz = getAllFieldClass(clazz,tempName);
       }
       return clazz;
   }

   /**
    * 获取list的泛型类所有属性
    * @param field
    * @return
    */
   public static Class getListGenericClass(Field field){
       ParameterizedType listGenericType  = (ParameterizedType)field.getGenericType();
       Type[] listActualTypeArguments = listGenericType.getActualTypeArguments();
       return  (Class)listActualTypeArguments[0];
   }

   /**
    * 获取list的泛型类指定属性
    * @param clazz
    * @param name
    * @return
    */
   public static Class getListGenericClass(Class<?> clazz,String name){
       Field listField = null;
       try {
           listField = clazz.getDeclaredField(name);
       } catch (Exception e) {
           e.printStackTrace();
       }
       ParameterizedType listGenericType  = (ParameterizedType)listField.getGenericType();
       Type[] listActualTypeArguments = listGenericType.getActualTypeArguments();
       return  (Class)listActualTypeArguments[0];
   }

   public static List<String> getFieldList(Class<?> clazz){
	    if(null == clazz){
	        return null;
	    }
	    List<String> fieldList = new LinkedList<String>();
	    Field[] fields = clazz.getDeclaredFields();
	    for(Field field : fields){
	        /** 过滤静态属性**/
	        if(Modifier.isStatic(field.getModifiers())){
	            continue;
	        }
	        /** 过滤transient 关键字修饰的属性**/
	        if(Modifier.isTransient(field.getModifiers())){
	            continue;
	        }
	        fieldList.add(field.getName());
	    }

	    return fieldList;
	}

   public static void main(String[] args) {
    
       System.out.println(ReflectionUtils.getFieldList(User.class));

   }
}