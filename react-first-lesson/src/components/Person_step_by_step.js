/* FIRST IMPLEMENTATION
import React from 'react';

class Person extends React.Component
{

  constructor()
  {
    super();
    this.name = "Ciccio";
    this.surname = "Pasticcio"
  }

  render()
  {
    return<h1>I am {this.name} {this.surname} </h1>;
  }

  changeToPippo = () =>
  {
    this.setState
    (
      {
        name: "Pippo"
      }
    );
  }

}

export default Person;
*/

/*
SECOND IMPLEMENTATION with the state object

import React from 'react';

class Person extends React.Component 
{
  constructor() 
  {
    super();
    this.state =
    {
      name : "Ciccio",
      surname : "Pasticcio"
    }
  }
  
  render() 
  {
      return <h1> I am {this.state.name} {this.state.surname} </h1>;
  }
}

export default Person;
*/

/* THIRD IMPLEMENTATION
import React from 'react';

class Person extends React.Component 
{
  constructor() 
  {
    super();
    this.state =
    {
      name : "Ciccio",
      surname : "Pasticcio"
    }
  }

  changeToPippo = () =>
  {
    
    //  In this case the object the is executing the method is the button,
    //  but in this case we want to refer to the object person, and this 
    //  can be done using the ARROW FUNCTION.
    //  Once we Change the State the object will be re-rendered.
    //  To this we use the setState method.
    
    this.setState
    (
      {
        name : "Pippo"
      }
    );
  }

  render() 
  {
    return ( 
      <div>
        <button onClick={this.changeToPippo}>Change name to Pippo</button>
        <h1>I am {this.state.name} {this.state.surname} </h1>
      </div>
    )
  }
}

export default Person;
*/

import React from 'react';

class Person extends React.Component 
{
  constructor(props) 
  {
    super(props);
    this.state =
    {
      name : this.props.name,
      surname : this.props.surname
    }
  }
  
  changeToPippo = () =>
  {
    this.setState
    (
      {
        name : "Pippo"
      }
    );
  }

  render() 
  {
    return ( 
      <div>
        <button onClick={this.changeToPippo}>Change name to Pippo</button>
        <h1>I am {this.state.name} {this.state.surname} </h1>
      </div>
    )
  }
}

export default Person;