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