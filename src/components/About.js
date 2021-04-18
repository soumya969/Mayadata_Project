import React from "react";
import Search from "./Search"

export default function About() {
  return (
    <div style={{marginBottom: "4.5rem"}}>
      <div className="heading">About Me</div>
      <div className="toolbar2">
        <div style={{marginLeft:"1rem"}}>
            Name: Soumya Prakash Nayak<br/>
            Roll: 1829104<br/>
            Github profile: <a href="https://github.com/soumya969">https://github.com/soumya969</a><br/>
            Skills: Javascript, React, HTML, CSS, etc.
            <br/><br/>
            Projects:
            <br/><br/>
            1. My porfolio/personal website: <br/><span >I had made my personal website using html, css and Javascript.  The portfolio contains all the details about me and also one can contact with us. It also displays which field i have been working and also show my teammates with whom am i working</span><br/>
            2. Frontend project on E-commerce website<br/>
            3. Frontend project on Food website<br/>
            4. Full stack website on "Hiddens of Odisha"<br/>
        </div>
      </div>
    </div>
  );
}