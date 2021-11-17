# Login

    ## Domain: localhost:81/login
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
                
                
# Logout

    ## Domain: localhost:81/logout



# Đăng Kí User


    ## Domain: localhost:81/dangki
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
        


# User

    ## Domain: localhost:81/user

            ### Lấy dữ liệu người dùng

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

    ###Sử dữ liệu người dùng

            method : PUT

            Request Headers:{
            "Authorization" : "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkIiwiZXhwIjoxNjM3MDcxOTY1LCJpYXQiOjE2MzcwNTM5NjV9.rHBCyHC6SDafYd4VjiW2p0YspN8wX9vJ2viQRxh5N55XRnfzjM7GlyMQB3BIof8b_fm1iV99vXkcZLevxZyk-w"
            }

        Request Body:{
                        "name": "Tuan1",
                        "phone": "0396118696"
                    }


        Response:
        
                True:
                    {
                        "avt": null,
                        "name": "Tuan1",
                        "password": "$2a$10$3tG56yvLSH5YHkqYhONKQuKlqE1razN9M7dcpu6CvY8fSb3aQhkba",
                        "role": "USER",
                        "email": "user1",
                        "iduser": 22,
                        "phone": "0396118696"

                    }
                False:{
                        "timestamp": "2021-11-16T09:24:36.941+00:00",
                        "status": 401,
                        "error": "Unauthorized",
                        "path": "/user"
                        }
        
    ### Thay doi avt

        Domain: localhost:81/user/avt

        method : PUT

            Request Headers:{
            "Authorization" : "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkIiwiZXhwIjoxNjM3MDcxOTY1LCJpYXQiOjE2MzcwNTM5NjV9.rHBCyHC6SDafYd4VjiW2p0YspN8wX9vJ2viQRxh5N55XRnfzjM7GlyMQB3BIof8b_fm1iV99vXkcZLevxZyk-w"
            }
            Request Body:{
                        from-data:
                            key : file
                            value : hình ảnh
                    }
            Response:
                True:
                    {
                       Thêm ảnh thành công
                    }
                False:{
                        Thêm ảnh thất bại
                        }

    ### Xem lịch sử tiếp xúc

        Domain: localhost:81/user/tiepxuc

        method : GET
            Request Headers:{
            "Authorization" : "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkIiwiZXhwIjoxNjM3MDcxOTY1LCJpYXQiOjE2MzcwNTM5NjV9.rHBCyHC6SDafYd4VjiW2p0YspN8wX9vJ2viQRxh5N55XRnfzjM7GlyMQB3BIof8b_fm1iV99vXkcZLevxZyk-w"
            }
         Response:
                [
                    {
                        "thoigian": "2021-11-12T07:57:54.000+00:00",
                        "tendiadiem": "dia diem 2",
                        "tenkhuvuc": "Phường Trung Đô"
                    },
                    {
                        "thoigian": "2021-11-16T01:07:27.000+00:00",
                        "tendiadiem": "dia diem 2",
                        "tenkhuvuc": "Phường Trung Đô"
                    }
                ]
                
    ### Thêm lịch sử tiếp xúc
    
    
        Domain: localhost:81/user/tiepxuc

        method : POST
            Request Headers:{
            "Authorization" : "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkIiwiZXhwIjoxNjM3MDcxOTY1LCJpYXQiOjE2MzcwNTM5NjV9.rHBCyHC6SDafYd4VjiW2p0YspN8wX9vJ2viQRxh5N55XRnfzjM7GlyMQB3BIof8b_fm1iV99vXkcZLevxZyk-w"
            }
            Request Body:{
                    
            }

    
