const initialValue = {
  deleteValue: "",
};

const DeleteReducer = (state = initialValue, action) => {
  switch (action.type) {
    case "DeleteTable":
      return {
        ...state,
        deleteValue: action.data,
      };

    default:
      return state;
  }
};
export default DeleteReducer;
