import React, { Component } from 'react'
import { Link, Redirect } from 'react-router-dom'

let projects = ["project 1", "project 2", "project 3"]




export default class Projects extends Component {
  constructor(props) {
    super(props);
    this.state = {
      error: null,
      isLoaded: false,
      items: [],
    };
  }

  componentDidMount() {
    fetch('http://51.75.163.237:8080/v1/projects/',{
      method: 'GET',
      header: {
          'Authorization': 'dXNlcg==',
      },
    })
      .then(response => response.json())
      .then(
        (json) => {
        this.setState({
          isLoaded: true,
          items: JSON.stringify(json),
        });
      },
      (error) => {
        this.setState({
          isLoaded: true,
          error
        });
      }


      );
  }


  render() {
    const { error, isLoaded, items } = this.state;
    if (error) {
      return <div>Error: {error.message}</div>;
    }
    if (!isLoaded){
      return <div>Loading...</div>
    }
    else {
      return (
        <div>
          <ul>
          {items.map(item => (<li key={item.id}><Link to={"/project/"+item.id}>{item.title}</Link></li>))}
              
        </ul>
        </div>
      )
    }
  }
}




