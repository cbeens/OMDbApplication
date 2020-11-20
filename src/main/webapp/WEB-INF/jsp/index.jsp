<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Movie Watchlist Maker</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../../css/styles.css">
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
            <td><img src=${poster}></td>
            <td>
                <p><strong>Title: </strong> ${title}</p>
                <p><strong>Director: </strong> ${director}</p>
                <p><strong>Description: </strong> ${desc}</p>
                <p><strong>Genre: </strong> ${genre}</p>
                <p><strong>Rating: </strong> ${rating}</p>
            </td>
        </tr>
    </table>

</div>

<br>

<form method="post" action="/add">
    <input type="submit" value="Add to Watchlist">
</form>
<form method="get" action="/load">
    <input type="submit" value="Load your Watchlist">
</form>

<br>
<h2>Your Watchlist</h2>
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