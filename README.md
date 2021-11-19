# Login

*Domain: localhost:81/login*
   
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

*Domain: localhost:81/logout*

# Đăng Kí User
*Domain: localhost:81/dangki*
    
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

*Domain: localhost:81/user*

## Lấy dữ liệu người dùng

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

## Sửa dữ liệu người dùng

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
        
## Thay doi avtar

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

##  Xem lịch sử tiếp xúc

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
                
## Thêm lịch sử tiếp xúc
    
    
        Domain: localhost:81/user/tiepxuc

        method : POST
            Request Headers:{
            "Authorization" : "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkIiwiZXhwIjoxNjM3MDcxOTY1LCJpYXQiOjE2MzcwNTM5NjV9.rHBCyHC6SDafYd4VjiW2p0YspN8wX9vJ2viQRxh5N55XRnfzjM7GlyMQB3BIof8b_fm1iV99vXkcZLevxZyk-w"
            }
            Request Body:{
                    {
                        "khuvuc": {
                            "idkhuvuc": 5,
                            "tenkhuvuc": "Phường Trung Đô"
                        },
                        "iddiadiem": 1,
                        "tendiadiem": "dia diem 2"
                    }
            }
            Response:
                [
                    {
                        "thoigian": "2021-11-19T02:38:01.000+00:00",
                        "name": "Tuan",
                        "tendiadiem": "dia diem 2",
                        "tenkhuvuc": "Phường Trung Đô"
                    }
                ]
    
# Admin
## Khuc Vực
    
*Lấy ra toàn bộ khu vực*
        
        Domain: localhost:81/admin/khuvuc

        Method: Get

            Request Headers:{
                "Authorization" : "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkIiwiZXhwIjoxNjM3MDcxOTY1LCJpYXQiOjE2MzcwNTM5NjV9.rHBCyHC6SDafYd4VjiW2p0YspN8wX9vJ2viQRxh5N55XRnfzjM7GlyMQB3BIof8b_fm1iV99vXkcZLevxZyk-w"
                }
                Response:
                    [
                        {
                            "idkhuvuc": 5,
                            "tenkhuvuc": "Phường Trung Đô"
                        }
                    ]

        Method: POST

            Request Headers:{
                "Authorization" : "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkIiwiZXhwIjoxNjM3MDcxOTY1LCJpYXQiOjE2MzcwNTM5NjV9.rHBCyHC6SDafYd4VjiW2p0YspN8wX9vJ2viQRxh5N55XRnfzjM7GlyMQB3BIof8b_fm1iV99vXkcZLevxZyk-w"
                }
            Request Body:{
                            "idkhuvuc": 5,
                            "tenkhuvuc": "Phường Trung Đô"
                        }
            Response:
                    [
                        {
                            "idkhuvuc": 5,
                            "tenkhuvuc": "Phường Trung Đô"
                        }
                    ]

        Method: PUT
            
            Domain: localhost:81/admin/khuvuc/5


            Request Headers:{
                "Authorization" : "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkIiwiZXhwIjoxNjM3MDcxOTY1LCJpYXQiOjE2MzcwNTM5NjV9.rHBCyHC6SDafYd4VjiW2p0YspN8wX9vJ2viQRxh5N55XRnfzjM7GlyMQB3BIof8b_fm1iV99vXkcZLevxZyk-w"
                }
            Request Body:{
                        
                            "tenkhuvuc": "Phường Trung Đô"
                        }
            Response:
                    [
                        {
                            "idkhuvuc": 5,
                            "tenkhuvuc": "Phường Trung Đô"
                        }
                    ]
    
*Thêm địa điểm cho khuc vực*
         
         Method = POST
         Domain: localhost:81/admin/khuvuc/5


            Request Headers:{
                "Authorization" : "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkIiwiZXhwIjoxNjM3MDcxOTY1LCJpYXQiOjE2MzcwNTM5NjV9.rHBCyHC6SDafYd4VjiW2p0YspN8wX9vJ2viQRxh5N55XRnfzjM7GlyMQB3BIof8b_fm1iV99vXkcZLevxZyk-w"
                }
            Request Body:{
                        
                            "tendiadiem": "dia diem 2"
                        }
            Response:
                    {
                        "khuvuc": {
                            "idkhuvuc": 5,
                            "tenkhuvuc": "Phường Trung Đô"
                        },
                        "iddiadiem": 26,
                        "tendiadiem": "Dia diem 3"
                    }

## Địa điểm
*Lấy ra toàn bộ địa điểm*

        Domain: localhost:81/admin/diadiem

        Method: Get

            Request Headers:{
                "Authorization" : "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkIiwiZXhwIjoxNjM3MDcxOTY1LCJpYXQiOjE2MzcwNTM5NjV9.rHBCyHC6SDafYd4VjiW2p0YspN8wX9vJ2viQRxh5N55XRnfzjM7GlyMQB3BIof8b_fm1iV99vXkcZLevxZyk-w"
                }
                Response:
                    [
                        {
                            "khuvuc": {
                                "idkhuvuc": 5,
                                "tenkhuvuc": "Phường Trung Đô"
                            },
                            "iddiadiem": 1,
                            "tendiadiem": "dia diem 2"
                        },
                        {
                            "khuvuc": {
                                "idkhuvuc": 5,
                                "tenkhuvuc": "Phường Trung Đô"
                            },
                            "iddiadiem": 6,
                            "tendiadiem": "Dia diem 1 "
                        },...
                    ]

*Lấy ra môt địa điểm*

        Domain: localhost:81/admin/diadiem/1

        Method: Get

            Request Headers:{
                "Authorization" : "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkIiwiZXhwIjoxNjM3MDcxOTY1LCJpYXQiOjE2MzcwNTM5NjV9.rHBCyHC6SDafYd4VjiW2p0YspN8wX9vJ2viQRxh5N55XRnfzjM7GlyMQB3BIof8b_fm1iV99vXkcZLevxZyk-w"
                }
                Response:
                        {
                            "khuvuc": {
                                "idkhuvuc": 5,
                                "tenkhuvuc": "Phường Trung Đô"
                            },
                            "iddiadiem": 1,
                            "tendiadiem": "dia diem 2"
                        },
                        
                
*Sửa thông tin địa điểm*

        Method: PUT

        Domain: localhost:81/admin/diadiem/1
        
        Request Headers:{
                "Authorization" : "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkIiwiZXhwIjoxNjM3MDcxOTY1LCJpYXQiOjE2MzcwNTM5NjV9.rHBCyHC6SDafYd4VjiW2p0YspN8wX9vJ2viQRxh5N55XRnfzjM7GlyMQB3BIof8b_fm1iV99vXkcZLevxZyk-w"
                }
            Request Body:{
                        
                            "tendiadiem": "dia diem 3"
                        }
            Response:
                    {
                        "khuvuc": {
                            "idkhuvuc": 5,
                            "tenkhuvuc": "Phường Trung Đô"
                        },
                        "iddiadiem": 1,
                        "tendiadiem": "Dia diem 3"
                    }
*Xóa địa điểm*

        Method: DELETE

        Domain: localhost:81/admin/diadiem/1
        
        Request Headers:{
                "Authorization" : "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkIiwiZXhwIjoxNjM3MDcxOTY1LCJpYXQiOjE2MzcwNTM5NjV9.rHBCyHC6SDafYd4VjiW2p0YspN8wX9vJ2viQRxh5N55XRnfzjM7GlyMQB3BIof8b_fm1iV99vXkcZLevxZyk-w"
                }
        
        Response:
                True:{
                       Xóa thành công
                    }
                False{
                    Xóa thất bại
                }  


## Tiếp Xúc

*lấy ra địa điểm tiếp xúc và người tiếp xúc*

    Domain: localhost:81/admin/tiepxuc?user=tuan&diadiem=Dia diem 1

    Request Headers:{
                "Authorization" : "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkIiwiZXhwIjoxNjM3MDcxOTY1LCJpYXQiOjE2MzcwNTM5NjV9.rHBCyHC6SDafYd4VjiW2p0YspN8wX9vJ2viQRxh5N55XRnfzjM7GlyMQB3BIof8b_fm1iV99vXkcZLevxZyk-w"
                }
        
        Response:
                [
                    {
                        "id": 1,
                        "diadiem": {
                            "khuvuc": {
                                "idkhuvuc": 5,
                                "tenkhuvuc": "Phường Trung Đô"
                            },
                            "iddiadiem": 6,
                            "tendiadiem": "Dia diem 1 "
                        },
                        "user": {
                            "avt": null,
                            "name": "Tuan",
                            "password": null,
                            "role": null,
                            "email": null,
                            "phone": "0396118696",
                            "iduser": 2
                        },
                        "thoigian": "2021-11-09T21:55:29.000+00:00"
                    }
                ]

*lấy ra một tiếp xúc củ thể*
    Domain: localhost:81/admin/tiepxuc/1
            Request Headers:{
                            "Authorization" : "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkIiwiZXhwIjoxNjM3MDcxOTY1LCJpYXQiOjE2MzcwNTM5NjV9.rHBCyHC6SDafYd4VjiW2p0YspN8wX9vJ2viQRxh5N55XRnfzjM7GlyMQB3BIof8b_fm1iV99vXkcZLevxZyk-w"
                     } 
            Response:{
                        "thoigian": "2021-11-09T21:55:29.000+00:00",
                        "name": "Tuan",
                        "tendiadiem": "Dia diem 1 ",
                        "tenkhuvuc": "Phường Trung Đô"
                    }
        




        

        
