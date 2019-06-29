import React, { Component } from 'react'
import { Link, Redirect } from 'react-router-dom'

let d = new Date()

export default class Issues extends Component {
  constructor(props) {
    super(props);
    console.log(props.id)
    this.state = {
      issueid: this.props.match.params.issues_id,
      title: "First problem",
      comments: ["First comment", "Second comment", "Third comment"],
      input: ""
    }
  }

  inputHandler = (event) => {
    this.setState({
      input: event.target.value
    });
  }

  addComment = () => {
    this.setState(state => ({
      comments: [...state.comments, state.input],
      input: ""
    }))
  }

  deleteComment = (index) => {
    this.setState(state => {
      const comments = [...this.state.comments];
      comments.splice(index, 1);
      return {
        comments: comments
      }
    })
 } 

  render() { 
    const {comments,issueid} = this.state;
    
    return (
      <div>
          <center>
        <h1> Issue number: {this.state.issueid}</h1>
        <h3>{this.state.title}</h3>
        <ul>
              {comments.map((comment, i) => 
                 <p key={i}>
                 User said: "<i>{comment}</i>" in {d.getFullYear()}, {d.getMonth()}, {d.getDate()}
                  <button onClick={ () => this.deleteComment(i)} >Delete</button>
                </p>
               )}
          </ul>

          <div>
            <textarea onChange={this.inputHandler} value={this.state.input} />
            <br/>
            <button onClick={this.addComment}> Add comment </button>          
          </div>
          </center>
      </div>
    )
  }
}