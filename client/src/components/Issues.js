import React, { Component } from 'react'
import { Link, Redirect } from 'react-router-dom'





export default class Issues extends Component {
  constructor(props) {
    super(props);
    console.log(props.id)
    this.state = {
      projectid: this.props.match.params.id,
      issues: ["issue 0", "issue 1", "issue 2"],
      input: ""
    }
  }

  inputHandler = (event) => {
    this.setState({
      input: event.target.value
    });
  }

  addIssue = () => {
    this.setState(state => ({
      issues: [...state.issues, state.input],
      input: "",
    }))
  }

  deleteIssue = (index) => {
    this.setState(() => {
      const issues = [...this.state.issues];
      issues.splice(index, 1);
      return {
        issues: issues
      }
    })
 } 

  render() { 
    const {issues,issueid,projectid} = this.state;
    console.log(issueid)
    return (
      <div>
        <h1> Issues of project: {this.props.match.params.id}</h1>
        <ul>
              {issues.map((project, i) => 
                 <li key={i}>
                  <Link to={"/project/"+ this.state.projectid +"/issues/" + i}>{project}</Link>
                  <button onClick={ () => this.deleteIssue(i)} >Delete</button>
                </li>
               )}
          </ul>

          <div>
            <input onChange={this.inputHandler} value={this.state.input} />
            <button onClick={this.addIssue}> Add issue </button>
          </div>
      </div>
    )
  }
}

