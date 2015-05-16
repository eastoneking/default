// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ReflectUtil.java

package com.neusoft.platform.syscontext.util;

import java.beans.Introspector;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.*;

public class ReflectUtil
{

	public static final Class NO_PARAMETERS[] = new Class[0];
	public static final Object NO_ARGUMENTS[] = new Object[0];
	public static final Type NO_TYPES[] = new Type[0];
	public static final String METHOD_GET_PREFIX = "get";
	public static final String METHOD_IS_PREFIX = "is";
	public static final String METHOD_SET_PREFIX = "set";
	private static Method _getMethod0;


	public static  Method getMethod0(Class c, String name, Class... parameterTypes){
	    try
	    {
	      return (Method)_getMethod0.invoke(c, new Object[] { name, parameterTypes });
	    }
	    catch (Exception ignore) {}
	    return null;
	}

	public static Method findMethod(Class c, String methodName)
	{
		return findDeclaredMethod(c, methodName, true);
	}

	public static Method findDeclaredMethod(Class c, String methodName)
	{
		return findDeclaredMethod(c, methodName, false);
	}

	private static Method findDeclaredMethod(Class c, String methodName, boolean publicOnly)
	{
		if (methodName == null || c == null)
			return null;
		Method ms[] = publicOnly ? c.getMethods() : c.getDeclaredMethods();
		Method amethod[];
		int j = (amethod = ms).length;
		for (int i = 0; i < j; i++)
		{
			Method m = amethod[i];
			if (m.getName().equals(methodName))
				return m;
		}

		return null;
	}

	public static  Class[] getClasses(Object... objects)
	{
		if (objects == null)
			return null;
		Class result[] = new Class[objects.length];
		for (int i = 0; i < objects.length; i++)
			if (objects[i] != null)
				result[i] = objects[i].getClass();

		return result;
	}

	public static Object invoke(Class c, Object obj, String method, Class paramClasses[], Object params[])
		throws IllegalAccessException, NoSuchMethodException, InvocationTargetException
	{
		Method m = c.getMethod(method, paramClasses);
		return m.invoke(obj, params);
	}

	public static Object invoke(Object obj, String method, Class paramClasses[], Object params[])
		throws IllegalAccessException, NoSuchMethodException, InvocationTargetException
	{
		Method m = obj.getClass().getMethod(method, paramClasses);
		return m.invoke(obj, params);
	}

	public static Object invoke(Object obj, String method, Object params[])
		throws IllegalAccessException, NoSuchMethodException, InvocationTargetException
	{
		Class paramClass[] = getClasses(params);
		return invoke(obj, method, paramClass, params);
	}

	public static Object invoke(Class c, Object obj, String method, Object params[])
		throws IllegalAccessException, NoSuchMethodException, InvocationTargetException
	{
		Class paramClass[] = getClasses(params);
		return invoke(c, obj, method, paramClass, params);
	}

	public static Object invokeDeclared(Class c, Object obj, String method, Class paramClasses[], Object params[])
		throws IllegalAccessException, NoSuchMethodException, InvocationTargetException
	{
		Method m = c.getDeclaredMethod(method, paramClasses);
		m.setAccessible(true);
		return m.invoke(obj, params);
	}

	public static Object invokeDeclared(Object obj, String method, Class paramClasses[], Object params[])
		throws IllegalAccessException, NoSuchMethodException, InvocationTargetException
	{
		Method m = obj.getClass().getDeclaredMethod(method, paramClasses);
		m.setAccessible(true);
		return m.invoke(obj, params);
	}

	public static Object invokeDeclared(Object obj, String method, Object params[])
		throws IllegalAccessException, NoSuchMethodException, InvocationTargetException
	{
		Class paramClass[] = getClasses(params);
		return invokeDeclared(obj, method, paramClass, params);
	}

	public static Object invokeDeclared(Class c, Object obj, String method, Object params[])
		throws IllegalAccessException, NoSuchMethodException, InvocationTargetException
	{
		Class paramClass[] = getClasses(params);
		return invokeDeclared(c, obj, method, paramClass, params);
	}

	public static boolean isSubclass(Class thisClass, Class target)
	{
		if (target.isInterface())
			return isInterfaceImpl(thisClass, target);
		for (Class x = thisClass; x != null; x = x.getSuperclass())
			if (x == target)
				return true;

		return false;
	}

	public static boolean isInterfaceImpl(Class thisClass, Class targetInterface)
	{
		for (Class x = thisClass; x != null; x = x.getSuperclass())
		{
			Class interfaces[] = x.getInterfaces();
			Class aclass[];
			int k = (aclass = interfaces).length;
			for (int j = 0; j < k; j++)
			{
				Class i = aclass[j];
				if (i == targetInterface)
					return true;
				if (isInterfaceImpl(i, targetInterface))
					return true;
			}

		}

		return false;
	}

	public static boolean isInstanceOf(Object o, Class target)
	{
		return isSubclass(o.getClass(), target);
	}

	public static Method[] getAccessibleMethods(Class clazz)
	{
		return getAccessibleMethods(clazz, Object.class);
	}

	public static Method[] getAccessibleMethods(Class clazz, Class limit)
	{
		Package topPackage = clazz.getPackage();
		List methodList = new ArrayList();
		int topPackageHash = topPackage != null ? topPackage.hashCode() : 0;
		boolean top = true;
		do
		{
			if (clazz == null)
				break;
			Method declaredMethods[] = clazz.getDeclaredMethods();
			Method amethod[];
			int k = (amethod = declaredMethods).length;
			for (int j = 0; j < k; j++)
			{
				Method method = amethod[j];
				if (!Modifier.isVolatile(method.getModifiers()))
					if (top)
					{
						methodList.add(method);
					} else
					{
						int modifier = method.getModifiers();
						if (!Modifier.isPrivate(modifier) && !Modifier.isAbstract(modifier))
							if (Modifier.isPublic(modifier))
								addMethodIfNotExist(methodList, method);
							else
							if (Modifier.isProtected(modifier))
							{
								addMethodIfNotExist(methodList, method);
							} else
							{
								Package pckg = method.getDeclaringClass().getPackage();
								int pckgHash = pckg != null ? pckg.hashCode() : 0;
								if (pckgHash == topPackageHash)
									addMethodIfNotExist(methodList, method);
							}
					}
			}

			top = false;
		} while ((clazz = clazz.getSuperclass()) != limit);
		Method methods[] = new Method[methodList.size()];
		for (int i = 0; i < methods.length; i++)
			methods[i] = (Method)methodList.get(i);

		return methods;
	}

	private static void addMethodIfNotExist(List allMethods, Method newMethod)
	{
		for (Iterator iterator = allMethods.iterator(); iterator.hasNext();)
		{
			Method m = (Method)iterator.next();
			if (compareSignatures(m, newMethod))
				return;
		}

		allMethods.add(newMethod);
	}

	public static Field[] getAccessibleFields(Class clazz)
	{
		return getAccessibleFields(clazz, Object.class);
	}

	public static Field[] getAccessibleFields(Class clazz, Class limit)
	{
		Package topPackage = clazz.getPackage();
		List fieldList = new ArrayList();
		int topPackageHash = topPackage != null ? topPackage.hashCode() : 0;
		boolean top = true;
		do
		{
			if (clazz == null)
				break;
			Field declaredFields[] = clazz.getDeclaredFields();
			Field afield[];
			int k = (afield = declaredFields).length;
			for (int j = 0; j < k; j++)
			{
				Field field = afield[j];
				if (top)
				{
					fieldList.add(field);
				} else
				{
					int modifier = field.getModifiers();
					if (!Modifier.isPrivate(modifier))
						if (Modifier.isPublic(modifier))
							addFieldIfNotExist(fieldList, field);
						else
						if (Modifier.isProtected(modifier))
						{
							addFieldIfNotExist(fieldList, field);
						} else
						{
							Package pckg = field.getDeclaringClass().getPackage();
							int pckgHash = pckg != null ? pckg.hashCode() : 0;
							if (pckgHash == topPackageHash)
								addFieldIfNotExist(fieldList, field);
						}
				}
			}

			top = false;
		} while ((clazz = clazz.getSuperclass()) != limit);
		Field fields[] = new Field[fieldList.size()];
		for (int i = 0; i < fields.length; i++)
			fields[i] = (Field)fieldList.get(i);

		return fields;
	}

	private static void addFieldIfNotExist(List allFields, Field newField)
	{
		for (Iterator iterator = allFields.iterator(); iterator.hasNext();)
		{
			Field f = (Field)iterator.next();
			if (compareSignatures(f, newField))
				return;
		}

		allFields.add(newField);
	}

	public static Method[] getSupportedMethods(Class clazz)
	{
		return getSupportedMethods(clazz, Object.class);
	}

	public static Method[] getSupportedMethods(Class clazz, Class limit)
	{
		ArrayList supportedMethods = new ArrayList();
		for (Class c = clazz; c != limit; c = c.getSuperclass())
		{
			Method methods[] = c.getDeclaredMethods();
			Method amethod[];
			int j = (amethod = methods).length;
			for (int i = 0; i < j; i++)
			{
				Method method = amethod[i];
				boolean found = false;
				for (Iterator iterator = supportedMethods.iterator(); iterator.hasNext();)
				{
					Method supportedMethod = (Method)iterator.next();
					if (compareSignatures(method, supportedMethod))
					{
						found = true;
						break;
					}
				}

				if (!found)
					supportedMethods.add(method);
			}

		}

		return (Method[])supportedMethods.toArray(new Method[supportedMethods.size()]);
	}

	public static Field[] getSupportedFields(Class clazz)
	{
		return getSupportedFields(clazz, Object.class);
	}

	public static Field[] getSupportedFields(Class clazz, Class limit)
	{
		ArrayList supportedFields = new ArrayList();
		for (Class c = clazz; c != limit; c = c.getSuperclass())
		{
			Field fields[] = c.getDeclaredFields();
			Field afield[];
			int j = (afield = fields).length;
			for (int i = 0; i < j; i++)
			{
				Field field = afield[i];
				boolean found = false;
				for (Iterator iterator = supportedFields.iterator(); iterator.hasNext();)
				{
					Field supportedField = (Field)iterator.next();
					if (compareSignatures(field, supportedField))
					{
						found = true;
						break;
					}
				}

				if (!found)
					supportedFields.add(field);
			}

		}

		return (Field[])supportedFields.toArray(new Field[supportedFields.size()]);
	}

	public static boolean compareDeclarations(Method first, Method second)
	{
		if (first.getReturnType() != second.getReturnType())
			return false;
		else
			return compareSignatures(first, second);
	}

	public static boolean compareSignatures(Method first, Method second)
	{
		if (!first.getName().equals(second.getName()))
			return false;
		else
			return compareParameters(first.getParameterTypes(), second.getParameterTypes());
	}

	public static boolean compareSignatures(Constructor first, Constructor second)
	{
		if (!first.getName().equals(second.getName()))
			return false;
		else
			return compareParameters(first.getParameterTypes(), second.getParameterTypes());
	}

	public static boolean compareSignatures(Field first, Field second)
	{
		return first.getName().equals(second.getName());
	}

	public static boolean compareParameters(Class first[], Class second[])
	{
		if (first.length != second.length)
			return false;
		for (int i = 0; i < first.length; i++)
			if (first[i] != second[i])
				return false;

		return true;
	}

	public static void forceAccess(AccessibleObject accObject)
	{
		if (accObject.isAccessible())
			return;
		try
		{
			accObject.setAccessible(true);
		}
		catch (SecurityException securityexception) { }
	}

	public static boolean isPublic(Member member)
	{
		return Modifier.isPublic(member.getModifiers());
	}

	public static boolean isPublicPublic(Member member)
	{
		return Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers());
	}

	public static boolean isPublic(Class c)
	{
		return Modifier.isPublic(c.getModifiers());
	}

	public static Object newInstance(Class type)
		throws IllegalAccessException, InstantiationException
	{
		if (type.isPrimitive())
		{
			if (type == Integer.TYPE)
				return Integer.valueOf(0);
			if (type == Long.TYPE)
				return Long.valueOf(0L);
			if (type == Boolean.TYPE)
				return Boolean.FALSE;
			if (type == Float.TYPE)
				return Float.valueOf(0.0F);
			if (type == Double.TYPE)
				return Double.valueOf(0.0D);
			if (type == Byte.TYPE)
				return Byte.valueOf((byte)0);
			if (type == Short.TYPE)
				return Short.valueOf((short)0);
			if (type == Character.TYPE)
				return Character.valueOf('\0');
			else
				throw new IllegalArgumentException((new StringBuilder("Invalid primitive type: ")).append(type).toString());
		}
		if (type == Integer.class)
			return Integer.valueOf(0);
		if (type == String.class)
			return "";
		if (type == Long.class)
			return Long.valueOf(0L);
		if (type == Boolean.class)
			return Boolean.FALSE;
		if (type == Float.class)
			Float.valueOf(0.0F);
		if (type == Double.class)
			Double.valueOf(0.0D);
		if (type == Map.class)
			return new HashMap();
		if (type == List.class)
			return new ArrayList();
		if (type == Set.class)
			return new LinkedHashSet();
		if (type == Collection.class)
			return new ArrayList();
		if (type == Byte.class)
			return Byte.valueOf((byte)0);
		if (type == Short.class)
			return Short.valueOf((short)0);
		if (type == Character.class)
			return Character.valueOf('\0');
		if (type.isEnum())
			return type.getEnumConstants()[0];
		if (type.isArray())
			return Array.newInstance(type.getComponentType(), 0);
		else
			return type.newInstance();
	}

	public static boolean isAssignableFrom(Member member1, Member member2)
	{
		return member1.getDeclaringClass().isAssignableFrom(member2.getDeclaringClass());
	}

	public static Class[] getSuperclasses(Class type)
	{
		int i = 0;
		for (Class x = type.getSuperclass(); x != null; x = x.getSuperclass())
			i++;

		Class result[] = new Class[i];
		i = 0;
		for (Class x = type.getSuperclass(); x != null; x = x.getSuperclass())
		{
			result[i] = x;
			i++;
		}

		return result;
	}

	public static boolean isUserDefinedMethod(Method method)
	{
		return method.getDeclaringClass() != Object.class;
	}

	public static boolean isObjectMethod(Method method)
	{
		return method.getDeclaringClass() ==  Object.class;
	}

	public static boolean isBeanProperty(Method method)
	{
		if (isObjectMethod(method))
			return false;
		String methodName = method.getName();
		Class returnType = method.getReturnType();
		Class paramTypes[] = method.getParameterTypes();
		if (methodName.startsWith("get"))
		{
			if (returnType != null && paramTypes.length == 0)
				return true;
		} else
		if (methodName.startsWith("is"))
		{
			if (returnType != null && paramTypes.length == 0)
				return true;
		} else
		if (methodName.startsWith("set") && paramTypes.length == 1)
			return true;
		return false;
	}

	public static boolean isBeanPropertyGetter(Method method)
	{
		return getBeanPropertyGetterPrefixLength(method) != 0;
	}

	private static int getBeanPropertyGetterPrefixLength(Method method)
	{
		if (isObjectMethod(method))
			return 0;
		String methodName = method.getName();
		Class returnType = method.getReturnType();
		Class paramTypes[] = method.getParameterTypes();
		if (methodName.startsWith("get"))
		{
			if (returnType != null && paramTypes.length == 0)
				return 3;
		} else
		if (methodName.startsWith("is") && returnType != null && paramTypes.length == 0)
			return 2;
		return 0;
	}

	public static String getBeanPropertyGetterName(Method method)
	{
		int prefixLength = getBeanPropertyGetterPrefixLength(method);
		if (prefixLength == 0)
		{
			return null;
		} else
		{
			String methodName = method.getName().substring(prefixLength);
			return Introspector.decapitalize(methodName);
		}
	}

	public static boolean isBeanPropertySetter(Method method)
	{
		return getBeanPropertySetterPrefixLength(method) != 0;
	}

	private static int getBeanPropertySetterPrefixLength(Method method)
	{
		if (isObjectMethod(method))
			return 0;
		String methodName = method.getName();
		Class paramTypes[] = method.getParameterTypes();
		return !methodName.startsWith("set") || paramTypes.length != 1 ? 0 : 3;
	}

	public static String getBeanPropertySetterName(Method method)
	{
		int prefixLength = getBeanPropertySetterPrefixLength(method);
		if (prefixLength == 0)
		{
			return null;
		} else
		{
			String methodName = method.getName().substring(prefixLength);
			return Introspector.decapitalize(methodName);
		}
	}

	public static Class getComponentType(Type type)
	{
		return getComponentType(type, -1);
	}

	public static Class getComponentType(Type type, int index)
	{
		if (type instanceof Class)
		{
			Class clazz = (Class)type;
			if (clazz.isArray())
				return clazz.getComponentType();
		} else
		if (type instanceof ParameterizedType)
		{
			ParameterizedType pt = (ParameterizedType)type;
			Type generics[] = pt.getActualTypeArguments();
			if (index < 0)
				index = generics.length + index;
			if (index < generics.length)
				return toClass(generics[index]);
		} else
		if (type instanceof GenericArrayType)
		{
			GenericArrayType gat = (GenericArrayType)type;
			return toClass(gat.getGenericComponentType());
		}
		return null;
	}

	public static Class getGenericSupertype(Class type, int index)
	{
		return getComponentType(type.getGenericSuperclass(), index);
	}

	public static Class getGenericSupertype(Class type)
	{
		return getComponentType(type.getGenericSuperclass());
	}

	public static Class toClass(Type type)
	{
		if (type instanceof Class)
			return (Class)type;
		if (type instanceof ParameterizedType)
		{
			ParameterizedType pt = (ParameterizedType)type;
			return toClass(pt.getRawType());
		}
		if (type instanceof WildcardType)
		{
			WildcardType wt = (WildcardType)type;
			Type lower[] = wt.getLowerBounds();
			if (lower.length == 1)
				return toClass(lower[0]);
			Type upper[] = wt.getUpperBounds();
			if (upper.length == 1)
				return toClass(upper[0]);
		} else
		{
			if (type instanceof GenericArrayType)
			{
				GenericArrayType gat = (GenericArrayType)type;
				Class componentType = toClass(gat.getGenericComponentType());
				return Array.newInstance(componentType, 0).getClass();
			}
			if (type instanceof TypeVariable)
			{
				TypeVariable tv = (TypeVariable)type;
				Type bounds[] = tv.getBounds();
				if (bounds.length == 1)
					return toClass(bounds[0]);
			}
		}
		return null;
	}

	public static Object readAnnotationValue(Annotation annotation, String name)
	{
	    try
	    {
	      Method method = annotation.annotationType().getDeclaredMethod(name, new Class[0]);
	      return method.invoke(annotation, new Object[0]);
	    }
	    catch (Exception ignore) {}
	    return null;
	}
	  static
	  {
	    try
	    {
	      _getMethod0 = Class.class.getDeclaredMethod("getMethod0", new Class[] { String.class, Class.class });
	      _getMethod0.setAccessible(true);
	    }
	    catch (Exception ignore)
	    {
	      try
	      {
	        _getMethod0 = Class.class.getMethod("getMethod", new Class[] { String.class, Class.class });
	      }
	      catch (Exception ignored)
	      {
	        _getMethod0 = null;
	      }
	    }
	  }

}
