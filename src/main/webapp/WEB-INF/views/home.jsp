<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="CL project">
    <meta name="author" content="LukaszKad">

    <title>Uproszczony kalkulator wycen projektów stoisk targowych</title>

    <!-- Bootstrap core CSS -->
    <link href="/resources/vendors/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/resources/css/full-width-pics.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-secondary fixed-top">
    <div class="container">
        <a class="navbar-brand" href="#">Uproszczony Kalkulator Wycen Projektów Stoisk Targowych</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/home">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/user/panel">Konto</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="https://dan-expo.pl/">Kontakt</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Header - set the background image for the header in the line below -->
<header class="py-5 bg-image-full" style="background-image: url('/resources/img/ARLEKINO_1.jpg');">
</header>

<!-- Content section -->
<section class="py-5">
    <div class="container">
        <h1>Kalkulator stoisk</h1>
        <p class="lead">Pozwala na wycenę twojego projektu zabudowy stoiska</p>
        <a href="/user/advanced" class="btn btn-dark">Przejdź do wyceny</a>
    </div>
</section>

<section class="py-5 bg-image-full" style="background-image: url('/resources/img/III_FormPlastic_Ambiente2015_w2009.jpg');">
    <div style="height: 200px;"></div>
</section>

<!-- Footer -->
<footer class="py-5 bg-secondary">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; LukaszKad 2019</p>
    </div>
</footer>

<!-- Bootstrap core JavaScript -->
<script src="/resources/vendors/jquery/jquery.min.js"></script>
<script src="/resources/vendors/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>