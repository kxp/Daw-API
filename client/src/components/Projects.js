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

  const responseObj = fetch('http://localhost:8080/v1/projects/', { 
    method: 'GET', 
    header: new Headers({
      'Authorization': 'dXNlcg==',
      'Access-Control-Allow-Origin':'*',
      'Access-Control-Allow-Methods': 'GET, PUT, POST, DELETE, OPTIONS',
      'Content-Type': 'application/json',
    }), 
  });

   //const request = {
   // headers: {'X-Custom-Header': 'foobar'}

     //method: "GET",
     //headers: { 
      //"Authorization": "dXNlcg==",
      //"Content-Type": "application/json",
      //"Access-Control-Allow-Origin":"*",  
      //"Access-Control-Allow-Methods": "GET, PUT, POST, DELETE, OPTIONS"}
    //};

  //  const responseObj = fetch('http://localhost:8080/v1/projects/', obj)
  //        .then(function(response){
  //            //Do something with response
  //            console.log(response);
  //        });
    //   fetch('http://51.75.163.237:8080/v1/projects/',{
    //     method: 'GET',
    //     header: {
    //         'Content-Type': 'application/json',
    //         'Authorization': 'dXNlcg==',     
    //   },
    // })
      responseObj.then(response => response.json())
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
    const { error, isLoaded, items, userId, title, body, projects,json } = this.state;
    console.log(json," HERE")
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
            Projects: 
              {projects.map((project, i) => 
                 <li key={i}>
                  <Link to={"/projects/"+i}>
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




