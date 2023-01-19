# REST API Design #

## Student POJO ##
String id<br>
String firstname<br>
String lastname<br>
String grade<br>
Double gpa<br>
String address<br>

## Course POJO ##
Integer id<br>
String name<br>
String instructor<br>
String description<br>

## Student_Course POJO ##
Integer id<br>
Student student<br>
Course course<br>
Double score<br>


## Student REST API ##
prefix: /students <br>
method: GET, REST API:  /students <br>
method: GET, REST API:  /students/{id} <br>
method: POST, REST API: /students<br>
method: PUT, REST API:  /students <br>
method: DELETE, REST API: /students/{id}<br>


## Course REST API ##
prefix: /courses <br>
method: GET, REST API:  /courses <br>
method: GET, REST API:  /courses/{id} <br>
method: POST, REST API: /courses<br>
method: PUT, REST API:  /courses <br>
method: DELETE, REST API: /courses/{id}<br>

## Student_Course REST API ##
method: GET, REST API:  /students/{sid}/courses/{cid} <br>
method: DELETE, REST API:  /students/{sid}/courses/{cid} <br>
method: POST, REST API: /students/courses <br>
method: PUT, REST API:  /students/courses <br>


