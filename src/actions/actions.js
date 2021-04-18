export const updateTable = (data) => ({
  type: "TableSet",
  data: data,
});

export const deleteTable = (data) => ({
  type: "DeleteTable",
  data: data,
});
