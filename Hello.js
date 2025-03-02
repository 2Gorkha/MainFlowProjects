//console.log("Hello I am Rahul");
//var message = "I am Sangeeta Kumari";
//var message = "I am Arun Kumar";//Var is used in variable declaration and can be redeclared
//console.log(message);

let message = "Hii I am Java Script Variable";
//let message = "Hii"; Cannot be redeclared but can be updated with another value
message = "I am Let Variable I cannot be Redeclared but can be Updated If Needed";
console.log(message);

//const text = "I am Const and Therefore I remain Constant Throughout the program and cannot be updated or redeclared";
//console.log(text);
//console.log(typeof text);
//Variable Namming Convention
// Can start only with alphabet,number and some special character($,_)
// No special is allowed other than above mentioned 
//Should not start with number but can end with number 
//Should not contain space in-between
//Variable name should always indicate the type of data stored
// It is case sensitive(for example Age and age are two different variable names )
_number = 99;
console.log(typeof _number);
// Boolean Datatype
let ProductInCart = false;
console.log(typeof ProductInCart);
// undefined
let age;
console.log(age);
//Object 
let object = {Name:"Sangeeta Kumari",Age:41,Role:"House-Maker"};
console.log(typeof object);
console.log(object);
let myArray = [44,55,66,22];
console.log(myArray);   
// Concadination 
let userName = "Rohit Raj";
let company = "Google";
let text = "My Name is "+userName+ " and I am an Engineer at "+company;
console.log(text);
// Template Literal
let college = "Hindustan Institute of Technology and Science";
let text1 = `My name is ${userName} and I am an Engineer at ${company}
I have completed my Btech from ${college}`;
console.log(text1);