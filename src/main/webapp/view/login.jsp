<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head></head>
<body>
    <h1>Xin chào, ${ name }</h1>
    <form action="login" method="POST">
        <div>
            <label>Email</label>
            <input type="email" name="email" />
        </div>
        <div>
            <label>Password</label>
            <input type="password" name="password" />
        </div>
        <button>Submit</button>
    </form>
</body>
</html>
