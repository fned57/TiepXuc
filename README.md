#Login
    Domain: localhost:81/login
        Request:{
                    "username" : "username",
                    "password" : "password"
                }
        Response: 
            True:{
                    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkIiwiZXhwIjoxNjM3MDcxNzA1LCJpYXQiOjE2MzcwNTM3MDV9.jS6LaPSWp_SUAV44utiS2nBZNZlf16pv-MYZTItPyJ9GlJsSfiRJRJa2-dUw_6tOBdnhh04MfManKIGHiTZ1Yg"
                }
            False:
                {
                    "timestamp": "2021-11-16T09:09:02.312+00:00",
                    "status": 401,
                    "error": "Unauthorized",
                    "path": "/login"
                }
#Logout
    Domain: localhost:81/logout



#Đăng Kí User
    Domain: localhost:81/dangki
        method : POST
        Request:{
                    "name": "Tuan",
                    "password": "user",
                    "email": "user",
                    "phone": "0396118696"
                }
        Response:
            True:
                {
                     Đăng kí thành công
                }
            False:{
                    Đăng Kí Thất bại
                }
        


#User
    Domain: localhost:81/user
        method : Get
        Request Headers:{
           "Authorization" : "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkIiwiZXhwIjoxNjM3MDcxOTY1LCJpYXQiOjE2MzcwNTM5NjV9.rHBCyHC6SDafYd4VjiW2p0YspN8wX9vJ2viQRxh5N55XRnfzjM7GlyMQB3BIof8b_fm1iV99vXkcZLevxZyk-w"
       }
       Response:
            True:
                {
                    "avt": null,
                    "name": "Tuan",
                    "password": "$2a$10$3tG56yvLSH5YHkqYhONKQuKlqE1razN9M7dcpu6CvY8fSb3aQhkba",
                    "role": "USER",
                    "phone": "0396118696",
                    "email": "user1",
                    "iduser": 22

                }
            False:{
                    "timestamp": "2021-11-16T09:24:36.941+00:00",
                    "status": 401,
                    "error": "Unauthorized",
                    "path": "/user"
                    }

    
