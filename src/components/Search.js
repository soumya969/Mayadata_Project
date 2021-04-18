import React from "react";
import search from "../icons/search.svg";

export default function Search() {
  return (
    <div
      style={{
        display: "flex",
        justifyContent: "left",
        paddingTop: "4.188rem",
        paddingLeft: "1rem",
      }}
    >
      <div className="searchText">
        <span>
          <img src={search} style={{ height: "1rem"}} />
        </span>
        <input
          className="inputText"
          type="text"
          style={{ border: "none", borderBottom: "0.063rem solid black" , marginRight:"50px"}}
          placeholder="Search"
        />
      </div>
      <div className="searchStart">
        <span
        >From: </span>
        <input
          type="date"
          style={{ border: "none", borderBottom: "0.063rem solid black", marginRight:"50px" }}
        />
      </div>
      <div className="searchEnd">
        <span
        style={{marginRight:"10px" }}
        >To: 
        </span>
        <input
          type="date"
          style={{ border: "none", borderBottom: "0.063rem solid black", marginRight:"150px" }}
        />
      </div>
    </div>
  );
}
