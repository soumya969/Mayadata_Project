import React from "react";
import home from "../icons/home.svg";
import about from "../icons/about.svg";
import menu from "../icons/menu.png";
import About from "../components/About";
import Home from "./Home";

export default function Content() {
  const [show,setShow]=React.useState(0);
  return (
    <div className="App" style={{ overflow: "hidden" }}>
      <div className="navbar">
      <div className="navbar_full">
      <div className="navbar_header">
        <img src={menu} style={{textAlign:"left"}} />
         <span style={{marginLeft:"1rem"}}>1829104</span>
      </div>
      <div className="navbar_content">
        <div className="navbar_element" onClick={() => setShow(0)} activeStyle={{color:"red"}}>
          <p>
            <span style={{ paddingRight: "0.738rem", paddingLeft: "1.55rem" }}>
              <img src={home} />
            </span>
            Home
          </p>
        </div>
        <div className="navbar_element" onClick={() => setShow(1)} activeStyle={{color:"red"}}>
          <p>
            <span style={{ paddingRight: "0.738rem", paddingLeft: "1.55rem" }}>
              <img src={about} />
            </span>
            About me
          </p>
        </div>
      </div>
    </div>
      </div>
      <div className="main">
      {show===0 && <Home />}
        {show===1 && <About />}
      </div>
    </div>
  );
}
