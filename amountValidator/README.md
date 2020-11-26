# NHSBSA_ASSIGNMENT with Spring Boot

### Tech Stack
Technologies used for current Task

* [Java 1.8]
* [Spring Boot, Spring Boot Web,embedded Tomcat Server]
* [Maven]
* [Swagger]


### Rest Apis Info
The following things illustrate Requests and Response:
# A post api which takes in regular amount json including amount and frequency
#Note: frequency can take only WEEK, TWO_WEEK, FOUR_WEEK, MONTH, QUARTER, YEAR
/validateAmount
* [Request] : {
	"frequency":"TWO_WEEK",
	"amount":"32.0"
}
* [Response] :true

* [Request]:{
	"frequency":"TWO_WEEK",
	"amount":"32.90"
}
* [Response]: Invalid amount

