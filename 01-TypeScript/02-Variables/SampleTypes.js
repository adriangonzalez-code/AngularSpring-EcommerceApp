var found = true;
var grade = 88.6;
var firstName = "Anup";
var lastName = 'Kumar';
// Let's break it!!!
/*
found = 0;
grade = "A";
firstName = false;
*/
console.log(found);
console.log("The grade is " + grade);
console.log("Hi " + firstName + " " + lastName);
// Use template Strings
console.log("Hi ".concat(firstName, " ").concat(lastName));
