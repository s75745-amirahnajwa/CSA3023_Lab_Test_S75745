<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<style>
    .footer {
        background-color: #2c3e50;
        color: white;
        text-align: center;
        padding: 10px;
        position: fixed;
        bottom: 0;
        width: 100%;
    }
</style>

<div class="footer">
    Current Server Time: <%= new java.util.Date() %>
</div>