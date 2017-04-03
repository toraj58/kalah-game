<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <link rel="stylesheet" href="Semantic-UI/semantic.min.css">
    <link rel="stylesheet" href="Semantic-UI/components/accordion.min.css">
    <script src="Semantic-UI/jquery3.2.0.js"></script>
    <script src="Semantic-UI/semantic.min.js"></script>
    <script src="Semantic-UI/components/accordion.min.js"></script>

    <script language='javascript'>
        $(document).ready(function () {
            $('.ui.accordion').accordion();
        });
    </script>

</head>
<body>
<%--Grid Begin--%>

<div class="ui equal width left aligned padded grid" style="margin: 0 auto">
    <div class="row">
        <div class="black column">
            <h1 class="ui center aligned header orange"> Welcome to Kalah Game </h1>
        </div>
    </div>
    <div class="row" style="background-color: #869D05">
        <div class="column">
            <div class="ui card">
                <a class="image" href="#">
                    <img src="images/touraj.jpg">
                </a>
                <div class="content">
                    <a class="header" href="#">Touraj</a>
                    <div class="meta">
                        <a>Real Fighter</a>
                    </div>
                </div>
            </div>

        </div>
        <div class="column">
            <%--[Begin] Help--%>
            <div class="ui inverted segment">
                <div class="ui inverted accordion">
                    <div class="title active">
                        <i class="dropdown icon"></i>
                        About Kalah Game?
                    </div>
                    <div class="content active">
                        <p class="transition visible" style="display: block !important;">
                            Kalah, also called Kalaha or Mancala, is a game in the mancala family imported in the United
                            States by William Julius Champion, Jr. in 1940. This game is sometimes also called
                            "Kalahari", possibly by false etymology from the Kalahari desert in Namibia.

                            As the most popular and commercially available variant of mancala in the West, Kalah is also
                            sometimes referred to as Warri or Awari, although those names more properly refer to the
                            game Oware.
                        </p>
                    </div>
                    <div class="title">
                        <i class="dropdown icon"></i>
                        Rules
                    </div>
                    <div class="content">
                        <p class="transition hidden">
                            Each of the two players has six pits in front of him/her. To the right of the six pits, each
                            player
                            has a larger pit, his Kalah or house. At the start of the game, six stones are put In each
                            pit.
                            The player who begins picks up all the stones in any of their own pits, and sows the stones
                            on to
                            the right, one in each of the following pits, including his own Kalah. No stones are put in
                            the
                            opponent's' Kalah. If the players last stone lands in his own Kalah, he gets another turn.
                            This can
                            be repeated any number of times before it's the other player's turn.
                        </p>
                    </div>
                    <div class="title">
                        <i class="dropdown icon"></i>
                        Who Wins?
                    </div>
                    <div class="content">
                        <p class="transition hidden">
                            when the last stone lands in an own empty pit, the player captures this stone and all stones
                            in
                            the opposite pit (the other players' pit) and puts them in his own Kalah.
                            The game is over as soon as one of the sides run out of stones. The player who still has
                            stones
                            in his/her pits keeps them and puts them in his/hers Kalah. The winner of the game is the
                            player
                            who has the most stones in his Kalah.
                        </p>
                    </div>
                </div>
            </div>
            <%--[End] Help--%>

            <button onclick="window.location.href='/game'" id="btn1" class="ui button massive green">
                Start Game
            </button>

        </div>


        <div class="column">
            <div class="ui card">
                <a class="image" href="#">
                    <img src="images/david.png">
                </a>
                <div class="content">
                    <a class="header" href="#">David</a>
                    <div class="meta">
                        <a>Spaceship Commander</a>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <div class="row">
        <div class="black column">
            Game Developed by Touraj Ebrahimi

        </div>
        <div class="olive column">


        </div>
    </div>

    <div class="row">
        <div class="column olive">
            <div class="big ui label">
                <i class="github icon"></i> toraj58
            </div>
            <div class="big ui label">
                <i class="bitbucket icon"></i> toraj58
            </div>
            <div class="big ui label">
                <i class="twitter icon teal"></i> @toraj58
            </div>
            <div class="big ui label">
                <i class="mail icon purple "></i> toraj_e@yahoo.com
            </div>
            <div class="big ui label">
                <i class="linkedin square icon blue"></i> Touraj Ebrahimi
            </div>
            <div class="big ui label">
                <i class="skype icon blue"></i> touraj.ebrahimi
            </div>
        </div>
    </div>

</div>


</body>

</html>