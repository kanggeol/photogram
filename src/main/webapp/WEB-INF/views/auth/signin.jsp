<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Photogram</title>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
          integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>

<body>
<div class="container">
    <main class="loginMain">
        <!--로그인섹션-->
        <section class="login">
            <!--로그인박스-->
            <article class="login__form__container">
                <!--로그인 폼-->
                <div class="login__form">
                    <h1><img src="/images/logo.jpg" alt=""></h1>

                    <!--로그인 인풋-->
                    <form class="login__input" action="/auth/signin" method="POST">
                        <div class="mb-3">
                            <input type="text" class="form-control" name="username" placeholder="유저네임"
                                   required="required"/>
                        </div>
                        <div class="mb-3">
                            <input type="password" class="form-control" name="password" placeholder="비밀번호"
                                   required="required"/>
                        </div>
                        <button type="submit" class="btn btn-primary">로그인</button>
                    </form>
                    <!--로그인 인풋end-->

                    <!-- 또는 -->
                    <div class="login__horizon mb-3">
                        <div class="br"></div>
                        <div class="or">또는</div>
                        <div class="br"></div>
                    </div>
                    <!-- 또는end -->

                    <!-- Oauth 소셜로그인 -->
                    <div class="login__facebook">
                        <button onclick="javascript:location.href='/oauth2/authorization/facebook'"
                                class="btn btn-primary">
                            <i class="fab fa-facebook-square"></i>
                            <span>Facebook으로 로그인</span>
                        </button>
                    </div>
                    <!-- Oauth 소셜로그인end -->
                </div>

                <!--계정이 없으신가요?-->
                <div class="login__register">
                    <span>계정이 없으신가요?</span>
                    <a href="/auth/signup" class="btn btn-link">가입하기</a>
                </div>
                <!--계정이 없으신가요?end-->
            </article>
        </section>
    </main>
</div>

</body>

</html>
