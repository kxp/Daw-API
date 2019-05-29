import React, { Component } from 'react'
import { Link, Redirect } from 'react-router-dom'

let projects = ["project0", "project1", "project2"]



export default class Projects extends Component {
  constructor(props) {
    super(props);
    this.state = {
      error: null,
      isLoaded: false,
      items: [],
      projects: projects,
      input: "",
      userId: '',
      title: '',
      body: ''

    };
  }

  componentDidMount() {
    fetch('https://jsonplaceholder.typicode.com/posts/1/comments',{
      method: 'GET',
      header: {
          'Content-Type': 'application/json',
          'Authorization': 'dXNlcg==',        
      },
    })
      .then(response => response.json())
      .then(
        (json) => {
        console.log(json)
        this.setState({
          isLoaded: true,
          items: json,
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


    submitHandler = e =>{
      e.preventDefault()
      console.log(this.state)
      fetch('https://jsonplaceholder.typicode.com/posts',{
        method: 'post',
        body: this.state,
      })
      .then(response => console.log(response))
    } 

    inputHandler = (event) => {
      this.setState({
        input: event.target.value
      });
    }

    addProject = () => {
      this.setState(state => ({
        projects: [...state.projects, state.input],
        input: ""
      }))
    }

    deleteProject = (index) => {
       this.setState(state => {
         const projects = [...this.state.projects];
         projects.splice(index, 1);
         return {
           projects: projects
         }
       })
    } 


  render() {
    const { error, isLoaded, items, userId, title, body, projects } = this.state;
    if (error) {
      return <div>Error: {error.message}</div>;
    }
    if (!isLoaded){
      return <div>Loading...</div>
    }
    else {
      return (
        /* Hand coded projects test */
        <div>
          <ul>
              {projects.map((project, i) => 
                 <li key={i}>
                  <Link to={"/project/"+i}>
                  {project}
                  
                  </Link>
                  <button onClick={ () => this.deleteProject(i)} >Delete</button>
                </li>
               )}
          </ul>

          <div>
            <input onChange={this.inputHandler} value={this.state.input} />
            <button onClick={this.addProject}> Add project </button>
          </div>
        </div>
      )
    }
  }
}




