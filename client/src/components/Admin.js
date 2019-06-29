import React, { Component } from 'react'
import { Link, Redirect } from 'react-router-dom'

export default class Admin extends Component {
    constructor(props){
        super(props)
        const token = localStorage.getItem("token")

        let loggedIn = true
        if(token == null){
            loggedIn = false
        }

        this.state = {
            loggedIn
        }
    }
  render() {
      if(this.state.loggedIn === false){
          return <Redirect to="/" />
      }
    return (
      <div>
        <h1>Administrator acces, Home page!</h1>
        <Link to="/logout">Logout</Link>
        <br></br>
        <Link to="/projects">Click to view the projects</Link>
      </div>
    )
  }
}
