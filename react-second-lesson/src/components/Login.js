import React from 'react';

/*
    Questo componente viene pensato per la gestione di un 
    form di login.
    Si hanno due input text:
    1. username;
    2. password;
    3. submit button;
*/

class login extends React.Component {

    constructor(props){
        super(props);
        this.state = {
            username : props.username,
            password : props.password
        }
    }

    /*
    Duplicazione di codice:
    onChangeUsername = (newValue,event) => 
    {   
        this.setState({
            username : newValue
        });
    }

    onChangePassword = (newValue,event) => 
    {   
        this.setState({
            password : newValue
        });
    }
    */

    // E' possibile usare lo stesso codice anzichè duplicarlo.
    onChangeInput = (event) => 
    {   
        this.setState({
            [event.target.name] : event.target.value
        });
    }

    /*
        In questo modo la pagina non viene aggiornata.
        In un caso generale ciò che si vuole fare è quello di 
        eseguire una richiesta Ajax.
        In modo tale che il server verifichi se le credenziali 
        siano corrette.
        Si vuole effettuare una richiesta al server.
    */
    logginAttempt = (event) =>
    {
        console.log("perform loginAttempt " + this.state.username + " " + this.state.password);
        event.preventDefault();
    }

    /*
    const mystyle = {
        color : "red"
    };*/
    
    render() {
        return (
            <div>
                <h1>Login Form</h1>
                <form>
                    <input name='username' onChange= {this.onChangeInput} type='text'></input>
                    <input name='password' onChange={this.onChangeInput} type='password'></input>
                    <input onClick={(event) => this.logginAttempt(event)} type='submit'></input>
                </form>
                <h1 style={{color:"red"}}>username: {this.state.username} </h1>
                <h1 style={{color:"green"}}>password: {this.state.password}</h1>
                <select value="Yellow">
                    <option value="Red">Red</option>
                    <option value="Yellow">Yellow</option>
                    <option value="Blue">Blue</option>
                </select>
            </div>
        );
    }
}

export default login;