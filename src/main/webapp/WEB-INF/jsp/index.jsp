<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Movie Watchlist Maker</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../../styles/style.css">
</head>
<body>
<h1>Movie Watchlist Maker</h1>
<h2>Find movies to add to your watchlist!</h2>

<form method="get" action="/search">
    <input type="text" placeholder="Search Movie Titles.." name="search">
    <button type="submit"><i class="fa fa-search"></i></button>
</form>

<br>

<div>
    <table>
        <tr>
            <td><img src='<%=request.getParameter("poster")%>'></td>
            <td>
                <h3>Title: </h3><p></p>
                <h3>Director: </h3><p></p>
                <h3>Description: </h3><p></p>
                <h3>Genre: </h3><p></p>
                <h3>Rating: </h3><p></p>
            </td>
        </tr>
    </table>

</div>

<br>

<form method="post" action="/add">
    <input type="submit" value="Add to Watchlist">
</form>

<br>

<table>
    <tr>
        <th>Title</th>
        <th>Director</th>
        <th>Description</th>
        <th>Genre</th>
        <th>Rating</th>
        <th>Poster</th>
    </tr>

    <c:forEach var = "movie" items = "${movieslist}">
        <tr>
            <td>${movie.title}</td>
            <td>${movie.director}</td>
            <td>${movie.desc}</td>
            <td>${movie.genre}</td>
            <td>${movie.rating}</td>
            <td><img src="${movie.poster}" width="25%"></td>
        </tr>
    </c:forEach>

</table>


</body>
</html>