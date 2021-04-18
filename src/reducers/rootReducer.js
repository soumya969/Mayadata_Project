import { combineReducers } from "redux";
import TableReducer from "./TableReducer";
import DeleteReducer from "./DeleteReducer";

const rootReducer = combineReducers({
  tableData: TableReducer,
  deleteValue: DeleteReducer,
});

export default rootReducer;
