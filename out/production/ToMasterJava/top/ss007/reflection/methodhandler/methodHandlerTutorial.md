# 概述

 [MethodHandler]("https://docs.oracle.com/javase/9/docs/api/java/lang/invoke/MethodHandle.html") 与反射的作用类似
可以在运行时访问方法与属性，但是据说其执行效率比反射更高，也被称为 **现代化反射**


# 使用步骤
需要4步：
1. 创建LookUp
2. 创建MethodType
3. 基于LookUp与MethodType获得MethodHandler
4. 调用MethodHandler