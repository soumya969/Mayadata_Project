import React from "react";
import Search from "./Search";
import Table from "./Table";

export default function Home() {
  return (
    <div>
      <div className="heading">My Meetings</div>
      <div className="toolbar">
        <Search />
      </div>
      <div className="tableMain">
        <Table />
      </div>
    </div>
  );
}
