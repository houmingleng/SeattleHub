<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
                <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
                <html>

                <head>
                    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
                    <!-- Bootstrap -->
                    <link href="css/bootstrap.css" rel="stylesheet">
                    <title>SeattlerHub</title>
                </head>

                <body>

                        <div class="bg-dark collapse navbar-expand-lg " id="navbarHeader">
                            <div class="container">
                                <div class="d-flex flex-row justify-content-between">
                                    <div class="col-sm-8 col-md-7 py-4">
                                        <h4 class="text-white">About</h4>
                                        <p class="text-muted">Lorem ipsum dolor sit amet consectetur, adipisicing elit.
                                            Optio quo, cum
                                            ratione, porro, esse incidunt vitae molestiae inventore
                                            consectetur voluptatem a voluptas illo at! Animi, architecto!</p>
                                        <p>${test}</p>
                                        <p>${message.title}</p>
                                        
                                    </div>
                                    <div class="col-sm-4 offset-md-1 py-4">
                                        <h4 class="text-white">Contact</h4>
                                        <ul class="list-unstyled">
                                            <li><a href="#" class="text-white">Github Link</a></li>
                                            <li><a href="#" class="text-white">Email us</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="navbar navbar-dark bg-dark shadow-sm">
                            <div class="container">
                                <a href="#" class="navbar-brand d-flex align-items-center">
                                    <strong>SeattlerHub</strong>
                                </a>
                                <form class="d-flex">
                                    <input class="form-control me-2 " type="search" placeholder="search by name"
                                        aria-label="Search">
                                    <button class="btn btn-outline-secondary" type="submit">Search</button>
                                </form>
                                <ul class="navbar-nav d-flex flex-row justify-content-evenly" style="width: 20%;">
                                    <li class="nav-item">
                                        <a class="nav-link" href="./login"><strong>Login</strong></a>
                                        <p id ="username" style="display: none">${username} </p>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="./register"><strong>Register</strong></a>
                                    </li>
                                    <button class="navbar-toggler collapsed" type="button" data-bs-toggle="collapse"
                                        data-bs-target="#navbarHeader" aria-controls="navbarHeader"
                                        aria-expanded="false" aria-label="Toggle navigation">
                                        <span class="navbar-toggler-icon"></span>
                                    </button>
                                </ul>

                            </div>
                        </div>
                    </header>

                    <main>
                        <section class="text-center container">
                            <div class="row py-lg-5">
                                <div class="col-lg-8 col-md-8 mx-auto d-flex flex-column align-items-center">
                                    <h1 class="fw-light">SeattlerHub</h1>
                                    <p class="lead text-muted">Lorem ipsum dolor sit amet consectetur, adipisicing elit.
                                        Optio quo, cum
                                        ratione, porro, esse incidunt vitae molestiae inventore
                                        consectetur voluptatem a voluptas illo at! Animi, architecto!</p>
                                    <div class="d-flex flex-row">
                                        <div class="card-body">
                                            <h3 class="card-title">Price</h3>
                                            <div class="btn-group mx-3">
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            <form action="displayAllHousings" method="get">
                                            	<button class="btn btn-primary my-2">display all</button>
                                            </form>
                                            
                                            
                                            
                                            
                                            <form action="findHousingPriceLowToHigh" method="post">
                                            	<button class="btn btn-secondary my-2">low to high</button>
                                            </form>   
                                              
                                              
                                            
                           
                                            <form action="findHousingPriceHighToLow" method="post">
                                                <button class="btn btn-primary my-2">high to low</button>
                                            </form>
                                                 

											<form action="findHousingRatingHighToLow" method="post">
												<button class="btn btn-primary my-2">Rating high to low</button>
											</form>
											
											
											<form action="findHousingRatingLowToHigh" method="post">
												<button class="btn btn-secondary my-2">low to high</button>
											</form>












                                            </div>
                                        </div>
                                        <div class="card-body">
                                            <h3 class="card-title">Rating</h3>
                                            <div class="btn-group mx-3">
                                              <!--   <button action="findHousingRatingHighToLow" method="post"
                                                    class="btn btn-primary my-2">high to low</button>
                                                <button action="findHousingRatingLowToHigh" method="post"
                                                    class="btn btn-secondary my-2">low to high</button> -->
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>
						
     <div class="album py-5 bg-light">
            <div class="container">
                <div class="d-flex flex-row flex-wrap">
                 <c:forEach items="${housings}" var="housing">
                    <div class="w-30">
                        <div class="card shadow-sm d-flex">
                            <div class="card-body d-flex flex-column">
                                <h3 class="card-title"><c:out value="${housing.getRentalPrice()}" /></h3>
                                <div class="d-flex justify-content-between align-items-center">
                                    <h4 class="card-subtitle"><c:out value="${housing.getName()}" /></h4>
                                 
                                </div>
                                <p class="text-muted"><c:out value="${housing.getAddress()}" /></p>
                                 <c:forEach items="${reviews}" var="review">
                                <div class="card align-self-center mb-3" style="width: 100%;">
                                    <div class="card-body ">
                                        <p class="starability-result" data-rating="5">
                                        </p>
                                        <h6 class="card-subtitle mb-2 text-muted"><c:out value="${review.getUsername()}" /></h6>
                                        <p class="card-text"><c:out value="${review.getContent()}" /></p>
                                    </div>
                                </div>
                                </c:forEach>
                                <div class="card mb-3">
                                    <div class="card-body">
                                        <div class="align-center">
                                            <form action="" class="validated-form" method="POST" novalidate>
                                                <fieldset class="starability-basic">
                                                    <input type="radio" id="no-rate" class="input-no-rate"
                                                        name="review[rating]" value="1" checked
                                                        aria-label="No rating." />
                                                    <input type="radio" id="first-rate1" name="review[rating]"
                                                        value="1" />
                                                    <label for="first-rate1" title="Terrible"></label>
                                                    <input type="radio" id="first-rate2" name="review[rating]"
                                                        value="2" />
                                                    <label for="first-rate2" title="Not good"></label>
                                                    <input type="radio" id="first-rate3" name="review[rating]"
                                                        value="3" />
                                                    <label for="first-rate3" title="Average"></label>
                                                    <input type="radio" id="first-rate4" name="review[rating]"
                                                        value="4" />
                                                    <label for="first-rate4" title="Very good"></label>
                                                    <input type="radio" id="first-rate5" name="review[rating]"
                                                        value="5" />
                                                    <label for="first-rate5" title="Amazing"></label>
                                                </fieldset>
                                        </div>
                                        <div>
                                            <textarea class="form-control mb-3" id="body" cols="30" rows="3"
                                                placeholder="Leave your review here." required></textarea>
                                        </div>
                                        <button class="btn btn-success ">Submit</button>
                                        </form>
                                    </div>
                                </div>
                                
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class="">
                                        <a href="./edit" type="button" class="btn btn-primary">Edit</a>
                                        <button type="button" class="btn btn-danger">Delete</button>
                                    </div>
                                    <small class="text-muted">11/14/2021</small>
                                </div>
                            </div>
                        </div>

                    </div>
                </c:forEach>
                </div>
            </div>
        </div>
	                              

                    </main>

                    <footer class="text-muted py-3">
                        <div class="container">
                            <p class="float-end mb-1">
                                <button class="btn btn-secondary"><a href="#">Back to top</a></button>
                            </p>
                        </div>
                    </footer>

                    <!-- Bootstrap -->
                    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
                    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
                    <!-- Include all compiled plugins (below), or include individual files as needed -->
                    <script src="js/bootstrap.min.js"></script>
                </body>

                </html>