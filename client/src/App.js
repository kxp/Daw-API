import React, { Component } from 'react';
import { Link, Switch, Route} from 'react-router-dom'
import logo from './logo.svg'
import Login from './components/Login'
import Admin from './components/Admin'
import Logout from './components/Logout'
import Projects from './components/Projects';
import Issues from './components/Issues';
import Issue from './components/Issue';




//if you remove exact in the route you can acces a path like this http://localhost:3000/b/asda
function App() {
  return (
    <Switch>
      <Route exact path="/" component={Login} /> 
      <Route exact path="/admin" component={Admin} />
      <Route exact path="/logout" component={Logout} />
      <Route exact path="/b" component={B} />
      <Route exact path="/projects/:id" component={A} />
      <Route exact path="/projects" component={Projects} />
      <Route exact path="/projects/:id/issues" component={Issues} />
      <Route exact path="/projects/:id/issues/:issues_id" component={Issue} />
    </Switch>
  );
}



const A = ({match}) => {
  return (
    <div>
      <h1>Hello project: {match.params.id}</h1>
      <Link to={"/projects/"+match.params.id+"/issues"}><h1>Click to view the issues of projectid: {match.params.id}</h1></Link>
    </div>
  )
}





const B = () => {
    return (
      <div className="App">
      <Projects>321321</Projects>
      Hello!
        </div>
    );
  }



export default App;
