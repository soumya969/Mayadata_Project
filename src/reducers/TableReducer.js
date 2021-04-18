const initialValue = {
  tableData: [],
};

const TableReducer = (state = initialValue, action) => {
  switch (action.type) {
    case "TableSet":
      return {
        ...state,
        tableData: [...state.tableData, ...action.data],
      };

    default:
      return state;
  }
};
export default TableReducer;
