import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import Person from './components/Person';
import * as serviceWorker from './serviceWorker';

/* 
    Hello World Example
    In this example we are adding HTML to the root element.
    This programming language is JavaScript but these is a
    special version, for example this version allows to put 
    HTML code inside JavaScript.
    For example, the following constant is equal to an HTML 
    tag.
*/
const message = <h1>Hello World!</h1>

const expression = 
(
    <div>
        <h1>1 + 1 = {1 + 1}</h1>
    </div>
)

/*
class Person 
{
    constructor() 
    {
        this.name = "Ciccio";
        this.surname = "Pasticcio";
    }

    log() 
    {
         
        //    in this case the variable message is visible only in the function,
        //   so the function has a FUNCTION SCOPED   
        if(1 == 1)
            var message = "Hello";

        console.log("Person: " + this.name + " " + this.surname);
    }
    
    
    //    This is an ARROW FUNCTION for the log:
    //    - () we can avoid the parentheses in the case in which we have not parameters;
    
    print = () => 
    {
        console.log("Print person: " + this.name + " " + this.surname);
    }
}

//We can use hineritance
class Student extends Person 
{
    //    we use the keyword super() to overwrite both the constructor and the log method
    //    We cannot use more constructors, even if we change the parameters, we cannot do 
    //    this:
    //    constructor(name){...}
    constructor()
    {
        //In this case we refer to the constructor of the super class
        super();
    }

    log()
    {
        super.log();
    }

}
*/

/*
    REACT uses an extension of JavaScript that is named JSX, 
    that is JavaScript with XML.
*/

/* 
    In this case we have an HTML and some elements, 
    and we want to put these element in the react application,
    inside the root element.
    In this example we are assuming that in the HTML we have an
    element whose id is "root".
    REACT start rendering what we want from the root element 
    (index.html).
    The start is defined from the code line below.
    The render method takes two parameters:
    - the first is a react element;
    - the second is an element in the html page.
    It will punt the react element inside the element in the html 
    page.
*/

//ReactDOM.render(message, document.getElementById('root'));

//ReactDOM.render(expression, document.getElementById('root'));

// To display components we use an HTML class whoes name is the same name of the class
//ReactDOM.render(<Person />, document.getElementById('root'));
ReactDOM.render(<Person name="Ciccio" surname="Pasticcio"/>, document.getElementById('root'));
serviceWorker.unregister();
