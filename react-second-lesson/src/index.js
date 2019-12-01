import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
//import Person from './components/Person';
//import Login from './components/Login';
import Persons from './components/Persons';
import * as serviceWorker from './serviceWorker';

//ReactDOM.render(<Person name="Ciccio" surname="Pasticcio"/>, document.getElementById('root'));
//ReactDOM.render(<Login/>, document.getElementById('root'));
ReactDOM.render(<Persons/>, document.getElementById('root'));
serviceWorker.unregister();
