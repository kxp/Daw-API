import React, { Component } from 'react';
import { Link, Switch, Route} from 'react-router-dom'
import logo from './logo.svg'
import Login from './components/Login'
import Admin from './components/Admin'
import Logout from './components/Logout'
import Projects from './components/Projects';




//if you remove exact in the route you can acces a path like this http://localhost:3000/b/asda
function App() {
  return (
    <Switch>
      <Route exact path="/" component={Login} /> 
      <Route exact path="/admin" component={Admin} />
      <Route exact path="/logout" component={Logout} />
      <Route exact path="/b" component={B} />
      <Route path="/projects" component={Projects} />
    </Switch>
  );
}



const A = () => {
  return (
    <div>
      <h1> This is component A page</h1>
      <Link to="/b"> B component</Link>
    </div>
  )
}

const B = () => {
    return (
      <div className="App">
      Hello!
        </div>
    );
  }



export default App;
