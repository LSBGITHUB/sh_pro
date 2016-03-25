<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>添加</h2>
    <s:form action="custaction" method="post">
       <s:textfield name="cust_name" label="客户姓名"/>
       <s:textarea name="cust_addr" label="客户地址"/>    
       <s:submit value="提交"/>          
    </s:form> 
    
    <h2>客户</h2>
    <s:if test="list.size()>0">
       <table border="1px" cellpadding="8px">
           
           <tr>
              <th>客户编号</th>
              <th>客户名称</th>
              <th>客户地址</th>
              <th>客户日期</th>
           </tr>
            <s:iterator value="list" status="suerStatus">
             <tr>
                <th><s:property value="cust_id"/></th>
                <th><s:property value="cust_name"/></th>
                <th><s:property value="cust_addr"/></th>
                <th><s:date name="create_date" format="dd/MM/yyyy"/> </th>
                  
             </tr>
                 
            </s:iterator>
       </table>
         
    </s:if>
</body>
</html>