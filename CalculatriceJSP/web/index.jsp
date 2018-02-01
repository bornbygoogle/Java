<%-- 
    Document   : Calcul
    Created on : 18 janv. 2018, 17:32:49
    Author     : faycal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ma Calculatrice</title>
    </head>
    <body>
        <%
            try{
            Double op1=Double.parseDouble(request.getParameter("Op1"));
            Double op2=Double.parseDouble(request.getParameter("Op2"));
            Double res=0.0;
            
            
        if(request.getParameter("type").equals("+"))
        {
            res=op1+op2;
            
        }
        else{
            if(request.getParameter("type").equals("-"))
            {res=op1-op2;}
            else{
                if(request.getParameter("type").equals("*"))
                {res=op1*op2;}
                else{
                    if(request.getParameter("type").equals("/"))
                    {res=op1/op2;}
                    
                }
            }
        }
        
        out.println(res);
        }
            catch (NumberFormatException e){out.println("uniquement des chiffres");}
        %>    
    </body>
</html>
