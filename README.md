RESTFul photo master API built with Java with Apache Maven, Tomcat and cloudinary.

What is Photo Master?

Photo Master is a client app which allows users to upload images either via a remote URL or local computer. Photo Master is always accessible for the user to view all their uploaded photos. They can download, delete, upload anytime they want. All of their photos are safety stored on the cloud as provided by cloudinary. (Currently I am using my cloudinary public_id and my secret key for image upload, feel free to change to your own)                                  

Photo Master Architecture

Photo Master was written using Java, Apache Maven, Gson (An open-source library for converting JSON), AngularJS, HTML, JSP. AngularJS, HTML, JSP are responsible for delivering beautiful user interface on the front-end while Apache Maven, Gson and Java are running on the web server side handling all user requests (Upload: HTTP GET when user uploads images via URL, HTTP POST when user uploads images from local computer, delete: HTTP DELETE request, view images: HTTP GET request.).

