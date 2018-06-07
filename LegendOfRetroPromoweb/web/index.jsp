<%-- 
    Document   : index
    Created on : May 25, 2018, 4:22:00 PM
    Author     : bornbygoogle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Website for Projet Etude - Legend of Retro</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="Projet Etude - DUT Modulaire">
        <meta name="author" content="code modified by bornbygoogle">
        
  <!-- css -->
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700|Open+Sans:400,300,700,800" rel="stylesheet" media="screen">

  <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
  <link href="css/style.css" rel="stylesheet" media="screen">
  <link href="color/default.css" rel="stylesheet" media="screen">
    </head>
    
    
    <body>

  <!-- Navigation -->
  <nav class="navbar navbar-default" role="navigation">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
          <span class="sr-only">Toggle nav</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>

        <!-- Logo text or image -->
        <a class="navbar-brand" href="index.html">Legend Of Retro</a>

      </div>
      <div class="navigation collapse navbar-collapse navbar-ex1-collapse">
        <ul class="nav navbar-nav">
          <li class="current"><a href="#intro">Home</a></li>
          <li><a href="#about">About</a></li>
          <li><a href="#services">Fonctionnalité</a></li>
          <li><a href="#portfolio">Promotion</a></li>
          <li><a href="#team">Team</a></li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- intro area -->
  <div id="intro">
    <div class="intro-text">
      <div class="container">
        <div class="col-md-12">
          <div id="rotator">
            <h1><span class="1strotate">Gestion des produits, Gestion Clients/Fournisseur, Gestion Achat / Vente, Promotion</span></h1>
            <div class="line-spacer"></div>
            <p><span class="2ndrotate">Recherche / Création des produits, Recherche / Création des Personnes ( Clients ou Fournisseurs ), Gestion + Création des factures , Promotion</span></p>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- About -->
  <section id="about" class="home-section bg-white">
    <div class="container">
      <div class="row">
        <div class="col-md-offset-2 col-md-8">
          <div class="section-heading">
            <h2>About us</h2>
            <div class="heading-line"></div>
            <p>Nous sommes 4 étudiants en 3e année du cours du soir DUT Informatique de IUT A - D&partement Informatique</p>
          </div>
        </div>
      </div>
      <div class="row wow fadeInUp">
        <div class="col-md-6 about-img">
          <img src="img/about-img.jpg" alt="">
        </div>

        <div class="col-md-6 content">
          <h2>Cette page web est issue de notre projet fin d'études.</h2>
          <h3>Dans le but d'application des connaissances théoriques en pratique.</h3>
          <p>
            Notre projet est pour le but de création une application SWING pour gérer un magasin des jeux de rétro, en appliquant maximum des connaissances théoriques par notre choix. 
          </p>
        </div>
      </div>
    </div>
  </section>

  <!-- Parallax 1 -->
  <section id="parallax1" class="home-section parallax" data-stellar-background-ratio="0.5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="color-light">
            <h2 class="wow bounceInDown" data-wow-delay="0.5s">Le seul contraint de ce projet : Développement en JAVA.</h2>
            <p class="lead wow bounceInUp" data-wow-delay="1s">Nous avons pris le choix d'intégrer en plus une partie de JAVA WEB d'ou ce site.</p>
          </div>
        </div>
      </div>
    </div>
  </section>

  <!-- Services -->
  <section id="services" class="home-section bg-white">
    <div class="container">
      <div class="row">
        <div class="col-md-offset-2 col-md-8">
          <div class="section-heading">
            <h2>Fonctionalités d'application SWING</h2>
            <div class="heading-line"></div>
            <p>Notre projet compose de 3 fonctionnalités principaux : </p>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12">
          <div id="carousel-service" class="service carousel slide">

            <!-- slides -->
            <div class="carousel-inner">
              <div class="item active">
                <div class="row">
                  <div class="col-sm-12 col-md-offset-1 col-md-6">
                    <div class="wow bounceInLeft">
                      <h4>Gestion des produits</h4>
                      <p>L'application est capable de recherche un/des Produits ( Consoles ou Jeux ); Elle est capable aussi de créer un/des nouveaux Produits.</p>
                    </div>
                  </div>
                  <div class="col-sm-12 col-md-5">
                    <div class="screenshot wow bounceInRight">
                      <img src="img/screenshots/1.png" class="img-responsive" alt="" />
                    </div>
                  </div>
                </div>
              </div>
              <div class="item">
                <div class="row">
                  <div class="col-sm-12 col-md-offset-1 col-md-6">
                    <div class="wow bounceInLeft">
                      <h4>Gestion des Clients/Fournisseurs</h4>
                      <p>L'application est capable de recherche un/des Personnes ( Clients ou Fournisseurs ); Elle est capable aussi de créer un/des nouveaux Personnes.</p>
                    </div>
                  </div>
                  <div class="col-sm-12 col-md-5">
                    <div class="screenshot wow bounceInRight">
                      <img src="img/screenshots/2.png" class="img-responsive" alt="" />
                    </div>
                  </div>
                </div>
              </div>
              <div class="item">
                <div class="row">
                  <div class="col-sm-12 col-md-offset-1 col-md-6">
                    <div class="wow bounceInLeft">
                      <h4>Gestion Achat/Vente</h4>
                      <p>L'application est capable de recherche la disponibilité d'un/des Personnes ( Clients ou Fournisseurs ) et créer à la volée; Elle est capable aussi de créer un/des nouveaux Factures d'achat ou vente.</p>
                    </div>
                  </div>
                  <div class="col-sm-12 col-md-5">
                    <div class="screenshot wow bounceInRight">
                      <img src="img/screenshots/3.png" class="img-responsive" alt="" />
                    </div>
                  </div>
                </div>
              </div>
              <div class="item">
                <div class="row">
                  <div class="col-sm-12 col-md-offset-1 col-md-6">
                    <div class="wow bounceInLeft">
                      <h4>Gestion des Promotions</h4>
                      <p>L'application est capable de calculer la côte d'un produit; permettre aux utilisateurs de modifier la côte en cas besoin. </p>
                    </div>
                  </div>
                  <div class="col-sm-12 col-md-5">
                    <div class="screenshot wow bounceInRight">
                      <img src="img/screenshots/2.png" class="img-responsive" alt="" />
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <!-- Indicators -->
            <ol class="carousel-indicators">
              <li data-target="#carousel-service" data-slide-to="0" class="active"></li>
              <li data-target="#carousel-service" data-slide-to="1"></li>
              <li data-target="#carousel-service" data-slide-to="2"></li>
              <li data-target="#carousel-service" data-slide-to="3"></li>
            </ol>
          </div>
        </div>
      </div>
    </div>
  </section>

  <!-- Works -->
  <section id="portfolio" class="home-section bg-gray">
    <div class="container">
      <div class="row">
        <div class="col-md-offset-2 col-md-8">
          <div class="section-heading">
            <h2>Promotion</h2>
            <div class="heading-line"></div>
            <p>Des promotions en cours</p>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-12">

          <ul id="og-grid" class="og-grid">
            <li>
              <a href="#" 
                 data-largesrc="img/works/1.jpg" 
                 data-title="Portfolio title" 
                 data-description="Duo te dico volutpat, unum elit oblique per id. Ne duo mollis sapientem intellegebat. Per at augue vidisse percipit, pri vocibus assueverit interesset ut, no dolore luptatum incorrupte nec. In mentitum forensibus nec, nibh eripuit ut pri, tale illud voluptatum ut sea. Sed oratio repudiare ei, cum an magna labitur, eu atqui augue mei. Pri consul detracto eu, solet nusquam accusam ex vim, an movet interesset necessitatibus mea.">
		<img src="img/works/thumbs/1.jpg" alt=""/>
		</a>
            </li>
            <li>
              <a href="#" 
                 data-largesrc="img/works/2.jpg" 
                 data-title="Portfolio title" 
                 data-description="Mea an eros periculis dignissim, quo mollis nostrum elaboraret et. Id quem perfecto mel, no etiam perfecto qui. No nisl legere recusabo nam, ius an tale pericula evertitur, dicat phaedrum qui in. Usu numquam legendos in, voluptaria sadipscing ut vel. Eu eum mandamus volutpat gubergren, eos ad detracto nominati, ne eum idque elitr aliquam.">
		<img src="img/works/thumbs/2.jpg" alt=""/>
		</a>
            </li>
            <li>
              <a href="#" data-largesrc="img/works/3.jpg" data-title="Portfolio title" data-description="Vim ad persecuti appellantur. Eam ignota deterruisset eu, in omnis fierent convenire sed. Ne nulla veritus vel, liber euripidis in eos. Postea comprehensam vis in, detracto deseruisse mei ea. Ex sadipscing deterruisset concludaturque quo.">
								<img src="img/works/thumbs/3.jpg" alt="img01"/>
							</a>
            </li>
            <li>
              <a href="#" data-largesrc="img/works/4.jpg" data-title="Portfolio title" data-description="In mentitum forensibus nec, nibh eripuit ut pri, tale illud voluptatum ut sea. Sed oratio repudiare ei, cum an magna labitur, eu atqui augue mei. Pri consul detracto eu, solet nusquam accusam ex vim, an movet interesset necessitatibus mea.">
								<img src="img/works/thumbs/4.jpg" alt="img01"/>
							</a>
            </li>
            <li>
              <a href="#" data-largesrc="img/works/5.jpg" data-title="Portfolio title" data-description="Duo te dico volutpat, unum elit oblique per id. Ne duo mollis sapientem intellegebat. Per at augue vidisse percipit, pri vocibus assueverit interesset ut, no dolore luptatum incorrupte nec. In mentitum forensibus nec, nibh eripuit ut pri, tale illud voluptatum ut sea">
								<img src="img/works/thumbs/5.jpg" alt="img01"/>
							</a>
            </li>
            <li>
              <a href="#" data-largesrc="img/works/6.jpg" data-title="Portfolio title" data-description="Id elit saepe pro. In atomorum constituam definitionem quo, at torquatos sadipscing eum, ut eum wisi meis mentitum. Probo feugiat ea duo. An usu platonem instructior, qui dolores inciderint ad. Te elit essent mea, vim ne atqui legimus invenire, ad dolor vitae sea.">
								<img src="img/works/thumbs/6.jpg" alt="img01"/>
							</a>
            </li>
            <li>
              <a href="#" data-largesrc="img/works/7.jpg" data-title="Portfolio title" data-description="Duo te dico volutpat, unum elit oblique per id. Ne duo mollis sapientem intellegebat. Per at augue vidisse percipit, pri vocibus assueverit interesset ut, no dolore luptatum incorrupte nec. In mentitum forensibus nec, nibh eripuit ut pri, tale illud voluptatum ut sea. Sed oratio repudiare ei, cum an magna labitur, eu atqui augue mei.">
								<img src="img/works/thumbs/7.jpg" alt="img01"/>
							</a>
            </li>
            <li>
              <a href="#" data-largesrc="img/works/8.jpg" data-title="Portfolio title" data-description="No nisl legere recusabo nam, ius an tale pericula evertitur, dicat phaedrum qui in. Usu numquam legendos in, voluptaria sadipscing ut vel. Eu eum mandamus volutpat gubergren, eos ad detracto nominati, ne eum idque elitr aliquam.">
								<img src="img/works/thumbs/8.jpg" alt="img01"/>
							</a>
            </li>
            <li>
              <a href="#" data-largesrc="img/works/9.jpg" data-title="Portfolio title" data-description="Lorem ipsum dolor sit amet, ex pri quod ferri fastidii. Mazim philosophia eum ad, facilisis laboramus te est. Eam magna fabellas ut. Ne vis diceret accumsan salutandi, pro in impedit accusamus dissentias, ut nonumy eloquentiam ius.">
								<img src="img/works/thumbs/9.jpg" alt="img01"/>
							</a>
            </li>
            <li>
              <a href="#" data-largesrc="img/works/10.jpg" data-title="Portfolio title" data-description="Duo te dico volutpat, unum elit oblique per id. Ne duo mollis sapientem intellegebat. Per at augue vidisse percipit, pri vocibus assueverit interesset ut, no dolore luptatum incorrupte nec. In mentitum forensibus nec, nibh eripuit ut pri, tale illud voluptatum ut sea. Sed oratio repudiare ei, cum an magna labitur, eu atqui augue mei. Pri consul detracto eu, solet nusquam accusam ex vim.">
								<img src="img/works/thumbs/10.jpg" alt="img01"/>
							</a>
            </li>
            <li>
              <a href="#" data-largesrc="img/works/11.jpg" data-title="Portfolio title" data-description="Vim ad persecuti appellantur. Eam ignota deterruisset eu, in omnis fierent convenire sed. Ne nulla veritus vel, liber euripidis in eos. Postea comprehensam vis in, detracto deseruisse mei ea. Ex sadipscing deterruisset concludaturque quo.">
								<img src="img/works/thumbs/11.jpg" alt="img01"/>
							</a>
            </li>
            <li>
              <a href="#" data-largesrc="img/works/12.jpg" data-title="Portfolio title" data-description="Mea an eros periculis dignissim, quo mollis nostrum elaboraret et. Id quem perfecto mel, no etiam perfecto qui. No nisl legere recusabo nam, ius an tale pericula evertitur, dicat phaedrum qui in. Usu numquam legendos in, voluptaria sadipscing ut vel. Eu eum mandamus volutpat gubergren, eos ad detracto nominati, ne eum idque elitr aliquam.">
								<img src="img/works/thumbs/12.jpg" alt="img01"/>
							</a>
            </li>
          </ul>

        </div>
      </div>
    </div>
  </section>

  <!-- Team -->
  <section id="team" class="home-section bg-white">
    <div class="container">
      <div class="row">
        <div class="col-md-offset-2 col-md-8">
          <div class="section-heading">
            <h2>Our Team</h2>
            <div class="heading-line"></div>
            <p>Les 4 étudiants 3e année du cours du soir - DUT Informatique - IUT A Site Villeurbanne.</p>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-xs-12 col-sm-3 col-md-3 col-lg-3">
          <div class="box-team wow bounceInUp" data-wow-delay="0.1s">
            <img src="img/team/1.jpg" alt="" class="img-circle img-responsive" />
            <h4>Adrien MARCHAND</h4>
            <p></p>
          </div>
        </div>
        <div class="col-xs-12 col-sm-3 col-md-3 col-lg-3" data-wow-delay="0.3s">
          <div class="box-team wow bounceInUp">
            <img src="img/team/2.jpg" alt="" class="img-circle img-responsive" />
            <h4>Julian BULAN</h4>
            <p></p>
          </div>
        </div>
        <div class="col-xs-12 col-sm-3 col-md-3 col-lg-3" data-wow-delay="0.5s">
          <div class="box-team wow bounceInUp">
            <img src="img/team/3.jpg" alt="" class="img-circle img-responsive" />
            <h4>Stephane TEACHER</h4>
            <p></p>
          </div>
        </div>
        <div class="col-xs-12 col-sm-3 col-md-3 col-lg-3" data-wow-delay="0.7s">
          <div class="box-team wow bounceInUp">
            <img src="img/team/4.jpg" alt="" class="img-circle img-responsive" />
            <h4>Minh An TRAN</h4>
            <p></p>
          </div>
        </div>
      </div>
    </div>
  </section>

  <!-- Footer -->
  <footer>
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <p>Copyright &copy; Alstar. All rights reserved.</p>
          <p>Modified par bornbygoogle for Etude Project.</p>
          <div class="credits">
            <!--
              All the links in the footer should remain intact.
              You can delete the links only if you purchased the pro version.
              Licensing information: https://bootstrapmade.com/license/
              Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=Alstar
            -->
            Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
          </div>
        </div>
      </div>
    </div>
  </footer>

  <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>

  <!-- js -->
  <script src="js/jquery.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/wow.min.js"></script>
  <script src="js/mb.bgndGallery.js"></script>
  <script src="js/mb.bgndGallery.effects.js"></script>
  <script src="js/jquery.simple-text-rotator.min.js"></script>
  <script src="js/jquery.scrollTo.min.js"></script>
  <script src="js/jquery.nav.js"></script>
  <script src="js/modernizr.custom.js"></script>
  <script src="js/grid.js"></script>
  <script src="js/stellar.js"></script>

  <!-- Template Custom Javascript File -->
  <script src="js/custom.js"></script>
    </body>
</html>
