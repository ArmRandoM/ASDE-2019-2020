import React from 'react';
import axios from 'axios';

class Persons extends React.Component {

    constructor(props){
        super(props);
        this.state = {
            persons : []
        }

    }

    componentDidMount() {
        axios.get('https://jsonplaceholder.typicode.com/users').then((res) => {
            this.setState({
                persons: res.data
            })
        })
    }

    render() {
        return (
            <ul>
                {this.state.persons.map((persons) => <li> {persons.name} </li>)}
            </ul>)
    }
}

export default Persons;