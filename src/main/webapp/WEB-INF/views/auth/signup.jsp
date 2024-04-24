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
        <!--회원가입섹션-->
        <section class="login">
            <article class="login__form__container">

                <!--회원가입 폼-->
                <div class="login__form">
                    <!--로고-->
                    <h1><img src="/images/logo.jpg" alt=""></h1>
                    <!--로고end-->

                    <!--회원가입 인풋-->
                    <form class="login__input" action="/auth/signup" method="post">
                        <div class="mb-3">
                            <input type="text" class="form-control" name="username" placeholder="유저네임"
                                   required="required" maxlength="30"/>
                        </div>
                        <div class="mb-3">
                            <input type="password" class="form-control" name="password" placeholder="패스워드"
                                   required="required"/>
                        </div>
                        <div class="mb-3">
                            <input type="email" class="form-control" name="email" placeholder="이메일"
                                   required="required"/>
                        </div>
                        <div class="mb-3">
                            <input type="text" class="form-control" name="name" placeholder="이름" required="required"/>
                        </div>
                        <button type="submit" class="btn btn-primary">가입</button>
                    </form>
                    <!--회원가입 인풋end-->
                </div>
                <!--회원가입 폼end-->

                <!--계정이 있으신가요?-->
                <div class="login__register">
                    <span>계정이 있으신가요?</span>
                    <a href="/auth/signin" class="btn btn-link">로그인</a>
                </div>
                <!--계정이 있으신가요?end-->

            </article>
        </section>
    </main>
</div>

</body>

</html>
