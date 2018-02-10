# waterlab
自学Java一年多，自己动手做了一个项目，希望能给自学编程的朋友们有所帮助。

【项目介绍】
</br>本项目分为3个模块： 
</br>1、报表填写：使用ajax向后台提交表单数据
</br>2、报表及用户管理：数据的CRUD操作
</br>3、数据图表：使用ajax接收从后台返回的数据，前端用Chart.js呈现数据

【开发工具及环境】
</br>环境：win10
</br>开发工具：MyEclipse、Tomcat7、Mysql5.5
</br>浏览器：Google Chrome 57、Firefox Quantum 58.0.1
 </br> &emsp; [>_<]:
 </br> &emsp;&emsp;win10什么时候能用IE8？
 
【开发所用技术】
</br>前端：jsp、bootstrap3、boostrap table、jQuery、bootstrap validator、chart.js
</br>后端：Struts2、Hibernate3、Spring3、jdk1.6
</br>数据交互格式：json（前端采用Ajax，后端采用fastjson）
</br>采用MVC模式

【数据库设计】
</br>
</br>![image](https://github.com/jackzgzzh/waterlab/blob/master/project_images/database.jpg)

【关于登录及拦截器】
</br>输入<span>http://localhost:3306/lab</span>，进入登录界面
</br>分为普通用户和管理用户（通过userRole字段来区分）
</br>普通用户（username:jackzg1,password:123）
</br>管理用户（username:jackzg5,password:123）

</br>定义了2个拦截器LoginInterceptor和MethodInterceptor,拦截器的作用：
</br>1、只有登录用户才能进行访问
</br>2、区分普通用户和管理用户的访问权限
