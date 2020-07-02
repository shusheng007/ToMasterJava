package top.ss007.reflection;



import top.ss007.reflection.javaTypeSystem.TypeTest;
import top.ss007.reflection.methodhandler.MethodHandlerDemo;

import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectionService {
    //***************ParameterizedType*********
    public void checkParameterizedType() {
        try {
            //参数类型1:java.util.List<T>
            Field list = TypeTest.class.getField("list");
            Type genericType1 = list.getGenericType();
            System.out.println("参数类型1:" + genericType1.getTypeName());

            //参数类型2:java.util.Map<java.lang.String, T>
            Field map = TypeTest.class.getField("map");
            Type genericType2 = map.getGenericType();
            System.out.println("参数类型2:" + genericType2.getTypeName());


            if (genericType2 instanceof ParameterizedType) {
                ParameterizedType pType = (ParameterizedType) genericType2;
                Type[] types = pType.getActualTypeArguments();
                System.out.println("参数类型列表:" + Arrays.asList(types));//参数类型列表:[class java.lang.String, T]
                System.out.println("参数原始类型:" + pType.getRawType());//参数原始类型:interface java.util.Map
                System.out.println("参数父类类型:" + pType.getOwnerType());//参数父类类型:null,因为Map没有外部类，所以为null
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    //*********************GenericArrayType*********************
    public void checkGenericArrayType() {
        try {
            Field tArray = TypeTest.class.getField("tArray");
            System.out.println("数组参数类型1:" + tArray.getGenericType());//数组参数类型1:T[]
            Field ltArray = TypeTest.class.getField("ltArray");
            System.out.println("数组参数类型2:" + ltArray.getGenericType());//数组参数类型2:java.util.List<T>[]
            if (tArray.getGenericType() instanceof GenericArrayType) {
                GenericArrayType arrayType = (GenericArrayType) tArray.getGenericType();
                System.out.println("数组参数类型3:" + arrayType.getGenericComponentType());//数组参数类型3:T
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    //***************************TypeVariable************************
    public void checkTypeVariable() {
        try {
            Field v = TypeTest.class.getField("v");
            TypeVariable typeVariable = (TypeVariable) v.getGenericType();
            System.out.println("TypeVariable1:" + typeVariable);//TypeVariable:V
            System.out.println("TypeVariable2:" + Arrays.asList(typeVariable.getBounds()));//TypeVariable2:[class java.lang.Number, interface java.io.Serializable]
            System.out.println("TypeVariable3:" + typeVariable.getGenericDeclaration());//TypeVariable3:class reflection.javaTypeSystem.TypeTest
            AnnotatedType[] annotatedTypes = typeVariable.getAnnotatedBounds();
            //1.8 AnnotatedType: 如果这个这个泛型参数类型的上界用注解标记了，我们
            //可以通过它拿到相应的注解
            System.out.println("TypeVariable4:" + Arrays.asList(annotatedTypes) + " : " +
                    Arrays.asList(annotatedTypes[0].getAnnotations()));//TypeVariable4:[sun.reflect.annotation.AnnotatedTypeFactory$AnnotatedTypeBaseImpl@511d50c0, sun.reflect.annotation.AnnotatedTypeFactory$AnnotatedTypeBaseImpl@60e53b93] : [@reflection.javaTypeSystem.Custom()]

            System.out.println("TypeVariable5:" + typeVariable.getName());//TypeVariable5:V
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    //*********************************Class*********************************
    public void checkClass() {
        try {
            Field tClass = TypeTest.class.getField("testClass");
            System.out.println("Class1:" + tClass.getGenericType());//Class1:class reflection.javaTypeSystem.TypeTest
            Field tClass2 = TypeTest.class.getField("testClass2");
            System.out.println("Class2:" + tClass2.getGenericType());//Class2:reflection.javaTypeSystem.TypeTest<T, java.lang.Integer>
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    //**************************WildcardType*********************************
    public void checkWildcardType() {
        try {
            Field mapWithWildcard = TypeTest.class.getField("mapWithWildcard");
            Type wild = mapWithWildcard.getGenericType();
            if (wild instanceof ParameterizedType) {
                ParameterizedType pType = (ParameterizedType) wild;
                Type[] actualTypes = pType.getActualTypeArguments();
                System.out.println("WildcardType1:" + Arrays.asList(actualTypes));//WildcardType1:[? super java.lang.String, ? extends java.lang.Number]
                WildcardType first = (WildcardType) actualTypes[0];//? super java.lang.String
                WildcardType second = (WildcardType) actualTypes[1];//? extends java.lang.Number
                System.out.println("WildcardType2: lower:" + Arrays.asList(first.getLowerBounds()) + "  upper:" + Arrays.asList(first.getUpperBounds()));//WildcardType2: lower:[class java.lang.String]  upper:[class java.lang.Object]
                System.out.println("WildcardType3: lower:" + Arrays.asList(second.getLowerBounds()) + "  upper:" + Arrays.asList(second.getUpperBounds()));//WildcardType3: lower:[]  upper:[class java.lang.Number]
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }


    public void invokeNameGetterMethod(){
        new MethodHandlerDemo().handleNameGetter();
    }



}




