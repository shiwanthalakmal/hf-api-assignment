# hf-api-assignment

### Prerequisites:
> - Java 1.8
> - Maven
> - Git

### Execute hf-api-test-bdd via Commandline:
> - Clone the hf-api-assignment project from git.
>   Command: ```git clone https://github.com/shiwanthalakmal/hf-api-assignment.git```
> - Move to hf-api-assignment root directory. ```cd hf-api-assignment```
> - Simply trigger the execution using ```mvn clean verify``` command

#### Additional Information:
> - User friendly output will be generated on the console during the execution
> - A comprehensive html report will be generated under: ```hf-api-assignment\target\site\cucumber-reports\cucumber-html-reports```. Note: You can open the report by clicking on "overview-features.html"

### Assignment Criteria and Status
- [x] getBookings: Test that at least 2 existing bookings are returned in the response.
- [x] getBooking: Test that the data returned for an existing booking matches.
- [x] createBooking: Test that bookings can be created. Keep in mind these restrictions

### Third Party Library Usage
- ```Unit test runner - junit 4.12```
- ```Testing and validating REST services -rest-assured 3.0.0```
- ```Easily create matchers - org.hamcrest 2.0.0.0```
- ```BDD support - info.cukes 1.2.5```
- ```JSON extraction - com.google.code.gson 2.8.5```
- ```Generate comprehensive html test report - net.masterthought 3.20.0```
