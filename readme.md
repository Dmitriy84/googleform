# RECOMENDATIONS for application improvement
 - application should use one language for all labels, text, tips. etc
 - - Right spelling could be found for Ukrainian and Russian languages could be found in MessagesBundle_ua.properties and MessagesBundle_ru.properties correspondingly

 
# NOTES for tests
 - a lot of tests are failed because of uses many languages like ua and ru
 - after will receive fixes for languages issues class TestNgTestBase should be modified
 		<<<public static final ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", new UTF8Control("ua"));>>> correspondingly to default language
 - choosing locale should be moved to application.properties in the future
 - not all bugs are covered by automation tests because some of expected results should be confirmed

 
# BUGS
  - Date verification is absent
 	Description: The user could specify any date which is far away in the past from now as well as in the future
 	Actual:      no date verification
 	Expected:    maximum should be 123 years and minimum 7 years in the past starting from now and.
 	Severity:    Critical
 - Mixed languages on the form.
 	Description: The mix of languages on the form. Should be corrected according to MessagesBundle_ua.properties and MessagesBundle_ru.properties files.
 	Actual:      mix of Ukrainian and Russian languages
 	Expected:    one language or Ukrainian or Russian not both.
 	Severity:    Minor
 - Unlimited input text length.
 	Description: Input boxes 'email address' and 'mood other' have unlimited text length.
 	Actual:      user could input any amount of symbols.
 	Expected:    fields input is limited to some length. Recommended 254 characters for email. 56 characters for 'other mood'. Numbers are relevant for 1920*1080 resolution.
 		Resolution should have influence to these numbers. If value is exceeded when error message should be shown as it is done for the name.
 	Severity:    Minor
 - Increase length for input fields
 	Description: Input fields like email and name should be extended to fill all free space on the form like it is done for 'mood other' input
 	Actual:      input fields are not use whole free space on form to store data
 	Expected:    Input fields email and name use whole free space on form to store data
 	Severity:    Minor

 	
# OUT OF SCOPE
  - performance testing of the application

# Run test
	mvn verify