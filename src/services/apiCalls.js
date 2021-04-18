import axios from "axios";

export const setTable = async () => {
  return await axios
    .get(`http://localhost:8080/Summer_Internship_Backend/setTable`)
    .then((res) => {
      return res.data;
    });
};

export const deleteData = async (list) => {
  return await axios({
    method: "get",
    url: `http://localhost:8080/Summer_Internship_Backend/deleteTable`,
    params: {
      serial: list,
    },
  });
};

export const addData = async (addForm, se) => {
  return await axios({
    method: "get",
    url: `http://localhost:8080/Summer_Internship_Backend/addTable`,
    params: {
      serial: se,
      name: addForm.name,
      attendee: addForm.attendee,
      date: addForm.date,
      start: addForm.start,
      end: addForm.end,
    },
  })
    .then(function (response) {
      console.log(response);
    })
    .catch(function (error) {
      console.log(error);
    });
};
