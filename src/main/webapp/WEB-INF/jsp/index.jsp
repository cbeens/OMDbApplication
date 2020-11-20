<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Movie Watchlist Maker</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style><%@include file="../../css/styles.css"%></style>
</head>
<body>
<h2>Add movies to the watchlist!</h2>

<form class="search-bar" method="get" action="/search">
    <input type="text" placeholder="Search Movie Titles.." name="search">
    <button type="submit"><i class="fa fa-search"></i></button>
</form>

<br>
<br>

<div>
    <table>
        <tr>
            <td><img src=${poster}></td>
            <td>
                <p><strong>Title: </strong> ${title}</p>
                <p><strong>Director: </strong> ${director}</p>
                <p><strong>Description: </strong> ${desc}</p>
                <p><strong>Genre: </strong> ${genre}</p>
                <p><strong>Rating: </strong> ${rating}</p>
                <form method="post" action="/add">
                    <input type="submit" value="Add to Watchlist">
                </form>
            </td>
        </tr>
    </table>

</div>

<br>


<br>
<h2>Current Watchlist</h2>
<form method="get" action="/load">
    <input type="submit" value="Load Watchlist">
</form>
<br>

<table class="data">
    <colgroup>
        <col style="width:15%">
        <col style="width:15%">
        <col style="width:40%">
        <col style="width:15%">
        <col style="width:5%">
        <col style="width:10%">
    </colgroup>
    <tr>
        <th>Title</th>
        <th>Director</th>
        <th>Description</th>
        <th>Genre</th>
        <th>Rating</th>
        <th>Options</th>
    </tr>

    <c:forEach var = "movie" items = "${movieslist}">
        <tr>
            <td>${movie.title}</td>
            <td>${movie.director}</td>
            <td>${movie.desc}</td>
            <td>${movie.genre}</td>
            <td>${movie.rating}</td>
            <td>
                <a href="/delete/${movie.getId()}">Delete</a>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>