import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import Person from './components/Person';
import * as serviceWorker from './serviceWorker';

ReactDOM.render(<Person name="Ciccio" surname="Pasticcio"/>, document.getElementById('root'));
serviceWorker.unregister();
