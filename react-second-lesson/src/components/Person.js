import React from 'react';

class Person extends React.Component 
{
  /*
    constructor è il primo metodo che viene invocato, una volta fatto
    ciò viene creata un'istanza di Person e il costruttore viene ese-
    guito.
  */

  /* 
    constructor con la definizione dello state tramite props, non rap-
    presenta la scelta migliore.
  
  constructor(props) 
  {
    super(props);
    this.state =
    {
      name : this.props.name,
      surname : this.props.surname
    }
  }
  */
  constructor(props) 
  {
    console.log('constructor()');
    super(props);
    this.state = 
    {  
      name : props.name,
      surname : props.surname
    }
  }

  /*
    una volta eseguito il costruttore, prova ad eseguire getDerivedS-
    tateFromProps e se questo non viene sovrascritto allora non fa n-
    iente.
    La cosa princpale da fare è spostare il codice che permette di d-
    efinire lo state tramite props all'interno del metodo getDerived-
    StateFromProps:
  */
 
  /*
  static getDerivedStateFromProps(props, state)
  {
    console.log('gdsfp()');
    return {
      name: props.name,
      surname: props.surname
    }
  }
  */

  changeName = (newName, event) => 
  {  
    this.setState({
        name : newName
    });
  }

  /* 
    In questo caso viene creato un metodo per gestire l'evento,
    per l'input text.
  */
  changeSurnameFromInput = (newValue,event) => 
  {  
    this.setState({
        surname : newValue
    });
  }

  /*
    In questo modo se si cambia il valore nell'input text viene
    definito un hendler che sull'evento onChange.
    Così il surname viene aggiornato in tempo reale.
  */
  render() 
  {
    console.log("render()");
    return ( 
      <div>
        <input onChange={(event) => this.changeSurnameFromInput(event.target.value, event)}></input>
        <button onClick={(event) => this.changeName("Pippo",event)}>Change name to Pippo</button>
        <h1>I am {this.state.name} {this.state.surname} </h1>
      </div>
    )
  }
  
  componentDidMount() 
  {
    console.log("componentDidMound()");
  }
  

  /*
    come si può vedere nella console, i metodi vengono eseguiti in questo ordine:
    1. constructor();
    2. getDerivedStateFromProps();
    3. render();
    4. componentDidMount();
    il framework gestisce il flusso di esecuzione.
  */
}


export default Person;